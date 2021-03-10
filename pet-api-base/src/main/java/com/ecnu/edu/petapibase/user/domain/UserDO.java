package com.ecnu.edu.petapibase.user.domain;

import com.ecnu.edu.petapibase.base.entity.BaseDataDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 13862
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "pet_user")
@ApiModel(value = "UserDO实体", description = "用户表")
public class UserDO extends BaseDataDO {

    private static final long serialVersionUID = 4826344082186156181L;
    @ApiModelProperty(value = "主键")
    @Id
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String mobilePhone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private Integer iconId;

}
