package com.xy.ssm.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.*;
import com.xy.ssm.service.CUserService;
import com.xy.ssm.service.CompanyService;
import com.xy.ssm.service.RegisterValidateService;
import com.xy.ssm.service.UserService;
import com.xy.ssm.utils.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuchen on 2017/1/12.
 */

@Controller
@RequestMapping("/user")
@SessionAttributes("currentUser")//讲登录后命名为currentUser的加入session
public class UserController extends BaseController{

    private Logger log = Logger.getLogger(UserController.class);
    //上面是LOG的声明，下面的Resource 可以考虑使用Autowired来注入Service
    @Resource
    private UserService userService;
    @Resource
    private CompanyService companyService;
    @Resource
    private CUserService cUserService;
    @Resource
    private RegisterValidateService service;

    /**
     * 跳转到大学生用户页面
     * @return
     */
    @RequestMapping("index")
    private String toIndex(){
        log.info("--------------------call:index");
        return "person_index";
    }

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
                baseResult=new BaseResult(false,"用户注册信息获取异常");
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
                    baseResult=new BaseResult(true,"注册用户信息成功");
                }else {
                    baseResult=new BaseResult(false,"用户注册失败");
                }
            }
        }catch (Exception e){
            log.error("注册用户出现异常"+e);
            baseResult=new BaseResult(false,"用户注册异常");
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
                List<CUser> cUsers = cUserService.checkName(username);
                if(cUsers != null && 0 < cUsers.size ()){
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
                List<CUser> cUsers = cUserService.checkMail(email);
                if(cUsers != null && 0 < cUsers.size ()){
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
                List<CUser> cUsers = cUserService.checkPhone(phone);
                if(cUsers != null && 0 < cUsers.size ()){
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
        Map map =new HashMap();
        try{
            if(StringUtils.isEmpty(json)){
                baseResult=new BaseResult(false,"登录信息获取异常，请联系管理员稍后再试");
            }else {
                log.info(json);
                JSONObject obj=JSON.parseObject(json);
                CUser cUser=new CUser();
                CCompany cCompany = new CCompany();
                if(obj.getInteger("type") == 1){
                    String pwd=obj.getString("password");
                    cUser=cUserService.getUserByUsername(obj.getString("username"),1);
                    if (cUser != null){
                        if(!MD5Util.validate(pwd,cUser.getUserPassword())){
                            baseResult=new BaseResult(false,"用户名或密码错误，请重新输入！");
                        }else {
                            map.put("loginuser",cUser);
                            saveLoginUser (map);
                            baseResult=new BaseResult(true,"");
                            baseResult.setData(1);
                        }
                    }else {
                        baseResult=new BaseResult(false,"该账户尚未注册，请注册后登录");
                    }
                }else if(obj.getInteger("type") == 2){
                    String pwd=obj.getString("password");
                    cCompany=companyService.getCompanyByAccount(obj.getString("username"));
                    if(cCompany != null){
                        if(!MD5Util.validate(cCompany.getCompPassword(),pwd)){
                            baseResult=new BaseResult(false,"用户名或密码错误，请重新输入！");
                        }else {
                            map.put("loginuser",cCompany);
                            saveLoginUser (map);
                            baseResult=new BaseResult(true,"");
                            baseResult.setData(2);
                        }
                    }else{
                        baseResult=new BaseResult(false,"该用户尚未注册，请注册后登录");
                    }
                }else{
                    String pwd=obj.getString("password");
                    cUser=cUserService.getUserByUsername(obj.getString("username"),0);
                    if (cUser != null){
                        if(!MD5Util.validate(pwd,cUser.getUserPassword())){
                            baseResult=new BaseResult(false,"用户名或密码错误，请重新输入！");
                        }else {
                            map.put("loginuser",cUser);
                            saveLoginUser (map);
                            baseResult=new BaseResult(true,"");
                            baseResult.setData(3);

                        }
                    }else {
                        baseResult=new BaseResult(false,"该用户尚未注册，请注册后登录");
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

    /**
     * 获取当前登录用户信息并测试session
     * @param cUser
     * @return
     */
    @RequestMapping(value = "/myinfo",produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String myinfo(@ModelAttribute("currentUser")CUser cUser){
        log.info("--------------------/user/myinfo  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            log.info(cUser.toString());
            baseResult=new BaseResult(true,"");
            baseResult.setData(cUser);
        }catch (Exception e){
            log.error("获取当前登录用户出现异常"+e);
            baseResult=new BaseResult(false,"获取当前登录用户出现异常，请联系管理员或稍后再试");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     * 获取可报名兼职列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getJobList", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobList(@RequestParam(required = false) String  condition,
                              @RequestParam(required = false) Integer  offset,
                              @RequestParam(required = false) Integer  limit) {
        String result = "";
        BaseResult baseResult = null;
        CUser cUser =(CUser) getLoginUser ().get ("loginuser");
        try{
            List<CJobs> jobsList = cUserService.getJobList(condition,offset,limit);
            int count = cUserService.getJobCount(condition,offset,limit);
            if(jobsList != null && 0 < jobsList.size ()) {
                for(int i=0;i<jobsList.size();i++){
                    if(cUserService.getAppliByTwoId(jobsList.get(i).getId (),cUser.getId ()) != null){
                        jobsList.get(i).setFlag(1);
                    }else{
                        jobsList.get(i).setFlag(0);
                    }
                }
                BootStrapTableResult tableResult = new BootStrapTableResult<CJobs>(jobsList, count);
                baseResult = new BaseResult(true, "");
                baseResult.setData(tableResult);
            } else {
                baseResult = new BaseResult(true, "暂无可报名兼职信息");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取可报名兼职列表异常！", e);
            baseResult = new BaseResult(false, "获取可报名兼职列表异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }


    /**
     *申请报名兼职
     * @param jobId
     * @return
     */
    @RequestMapping(value = "/applicationJob", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String applicationJob(@RequestParam(required = true) Long  jobId) {
        log.info("--------------------/user/applicationJob  called");
        String result = "";
        BaseResult baseResult = null;
        CApplication cApplication = new CApplication();
        CUser cUser =(CUser) super.getLoginUser ().get ("loginuser");
        try{
            CJobs job=companyService.getJobDetails (jobId);
            if(job == null){
                baseResult=new BaseResult(false,"该兼职不存在");
            }else {
                cApplication.setAppliJobId (jobId);
                cApplication.setAppliStatus ("0");
                cApplication.setAppliUserId (cUser.getId ());
                //向数据库中添加申请报名记录
                int resultCode = cUserService.addJobApplication(cApplication);
                if(resultCode > 0){
                    //查询该兼职的报名人数
                    int count=companyService.getJobApplicationCount(jobId);
                    //设置报名人数上限为需求人数的两倍，供企业筛选
                    if(count == 2*job.getJobDemandNumber ()){
                        int resultCode1 = companyService.updateJobStatus (jobId,"4");
                        if(resultCode1 > 0){
                            baseResult=new BaseResult(true,"");
                        }else{
                            baseResult=new BaseResult(false,"修改兼职状态失败");
                        }
                    }
                }else{
                    baseResult=new BaseResult(false,"申请报名失败，请刷新后重试");
                }
            }
        }catch (Exception e){
            log.error("申请报名兼职异常"+e);
            baseResult=new BaseResult(false,"申请报名兼职异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     * 查看我的兼职情况
     * @param
     * @return
     */
    @RequestMapping(value = "/getMyAppliSituation", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getMyAppliSituation(@ModelAttribute("currentUser")CUser cUser,@RequestParam(required = false) String  jobStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<VOCApplication> vocApplicationList = userService.getMyAppliSituation(cUser.getId (),jobStatus);
            if(vocApplicationList != null && 0 < vocApplicationList.size ()) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(vocApplicationList);
            } else {
                baseResult = new BaseResult(true, "暂无报名情况");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("查看我的报名情况异常！", e);
            baseResult = new BaseResult(false, "查看我的报名情况异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     *退出兼职
     * @param applicationId
     * @return
     */
    @RequestMapping(value = "/quitJob", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String quitJob(@RequestParam(required = true) Long  applicationId,@ModelAttribute("currentUser")CUser cUser) {
        log.info("--------------------/user/quitJob  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            int re=userService.quitJob (applicationId,cUser.getId ());
            if(re > 0){
                baseResult=new BaseResult(true,"");
            }else {
                baseResult=new BaseResult(true,"退出兼职失败");
            }
        }catch (Exception e){
            log.error("退出兼职异常"+e);
            baseResult=new BaseResult(false,"退出兼职异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     *修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "/updateUserInfo", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateUserInfo(@RequestParam(required = true) CUser  cUser) {
        log.info("--------------------/user/updateUserInfo  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CUser> cUsers = cUserService.checkName (cUser.getUserName ());
            List<CUser> cUsers1 = cUserService.checkPhone (cUser.getUserPhone ());
            List<CUser> cUsers2 = cUserService.checkMail (cUser.getUserEmail ());
            if(cUsers != null && cUsers.size() > 1){
                baseResult=new BaseResult(false,"登录名已存在，请重新输入");
            }else if(cUsers.size() == 1 && !cUsers.get(0).getId().toString().equals(cUser.getId().toString())){
                baseResult=new BaseResult(false,"登录名已存在，请重新添加");
            }else{
                if(cUsers1 != null && cUsers1.size() > 1){
                    baseResult=new BaseResult(false,"手机号已存在，请重新输入");
                }else if(cUsers1.size() == 1 && !cUsers1.get(0).getId().toString().equals(cUser.getId().toString())){
                    baseResult=new BaseResult(false,"登录名已存在，请重新添加");
                }else{
                    if(cUsers2 != null && cUsers2.size() > 1){
                        baseResult=new BaseResult(false,"邮箱已存在，请重新输入");
                    }else if(cUsers2.size() == 1 && !cUsers2.get(0).getId().toString().equals(cUser.getId().toString())){
                        baseResult=new BaseResult(false,"邮箱已存在，请重新添加");
                    }else{
                        int rs = cUserService.updateUser(cUser);
                        if (rs == 1) {
                            baseResult = new BaseResult(true, "修改个人信息成功");
                        } else {
                            baseResult = new BaseResult(true, "修改个人信息失败");
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error("修改用戶信息异常"+e);
            baseResult=new BaseResult(false,"修改用戶信息异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     *修改用户密码
     * @param
     * @return
     */
    @RequestMapping(value = "/updateUserPassword", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateUserPassword(@ModelAttribute("currentUser")CUser cUser,
                                 @RequestParam(required = true)String oldPassword,
                                 @RequestParam(required = true)String newPassword) {
        log.info("--------------------/user/updateUserPassword  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            String oldPw = MD5Util.encode2hex(oldPassword);
            String newPw = MD5Util.encode2hex(newPassword);
            if(!cUser.getUserPassword ().equals(oldPw))
            {
                baseResult = new BaseResult(false, "密码错误");
            }else {
                int rs = userService.updateUserPassword(newPw,cUser.getId ());
                if (rs == 1) {
                    baseResult = new BaseResult(true, "");
                } else {
                    baseResult = new BaseResult(true, "修改密码失败");
                }
            }
        }catch (Exception e){
            log.error("修改密码异常"+e);
            baseResult=new BaseResult(false,"修改密码异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }
}
