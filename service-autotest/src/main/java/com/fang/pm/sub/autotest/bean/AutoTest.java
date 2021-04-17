package com.fang.pm.sub.autotest.bean;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * 自动测试表
 * <p>
 * 名称
 * 类型
 */
public class AutoTest {

    private String name;

    private Integer id;

    private Integer projectId;

    private Byte type;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}
