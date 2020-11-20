package com.fang.pm.controll;


import com.fang.pm.entity.resp.Result;
import com.fang.pm.util.QrCodeGenerateService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Value("${project.rootUrl}")
    String rootPath;

    @Value("${server.port}")
    String port;


    /**
     * 列出当前的项目
     *
     * @return
     */
    @RequestMapping("/list/dir")
    public Result listProject() throws Exception {

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
                Arrays.sort(childFile, (one, two) -> (int) (two.lastModified() - one.lastModified()));
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
    public ResponseEntity<byte[]> getQRImage(String url) throws IOException, WriterException {
        String urlReal = rootPath + ":" + port + "/pm/file/down?path=" + url;
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
        if (file.exists() && file.isFile()) {

            // 如果文件存在，则进行下载
            if (file.exists()) {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(path, "UTF-8"));

                response.addHeader("Content-Length", "" + file.length());
                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
