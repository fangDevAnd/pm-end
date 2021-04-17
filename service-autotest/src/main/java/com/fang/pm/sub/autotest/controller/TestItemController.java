package com.fang.pm.sub.autotest.controller;

import com.fang.pm.sub.autotest.bean.TestItem;
import com.fang.pm.sub.autotest.bean.TestProject;
import com.fang.pm.sub.autotest.service.TestItemService;
import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.util.ObjMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autoTest/item")
public class TestItemController {

    @Autowired
    TestItemService testItemService;

    @RequestMapping("/all")
    public Result all(TestItem testItem) {
        List<TestItem> items = testItemService.list(ObjMapper.objToMap(testItem), null, null, null, "id desc");
        return new Result().setData(items).setCode(200);
    }

    @PostMapping("/add")
    public Result add(@RequestBody  TestItem project) {
        int result = testItemService.add(project);
        return new Result().setCode(200).setData(result);
    }


    @PostMapping("/del")
    public Result del(@RequestBody  TestItem project) {
        int result = testItemService.del(ObjMapper.objToMap(project), null);
        return new Result().setCode(200).setData(result);
    }


}
