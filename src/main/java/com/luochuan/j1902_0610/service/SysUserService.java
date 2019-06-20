package com.luochuan.j1902_0610.service;

import com.luochuan.j1902_0610.pojo.SysUser;

public interface SysUserService {
    /**
     *
     * 根据用户名查询用户信息
     * */
    public SysUser selectUserByUserName(String username);
}
