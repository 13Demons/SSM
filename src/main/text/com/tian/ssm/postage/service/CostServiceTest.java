package com.tian.ssm.postage.service;

import com.tian.ssm.postage.bean.Cost;
import com.tian.ssm.postage.mapper.CostMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class CostServiceTest {

    @Resource
    private CostMapper costMapper;

    @Test
    public void findAllCost() throws Exception {
        costMapper.findAllCost(new Cost()).forEach(System.out::println);
    }

}