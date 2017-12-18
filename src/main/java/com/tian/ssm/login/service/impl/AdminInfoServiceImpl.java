package com.tian.ssm.login.service.impl;

import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.login.bean.AdminRole;
import com.tian.ssm.login.mapper.AdminInfoMapper;
import com.tian.ssm.login.service.AdminInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public List<AdminInfo> find(AdminInfo adminInfo) {
        return adminInfoMapper.find(adminInfo);
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
                || ("^(0\\d{2}-\\d{8}(-\\d{1,4})?)" + "|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$").equals(adminInfo.getTelephone())
                || "".equals(adminInfo.getTelephone())) {
            return "Admin_Telephone";
            //确认邮箱
        }
        if ("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$".equals(adminInfo.getEmail())
                || "".equals(adminInfo.getEmail())) {
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
        return adminInfoMapper.find_Admin(adminId);
    }

    //回显role
    @Override
    public List<AdminRole> find_AdminR(Integer adminId) {
        return adminInfoMapper.find_AdminR(adminId);
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
        } else if ("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$".equals(adminInfo.getEmail())
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