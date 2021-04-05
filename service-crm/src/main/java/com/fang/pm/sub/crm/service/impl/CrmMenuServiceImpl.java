package com.fang.pm.sub.crm.service.impl;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.crm.Bean.CrmMenu;
import com.fang.pm.sub.crm.mapper.CrmMenuMapper;
import com.fang.pm.sub.crm.service.CrmMenuService;
import com.fang.pm.sub.upload.bean.Upload;
import com.fang.pm.sub.upload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrmMenuServiceImpl implements CrmMenuService {

    @Autowired
    CrmMenuMapper crmMenuMapper;

    @Autowired
    FileUploadService uploadService;

    @Override
    public Result getMenu() {
        List<CrmMenu> menus = crmMenuMapper.findAll(0);
        return new Result().setCode(Result.CODE_SUCCESS).setData(foreachList(menus));
    }

    /**
     * 添加一个菜单
     *
     * @param menu
     * @return
     */
    @Override
    public Result add(CrmMenu menu) {
        crmMenuMapper.insert(menu);
        return new Result().setCode(200);
    }

    private List<CrmMenu> foreachList(List<CrmMenu> menus) {
        menus.forEach(crmMenu -> {
            if (crmMenu.getUrl() != null) {
                Upload upload = uploadService.url(crmMenu.getUrl());
                crmMenu.setUrls(upload.getUrls());
            }
            List<CrmMenu> itemMenu = crmMenuMapper.findAll(crmMenu.getId());
            crmMenu.setList(foreachList(itemMenu));
        });
        return menus;
    }

    public Result del(Integer id) {
        CrmMenu crmMenu = new CrmMenu();
        crmMenu.setId(id);
        crmMenuMapper.del(crmMenu);
        List<CrmMenu> menus = crmMenuMapper.findAll(id);
        foreachList(menus);
        crmMenu.setList(menus);
        List<Integer> ids = new ArrayList<>();
        ids(crmMenu, ids);
        crmMenu.setIds(ids);
        crmMenuMapper.del(crmMenu);
        return new Result().setCode(200);
    }


    private List<Integer> ids(CrmMenu menu, List<Integer> ids) {
        menu.getList().forEach(menu1 -> {
            ids.add(menu.getId());
            ids.addAll(ids(menu1, ids));
        });
        return ids;
    }

}
