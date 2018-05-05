package com.xy.ssm.service;

import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CTeacher;
import com.xy.ssm.model.CJobs;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wuchenl on 2017/1/28.
 */
public interface TeacherService {
    /**
     * 发布资源
     * @param cJobs
     * @return
     */
    Long addJobs(CJobs cJobs);
    CTeacher getTeacherByAccount(String teaAccount);
    List<CJobs> getJobsByTeacherId(String queryTerm,Long teacherId, Integer offset,Integer limit,String jobStatus);
    int getJobsCountByTeacherId(String queryTerm,Long teacherId);
    List<CJobs> getAllJobs(String jobStatus,Integer offset,Integer limit);
    int getAllJobsCount(String jobStatus);
    int updateJobStatus(Long jobId,String jobStatus);
    CJobs getJobDetails(Long jobId);
    int getJobApplicationCount(Long jobId);
    int deleteJobById(Long jobId);
    CTeacher getTeacherInfo(Long teacherId);
    List<CComment> getTeacherComment(Long teacherId,Integer offset,Integer limit);
    int getTeacherCommentCount(Long teacherId);
    int updateTeacherStatus(Long teacherId,String teaStatus);
    List<CApplication> getEnrollmentSituation(Long jobId,String appliStatus);
    int updateApplicationStatus(Long jobId,Long userId,String appliStatus);
    int updateCompPassword(String newPw,Long cTeacher);
    int updateJobSign(Long jobId);
    int updateCompSign(Long applicationId,Long jobId);
    List<CTeacher> checkAccount(String account);
    List<CTeacher> checkPhone(String phone);
    List<CTeacher> checkMail(String email);
    int updateTeacher(CTeacher cTeacher);
    List<CTeacher> getAllTeacher();
    int addTeacher(CTeacher cTeacher);
/*添加文件*/
void addFile(Map map);
/*通过创建时间，得到资源的id*/
String getJobId(String jobCreateTime);
}
