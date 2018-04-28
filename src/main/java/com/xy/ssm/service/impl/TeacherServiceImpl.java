package com.xy.ssm.service.impl;


import com.xy.ssm.dao.TeacherDao;
import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CTeacher;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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