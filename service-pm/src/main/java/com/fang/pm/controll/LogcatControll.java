package com.fang.pm.controll;

import com.fang.pm.entity.request.real.Logcat;
import com.fang.pm.sub.base.base.bean.LimitResp;
import com.fang.pm.entity.resp.Result;
import com.fang.pm.service.LogcatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logcat")
public class LogcatControll {

    @Autowired
    LogcatService logcatService;

    @RequestMapping("/add")
    public Result uploadLogcat(@RequestBody Logcat logcat) {
        int result = logcatService.add(logcat);
        return new Result(200, null, null, result);
    }

    /**
     * 提供日志查询的功能
     *
     * @param logcat
     * @return
     */
    @RequestMapping("/list")
    public LimitResp list(@RequestBody Logcat logcat) {
        logcat.getLimitAndOffset();
        int count = logcatService.count(logcat);
        List<Logcat> list = logcatService.all(logcat);
        return new LimitResp(count, list);
    }

    @RequestMapping("/option")
    public Result option() {
        return logcatService.selectOption();
    }


}
