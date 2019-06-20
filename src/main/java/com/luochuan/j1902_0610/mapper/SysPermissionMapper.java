package com.luochuan.j1902_0610.mapper;

import com.luochuan.j1902_0610.pojo.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 *
 * */
@Mapper
public interface SysPermissionMapper {
    public List<SysPermission> findPermsByUserName(@Param("loginName")String loginName);
}
