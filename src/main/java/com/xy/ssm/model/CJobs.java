package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 兼职表
 */
public class CJobs implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //兼职id
    private Long id;
    //发布兼职企业id
    private Long jobCompanyId;
    //发布兼职企业id
    private String jobCompanyName;
    //兼职名称
    private String jobTitle;
    //兼职类型
    private String jobType ;
    //需求人数
    private int jobDemandNumber;
    //性别要求
    private String jobRequiresGender ;
    //薪资类型
    private String jobSalaryType;
    //每日工作时长
    private String jobHours  ;
    //薪资金额
    private String jobSalary;
    //工作地点
    private String jobAddress ;
    //兼职描述
    private String jobIntroduction;
    //联系电话
    private String jobContactPhone;
    //兼职状态
    private String jobStatus ;
    //标志
    private int flag ;
    //备注
    private String jobRemarks;
    //该兼职报名人数
    private int appliCount;
    //工作时间
    private Date jobTime;
    //报名截止时间
    private Date jobDeadline;
    //创建时间
    private Date createTime;

    public static long getSerialVersionUID ()
    {
        return serialVersionUID;
    }

    public Long getId ()
    {
        return id;
    }

    public void setId (Long id)
    {
        this.id = id;
    }

    public Long getJobCompanyId ()
    {
        return jobCompanyId;
    }

    public void setJobCompanyId (Long jobCompanyId)
    {
        this.jobCompanyId = jobCompanyId;
    }

    public String getJobCompanyName ()
    {
        return jobCompanyName;
    }

    public void setJobCompanyName (String jobCompanyName)
    {
        this.jobCompanyName = jobCompanyName;
    }

    public String getJobTitle ()
    {
        return jobTitle;
    }

    public void setJobTitle (String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public String getJobType ()
    {
        return jobType;
    }

    public void setJobType (String jobType)
    {
        this.jobType = jobType;
    }

    public int getJobDemandNumber ()
    {
        return jobDemandNumber;
    }

    public void setJobDemandNumber (int jobDemandNumber)
    {
        this.jobDemandNumber = jobDemandNumber;
    }

    public String getJobRequiresGender ()
    {
        return jobRequiresGender;
    }

    public void setJobRequiresGender (String jobRequiresGender)
    {
        this.jobRequiresGender = jobRequiresGender;
    }

    public String getJobSalaryType ()
    {
        return jobSalaryType;
    }

    public void setJobSalaryType (String jobSalaryType)
    {
        this.jobSalaryType = jobSalaryType;
    }

    public String getJobHours ()
    {
        return jobHours;
    }

    public void setJobHours (String jobHours)
    {
        this.jobHours = jobHours;
    }

    public String getJobSalary ()
    {
        return jobSalary;
    }

    public void setJobSalary (String jobSalary)
    {
        this.jobSalary = jobSalary;
    }

    public String getJobAddress ()
    {
        return jobAddress;
    }

    public void setJobAddress (String jobAddress)
    {
        this.jobAddress = jobAddress;
    }

    public String getJobIntroduction ()
    {
        return jobIntroduction;
    }

    public void setJobIntroduction (String jobIntroduction)
    {
        this.jobIntroduction = jobIntroduction;
    }

    public String getJobContactPhone ()
    {
        return jobContactPhone;
    }

    public void setJobContactPhone (String jobContactPhone)
    {
        this.jobContactPhone = jobContactPhone;
    }

    public String getJobStatus ()
    {
        return jobStatus;
    }

    public void setJobStatus (String jobStatus)
    {
        this.jobStatus = jobStatus;
    }

    public String getJobRemarks ()
    {
        return jobRemarks;
    }

    public void setJobRemarks (String jobRemarks)
    {
        this.jobRemarks = jobRemarks;
    }

    public int getAppliCount ()
    {
        return appliCount;
    }

    public void setAppliCount (int appliCount)
    {
        this.appliCount = appliCount;
    }

    public Date getJobDeadline ()
    {
        return jobDeadline;
    }

    public void setJobDeadline (Date jobDeadline)
    {
        this.jobDeadline = jobDeadline;
    }

    public Date getCreateTime ()
    {
        return createTime;
    }

    public void setCreateTime (Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getJobTime ()
    {
        return jobTime;
    }

    public void setJobTime (Date jobTime)
    {
        this.jobTime = jobTime;
    }

    public int getFlag ()
    {
        return flag;
    }

    public void setFlag (int flag)
    {
        this.flag = flag;
    }
}
