package com.walkers.sportslight.config.oauth2;

import com.walkers.sportslight.user.command.domain.model.Authority;
import com.walkers.sportslight.user.command.domain.model.LoginType;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.model.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Getter
@Slf4j
public class OAuthAttributes {

    private String nameAttributeKey; //pk
    private OAuth2UserInfo oauth2UserInfo; // 소셜 타입별 로그인 유저 정보(닉네임, 이메일, 프로필 사진 등등)


    @Builder
    public OAuthAttributes(String nameAttributeKey, OAuth2UserInfo oauth2UserInfo) {
        this.nameAttributeKey = nameAttributeKey;
        this.oauth2UserInfo = oauth2UserInfo;
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .nameAttributeKey(userNameAttributeName)
                .oauth2UserInfo(new KakaoOAuth2UserInfo(attributes))
                .build();
    }

    public static OAuthAttributes of(LoginType loginType, String userNameAttributeName, Map<String, Object> attributes) {
        log.info("loginType:{}", loginType);
        //타 소셜 로그인 서비스 구분도 추가 예정
        return ofKakao(userNameAttributeName, attributes);
    }

    public User toEntity(LoginType loginType, OAuth2UserInfo oauth2UserInfo) {
        return User.builder()
                .userId(oauth2UserInfo.getId())
                .nickname(oauth2UserInfo.getNickname())
//                .imageUrl(oauth2UserInfo.getImageUrl())
                //.role(Role.GUEST)
                .authority(Authority.USER)
                .loginType(loginType)
                .money(0)
                .status(UserStatus.ACTIVE)
                .height(170.0)
                .weight(70.0)
                .build();
    }




}
