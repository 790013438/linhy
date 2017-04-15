package com.xy.ssm.service;

import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CCompany;
import com.xy.ssm.model.CJobs;

import java.util.List;

/**
 * Created by wuchenl on 2017/1/28.
 */
public interface CompanyService {
    /**
     * 发布兼职
     * @param cJobs
     * @return
     */
    Long addJobs(CJobs cJobs);
    CCompany getCompanyByAccount(String compAccount);
    List<CJobs> getJobsByCompanyId(String queryTerm,Long companyId, Integer offset,Integer limit);
    int getJobsCountByCompanyId(String queryTerm,Long companyId);
    List<CJobs> getAllJobs(String jobStatus,Integer offset,Integer limit);
    int getAllJobsCount(String jobStatus);
    int updateJobStatus(Long jobId,String jobStatus);
    CJobs getJobDetails(Long jobId);
    int getJobApplicationCount(Long jobId);
    int deleteJobById(Long jobId);
    CCompany getCompanyInfo(Long companyId);
    List<CComment> getCompanyComment(Long companyId,Integer offset,Integer limit);
    int getCompanyCommentCount(Long companyId);
    int updateCompanyStatus(Long companyId,String compStatus);
    List<CApplication> getEnrollmentSituation(Long jobId,String appliStatus);
    int updateApplicationStatus(Long jobId,Long userId,String appliStatus);
    int updateCompPassword(String newPw,Long cCompany);

}
