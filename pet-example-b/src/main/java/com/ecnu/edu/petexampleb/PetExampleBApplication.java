package com.ecnu.edu.petexampleb;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * example-b
 *
 * @author Leo Qin
 */
@SpringBootApplication
@EnableSwagger2Doc
public class PetExampleBApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetExampleBApplication.class, args);
    }

}
