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
    @Test
    public void updateCost() throws Exception {
        Cost cost = new Cost();
        cost.setCostId(20);
        cost.setCostName("ooj");
        cost.setBaseDuration(45);
        cost.setBaseCost(45);
        cost.setUnitCost(45);
        cost.setDescr("sdsdsds");
        costMapper.updateCost(cost);
    }

    @Test
    public void insert() throws Exception {
        costMapper.insert(new Cost("rr",20,20,20,"tt"));
    }

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


    @Test
    public void baseClass() throws Exception {
        costMapper.baseClass().forEach(System.out::println);
    }

    @Test
    public void base_Class() throws Exception {
        costMapper.Baselarge().forEach(System.out::println);
    }

    @Test
    public void timelength() throws Exception {
        costMapper.Timelength().forEach(System.out::println);
    }

    @Test
    public void time_length() throws Exception {
        costMapper.Timelarge().forEach(System.out::println);
    }



}