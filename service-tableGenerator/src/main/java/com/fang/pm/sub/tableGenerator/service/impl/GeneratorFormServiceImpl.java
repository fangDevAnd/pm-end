package com.fang.pm.sub.tableGenerator.service.impl;

import com.fang.pm.sub.service.mapper.BaseDao;
import com.fang.pm.sub.tableGenerator.bean.GeneratorForm;
import com.fang.pm.sub.tableGenerator.mapper.GeneratorFormMapper;
import com.fang.pm.sub.tableGenerator.service.GeneratorFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Service
public class GeneratorFormServiceImpl extends GeneratorFormService {

    @Autowired
    GeneratorFormMapper mapper;
    
    @Override
    public BaseDao<Integer, Void, GeneratorForm> getDao() {
        return mapper;
    }
}
