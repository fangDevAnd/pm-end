package com.fang.pm.sub.service;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.bean.LimitRequest;
import com.fang.pm.sub.base.base.bean.LimitResp;
import com.fang.pm.sub.base.base.util.ObjMapper;
import com.fang.pm.sub.service.service.BaseService;
import com.fang.pm.sub.service.util.ControllerUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

public abstract class BaseController<MK, FK, O extends LimitRequest> {

    protected abstract BaseService<MK, FK, O> getBaseService();

    /**
     * 列表数据
     *
     * @param route
     * @return
     */
    @RequestMapping("/list")
    public Result list(O route) {
        return ControllerUtils.list(route, getBaseService());
    }

    /**
     * 删除
     *
     * @param route
     * @return
     */
    @PostMapping("/del")
    public Result del(O route) {
        return ControllerUtils.del(route, getBaseService());
    }


    @PostMapping("/add")
    public Result add(O bean) {
        return ControllerUtils.add(bean, getBaseService());
    }

    @PostMapping("/update")
    public Result update(O bean) {
        return ControllerUtils.update(bean, getBaseService());
    }


}
