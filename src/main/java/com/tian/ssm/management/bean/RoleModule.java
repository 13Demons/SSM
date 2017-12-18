package com.tian.ssm.management.bean;

public class RoleModule {
    private Integer roleId;

    private Integer moduleId;

    private RoleInfo roleInfo;

    public RoleModule() {
    }

    public RoleModule(Integer roleId, Integer moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "RoleModule{" +
                "roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }
}