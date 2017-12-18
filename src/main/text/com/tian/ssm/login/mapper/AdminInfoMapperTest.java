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
    public void vagueAdmin() throws Exception {

    }


    @Test
    public void find_AdminR() throws Exception {
        adminInfoMapper.find_AdminR(2000).forEach(System.out::println);
    }


    @Resource
    private AdminInfoMapper adminInfoMapper;
    @Test
    public void find_Admin() throws Exception {
//        AdminInfo adminInfo = new AdminInfo();
//        adminInfo.setAdminId(5000);
        adminInfoMapper.find_Admin(5000).forEach(System.out::println);
    }

    @Test
    public void find() throws Exception {
        adminInfoMapper.find("%qqq%",-1).forEach(System.out::println);
    }


}