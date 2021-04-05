package com.fang.pm.controll;


import com.fang.pm.config.DependencyCheckProperties;
import com.fang.pm.entity.CheckReport;
import com.fang.pm.entity.resp.Result;
import com.fang.pm.sub.base.base.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import com.fang.pm.sub.base.base.Result;

/**
 * 这个实现的功能是 测试项目的
 */
@RestController
@RequestMapping("/check")
public class CheckReportController {

    @Autowired
    DependencyCheckProperties dependencyCheckProperties;


    //使用本地缓存方案
    private List<CheckReport> projectNames;

    //定义再次扫描项目的时间
    public static final int TIME_FOR_RE_SCAN = 10 * 60 * 1000;

    private long beforeScanTime;


    /**
     * 获得项目的名称
     *
     * @return
     */
    @RequestMapping("/all")
    public Result allCheckResport() {

        if (beforeScanTime == 0) {
            projectNames = getWorkSpaceName(dependencyCheckProperties.getFileRootPath());
        } else if (beforeScanTime + TIME_FOR_RE_SCAN < System.currentTimeMillis()) {
            //重新刷新
            projectNames = getWorkSpaceName(dependencyCheckProperties.getFileRootPath());
        }
        beforeScanTime = System.currentTimeMillis();


        return new Result().setCode(200).setData(projectNames);
    }

    private List<CheckReport> getWorkSpaceName(String rootPath) {
        File workspace = new File(rootPath);
        List<CheckReport> checkReports = new ArrayList<>();
        if (workspace.isDirectory()) {
            List<String> fileList = Arrays.asList(workspace.list());
            fileList.stream().forEach(s -> {
                File fileItem = new File(workspace, s);
                CheckReport report = new CheckReport();
                report.setCreateTime(DateUtil.dateForType(fileItem.lastModified(), 1));
                File reportHtml = new File(fileItem, dependencyCheckProperties.getFileName());
                report.setProjectName(s);
                report.setGenerateDate(DateUtil.dateForType(reportHtml.lastModified(), 1));
                checkReports.add(report);
            });
        }
        return checkReports;
    }


}
