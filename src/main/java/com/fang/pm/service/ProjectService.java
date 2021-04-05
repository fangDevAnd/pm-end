package com.fang.pm.service;


import com.fang.pm.entity.request.real.ProjectReqResp;
import com.fang.pm.entity.resp.Result;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目管理的 业务逻辑层的实现
 */

public interface ProjectService {


    /**
     * 获得所有的项目的接口
     *
     * @param reqResp
     * @return
     */
    public Result getAll(ProjectReqResp reqResp);

    /**
     * 对指定的项目进行更新
     *
     * @param reqResp
     * @return
     */
    public Result update(ProjectReqResp reqResp);

    /**
     * 添加一个新的项目
     *
     * @param reqResp
     * @return
     */
    public Result add(ProjectReqResp reqResp);


}
