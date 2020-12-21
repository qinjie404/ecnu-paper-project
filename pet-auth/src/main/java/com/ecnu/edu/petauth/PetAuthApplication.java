package com.ecnu.edu.petauth;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 13862
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.ecnu.edu.petauth.service")
@EnableSwagger2Doc
public class PetAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetAuthApplication.class, args);
    }

}
