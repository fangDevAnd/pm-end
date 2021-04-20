package com.fang.pm.sub.tableGenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {
        "com.fang.pm.sub.tableGenerator.mapper"
})
public class TableGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TableGeneratorApplication.class, args);
    }

}
