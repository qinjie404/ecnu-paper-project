package com.ecnu.edu.petapibase.base;

import lombok.Data;

import java.util.List;

/**
 * 分页vo
 *
 * @author Leo Qin
 */
@Data
public class PageVO<T> {
    private Long totalNum;
    private List<T> list;
}
