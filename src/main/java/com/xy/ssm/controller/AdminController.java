package com.xy.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CCompany;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.model.CUser;
import com.xy.ssm.service.CompanyService;
import com.xy.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wuchenl on 2017/1/13.
 */
@Controller
@RequestMapping("admin")
public class AdminController
{

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @Resource
    private CompanyService companyService;

    /**
     * 跳转到管理员用户页面
     * @return
     */
    @RequestMapping("index")
    private String toIndex(){
        log.info("--------------------call:index");
        return "system_index";
    }
    /**
     * 按状态获取兼职列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllJobs", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobsByCompanyId(@RequestParam(required = true) Integer offset,
                                     @RequestParam(required = true) Integer limit,
                                     @RequestParam(required = true) String jobStatus) {
        String result = "";
        BaseResult baseResult = null;
        offset = offset ==null ? 0 :offset;//默认设置0
        limit = limit == null ? 10 : limit;//默认展示10条
        try{
            List<CJobs> list = companyService.getAllJobs(jobStatus,offset, limit);
            int count = companyService.getAllJobsCount(jobStatus);
            if(list != null && 0<list.size()) {
                BootStrapTableResult tableResult = new BootStrapTableResult<CJobs>(list,count);
                baseResult = new BaseResult(true, "");
                baseResult.setData(tableResult);
            } else {
                baseResult = new BaseResult(true, "没有查询到待审核兼职信息");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取兼职信息列表异常！", e);
            baseResult = new BaseResult(false, "获取兼职信息列表异常！");
            result = JSON.toJSONString(baseResult);
        }
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
     * 审核兼职
     * @param
     * @return
     */
    @RequestMapping(value = "/auditingJob", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String auditingJob(@RequestParam(required = true) Long jobId,
                                     @RequestParam(required = true) String jobStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int resultCode = companyService.updateJobStatus(jobId,jobStatus);
            if(resultCode > 0) {
                baseResult = new BaseResult(true, "");
            } else {
                baseResult = new BaseResult(true, "修改兼职状态失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("修改兼职状态异常！", e);
            baseResult = new BaseResult(false, "修改兼职状态异常！");
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
    public String deleteJobById(@RequestParam(required = true) Long jobId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int resultCode = companyService.deleteJobById(jobId);
            if(resultCode > 0) {
                baseResult = new BaseResult(true, "");
            } else {
                baseResult = new BaseResult(true, "删除兼职失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("删除兼职异常！", e);
            baseResult = new BaseResult(false, "删除兼职异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }


    /**
     * 查看企业用户基本信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getCompanyInfoById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getCompanyInfoById(@RequestParam(required = true) Long companyId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            CCompany companyInfo = companyService.getCompanyInfo(companyId);
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
     * 查看企业用户评论信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getCompanyCommentById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getCompanyCommentById(@RequestParam(required = true) Integer offset,
                                        @RequestParam(required = true) Integer limit,
                                        @RequestParam(required = true) Long companyId) {
        String result = "";
        BaseResult baseResult = null;
        offset = offset ==null ? 0 :offset;//默认设置0
        limit = limit == null ? 10 : limit;//默认展示10条
        try{
            List<CComment> comments = companyService.getCompanyComment(companyId,offset,limit);
            int count = companyService.getCompanyCommentCount (companyId);
            if(comments != null && 0 < comments.size ()) {
                BootStrapTableResult tableResult = new BootStrapTableResult<CComment>(comments,count);
                baseResult = new BaseResult(true, "");
                baseResult.setData(tableResult);
            } else {
                baseResult = new BaseResult(true, "暂无评论");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取评论信息异常！", e);
            baseResult = new BaseResult(false, "获取评论信息异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 修改企业状态
     * @param
     * @return
     */
    @RequestMapping(value = "/updateCompanyStatus", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCompanyStatus(@RequestParam(required = true) Long companyId,
                                       @RequestParam(required = true) String compStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int resultCode = companyService.updateCompanyStatus(companyId,compStatus);
            if(resultCode > 0) {
                baseResult = new BaseResult(true, "");
            } else {
                baseResult = new BaseResult(true, "更新企业状态失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("更新企业状态异常！", e);
            baseResult = new BaseResult(false, "更新企业状态异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 修改大学生用户状态
     * @param
     * @return
     */
    @RequestMapping(value = "/updateStudentStatus", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateStudentStatus(@RequestParam(required = true) Long userId,
                                      @RequestParam(required = true) int userStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int resultCode = userService.updateStudentStatus(userId,userStatus);
            if(resultCode > 0) {
                baseResult = new BaseResult(true, "");
            } else {
                baseResult = new BaseResult(true, "更新用户状态失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("更新用户状态异常！", e);
            baseResult = new BaseResult(false, "更新用户状态异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 查看大学生用户基本信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getUserInfoById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getUserInfoById(@RequestParam(required = true) Long userId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            CUser userInfo = userService.getUserInfo(userId);
            if(userInfo != null) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(userInfo);
            } else {
                baseResult = new BaseResult(true, "该用户不存在");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取用户信息异常！", e);
            baseResult = new BaseResult(false, "获取用户信息异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 查看大学生用户评论信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getUserCommentById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getUserCommentById(@RequestParam(required = true) Integer offset,
                                        @RequestParam(required = true) Integer limit,
                                        @RequestParam(required = true) Long userId) {
        String result = "";
        BaseResult baseResult = null;
        offset = offset ==null ? 0 :offset;//默认设置0
        limit = limit == null ? 10 : limit;//默认展示10条
        try{
            List<CComment> comments = userService.getUserComment(userId,offset,limit);
            int count = userService.getUserCommentCount (userId);
            if(comments != null && 0 < comments.size ()) {
                BootStrapTableResult tableResult = new BootStrapTableResult<CComment>(comments,count);
                baseResult = new BaseResult(true, "");
                baseResult.setData(tableResult);
            } else {
                baseResult = new BaseResult(true, "暂无评论");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取评论信息异常！", e);
            baseResult = new BaseResult(false, "获取评论信息异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }
}
