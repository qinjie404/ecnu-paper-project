package com.ecnu.edu.petauth.jwt.util;

import com.ecnu.edu.petauth.jwt.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt工具类
 *
 * @author 13862
 * @description
 * @date 2020/12/14 16:34
 */
@Slf4j
@Component
public class JwtUtil {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 生成token
     *
     * @param userName
     * @param rememberMe
     * @return
     */
    public String createJwtToken(String userName, boolean rememberMe) {
        long expiration = rememberMe ? jwtProperties.getExpirationRemember() : jwtProperties.getExpiration();
        Date date = new Date();
        Map<String, Object> headerMap = new HashMap<>(4);
        // 设置token类型
        headerMap.put("typ", "JWT");
        String token = Jwts.builder().setIssuer(jwtProperties.getIssuer())
                .setHeader(headerMap)
                .setId(jwtProperties.getId())
                .setSubject(userName)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + expiration))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
            return body;
        } catch (ExpiredJwtException e) {
            log.error("token已过期", e);
            return null;
        }
    }

    /**
     * 从token中获取用户名
     *
     * @param token
     * @return
     */
    public String getUserName(String token) {
        Claims body = parseToken(token);
        if (body != null) {
            return body.getSubject();
        }
        return null;
    }

    /**
     * 判断token是否过期
     *
     * @param token
     * @return
     */
    public Boolean isExpiration(String token) {
        Claims body = parseToken(token);
        if (body != null) {
            return body.getExpiration().before(new Date());
        }
        return true;
    }
}
