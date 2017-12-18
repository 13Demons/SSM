package com.tian.ssm.postage.service;

import com.tian.ssm.postage.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/12/12.
 */

public interface CostService {

    List<Cost> findAllCost(Cost cost);
}
