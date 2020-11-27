package com.ecnu.edu.petbusiness.user.controller;

import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.common.query.PageQuery;
import com.ecnu.edu.petapibase.user.domain.UserDO;
import com.ecnu.edu.petbusiness.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/listByPage")
    @ApiOperation(value = "获取所有用户分页",httpMethod = "POST")
    public PageVO<UserDO> getUserListByPage(@RequestBody PageQuery query) {
        return userService.getUserListByPage(query);
    }


}
