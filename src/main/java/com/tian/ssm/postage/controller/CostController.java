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
import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/12/12.
 */
@Controller
public class CostController {

    @Resource(name = "cost")
    private CostService costService;
    @Resource(name = "adminInfo")
    private AdminInfoService adminInfoService;

    @RequestMapping(value = "ind")
    public String i() {
        return "/index";
    }


    //显示 @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping(value = "CostMap")
    @ResponseBody
    public AjaxResult Costlist(@DateTimeFormat(pattern = "yyyy-MM-dd") Cost cost) {
        return new AjaxResult(costService.findAllCost(cost));
    }

    @RequestMapping(value = "add_Cost")
    public String costAdd() {
        return "fee/fee_add";
    }

    @RequestMapping(value = "upC")
    @ResponseBody
    public String updateCost1(){
        return "success";
    }


    @RequestMapping(value = "update_Cost")
    public String updateCost(){
        return "fee/fee_modi";
    }

    @RequestMapping(value = "feeAdminInfo")
    @ResponseBody
    public String feeAdmin() {
        return "success";
    }

    @RequestMapping(value = "fee_AdminInfo")
    public String feeAdmin1() {
        return "admin/admin_list";
    }

    @RequestMapping(value = "feeRole")
    @ResponseBody
    public String feeRole() {
        return "success";
    }

    @RequestMapping(value = "fee_Role")
    public String feeRole1() {
        return "role/role_list";
    }


    //删除Cost
    @RequestMapping(value = "deleteCost")
    @ResponseBody
    public String deleteCost(Cost cost) {
        costService.deleteCost(cost.getCostId());
        return "success";
    }

    @RequestMapping(value = "feeList")
    public String feeList1(){
        return "fee/fee_list";
    }

    @RequestMapping(value = "detailsRole")
    @ResponseBody
    public String detailsRole(){
        return "success";
    }

    @RequestMapping(value = "Details_Role")
    public String Details_Role(HttpSession session,Integer costId){
        session.setAttribute("costId",costId);
        return "fee/fee_detail";
    }


    //查询详情(回显)
    @RequestMapping(value = "findCostId")
    @ResponseBody
    public AjaxResult findCostId(HttpSession session){
        Integer costId = (Integer) session.getAttribute("costId");
        System.out.println(costId);
        return new AjaxResult(costService.findCostId(costId));
    }





}
