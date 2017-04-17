package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 兼职报名表
 */
public class CApplication implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //流水号
    private Long id;
    //报名用户id
    private Long appliUserId;
    //兼职id
    private Long appliJobId;
    //用户标记
    private int userSign;
    //报名状态
    private String appliStatus;
    //用户名
    private String userName;
    //用户手机号
    private String userPhone;
    //用户头像
    private String userIcon;
    //用户邮箱
    private String userEmail;
    //用户性别
    private String userGender;
    //用户真实姓名
    private String userRealName;
    //用户兼职意向---如发传单等。
    private String userIntention;
    //用户简介
    private String userProfile;
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

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public String getUserPhone ()
    {
        return userPhone;
    }

    public void setUserPhone (String userPhone)
    {
        this.userPhone = userPhone;
    }

    public String getUserIcon ()
    {
        return userIcon;
    }

    public void setUserIcon (String userIcon)
    {
        this.userIcon = userIcon;
    }

    public String getUserEmail ()
    {
        return userEmail;
    }

    public void setUserEmail (String userEmail)
    {
        this.userEmail = userEmail;
    }

    public String getUserGender ()
    {
        return userGender;
    }

    public void setUserGender (String userGender)
    {
        this.userGender = userGender;
    }

    public String getUserRealName ()
    {
        return userRealName;
    }

    public void setUserRealName (String userRealName)
    {
        this.userRealName = userRealName;
    }

    public String getUserIntention ()
    {
        return userIntention;
    }

    public void setUserIntention (String userIntention)
    {
        this.userIntention = userIntention;
    }

    public String getUserProfile ()
    {
        return userProfile;
    }

    public void setUserProfile (String userProfile)
    {
        this.userProfile = userProfile;
    }

    public Date getCreateTime ()
    {
        return createTime;
    }

    public void setCreateTime (Date createTime)
    {
        this.createTime = createTime;
    }

    public int getUserSign ()
    {
        return userSign;
    }

    public void setUserSign (int userSign)
    {
        this.userSign = userSign;
    }

    @Override
    public String toString ()
    {
        return "CApplication{" +
                "id=" + id +
                ", appliUserId=" + appliUserId +
                ", appliJobId=" + appliJobId +
                ", userSign=" + userSign +
                ", appliStatus='" + appliStatus + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userIntention='" + userIntention + '\'' +
                ", userProfile='" + userProfile + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
