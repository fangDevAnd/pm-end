package com.fang.pm.sub.tableGenerator.bean;

import com.fang.pm.sub.base.base.bean.LimitRequest;

public class GeneratorForm extends LimitRequest {

    private Integer id;

    private String formVal;

    private String desci;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormVal() {
        return formVal;
    }

    public void setFormVal(String formVal) {
        this.formVal = formVal;
    }

    public String getDesci() {
        return desci;
    }

    public void setDesci(String desci) {
        this.desci = desci;
    }



}
