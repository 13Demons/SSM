package com.tian.ssm.login.bean;

public class AdminRole {
    private Integer adminId;

    private Integer roleId;

    @Override
    public String toString() {
        return "AdminRole{" +
                "adminId=" + adminId +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}