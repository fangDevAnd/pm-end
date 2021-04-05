package com.fang.pm.sub.base.base;


import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 响应类型的url
 */
public class ResponseUtils {


    public static void responseFileDownload(File file, HttpServletResponse response) throws UnsupportedEncodingException {
        // 如果文件存在，则进行下载
        if (file.exists()) {
            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.addHeader("Content-Length", "" + file.length());
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
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


    /**
     * 返回json数据
     *
     * @param response
     * @param status
     * @param info
     */
    public static void responseJson(HttpServletResponse response, HttpServletRequest request, int status, Result info) {
        try {
            setCrosResp(request, response);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(status);
            response.getWriter().write(new Gson().toJson(info));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setCrosResp(HttpServletRequest request, HttpServletResponse response) {
        String originHeader = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", originHeader);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        String header = "Authorization,Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token";
        response.setHeader("Access-Control-Allow-Headers", header);
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }


}
