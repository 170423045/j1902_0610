package com.luochuan.j1902_0610.service.impl;

import com.luochuan.j1902_0610.mapper.SysPermissionMapper;
import com.luochuan.j1902_0610.pojo.SysPermission;
import com.luochuan.j1902_0610.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    private List<SysPermission> permsByUserName;

    @Override
    public Set<SysPermission> selectSysPermsByName(String username) {
        Set<SysPermission> set=new HashSet<>();
        List<SysPermission> list = sysPermissionMapper.findPermsByUserName(username);
        for (SysPermission per:list
             ) {
            set.add(per);
        }
        return set;
    }
}
