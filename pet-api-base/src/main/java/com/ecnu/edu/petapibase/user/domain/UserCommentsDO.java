package com.ecnu.edu.petapibase.user.domain;

import com.ecnu.edu.petapibase.base.entity.BaseDataDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;

/**
* EO - 评论表
* ============================================================================
* 版权所有 2020 。
*
* @author qinjie
* @version 1.0 2020-11-25
* ============================================================================
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "pet_user_comments")
@ApiModel(value = "UserCommentsDO实体",description = "评论表")
public class UserCommentsDO extends BaseDataDO {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @Id
    private Integer commentId;

    @ApiModelProperty(value = "笔记id")
    private Integer noteId;

    @ApiModelProperty(value = "上级id")
    private Integer parentId;

    @ApiModelProperty(value = "评论内容")
    private String content;


}