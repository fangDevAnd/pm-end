package com.fang.pm.sub.security.bean;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 自定义令牌对象
 * <p>
 * 继承了  UsernamePasswordAuthenticationToken  这个是系统的默认的实现 ，默认请求传递的数据会被封装为 UsernamePasswordAuthenticationToken
 * <p>
 * 进行认证
 *
 * @author Louis
 * @date Jan 14, 2019
 */
public class JwtAuthenticatioToken extends UsernamePasswordAuthenticationToken {

    private String token;

    public JwtAuthenticatioToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtAuthenticatioToken(Object principal, Object credentials, String token) {
        super(principal, credentials);
        this.token = token;
    }

    public JwtAuthenticatioToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
