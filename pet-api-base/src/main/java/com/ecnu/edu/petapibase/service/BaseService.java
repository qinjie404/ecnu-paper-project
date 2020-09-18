package com.ecnu.edu.petapibase.service;

import com.ecnu.edu.petapibase.dao.BaseDao;

/**
 * @author 13862
 */
public interface BaseService<M extends BaseDao<T>, T> {

    /**
     * 根据主键获取对象
     *
     * @param id 主键
     */
    void selectByPrimaryKey(Object id);
}
