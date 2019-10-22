package com.hzm.shop.service;

import com.hzm.shop.dao.ProductDao;
import com.hzm.shop.dao.PurchaseRecordDao;
import com.hzm.shop.pojo.ProductPo;
import com.hzm.shop.pojo.PurchaseRecordPo;
import com.hzm.shop.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
public class PurchaseServiceImp implements PurchaseService {

    @Autowired
     ProductDao productDao = null;
    @Autowired
     PurchaseRecordDao purchaseRecordDao = null;

    @Override
    //启动spring数据库事务机制
    @Transactional

    public boolean purchase(Long userId, Long productId, int quantity) {
        //获取产品
        ProductPo product = productDao.getProduct(productId);
        //比较库存和购买数量
        if (product.getStock() < quantity) {
            //库存不足
            return false;
        }
        //扣减库存
        productDao.decreaseProduct(userId, quantity);
        //初始化购买记录
        PurchaseRecordPo purchaseRecordPo = initPurchaseRecord(userId, product, quantity);
        //插入购买记录
        purchaseRecordDao.insertPurchaseRecord(purchaseRecordPo);
        return true;
    }

    //初始化购买记录
    public PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo purchaseRecordPo = new PurchaseRecordPo();
        purchaseRecordPo.setNote("购买日志，时间：" + System.currentTimeMillis());
        purchaseRecordPo.setPrice(product.getPrice());
        purchaseRecordPo.setProductId(product.getId());
        purchaseRecordPo.setQuantity(quantity);
        purchaseRecordPo.setUserId(userId);
        purchaseRecordPo.setSum(product.getPrice() * quantity);
        return purchaseRecordPo;
    }
}
