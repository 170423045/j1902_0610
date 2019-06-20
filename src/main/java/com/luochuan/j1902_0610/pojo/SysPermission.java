package com.luochuan.j1902_0610.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class SysPermission implements Serializable {
    private int permId;
    private String permName;//权限名称
    private String permUrl;//权限操作地址（路径）
    private String menuName;//菜单名
    private String menuLevel;//菜单级别（11：一级；12：二级。。。）
    private String menuCode;//菜单编码（每级两位数字）
    private int ifValid;
    private String parentCode;

}
