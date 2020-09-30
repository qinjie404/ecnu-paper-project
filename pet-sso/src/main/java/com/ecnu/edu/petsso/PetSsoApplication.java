package com.ecnu.edu.petsso;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.ecnu.edu.petsso")
@EnableFeignClients(basePackages = "com.ecnu.edu.petsso.service")
@MapperScan(basePackages = "com.ecnu.edu.petsso.dao")
@EnableSwagger2Doc
public class PetSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetSsoApplication.class, args);
    }

}
