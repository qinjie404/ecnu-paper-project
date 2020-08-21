package com.ecnu.edu.petconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * config
 *
 * @author Leo Qin
 */
@SpringBootApplication
@EnableConfigServer
public class PetConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetConfigApplication.class, args);
    }

}
