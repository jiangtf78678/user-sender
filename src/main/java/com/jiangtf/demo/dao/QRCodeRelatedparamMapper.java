package com.jiangtf.demo.dao;

import com.jiangtf.demo.entity.QRCodeRelatedparam;

public interface QRCodeRelatedparamMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(QRCodeRelatedparam record);

    int insertSelective(QRCodeRelatedparam record);

    QRCodeRelatedparam selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(QRCodeRelatedparam record);

    int updateByPrimaryKey(QRCodeRelatedparam record);
}