package com.ecnu.edu.petbusiness.user.service;


import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.base.service.BaseService;
import com.ecnu.edu.petapibase.user.domain.UserNotesDO;
import com.ecnu.edu.petapibase.user.query.CommunityNotesQuery;
import com.ecnu.edu.petapibase.user.vo.CommunityNotesVO;

/**
 * Service - 用户笔记表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
public interface UserNotesService extends BaseService<UserNotesDO> {

    /**
     * `获取社区用户笔记
     *
     * @param query
     * @return
     */
    PageVO<CommunityNotesVO> getUserNotes(CommunityNotesQuery query);
}