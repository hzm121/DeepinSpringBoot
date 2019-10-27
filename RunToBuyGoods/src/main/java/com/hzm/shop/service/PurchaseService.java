package com.hzm.shop.service;

import org.springframework.stereotype.Service;
/**
 * @author hzm
 */

public interface PurchaseService {
    /**
     * 处理购买业务
     * @param userId 用户编号
     * @param productId 产品编号
     * @param quantity 产品数量
     * @return 成功或失败
     */
    public boolean purchase(Long userId,Long productId,int quantity);
}
