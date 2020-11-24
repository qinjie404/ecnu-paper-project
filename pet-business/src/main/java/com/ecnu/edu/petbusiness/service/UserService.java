package com.ecnu.edu.petbusiness.service;

import com.ecnu.edu.petapibase.entity.base.vo.PageVO;
import com.ecnu.edu.petapibase.entity.petuser.domain.UserDO;
import com.ecnu.edu.petapibase.entity.petuser.query.UserQuery;
import com.ecnu.edu.petapibase.service.BaseService;

import java.util.List;

/**
 * @author 13862
 */
public interface UserService extends BaseService<UserDO> {
    List<UserDO> getUserList();

    PageVO<UserDO> getUserListByPage(UserQuery query);

    UserDO selectById(int userId);
}
