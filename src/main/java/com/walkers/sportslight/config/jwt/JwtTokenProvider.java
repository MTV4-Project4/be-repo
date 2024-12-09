package com.walkers.sportslight.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Component
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;



    public String encodeBase64SecretKey(String secretKey){
        return Encoders.BASE64.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public Key getKeyFromEncodedBase64SecretKey(String encodedSecretKey){
        byte[] keyBytes = Decoders.BASE64.decode(encodedSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String userId, String nickname, Duration expiredAt) {

        Key key = getKeyFromEncodedBase64SecretKey(
                encodeBase64SecretKey(jwtProperties.getSecretKey())
        );
        Date now = new Date();
        Date accessTokenExpiry = new Date(now.getTime() + expiredAt.toMillis());

        return Jwts.builder()
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(accessTokenExpiry)
                .setSubject(userId)
                .claim("id", userId)
                .claim("nickname", nickname)
                //암호화
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validToken(String token) {
        try{
            Key key = getKeyFromEncodedBase64SecretKey(
                    encodeBase64SecretKey(jwtProperties.getSecretKey()));
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e){
            log.warn("Invalid JWT token: {}", e.getMessage());
            return false;
        }
    }

    public Claims parseClaims(String token) {
        try{
            Key key = getKeyFromEncodedBase64SecretKey(
                    encodeBase64SecretKey(jwtProperties.getSecretKey()));
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e){
            log.warn("expired JWT token: {}", e.getMessage());
            return e.getClaims();
        }
    }

    //JWT 토큰 복호화 -> 인증 정보 확인
    public Authentication getAuthentication(String token) {

        Claims claims = parseClaims(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(
            new SimpleGrantedAuthority("USER")
        );

        UserDetails principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);

    }

    public String getUserIdFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims.get("userId", String.class);
    }

    public String getNicknameFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims.get("nickname", String.class);
    }
}
