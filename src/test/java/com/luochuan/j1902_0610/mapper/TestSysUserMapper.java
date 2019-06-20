package com.luochuan.j1902_0610.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Configuration("com.luochuan.j1902_0610.mapper")
public class TestSysUserMapper {
    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void test(){

        System.out.println(sysUserMapper.findUserByLoginName("admin"));
    }
}
