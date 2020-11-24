package com.ecnu.edu.petbusiness;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 13862
 */
@SpringBootApplication(scanBasePackages = "com.ecnu.edu.petbusiness")
@EnableFeignClients(basePackages = "com.ecnu.edu.petbusiness.service")
@MapperScan(basePackages = "com.ecnu.edu.petbusiness.dao")
@EnableSwagger2Doc
public class PetBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetBusinessApplication.class, args);
    }

}
