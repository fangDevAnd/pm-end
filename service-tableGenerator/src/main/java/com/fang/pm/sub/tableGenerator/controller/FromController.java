package com.fang.pm.sub.tableGenerator.controller;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.util.ObjMapper;
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
public class FromController {

    @Autowired
    GeneratorFormService generatorFormService;

    /**
     * 列表数据
     *
     * @param form
     * @return
     */
    @RequestMapping("/list")
    public Result list(GeneratorForm form) {
        HashMap<String, Object> param = ObjMapper.objToMap(form);
        List<GeneratorForm> formList = generatorFormService.list(
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
    public Result del(GeneratorForm form) {
        HashMap<String, Object> param = ObjMapper.objToMap(form);
        int result = generatorFormService.del(param, null);
        return new Result().setData(result).setCode(200);
    }


}
