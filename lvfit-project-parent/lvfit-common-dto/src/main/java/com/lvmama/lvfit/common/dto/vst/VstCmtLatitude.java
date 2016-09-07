/**
 * Project Name:lvfit-common-dto
 * File Name:VstCmtLatitude.java
 * Package Name:com.lvmama.lvfit.common.dto.vst
 * Date:2015-11-26下午8:53:18
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;

/**
 * 点评纬度.
 * ClassName:VstCmtLatitude <br/>
 * Date:     2015-11-26 下午8:53:18 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class VstCmtLatitude implements Serializable {

	/**
	 * serialVersionUID.
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 5042296161140266405L;
	/**
	 * 标识
	 */
	private Long cmtLatitudeId;
	/**
	 * 维度ID
	 */
	private String latitudeId;
	/**
	 * 评分(非常好，较好，好，一般，差)
	 */
	private Integer score;
	/**
	 * 点评ID
	 */
	private Long commentId;
	/**
	 * 维度名称
	 */
	private String latitudeName;
 	
	public String getChScore() {
		if (null == this.getScore()) {
			return "";
		} else {
			switch (this.getScore().intValue()) {
			case 5:
				return "推荐";
			case 4:
				return "满意";
			case 3:
				return "一般";
			case 2:
				return "不满";
			case 1:
				return "失望";
			default:
				return "";
			}
		}
	}	

	public Long getCmtLatitudeId() {
		return cmtLatitudeId;
	}

	public void setCmtLatitudeId(Long cmtLatitudeId) {
		this.cmtLatitudeId = cmtLatitudeId;
	}

	public String getLatitudeId() {
		return latitudeId;
	}

	public void setLatitudeId(String latitudeId) {
		this.latitudeId = latitudeId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getLatitudeName() {
		return latitudeName;
	}

	public void setLatitudeName(String latitudeName) {
		this.latitudeName = latitudeName;
	}
	
	 public int compare(VstCmtLatitude arg0, VstCmtLatitude arg1) {  
	        if(arg0.getLatitudeId().compareTo(arg1.getLatitudeId()) > 0){  
	            return 1;  
	        }else{  
	            return 0;  
	        }  
	    }  


}

