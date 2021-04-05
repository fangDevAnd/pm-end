package com.fang.pm.sub.security.tools;


import com.fang.pm.sub.security.bean.GrantedAuthorityImpl;
import com.fang.pm.sub.security.bean.JwtAuthenticatioToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * JWT工具类
 *
 * @author Louis
 * @date Jan 14, 2019
 */
@Component
public class JwtTokenUtils implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    private static final String USERNAME = Claims.SUBJECT;
    /**
     * 创建时间
     */
    private static final String CREATED = "created";
    /**
     * 权限列表
     */
    private static final String AUTHORITIES = "authorities";
    /**
     * 密钥
     */
    private static final String SECRET = "abcdefgh";


    /**
     * 生成令牌
     *
     * @param authentication 用户
     * @return 令牌
     */
    public static String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>(3);
        claims.put(USERNAME, SecurityUtils.getUsername(authentication));//获得用户名
        claims.put(CREATED, new Date());
        claims.put(AUTHORITIES, authentication.getAuthorities());//获得当前的权限
        return generateToken(claims, authentication);
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private static String generateToken(Map<String, Object> claims, Authentication authentication) {
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, SECRET).compact();
        userInfoDao.saveToken(token, authentication);
        return token;
    }

    private static UserInfoDao userInfoDao;

    @Autowired
    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }


    /**
     * 根据请求令牌获取登录认证信息
     *
     * @param request 令牌
     * @return 用户名
     */
    public static Authentication getAuthenticationeFromToken(HttpServletRequest request) {
        Authentication authentication = null;
        // 获取请求携带的令牌
        String token = JwtTokenUtils.getToken(request);
        if (token != null) {
            // 请求令牌不能为空
            // 上下文中Authentication为空
            authentication = userInfoDao.getSysUseer(token);
            if (authentication != null) {
                userInfoDao.flushTokenTime(token);
            }
        }
        return authentication;
    }


    /**
     * 获取请求token
     *
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String tokenHead = "Bearer ";
        if (token == null) {
            token = request.getHeader("token");
        } else if (token.contains(tokenHead)) {
            token = token.substring(tokenHead.length());
        }
        if ("".equals(token)) {
            token = null;
        }
        return token;
    }

}