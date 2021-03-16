package com.ecnu.edu.petbusiness.user.service.impl;

import com.ecnu.edu.petapibase.base.entity.PageVO;
import com.ecnu.edu.petapibase.base.service.impl.BaseServiceImpl;
import com.ecnu.edu.petapibase.user.domain.UserNotesDO;
import com.ecnu.edu.petapibase.user.query.CommunityNotesQuery;
import com.ecnu.edu.petapibase.user.vo.CommunityNotesVO;
import com.ecnu.edu.petbusiness.user.dao.UserNotesDao;
import com.ecnu.edu.petbusiness.user.service.UserNotesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
* Service - 用户笔记表
* ============================================================================
* 版权所有 2020 。
*
* @author qinjie
* @version 1.0 2020-11-26
* ============================================================================
*/
@Slf4j
@Service
public class UserNotesServiceImpl extends BaseServiceImpl<UserNotesDO> implements UserNotesService {

    @Autowired
    private UserNotesDao userNotesDao;

    @Override
    public PageVO<CommunityNotesVO> getUserNotes(CommunityNotesQuery query) {
        Page<CommunityNotesVO> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<CommunityNotesVO> notesVOList = userNotesDao.queryUserNotes(query);
        PageVO<CommunityNotesVO> pageVO = new PageVO<>();
        pageVO.setList(notesVOList);
        pageVO.setTotalNum(page.getTotal());
        pageVO.setTotalPage(page.getPages());
        return pageVO;
    }
}