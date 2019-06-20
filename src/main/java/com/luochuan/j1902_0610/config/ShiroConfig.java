package com.luochuan.j1902_0610.config;

import com.luochuan.j1902_0610.shiro.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /*
    添加凭证匹配器
    * 负责对数据库里加密信息的匹配认证
    *
    *
    * */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=
                new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);//将加密后的字符串转换为16进制字符串
        return hashedCredentialsMatcher;
    }
    @Bean(name = "myRealm")
    public MyRealm getMyRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        System.out.println("myRealm");
        MyRealm myRealm=new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return myRealm;
    }

    /**
     * 注入安全管理器
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm) {
        System.out.println("注入安全管理器");
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }
    /*
     * 注入权限过滤器
     *
     * */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") SecurityManager securityManager) {
        //创建权限过滤器
        System.out.println("注入权限过滤器");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置权限过滤器
        shiroFilterFactoryBean.setSecurityManager(securityManager);//安全管理器，携带权限逻辑
        shiroFilterFactoryBean.setLoginUrl("/login");//登录页
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");//无授权的页面

        Map<String, String> map = new HashMap<>();//通过map集合有区分不同访问权限所能访问的不同页面
//        map.put("/main", "authc");//只有登录后才可访问
//        map.put("/one", "perms[user_edit]");//拥有user_edit的用户才可访问
//        map.put("/two", "perms[user_forbidden]");//拥有user_forbidden的用户才可以访问

//        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);//将定义好的map集合配置进ShiroFilterFactoryBean对象
        return shiroFilterFactoryBean;
    }
    //开解shiro注解扫描
    @Bean
    public DefaultAdvisorAutoProxyCreator  defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=
                new DefaultAdvisorAutoProxyCreator();
        return defaultAdvisorAutoProxyCreator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("defaultWebSecurityManager") SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor
                =new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
