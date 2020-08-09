package com.jiangtf.demo.entity;

import java.util.Date;

public class ChannelMedisDto {
    private Long id;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String sysOrgCode;

    private String channelCode;

    private String mediaName;

    private String mediaAlias;

    private String mediaShortName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode == null ? null : sysOrgCode.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName == null ? null : mediaName.trim();
    }

    public String getMediaAlias() {
        return mediaAlias;
    }

    public void setMediaAlias(String mediaAlias) {
        this.mediaAlias = mediaAlias == null ? null : mediaAlias.trim();
    }

    public String getMediaShortName() {
        return mediaShortName;
    }

    public void setMediaShortName(String mediaShortName) {
        this.mediaShortName = mediaShortName == null ? null : mediaShortName.trim();
    }
}