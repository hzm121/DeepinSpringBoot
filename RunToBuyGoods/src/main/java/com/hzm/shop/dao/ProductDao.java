package com.hzm.shop.dao;

import com.hzm.shop.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
    public ProductPo getProduct(Long id);
    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);
}
