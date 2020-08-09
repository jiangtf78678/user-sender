package com.jiangtf.demo.dao;

import com.jiangtf.demo.entity.ChannelMedisDto;

public interface ChannelMedisDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelMedisDto record);

    int insertSelective(ChannelMedisDto record);

    ChannelMedisDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelMedisDto record);

    int updateByPrimaryKey(ChannelMedisDto record);
}