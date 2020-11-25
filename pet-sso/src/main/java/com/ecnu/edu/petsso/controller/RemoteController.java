package com.ecnu.edu.petsso.controller;

import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.user.domain.UserDO;
import com.ecnu.edu.petapibase.user.query.UserQuery;
import com.ecnu.edu.petsso.service.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 13862
 * @description
 * @date 2020/11/24 19:46
 */

@RestController
@RequestMapping("/remote")
public class RemoteController {
    @Autowired
    private UserRemoteService userRemoteService;

    @PostMapping(path = "/call2b")
    public PageVO<UserDO> sayHello2B(@RequestBody UserQuery query) {
        return userRemoteService.getUserListByPage(query);
    }

}
