package com.fang.pm.service.impl;

import com.fang.pm.dao.LogcatDao;
import com.fang.pm.entity.request.real.Logcat;
import com.fang.pm.entity.resp.Result;
import com.fang.pm.service.LogcatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LogcatServiceImpl implements LogcatService {

    @Autowired
    private LogcatDao logcatDao;

    @Override
    public int add(Logcat logcat) {
        return logcatDao.add(logcat);
    }

    @Override
    public List<Logcat> all(Logcat logcat) {
        return logcatDao.all(logcat);
    }

    @Override
    public int count(Logcat logcat) {
        return logcatDao.count(logcat);
    }

    @Override
    public Result selectOption() {

        String[] keys = {
                "project",
                "version",
                "phone"
        };
        HashMap<String, List<String>> options = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            List<String> val = logcatDao.orderForColumn(keys[i]);
            options.put(keys[i], val);
        }
        return new Result(200, null, options, 1);
    }


}
