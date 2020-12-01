package com.ecnu.edu.petbusiness.common.controller;

import com.ecnu.edu.petapibase.base.entity.CommonRes;
import com.ecnu.edu.petapibase.common.domain.FileInfoDO;
import com.ecnu.edu.petbusiness.common.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.omg.CORBA.COMM_FAILURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * Controller - 文件表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileInfoController {

    public static final String[] fileType = {"bmp", "png", "gif", "jpg", "jpeg"};
    public static final String PARAM_TARGET_ID = "targetId";
    public static final String PARAM_TARGET_TYPE = "targetType";

    @Autowired
    private FileInfoService fileInfoService;

    @PostMapping("/upload")
    public CommonRes upload(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Integer targetId = null;
        String targetType = null;
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            if (StringUtils.equalsIgnoreCase(PARAM_TARGET_ID, key)) {
                targetId = NumberUtils.toInt(entry.getValue()[0]);
            } else if (StringUtils.equalsIgnoreCase(PARAM_TARGET_TYPE, key)) {
                targetType = entry.getValue()[0];
            }
        }
        if (StringUtils.isBlank(targetType)) {
            return CommonRes.getCommonRes(CommonRes.FAIL_STATUS, "目标类型不能为空");
        }
        log.info("targetId:[{}],targetType:[{}]", targetId, targetType);
        //
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        return null;
    }

    @PostMapping("/selectById")
    public CommonRes<List<FileInfoDO>> selectById() {
        List<FileInfoDO> fileInfoDO = fileInfoService.selectAll();
        return CommonRes.getCommonRes(CommonRes.SUCCESS_STATUS, fileInfoDO);

    }
}