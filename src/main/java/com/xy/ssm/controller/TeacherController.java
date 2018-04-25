package com.xy.ssm.controller;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.*;
import com.xy.ssm.service.TeacherService;
import com.xy.ssm.service.MessageService;
import com.xy.ssm.service.UserService;
import com.xy.ssm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */

@Controller
@RequestMapping("/teacher")
@SessionAttributes("currentUser")//讲登录后命名为currentUser的加入session
public class TeacherController extends BaseController {

    private Logger log = Logger.getLogger(TeacherController.class);
    //上面是LOG的声明，下面的Resource 可以考虑使用Autowired来注入Service
    @Resource
    private TeacherService teacherService;

    @Autowired
    private MessageService messageService;

//    /**
//     * 跳转到教师用户页面
//     * @return
//     */
//    @RequestMapping("index")
//    private String toIndex(){
//        log.info("--------------------call:index");
//        return "jz_index";
//    }

    /**
     * 发布资源信息
     * @return
     */
    @RequestMapping(value = "/addJobs", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addJobs(@RequestParam(required = true) String  json) {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher)getLoginUser ().get ("loginuser");
        try{
            CJobs cJobs=(CJobs)JSON.parseObject (json,CJobs.class);
            log.info (JSON.toJSONString (cJobs));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            cJobs.setJobTime (sdf.parse (cJobs.getTime()));
            cJobs.setJobDeadline (sdf.parse(cJobs.getDeadline()));
            Long teacherId = cTeacher.getId();
            cJobs.setJobTeacherId(teacherId);
            Long id = teacherService.addJobs(cJobs);
            if(id != null){
                baseResult=new BaseResult(true,"保存资源信息成功");
            }else{
                baseResult=new BaseResult(false,"保存资源信息失败");
            }
        }catch (Exception e){
            log.error("保存资源信息异常,请先登录"+e);
            baseResult=new BaseResult(false,"保存资源信息异常，请先登录");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }

    /**
     * 分页获取当前教师发布的资源信息列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getJobsByTeacherId", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobsByTeacherId(@RequestParam(required = false) Integer offset,
                                     @RequestParam(required = false) Integer limit,
                                     @RequestParam(required = false) String queryTerm,
                                     @RequestParam(required = false) String jobStatus) {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher)getLoginUser ().get ("loginuser");
        Long teacherId = cTeacher.getId();
        try{
            List<CJobs> list = teacherService.getJobsByTeacherId(queryTerm,teacherId, offset,limit,jobStatus);
            int count = teacherService.getJobsCountByTeacherId(queryTerm,teacherId);
            if(list != null && 0<list.size()) {
                BootStrapTableResult tableResult = new BootStrapTableResult<CJobs>(list,count);
                baseResult = new BaseResult(true, "");
                baseResult.setData(tableResult);
            } else {
                baseResult = new BaseResult(true, "没有查询到相关信息");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取资源信息列表异常！", e);
            baseResult = new BaseResult(false, "当前教师发布的资源信息列表异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 获取资源报名情况
     * @param
     * @return
     */
    @RequestMapping(value = "/getEnrollmentSituation", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getEnrollmentSituation(@RequestParam(required = true) Long jobId,@RequestParam(required = false) String appliStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            List<CApplication> applicationList = teacherService.getEnrollmentSituation(jobId,appliStatus);
            if(applicationList != null && 0<applicationList.size()) {
                baseResult = new BaseResult(true, "");
                baseResult.setData(applicationList);
            } else {
                baseResult = new BaseResult(false, "暂无资源报名情况");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("获取资源报名情况异常！", e);
            baseResult = new BaseResult(false, "获取资源报名情况异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     * 筛选资源用户
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
                List<CApplication> applicationList = teacherService.getEnrollmentSituation(jobId,"appli_successful");
                int appliSuccessCount = applicationList.size ();
                if(appliSuccessCount == demandNumber){
                    baseResult = new BaseResult(false, "人数已达到需求人数");
                }else{
                    int resultCode = teacherService.updateApplicationStatus(jobId,userId,appliStatus);
                    if(resultCode  > 0) {
                        baseResult = new BaseResult(true, "");
                    } else {
                        baseResult = new BaseResult(false, "修改用户报名状态失败");
                    }
                }
            }else{
                int resultCode = teacherService.updateApplicationStatus(jobId,userId,appliStatus);
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
     * 删除某资源
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteJobById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteJobById(@RequestParam(required = true) Long jobId,@ModelAttribute("currentUser")CTeacher cTeacher) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int rs = teacherService.deleteJobById (jobId);
            if(rs > 0){
                baseResult=new BaseResult(true,"删除资源成功");
            }else{
                baseResult=new BaseResult(false,"删除资源失败");
            }
        }catch (Exception e){
            log.error("删除资源异常"+e);
            baseResult=new BaseResult(false,"删除资源异常");
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
        CTeacher cTeacher =(CTeacher) getLoginUser ().get ("loginuser");
        String jobStatus = "1";
        try{
            if(cTeacher.getTeaStatus().equals ("comp_apply")){
                baseResult=new BaseResult(false,"教师还未通过审核，暂不能提交资源");
            }else{
                int rs = teacherService.updateJobStatus (jobId,jobStatus);
                if(rs > 0){
                    String message="资源id为"+jobId+"的资源进行请求审批！";
                    messageService.sendMessage (MessageUtils.getMessage (1L,1L,1,message));
                    baseResult=new BaseResult(true,"");
                }else{
                    baseResult=new BaseResult(false,"提交审核失败");
                }
            }
        }catch (Exception e){
            log.error("提交审核异常"+e);
            baseResult=new BaseResult(false,"提交审核异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }
    /**
     *修改教师用户密码
     * @param
     * @return
     */
    @RequestMapping(value = "/updateCompPassword", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCompPassword(@RequestParam(required = true)String oldPassword,
                                 @RequestParam(required = true)String newPassword) {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher)getLoginUser ().get ("loginuser");
        try{
            String oldPw = MD5Util.encode2hex(oldPassword);
            String newPw = MD5Util.encode2hex(newPassword);
            if(!cTeacher.getTeaPassword().equals(oldPw))
            {
                baseResult = new BaseResult(false, "密码错误");
            }else {
                int rs = teacherService.updateCompPassword(newPw,cTeacher.getId ());
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
     * 查看资源详情
     * @param
     * @return
     */
    @RequestMapping(value = "/getJobDetails", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobDetails(@RequestParam(required = true) Long jobId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            CJobs job = teacherService.getJobDetails(jobId);
            if(job != null) {
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
     * 移除资源（该资源对教师用户不可见）
     * @param
     * @return
     */
    @RequestMapping(value = "/removeJobById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String removeJobById(@RequestParam(required = true) Long jobId) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int resultCode = teacherService.updateJobSign(jobId);
            if(resultCode > 0) {
                baseResult = new BaseResult(true, "");
            } else {
                baseResult = new BaseResult(true, "移除资源失败");
            }
            result= JSON.toJSONString(baseResult);
        }catch (Exception e) {
            log.error("移除资源异常！", e);
            baseResult = new BaseResult(false, "移除资源异常！");
            result = JSON.toJSONString(baseResult);
        }
        return result;
    }

    /**
     *删除资源记录
     * @param applicationId
     * @return
     */
    @RequestMapping(value = "/updateCompSign", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateCompSign(@RequestParam(required = true) Long  applicationId,
                                 @RequestParam(required = true) Long  jobId) {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher)getLoginUser ().get ("loginuser");
        try{
            int re=teacherService.updateCompSign (applicationId,jobId);
            if(re > 0){
                baseResult=new BaseResult(true,"");
            }else {
                baseResult=new BaseResult(true,"删除资源记录失败");
            }
        }catch (Exception e){
            log.error("删除资源记录异常"+e);
            baseResult=new BaseResult(false,"删除资源记录异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }
    /**
     * 查看教师用户基本信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getTeacherInfoById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getTeacherInfoById() {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher) getLoginUser ().get ("loginuser");
        try{
            CTeacher teacherInfo = teacherService.getTeacherInfo(cTeacher.getId ());
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
     *修改用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "/updateTeacherInfo", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updateUserInfo(CTeacher  cTeacher) {
        log.info("--------------------/teacher/updateTeacherInfo  called");
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher1 =(CTeacher) getLoginUser ().get ("loginuser");
        cTeacher.setId (cTeacher1.getId ());
        try{
            List<CTeacher> cTeachers = teacherService.checkAccount (cTeacher.getTeaAccount());
            List<CTeacher> cTeachers1 = teacherService.checkPhone (cTeacher.getTeaPhone());
            List<CTeacher> cTeachers2 = teacherService.checkMail (cTeacher.getTeaEmail());
            if(cTeachers != null && cTeachers.size() > 1){
                baseResult=new BaseResult(false,"登录名已存在，请重新输入");
            }else if(cTeachers.size() == 1 && !cTeachers.get(0).getId().toString().equals(cTeacher.getId().toString())){
                baseResult=new BaseResult(false,"登录名已存在，请重新添加");
            }else{
                if(cTeachers1 != null && cTeachers1.size() > 1){
                    baseResult=new BaseResult(false,"手机号已存在，请重新输入");
                }else if(cTeachers1.size() == 1 && !cTeachers1.get(0).getId().toString().equals(cTeacher.getId().toString())){
                    baseResult=new BaseResult(false,"登录名已存在，请重新添加");
                }else{
                    if(cTeachers2 != null && cTeachers2.size() > 1){
                        baseResult=new BaseResult(false,"邮箱已存在，请重新输入");
                    }else if(cTeachers2.size() == 1 && !cTeachers2.get(0).getId().toString().equals(cTeacher.getId().toString())){
                        baseResult=new BaseResult(false,"邮箱已存在，请重新添加");
                    }else{
                        int rs = teacherService.updateTeacher(cTeacher);
                        if (rs == 1) {
                            baseResult = new BaseResult(true, "修改教师信息成功");
                        } else {
                            baseResult = new BaseResult(true, "修改教师信息失败");
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error("修改教师信息异常"+e);
            baseResult=new BaseResult(false,"修改教师信息异常");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }
    /*将用户名检测功能放到了UserController里面，放在这里会被spring-mvc里面配置的连接器拦截，返回login页*/
}
