package com.luochuan.j1902_0610;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class J19020610ApplicationTests {

    @Test
    public void contextLoads() {
        Md5Hash md5Hash=new Md5Hash("admin",null,1024);
        System.out.println(md5Hash.toString());

    }

}
