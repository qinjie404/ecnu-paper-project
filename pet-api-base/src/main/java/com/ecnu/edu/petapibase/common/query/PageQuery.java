package com.ecnu.edu.petapibase.common.query;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 13862
 * @description 分页查询
 * @date 2020/11/27 13:55
 */
@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = -9194172276423987310L;

    private Integer pageNo = 1;
    private Integer pageSize = 10;
}
