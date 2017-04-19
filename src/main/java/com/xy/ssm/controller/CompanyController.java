package com.xy.ssm.controller;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CCompany;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.model.CUser;
import com.xy.ssm.service.CompanyService;
import com.xy.ssm.service.UserService;
import com.xy.ssm.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */

@Controller
@RequestMapping("/company")
@SessionAttributes("currentUser")//讲登录后命名为currentUser的加入session
public class CompanyController extends BaseController {

    private Logger log = Logger.getLogger(CompanyController.class);
    //上面是LOG的声明，下面的Resource 可以考虑使用Autowired来注入Service
    @Resource
    private CompanyService companyService;

//    /**
//     * 跳转到企业用户页面
//     * @return
//     */
//    @RequestMapping("index")
//    private String toIndex(){
//        log.info("--------------------call:index");
//        return "jz_index";
//    }

    /**
     * 发布兼职信息
     * @param cJobs
     * @return
     */
    @RequestMapping(value = "/addJobs", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addJobs(@RequestParam(required = true) CJobs cJobs) {
        String result = "";
        BaseResult baseResult = null;
        CCompany cCompany =(CCompany)getLoginUser ().get ("loginuser");

        try{
            Long companyId = cCompany.getId();
            cJobs.setJobCompanyId(companyId);
            Long id = companyService.addJobs(cJobs);
            if(id != null){
                baseResult=new BaseResult(true,"发布兼职信息成功");
            }else{
                baseResult=new BaseResult(false,"发布兼职信息失败");
            }
        }catch (Exception e){
            log.error("发布兼职信息异常"+e);
            baseResult=new BaseResult(false,"发布兼职信息异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     * 分页获取当前企业发布的兼职信息列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getJobsByCompanyId", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobsByCompanyId(@RequestParam(required = false) Integer offset,
                                     @RequestParam(required = false) Integer limit,
                                     @RequestParam(required = false) String queryTerm,
                                     @RequestParam(required = false) String jobStatus) {
        String result = "";
        BaseResult baseResult = null;
        CCompany cCompany =(CCompany)getLoginUser ().get ("loginuser");
        Long companyId = cCompany.getId();
        try{
            List<CJobs> list = companyService.getJobsByCompanyId(queryTerm,companyId, offset,limit,jobStatus);
            int count = companyService.getJobsCountByCompanyId(queryTerm,companyId);
            if(list != null && 0<list.size()) {
                BootStrapTableResult tableResult = new BootStrapTableResult<CJobs>(list,count);
                baseResult = new BaseResult(true, "");
                baseResult.setData(tableResult);
            } else {
                baseResult = new BaseResult(true, "没有查询到相关信息");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取兼职信息列表异常！", e);
            baseResult = new BaseResult(false, "当前企业发布的兼职信息列表异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 获取兼职报名情况
     * @param
     * @return
     */
    @RequestMapping(value = "/getEnrollmentSituation", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getEnrollmentSituation(@RequestParam(required = true) Long jobId,@RequestParam(required = false) String appliStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CApplication> applicationList = companyService.getEnrollmentSituation(jobId,appliStatus);
            if(applicationList != null && 0<applicationList.size()) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(applicationList);
            } else {
                baseResult = new BaseResult(false, "暂无兼职报名情况");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取兼职报名情况异常！", e);
            baseResult = new BaseResult(false, "获取兼职报名情况异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 筛选兼职用户
     * @param
     * @return
     */
    @RequestMapping(value = "/screenApplicationUser", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getEnrollmentSituation(@RequestParam(required = true) Long jobId,@RequestParam(required = true) Long userId,@RequestParam(required = true) Integer demandNumber,@RequestParam(required = true) String appliStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            if(appliStatus.equals ("appli_successful")){
                //查询报名成功的人数
                List<CApplication> applicationList = companyService.getEnrollmentSituation(jobId,"appli_successful");
                int appliSuccessCount = applicationList.size ();
                if(appliSuccessCount == demandNumber){
                    baseResult = new BaseResult(false, "人数已达到需求人数");
                }else{
                    int resultCode = companyService.updateApplicationStatus(jobId,userId,appliStatus);
                    if(resultCode  > 0) {
                        baseResult = new BaseResult(true, "");
                    } else {
                        baseResult = new BaseResult(false, "修改用户报名状态失败");
                    }
                }
            }else{
                int resultCode = companyService.updateApplicationStatus(jobId,userId,appliStatus);
                if(resultCode  > 0) {
                    baseResult = new BaseResult(true, "");
                } else {
                    baseResult = new BaseResult(false, "修改用户报名状态失败");
                }
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("修改用户报名状态异常！", e);
            baseResult = new BaseResult(false, "修改用户报名状态异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 删除某兼职
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteJobById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteJobById(@RequestParam(required = true) Long jobId,@ModelAttribute("currentUser")CCompany cCompany) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int rs = companyService.deleteJobById (jobId);
            if(rs > 0){
                baseResult=new BaseResult(true,"删除兼职成功");
            }else{
                baseResult=new BaseResult(false,"删除兼职失败");
            }
        }catch (Exception e){
            log.error("删除兼职异常"+e);
            baseResult=new BaseResult(false,"删除兼职异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     * 提交审核
     * @param
     * @return
     */
    @RequestMapping(value = "/submitAudit", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String submitAudit(@RequestParam(required = true) Long jobId) {
        String result = "";
        BaseResult baseResult = null;
        CCompany cCompany =(CCompany) getLoginUser ().get ("loginuser");
        String jobStatus = "1";
        try{
            int rs = companyService.updateJobStatus (jobId,jobStatus);
            if(rs > 0){
                baseResult=new BaseResult(true,"");
            }else{
                baseResult=new BaseResult(false,"提交审核失败");
            }
        }catch (Exception e){
            log.error("提交审核异常"+e);
            baseResult=new BaseResult(false,"提交审核异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }
    /**
     *修改企业用户密码
     * @param
     * @return
     */
    @RequestMapping(value = "/updateCompPassword", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCompPassword(@RequestParam(required = true)String oldPassword,
                                 @RequestParam(required = true)String newPassword) {
        String result = "";
        BaseResult baseResult = null;
        CCompany cCompany =(CCompany)getLoginUser ().get ("loginuser");
        try{
            String oldPw = MD5Util.encode2hex(oldPassword);
            String newPw = MD5Util.encode2hex(newPassword);
            if(!cCompany.getCompPassword ().equals(oldPw))
            {
                baseResult = new BaseResult(false, "密码错误");
            }else {
                int rs = companyService.updateCompPassword(newPw,cCompany.getId ());
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
    /**
     * 查看兼职详情
     * @param
     * @return
     */
    @RequestMapping(value = "/getJobDetails", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobDetails(@RequestParam(required = true) Long jobId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            CJobs job = companyService.getJobDetails(jobId);
            if(job != null) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(job);
            } else {
                baseResult = new BaseResult(true, "该兼职不存在");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取兼职信息详情异常！", e);
            baseResult = new BaseResult(false, "获取兼职信息详情异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 移除兼职（该兼职对企业用户不可见）
     * @param
     * @return
     */
    @RequestMapping(value = "/removeJobById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String removeJobById(@RequestParam(required = true) Long jobId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int resultCode = companyService.updateJobSign(jobId);
            if(resultCode > 0) {
                baseResult = new BaseResult(true, "");
            } else {
                baseResult = new BaseResult(true, "移除兼职失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("移除兼职异常！", e);
            baseResult = new BaseResult(false, "移除兼职异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     *删除兼职记录
     * @param applicationId
     * @return
     */
    @RequestMapping(value = "/updateCompSign", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCompSign(@RequestParam(required = true) Long  applicationId,
                                 @RequestParam(required = true) Long  jobId) {
        String result = "";
        BaseResult baseResult = null;
        CCompany cCompany =(CCompany)getLoginUser ().get ("loginuser");
        try{
            int re=companyService.updateCompSign (applicationId,jobId);
            if(re > 0){
                baseResult=new BaseResult(true,"");
            }else {
                baseResult=new BaseResult(true,"删除兼职记录失败");
            }
        }catch (Exception e){
            log.error("删除兼职记录异常"+e);
            baseResult=new BaseResult(false,"删除兼职记录异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }
    /**
     * 查看企业用户基本信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getCompanyInfoById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getCompanyInfoById() {
        String result = "";
        BaseResult baseResult = null;
        CCompany cCompany =(CCompany) getLoginUser ().get ("loginuser");
        try{
            CCompany companyInfo = companyService.getCompanyInfo(cCompany.getId ());
            if(companyInfo != null) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(companyInfo);
            } else {
                baseResult = new BaseResult(true, "该企业不存在");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取企业信息异常！", e);
            baseResult = new BaseResult(false, "获取企业信息异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     *修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "/updateCompanyInfo", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateUserInfo(CCompany  cCompany) {
        log.info("--------------------/company/updateCompanyInfo  called");
        String result = "";
        BaseResult baseResult = null;
        CCompany cCompany1 =(CCompany) getLoginUser ().get ("loginuser");
        cCompany.setId (cCompany1.getId ());
        try{
            List<CCompany> cCompanys = companyService.checkAccount (cCompany.getCompAccount ());
            List<CCompany> cCompanys1 = companyService.checkPhone (cCompany.getCompPhone ());
            List<CCompany> cCompanys2 = companyService.checkMail (cCompany.getCompEmail ());
            if(cCompanys != null && cCompanys.size() > 1){
                baseResult=new BaseResult(false,"登录名已存在，请重新输入");
            }else if(cCompanys.size() == 1 && !cCompanys.get(0).getId().toString().equals(cCompany.getId().toString())){
                baseResult=new BaseResult(false,"登录名已存在，请重新添加");
            }else{
                if(cCompanys1 != null && cCompanys1.size() > 1){
                    baseResult=new BaseResult(false,"手机号已存在，请重新输入");
                }else if(cCompanys1.size() == 1 && !cCompanys1.get(0).getId().toString().equals(cCompany.getId().toString())){
                    baseResult=new BaseResult(false,"登录名已存在，请重新添加");
                }else{
                    if(cCompanys2 != null && cCompanys2.size() > 1){
                        baseResult=new BaseResult(false,"邮箱已存在，请重新输入");
                    }else if(cCompanys2.size() == 1 && !cCompanys2.get(0).getId().toString().equals(cCompany.getId().toString())){
                        baseResult=new BaseResult(false,"邮箱已存在，请重新添加");
                    }else{
                        int rs = companyService.updateCompany(cCompany);
                        if (rs == 1) {
                            baseResult = new BaseResult(true, "修改企业信息成功");
                        } else {
                            baseResult = new BaseResult(true, "修改企业信息失败");
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error("修改企业信息异常"+e);
            baseResult=new BaseResult(false,"修改企业信息异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     *检测用户名是否存在
     * @param account
     * @return
     */
    @RequestMapping(value = "/checkName", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String checkName(@RequestParam(required = true) String  account) {
        log.info("--------------------/company/checkName  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            if(StringUtils.isEmpty(account)){
                baseResult=new BaseResult(false,"获取企业账号异常，请联系管理员稍后再试");
            }else {
                List<CCompany> cCompanys = companyService.checkAccount(account);
                if(cCompanys != null && 0 < cCompanys.size ()){
                    baseResult=new BaseResult(false,"企业账号已经存在");
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
        log.info("--------------------/company/checkMail  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            if(StringUtils.isEmpty(email)){
                baseResult=new BaseResult(false,"邮箱信息获取异常，请联系管理员稍后再试");
            }else {
                List<CCompany> cCompanys = companyService.checkMail(email);
                if(cCompanys != null && 0 < cCompanys.size ()){
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
        log.info("--------------------/company/checkPhone  called");
        String result = "";
        BaseResult baseResult = null;
        try{
            if(StringUtils.isEmpty(phone)){
                baseResult=new BaseResult(false,"手机号信息获取异常，请联系管理员稍后再试");
            }else {
                List<CCompany> cCompanys = companyService.checkPhone(phone);
                if(cCompanys != null && 0 < cCompanys.size ()){
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



}
