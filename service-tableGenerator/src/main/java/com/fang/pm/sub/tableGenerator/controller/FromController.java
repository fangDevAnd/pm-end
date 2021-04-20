package com.fang.pm.sub.tableGenerator.controller;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.bean.LimitResp;
import com.fang.pm.sub.base.base.util.ObjMapper;
import com.fang.pm.sub.service.BaseController;
import com.fang.pm.sub.service.service.BaseService;
import com.fang.pm.sub.tableGenerator.bean.GeneratorForm;
import com.fang.pm.sub.tableGenerator.service.GeneratorFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * 生成器的 form历史数据
 * 支持分页
 */
@RestController
@RequestMapping("/generator/form")
public class FromController extends BaseController<Integer, Void, GeneratorForm> {

    @Autowired
    GeneratorFormService generatorFormService;

    @Override
    protected BaseService<Integer, Void, GeneratorForm> getBaseService() {
        return generatorFormService;
    }
}
