package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 兼职报名表
 */
public class VOCApplication implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //流水号
    private Long id;
    //报名用户id
    private Long appliUserId;
    //兼职id
    private Long appliJobId;
    //报名状态
    private int appliStatus;
    //发布兼职企业名称
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
    private int jobSalaryType;
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
    private int jobStatus ;
    //备注
    private String jobRemarks;
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

    public Long getAppliUserId ()
    {
        return appliUserId;
    }

    public void setAppliUserId (Long appliUserId)
    {
        this.appliUserId = appliUserId;
    }

    public Long getAppliJobId ()
    {
        return appliJobId;
    }

    public void setAppliJobId (Long appliJobId)
    {
        this.appliJobId = appliJobId;
    }

    public int getAppliStatus ()
    {
        return appliStatus;
    }

    public void setAppliStatus (int appliStatus)
    {
        this.appliStatus = appliStatus;
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

    public int getJobSalaryType ()
    {
        return jobSalaryType;
    }

    public void setJobSalaryType (int jobSalaryType)
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

    public int getJobStatus ()
    {
        return jobStatus;
    }

    public void setJobStatus (int jobStatus)
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
}
