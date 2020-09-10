package com.ecnu.edu.petregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Registry
 *
 * @author Leo Qin
 */
@SpringBootApplication
@EnableEurekaServer
public class PetRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetRegistryApplication.class, args);
    }

}
