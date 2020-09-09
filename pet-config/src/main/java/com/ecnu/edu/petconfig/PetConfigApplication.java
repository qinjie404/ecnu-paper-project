package com.ecnu.edu.petconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * config
 *
 * @author Leo Qin
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableConfigServer
public class PetConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetConfigApplication.class, args);
    }

}
