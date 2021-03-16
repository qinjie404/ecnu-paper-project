package com.ecnu.edu.petbusiness;

import com.ecnu.edu.petbusiness.util.IpAddressUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class PetBusinessApplicationTests {

    @Test
    void contextLoads() {
        String s = "w fd";
        log.info("isBlank:{}", StringUtils.isBlank(s));
        log.info("isEmpty:{}", StringUtils.isEmpty(s));

    }

    @Test
    void ipAddressUtil() {
        log.info("地址：{}", IpAddressUtil.getNewInstance().getCityInfo("223.104.213.60"));
    }
}
