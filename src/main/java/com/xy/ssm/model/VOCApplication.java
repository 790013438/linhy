package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 资源申请表
 */
public class VOCApplication implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //流水号
    private Long id;
    //申请用户id
    private Long appliUserId;
    //资源id
    private Long appliJobId;
    //申请状态
    private String appliStatus;
    //发布资源教师名称
    private String jobTeacherName;
    //资源名称
    private String jobTitle;
    //资源类型
    private String jobType ;
    //需求人数
    /*private int jobDemandNumber;*/
    //性别要求
    /*private String jobRequiresGender ;*/
    //薪资类型
    /*private String jobSalaryType;*/
    //建议每日学习时长
    private String jobHours  ;
    //薪资金额
   /* private String jobSalary;*/
    //工作地点
    /*private String jobAddress ;*/
    //资源描述
    private String jobIntroduction;
    //联系电话
    /*private String jobContactPhone;*/
    //资源状态
    private String jobStatus ;
    //备注
    /*private String jobRemarks;*/
    //截止时间
    private Date jobDeadline;
    //资源时间
    private Date jobTime;
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

    public String getAppliStatus ()
    {
        return appliStatus;
    }

    public void setAppliStatus (String appliStatus)
    {
        this.appliStatus = appliStatus;
    }

    public String getJobTeacherName ()
    {
        return jobTeacherName;
    }

    public void setJobTeacherName (String jobTeacherName)
    {
        this.jobTeacherName = jobTeacherName;
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

   /* public int getJobDemandNumber ()
    {
        return jobDemandNumber;
    }
    public void setJobDemandNumber (int jobDemandNumber)
    {
        this.jobDemandNumber = jobDemandNumber;
    }*/

   /* public String getJobRequiresGender ()
    {
        return jobRequiresGender;
    }
    public void setJobRequiresGender (String jobRequiresGender)
    {
        this.jobRequiresGender = jobRequiresGender;
    }*/
    /*public String getJobSalaryType ()
    {
        return jobSalaryType;
    }
    public void setJobSalaryType (String jobSalaryType)
    {
        this.jobSalaryType = jobSalaryType;
    }*/
    public String getJobHours ()
    {
        return jobHours;
    }

    public void setJobHours (String jobHours)
    {
        this.jobHours = jobHours;
    }

/*    public String getJobSalary ()
    {
        return jobSalary;
    }
    public void setJobSalary (String jobSalary)
    {
        this.jobSalary = jobSalary;
    }*/

/*    public String getJobAddress ()
    {
        return jobAddress;
    }
    public void setJobAddress (String jobAddress)
    {
        this.jobAddress = jobAddress;
    }*/

    public String getJobIntroduction ()
    {
        return jobIntroduction;
    }

    public void setJobIntroduction (String jobIntroduction)
    {
        this.jobIntroduction = jobIntroduction;
    }

/*    public String getJobContactPhone ()
    {
        return jobContactPhone;
    }
    public void setJobContactPhone (String jobContactPhone)
    {
        this.jobContactPhone = jobContactPhone;
    }*/

    public String getJobStatus ()
    {
        return jobStatus;
    }

    public void setJobStatus (String jobStatus)
    {
        this.jobStatus = jobStatus;
    }

/*    public String getJobRemarks ()
    {
        return jobRemarks;
    }
    public void setJobRemarks (String jobRemarks)
    {
        this.jobRemarks = jobRemarks;
    }*/

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
}
