package com.ecnu.edu.petuser.controller;

import com.ecnu.edu.petapibase.examplea.domain.UserDO;
import com.ecnu.edu.petuser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 13862
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/list")
    @ApiOperation(value = "获取所有用户",httpMethod = "Get")
    public List<UserDO> getUserList() {
        return userService.getUserList();
    }

}
