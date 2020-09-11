package com.ecnu.edu.petuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * user
 *
 * @author Leo Qin
 */
@SpringBootApplication(scanBasePackages = "com.ecnu.edu.petuser")
@EnableFeignClients(basePackages = "com.ecnu.edu.petuser.service")
@MapperScan(basePackages = "com.ecnu.edu.petuser.dao")
public class PetUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetUserApplication.class, args);
    }

}
