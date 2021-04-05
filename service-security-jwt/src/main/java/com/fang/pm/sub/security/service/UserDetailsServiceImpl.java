package com.fang.pm.sub.security.service;

import com.fang.pm.sub.base.base.bean.SysUser;
import com.fang.pm.sub.security.bean.JwtUserDetails;
import com.fang.pm.sub.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户登录认证信息查询
 *
 * @author Louis
 * @date Jan 14, 2019
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

//    @Autowired
//    PermissionMapper permissionMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userMapper.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        // 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口
//        Set<String> permissions = permissionMapper.findPermissions(user.getName());
//        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(), user.getPassword(), user.getSalt(), null);//暂时不去实现权限功能
    }
}