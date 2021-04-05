package com.fang.pm.sub.security.config;

import com.fang.pm.sub.base.base.ResponseUtils;
import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.security.filter.JwtAuthenticationFilter;

import com.fang.pm.sub.security.tools.JwtTokenUtils;
import com.fang.pm.sub.security.tools.UserInfoDao;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring Security配置
 *
 * @author Louis
 * @date Jan 14, 2019
 */
@Configuration
@EnableWebSecurity    // 开启Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true)    // 开启权限注解，如：@PreAuthorize注解 springSecurity文档给出了，可以参考官方文档
public class SecurityWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件 自定义验证提供者
        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
        http.csrf().disable().
                authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // web jars
                .antMatchers("/webjars/**", "/**/*.html",
                        "/userLogin", "/captcha.jpg").permitAll()
                // 其他所有请求需要身份认证
                .anyRequest().authenticated();
        // 退出登录处理器
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            Result info = new Result().setCode(HttpStatus.UNAUTHORIZED.value()).setMsg("请先登录");
            ResponseUtils.responseJson(response, request, HttpStatus.OK.value(), info);
        });
        // 解决不允许显示在iframe的问题
        http.headers().frameOptions().disable();
        http.headers().cacheControl();

        http.logout().logoutSuccessHandler((request, response, authentication) -> {
            String token = JwtTokenUtils.getToken(request);
            userInfoDao.del(token);
            ResponseUtils.responseJson(response, request, HttpStatus.OK.value(), new Result().setCode(200).setMsg("退出登录成功"));
        });
        // token验证过滤器  在 用户名和密码 认证过滤器之前 添加一个 jwt认证过滤
        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}