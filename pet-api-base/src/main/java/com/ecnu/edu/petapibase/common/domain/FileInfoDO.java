package com.ecnu.edu.petapibase.common.domain;

import com.ecnu.edu.petapibase.base.entity.BaseDataDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EO - 文件表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "pet_file_info")
@ApiModel(value = "FileInfoDO实体", description = "文件表")
public class FileInfoDO extends BaseDataDO {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件id")
    @Id
    private Integer fileId;

    @ApiModelProperty(value = "目标id")
    private Integer targetId;

    @ApiModelProperty(value = "目标类型")
    private String targetType;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "文件地址")
    private String filePath;


}