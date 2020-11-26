package com.ecnu.edu.petbusiness.user.controller;

import com.ecnu.edu.petapibase.base.entity.CommonRes;
import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.user.domain.UserDO;
import com.ecnu.edu.petapibase.user.query.UserQuery;
import com.ecnu.edu.petbusiness.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 13862
 */
@Slf4j
@RestController
@RequestMapping("/mappers/user")
@Api(value = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/list")
    @ApiOperation(value = "获取所有用户",httpMethod = "POST")
    public CommonRes getUserList() {
        try{
            List<UserDO> userList = userService.getUserList();
            return CommonRes.getCommonRes(CommonRes.SUCCESS_STATUS,userList);
        }catch (Exception e){
            return CommonRes.getCommonRes(CommonRes.FAIL_STATUS, "获取所有用户接口调用失败");
        }
    }

    @PostMapping("/listByPage")
    @ApiOperation(value = "获取所有用户",httpMethod = "POST")
    public PageVO<UserDO> getUserListByPage(@RequestBody UserQuery query) {
        return userService.getUserListByPage(query);
    }

    @PostMapping("/selectById")
    @ApiOperation(value = "根据主键获取用户",httpMethod = "POST")
    public UserDO selectById(@RequestParam int userId) {
        return userService.selectById(userId);
    }

}
