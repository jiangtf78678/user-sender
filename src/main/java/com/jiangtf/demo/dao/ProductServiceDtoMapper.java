package com.jiangtf.demo.dao;

import com.jiangtf.demo.entity.ProductServiceDto;

public interface ProductServiceDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductServiceDto record);

    int insertSelective(ProductServiceDto record);

    ProductServiceDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductServiceDto record);

    int updateByPrimaryKey(ProductServiceDto record);
}