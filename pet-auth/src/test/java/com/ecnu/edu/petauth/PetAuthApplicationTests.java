package com.ecnu.edu.petauth;

import com.ecnu.edu.petauth.feign.service.UserRemoteService;
import com.ecnu.edu.petauth.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
class PetAuthApplicationTests {

    private String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJsZW9xaW4iLCJzdWIiOiJxaW5qaWUiLCJpYXQiOjE2MDgwMjE2OTIsImV4cCI6MTYwODAyMzQ5Mn0.TVT3ECiazjuwmxZK4JWFtUlxlmQToRj0NG19_FxyBQw";

    @Autowired
    private UserRemoteService remoteService;
    @Autowired
    private JwtUtil jwtUtil;
    @Test
    void testJwtCreate() {
        String token = jwtUtil.createJwtToken("qinjie", false);
        log.info("token:{}",token);
    }

    @Test
    void testJwtParse() {
        Claims claims = jwtUtil.parseToken(token);
        log.info("token:{}",claims);
    }

    @Test
    void testGetUserName() {
        String userName = jwtUtil.getUserName(token);
        log.info("userName:{}",userName);
    }
    @Test
    void testIsExpiration() {
        boolean isExpiration = jwtUtil.isExpiration(token);
        log.info("isExpiration:{}",isExpiration);
    }

    @Test
    void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        log.info("isExpiration:{}",bCryptPasswordEncoder.encode("123"));
    }
}
