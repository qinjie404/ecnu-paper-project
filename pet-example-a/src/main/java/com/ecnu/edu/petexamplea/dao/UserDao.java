package com.ecnu.edu.petexamplea.dao;

import com.ecnu.edu.petapibase.examplea.domain.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 13862
 */
@Repository
public interface UserDao {

    List<UserDO> getUserList();
}
