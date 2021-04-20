package com.fang.pm.sub.tableGenerator.controller;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.bean.LimitResp;
import com.fang.pm.sub.base.base.util.ObjMapper;
import com.fang.pm.sub.service.BaseController;
import com.fang.pm.sub.service.service.BaseService;
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
public class RouterController extends BaseController<Integer, Void, GeneratorRoute> {

    @Autowired
    GeneratorRouteService generatorRouteService;

    @Override
    protected BaseService<Integer, Void, GeneratorRoute> getBaseService() {
        return generatorRouteService;
    }

}
