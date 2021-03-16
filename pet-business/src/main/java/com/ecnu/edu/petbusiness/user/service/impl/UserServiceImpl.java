package com.ecnu.edu.petbusiness.user.service.impl;

import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.base.service.impl.BaseServiceImpl;
import com.ecnu.edu.petapibase.common.query.PageQuery;
import com.ecnu.edu.petapibase.user.domain.UserDO;
import com.ecnu.edu.petbusiness.user.dao.UserDao;
import com.ecnu.edu.petbusiness.user.service.UserService;
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
public class UserServiceImpl extends BaseServiceImpl<UserDO> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDO> getUserList() {
        return userDao.selectAll();
    }

    @Override
    public PageVO<UserDO> getUserListByPage(PageQuery query) {
        Page<UserDO> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<UserDO> userDOS = getUserList();
        PageVO<UserDO> pageVO = new PageVO<>();
        pageVO.setList(userDOS);
        pageVO.setTotalNum(page.getTotal());
        return pageVO;
    }

    @Override
    public UserDO findByUserName(String userName) {
        UserDO userDO=new UserDO();
        userDO.setUserName(userName);
        userDO.setStatus(1);
        return userDao.selectOne(userDO);
    }
}
