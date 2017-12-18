package com.tian.ssm.management.service.impl;

import com.tian.ssm.management.bean.ModuleInfo;
import com.tian.ssm.management.mapper.ModuleInfoMapper;
import com.tian.ssm.management.service.ModuleInfoMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/13.
 */
@Service("moduleInfo")
public class ModuleInfoMapperServiceImpl implements ModuleInfoMapperService {
    @Resource
    private ModuleInfoMapper moduleInfoMapper;

    @Override
    public String deleteName(ModuleInfo moduleName)
    {
        return moduleInfoMapper.deleteName(moduleName);
    }
}
