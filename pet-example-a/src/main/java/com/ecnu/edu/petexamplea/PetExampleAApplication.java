package com.ecnu.edu.petexamplea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * example-a
 *
 * @author Leo Qin
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.ecnu.edu.petexamplea.service")
public class PetExampleAApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetExampleAApplication.class, args);
    }

}
