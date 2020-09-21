package com.ecnu.edu.petapibase.service;

import java.util.List;

/**
 * @author 13862
 */
public interface BaseService<T> {

    /**
     * 根据主键获取对象
     *
     * @param id 主键
     */
    T selectByPrimaryKey(Object id);

    /**
     * 根据实体对象(不为空的字段)查询对象
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);

    /**
     * 查询所有对象
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 根据实体对象(不为空的字段)查询对象列表
     *
     * @param entity
     * @return
     */
    List<T> select(T entity);

    /**
     * 根据实体对象(不为空的字段)查询对象个数
     *
     * @param entity
     * @return
     */
    int selectCount(T entity);

    /**
     * 插入一个对象，null值不会插入，会使用数据库默认值
     *
     * @param entity
     * @return
     */
    int insertSelective(T entity);

    /**
     * 根据主键更新不为null的字段
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKeySelective(T entity);

    /**
     * 根据主键刪除数据
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Object id);

    /**
     * 插入数据返回数据主键，null值也会插入，不会使用数据库默认值
     *
     * @param entity
     * @return
     */
    int insertUseGeneratedKeys(T entity);

    /**
     * 批量插入数据，null值也会插入，不会使用数据库默认值
     *
     * @param entityList
     * @return
     */
    int insertList(List<T> entityList);

}
