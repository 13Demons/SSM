package com.tian.ssm.login.service;

import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.login.mapper.AdminInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by dllo on 17/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class AdminInfoServiceTest {



    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Test
    public void loginAdmin() throws Exception {
        System.out.println(adminInfoMapper.loginAdmin(new AdminInfo("123","123")));
    }

    @Test
    public void find() throws Exception {
        System.out.println(adminInfoMapper.find(new AdminInfo()));
    }


}