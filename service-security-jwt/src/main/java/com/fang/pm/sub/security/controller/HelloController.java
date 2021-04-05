package com.fang.pm.sub.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello() {
        return "sdsfsdgfsdf";
    }


}
