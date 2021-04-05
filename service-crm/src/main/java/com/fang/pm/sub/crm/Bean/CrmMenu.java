package com.fang.pm.sub.crm.Bean;

import java.util.List;

public class CrmMenu {

    private Integer id;

    private String menuName;

    private Integer pid;

    private Integer url;

    private List<CrmMenu> list;

    private String urls;

    private List<Integer> ids;

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public List<CrmMenu> getList() {
        return list;
    }

    public void setList(List<CrmMenu> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
