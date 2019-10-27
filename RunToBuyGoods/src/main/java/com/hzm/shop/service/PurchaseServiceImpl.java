package com.hzm.shop.service;

import com.hzm.shop.dao.ProductDao;
import com.hzm.shop.dao.PurchaseRecordDao;
import com.hzm.shop.pojo.ProductPo;
import com.hzm.shop.pojo.PurchaseRecordPo;
import com.hzm.shop.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * @author huangzhenmin
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    ProductDao productDao = null;
    @Autowired
    PurchaseRecordDao purchaseRecordDao = null;
    @Autowired
    StringRedisTemplate redisTemplate = null;

    @Override
    //启动spring数据库事务机制
    @Transactional(rollbackFor = Exception.class)

    public boolean purchase(Long userId, Long productId, int quantity) {
        //使用时间戳限制数据重入次数
//        long start = System.currentTimeMillis();
//        while (true) {
//            long end = System.currentTimeMillis();
//            if (end -start >1000){
//                return false;
//            }
//            //获取产品
//            ProductPo product = productDao.getProduct(productId);
//            //比较库存和购买数量
//            if (product.getStock() < quantity) {
//                //库存不足
//                return false;
//            }
//            //查询版本号
//            int version = product.getVersion();
//            //扣减库存
//            int result = productDao.decreaseProduct(userId, quantity,version);
//            //如果更新数据失败说明数据在多线程中被其他线程修改，导致失败返回
//            if (result == 0){
//                continue;
//            }
//            //初始化购买记录
//            PurchaseRecordPo purchaseRecordPo = initPurchaseRecord(userId, product, quantity);
//            //插入购买记录
//            purchaseRecordDao.insertPurchaseRecord(purchaseRecordPo);
//            return true;

        //使用次数限制重入
        for (int i = 0; i < 10; i++) {
            //获取产品
            ProductPo product = productDao.getProduct(productId);
            //比较库存和购买数量
            if (product.getStock() < quantity) {
                //库存不足
                return false;
            }
            //查询版本号
            int version = product.getVersion();
            //扣减库存
            int result = productDao.decreaseProduct(userId, quantity, version);
            //如果更新数据失败说明数据在多线程中被其他线程修改，导致失败返回
            if (result == 0) {
                continue;
            }
            //初始化购买记录
            PurchaseRecordPo purchaseRecordPo = initPurchaseRecord(userId, product, quantity);
            //插入购买记录
            purchaseRecordDao.insertPurchaseRecord(purchaseRecordPo);
            return true;
        }
        return false;

        //使用Redis Lua响应请求
//        String purchaseScript = "" +
//                "redis.call('sadd',KEY[1],ARGV[2]) \n";


    }

    /**
     * 初始化购买记录
     */
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
