package com.tian.ssm.management.service;

import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.mapper.RoleModuleMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class RoleModuleServiceTest {
    @Resource
    private RoleModuleMapper roleModuleMapper;



}