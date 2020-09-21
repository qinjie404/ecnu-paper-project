package com.ecnu.edu.petuser;

import com.ecnu.edu.petapibase.entity.petuser.domain.UserDO;
import com.ecnu.edu.petuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class PetUserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<UserDO> userDOList = new ArrayList<>();
        UserDO userDO=new UserDO();
        userDO.setUserName("44");
        userDO.setCreateTime(new Date());
        int i=userService.insertSelective(userDO);
        log.info("userDo:{}", userDO.getUserId());
    }

}
