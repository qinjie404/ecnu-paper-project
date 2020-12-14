package com.ecnu.edu.petbusiness.user.controller;

import com.ecnu.edu.petapibase.base.entity.CommonRes;
import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.user.query.CommunityNotesQuery;
import com.ecnu.edu.petapibase.user.vo.CommunityNotesVO;
import com.ecnu.edu.petbusiness.user.service.UserNotesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ecnu.edu.petapibase.base.entity.CommonRes.getCommonRes;


/**
 * Controller - 用户笔记表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
@Slf4j
@RestController
@RequestMapping("/notes")
@Api(value = "用户笔记Controller")
public class UserNotesController {

    @Autowired
    private UserNotesService userNotesService;

    @PostMapping("/userNotes")
    @ApiOperation(value = "获取社区用户笔记", httpMethod = "POST")
    public CommonRes<PageVO<CommunityNotesVO>> getUserNotes(@RequestBody CommunityNotesQuery query) {
        try {
            PageVO<CommunityNotesVO> pageVO = userNotesService.getUserNotes(query);
            return getCommonRes(CommonRes.SUCCESS_STATUS, pageVO);
        } catch (Exception e) {
            log.error("获取社区用户笔记接口异常：" , e);
            return getCommonRes(CommonRes.FAIL_STATUS, "获取社区用户笔记接口异常");
        }
    }
}