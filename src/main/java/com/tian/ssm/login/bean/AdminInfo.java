package com.tian.ssm.login.bean;

import com.tian.ssm.management.bean.ModuleInfo;
import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.bean.RoleModule;

import java.util.Date;

public class AdminInfo {
    private Integer adminId;

    private String adminCode;

    private String password;

    private String name;

    private String telephone;

    private String email;

    private Date enrolldate;


    private AdminRole adminRole;
    private RoleInfo roleInfo;
    private RoleModule roleModule;
    private ModuleInfo moduleInfo;




    public AdminInfo() {
    }

    public AdminInfo(String adminCode, String name, String telephone, String email) {
        this.adminCode = adminCode;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public AdminInfo(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    public AdminInfo(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public AdminInfo(String adminCode, String password, String name, String telephone, String email) {
        this.adminCode = adminCode;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public AdminInfo(Integer adminId, String adminCode, String password, String name, String telephone, String email, Date enrolldate, AdminRole adminRole, RoleInfo roleInfo, RoleModule roleModule, ModuleInfo moduleInfo) {
        this.adminId = adminId;
        this.adminCode = adminCode;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
        this.adminRole = adminRole;
        this.roleInfo = roleInfo;
        this.roleModule = roleModule;
        this.moduleInfo = moduleInfo;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminId=" + adminId +
                ", adminCode='" + adminCode + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrolldate +
                ", adminRole=" + adminRole +
                ", roleInfo=" + roleInfo +
                ", roleModule=" + roleModule +
                ", moduleInfo=" + moduleInfo +
                '}';
    }

    public AdminRole getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(AdminRole adminRole) {
        this.adminRole = adminRole;
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }

    public RoleModule getRoleModule() {
        return roleModule;
    }

    public void setRoleModule(RoleModule roleModule) {
        this.roleModule = roleModule;
    }

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }
}