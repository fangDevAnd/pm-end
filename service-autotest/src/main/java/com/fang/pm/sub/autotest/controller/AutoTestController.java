package com.fang.pm.sub.autotest.controller;

import com.fang.pm.sub.autotest.bean.AutoTest;
import com.fang.pm.sub.autotest.bean.TestItem;
import com.fang.pm.sub.autotest.bean.TestProject;
import com.fang.pm.sub.autotest.service.AutoTestService;
import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.util.MapGenerator;
import com.fang.pm.sub.base.base.util.ObjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/autoTest/test")
public class AutoTestController {


    @Autowired
    AutoTestService service;

    /**
     * 获得一个项目下的所有　自动化测试
     *
     * @param autoTest
     * @return
     */
    @RequestMapping("/all")
    public Result all(AutoTest autoTest) {
        Map<String, Object> param = ObjMapper.objToMap(autoTest);
        List<AutoTest> list = service.list(param,
                null, null, null, "name"
        );
        return new Result().setCode(200).setData(list);
    }

    @PostMapping("/add")
    public Result add(@RequestBody AutoTest autoTest) {
        int result = service.add(autoTest);
        return new Result().setCode(200).setData(result);
    }

    @PostMapping("/del")
    public Result del(@RequestBody AutoTest test) {
        int result = service.del(ObjMapper.objToMap(test), null);
        return new Result().setCode(200).setData(result);
    }


}

