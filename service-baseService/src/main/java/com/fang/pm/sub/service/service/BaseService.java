package com.fang.pm.sub.service.service;

import java.util.List;
import java.util.Map;

/**
 * @param <MK> 主键
 * @param <FK> 外键
 * @param <O>  数据对象
 */
public interface BaseService<MK, FK, O> {

    //---------数据无关性方法

    /**
     * 查询自己单表的数据的方法,一般代表的是无关性查询,
     *
     * @param params
     * @param customFilter
     * @param offset
     * @param limit
     * @param sort
     * @return
     */
    List<O> list(Map<String, Object> params, String customFilter, Integer offset, Integer limit, String sort);

    /**
     * 查询数据的count 数量
     *
     * @param params
     * @param customFilter
     * @return
     */
    int count(Map<String, Object> params, String customFilter);

    /**
     * 添加一个新的Bean 到数据库
     *
     * @param bean
     */
    int add(O bean);

    int del(Map<String, Object> params, String customFilter);

    int update(Map<String, Object> params, String customFilter, O bean);

    public float sum(Map<String, Object> params, String customFilter, String field);

    public float avg(Map<String, Object> params, String customFilter, String field);


}