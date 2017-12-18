package com.tian.ssm.management.mapper;

import com.tian.ssm.management.bean.RoleInfo;
import com.tian.ssm.management.bean.RoleModule;

import java.util.List;

public interface RoleInfoMapper {
    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    /**
     * 显示
     * @return
     */
    List<RoleInfo> findAllRole(RoleInfo roleInfo);


    RoleInfo findName(RoleInfo roleInfo);

    /**
     * 修改
     * @param roleInfo
     */
    void update(RoleInfo roleInfo);


    /**
     * 删除
     * @param adminId
     */
    Integer delete(Integer adminId);




    /**
     * 添加角色
     * @param roleInfo
     */
    void addRole(RoleInfo roleInfo);

    /**
     * 添加角色(中间表)
     * @return
     */
    int addModu(RoleInfo roleInfo);





    /**
     * 删除名字
     * @param roleInfo
     * @return
     */
    Integer deleteName(RoleInfo roleInfo);

    RoleInfo findId(RoleInfo roleInfo);




    //编辑角色
    void updateRole(RoleInfo role);

    //根据id删除角色权限
    void deleteRoleModule(int roleId);

    //在重新添加角色权限
    void addRoleModule(int roleId,int module);


    List<RoleInfo> findNameById(int roleId);
    //    回显权限
    List<RoleModule> roleModules(int roleId);




}