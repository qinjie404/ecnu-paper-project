package com.ecnu.edu.petauth.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * jwt配置类
 *
 * @author 13862
 * @description
 * @date 2020/12/14 16:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * 签发者
     */
    private String issuer;
    /**
     * 过期时间(ms)
     */
    private Long expiration;
    /**
     * 记住我过期时间(ms)
     */
    private Long expirationRemember;
    /**
     * 盐
     */
    private String secret;
    /**
     * jwt id
     */
    private String id;

}
