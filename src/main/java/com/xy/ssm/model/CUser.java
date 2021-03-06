package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wuchenl on 2017/1/21.
 */
public class CUser implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //流水号
    private Long id;
    //用户名
    private String userName;
    //用户手机号
    private String userPhone;
    //用户头像，not use
    private String userIcon;
    //用户邮箱
    private String userEmail;
    //用户性别
    private String userGender;
    //用户真实姓名
    private String userRealName;
    //用户资源意向，not use
    private String userIntention;
    //用户专业
    private String userMajor;
    //用户院系
    private String userDepartments;
    //用户简介
    private String userProfile;
    //用户类型
    private Integer userType;
    //用户状态
    private Integer userStatus;

    public String getValidateCode() {
        return validateCode;
    }
    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    //用户密码
    private String userPassword;
    //出生日期
    private Date birthdate;
    //创建时间
    private Date createTime;
/*激活码*/
    private String validateCode;

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

    public String getUserMajor ()
    {
        return userMajor;
    }

    public void setUserMajor (String userMajor)
    {
        this.userMajor = userMajor;
    }

    public String getUserDepartments ()
    {
        return userDepartments;
    }

    public void setUserDepartments (String userDepartments)
    {
        this.userDepartments = userDepartments;
    }

    public String getUserProfile ()
    {
        return userProfile;
    }

    public void setUserProfile (String userProfile)
    {
        this.userProfile = userProfile;
    }

    public Integer getUserType ()
    {
        return userType;
    }

    public void setUserType (Integer userType)
    {
        this.userType = userType;
    }

    public Integer getUserStatus ()
    {
        return userStatus;
    }

    public void setUserStatus (Integer userStatus)
    {
        this.userStatus = userStatus;
    }

    public String getUserPassword ()
    {
        return userPassword;
    }

    public void setUserPassword (String userPassword)
    {
        this.userPassword = userPassword;
    }

    public Date getBirthdate ()
    {
        return birthdate;
    }

    public void setBirthdate (Date birthdate)
    {
        this.birthdate = birthdate;
    }

    public Date getCreateTime ()
    {
        return createTime;
    }

    public void setCreateTime (Date createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString ()
    {
        return "CUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userIntention='" + userIntention + '\'' +
                ", userMajor='" + userMajor + '\'' +
                ", userDepartments='" + userDepartments + '\'' +
                ", userProfile='" + userProfile + '\'' +
                ", userType=" + userType +
                ", userStatus=" + userStatus +
                ", userPassword='" + userPassword + '\'' +
                ", birthdate=" + birthdate +
                ", createTime=" + createTime +
             /*   ", validateCode='" + validateCode + '\'' +*/
                '}';
    }
}
