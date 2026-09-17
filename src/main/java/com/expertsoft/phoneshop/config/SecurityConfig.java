package com.expertsoft.phoneshop.config;

import com.expertsoft.phoneshop.service.CustomOAuthUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuthUserService customOAuthUserService;

    public SecurityConfig(CustomOAuthUserService customOAuthUserService) {
        this.customOAuthUserService = customOAuthUserService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(auth -> auth
                        .antMatchers("/phones").permitAll()
                        .antMatchers("/phones/*").authenticated()
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .antMatchers("/login").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .oauth2Login(oauth2 ->
                        oauth2
                                .loginPage("/login")
                                .permitAll()
                                .userInfoEndpoint(userInfo ->
                                        userInfo.userService(customOAuthUserService)
                                )
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/phones")
                );

        return http.csrf().disable().build();
    }

}
