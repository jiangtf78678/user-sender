package com.jiangtf.demo.dao;

import com.jiangtf.demo.entity.ExtryLeaveUser;

public interface ExtryLeaveUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExtryLeaveUser record);

    int insertSelective(ExtryLeaveUser record);

    ExtryLeaveUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExtryLeaveUser record);

    int updateByPrimaryKey(ExtryLeaveUser record);
}