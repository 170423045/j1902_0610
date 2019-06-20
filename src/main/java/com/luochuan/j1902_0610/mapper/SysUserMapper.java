package com.luochuan.j1902_0610.mapper;

import com.luochuan.j1902_0610.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 *
 *
 * */
@Mapper
public interface SysUserMapper {
    public SysUser findUserByLoginName(@Param("loginName") String loginName);
}
