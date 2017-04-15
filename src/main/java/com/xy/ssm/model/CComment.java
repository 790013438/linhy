package com.xy.ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiongyan on 2017/2/11.
 * 兼职报名表
 */
public class CComment implements Serializable {
    private static final long serialVersionUID = 4015147211524700827L;
    //流水号
    private Long id;
    //被评论对象ID
    private Long commCommentatorId;
    //评论内容
    private String commContent;
    //发布评论人的ID
    private Long commPublisherId ;
    //评论类型
    private int commType;
    //评论者头像
    private String commPublisheIcon ;
    //评论者用户名
    private String commPublisheName;
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

    public Long getCommCommentatorId() {
        return commCommentatorId;
    }

    public void setCommCommentatorId(Long commCommentatorId) {
        this.commCommentatorId = commCommentatorId;
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent;
    }

    public Long getCommPublisherId() {
        return commPublisherId;
    }

    public void setCommPublisherId(Long commPublisherId) {
        this.commPublisherId = commPublisherId;
    }

    public int getCommType() {
        return commType;
    }

    public void setCommType(int commType) {
        this.commType = commType;
    }

    public String getCommPublisheIcon() {
        return commPublisheIcon;
    }

    public void setCommPublisheIcon(String commPublisheIcon) {
        this.commPublisheIcon = commPublisheIcon;
    }

    public String getCommPublisheName() {
        return commPublisheName;
    }

    public void setCommPublisheName(String commPublisheName) {
        this.commPublisheName = commPublisheName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
