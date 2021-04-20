package com.fang.pm.sub.base.base.bean;

/**
 * 基本的请求接口
 */
public abstract class BaseRequest {
    //代表的是更新操作时，where条件的参数
    private String updateParam = null;

    public String getUpdateParam() {
        return updateParam;
    }

    public void setUpdateParam(String updateParam) {
        this.updateParam = updateParam;
    }
}
