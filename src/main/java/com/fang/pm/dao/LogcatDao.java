package com.fang.pm.dao;

import com.fang.pm.entity.request.LimitRequest;
import com.fang.pm.entity.request.real.Logcat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogcatDao {

    public int add(Logcat logcat);

    List<Logcat> all(Logcat logcat);

    int count(Logcat logcat);
}
