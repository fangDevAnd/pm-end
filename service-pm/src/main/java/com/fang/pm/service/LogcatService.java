package com.fang.pm.service;

import com.fang.pm.entity.request.real.Logcat;
import com.fang.pm.entity.resp.Result;

import java.util.List;

public interface LogcatService {


    int add(Logcat logcat);

    List<Logcat> all(Logcat request);

    int count(Logcat request);

    Result selectOption();
}
