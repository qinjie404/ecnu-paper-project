package com.ecnu.edu.petexamplea.service.impl;

import com.ecnu.edu.petapibase.examplea.domain.UserDO;
import com.ecnu.edu.petexamplea.dao.UserDao;
import com.ecnu.edu.petexamplea.service.UserService;
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
}
