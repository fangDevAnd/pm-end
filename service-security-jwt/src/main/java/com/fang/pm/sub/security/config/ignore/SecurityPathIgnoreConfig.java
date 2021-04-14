package com.fang.pm.sub.security.config.ignore;

import com.fang.pm.sub.base.base.security.SecurityPathIgnore;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;


@Configuration
public class SecurityPathIgnoreConfig {


    @Bean
    public SecurityPathIgnore securitySecurityPathIgnore() {

        return new SecurityPathIgnore("/webjars/**", "/**/*.html",
                "/userLogin", "/captcha.jpg");
    }

    @Bean
    public SecurityPathIgnore pmSecurityPathIgnore() {
        return new SecurityPathIgnore("/pm/qrimage", "/pm/file/down");
    }


}

