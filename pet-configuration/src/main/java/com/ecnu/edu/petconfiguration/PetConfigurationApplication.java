package com.ecnu.edu.petconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PetConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetConfigurationApplication.class, args);
    }

}
