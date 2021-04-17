package com.fang.pm.sub.autotest.service.impl;

import com.fang.pm.sub.autotest.bean.AutoTest;
import com.fang.pm.sub.autotest.bean.TestItem;
import com.fang.pm.sub.autotest.mapper.AutoTestMapper;
import com.fang.pm.sub.autotest.mapper.TestItemMapper;
import com.fang.pm.sub.autotest.service.AutoTestService;
import com.fang.pm.sub.autotest.service.TestItemService;
import com.fang.pm.sub.service.mapper.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestItemServiceImpl extends TestItemService {

    @Autowired
    TestItemMapper mapper;

    @Override
    public BaseDao<Integer, Integer, TestItem> getDao() {
        return mapper;
    }


}
