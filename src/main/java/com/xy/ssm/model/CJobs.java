package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 资源表
 */
public class CJobs implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //资源id
    private Long id;
    //发布资源教师id
    private Long jobTeacherId;
    //发布资源教师id
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
    //薪资金额
/*    private String jobSalary;*/
    //工作地点
  /*  private String jobAddress ;*/
    //资源描述
    private String jobIntroduction;
    //联系电话
/*    private String jobContactPhone;*/
    //资源状态
    private String jobStatus ;
    //标志
    private int flag ;
    //备注
    /*private String jobRemarks;*/
    //该资源报名人数
    private int appliCount;
    //工作时间
    private Double jobHours;
    //报名截止时间
    private Date jobDeadline;
    //创建时间
    private Date createTime;

    private String time;
    private String deadline;

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getDeadline ()
    {
        return deadline;
    }

    public void setDeadline (String deadline)
    {
        this.deadline = deadline;
    }

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

    public Long getJobTeacherId ()
    {
        return jobTeacherId;
    }

    public void setJobTeacherId (Long jobTeacherId)
    {
        this.jobTeacherId = jobTeacherId;
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

    /*public String getJobRequiresGender ()
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

    public Double getJobTime ()
    {
        return jobHours;
    }

    public void setJobTime (Double jobHours)
    {
        this.jobHours = jobHours;
    }
    public void setJobHours(Double jobHours){
        this.jobHours=jobHours;
    }
    public Double getJobHours(){
        return jobHours;
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
