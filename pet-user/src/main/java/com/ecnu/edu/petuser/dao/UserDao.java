package com.ecnu.edu.petuser.dao;

import com.ecnu.edu.petapibase.petuser.domain.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 13862
 */
@Repository
public interface UserDao {

    List<UserDO> getUserList();
}
