package com.ecnu.edu.petbusiness.user.dao;

import com.ecnu.edu.petapibase.base.dao.BaseDao;
import com.ecnu.edu.petapibase.user.domain.UserRelDO;
import org.springframework.stereotype.Repository;

/**
 * Mapper - 用户关联关系(粉丝)表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
@Repository
public interface UserRelDao extends BaseDao<UserRelDO> {

}