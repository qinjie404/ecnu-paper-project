package com.ecnu.edu.petuser.service.impl;

import com.ecnu.edu.petapibase.base.PageVO;
import com.ecnu.edu.petapibase.petuser.domain.UserDO;
import com.ecnu.edu.petapibase.petuser.query.UserQuery;
import com.ecnu.edu.petuser.dao.UserDao;
import com.ecnu.edu.petuser.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 13862
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDO> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public PageVO<UserDO> getUserListByPage(UserQuery query) {
        Page<UserDO> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<UserDO> userDOS = getUserList();
        PageVO<UserDO> pageVO = new PageVO<>();
        pageVO.setList(userDOS);
        pageVO.setTotalNum(page.getTotal());
        return pageVO;
    }
}
