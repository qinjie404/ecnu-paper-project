package com.ecnu.edu.petgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * gateway
 *
 * @author Leo Qin
 */
@SpringBootApplication
@EnableZuulProxy
public class PetGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetGatewayApplication.class, args);
    }

}
