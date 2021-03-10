package com.ecnu.edu.petapibase.label.domain;

import com.ecnu.edu.petapibase.base.entity.BaseDataDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * EO - 表现子类表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "pet_label_item")
@ApiModel(value = "LabelItemDO实体", description = "表现子类表")
public class LabelItemDO extends BaseDataDO {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签子项id")
    private Integer labelItemId;

    @ApiModelProperty(value = "标签id")
    private Integer labelId;

    @ApiModelProperty(value = "父标签项id")
    private Integer parentItemId;

    @ApiModelProperty(value = "标签项code")
    private String labelItemCode;

    @ApiModelProperty(value = "标签项名称")
    private String labelItemName;

    @ApiModelProperty(value = "标签项层级")
    private String treeProp;


}