package com.fang.pm.service.impl;

import com.fang.pm.dao.ProjectDao;
import com.fang.pm.entity.request.real.ProjectReqResp;
import com.fang.pm.entity.resp.LimitResp;
import com.fang.pm.entity.resp.Result;
import com.fang.pm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDao projectDao;

    @Value("${project.projectPath}")
    String projectPath;

    @Override
    public Result getAll(ProjectReqResp reqResp) {
        List<ProjectReqResp> reqResps = getAllList(reqResp);
        int count = getCount(reqResp);
        LimitResp resp = new LimitResp(count, reqResps);
        return new Result(200, null, resp, 1);
    }

    public List<ProjectReqResp> getAllList(ProjectReqResp reqResp) {
        return projectDao.getAll(reqResp);
    }

    @Override
    public Result update(ProjectReqResp reqResp) {
        int result = projectDao.update(reqResp);
        return new Result(200, "更新成功", null, result);
    }


    public boolean hasPro(String proName) {
        ProjectReqResp pNameQuery = new ProjectReqResp();
        pNameQuery.setProName(proName);
        List<ProjectReqResp> reqResps = getAllList(pNameQuery);
        return reqResps.size() > 0;

    }

    @Transactional
    @Override
    public Result add(ProjectReqResp reqResp) {

        if (hasPro(reqResp.getProName())) {
            return new Result(1001, "当前项目已存在", null, 0);
        }

        reqResp.setCreateTime(new Date());
        int result = projectDao.add(reqResp);

        if (StringUtils.isEmpty(reqResp.getEngName())) {
            return new Result(301, "参数错误", null, 0);
        }

        File file = new File(projectPath + reqResp.getEngName());
        if (!file.exists()) {
            file.mkdir();
        }
        return new Result(200, "添加成功", null, result);
    }


    public int getCount(ProjectReqResp reqResp) {
        return projectDao.count(reqResp);
    }


}
