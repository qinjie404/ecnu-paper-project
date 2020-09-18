package com.ecnu.edu.petapibase.entity.petuser.domain;

import com.ecnu.edu.petapibase.entity.base.domain.BaseDataDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 13862
 */
@Data
@Table(name = "pet_user")
public class UserDO extends BaseDataDO {

    private static final long serialVersionUID = 4826344082186156181L;
    @Id
    @ApiModelProperty(value = "主键id")
    private Integer userId;
    @ApiModelProperty(value = "名字")
    private String userName;

}
