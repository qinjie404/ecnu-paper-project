package com.ecnu.edu.petapibase.user.domain;

import com.ecnu.edu.petapibase.base.entity.BaseDataDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;

/**
* EO - 用户笔记表
* ============================================================================
* 版权所有 2020 。
*
* @author qinjie
* @version 1.0 2020-11-26
* ============================================================================
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "pet_user_notes")
@ApiModel(value = "UserNotesDO实体",description = "用户笔记表")
public class UserNotesDO extends BaseDataDO {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @Id
    private Integer noteId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "点赞数")
    private Integer thumbsUpNumber;

    @ApiModelProperty(value = "收藏数")
    private Integer collectionNumber;


}