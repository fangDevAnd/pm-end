package com.fang.pm.sub.service.util;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.bean.LimitRequest;
import com.fang.pm.sub.base.base.bean.LimitResp;
import com.fang.pm.sub.base.base.util.ObjMapper;
import com.fang.pm.sub.service.service.BaseService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class ControllerUtils {

    public static <MK, FK, O> Result list(O bean, BaseService<MK, FK, O> baseService) {
        HashMap<String, Object> param = ObjMapper.objToMap(bean);
        List<O> formList = baseService.list(
                param, null, null, null, null);
        LimitResp resp = new LimitResp();
        resp.setTotal(baseService.count(param, null));
        resp.setData(formList);
        return new Result().setCode(200).setData(resp);
    }


    public static <MK, FK, O> Result del(O bean, BaseService<MK, FK, O> baseService) {
        HashMap<String, Object> param = ObjMapper.objToMap(bean);
        int result = baseService.del(param, null);
        return new Result().setData(result).setCode(200);
    }


    public static <MK, FK, O> Result add(O bean, BaseService<MK, FK, O> baseService) {
        int result = baseService.add(bean);
        return new Result().setData(result).setCode(200);
    }

    public static <MK, FK, O extends LimitRequest> Result update(O bean, BaseService<MK, FK, O> baseService) {
        O whereBean = (O) new Gson().fromJson(bean.getUpdateParam(), bean.getClass());
        HashMap<String, Object> param = ObjMapper.objToMap(whereBean);
        int result = baseService.update(param, null, bean);
        return new Result().setData(result).setCode(200);
    }


}
