package com.tian.ssm.management.mapper;

import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.bean.RoleModule;

public interface RoleModuleMapper {

    int insert(RoleModule record);

    int insertSelective(RoleModule record);

    // 根据角色删除中间表的内容
    Integer delRoleInMiddleTable(RoleInfo roleInfo);
}