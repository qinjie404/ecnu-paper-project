package com.ecnu.edu.petsso.service;

import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.common.query.PageQuery;
import com.ecnu.edu.petapibase.user.domain.UserDO;
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
    PageVO<UserDO> getUserListByPage(@RequestBody PageQuery query);
}
