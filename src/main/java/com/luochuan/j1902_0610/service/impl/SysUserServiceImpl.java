package com.luochuan.j1902_0610.service.impl;

import com.luochuan.j1902_0610.mapper.SysUserMapper;
import com.luochuan.j1902_0610.pojo.SysUser;
import com.luochuan.j1902_0610.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUserName(String username) {

        return sysUserMapper.findUserByLoginName(username);
    }
}
