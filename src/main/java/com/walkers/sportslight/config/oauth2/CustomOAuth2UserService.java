package com.walkers.sportslight.config.oauth2;

import com.walkers.sportslight.user.command.application.service.UserService;
import com.walkers.sportslight.user.command.domain.model.LoginType;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import com.walkers.sportslight.userReward.command.domain.aggregate.UserReward;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("execute CustomOAuth2UserService.loadUser() - OAuth2 Login Request start");


        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);


        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        LoginType loginType = getLoginType(registrationId);

        //OAuth2 로그인시 PK
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();


        //소셜 로그인 시 API 제공하는 userInfo의 Json
        Map<String, Object> attributes = oAuth2User.getAttributes();

        //return null;
        OAuthAttributes extractAttributes = OAuthAttributes.of(loginType, userNameAttributeName, attributes);

        User createdUser = getUser(extractAttributes, loginType);

        return new CustomOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(createdUser.getAuthority().getKey())),
                attributes,
                extractAttributes.getNameAttributeKey(),
                createdUser.getUserId(),
                createdUser.getAuthority()
        );

    }

    private User getUser(OAuthAttributes extractAttributes, LoginType loginType) {

        log.info("oauth2UserInfo:{}", extractAttributes.getOauth2UserInfo());
        log.info("id:{}", extractAttributes.getOauth2UserInfo().getId());




        String userId = extractAttributes.getOauth2UserInfo().getId();

        Optional<User> user = userRepository.findByUserId(userId);

        return user.orElseGet(() -> saveUser(extractAttributes, loginType));
    }

    private User saveUser(OAuthAttributes extractAttributes, LoginType loginType) {
        User createdUSer = extractAttributes.toEntity(loginType, extractAttributes.getOauth2UserInfo());
        return userRepository.save(createdUSer);
    }

    private LoginType getLoginType(String registrationId) {
        return LoginType.KAKAO;
    }
}
