package com.luochuan.j1902_0610.controller;

import com.luochuan.j1902_0610.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
public class UserController {
    /**
     *
     * 显示登陆试图
     *
     * */
    @RequestMapping("/login")
    public String loginview(){
        return "login";
    }
    /**
     *
     * 显示登录失败页面
     *
     * */
    @RequestMapping(value = "/dealLogin",method = RequestMethod.POST)
    public String dealLogin(UserVo userVo){
        try {

            System.out.println("controller");
            //构建令牌
            UsernamePasswordToken token=new UsernamePasswordToken(userVo.getUsername(),userVo.getPassword());

            //获取subject
            Subject subject=SecurityUtils.getSubject();
            //登录
            subject.login(token);
            //是否通过验证
            if(subject.isAuthenticated()){
                return "main";
            }
        }catch (Exception e){
            System.out.println("登陆失败");
            e.printStackTrace();
        }

        return "login";
    }
    /**
     *
     * 显示main试图
     *
     * */
    @RequiresPermissions("authc")
    @RequestMapping("/main")
    public String mainView(){
        return "main";
    }
    /**
     *
     * 无权访问试图
     *
     * */
    @RequestMapping("/unauth")
    public String unauthView(){
        return "unauth";
    }
    /**
     *
     * 显示one试图
     *
     * */
    @RequiresPermissions("user_edit")
    @RequestMapping("/one")
    public String oneView(){
        return "one";
    }
    /**
     *
     * 显示two试图
     *
     * */
    @RequiresPermissions("user_forbidden")
    @RequestMapping("/two")
    public String twoView(){
        return "two";
    }

    @RequestMapping("/logout")
    public String logoutView(){
        try {
            Subject subject=SecurityUtils.getSubject();
            subject.logout();
        }catch (Exception e){

        }
        return "redirect:login";
    }
}
