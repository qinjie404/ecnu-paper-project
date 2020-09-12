package com.ecnu.edu.petuser.controller;

import com.ecnu.edu.petapibase.base.PageVO;
import com.ecnu.edu.petapibase.petuser.domain.UserDO;
import com.ecnu.edu.petapibase.petuser.query.UserQuery;
import com.ecnu.edu.petuser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/list")
    @ApiOperation(value = "获取所有用户",httpMethod = "POST")
    public List<UserDO> getUserList() {
        return userService.getUserList();
    }

    @PostMapping("/listByPage")
    @ApiOperation(value = "获取所有用户",httpMethod = "POST")
    public PageVO<UserDO> getUserListByPage(@RequestBody UserQuery query) {
        return userService.getUserListByPage(query);
    }

}
