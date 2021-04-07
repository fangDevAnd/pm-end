package com.fang.pm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fang
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.fang.pm.dao",
        "com.fang.pm.sub.crm.mapper",
        "com.fang.pm.sub.upload.mapper",
        "com.fang.pm.sub.security.mapper"
})
public class PmApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmApplication.class, args);
    }

}
