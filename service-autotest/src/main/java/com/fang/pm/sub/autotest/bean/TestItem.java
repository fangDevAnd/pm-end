package com.fang.pm.sub.autotest.bean;

/**
 * 自动测试项
 */
public class TestItem {

    private Integer autoTestId;

    private Integer id;

    private String descr;

    //存放实际的数据，使用的是json存储,
    private String innerItems;

    //卡片数量的恢复
    private String initCount;

    public Integer getAutoTestId() {
        return autoTestId;
    }

    public void setAutoTestId(Integer autoTestId) {
        this.autoTestId = autoTestId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getInnerItems() {
        return innerItems;
    }

    public void setInnerItems(String innerItems) {
        this.innerItems = innerItems;
    }

    public String getInitCount() {
        return initCount;
    }

    public void setInitCount(String initCount) {
        this.initCount = initCount;
    }
}
