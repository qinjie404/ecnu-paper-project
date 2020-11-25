package com.ecnu.edu.petapibase.base.service.impl;

import com.ecnu.edu.petapibase.base.dao.BaseDao;
import com.ecnu.edu.petapibase.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 13862
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public T selectByPrimaryKey(Object id) {
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public T selectOne(T entity) {
        return baseDao.selectOne(entity);
    }

    @Override
    public List<T> selectAll() {
        return baseDao.selectAll();
    }

    @Override
    public List<T> select(T entity) {
        return baseDao.select(entity);
    }

    @Override
    public int selectCount(T entity) {
        return baseDao.selectCount(entity);
    }

    @Override
    public int insertSelective(T entity) {
        return baseDao.insertSelective(entity);
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return baseDao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int deleteByPrimaryKey(Object id) {
        return baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertUseGeneratedKeys(T entity) {
        return baseDao.insertUseGeneratedKeys(entity);
    }

    @Override
    public int insertList(List<T> entityList) {
        return baseDao.insertList(entityList);
    }
}
