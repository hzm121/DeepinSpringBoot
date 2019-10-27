package com.hzm.shop.dao;

import com.hzm.shop.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hzm
 */
@Repository
public interface PurchaseRecordDao {
    /**
     * 增加一条支付记录
     * @param pr
     * @return int
     */
    public int insertPurchaseRecord(PurchaseRecordPo pr);
}
