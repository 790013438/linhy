package com.xy.ssm.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.model.CUser;
import com.xy.ssm.model.User;
import com.xy.ssm.service.CUserService;
import com.xy.ssm.service.RegisterValidateService;
import com.xy.ssm.service.UserService;
import com.xy.ssm.utils.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    //上面是LOG的声明，下面的Resource 可以考虑使用Autowired来注入Service
    @Resource
    private UserService userService;
    @Resource
    private CUserService cUserService;
    @Resource
    private RegisterValidateService service;

    /**
     * 这里的访问路径就为/user/showUser的形式。参数自己带。此为测试demo 所以返回到页面上。后续加入ajax
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }

    /**
     * 用户注册
     * @param json
     * @return
     */
    @RequestMapping(value = "/register", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String register(@RequestParam(required = true) String  json) {
        String result = "";
        BaseResult baseResult = null;
        try{
            if(StringUtils.isEmpty(json)){
                baseResult=new BaseResult(false,"用户注册信息获取异常，请联系管理员稍后再试");
            }else {
                CUser cUser=new CUser();
                log.info(json);
                JSONObject obj=JSON.parseObject(json);
                cUser.setUserName(obj.getString("username"));
                cUser.setUserEmail(obj.getString("email"));
                cUser.setUserPassword(MD5Util.encode2hex(obj.getString("password")));
                cUser.setUserGender(obj.getString("gender"));
                cUser.setUserPhone(obj.getString("phone"));
                cUser.setCreateTime(new Date());
                cUser.setUserType(1);
                Long rs=service.processRegister(cUser);
                if(rs!=null){
                    baseResult=new BaseResult(true,"注册用户信息成功，请前往邮箱激活");
                }else {
                    baseResult=new BaseResult(false,"注册用户信息出现异常，请联系管理员或稍后再试");
                }
            }
        }catch (Exception e){
            log.error("注册用户出现异常"+e);
            baseResult=new BaseResult(false,"注册用户信息出现异常，请联系管理员或稍后再试");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     *检测用户名是否存在
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkName", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String checkName(@RequestParam(required = true) String  username) {
        log.info("--------------------/user/checkName  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            if(StringUtils.isEmpty(username)){
                baseResult=new BaseResult(false,"用户名信息获取异常，请联系管理员稍后再试");
            }else {
                Integer rs=cUserService.checkName(username);
                log.info("查询结果为："+rs);
                if(rs.equals(1)){
                    baseResult=new BaseResult(false,"用户名已经存在");
                }else {
                    baseResult=new BaseResult(true,"");
                }
            }
        }catch (Exception e){
            log.error("注册用户出现异常"+e);
            baseResult=new BaseResult(false,"注册用户信息出现异常，请联系管理员或稍后再试");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     *检测邮箱是否存在
     * @param email
     * @return
     */
    @RequestMapping(value = "/checkMail", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String checkMail(@RequestParam(required = true) String  email) {
        log.info("--------------------/user/checkMail  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            if(StringUtils.isEmpty(email)){
                baseResult=new BaseResult(false,"邮箱信息获取异常，请联系管理员稍后再试");
            }else {
                Integer rs=cUserService.checkMail(email);
                log.info("查询结果为："+rs);
                if(rs.equals(1)){
                    baseResult=new BaseResult(false,"邮箱已经存在");
                }else {
                    baseResult=new BaseResult(true,"");
                }
            }
        }catch (Exception e){
            log.error("注册用户出现异常"+e);
            baseResult=new BaseResult(false,"注册用户信息出现异常，请联系管理员或稍后再试");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     *检测手机号是否存在
     * @param phone
     * @return
     */
    @RequestMapping(value = "/checkPhone", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String checkPhone(@RequestParam(required = true) String  phone) {
        log.info("--------------------/user/checkPhone  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            if(StringUtils.isEmpty(phone)){
                baseResult=new BaseResult(false,"手机号信息获取异常，请联系管理员稍后再试");
            }else {
                Integer rs=cUserService.checkPhone(phone);
                log.info("查询结果为："+rs);
                if(rs.equals(1)){
                    baseResult=new BaseResult(false,"手机号已经存在");
                }else {
                    baseResult=new BaseResult(true,"");
                }
            }
        }catch (Exception e){
            log.error("注册用户出现异常"+e);
            baseResult=new BaseResult(false,"注册用户信息出现异常，请联系管理员或稍后再试");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     *登录
     * @param json
     * @return
     */
    @RequestMapping(value = "/login", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String login(@RequestParam(required = true) String  json) {
        log.info("--------------------/user/login  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            if(StringUtils.isEmpty(json)){
                baseResult=new BaseResult(false,"登录信息获取异常，请联系管理员稍后再试");
            }else {
                log.info(json);
                JSONObject obj=JSON.parseObject(json);
                CUser cUser=new CUser();
                cUser.setUserName(obj.getString("username"));
                String pwd=obj.getString("password");
                cUser.setUserType(obj.getInteger("type"));
                if(cUser.getUserType()==1){
                    cUser=cUserService.getUserByUsername(cUser.getUserName());
                    log.info(cUser.getUserPassword()+"----------------------------------------"+pwd);
                    if(!MD5Util.validate(pwd,cUser.getUserPassword())){
                        baseResult=new BaseResult(false,"登录失败！");
                    }else {
                        baseResult=new BaseResult(true,"登录成功");
                    }
                }else {
                    cUser=cUserService.getUserByUsername(cUser.getUserName());
                    if(!MD5Util.validate(cUser.getUserPassword(),pwd)){
                        baseResult=new BaseResult(false,"登录失败！");
                    }else {
                        baseResult=new BaseResult(true,"登录成功");
                    }
                }

            }
        }catch (Exception e){
            log.error("登录用户出现异常"+e);
            baseResult=new BaseResult(false,"登录用户信息出现异常，请联系管理员或稍后再试");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }
}
