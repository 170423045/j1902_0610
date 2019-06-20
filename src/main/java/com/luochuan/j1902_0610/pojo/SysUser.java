package com.luochuan.j1902_0610.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysUser implements Serializable {
    /**
     *
     */
//    private static final long serialVersionUID = -4196181599263518127L;
    private  int userid;//用户id
    private String username;//用户实名
    private String password;//
    private String loginName;//登录名
    private Date createTime;
    private String realname;
    private int state; //状态
//    private int ifValid;//是否有效（1：有效；0：无效）
//    private int ifHidden;//是否隐藏（1：不隐藏；0：隐藏）




}
