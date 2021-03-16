package com.ecnu.edu.petapibase.user.domain;

import com.ecnu.edu.petapibase.base.entity.BaseDataDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;

/**
* EO - 用户关联关系(粉丝)表
* ============================================================================
* 版权所有 2020 。
*
* @author qinjie
* @version 1.0 2020-11-26
* ============================================================================
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "pet_user_rel")
@ApiModel(value = "UserRelDO实体",description = "用户关联关系(粉丝)表")
public class UserRelDO extends BaseDataDO {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @Id
    private Integer userRelId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "用户关联id(粉丝id)")
    private Integer relUserId;


}