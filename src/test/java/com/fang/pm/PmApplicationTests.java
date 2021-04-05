package com.fang.pm;

import com.fang.pm.controll.LogcatControll;
import com.fang.pm.entity.request.real.Logcat;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class PmApplicationTests {

    @Autowired
    LogcatControll logcatControll;

    @Test
    void contextLoads() {

//        Logcat logcat = new Logcat("BeiteEr", "152553332322",
//                "13077995907", null, "e", "not found this", "Device");
//        logcatControll.uploadLogcat(logcat);

//        System.out.println(new Gson().toJson(logcat));

    }

}
