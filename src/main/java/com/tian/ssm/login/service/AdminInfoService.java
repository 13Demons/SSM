package com.tian.ssm.login.service;

import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.login.bean.AdminRole;
import com.tian.ssm.management.bean.ModuleInfo;
import com.tian.ssm.management.bean.RoleInfo;

import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */

public interface AdminInfoService {
    //登录
    AdminInfo loginAdmin(AdminInfo adminInfo);
    //管理员查看
    List<AdminInfo> find(AdminInfo adminInfo,String roleName,Integer moduleId);

    //添加管理员
    String addAdmin(AdminInfo adminInfo,String Pwd,Integer[] roleId);

    //删除管理员
    String deleteAdmin(AdminInfo admin);

    //修改管理员
    String updateAdmin(AdminInfo adminInfo,Integer[] roleId);

    //查找admin_info
    List<AdminInfo> find_Admin(Integer adminId);

    //查找中间表admin_role
    List<AdminRole> find_AdminR(Integer adminId);

    //Module查询
    List<ModuleInfo> find_ModuleInfo();

}
