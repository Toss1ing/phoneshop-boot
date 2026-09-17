package com.expertsoft.phoneshop.config;

import com.expertsoft.phoneshop.config.properties.AdminProperties;
import com.expertsoft.phoneshop.persistence.model.User;
import com.expertsoft.phoneshop.persistence.model.enums.Role;
import com.expertsoft.phoneshop.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    private final PasswordEncoder passwordEncoder;
    private final AdminProperties adminProperties;

    public DataInitializer(
            PasswordEncoder passwordEncoder,
            AdminProperties adminProperties
    ) {
        this.passwordEncoder = passwordEncoder;
        this.adminProperties = adminProperties;
    }

    @Bean
    public CommandLineRunner createAdmin(UserRepository userRepository) {
        return args -> {
            User admin = new User(
                    adminProperties.getLogin(),
                    passwordEncoder.encode(adminProperties.getPassword()),
                    Role.ADMIN
            );
            userRepository.save(admin);
        };
    }

}
