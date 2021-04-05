package com.fang.pm.sub.upload.service;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.upload.bean.Upload;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 文件存储的url
 *
 * @author fang
 */
public interface FileUploadService {
    public Result uploadFile(MultipartFile[] files) throws IOException;

    void down(String url, HttpServletResponse response) throws UnsupportedEncodingException;

    Upload url(Integer id);

}
