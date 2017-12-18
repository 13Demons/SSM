package com.tian.ssm.postage.mapper;

import com.tian.ssm.postage.bean.Cost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class CostMapperTest {

    @Resource
    private CostMapper costMapper;
    @Test
    public void findCostId() throws Exception {
        Cost cost = new Cost();
        cost.setCostId(5);
        costMapper.findCostId(cost);
    }

    @Test
    public void find()throws Exception{
        Cost cost = new Cost();
        cost.setCostId(1);
        System.out.println(costMapper.findCostId(cost));
    }

}