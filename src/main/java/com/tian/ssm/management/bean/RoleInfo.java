package com.tian.ssm.management.bean;

import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.login.bean.AdminRole;

import java.util.List;

public class RoleInfo {
    private Integer roleId;
    private String roleName;
    private ModuleInfo moduleInfo;
    private RoleModule roleModule;

    private List<Integer> moduleId;
    private List<AdminInfo> adminInfos;
    private List<AdminRole> adminRoles;



    public RoleInfo() {
    }

    public RoleInfo(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleInfo(String roleName) {
        this.roleName = roleName;
    }

    public RoleInfo(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", moduleInfo=" + moduleInfo +
                ", roleModule=" + roleModule +
                '}';
    }

    public List<AdminInfo> getAdminInfos() {
        return adminInfos;
    }

    public void setAdminInfos(List<AdminInfo> adminInfos) {
        this.adminInfos = adminInfos;
    }

    public List<AdminRole> getAdminRoles() {
        return adminRoles;
    }

    public void setAdminRoles(List<AdminRole> adminRoles) {
        this.adminRoles = adminRoles;
    }

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public RoleModule getRoleModule() {
        return roleModule;
    }

    public void setRoleModule(RoleModule roleModule) {
        this.roleModule = roleModule;
    }


    public List<Integer> getModuleId() {
        return moduleId;
    }

    public void setModuleId(List<Integer> moduleId) {
        this.moduleId = moduleId;
    }


}