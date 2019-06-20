package com.luochuan.j1902_0610.shiro;

import com.luochuan.j1902_0610.pojo.SysPermission;
import com.luochuan.j1902_0610.pojo.SysUser;
import com.luochuan.j1902_0610.service.SysPermissionService;
import com.luochuan.j1902_0610.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /*
    *
    * 获取授权信息对象
    *
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户名
        String principal= (String) principals.getPrimaryPrincipal();
        //根据用户名查询用户权限
        Set<SysPermission> sysPermissions=sysPermissionService.selectSysPermsByName(principal);
        Set<String> perms=new HashSet<>();
        if(sysPermissions!=null){
            for (SysPermission sp:sysPermissions
                 ) {
                perms.add(sp.getPermName());
            }
        }
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(perms);
        return authorizationInfo;
    }
    /**
     *
     * 认证信息
     *
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username= (String) token.getPrincipal();
        SysUser sysUser= sysUserService.selectUserByUserName(username);
        SimpleAuthenticationInfo authenticationInfo=null;
        if(sysUser!=null){
            System.out.println(this.getName());
            authenticationInfo=new SimpleAuthenticationInfo(username,sysUser.getPassword(),this.getName());
        }

        return authenticationInfo;
    }
}
