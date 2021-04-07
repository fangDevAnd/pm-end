package com.fang.pm.controll;


import com.fang.pm.entity.request.real.ProjectReqResp;
import com.fang.pm.entity.resp.Result;
import com.fang.pm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目配置的控制器
 *
 * @author fang
 * @date 2020-11-16
 * @function 主要的功能是提供对 项目表的crud 操作
 */
@RestController
@RequestMapping("/pro")
public class ProjectConfigControll {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/all")
    public Result all(ProjectReqResp reqResp) {

        reqResp.getLimitAndOffset();

        return projectService.getAll(reqResp);
    }

    @RequestMapping("/update")
    public Result update(ProjectReqResp resp) {
        return projectService.update(resp);
    }

    @RequestMapping("/del")
    public Result del(ProjectReqResp resp) {
        resp.setIsDel(1);
        return projectService.update(resp);
    }

    @RequestMapping("/add")
    public Result insert(ProjectReqResp resp) {
        return projectService.add(resp);
    }


}
