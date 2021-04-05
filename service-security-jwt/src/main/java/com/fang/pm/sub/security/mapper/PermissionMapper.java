package com.fang.pm.sub.security.mapper;

import java.util.Set;

public interface PermissionMapper {

    Set<String> findPermissions(String name);
}
