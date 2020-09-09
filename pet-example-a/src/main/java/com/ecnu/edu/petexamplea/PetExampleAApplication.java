package com.ecnu.edu.petexamplea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * example-a
 *
 * @author Leo Qin
 */
@SpringBootApplication(scanBasePackages = "com.ecnu.edu.petexamplea")
@EnableFeignClients(basePackages = "com.ecnu.edu.petexamplea.service")
@MapperScan(basePackages = "com.ecnu.edu.petexamplea.dao")
@EntityScan("com.ecnu.edu.petapibase")
public class PetExampleAApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetExampleAApplication.class, args);
    }

}
