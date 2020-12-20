package com.ecnu.edu.petgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * gateway
 *
 * @author Leo Qin
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.ecnu.edu.petgateway.service")
@EnableZuulProxy
public class PetGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetGatewayApplication.class, args);
    }

}
