package com.fang.pm.sub.tableGenerator.bean;

import com.fang.pm.sub.base.base.bean.LimitRequest;

public class GeneratorRoute  extends LimitRequest {

    private String router;

    private String formVal;

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getFormVal() {
        return formVal;
    }

    public void setFormVal(String formVal) {
        this.formVal = formVal;
    }
}
