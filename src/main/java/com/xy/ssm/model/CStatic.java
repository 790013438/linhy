package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 静态数据表
 */
public class CStatic implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //主键ID
    private Long id;
    //静态数据编码
    private String staticCode;
    //对应名称
    private String staticName;
    //对应值
    private String staticValue;
    //类型
    private String staticType ;
    //类型名
    private String staticTypeName ;
    //备注
    private String remark ;
    //状态
    private int status ;
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

    public String getStaticCode() {
        return staticCode;
    }

    public void setStaticCode(String staticCode) {
        this.staticCode = staticCode;
    }

    public String getStaticName() {
        return staticName;
    }

    public void setStaticName(String staticName) {
        this.staticName = staticName;
    }

    public String getStaticValue() {
        return staticValue;
    }

    public void setStaticValue(String staticValue) {
        this.staticValue = staticValue;
    }

    public String getStaticType() {
        return staticType;
    }

    public void setStaticType(String staticType) {
        this.staticType = staticType;
    }

    public String getStaticTypeName() {
        return staticTypeName;
    }

    public void setStaticTypeName(String staticTypeName) {
        this.staticTypeName = staticTypeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
