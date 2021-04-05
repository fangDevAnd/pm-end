package com.fang.pm.sub.crm.controller;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.crm.Bean.CrmMenu;
import com.fang.pm.sub.crm.service.CrmMenuService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内部的　crm系统的控制器
 */

@RestController
@RequestMapping("/crm")
public class CrmMenuController {

    @Autowired
    CrmMenuService crmMenuService;

    @RequestMapping("menu")
    public Result menuList() {
        return crmMenuService.getMenu();
    }

    @RequestMapping("/add")
    public Result add(@RequestBody CrmMenu menu) {
        return crmMenuService.add(menu);
    }

    /**
     * 删除，会删除对应下面的所有id
     *
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public Result del(Integer id) {
        return crmMenuService.del(id);
    }


}
