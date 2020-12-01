package com.ecnu.edu.petsso;

import com.ecnu.edu.petsso.service.UserRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class PetSsoApplicationTests {

    @Autowired
    private UserRemoteService remoteService;
    @Test
    void contextLoads() {
    }

}
