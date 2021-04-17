package com.fang.pm.sub.autotest.service.impl;

import com.fang.pm.sub.autotest.bean.TestProject;
import com.fang.pm.sub.autotest.mapper.TestProjectMapper;
import com.fang.pm.sub.autotest.service.TestProjectService;
import com.fang.pm.sub.service.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestProjectServiceImpl extends TestProjectService {

    @Autowired
    TestProjectMapper mapper;

    @Override
    public BaseDao<Integer, Void, TestProject> getDao() {
        return mapper;
    }
}
