package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.persistence.model.User;
import com.expertsoft.phoneshop.persistence.model.enums.Role;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuthUserService extends DefaultOAuth2UserService {

    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String BIO_ATTRIBUTE = "bio";
    private static final String AVATAR_URL_ATTRIBUTE = "avatar_url";
    private static final String LOCATION_ATTRIBUTE = "location";
    private static final String COMPANY_ATTRIBUTE = "company";

    private final UserService userService;

    public CustomOAuthUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) {
        OAuth2User oAuth2User = super.loadUser(request);

        String userLogin = oAuth2User.getAttribute(LOGIN_ATTRIBUTE);

        if(userService.getUserByLogin(userLogin).isEmpty()) {
            User user = new User(
                    userLogin,
                    oAuth2User.getAttribute(NAME_ATTRIBUTE),
                    oAuth2User.getAttribute(BIO_ATTRIBUTE),
                    oAuth2User.getAttribute(AVATAR_URL_ATTRIBUTE),
                    oAuth2User.getAttribute(LOCATION_ATTRIBUTE),
                    oAuth2User.getAttribute(COMPANY_ATTRIBUTE),
                    Role.USER
            );

            userService.createUser(user);
        }

        return oAuth2User;
    }
}
