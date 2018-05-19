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
    public String getJobId() {
        return teacherDao.getJobId();
    }
/*添加作业记录信息*/
    @Override
    public Long addHom(CHomework cHomework) {
        return teacherDao.addHom(cHomework);
    }
/*通过创建时间，得到作业的id*/
    @Override
    public String getHomId() {
        return teacherDao.getHomId();
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
   /*得到作业信息*/
    @Override
    public List<CHomework> getHomsByTeacherId(Long teacherId) {
        return teacherDao.getHomsByTeacherId(teacherId);
    }

    /**
     * 得到作业记录总数
     * @param teacherId
     * @return
     */
    @Override
    public int getHomsCountByTeacherId(Long teacherId) {
        return teacherDao.getHomsCountByTeacherId(teacherId);
    }
/*删除id的作业*/
    @Override
    public int deleteHomById(Long jobId) {
        return teacherDao.deleteHomById(jobId);
    }

    /**
     * 作业状态为待审核
     * @param jobId
     * @return
     */
    @Override
    public int updateHomStatus(Long jobId) {
        return teacherDao.updateHomStatus(jobId);
    }

    /**
     * 通过id得到作业详情
     * @param jobId
     * @return
     */
    @Override
    public CHomework getHomDetails(Long jobId) {
        return teacherDao.getHomDetails(jobId);
    }

    /**
     * 通过id得到对应作业文件
     * @param file_hom_id
     * @return
     */
    @Override
    public List<CHomFile> gethomFiles(Long file_hom_id) {
        return teacherDao.gethomFiles(file_hom_id);
    }

    /**
     * 通过作业文件名得到作业文件地址
     * @param filename
     * @return
     */
    @Override
    public CHomFile getHomFileDetails(String filename) {
        return teacherDao.getHomFileDetails(filename);
    }

    /**
     * 获取所有未截止的作业信息
     * @return
     */
    @Override
    public List<CHomework> getAllHomsOne() {
        return teacherDao.getAllHomsOne();
    }

    /**
     * 得到未截止作业总数
     * @return
     */
    @Override
    public int getAllHomsOneCount() {
        return teacherDao.getAllHomsOneCount();
    }
    /*获取已截止的作业*/
    @Override
    public List<CHomework> getOldHoms() {
        return teacherDao.getOldHoms();
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
