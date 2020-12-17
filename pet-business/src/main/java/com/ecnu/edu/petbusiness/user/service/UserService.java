package com.ecnu.edu.petbusiness.user.service;

import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.base.service.BaseService;
import com.ecnu.edu.petapibase.common.query.PageQuery;
import com.ecnu.edu.petapibase.user.domain.UserDO;

import java.util.List;

/**
 * @author 13862
 */
public interface UserService extends BaseService<UserDO> {
    List<UserDO> getUserList();

    PageVO<UserDO> getUserListByPage(PageQuery query);

    UserDO findByUserName(String userName);
}
