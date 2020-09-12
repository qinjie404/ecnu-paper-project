package com.ecnu.edu.petuser.service;

import com.ecnu.edu.petapibase.base.PageVO;
import com.ecnu.edu.petapibase.petuser.domain.UserDO;
import com.ecnu.edu.petapibase.petuser.query.UserQuery;

import java.util.List;

/**
 * @author 13862
 */
public interface UserService {
    List<UserDO> getUserList();

    PageVO<UserDO> getUserListByPage(UserQuery query);
}
