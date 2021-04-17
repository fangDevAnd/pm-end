package com.fang.pm.sub.service.service;

import com.fang.pm.sub.service.mapper.BaseDao;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * 提供了基本的查询接口 .对于实现一些数据相关的查询提供了基本的crud方法
 * 唯一不同的是 需要自己编写底层的 xml 实现
 *
 * @param <MK>
 * @param <FK>
 * @param <O>
 */
public abstract class BaseQueryService<MK, FK, O> implements BaseService<MK, FK, O> {


    @PostConstruct
    public void init() {

    }

    public abstract BaseDao<MK, FK, O> getDao();

    @Override
    public List<O> list(Map<String, Object> params, String customFilter, Integer offset, Integer limit, String sort) {
        return getDao().list(params, customFilter, offset, limit, sort);
    }

    @Override
    public int count(Map<String, Object> params, String customFilter) {
        return getDao().count(params, customFilter);
    }

    @Override
    public int add(O bean) {
        return getDao().insert(bean);
    }

    @Override
    public int del(Map<String, Object> params, String customFilter) {
        return getDao().del(params, customFilter);
    }

    @Override
    public int update(Map<String, Object> params, String customFilter, O bean) {
        return getDao().update(bean, params, customFilter);
    }

    @Override
    public float sum(Map<String, Object> params, String customFilter, String field) {
        return getDao().sum(params, customFilter, field);
    }

    @Override
    public float avg(Map<String, Object> params, String customFilter, String field) {
        return getDao().avg(params, customFilter, field);
    }


}
