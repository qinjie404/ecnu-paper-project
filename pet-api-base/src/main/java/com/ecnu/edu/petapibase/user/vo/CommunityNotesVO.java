package com.ecnu.edu.petapibase.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 13862
 * @description 社区首页笔记vo
 * @date 2020/11/26 22:24
 */
@Data
public class CommunityNotesVO implements Serializable {
    private static final long serialVersionUID = -2002192837957354780L;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("笔记id")
    private Integer noteId;
    @ApiModelProperty("笔记图片id")
    private Integer fileId;
    @ApiModelProperty("头像id")
    private Integer headImageId;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("点赞数")
    private Integer thumbsUpNumber;
}
