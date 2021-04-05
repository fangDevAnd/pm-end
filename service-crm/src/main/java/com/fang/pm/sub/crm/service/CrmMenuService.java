package com.fang.pm.sub.crm.service;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.crm.Bean.CrmMenu;

import java.util.List;

public interface CrmMenuService {

    Result getMenu();

    Result add(CrmMenu menu);

    Result del(Integer id);
}
