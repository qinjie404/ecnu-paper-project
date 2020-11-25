package com.ecnu.edu.petapibase.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库表通用字段
 *
 * @author 13862
 */
@Data
public class BaseDataDO implements Serializable {
    private static final long serialVersionUID = 2753718529880101957L;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty(value = "创建人id")
    private Integer createId;
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @ApiModelProperty(value = "更新人id")
    private Integer updateId;
}
