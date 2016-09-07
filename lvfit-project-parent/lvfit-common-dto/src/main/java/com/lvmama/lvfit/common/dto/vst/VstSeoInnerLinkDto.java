/**
 * Project Name:lvfit-common-dto
 * File Name:VstPicComment.java
 * Package Name:com.lvmama.lvfit.common.dto.vst
 * Date:2015-11-27下午3:39:58
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.vst;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * Date:     2016-01-15 <br/>
 * @author   yueyufan
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class VstSeoInnerLinkDto implements java.io.Serializable{
	private Long destLinkId;//主键id
    private Long destId;//目的地id 关联查询上级行政区域
    private Long linkDestType;//关键词属性（城市1，景区2，酒店3，【点评4,...副表】）
    private Long linkType;//关键词类型 （美食..副表）
    private Long linkSubject;//关键词主题 （历史城市... 副表）
    private String linkName;//关键字
    private String linkUrl;//链接地址
    private String isTop;//是否置顶（推荐置顶Y/N）
    private Long linkSeq;//排序指数
    private String destName;
    private String destParentName;
    private String destParentId;

    private String linkTypeName;
    private String linkSubjectName;
    private String linkDestTypeName;
    private String destIdStr;
    private Long startSeq;
    private Long endSeq;

    public Long getDestLinkId() {
        return destLinkId;
    }

    public void setDestLinkId(Long destLinkId) {
        this.destLinkId = destLinkId;
    }

    public Long getDestId() {
        return destId;
    }

    public void setDestId(Long destId) {
        this.destId = destId;
    }
    
    public Long getLinkDestType() {
        return linkDestType;
    }

    public void setLinkDestType(Long linkDestType) {
        this.linkDestType = linkDestType;
    }

    public Long getLinkType() {
        return linkType;
    }

    public void setLinkType(Long linkType) {
        this.linkType = linkType;
    }

   public Long getLinkSubject() {
        return linkSubject;
    }

    public void setLinkSubject(Long linkSubject) {
        this.linkSubject = linkSubject;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    @JsonIgnore
    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public Long getLinkSeq() {
        return linkSeq;
    }

    public void setLinkSeq(Long linkSeq) {
        this.linkSeq = linkSeq;
    }
    
    @JsonIgnore
    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    @JsonIgnore
    public String getDestParentName() {
        return destParentName;
    }

    public void setDestParentName(String destParentName) {
        this.destParentName = destParentName;
    }

    @JsonIgnore
    public String getDestParentId() {
        return destParentId;
    }

    public void setDestParentId(String destParentId) {
        this.destParentId = destParentId;
    }

    @JsonIgnore
    public String getLinkTypeName() {
        return linkTypeName;
    }

    public void setLinkTypeName(String linkTypeName) {
        this.linkTypeName = linkTypeName;
    }

    @JsonIgnore
    public String getLinkSubjectName() {
        return linkSubjectName;
    }

    public void setLinkSubjectName(String linkSubjectName) {
        this.linkSubjectName = linkSubjectName;
    }

    @JsonIgnore
    public String getLinkDestTypeName() {
        return linkDestTypeName;
    }

    public void setLinkDestTypeName(String linkDestTypeName) {
        this.linkDestTypeName = linkDestTypeName;
    }

    @JsonIgnore
    public String getDestIdStr() {
        return destIdStr;
    }

    public void setDestIdStr(String destIdStr) {
        this.destIdStr = destIdStr;
    }

    public Long getStartSeq() {
        return startSeq;
    }

    public void setStartSeq(Long startSeq) {
        this.startSeq = startSeq;
    }

   public Long getEndSeq() {
        return endSeq;
    }

    public void setEndSeq(Long endSeq) {
        this.endSeq = endSeq;
    }
}

