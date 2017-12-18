package com.tian.ssm.management.mapper;

import com.tian.ssm.management.bean.ModuleInfo;

public interface ModuleInfoMapper {
    int insert(ModuleInfo record);

    int insertSelective(ModuleInfo record);

    String deleteName(ModuleInfo moduleName);
}