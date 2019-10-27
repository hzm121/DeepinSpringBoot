package com.hzm.shop.controller;

import com.hzm.shop.dao.PurchaseRecordDao;
import com.hzm.shop.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hzm
 */
@Controller
public class PurchaseController   {
    @Autowired
    private PurchaseService purchaseService = null;
    @Autowired
private PurchaseRecordDao purchaseRecordDao = null;
    /**
     定义JSP视图
     */
    @RequestMapping("/test")
    public String testPage(){
        return "test";
    }
    @PostMapping("/purchase")
    @ResponseBody
    public Result purchase(Long userId, Long productId, Integer quantity) {
        boolean isSuccess = purchaseService.purchase(userId, productId, quantity);
        String msg = isSuccess ? "抢购成功" : "抢购失败";
        return new Result(isSuccess, msg);
    }
}

class Result {
    private boolean isSuccess = false;
    private String msg = null;

    public Result() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Result(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }
}
