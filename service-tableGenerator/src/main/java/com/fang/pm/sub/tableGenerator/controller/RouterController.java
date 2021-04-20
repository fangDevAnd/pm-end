package com.fang.pm.sub.tableGenerator.controller;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.util.ObjMapper;
import com.fang.pm.sub.tableGenerator.bean.GeneratorForm;
import com.fang.pm.sub.tableGenerator.bean.GeneratorRoute;
import com.fang.pm.sub.tableGenerator.service.GeneratorFormService;
import com.fang.pm.sub.tableGenerator.service.GeneratorRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 生成器的 form配置
 */
@RestController
@RequestMapping("/generator/router")
public class RouterController {

    @Autowired
    GeneratorRouteService generatorRouteService;

    /**
     * 列表数据
     *
     * @param route
     * @return
     */
    @RequestMapping("/list")
    public Result list(GeneratorRoute route) {
        HashMap<String, Object> param = ObjMapper.objToMap(route);
        List<GeneratorRoute> formList = generatorRouteService.list(
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
    public Result del(GeneratorRoute form) {
        HashMap<String, Object> param = ObjMapper.objToMap(form);
        int result = generatorRouteService.del(param, null);
        return new Result().setData(result).setCode(200);
    }

}
