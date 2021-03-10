package com.ecnu.edu.petapibase.label.domain;

import com.ecnu.edu.petapibase.base.entity.BaseDataDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EO - 标签大类表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "pet_label")
@ApiModel(value = "LabelDO实体", description = "标签大类表")
public class LabelDO extends BaseDataDO {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签id")
    @Id
    private Integer labelId;

    @ApiModelProperty(value = "标签code")
    private String labelCode;

    @ApiModelProperty(value = "标签名称")
    private String labelName;

    @ApiModelProperty(value = "标签描述")
    private String labelDesc;


}