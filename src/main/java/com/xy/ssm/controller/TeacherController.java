package com.xy.ssm.controller;


import com.alibaba.fastjson.JSON;
import com.xy.ssm.common.BaseResult;
import com.xy.ssm.common.BootStrapTableResult;
import com.xy.ssm.model.*;
import com.xy.ssm.service.TeacherService;
import com.xy.ssm.service.MessageService;
import com.xy.ssm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wuchen on 2017/1/12.
 */

@Controller
@RequestMapping("/teacher")
@SessionAttributes("currentUser")//讲登录后命名为currentUser的加入session
public class TeacherController extends BaseController {

/*    private static Date jobCreateTime=null;

    public void setJobCreateTime(Date jobCreateTime) {
        this.jobCreateTime = jobCreateTime;
    }

    public Date getJobCreateTime() {
        return jobCreateTime;
    }*/
    private Integer number;
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
    public String addJobs(@RequestParam(required = true) String  json, HttpServletRequest request) {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher)getLoginUser ().get ("loginuser");
        try{
            CJobs cJobs=(CJobs)JSON.parseObject (json,CJobs.class);
            cJobs.setCreateTime(new Date());
           /* setJobCreateTime(cJobs.getCreateTime());*///得到创建时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
     * 发布作业信息
     * @return
     */
    @RequestMapping(value = "/addHoms", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addHoms(@RequestParam(required = true) String  json, HttpServletRequest request) {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher)getLoginUser ().get ("loginuser");
        try{
            CHomework cHomework=(CHomework) JSON.parseObject (json,CHomework.class);
            cHomework.setCreateTime(new Date());
            /*setJobCreateTime(cHomework.getCreateTime());*///得到创建时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            cHomework.setHomDeadline(sdf.parse(cHomework.getDeadline()));
            Long teacherId = cTeacher.getId();
            cHomework.setTeacherId(teacherId);
            Long id = teacherService.addHom(cHomework);
            if(id != null){
                baseResult=new BaseResult(true,"保存作业信息成功");
            }else{
                baseResult=new BaseResult(false,"保存作业信息失败");
            }
        }catch (Exception e){
            log.error("保存作业信息异常,请先登录"+e);
            baseResult=new BaseResult(false,"保存作业信息异常，请先登录");
        }
        result= JSON.toJSONString(baseResult);
        return result;
    }
    /**
     * 发布资源文件
     * @return
     */
    @RequestMapping(value = "/addJobFiles", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    /*@ResponseBody*/
    public String addJobFiles(@RequestParam("job_file")MultipartFile[] files,HttpServletResponse response){
        /*SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
        String result="";
        /*文件上传*/
        /*上传文件保存目录*/
        Map<String,String> map=new HashMap();
        String savePath="E:\\spring-mvc-mybatis-IDEA\\upload\\";
        String id=teacherService.getJobId();/*format.format(jobCreateTime)*/
        map.put("file_job_id",id);
        if (files!=null && files.length!=0){
            for (MultipartFile file:files){
                String filename=file.getOriginalFilename();
                UUID uuid=UUID.randomUUID();
                String type=filename.substring(filename.lastIndexOf("."));
                map.put("file_name",uuid.toString()+type);
                map.put("file_route",savePath);
                map.put("file_realname",filename);
                map.put("file_size",((Long)(file.getSize()/1024)).toString());
                map.put("file_type",type);
                teacherService.addFile(map);
                result="success";
                try {
                    file.transferTo(new File(savePath+uuid+type));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            result="false";
        }
        return "redirect:/teacher/addJob?"+result;
    }
    /**
     * 发布作业文件
     * @return
     */
    @RequestMapping(value = "/addHomFiles", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    /*@ResponseBody*/
    public String addHomFiles(@RequestParam("hom_file")MultipartFile[] files,HttpServletResponse response){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result="";
        /*文件上传*/
        /*上传文件保存目录*/
        Map<String,String> map=new HashMap();
        String savePath="E:\\spring-mvc-mybatis-IDEA\\uploadHom\\";
        String id=teacherService.getHomId();/*String id=teacherService.getHomId();*/
       /* String id=teacherService.getHomId(jobCreateTime.toString());*/
        map.put("file_hom_id",id);
        if (files!=null && files.length!=0){
            for (MultipartFile file:files){
                UUID uuid=UUID.randomUUID();
                String filename=file.getOriginalFilename();
                String type=filename.substring(filename.lastIndexOf("."));
                map.put("file_route",savePath);
                map.put("file_realname",filename);
                map.put("file_name",uuid.toString()+type);
                map.put("file_size",((Long)(file.getSize()/1024)).toString());
                map.put("file_type",type);
                teacherService.addHomFile(map);
                try {
                    file.transferTo(new File(savePath+uuid+type));
                    result="success";
                } catch (IOException e) {
                    e.printStackTrace();
                    result="false";
                }
            }
        }else{
            result="false";
        }
        return "redirect:/teacher/addHom?"+result;
    }
    /*downloadJobFiles 资源文件下载*/
    @RequestMapping(value="/downloadJobFiles",  produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void downloadJobFiles(@RequestParam("name") String filename){

        CJobFile jobFile=teacherService.getJobFileDetails(filename);
        String path=jobFile.getFile_route();
        File file=new File(path, jobFile.getFile_name());
        if (!file.exists()){
            try {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType==null){
            mimeType="application/octet-stream";
        }
        response.setContentType(mimeType);
        try {
            response.setHeader("Content-disposition",String.format("attachment;filename=\"%s\"", URLEncoder.encode(file.getName(),"UTF-8")));
            response.setContentLength((int)file.length());
            InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream,response.getOutputStream());
            inputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*downloadHomFiles 作业文件下载*/
    @RequestMapping(value="/downloadHomFiles",  produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public void downloadHomFiles(@RequestParam("name") String filename)throws Exception{

        CHomFile homFile=teacherService.getHomFileDetails(filename);
        String path=homFile.getFile_route();
        File file=new File(path, homFile.getFile_name());
        if (!file.exists()){
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType==null){
            mimeType="application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setHeader("Content-disposition",String.format("attachment;filename=\"%s\"", URLEncoder.encode(file.getName(),"UTF-8")));
        response.setContentLength((int)file.length());
        InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream,response.getOutputStream());
        inputStream.close();
    }
    /**
     * 分页获取当前教师发布的资源信息列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getHomsByTeacherId", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getHomsByTeacherId() {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher)getLoginUser ().get ("loginuser");
        Long teacherId = cTeacher.getId();
        try{
            List<CHomework> list = teacherService.getHomsByTeacherId(teacherId);
            System.out.println("========================="+list.get(0).getHomTitle()+list.get(0).getHomType());
            int count = teacherService.getHomsCountByTeacherId(teacherId);
            if(list != null && 0<list.size()) {
                BootStrapTableResult tableResult = new BootStrapTableResult<CHomework>(list,count);
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
     * 分页获取当前教师发布的作业信息列表
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
     * @RequestParam(required = true) Integer demandNumber,
     */
    @RequestMapping(value = "/screenApplicationUser", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getEnrollmentSituation(@RequestParam(required = true) Long jobId,@RequestParam(required = true) Long userId,@RequestParam(required = true) String appliStatus) {
        String result = "";
        BaseResult baseResult = null;
        try{
            if(appliStatus.equals ("appli_successful")){
                //查询报名成功的人数
                List<CApplication> applicationList = teacherService.getEnrollmentSituation(jobId,"appli_successful");
                int appliSuccessCount = applicationList.size ();
 /*               if(appliSuccessCount == demandNumber){
                    baseResult = new BaseResult(false, "人数已达到需求人数");
                }else{*/
                    int resultCode = teacherService.updateApplicationStatus(jobId,userId,appliStatus);
                    if(resultCode  > 0) {
                        baseResult = new BaseResult(true, "");
                    } else {
                        baseResult = new BaseResult(false, "修改用户报名状态失败");
                    }
                /*}*/
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
     * 删除某作业
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteHomById", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String deleteHomById(@RequestParam(required = true) Long homId,@ModelAttribute("currentUser")CTeacher cTeacher) {
        String result = "";
        BaseResult baseResult = null;
        try{
            int rs = teacherService.deleteHomById (homId);
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
     * 资源提交审核
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
                    String message="资源序号为"+jobId+"的资源进行请求审批！";
                    messageService.sendMessage (
                            new CMessage(cTeacher.getId(),null,1,
                                    message,0,new Date(),0,2)
                    );
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
     * 作业提交审核
     * @param
     * @return
     */
    @RequestMapping(value = "/submitHomAudit", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String submitHomAudit(@RequestParam(required = true) Long jobId) {
        String result = "";
        BaseResult baseResult = null;
        CTeacher cTeacher =(CTeacher) getLoginUser ().get ("loginuser");
        /*String jobStatus = "1";*/
        try{
            if(cTeacher.getTeaStatus().equals ("comp_apply")){
                baseResult=new BaseResult(false,"教师还未通过审核，暂不能提交资源");
            }else{
                int rs = teacherService.updateHomStatus (jobId);
                if(rs > 0){
                    String message="作业记录序号为"+jobId+"的作业记录进行发布！";
                    /*发送信息，暂时没有改*/
                    messageService.sendMessage (
                            new CMessage(cTeacher.getId(),null,2,
                                    message,0,new Date(),0,2)
                    );
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
     * 通过id得到资源详情
     * @param jobId
     * @param request
     * @return
     */
    @RequestMapping(value = "/getJobDetails", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getJobDetails(@RequestParam(required = true) Long jobId, HttpServletRequest request) {
        String result = "";
        BaseResult baseResult = null;
        List list=new ArrayList();
        try{
            CJobs job = teacherService.getJobDetails(jobId);
            if(job != null) {
                baseResult = new BaseResult(true, "");
                list.add(job);
                String file_job_id=job.getId().toString();
                List<CJobFile> jobFile=teacherService.getJobFiles(file_job_id);
                list.add(jobFile);
                baseResult.setData(list);
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
     * 通过id得到作业详情
     * @param jobId
     * @param request
     * @return
     */
    @RequestMapping(value = "/getHomDetails", produces = {"application/json;charset=UTF-8"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getHomDetails(@RequestParam(required = true) Long jobId, HttpServletRequest request) {
        String result = "";
        BaseResult baseResult = null;
        List list=new ArrayList();
        try{
            CHomework homework = teacherService.getHomDetails(jobId);
            if(homework != null) {
                baseResult = new BaseResult(true, "");
                list.add(homework);
                Long file_hom_id=homework.getId();
                List<CHomFile> homFile=teacherService.gethomFiles(file_hom_id);
                list.add(homFile);
                baseResult.setData(list);
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
