package com.fang.pm.service;

import com.fang.pm.entity.request.LimitRequest;
import com.fang.pm.entity.request.real.Logcat;

import java.util.List;

public interface LogcatService {


    int add(Logcat logcat);

    List<Logcat> all(Logcat request);

    int count(Logcat request);


}
