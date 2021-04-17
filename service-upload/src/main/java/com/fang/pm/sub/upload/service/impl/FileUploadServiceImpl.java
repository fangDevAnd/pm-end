package com.fang.pm.sub.upload.service.impl;

import com.fang.pm.sub.base.base.ResponseUtils;
import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.upload.bean.Upload;
import com.fang.pm.sub.upload.config.UploadProperties;
import com.fang.pm.sub.upload.mapper.UploadFileMapper;
import com.fang.pm.sub.upload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件存储的url
 *
 * @author fang
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    UploadProperties uploadProperties;

    @Autowired
    UploadFileMapper uploadFileMapper;

    @Value("${server.servlet.context-path}")
    private String contentPath;

    @Override
    public Result uploadFile(MultipartFile[] files) throws IOException {
        StringBuilder builder = new StringBuilder("");
        File rootFile = new File(uploadProperties.getFilePath());
        if (!rootFile.exists()) {
            rootFile.mkdir();
        }
        for (MultipartFile file : files) {
            String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File realFile = new File(rootFile, name);
            file.transferTo(realFile);
            builder.append(contentPath + uploadProperties.getFileUrl() + name).append(",");
        }
        String urls = builder.toString();
        Upload upload = new Upload();
        upload.setUrls(urls.substring(0, urls.length() - 1));
        uploadFileMapper.insert(upload);
        return new Result().setCode(Result.CODE_SUCCESS).setData(upload.getId());
    }

    /**
     * 文件下载
     *
     * @param url
     */
    @Override
    public void down(String url, HttpServletResponse response) throws UnsupportedEncodingException {
        url = url.replace(uploadProperties.getFileUrl(), uploadProperties.getFilePath());
        File file = new File(url);
        ResponseUtils.responseFileDownload(file, response);
    }

    @Override
    public Upload url(Integer id) {
        return uploadFileMapper.find(id);
    }


}
