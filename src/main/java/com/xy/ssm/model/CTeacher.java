package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 教师信息表
 */
public class CTeacher implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //流水号
    private Long id;
    //教师账户名
    private String teaAccount;
    //登录密码
    private String teaPassword;
/*    教师网站
    private String commWebsite ;*/
    //教师名
    private String teaName ;
    //教师职称
    private String teaContacts;
    //联系电话
    private String teaPhone ;
    //教师邮箱
    private String teaEmail;
    //教师信息
    private String teaInfo ;
    //教师执照
    private String teaLicense;
    //教师地址
    private String teaAddress ;
    //用户头像
    private String teaPhoto;
    //状态
    private String teaStatus ;
    //创建时间
    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



/*    public String getCommWebsite ()
    {
        return commWebsite;
    }*/

/*    public void setCommWebsite (String commWebsite)
    {
        this.commWebsite = commWebsite;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeaAccount() {
        return teaAccount;
    }

    public void setTeaAccount(String teaAccount) {
        this.teaAccount = teaAccount;
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaContacts() {
        return teaContacts;
    }

    public void setTeaContacts(String teaContacts) {
        this.teaContacts = teaContacts;
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone;
    }

    public String getTeaEmail() {
        return teaEmail;
    }

    public void setTeaEmail(String teaEmail) {
        this.teaEmail = teaEmail;
    }

    public String getTeaInfo() {
        return teaInfo;
    }

    public void setTeaInfo(String teaInfo) {
        this.teaInfo = teaInfo;
    }

    public String getTeaLicense() {
        return teaLicense;
    }

    public void setTeaLicense(String teaLicense) {
        this.teaLicense = teaLicense;
    }

    public String getTeaAddress() {
        return teaAddress;
    }

    public void setTeaAddress(String teaAddress) {
        this.teaAddress = teaAddress;
    }

    public String getTeaPhoto() {
        return teaPhoto;
    }

    public void setTeaPhoto(String teaPhoto) {
        this.teaPhoto = teaPhoto;
    }

    public String getTeaStatus() {
        return teaStatus;
    }

    public void setTeaStatus(String teaStatus) {
        this.teaStatus = teaStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
