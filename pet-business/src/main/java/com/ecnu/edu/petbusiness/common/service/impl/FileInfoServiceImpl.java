package com.ecnu.edu.petbusiness.common.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import com.ecnu.edu.petapibase.base.service.impl.BaseServiceImpl;
import com.ecnu.edu.petapibase.common.domain.FileInfoDO;
import com.ecnu.edu.petbusiness.common.dao.FileInfoDao;
import com.ecnu.edu.petbusiness.common.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;


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

    @Value("${file.root-path}")
    private String rootPath;
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private FileInfoDao fileInfoDao;


    @Override
    public int upLoadFile(FileInfoDO fileInfoDO, MultipartFile file) {
        try {
            fileInfoDO.setFileName(file.getOriginalFilename());
            String filePath = getFilePath(file);
            fileInfoDO.setFilePath(filePath);
            fileInfoDO.setStatus(0);
            saveEntity(fileInfoDO);
            return fileInfoDO.getFileId();
        } catch (Exception e) {
            log.error("文件保存失败：" + e);
            return 0;
        }
    }

    @Override
    public int saveEntity(FileInfoDO fileInfoDO) {
        return fileInfoDao.saveEntity(fileInfoDO);

    }

    /**
     * 获取上传路径
     *
     * @param file
     * @return
     */
    private String getFilePath(MultipartFile file) throws IOException {
        String nowStr = DateFormatUtils.format(new Date(), DatePattern.PURE_DATE_PATTERN);
        String dirPath = rootPath + uploadDir + File.separator + nowStr;
        // 创建文件目录
        FileUtil.mkdir(dirPath);
        // 重命名文件名
        String fileName = new String(file.getOriginalFilename().getBytes(), CharsetUtil.UTF_8);
        // 文件名_yyyyMMddHHmmssSSS.文件类型
        String newFileName = StringUtils.substringBeforeLast(fileName, ".") + "_" + DateFormatUtils.format(new Date(), DatePattern.PURE_DATETIME_MS_PATTERN) + "." + StringUtils.substringAfterLast(fileName, ".");
        log.info("上传文件路径:[{}],上传文件名：[{}]", dirPath, newFileName);
        String filePath = dirPath + File.separator + newFileName;
        File destFile = new File(filePath);
        FileCopyUtils.copy(file.getBytes(), destFile);
        return destFile.getPath();
    }
}