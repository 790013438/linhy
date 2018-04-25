package com.xy.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CTeacher;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.model.CUser;
import com.xy.ssm.service.CUserService;
import com.xy.ssm.service.TeacherService;
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
    private TeacherService teacherService;
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
    public String getJobsByTeacherId(@RequestParam(required = false) Integer offset,
                                     @RequestParam(required = false) Integer limit,
                                     @RequestParam(required = true) String jobStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CJobs> list = teacherService.getAllJobs(jobStatus,offset, limit);
            int count = teacherService.getAllJobsCount(jobStatus);
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
    @RequestMapping(value = "/getAllTeacher", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getAllTeacher() {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CTeacher> list = teacherService.getAllTeacher();
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
            CJobs job = teacherService.getJobDetails(jobId);
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
            CJobs cJobs=teacherService.getJobDetails (jobId);
            int resultCode = teacherService.updateJobStatus(jobId,jobStatus);
            if(resultCode > 0) {
                String message="资源id为<a href=\"jobDetails?id=" + jobId + "\">"+jobId+"</a>的资源已经审批！";
                messageService.sendMessage (MessageUtils.getMessage (cJobs.getJobTeacherId (),2L,1,message));
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
            int resultCode = teacherService.deleteJobById(jobId);
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
    @RequestMapping(value = "/getTeacherInfoById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getTeacherInfoById(@RequestParam(required = true) Long teacherId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            CTeacher teacherInfo = teacherService.getTeacherInfo(teacherId);
            if(teacherInfo != null) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(teacherInfo);
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
    @RequestMapping(value = "/getTeacherCommentById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getTeacherCommentById(@RequestParam(required = false) Integer offset,
                                        @RequestParam(required = false) Integer limit,
                                        @RequestParam(required = true) Long teacherId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CComment> comments = teacherService.getTeacherComment(teacherId,offset,limit);
            int count = teacherService.getTeacherCommentCount (teacherId);
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
    @RequestMapping(value = "/updateTeacherStatus", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateTeacherStatus(@RequestParam(required = true) Long teacherId,
                                       @RequestParam(required = true) String teaStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int resultCode = teacherService.updateTeacherStatus(teacherId,teaStatus);
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
