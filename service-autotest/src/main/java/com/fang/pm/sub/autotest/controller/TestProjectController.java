package com.fang.pm.sub.autotest.controller;

import com.fang.pm.sub.autotest.bean.TestItem;
import com.fang.pm.sub.autotest.bean.TestProject;
import com.fang.pm.sub.autotest.service.TestProjectService;
import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.util.ObjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 自动化测试项，
 * 包括创建项目,显示项目(分页)
 */
@RestController
@RequestMapping("/autoTest/project")
public class TestProjectController {

    @Autowired
    TestProjectService testProjectService;

    @RequestMapping("/all")
    public Result all() {
        List<TestProject> items = testProjectService.list(null, null, null, null, "id desc");
        return new Result().setData(items).setCode(200);
    }

    @PostMapping("/add")
    public Result add(@RequestBody TestProject project) {
        int result = testProjectService.add(project);
        return new Result().setCode(200).setData(result);
    }

    @PostMapping("/del")
    public Result del(@RequestBody TestProject project) {
        int result = testProjectService.del(ObjMapper.objToMap(project), null);
        return new Result().setCode(200).setData(result);
    }


}
