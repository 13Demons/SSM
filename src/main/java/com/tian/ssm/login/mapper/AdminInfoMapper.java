package com.tian.ssm.login.mapper;

import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.login.bean.AdminRole;
import com.tian.ssm.management.bean.RoleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminInfoMapper {

    int insert(AdminInfo record);
    int insertSelective(AdminInfo record);

    //登录(admin_info)
    AdminInfo loginAdmin(AdminInfo adminInfo);

    //查询(admin_info)
    List<AdminInfo> find(AdminInfo adminInfo);

    //添加管理员(admin_info)
    void addAdmin(AdminInfo admin);


    //查询名字(admin_info)
    List<AdminInfo> findAdminName();

    //删除管理员(admin_info)
    int deleteAdmin(AdminInfo admin);

    //删除(role_module)
    int deleteRoleModule(List<AdminRole> adminRole);

    //删除中间(admin_role)
    int deleteAdmin_role(AdminInfo adminInfo);

    //删除角色(role_Info)
    int deleteRole_Info( List<AdminRole> adminRole);

    //查询中间表的id(根据管理员id)
    List<AdminRole> findAdminAndRole(AdminInfo admin);

    //修改管理员(姓名,账号,电话,邮箱,角色)
    int updateAdmin(AdminInfo admin);

    //查询插入以后的人
    RoleInfo findInsertRoleInfo(RoleInfo roleInfo);

    //向中间表添加ID
    int insertAdminRole(Integer adminId,Integer roleId);


    //查找admin_info
    List<AdminInfo> find_Admin(Integer adminId);

    //查找中间表admin_role
    List<AdminRole> find_AdminR(Integer adminId);

    //更改admin_info
    void updateA(AdminInfo adminInfo);

    //删除中间表
    void deleteAR(Integer adminId);

    //添加中间表
    void addAdminRole(int adminId, Integer roleId);


}