package com.tian.ssm.management.service;


import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.mapper.RoleInfoMapper;

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
public class RoleInfoServiceTest {


    @Resource
    private RoleInfoMapper roleInfoMapper;

    @Test
    public void findAllRole() throws Exception {
        roleInfoMapper.findAllRole(new RoleInfo()).forEach(System.out::println);
    }



    @Test
    public void addRole() throws Exception {
        roleInfoMapper.addRole(new RoleInfo("ddd"));
    }
    @Test
    public void addModu()throws Exception {
       RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleName("ad");
        roleInfoMapper.addRole(roleInfo);
        System.out.println(roleInfo.getRoleId());

    }
    @Test
    public void findName() throws Exception {
        roleInfoMapper.findName(new RoleInfo("aaa"));
    }

    @Test
    public void deleteName() throws Exception {
        roleInfoMapper.deleteName(new RoleInfo("qq"));
    }

    @Test
    public void findId() throws Exception {
        roleInfoMapper.findId(new RoleInfo(100));
    }


}