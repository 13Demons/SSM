package com.tian.ssm.login.mapper;

import com.tian.ssm.login.bean.AdminInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class AdminInfoMapperTest {
    @Test
    public void updateEcho() throws Exception {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminId(2000);
        adminInfo.setName("666");
        adminInfo.setTelephone("15046496784");
        adminInfo.setEmail("578274855@qq.com");
        adminInfoMapper.updateEcho(adminInfo);
    }

    @Test
    public void loginAdmin() throws Exception {
        AdminInfo adminInfo = adminInfoMapper.loginAdmin(new AdminInfo("111", "123"));
        System.out.println(adminInfo);
    }

    @Test
    public void find_AdminR1() throws Exception {
        adminInfoMapper.find_AdminR(2000).forEach(System.out::println);
    }

    @Test
    public void echoAdmin() throws Exception {
        System.out.println(adminInfoMapper.EchoAdmin(new AdminInfo(2000, "")));
    }

    @Test
    public void find_AdminR() throws Exception {
        adminInfoMapper.find_AdminR(2000).forEach(System.out::println);
    }


    @Resource
    private AdminInfoMapper adminInfoMapper;


    @Test
    public void find() throws Exception {
        adminInfoMapper.find("%qqq%",-1).forEach(System.out::println);
    }



}