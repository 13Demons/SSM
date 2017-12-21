package com.tian.ssm.postage.mapper;

import com.tian.ssm.postage.bean.Cost;

import java.util.List;

public interface CostMapper {

    //Cost添加
    void insert(Cost cost);

    int insertSelective(Cost record);
    
    //查看所有信息
    List<Cost> findAllCost(Cost cost);

    //删除Cost
    Integer deleteCost(Integer costId);

    //显示详情
    List<Cost> findCostId(Cost cost);

    //基费从小到大
    List<Cost> baseClass();

    //基费从大到小
    List<Cost> Baselarge();

    //时长从小到大
    List<Cost> Timelength ();

    //时长从大到小
    List<Cost> Timelarge();

    //修改
    void updateCost(Cost cost);



}