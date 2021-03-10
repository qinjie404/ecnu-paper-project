package com.ecnu.edu.petbusiness.common.service;


import com.ecnu.edu.petapibase.base.service.BaseService;
import com.ecnu.edu.petapibase.common.domain.FileInfoDO;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service - 文件表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
public interface FileInfoService extends BaseService<FileInfoDO> {


    /**
     * 上传文件
     *
     * @param fileInfoDO
     * @param file
     * @return
     */
    int upLoadFile(FileInfoDO fileInfoDO, MultipartFile file);

    /**
     * 保存对象
     *
     * @param fileInfoDO
     * @return
     */
    int saveEntity(FileInfoDO fileInfoDO);
}