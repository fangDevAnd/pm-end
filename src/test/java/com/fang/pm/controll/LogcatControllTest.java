package com.fang.pm.controll;

import com.fang.pm.entity.resp.Result;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class LogcatControllTest {

    @Autowired
    LogcatControll logcatControll;

    @Test
    void option() {
        Result result = logcatControll.option();
        System.out.println(new Gson().toJson(result));
    }
}