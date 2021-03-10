package com.ecnu.edu.petapibase.base.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页vo
 *
 * @author Leo Qin
 */
@Data
public class PageVO<T> {
    @ApiModelProperty(value = "总条数")
    private Long totalNum;
    @ApiModelProperty(value = "总页数")
    private Integer totalPage;
    @ApiModelProperty(value = "列表")
    private List<T> list;
}
