package com.tian.ssm.postage.mapper;

import com.tian.ssm.postage.bean.Cost;

import java.util.List;

public interface CostMapper {
    int insert(Cost record);

    int insertSelective(Cost record);
    
    //查看所有信息
    List<Cost> findAllCost(Cost cost);
}