package com.ecnu.edu.petbusiness.user.service.impl;

import com.ecnu.edu.petapibase.entity.base.vo.PageVO;
import com.ecnu.edu.petapibase.entity.petuser.domain.UserDO;
import com.ecnu.edu.petapibase.entity.petuser.query.UserQuery;
import com.ecnu.edu.petapibase.service.impl.BaseServiceImpl;
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
    public PageVO<UserDO> getUserListByPage(UserQuery query) {
        Page<UserDO> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<UserDO> userDOS = getUserList();
        PageVO<UserDO> pageVO = new PageVO<>();
        pageVO.setList(userDOS);
        pageVO.setTotalNum(page.getTotal());
        return pageVO;
    }

    @Override
    public UserDO selectById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
