package com.fang.pm.controll;


import com.fang.pm.entity.resp.Result;
import com.fang.pm.sub.base.base.ResponseUtils;
import com.fang.pm.sub.base.base.security.SecurityPathIgnore;
import com.fang.pm.util.QrCodeGenerateService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 包管理的控制代码
 */
@RestController
@RequestMapping("/pm")
public class PmControll {


    @Value("${project.projectPath}")
    String projectPath;

    @Value("${server.port}")
    String port;

    @Autowired
    public void setIgnore(SecurityPathIgnore ignore) {
        this.ignore = ignore;
    }

    private SecurityPathIgnore ignore;

    /**
     * 列出当前的项目
     *
     * @return
     */
    @RequestMapping("/list/dir")
    public Result listProject(HttpServletRequest request) throws Exception {
        System.out.println(ignore);

        File file = new File(projectPath);

        if (!file.exists()) {
            file.createNewFile();
        }

        String[] fileS = file.list();

        return new Result(200, "success", fileS, 1);
    }

    @RequestMapping("/list/file")
    public Result listFile(String project) {

        File file = new File(projectPath + project);

        if (file.exists() && file.isDirectory()) {

            File[] childFile = file.listFiles();

            if (childFile != null) {
                Arrays.sort(childFile, (one, two) -> (two.getName().compareTo(one.getName())));
            }

            List<String> files = Arrays.asList(childFile).stream().map(file1 -> file1.getName()).collect(Collectors.toList());
            return new Result(200, "success", files, 1);
        } else {
            return new Result(200, "失败", null, 0);
        }
    }

    /**
     * 生成二维码
     * 该生成的 url 直接走 nginx
     */
    @GetMapping(value = "/qrimage")
    public ResponseEntity<byte[]> getQRImage(String url, HttpServletRequest request) throws IOException, WriterException {
        String urlReal = "http://" + request.getServerName() + ":" + port + "/pm/file/down?path=" + url;
        //二维码内的信息
        byte[] qrcode = null;
        qrcode = QrCodeGenerateService.getQRCodeImage(urlReal, 360, 360);
        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(qrcode, headers, HttpStatus.CREATED);
    }

    @GetMapping("/file/down")
    public void down(String path, HttpServletResponse response) throws Exception {
        String filename = projectPath + path;
        File file = new File(filename);
        ResponseUtils.responseFileDownload(file, response);
    }


}
