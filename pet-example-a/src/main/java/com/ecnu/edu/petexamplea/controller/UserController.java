package com.ecnu.edu.petexamplea.controller;

import com.ecnu.edu.petapibase.examplea.domain.UserDO;
import com.ecnu.edu.petexamplea.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public List<UserDO> getUserList() {
        return userService.getUserList();
    }

}
