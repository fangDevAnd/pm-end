package com.fang.pm.sub.security.tools;

import com.fang.pm.sub.security.bean.JwtAuthenticatioToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * Security相关操作
 *
 * @author Louis
 * @date Jan 14, 2019
 */
public class SecurityUtils {

    /**
     * 系统登录认证
     *
     * @param request
     * @param username
     * @param password
     * @param authenticationManager
     * @return
     */
    public static JwtAuthenticatioToken login(HttpServletRequest request, String username,
                                              String password, AuthenticationManager authenticationManager) {
        JwtAuthenticatioToken token = new JwtAuthenticatioToken(username, password);

        /**
         *
         * WebAuthenticationDetailsSource  本身没有什么东西  ，buildDetails 返回了相关的
         * request 信息。
         *
         *
         */
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        /**
         *
         *
         * authenticationManager内部会去加载　认证提供者，　--->调用　UserDetailsService　的实现，进行登录
         *
         *
         * 实现是
         * {@link org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider}
         *
         *  底层调用了 {@link org.springframework.security.core.userdetails.UserDetailsService} 的实现加载用户的信息。
         *
         *
         *
         */
        // 执行登录认证过程
        Authentication authentication = authenticationManager.authenticate(token);
        // 认证成功存储认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成令牌并返回给客户端
        token.setToken(JwtTokenUtils.generateToken(authentication));
        return token;
    }

    /**
     * 获取令牌进行认证
     *
     * @param request
     */
    public static void checkAuthentication(HttpServletRequest request) {
        // 获取令牌并根据令牌获取登录认证信息
        Authentication authentication = JwtTokenUtils.getAuthenticationeFromToken(request);
        // 设置登录认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    
    /**
     * 获取用户名
     *
     * @return
     */
    public static String getUsername(Authentication authentication) {
        String username = null;
        if (authentication != null) {
            Object principal = authentication.getPrincipal();//获得用户名称
            if (principal != null && principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            }
        }
        return username;
    }

    /**
     * 获取当前登录信息
     *
     * @return
     */
    public static Authentication getAuthentication() {
        if (SecurityContextHolder.getContext() == null) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

}
