package com.fang.pm.sub.security.config;

import com.fang.pm.sub.security.bean.JwtUserDetails;
import com.fang.pm.sub.security.tools.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 身份验证提供者
 *
 * @author Louis
 * @date Jan 14, 2019
 * <p>
 * <p>
 * DaoAuthenticationProvider 是springsecurity 默认的实现
 */
public class JwtAuthenticationProvider extends DaoAuthenticationProvider {

    public JwtAuthenticationProvider(UserDetailsService userDetailsService) {

        //设置当前的认证提供者 的 用户详情数据查询的 服务为植注入的服务
        setUserDetailsService(userDetailsService);
    }

    /**
     * 只要不去抛出异常，就是代表了登录成功
     *
     * @param userDetails    封装了 用户详情数据的 ，使用的就是 我们设置的userDetailService 加载的数据
     * @param authentication 传递的数据
     * @throws AuthenticationException
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }
        String presentedPassword = authentication.getCredentials().toString();
        String salt = ((JwtUserDetails) userDetails).getSalt();
        // 覆写密码验证逻辑
        if (!new PasswordEncoder(salt).matches(userDetails.getPassword(), presentedPassword)) {
            logger.debug("Authentication failed: password does not match stored value");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }
    }

}