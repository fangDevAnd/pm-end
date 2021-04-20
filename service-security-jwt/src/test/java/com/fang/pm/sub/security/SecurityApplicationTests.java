package com.fang.pm.sub.security;

import com.fang.pm.sub.security.tools.PasswordEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecurityApplicationTests {


    @Test
    void contextLoads() {

        boolean isMarch = new BCryptPasswordEncoder().matches("AdiwS1357!","$2a$10$7nSccjwQmIAH83BzcBmDXeMfIH541qBNuBktI7hlydzGfSPOGbBx6");
        System.out.println(isMarch);

        //$2a$10$7nSccjwQmIAH83BzcBmDXeMfIH541qBNuBktI7hlydzGfSPOGbBx6
//        $2a$10$BujFG1mZj.mX/SafW/6yPeD7Nitdd33xPLrSQTtTZCPI6nJl2eNhy  admin

    }

}
