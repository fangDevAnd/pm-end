package com.fang.pm.sub.tableGenerator.controller;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.bean.LimitResp;
import com.fang.pm.sub.base.base.util.ObjMapper;
import com.fang.pm.sub.service.BaseController;
import com.fang.pm.sub.service.service.BaseService;
import com.fang.pm.sub.tableGenerator.bean.GeneratorForm;
import com.fang.pm.sub.tableGenerator.bean.GeneratorRoute;
import com.fang.pm.sub.tableGenerator.bean.GeneratorSetting;
import com.fang.pm.sub.tableGenerator.service.GeneratorRouteService;
import com.fang.pm.sub.tableGenerator.service.GeneratorSettingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 表单设置的控制器
 */
@RequestMapping("/generator/setting")
@RestController
public class SettingController extends BaseController<Integer, Void, GeneratorSetting> {

    @Autowired
    GeneratorSettingService generatorSettingService;
    
    @Override
    protected BaseService<Integer, Void, GeneratorSetting> getBaseService() {
        return generatorSettingService;
    }
}
