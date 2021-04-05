package com.fang.pm.sub.security.filter;

import com.fang.pm.sub.base.base.ResponseUtils;
import com.fang.pm.sub.security.tools.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录认证过滤器
 * <p>
 * 负责登录时检查并生产令牌  保存到上下文
 *
 * @author Louis
 * @date Jan 14, 2019
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {


    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取token, 并检查登录状态
        SecurityUtils.checkAuthentication(request);
        //添加cros跨域
        ResponseUtils.setCrosResp(request, response);

        chain.doFilter(request, response);
    }

}