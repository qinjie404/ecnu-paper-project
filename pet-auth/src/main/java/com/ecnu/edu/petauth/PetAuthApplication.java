package com.ecnu.edu.petauth;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.ecnu.edu.petauth")
@EnableFeignClients(basePackages = "com.ecnu.edu.petauth.feign.service")
@MapperScan(basePackages = "com.ecnu.edu.petauth.dao")
@EnableSwagger2Doc
public class PetAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetAuthApplication.class, args);
    }

}
