package com.tian.ssm.login.controller;

import com.tian.ssm.login.bean.AdminInfo;
import com.tian.ssm.login.service.AdminInfoService;
import com.tian.ssm.login.utils.AjaxResult;
import com.tian.ssm.login.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by dllo on 17/12/9.
 */
@Controller
public class LoginController {

    @Resource(name = "adminInfo")
    private AdminInfoService adminInfoService;
    private String text;

    /**
     * 登录
     * @param adminInfo
     * @param code
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login")
    public String loginAdminInfo(AdminInfo adminInfo, String code, HttpSession session){
        AdminInfo admin = adminInfoService.loginAdmin(adminInfo);
        String code1 = (String) session.getAttribute("code");

        if (adminInfo.getName()==null&&adminInfo.getName().isEmpty()){
            return "error";
        }
        else if (adminInfo.getPassword()==null||adminInfo.getPassword().isEmpty()){
            return "errorNull";
        }
        else if (adminInfo.getName().length()<3||adminInfo.getName().length()>8){
            return "NameLength";
        }
        else if (adminInfo.getPassword().length()<3||adminInfo.getPassword().length()>8){
            return "PwdLength";
        }
        else if ( admin==null||admin.getName()==null){
            return "NameError";
        }
        else if (!admin.getPassword().equals(adminInfo.getPassword())){
            return "PwdError";
        }
        else if (!code1.equalsIgnoreCase(code)){
            return "codeError";
        }
        session.setAttribute("adminInfo",admin);
        return "success";
    }

    @RequestMapping(value = "logins")
    public String login(){
        return "index";
    }

    /**
     * 验证码
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/code")
    public void Verify(HttpSession session, HttpServletResponse response) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        text = verifyCode.getText();
        session.setAttribute("code",verifyCode.getText());
        VerifyCode.output(image,response.getOutputStream());
    }


    @RequestMapping(value = "RoleList")
    public String admin(){
        return "/role/role_list";
    }

    @RequestMapping(value = "Role")
    //必须要有注解
    @ResponseBody
    public String admin1(){
        return "success";
    }




    @RequestMapping(value = "fee_list")
    public String cost(){
        return "/fee/fee_list";
    }


    @RequestMapping(value = "admin_list")
    public String ad(){
        return "admin/admin_list";
    }

    @RequestMapping(value = "service_list")
    public String service(){
        return "service/service_list";
    }

    @RequestMapping(value = "bill_list")
    public String bill(){
        return "bill/bill_list";
    }

    @RequestMapping(value = "report_list")
    public String report(){
        return "report/report_list";
    }

    @RequestMapping(value = "user_info")
    public String user(){
        return "user/user_info";
    }

    @RequestMapping(value = "account_list")
    public String account(){
        return "account/account_list";
    }

    @RequestMapping(value = "user_modi_pwd")
    public String usepwd(){
        return "user/user_modi_pwd";
    }


    //管理员查询
    @RequestMapping(value = "fee")
    @ResponseBody
    public AjaxResult findFee(AdminInfo adminInfo,String roleName,Integer moduleId){
        return new AjaxResult(adminInfoService.find(adminInfo,roleName,moduleId));
    }

    //页面跳转到添加界面
    @RequestMapping(value = "add_admin")
    public String updateAdmin(){
        return "admin/admin_add";
    }

    @RequestMapping(value = "/upd")
    @ResponseBody
    public String upd(Integer adminId,HttpSession session){
        session.setAttribute("adminId",adminId);
        return "success";
    }

    //页面跳转到修改界面
    @RequestMapping(value = "update_admin")
    public String deladmin(){
        System.out.println("11111");
        return "admin/admin_modi";
    }


    //跳主页
    @RequestMapping(value ="indexAdmin")
    @ResponseBody
    public String indexAdmin(){
        return "success";
    }

    @RequestMapping(value = "index_Admin")
    public String index_Admin(){
        return "admin/admin_list";
    }


    //跳角色
    @RequestMapping(value = "roleAdmin")
    @ResponseBody
    public String roleAdmin(){
        return "success";
    }

    @RequestMapping(value = "role_Admin")
    public String role_Admin(){
        return "role/role_list";
    }


    //跳咨询
    @RequestMapping(value = "feeAdmin")
    @ResponseBody
    public String feeAdmin(){
        return "success";
    }

    @RequestMapping(value = "fee_Admin")
    public String fee_Admin(){
        return "fee/fee_list";
    }

    //模块
    @RequestMapping(value = "findModuleInfo")
    @ResponseBody
    public AjaxResult findModuleInfo(){
        return new AjaxResult(adminInfoService.find_ModuleInfo());
    }




    //修改密码
    @RequestMapping(value = "/update_Admin")
    @ResponseBody
    public String updateAdmin(AdminInfo adminInfo,String Pwd){
        return adminInfoService.updateAdmin(adminInfo,Pwd);
    }

    //个人信息回显
    @RequestMapping(value = "/Echo")
    @ResponseBody
    public AjaxResult Echo(HttpSession session){
        AdminInfo admin = (AdminInfo) session.getAttribute("adminInfo");
        return new AjaxResult(adminInfoService.EchoAdmin(admin));
    }

    //修改个人信息
    @RequestMapping(value = "/updateEcho")
    @ResponseBody
    public String updateEcho(AdminInfo adminInfo){
        return  adminInfoService.updateEcho(adminInfo);
    }




}
