package com.ecnu.edu.petuser.service;

import com.ecnu.edu.petapibase.entity.base.vo.PageVO;
import com.ecnu.edu.petapibase.entity.petuser.domain.UserDO;
import com.ecnu.edu.petapibase.entity.petuser.query.UserQuery;

import java.util.List;

/**
 * @author 13862
 */
public interface UserService {
    List<UserDO> getUserList();

    PageVO<UserDO> getUserListByPage(UserQuery query);
}
