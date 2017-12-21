package com.tian.ssm.postage.service.impl;

import com.tian.ssm.postage.bean.Cost;
import com.tian.ssm.postage.mapper.CostMapper;
import com.tian.ssm.postage.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Override
    public List<Cost> baseClass() {
        return costMapper.baseClass();
    }

    @Override
    public List<Cost> Baselarge() {
        return costMapper.Baselarge();
    }

    @Override
    public List<Cost> Timelength() {
        return costMapper.Timelength();
    }

    @Override
    public List<Cost> Timelarge() {
        return costMapper.Timelarge();
    }

    @Override
    public String insert(Cost cost) {
//        if (cost.getCostName().equals("")||cost.getCostName().length()>50){
//            //资费名称
//            return "CostName";
//        }else if (cost.getBaseDuration().equals("")||
//                cost.getBaseDuration().equals("^([1-6]\\d{0,3}|100)$")){
//            //基本时长
//            return "BaseDuration";
//        }else if (cost.getBaseCost().equals("")||cost.getBaseCost().equals("^\\d{1,5}(\\.\\d{1,2})?$")){
//            //基本费用
//            return "BaseCost";
//        }else if (cost.getUnitCost().equals("")||cost.getUnitCost().equals("^\\d{1,5}(\\.\\d{1,2})?$")){
//            //单位费用
//            return "UnitCost";
//        }else if (cost.getDescr().equals("")||cost.getDescr().length()>100){
//            //资费说明
//            return "Descr";
//        }
        //添加
        Cost cost1= new Cost();
        cost1.setCreatime(new Date());
        cost.setCreatime(cost1.getCreatime());
        costMapper.insert(cost);
        return "success";
    }

    //修改Cost
    @Override
    public String updateCost(Cost cost) {
        cost.setStartime(new Date());
        costMapper.updateCost(cost);
        return "success";
    }


}
