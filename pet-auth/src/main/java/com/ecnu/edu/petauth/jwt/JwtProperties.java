package com.ecnu.edu.petauth.jwt;

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


}
