package com.tian.ssm.login.service.impl;

import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.login.bean.AdminRole;
import com.tian.ssm.login.mapper.AdminInfoMapper;
import com.tian.ssm.login.service.AdminInfoService;
import com.tian.ssm.management.bean.ModuleInfo;
import com.tian.ssm.management.mapper.ModuleInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */
@Service("adminInfo")
public class AdminInfoServiceImpl implements AdminInfoService {

    @Resource
    private AdminInfoMapper adminInfoMapper;


    @Override
    public AdminInfo loginAdmin(AdminInfo adminInfo) {
        return adminInfoMapper.loginAdmin(adminInfo);
    }

    //查询全部
    @Override
    public List<AdminInfo> find(AdminInfo adminInfo,String roleName,Integer moduleId) {
        String name = "%" + roleName + "%";
        return adminInfoMapper.find(name,moduleId);
    }

    //角色添加
    @Override
    public String addAdmin(AdminInfo adminInfo, String Pwd, Integer[] roleId) {
        //判断输入名字长度
        if (adminInfo.getAdminCode().length() >= 20 || adminInfo.getAdminCode().equals("") ||
                adminInfo.getAdminCode() == null) {
            return "AdminCode_Length";
            //判断账号
        }
        if (adminInfo.getName().length() > 30 || adminInfo.getName().equals("") || adminInfo.getName() == null) {
            return "AdminName_Length";
            //判断密码
        }
        if (adminInfo.getPassword().length() > 30 || adminInfo.getPassword().equals("") || adminInfo.getPassword() == null) {
            return "AdminPwd_Length";
            //判断确认密码
        }
        if (!adminInfo.getPassword().equals(Pwd)) {
            return "AdminPwd_Equals";
            //电话号
        }
        if ("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$".equals(adminInfo.getTelephone())
                || ("^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\\\\d{8}$").equals(adminInfo.getTelephone())
                || "".equals(adminInfo.getTelephone())||adminInfo.getTelephone().length()>11||adminInfo.getTelephone().length()<7) {
            return "Admin_Telephone";
            //确认邮箱
        }
        if ("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$".equals(adminInfo.getEmail())
                || "".equals(adminInfo.getEmail())||("^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$").equals(adminInfo.getEmail())) {
            return "Admin_Email";
            //判断角色是否选中
        }
        if (roleId[0] == 0) {
            return "roleError";
        } else {
            adminInfo.setEnrolldate(new Date());

            adminInfoMapper.addAdmin(adminInfo);
            for (int i = 0; i < roleId.length; i++) {
                Integer integer = roleId[i];
                adminInfoMapper.addAdminRole(adminInfo.getAdminId(), integer);
            }
            return "success";
        }
    }

    //删除管理
    @Override
    public String deleteAdmin(AdminInfo admin) {
        List<AdminRole> adminAndRole = adminInfoMapper.findAdminAndRole(admin);
        adminInfoMapper.deleteRole_Info(adminAndRole);
        adminInfoMapper.deleteRoleModule(adminAndRole);
        adminInfoMapper.deleteAdmin_role(admin);
        adminInfoMapper.deleteAdmin(admin);
        return "success";
    }

    //回显admin
    @Override
    public List<AdminInfo> find_Admin(Integer adminId) {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminId(adminId);
        return adminInfoMapper.find_Admin(adminInfo);
    }

    //回显role
    @Override
    public List<AdminRole> find_AdminR(Integer adminId) {
        return adminInfoMapper.find_AdminR(adminId);
    }

    @Override
    public List<ModuleInfo> find_ModuleInfo() {
        return adminInfoMapper.find_ModuleInfo();
    }

    //修改密码
    @Override
    public String updateAdmin(AdminInfo adminInfo,String Pwd) {
        if (adminInfo.getPassword().length() > 30 || adminInfo.getPassword().equals("") || adminInfo.getPassword() == null) {
            return "AdminPassword";
        }
        if (adminInfo.getPassword().length() > 30 || adminInfo.getPassword().equals("") || adminInfo.getPassword() == null) {
            return "AdminPassword1";
        }
        if (!adminInfo.getPassword().equals(Pwd)) {
            return "AdminPwd";
        }
        adminInfoMapper.updateAdmin(adminInfo);
        return "success";
    }



    //个人信息回显
    @Override
    public AdminInfo EchoAdmin(AdminInfo adminInfo) {
        return adminInfoMapper.EchoAdmin(adminInfo);
    }

    //修改个人信息
    @Override
    public String updateEcho(AdminInfo adminInfo) {
        if (adminInfo.getName().length() > 30 || adminInfo.getName().equals("") || adminInfo.getName() == null) {
            return "Admin_Name";
        }if (adminInfo.getTelephone().length()>11||adminInfo.getTelephone().length()<7||
                adminInfo.getTelephone().equals("\"^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8})|(0\\\\d{2}-\\\\d{8})|(0\\\\d{3}-\\\\d{7})$")){
            return "Admin_Tele";
        }if (adminInfo.getEmail().length()>50||adminInfo.getEmail().equals("")||adminInfo.getEmail().equals("\"^([a-z0-9A-Z]+[-|_|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$\"")){
            return "Admin_Email";
        }
       adminInfoMapper.updateEcho(adminInfo);
        return "success";
    }


    //修改
    @Override
    public String updateAdmin(AdminInfo adminInfo, Integer[] roleId) {
        //判断姓名
        if (adminInfo.getAdminCode().length() > 20 || adminInfo.getAdminCode().equals("") || adminInfo.getAdminCode() == null) {
            return "AdminCode_Length";
            //电话号
        } else if ("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$".equals(adminInfo.getTelephone())
                || ("^(0\\d{2}-\\d{8}(-\\d{1,4})?)" + "|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$").equals(adminInfo.getTelephone())
                || "".equals(adminInfo.getTelephone())) {
            return "Admin_Telephone";
            //确认邮箱
        } else if (("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+" +
                "(\\.[a-zA-Z0-9_-]+)+$").equals(adminInfo.getEmail())
                || "".equals(adminInfo.getEmail())) {
            return "Admin_Email";
            //判断角色是否选中
        } else if (roleId[0] == 0) {
            return "roleError";
        } else {
            adminInfoMapper.updateA(adminInfo);
            adminInfoMapper.deleteAR(adminInfo.getAdminId());
            for (Integer integer : roleId) {
                adminInfoMapper.addAdminRole(adminInfo.getAdminId(),integer);
            }
            return "success";
        }
    }


}