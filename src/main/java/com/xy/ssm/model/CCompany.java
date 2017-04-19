package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 企业信息表
 */
public class CCompany implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //流水号
    private Long id;
    //企业账户名
    private String compAccount;
    //登录密码
    private String compPassword;
    //公司网站
    private String commWebsite ;
    //公司名
    private String compName ;
    //公司联系人
    private String compContacts;
    //联系电话
    private String compPhone ;
    //公司邮箱
    private String compEmail;
    //公司信息
    private String compInfo ;
    //公司执照
    private String compLicense;
    //公司地址
    private String compAddress ;
    //用户头像
    private String compPhoto;
    //状态
    private String compStatus ;
    //创建时间
    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompAccount() {
        return compAccount;
    }

    public void setCompAccount(String compAccount) {
        this.compAccount = compAccount;
    }

    public String getCompPassword() {
        return compPassword;
    }

    public void setCompPassword(String compPassword) {
        this.compPassword = compPassword;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompContacts() {
        return compContacts;
    }

    public void setCompContacts(String compContacts) {
        this.compContacts = compContacts;
    }

    public String getCompPhone() {
        return compPhone;
    }

    public void setCompPhone(String compPhone) {
        this.compPhone = compPhone;
    }

    public String getCompEmail() {
        return compEmail;
    }

    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail;
    }

    public String getCompInfo() {
        return compInfo;
    }

    public void setCompInfo(String compInfo) {
        this.compInfo = compInfo;
    }

    public String getCompLicense() {
        return compLicense;
    }

    public void setCompLicense(String compLicense) {
        this.compLicense = compLicense;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCommWebsite ()
    {
        return commWebsite;
    }

    public void setCommWebsite (String commWebsite)
    {
        this.commWebsite = commWebsite;
    }

    public String getCompPhoto() {
        return compPhoto;
    }

    public void setCompPhoto(String compPhoto) {
        this.compPhoto = compPhoto;
    }

    public String getCompStatus ()
    {
        return compStatus;
    }

    public void setCompStatus (String compStatus)
    {
        this.compStatus = compStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
