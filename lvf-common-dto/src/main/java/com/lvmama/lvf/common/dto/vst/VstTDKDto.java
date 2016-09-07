/**
 * Project Name:lvfit-common-dto
 * File Name:VstPicComment.java
 * Package Name:com.lvmama.lvfit.common.dto.vst
 * Date:2015-11-27下午3:39:58
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvf.common.dto.vst;


/**
 *
 * Date:     2016-01-15 <br/>
 * @author   yueyufan
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class VstTDKDto implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4321933826213667799L;
	private String id;
	private String ruleTitle;
	private String type;
	private String key;
	private String title;
	private String keywords;
	private String description;
	private String crtDate;
	private String updDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRuleTitle() {
		return ruleTitle;
	}
	public void setRuleTitle(String ruleTitle) {
		this.ruleTitle = ruleTitle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCrtDate() {
		return crtDate;
	}
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
	public String getUpdDate() {
		return updDate;
	}
	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}
}

