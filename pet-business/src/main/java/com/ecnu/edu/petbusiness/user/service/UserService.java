package com.ecnu.edu.petbusiness.user.service;

import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.user.domain.UserDO;
import com.ecnu.edu.petapibase.user.query.UserQuery;
import com.ecnu.edu.petapibase.base.service.BaseService;

import java.util.List;

/**
 * @author 13862
 */
public interface UserService extends BaseService<UserDO> {
    List<UserDO> getUserList();

    PageVO<UserDO> getUserListByPage(UserQuery query);

    UserDO selectById(int userId);
}
