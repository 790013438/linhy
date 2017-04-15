package com.xy.ssm.dao;

import com.xy.ssm.model.CApplication;
import com.xy.ssm.model.CComment;
import com.xy.ssm.model.CCompany;
import com.xy.ssm.model.CJobs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuchen on 2017/1/12.
 */

@Repository
//养成好习惯，将存储层Bean对应表明
public interface CompanyDao {
    Long insertJob(CJobs cJobs);
    CCompany selectCompanyByAccount(@Param("compAccount")String compAccount);
    List<CJobs> selectJobsByCompanyId(@Param("queryTerm")String queryTerm, @Param("companyId")Long companyId, @Param("offset")Integer offset,@Param("limit") Integer limit);
    int selectJobsCountByCompanyId(@Param("queryTerm")String queryTerm, @Param("companyId")Long companyId);
    List<CJobs> selectAllJobs(@Param("jobStatus")String jobStatus,@Param("offset")Integer offset, @Param("limit")Integer limit);
    int selectAllJobsCount(@Param("jobStatus")String jobStatus);
    int updateJobStatus(@Param("jobId")Long jobId,@Param("jobStatus")String jobStatus);
    CJobs selectJobDetails(@Param("jobId")Long jobId);
    int getJobApplicationCount(@Param("jobId")Long jobId);
    int deleteJobById(@Param("jobId")Long jobId);
    List<CComment> getCompanyComment(@Param("companyId")Long companyId,@Param("offset")Integer offset,@Param("limit")Integer limit);
    int getCompanyCommentCount(@Param("companyId")Long companyId);
    int updateCompanyStatus(@Param("companyId")Long companyId,@Param("compStatus")String compStatus);
    List<CApplication> getEnrollmentSituation(@Param("jobId")Long jobId,@Param("appliStatus")String appliStatus);
    int updateApplicationStatus(@Param("jobId")Long jobId,@Param("userId")Long userId,@Param("appliStatus")String appliStatus);
    int updateCompPassword(@Param("newPw")String newPw,@Param("cCompanyId")Long cCompanyId);
    CCompany getCompanyInfo(@Param("companyId")Long companyId);
}
