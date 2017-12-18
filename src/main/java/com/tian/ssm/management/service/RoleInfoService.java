package com.tian.ssm.management.service;


import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.bean.RoleModule;

import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */

public interface RoleInfoService {

    List<RoleInfo> findAllRole(RoleInfo roleInfo);

    Integer delete(Integer adminId);

//    String addRole(RoleInfo roleInfo,List<Integer> moduleId);

    String addRole(RoleInfo roleInfo,Integer[] moduleId);

    Integer deleteName(RoleInfo roleInfo);

    RoleInfo findId(RoleInfo roleInfo);




    //编辑角色
    void updateRole(RoleInfo role);

    //根据id删除角色权限
    void deleteRoleModule(int roleId);

    //在重新添加角色权限
    void addRoleModule(int roleId ,int[] module);


    List<RoleInfo> findNameById(int roleId);
    //    回显权限
    List<RoleModule> roleModules(int roleId);



}
