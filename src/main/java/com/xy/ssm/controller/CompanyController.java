package com.xy.ssm.controller;


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
public class CompanyController {

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
    public String addJobs(@RequestParam(required = true) CJobs cJobs,@ModelAttribute("currentUser")CCompany cCompany) {
        String result = "";
        BaseResult baseResult = null;
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
    public String getJobsByCompanyId(@RequestParam(required = true) Integer offset,
                                     @RequestParam(required = true) Integer limit,
                                     @RequestParam(required = false) String queryTerm,
                                     @ModelAttribute("currentUser")CCompany cCompany) {
        String result = "";
        BaseResult baseResult = null;
        offset = offset ==null ? 0 :offset;//默认设置0
        limit = limit == null ? 10 : limit;//默认展示10条
        Long companyId = cCompany.getId();
        try{
            List<CJobs> list = companyService.getJobsByCompanyId(queryTerm,companyId, offset, limit);
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
            baseResult = new BaseResult(false, "分页获取当前企业发布的兼职信息列表异常！");
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
    public String getEnrollmentSituation(@RequestParam(required = true) Long jobId,@RequestParam(required = true) String appliStatus) {
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
    public String getEnrollmentSituation(@RequestParam(required = true) Long jobId,@RequestParam(required = true) Long userId,@RequestParam(required = true) int demandNumber,@RequestParam(required = true) String appliStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            if(appliStatus.equals (1)){
                //查询报名成功的人数
                List<CApplication> applicationList = companyService.getEnrollmentSituation(jobId,"1");
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
     *修改企业用户密码
     * @param
     * @return
     */
    @RequestMapping(value = "/updateCompPassword", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCompPassword(@ModelAttribute("currentUser")CCompany cCompany,
                                 @RequestParam(required = true)String oldPassword,
                                 @RequestParam(required = true)String newPassword) {
        String result = "";
        BaseResult baseResult = null;
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

}
