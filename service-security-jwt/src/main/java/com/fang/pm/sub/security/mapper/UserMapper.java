package com.fang.pm.sub.security.mapper;

import com.fang.pm.sub.base.base.bean.SysUser;

public interface UserMapper {
    SysUser findByName(String username);
}
