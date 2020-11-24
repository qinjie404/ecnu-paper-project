package com.ecnu.edu.petsso.service;

import com.ecnu.edu.petapibase.entity.base.vo.PageVO;
import com.ecnu.edu.petapibase.entity.petuser.domain.UserDO;
import com.ecnu.edu.petapibase.entity.petuser.query.UserQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 13862
 * @description
 * @date 2020/9/30 14:37
 */
@FeignClient(name = "${pet.service.name.pet-business}")
public interface UserRemoteService {


    /**
     * 获取用户列表
     *
     * @param query
     * @return
     * @author 13862
     * @date 2020/9/30
     **/
    @PostMapping("/user/listByPage")
    PageVO<UserDO> getUserListByPage(@RequestBody UserQuery query);
}
