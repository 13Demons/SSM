package com.tian.ssm.postage.controller;

import com.tian.ssm.login.service.AdminInfoService;
import com.tian.ssm.login.utils.AjaxResult;
import com.tian.ssm.postage.bean.Cost;
import com.tian.ssm.postage.service.CostService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/12.
 */
@Controller
public class CostController  {

    @Resource(name ="cost")
    private CostService costService;
    @Resource(name = "adminInfo")
    private AdminInfoService adminInfoService;

    @RequestMapping(value = "ind")
    public String i(){
        return "/index";
    }


    //显示 @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping(value = "CostMap")
    @ResponseBody
    public AjaxResult Costlist(@DateTimeFormat(pattern = "yyyy-MM-dd")Cost cost){
        return new AjaxResult(costService.findAllCost(cost));
    }

    @RequestMapping(value = "add_Cost")
    public String costAdd(){
        return "fee/fee_add";
    }







}
