package com.xy.ssm.dao;

import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CTeacher;
import com.xy.ssm.model.CJobs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wuchen on 2017/1/12.
 */

@Repository
//养成好习惯，将存储层Bean对应表明
public interface TeacherDao {
    Long insertJob(CJobs cJobs);
    CTeacher selectTeacherByAccount(@Param("teaAccount")String teaAccount);
    List<CJobs> selectJobsByTeacherId(@Param("queryTerm")String queryTerm, @Param("teacherId")Long teacherId, @Param("offset")Integer offset,@Param("limit") Integer limit,@Param("jobStatus")String  jobStatus);
    int selectJobsCountByTeacherId(@Param("queryTerm")String queryTerm, @Param("teacherId")Long teacherId);
    List<CJobs> selectAllJobs(@Param("jobStatus")String jobStatus,@Param("offset")Integer offset, @Param("limit")Integer limit);
    int selectAllJobsCount(@Param("jobStatus")String jobStatus);
    int updateJobStatus(@Param("jobId")Long jobId,@Param("jobStatus")String jobStatus);
    CJobs selectJobDetails(@Param("jobId")Long jobId);
    int getJobApplicationCount(@Param("jobId")Long jobId);
    int deleteJobById(@Param("jobId")Long jobId);
    List<CComment> getTeacherComment(@Param("teacherId")Long teacherId,@Param("offset")Integer offset,@Param("limit")Integer limit);
    int getTeacherCommentCount(@Param("teacherId")Long teacherId);
    int updateTeacherStatus(@Param("teacherId")Long teacherId,@Param("teaStatus")String teaStatus);
    List<CApplication> getEnrollmentSituation(@Param("jobId")Long jobId,@Param("appliStatus")String appliStatus);
    int updateApplicationStatus(@Param("jobId")Long jobId,@Param("userId")Long userId,@Param("appliStatus")String appliStatus);
    int updateCompPassword(@Param("newPw")String newPw,@Param("cTeacherId")Long cTeacherId);
    CTeacher getTeacherInfo(@Param("teacherId")Long teacherId);
    int updateJobSign(@Param("jobId")Long jobId);
    int updateCompSign(@Param("applicationId")Long applicationId,@Param("jobId")Long jobId);
    List<CTeacher> checkAccount (@Param("account")String account);
    List<CTeacher> checkPhone (@Param("phone")String phone);
    List<CTeacher> checkMail (@Param("email")String email);
    int updateTeacher (CTeacher cTeacher);
    List<CTeacher> getAllTeacher();
    int addTeacher(CTeacher cTeacher);
    /*添加文件*/
    void addFile(Map map);
    String getJobId(String jobCreateTime);
}
