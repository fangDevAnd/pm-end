package com.fang.pm.sub.service.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @param <k> 主键
 * @param <F> 外键
 * @param <T> 对象
 */
public interface BaseDao<k, F, T> {

    /**
     * 外键列表的 map
     */
    public static final String FKS = "fks";


    int count(@Param("params") Map<String, Object> params, @Param("custom") String custom);


    List<T> list(@Param("params") Map<String, Object> params,
                 @Param("custom") String custom,
                 @Param("offset") Integer offset,
                 @Param("limit") Integer limit,
                 @Param("sort") String sort);

    int insert(@Param("obj") T data);


    int del(@Param("params") Map<String, Object> params, @Param("custom") String custom);


    int update(@Param("obj") T t, @Param("params") Map<String, Object> params, @Param("custom") String custom);

    /**
     * 总数的查询
     *
     * @param params where条件
     * @param field  操作的域
     * @return
     */

    float sum(@Param("params") Map<String, Object> params, @Param("custom") String custom, @Param("field") String field);

    /**
     * 平均值的sql接口
     *
     * @param params where条件
     * @param field  操作的域
     * @return
     */

    float avg(@Param("params") Map<String, Object> params, @Param("custom") String custom, @Param("field") String field);


}
