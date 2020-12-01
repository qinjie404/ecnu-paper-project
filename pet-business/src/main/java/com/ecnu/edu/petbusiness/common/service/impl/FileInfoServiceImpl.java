package com.ecnu.edu.petbusiness.common.service.impl;

import com.ecnu.edu.petapibase.base.service.impl.BaseServiceImpl;
import com.ecnu.edu.petapibase.common.domain.FileInfoDO;
import com.ecnu.edu.petbusiness.common.dao.FileInfoDao;
import com.ecnu.edu.petbusiness.common.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* Service - 文件表
* ============================================================================
* 版权所有 2020 。
*
* @author qinjie
* @version 1.0 2020-11-26
* ============================================================================
*/
@Slf4j
@Service
public class FileInfoServiceImpl extends BaseServiceImpl<FileInfoDO> implements FileInfoService {
    @Autowired
    private FileInfoDao fileInfoDao;


}