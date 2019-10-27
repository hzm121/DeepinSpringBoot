package com.hzm.shop.dao;

import com.hzm.shop.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author hzm
 */
@Repository
public interface ProductDao {
    /**
     * 根据ID获取产品
     * @param id
     * @return ProductPo
     */
    public ProductPo getProduct(Long id);

    /**
     * 产品库存减1
     * @param id
     * @param quantity
     * @param version
     * @return int
     */
    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity,@Param("version") int version);
}
