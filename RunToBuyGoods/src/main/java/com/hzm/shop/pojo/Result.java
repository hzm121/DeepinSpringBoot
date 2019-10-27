package com.hzm.shop.pojo;
/**
 * @author huangzhenmin
 */
public class Result {
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
