package com.ecnu.edu.petapibase.service.impl;

import com.ecnu.edu.petapibase.dao.BaseDao;
import com.ecnu.edu.petapibase.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 13862
 */
public class BaseServiceImpl<M extends BaseDao<T>, T> implements BaseService<M, T> {

    @Autowired
    private M baseDao;

    @Override
    public void selectByPrimaryKey(Object id) {
        baseDao.selectByPrimaryKey(id);
    }

}
