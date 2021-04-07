package com.fang.pm.dao;


import com.fang.pm.entity.request.real.ProjectReqResp;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * 项目的dao
 */
public interface ProjectDao {

    /**
     * 获得所有的项目的接口
     *
     * @param reqResp
     * @return
     */
    public List<ProjectReqResp> getAll(@Param("param") ProjectReqResp reqResp);

    /**
     * 对指定的项目进行更新
     *
     * @param reqResp
     * @return
     */
    public int update(@Param("param") ProjectReqResp reqResp);

    /**
     * 添加一个新的项目
     *
     * @param reqResp
     * @return
     */
    public int add(@Param("param") ProjectReqResp reqResp);


    int count(@Param("param") ProjectReqResp reqResp);
}
