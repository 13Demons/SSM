package com.tian.ssm.management.service.impl;

import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.mapper.RoleModuleMapper;
import com.tian.ssm.management.service.RoleModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/12.
 */

@Service("roleModule")
public class RoleModuleServiceImpl implements RoleModuleService {

    @Resource
    private RoleModuleMapper roleModuleMapper;

    //删除中间表
    @Override
    public Integer delRoleInMiddleTable(RoleInfo roleInfo) {
        return roleModuleMapper.delRoleInMiddleTable(roleInfo);
    }



}
