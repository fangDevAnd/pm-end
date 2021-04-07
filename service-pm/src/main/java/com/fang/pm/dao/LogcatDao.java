package com.fang.pm.dao;

import com.fang.pm.entity.request.LimitRequest;
import com.fang.pm.entity.request.real.Logcat;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogcatDao {

    public int add(Logcat logcat);

    List<Logcat> all(Logcat logcat);

    int count(Logcat logcat);

    @Select("select distinct ${key} from logcat order by #{key}")
    List<String> orderForColumn(@Param("key") String key);
}
