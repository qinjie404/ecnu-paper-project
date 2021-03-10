package com.ecnu.edu.petbusiness.user.dao;

import com.ecnu.edu.petapibase.base.dao.BaseDao;
import com.ecnu.edu.petapibase.user.domain.UserNotesDO;
import com.ecnu.edu.petapibase.user.query.CommunityNotesQuery;
import com.ecnu.edu.petapibase.user.vo.CommunityNotesVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper - 用户笔记表
 * ============================================================================
 * 版权所有 2020 。
 *
 * @author qinjie
 * @version 1.0 2020-11-26
 * ============================================================================
 */
@Repository
public interface UserNotesDao extends BaseDao<UserNotesDO> {

    /**
     * 获取社区用户笔记
     *
     * @param query
     * @return
     */
    List<CommunityNotesVO> queryUserNotes(CommunityNotesQuery query);
}