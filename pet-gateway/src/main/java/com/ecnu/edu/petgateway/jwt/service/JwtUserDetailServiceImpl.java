package com.ecnu.edu.petgateway.jwt.service;

import com.ecnu.edu.petapibase.user.domain.UserDO;
import com.ecnu.edu.petgateway.service.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 13862
 * @description
 * @date 2020/12/17 14:17
 */
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRemoteService userRemoteService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDO userDO = userRemoteService.findByUserName(s);
        return User.builder().username(s).password(userDO.getPassword()).roles("ROLE_USER").build();
    }
}
