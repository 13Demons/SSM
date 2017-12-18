package com.tian.ssm.postage.service.impl;

import com.tian.ssm.postage.bean.Cost;
import com.tian.ssm.postage.mapper.CostMapper;
import com.tian.ssm.postage.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/12.
 */
@Service("cost")
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    //查询Cost
    @Override
    public List<Cost> findAllCost(Cost cost) {
        return costMapper.findAllCost(cost);
    }

    //删除Cost
    @Override
    public Integer deleteCost(Integer costId) {
        return costMapper.deleteCost(costId);
    }

    @Override
    public List<Cost> findCostId(Integer costId) {
        Cost cost = new Cost();
        cost.setCostId(costId);
        return costMapper.findCostId(cost);
    }

}
