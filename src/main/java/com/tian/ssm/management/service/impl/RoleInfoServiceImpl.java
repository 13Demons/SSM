package com.tian.ssm.management.service.impl;


import com.tian.ssm.management.bean.ModuleInfo;
import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.bean.RoleModule;
import com.tian.ssm.management.mapper.RoleInfoMapper;
import com.tian.ssm.management.service.RoleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/9.
 */
@Service("roleInfo")
public class RoleInfoServiceImpl implements RoleInfoService {

    @Resource
    private RoleInfoMapper roleInfoMapper;


    @Override
    public List<RoleInfo> findAllRole(RoleInfo roleInfo) {

        return roleInfoMapper.findAllRole(roleInfo);
    }



    @Override
    public String addRole(RoleInfo roleInfo, Integer[] moduleId) {

        if (roleInfo.getRoleName().equals("") || roleInfo.getRoleName() == null) {
            return "nameNull";
        } else if (moduleId[0] == 0) {
            return "integerError";
        } else {
            roleInfoMapper.addRole(roleInfo);
            System.out.println(roleInfo);
            RoleInfo name = roleInfoMapper.findName(roleInfo);
            for (Integer integer : moduleId) {
                ModuleInfo moduleInfo =new ModuleInfo();
                moduleInfo.setModuleId(integer);
                name.setModuleInfo(moduleInfo);
                roleInfoMapper.addModu(name);
            }
            return "add";
        }
    }

    @Override
    public Integer deleteName(RoleInfo roleInfo) {
        return roleInfoMapper.deleteName(roleInfo);
    }

    @Override
    public RoleInfo findId(RoleInfo roleInfo) {
        return roleInfoMapper.findId(roleInfo);
    }

    //删除
    @Override
    public Integer delete(Integer adminId) {
        return roleInfoMapper.delete(adminId);
    }


    /**
     * 修改角色
     * @param role
     */
    @Override
    public void updateRole(RoleInfo role) {
        roleInfoMapper.updateRole(role);
    }


    /**
     * 删除中间表
     * @param roleId
     */
    @Override
    public void deleteRoleModule(int roleId) {
        roleInfoMapper.deleteRoleModule(roleId);
    }

    /**
     * 在循环着添加中间表的数据
     * @param module
     */
    @Override
    public void addRoleModule(int roleId,int[] module) {

        for (int i = 0; i < module.length; i++) {
            Integer integer = module[i];
            roleInfoMapper.addRoleModule(roleId,integer);

        }
    }

    @Override
    public List<RoleInfo> findNameById(int roleId) {
        return roleInfoMapper.findNameById(roleId);
    }

    //回显权限
    @Override
    public List<RoleModule> roleModules(int roleId) {
        return roleInfoMapper.roleModules(roleId);
    }



}
