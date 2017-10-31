package com.sport.entity.manage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sport.common.annotation.Ignore;
import com.sport.common.annotation.Table;
import com.sport.util.DateUtil;

import java.util.Date;

@Table("t_news")
public class NewsEntity {
    @Ignore
    private Integer id;

    private String newsSubTitle;

    private String newsTitle;
    //发布时间
    @JsonFormat(pattern = DateUtil.TIME_PATTERN)
    private Date publishTime;
    @JsonFormat(pattern = DateUtil.TIME_PATTERN)
    private Date createTime;
    //是否发布（1：是，0：否）
    private Boolean isPublish;

    private String newsContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsSubTitle() {
        return newsSubTitle;
    }

    public void setNewsSubTitle(String newsSubTitle) {
        this.newsSubTitle = newsSubTitle;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Boolean getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Boolean isPublish) {
        this.isPublish = isPublish;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}