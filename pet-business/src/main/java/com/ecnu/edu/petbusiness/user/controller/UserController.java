package com.ecnu.edu.petbusiness.user.controller;

import com.ecnu.edu.petapibase.user.domain.UserDO;
import com.ecnu.edu.petbusiness.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 13862
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户Controller")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findByUserName")
    @ApiOperation(value = "根据用户名获取用户", httpMethod = "POST")
    public UserDO findByUserName(@RequestParam("userName") String userName) {
        return userService.findByUserName(userName);
    }


}
