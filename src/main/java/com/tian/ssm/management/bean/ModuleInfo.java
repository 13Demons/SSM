package com.tian.ssm.management.bean;

import com.tian.ssm.login.bean.AdminInfo;

public class ModuleInfo {
    private Integer moduleId;

    private String moduleName;

    private ModuleInfo moduleInfo;

    private AdminInfo adminInfo;

    public ModuleInfo() {
    }

    public ModuleInfo(String moduleName) {
        this.moduleName = moduleName;
    }

    public ModuleInfo(Integer moduleId, String moduleName) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        return "ModuleInfo{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }

    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }


    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }
}