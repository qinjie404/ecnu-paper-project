package com.ecnu.edu.petauth.feign.service;

import com.ecnu.edu.petapibase.user.domain.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 13862
 * @description
 * @date 2020/9/30 14:37
 */
@FeignClient(name = "${pet.service.name.pet-business}")
public interface UserRemoteService {


    /**
     * 根据用户名获取用户
     *
     * @param userName
     * @return
     * @author 13862
     * @date 2020/9/30
     **/
    @PostMapping("/user/findByUserName")
    UserDO findByUserName(@RequestParam("userName") String userName);
}
