package com.fang.pm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加cros支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedHeaders();
    }
    
    /**
     * 添加过滤器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    
    }

    @Autowired
    DependencyCheckProperties dependencyCheckProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        File file = new File(dependencyCheckProperties.getFileRootPath());
        //添加文件映射路径为该目录的子目录
        for (String fileName : file.list()) {
            String path = "file://" + new File(file, fileName).getAbsolutePath() + "/";
            registry.addResourceHandler("/" + fileName + "/*.html")
                    .addResourceLocations(path);
        }
    }
}
