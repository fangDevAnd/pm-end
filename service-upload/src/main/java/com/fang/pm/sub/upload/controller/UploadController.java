package com.fang.pm.sub.upload.controller;


import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.upload.service.FileUploadService;
import com.fang.pm.sub.upload.service.impl.FileUploadServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    FileUploadService uploadService;

    /**
     * 文件上传的接口
     * 返回的data 代表的是文件的唯一索引
     *
     * @param files
     * @return
     */
    @RequestMapping("/file")
    public Result uploadFile(@RequestParam("file") MultipartFile[] files) throws IOException {
        return uploadService.uploadFile(files);
    }


    /**
     * 文件的索引id
     *
     * @param url
     * @param response
     * @return
     */
    @PostMapping("/download")
    public void download(String url, HttpServletResponse response) throws UnsupportedEncodingException {
        uploadService.down(url, response);
    }


}
