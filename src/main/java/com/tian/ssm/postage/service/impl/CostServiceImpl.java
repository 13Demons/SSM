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

    @Override
    public List<Cost> findAllCost(Cost cost) {
        return costMapper.findAllCost(cost);
    }
}
