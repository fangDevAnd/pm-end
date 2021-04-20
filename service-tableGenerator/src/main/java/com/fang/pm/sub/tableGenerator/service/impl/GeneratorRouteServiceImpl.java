package com.fang.pm.sub.tableGenerator.service.impl;

import com.fang.pm.sub.service.mapper.BaseDao;
import com.fang.pm.sub.service.service.BaseQueryService;
import com.fang.pm.sub.tableGenerator.bean.GeneratorRoute;
import com.fang.pm.sub.tableGenerator.mapper.GeneratorRouterMapper;
import com.fang.pm.sub.tableGenerator.service.GeneratorRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorRouteServiceImpl extends GeneratorRouteService {

    @Autowired
    GeneratorRouterMapper mapper;

    @Override
    public BaseDao<Integer, Void, GeneratorRoute> getDao() {
        return mapper;
    }
}
