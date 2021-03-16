package com.ecnu.edu.petbusiness;

import com.ecnu.edu.petapibase.base.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 13862
 * @description
 * @date 2020/12/30 16:31
 */
@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void hsetTest() {
        redisUtil.hset("qinjie", "1", 1);
        redisUtil.hset("qinjie", "2", 2);
    }
    @Test
    void hmsetTest() {
        Map<String,Object> map=new HashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        redisUtil.hmset("qq", map,60);

    }

    @Test
    void hgetTest() {
       log.info("hget:{}",redisUtil.hget("qinjie","1"));
       log.info("hmget:{}",redisUtil.hmget("qinjie"));
    }
}
