package com.jiangtf.demo.dao;

import com.jiangtf.demo.config.database.BaseMapper;
import com.jiangtf.demo.entity.TradeDeails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradeDeailsMapper extends BaseMapper<TradeDeails> {

    int updateStatusById(@Param("id") String id);

    List<TradeDeails> queryByNotSync(@Param("list") List<String> list);
}