package com.luochuan.j1902_0610.service;

import com.luochuan.j1902_0610.pojo.SysPermission;

import java.util.Set;

public interface SysPermissionService {
    public Set<SysPermission> selectSysPermsByName(String username);
}
