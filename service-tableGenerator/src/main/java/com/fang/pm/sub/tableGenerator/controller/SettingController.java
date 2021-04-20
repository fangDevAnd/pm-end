package com.fang.pm.sub.tableGenerator.controller;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.util.ObjMapper;
import com.fang.pm.sub.tableGenerator.bean.GeneratorForm;
import com.fang.pm.sub.tableGenerator.bean.GeneratorRoute;
import com.fang.pm.sub.tableGenerator.bean.GeneratorSetting;
import com.fang.pm.sub.tableGenerator.service.GeneratorRouteService;
import com.fang.pm.sub.tableGenerator.service.GeneratorSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 表单设置的控制器
 */
@RequestMapping("/generator/setting")
@RestController
public class SettingController {

    @Autowired
    GeneratorSettingService generatorSettingService;


    /**
     * 列表数据
     *
     * @param route
     * @return
     */
    @RequestMapping("/list")
    public Result list(GeneratorSetting route) {
        HashMap<String, Object> param = ObjMapper.objToMap(route);
        List<GeneratorSetting> formList = generatorSettingService.list(
                param, null, null, null, "id desc");
        return new Result().setCode(200).setData(formList);
    }

    /**
     * 删除
     *
     * @param form
     * @return
     */
    @RequestMapping("/del")
    public Result del(GeneratorSetting form) {
        HashMap<String, Object> param = ObjMapper.objToMap(form);
        int result = generatorSettingService.del(param, null);
        return new Result().setData(result).setCode(200);
    }


}
