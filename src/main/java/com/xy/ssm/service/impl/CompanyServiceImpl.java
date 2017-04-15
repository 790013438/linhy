package com.xy.ssm.service.impl;


import com.xy.ssm.dao.CompanyDao;
import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CCompany;
import com.xy.ssm.model.CJobs;
import com.xy.ssm.service.CompanyService;
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
public class CompanyServiceImpl implements CompanyService {
    
    @Resource
    private CompanyDao companyDao;

    public Long addJobs(CJobs cJobs) {
        return companyDao.insertJob(cJobs);
    }

    public CCompany getCompanyByAccount(String compAccount) {
        return companyDao.selectCompanyByAccount(compAccount);
    }

    public int updateJobStatus (Long jobId, String jobStatus)
    {
        return companyDao.updateJobStatus (jobId,jobStatus);
    }

    public CJobs getJobDetails (Long jobId)
    {
        return companyDao.selectJobDetails (jobId);
    }

    public int getJobApplicationCount (Long jobId)
    {
        return companyDao.getJobApplicationCount (jobId);
    }

    public int deleteJobById (Long jobId)
    {
        return companyDao.deleteJobById(jobId);
    }

    public CCompany getCompanyInfo (Long companyId)
    {
        return companyDao.getCompanyInfo(companyId);
    }

    public List<CComment> getCompanyComment (Long companyId, Integer offset, Integer limit)
    {
        return companyDao.getCompanyComment(companyId,offset,limit);
    }

    public int getCompanyCommentCount (Long companyId)
    {
        return companyDao.getCompanyCommentCount(companyId);
    }

    public int updateCompanyStatus (Long companyId, String compStatus)
    {
        return companyDao.updateCompanyStatus(companyId,compStatus);
    }

    public List<CApplication> getEnrollmentSituation (Long jobId, String appliStatus)
    {
        return companyDao.getEnrollmentSituation(jobId,appliStatus);
    }

    public int updateApplicationStatus (Long jobId, Long userId, String appliStatus)
    {
        return companyDao.updateApplicationStatus(jobId,userId,appliStatus);
    }

    public int updateCompPassword (String newPw, Long cCompany)
    {
        return companyDao.updateCompPassword(newPw,cCompany);
    }

    public List<CJobs> getJobsByCompanyId(String queryTerm, Long companyId, Integer offset, Integer limit) {
        return companyDao.selectJobsByCompanyId(queryTerm,companyId, offset, limit);
    }

    public int getJobsCountByCompanyId(String queryTerm, Long companyId) {
        return companyDao.selectJobsCountByCompanyId(queryTerm,companyId);
    }

    public List<CJobs> getAllJobs (String jobStatus, Integer offset, Integer limit)
    {
        return companyDao.selectAllJobs (jobStatus,offset,limit);
    }

    public int getAllJobsCount (String jobStatus)
    {
        return companyDao.selectAllJobsCount (jobStatus);
    }
}
