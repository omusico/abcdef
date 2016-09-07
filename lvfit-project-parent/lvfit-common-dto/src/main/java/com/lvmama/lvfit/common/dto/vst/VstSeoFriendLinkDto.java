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
public class VstSeoFriendLinkDto implements java.io.Serializable{

	private static final long serialVersionUID = 4141917961831108075L;
	
	private Long friendLinkId;//友情链接id(主键)
	private Long destId;//对应目的地id
	private Long fromPlaceId;//出发地id
	private String friendLinkName;//关键词
	private Long friendLinkTypeId;//关键词类别
	private String friendLinkUrl;//链接地址
	private Long friendLinkKeyId;//也面对的key
	private String noFollow;//是否允许爬取，1代表是，0代表否
	private String isDeadLink;//是否为死链，1代表是，0代表否
	private String isLongValid;//是否过期，1代表是，0代表否
	private String destName;
	private String destParentName;
	private String destParentId;
	
	private String friendLinkTypeName;
	private String friendLinkKeyName;
	private String destIdStr;
	private String fromPlaceIdStr;
	private String linkMan;
	private String contactMethod;
	
	
	public Long getFriendLinkId() {
		return friendLinkId;
	}
	public void setFriendLinkId(Long friendLinkId) {
		this.friendLinkId = friendLinkId;
	}
	
	
	public Long getDestId() {
		return destId;
	}
	public void setDestId(Long destId) {
		this.destId = destId;
	}
	
	public Long getFromPlaceId() {
		return fromPlaceId;
	}
	public void setFromPlaceId(Long fromPlaceId) {
		this.fromPlaceId = fromPlaceId;
	}
	
	public String getFriendLinkName() {
		return friendLinkName;
	}
	public void setFriendLinkName(String friendLinkName) {
		this.friendLinkName = setStringCutTrim(friendLinkName);
	}
	
	public String getFriendLinkUrl() {
		return friendLinkUrl;
	}
	public void setFriendLinkUrl(String friendLinkUrl) {
		this.friendLinkUrl = setStringCutTrim(friendLinkUrl);
	}
	
	public Long getFriendLinkKeyId() {
		return friendLinkKeyId;
	}
	public void setFriendLinkKeyId(Long friendLinkKeyId) {
		this.friendLinkKeyId = friendLinkKeyId;
	}
	
	public String getNoFollow() {
		return noFollow;
	}
	public void setNoFollow(String noFollow) {
		this.noFollow = setStringCutTrim(noFollow);
	}
	
	public String getIsDeadLink() {
		return isDeadLink;
	}
	public void setIsDeadLink(String isDeadLink) {
		this.isDeadLink = setStringCutTrim(isDeadLink);
	}
	
	
	public String getIsLongValid() {
		return isLongValid;
	}
	public void setIsLongValid(String isLongValid) {
		this.isLongValid = setStringCutTrim(isLongValid);
	}
	
	@JsonIgnore
	public String getDestParentName() {
		return destParentName;
	}
	public void setDestParentName(String destParentName) {
		this.destParentName = setStringCutTrim(destParentName);
	}
	
	@JsonIgnore
	public String getDestParentId() {
		return destParentId;
	}
	public void setDestParentId(String destParentId) {
		this.destParentId = setStringCutTrim(destParentId);
	}
	
	public Long getFriendLinkTypeId() {
		return friendLinkTypeId;
	}
	public void setFriendLinkTypeId(Long friendLinkTypeId) {
		this.friendLinkTypeId = friendLinkTypeId;
	}
	
	@JsonIgnore
	public String getDestName() {
		return destName;
	}
	public void setDestName(String destName) {
		this.destName = setStringCutTrim(destName);
	}
	
	public String getFriendLinkTypeName() {
		return friendLinkTypeName;
	}
	public void setFriendLinkTypeName(String friendLinkTypeName) {
		this.friendLinkTypeName = setStringCutTrim(friendLinkTypeName);
	}
	
	public String getFriendLinkKeyName() {
		return friendLinkKeyName;
	}
	public void setFriendLinkKeyName(String friendLinkKeyName) {
		this.friendLinkKeyName = setStringCutTrim(friendLinkKeyName);
	}
	
	@JsonIgnore
	public String getDestIdStr() {
		return destIdStr;
	}
	//用到ajax查询 destId为String 转换为Long 异常 所以无法保存。故采取中间值转换
	public void setDestIdStr(String destIdStr) {
		this.destId = Long.valueOf(setStringCutTrim(destIdStr));
		this.destIdStr = setStringCutTrim(destIdStr);
	}
	
	@JsonIgnore
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = setStringCutTrim(linkMan);
	}
	
	@JsonIgnore
	public String getContactMethod() {
		return contactMethod;
	}
	public void setContactMethod(String contactMethod) {
		this.contactMethod = setStringCutTrim(contactMethod);
	}
	
	@JsonIgnore
	public String getFromPlaceIdStr() {
		return fromPlaceIdStr;
	}
	public void setFromPlaceIdStr(String fromPlaceIdStr) {
		this.fromPlaceId=Long.valueOf(setStringCutTrim(fromPlaceIdStr));
		this.fromPlaceIdStr = setStringCutTrim(fromPlaceIdStr);
	}
	
	@JsonIgnore
	public String setStringCutTrim(String str){
		   return null!=str?str.trim():null;
		}
	
}

