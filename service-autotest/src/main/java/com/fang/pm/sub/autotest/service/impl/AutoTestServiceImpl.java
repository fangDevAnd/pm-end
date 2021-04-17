package com.fang.pm.sub.autotest.service.impl;

import com.fang.pm.sub.autotest.bean.AutoTest;
import com.fang.pm.sub.autotest.bean.TestProject;
import com.fang.pm.sub.autotest.mapper.AutoTestMapper;
import com.fang.pm.sub.autotest.mapper.TestProjectMapper;
import com.fang.pm.sub.autotest.service.AutoTestService;
import com.fang.pm.sub.autotest.service.TestProjectService;
import com.fang.pm.sub.service.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoTestServiceImpl extends AutoTestService {

    @Autowired
    AutoTestMapper mapper;

    @Override
    public BaseDao<Integer, Integer, AutoTest> getDao() {
        return mapper;
    }



}
