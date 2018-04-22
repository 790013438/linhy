package com.xy.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CCompany;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.model.CUser;
import com.xy.ssm.service.CUserService;
import com.xy.ssm.service.CompanyService;
import com.xy.ssm.service.MessageService;
import com.xy.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wuchenl on 2017/1/13.
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController
{

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @Resource
    private CompanyService companyService;
    @Resource
    private CUserService cUserService;
    @Autowired
    private MessageService messageService;
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
     * 按状态获取资源列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllJobs", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobsByCompanyId(@RequestParam(required = false) Integer offset,
                                     @RequestParam(required = false) Integer limit,
                                     @RequestParam(required = true) String jobStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CJobs> list = companyService.getAllJobs(jobStatus,offset, limit);
            int count = companyService.getAllJobsCount(jobStatus);
            if(list != null && 0<list.size()) {
                BootStrapTableResult tableResult = new BootStrapTableResult<CJobs>(list,count);
                baseResult = new BaseResult(true, "");
                baseResult.setData(tableResult);
            } else {
                baseResult = new BaseResult(true, "没有查询到待审核资源信息");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取资源信息列表异常！", e);
            baseResult = new BaseResult(false, "获取资源信息列表异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 获取大学生用户列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllUsers", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getAllUsers() {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CUser> list = userService.getAllUsers();
            if(list != null && 0<list.size()) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(list);
            } else {
                baseResult = new BaseResult(true, "暂无用户信息");
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
     * 按状态获取教师信息列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllCompany", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getAllCompany() {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CCompany> list = companyService.getAllCompany();
            if(list != null && 0<list.size()) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(list);
            } else {
                baseResult = new BaseResult(true, "没有查询教师信息");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取教师信息列表异常！", e);
            baseResult = new BaseResult(false, "获取教师信息列表异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 查看资源详情
     * @param
     * @return
     */
    @RequestMapping(value = "/getJobDetails", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobDetails(@RequestParam(required = true) Long jobId) {
        String result = "";
        BaseResult baseResult = null;
        CUser cUser =(CUser) getLoginUser ().get ("loginuser");
        try{
            CJobs job = companyService.getJobDetails(jobId);
            if(job != null) {
                if(cUserService.getAppliByTwoId(job.getId (),cUser.getId ()) != null){
                    job.setFlag(1);
                }else{
                    job.setFlag(0);
                }
                baseResult = new BaseResult(true, "");
                baseResult.setData(job);
            } else {
                baseResult = new BaseResult(true, "该资源不存在");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取资源信息详情异常！", e);
            baseResult = new BaseResult(false, "获取资源信息详情异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 审核资源
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
            CJobs cJobs=companyService.getJobDetails (jobId);
            int resultCode = companyService.updateJobStatus(jobId,jobStatus);
            if(resultCode > 0) {
                String message="资源id为<a href=\"jobDetails?id=" + jobId + "\">"+jobId+"</a>的资源已经审批！";
                messageService.sendMessage (MessageUtils.getMessage (cJobs.getJobCompanyId (),2L,1,message));
                baseResult = new BaseResult(true, "");
            } else {
                baseResult = new BaseResult(true, "修改资源状态失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("修改资源状态异常！", e);
            baseResult = new BaseResult(false, "修改资源状态异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 删除某资源
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
                baseResult = new BaseResult(true, "删除资源失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("删除资源异常！", e);
            baseResult = new BaseResult(false, "删除资源异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }


    /**
     * 查看教师用户基本信息
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
                baseResult = new BaseResult(true, "该教师不存在");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取教师信息异常！", e);
            baseResult = new BaseResult(false, "获取教师信息异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 查看教师用户评论信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getCompanyCommentById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getCompanyCommentById(@RequestParam(required = false) Integer offset,
                                        @RequestParam(required = false) Integer limit,
                                        @RequestParam(required = true) Long companyId) {
        String result = "";
        BaseResult baseResult = null;
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
     * 修改教师状态
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
                baseResult = new BaseResult(true, "更新教师状态失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("更新教师状态异常！", e);
            baseResult = new BaseResult(false, "更新教师状态异常！");
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
