package com.tian.ssm.management.controller;

import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.login.bean.AdminRole;
import com.tian.ssm.login.service.AdminInfoService;
import com.tian.ssm.login.utils.AjaxResult;
import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.service.RoleInfoService;
import com.tian.ssm.management.service.RoleModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by dllo on 17/12/9.
 */
@Controller
public class ManagementController {

    @Resource(name = "roleInfo")
    private RoleInfoService roleInfoService;


    @Resource(name = "roleModule")
    private RoleModuleService roleModuleService;

    @Resource(name = "adminInfo")
    private AdminInfoService adminInfoService;


    @RequestMapping(value = "Index")
    //必须要有注解
    @ResponseBody
    public String admin1() {
        return "success";
    }

    @RequestMapping(value = "List")
    public String admin() {
        return "index";
    }

    //显示
    @RequestMapping(value = "/ReleMan")
    @ResponseBody
    public AjaxResult Role(RoleInfo roleInfo) {
        return new AjaxResult(roleInfoService.findAllRole(roleInfo));

    }

    @RequestMapping(value = "/role_add")
    public String add() {
        return "/role/role_add";
    }


    //添加
    @RequestMapping(value = "add_add")
    @ResponseBody
    public String addRole(RoleInfo roleInfo, Integer[] moduleId) {
        return roleInfoService.addRole(roleInfo, moduleId);
    }

    @RequestMapping(value = "roles")
    public String R() {
        return "/role/role_list";
    }


    //删除
    @RequestMapping(value = "delete_Role")
    @ResponseBody
    public String deleteRole(RoleInfo roleInfo) {
        //删除中间表
        roleModuleService.delRoleInMiddleTable(roleInfo);
        //删除Id
        roleInfoService.delete(roleInfo.getRoleId());
        return "deleteRole";
    }


    @RequestMapping(value = "role_list")
    public String deletR() {
        return "/role/role_list";
    }


    @RequestMapping("/list")
    public String list() {
        return "role/role_list";
    }


    @RequestMapping("/update")
    @ResponseBody
    public String updateR(RoleInfo role, HttpSession session) {
        session.setAttribute("roleId", role.getRoleId());
        return "success";
    }

    //跳转到修改页面
    @RequestMapping("/up")
    public String up() {
        return "/role/role_modi";
    }


    //修改角色
    @RequestMapping("/updateRole")
    @ResponseBody
    public RoleInfo updateRole(RoleInfo roleInfo, int[] module) {
        roleInfoService.updateRole(roleInfo);
        roleInfoService.deleteRoleModule(roleInfo.getRoleId());
        roleInfoService.addRoleModule(roleInfo.getRoleId(), module);
        return roleInfo;
    }

    //回显
    @RequestMapping(value = "/echo", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String echo(HttpSession session) {
        int roleId = (int) session.getAttribute("roleId");
        List<RoleInfo> ids = roleInfoService.findNameById(roleId);
        return ids.get(0).getRoleName();
    }


    //管理添加
    @RequestMapping(value = "/addAdmin")
    @ResponseBody
    public String addAdmin(AdminInfo adminInfo, String Pwd, Integer[] roleId) {
        String addAdmin = adminInfoService.addAdmin(adminInfo, Pwd, roleId);
        return addAdmin;
    }

    //删除管理
    @RequestMapping(value = "/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(AdminInfo adminInfo) {
        return adminInfoService.deleteAdmin(adminInfo);
    }

    //管理回显
    @RequestMapping(value = "/EchoAdmin")
    @ResponseBody
    public List<AdminInfo> EchoAdmin(HttpSession session) {
        Integer adminId = (Integer) session.getAttribute("adminId");
        List<AdminInfo> admin = adminInfoService.find_Admin(adminId);
        return admin;
    }

    //管理回显中间表
    @RequestMapping(value = "/EchoAdminR")
    @ResponseBody
    public List<AdminRole> EchoAdminR(HttpSession session) {
        Integer adminId = (Integer) session.getAttribute("adminId");
        return adminInfoService.find_AdminR(adminId);
    }

    //管理修改
    @RequestMapping(value = "/updateAdmin")
    @ResponseBody
    public String updateAdmin(AdminInfo adminInfo, Integer[] roleId, HttpSession session) {
        adminInfo.setAdminId((Integer) session.getAttribute("adminId"));
        System.out.println(adminInfo);
        for (Integer integer : roleId) {
            System.out.println(integer);
        }
        return adminInfoService.updateAdmin(adminInfo, roleId);
    }

    //下拉模块查询(权限)
    @RequestMapping(value = "/find_ModuleInfo")
    @ResponseBody
    public AjaxResult findModuleInfo() {
        return new AjaxResult(adminInfoService.find_ModuleInfo());
    }




}
