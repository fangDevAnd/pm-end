package com.fang.pm.sub.tableGenerator.bean;

import com.fang.pm.sub.base.base.bean.LimitRequest;

/**
 * 表单设置
 */
public class GeneratorSetting extends LimitRequest {

    private Integer id;

    private String form;

    private String itemMapper;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getItemMapper() {
        return itemMapper;
    }

    public void setItemMapper(String itemMapper) {
        this.itemMapper = itemMapper;
    }
}
