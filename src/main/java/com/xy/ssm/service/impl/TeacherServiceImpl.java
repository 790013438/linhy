package com.xy.ssm.service.impl;


import com.xy.ssm.dao.TeacherDao;
import com.xy.ssm.model.*;
import com.xy.ssm.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wuchen on 2017/1/12.
 */

@Service
@Transactional(rollbackFor = Exception.class)
//上面是说如果发生异常时，将回滚到之前的状态
public class TeacherServiceImpl implements TeacherService {
    
    @Resource
    private TeacherDao teacherDao;

    public Long addJobs(CJobs cJobs) {
        return teacherDao.insertJob(cJobs);
    }

    public CTeacher getTeacherByAccount(String teaAccount) {
        return teacherDao.selectTeacherByAccount(teaAccount);
    }

    public int updateJobStatus (Long jobId, String jobStatus)
    {
        return teacherDao.updateJobStatus (jobId,jobStatus);
    }

    public CJobs getJobDetails (Long jobId)
    {
        return teacherDao.selectJobDetails (jobId);
    }

    public int getJobApplicationCount (Long jobId)
    {
        return teacherDao.getJobApplicationCount (jobId);
    }

    public int deleteJobById (Long jobId)
    {
        return teacherDao.deleteJobById(jobId);
    }

    public CTeacher getTeacherInfo (Long teacherId)
    {
        return teacherDao.getTeacherInfo(teacherId);
    }

    public List<CComment> getTeacherComment (Long teacherId, Integer offset, Integer limit)
    {
        return teacherDao.getTeacherComment(teacherId,offset,limit);
    }

    public int getTeacherCommentCount (Long teacherId)
    {
        return teacherDao.getTeacherCommentCount(teacherId);
    }

    public int updateTeacherStatus (Long teacherId, String teaStatus)
    {
        return teacherDao.updateTeacherStatus(teacherId,teaStatus);
    }

    public List<CApplication> getEnrollmentSituation (Long jobId, String appliStatus)
    {
        return teacherDao.getEnrollmentSituation(jobId,appliStatus);
    }

    public int updateApplicationStatus (Long jobId, Long userId, String appliStatus)
    {
        return teacherDao.updateApplicationStatus(jobId,userId,appliStatus);
    }

    public int updateCompPassword (String newPw, Long cTeacher)
    {
        return teacherDao.updateCompPassword(newPw,cTeacher);
    }

    public int updateJobSign (Long jobId)
    {
        return teacherDao.updateJobSign(jobId);
    }

    @Override
    public int updateCompSign (Long applicationId, Long jobId)
    {
        return teacherDao.updateCompSign(applicationId,jobId);
    }

    @Override
    public List<CTeacher> checkAccount (String account)
    {
        return teacherDao.checkAccount(account);
    }

    @Override
    public List<CTeacher> checkPhone (String phone)
    {
        return teacherDao.checkPhone(phone);
    }

    @Override
    public List<CTeacher> checkMail (String email)
    {
        return teacherDao.checkMail(email);
    }

    @Override
    public int updateTeacher (CTeacher cTeacher)
    {
        return teacherDao.updateTeacher(cTeacher);
    }

    @Override
    public List<CTeacher> getAllTeacher ()
    {
        return teacherDao.getAllTeacher();
    }

    @Override
    public int addTeacher (CTeacher cTeacher)
    {
        return teacherDao.addTeacher(cTeacher);
    }


    /*添加文件*/
    @Override
    public void addFile(Map map) {
    teacherDao.addFile(map);
    }
    /*通过创建时间，得到资源的id*/
    @Override
    public String getJobId(String jobCreateTime) {
        return teacherDao.getJobId(jobCreateTime);
    }
/*添加作业记录信息*/
    @Override
    public Long addHom(CHomework cHomework) {
        return teacherDao.addHom(cHomework);
    }
/*通过创建时间，得到作业的id*/
    @Override
    public String getHomId(String jobCreateTime) {
        return teacherDao.getHomId(jobCreateTime);
    }
/*添加作业文件*/
    @Override
    public void addHomFile(Map map) {
       teacherDao.addHomFile(map);
    }
/*根据资源id，得到资源文件信息*/
    @Override
    public List<CJobFile> getJobFiles(String file_job_id) {
        return teacherDao.getJobFiles(file_job_id);
    }

    /**
     * 根据uuid名字得到资源文件信息
     * @param filename
     * @return
     */
    @Override
    public CJobFile getJobFileDetails(String filename) {
        return teacherDao.getJobFileDetails(filename);
    }

    public List<CJobs> getJobsByTeacherId(String queryTerm, Long teacherId, Integer offset, Integer limit,String jobStatus) {
        return teacherDao.selectJobsByTeacherId(queryTerm,teacherId, offset, limit,jobStatus);
    }

    public int getJobsCountByTeacherId(String queryTerm, Long teacherId) {
        return teacherDao.selectJobsCountByTeacherId(queryTerm,teacherId);
    }

    public List<CJobs> getAllJobs (String jobStatus, Integer offset, Integer limit)
    {
        return teacherDao.selectAllJobs (jobStatus,offset,limit);
    }

    public int getAllJobsCount (String jobStatus)
    {
        return teacherDao.selectAllJobsCount (jobStatus);
    }
}
