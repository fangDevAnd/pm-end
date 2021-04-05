package com.fang.pm.sub.security.tools;

import com.fang.pm.sub.base.base.bean.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 存放用户token信息的dao
 */
@Component
public class UserInfoDao {


    @Autowired
    RedisTemplate redisTemplate;


    public static final int EXPRES_TIME_MINUTE = 5;

    public void saveToken(String token, Authentication sysUser) {
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set(token, sysUser, 5, TimeUnit.MINUTES);
    }

    public Authentication getSysUseer(String token) {
        ValueOperations operations = redisTemplate.opsForValue();
        return (Authentication) operations.get(token);
    }

    public void flushTokenTime(String token) {
        redisTemplate.expire(token, EXPRES_TIME_MINUTE, TimeUnit.MINUTES);
    }

    public void del(String token) {
        redisTemplate.delete(token);
    }


}
