package com.fang.pm.sub.security;

import com.fang.pm.sub.security.tools.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {


    @Test
    void contextLoads() {

        String pwd = new PasswordEncoder("123").encode("123");
        System.out.println(pwd);
    }

}
