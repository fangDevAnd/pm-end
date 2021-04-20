package com.fang.pm.sub.tableGenerator.service.impl;

import com.fang.pm.sub.service.mapper.BaseDao;
import com.fang.pm.sub.tableGenerator.bean.GeneratorRoute;
import com.fang.pm.sub.tableGenerator.bean.GeneratorSetting;
import com.fang.pm.sub.tableGenerator.mapper.GeneratorSettingMapper;
import com.fang.pm.sub.tableGenerator.service.GeneratorRouteService;
import com.fang.pm.sub.tableGenerator.service.GeneratorSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorSettingServiceImpl extends GeneratorSettingService {

    @Autowired
    GeneratorSettingMapper mapper;

    @Override
    public BaseDao<Integer, Void, GeneratorSetting> getDao() {
        return mapper;
    }
}
