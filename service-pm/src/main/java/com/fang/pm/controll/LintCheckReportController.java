package com.fang.pm.controll;

import com.fang.pm.config.LintReportProperteis;
import com.fang.pm.entity.resp.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * lint检查报告的控制器
 */
@RestController
@RequestMapping("/lint")
public class LintCheckReportController {

    @Autowired
    LintReportProperteis lintReportProperteis;

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @RequestMapping("/all")
    public Result list(String project) {
        File file = new File(lintReportProperteis.getPath() + project + lintReportProperteis.getDir());
        logger.debug("当前文件路径" + file);
        return new Result().setCode(200).setData(file.list()).setMsg("成功");
    }


}
