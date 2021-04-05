package com.fang.pm.sub.upload.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class UploadWebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加cros支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
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
    UploadProperties properties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "file://" + properties.getFilePath();
        registry.addResourceHandler(properties.getFileUrl() + "**")
                .addResourceLocations(path);

    }
}
