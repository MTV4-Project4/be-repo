package com.walkers.sportslight.config.oauth2;

import com.walkers.sportslight.user.command.domain.model.Authority;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
public class CustomOAuth2User extends DefaultOAuth2User {

    private String userId;
    private Authority authority;

    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes, String nameAttributeKey
    , String userId, Authority authority) {
        super(authorities, attributes, nameAttributeKey);
        this.userId = userId;
        this.authority = authority;
    }
}
