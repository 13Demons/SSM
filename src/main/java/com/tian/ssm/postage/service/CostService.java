package com.tian.ssm.postage.service;

import com.tian.ssm.postage.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/12/12.
 */

public interface CostService {

    //查询Cost
    List<Cost> findAllCost(Cost cost);

    //删除Cost
    Integer deleteCost(Integer costId);

    //显示详情
    List<Cost> findCostId(Integer costId);


    //基费从小到大
    List<Cost> baseClass();

    //基费从大到小
    List<Cost> Baselarge();

    //时长从小到大
    List<Cost> Timelength ();

    //时长从大到小
    List<Cost> Timelarge();

    //添加Cost
    String insert(Cost cost);

    //修改
    String updateCost(Cost cost);
}
