/**
 * Project Name:lvfit-common-dto
 * File Name:VstComment.java
 * Package Name:com.lvmama.lvfit.common.dto.vst
 * Date:2015-11-26下午8:27:27
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.form.Form;
/**
 * vst点评对象.
 * ClassName:VstComment <br/>
 * Date:     2015-11-26 下午8:27:27 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class VstComment implements Form,Serializable{
	/**
	 * serialVersionUID.
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = -4661619670047907640L;
	/**
	 * 点评ID
	 */
	private Long commentId;
	
	/**
	 * 产品ID
	 */
	private Long productId;
	
	/**
	 * 订单ID
	 */
	//private Long orderId;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 是否精华
	 */
	//private String isBest = "N";
	
	/**
	 * 是否审核
	 */
	//private String isAudit = Constant.CMT_AUDIT_STATUS.AUDIT_GOING.name();
	
	/**
	 * 点评内容
	 */
	private String content;
	
	/**
	 * 有用数
	 */
	//private Long usefulCount = 0L;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 回复数
	 */
	//private Long replyCount = 0L;
	
	/**
	 * 审核时间
	 */
	private Date auditTime;
	
	/**
	 * 是否隐藏显示
	 * Y 为前台隐藏
	 * N 为前台显示
	 */
	private String isHide = "N";
	
	/**
	 * 创建时间
	 */
	private Date createdTime;
	
	
	/**
	 * 点评是否含有敏感词
	 */
	private String isHasSensitivekey="N";
	
	/**
	 * 发点评用户端IP(用来限制批量发点评)
	 */
	//private String reqIp;
	
	/**
	 * 审核状态
	 */
	private long reviewStatus = 5;
	
	/**
	 * VST品类产品名称
	 */
	private String vstName;
	
	/**
	 * VST图片
	 */
	//private String vstPicture;
	
	/**
	 * VST URL
	 */
	//private String vstUrl;
	
	/**
	 * VST 商品名称    
	 * eg: VSTName=如家酒店   vstSpName=大床房
	 */
	private String vstSpName;
	
	/**
	 * 判断是否有图片
	 */
	//private String isPicture;
//	/**
//	 * 上传图片数
//	 */
//	private Long pictureCount;
	
	/**
	 * 总体点评(可能暂时用不上，暂保留)
	 */
	//private VstCmtLatitude sumaryLatitude;
	
	private String AvgScore;
	/**
	 * 点评维度
	 */
	private List<VstCmtLatitude> cmtLatitudes;
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/*public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}*/
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/*public Long getUsefulCount() {
		return usefulCount;
	}
	public void setUsefulCount(Long usefulCount) {
		this.usefulCount = usefulCount;
	}*/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/*public Long getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Long replyCount) {
		this.replyCount = replyCount;
	}*/
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public String getIsHide() {
		return isHide;
	}
	public void setIsHide(String isHide) {
		this.isHide = isHide;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getIsHasSensitivekey() {
		return isHasSensitivekey;
	}
	public void setIsHasSensitivekey(String isHasSensitivekey) {
		this.isHasSensitivekey = isHasSensitivekey;
	}
	/*public String getReqIp() {
		return reqIp;
	}
	public void setReqIp(String reqIp) {
		this.reqIp = reqIp;
	}*/
	public long getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(long reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getVstName() {
		return vstName;
	}
	public void setVstName(String vstName) {
		this.vstName = vstName;
	}
	/*public String getVstPicture() {
		return vstPicture;
	}
	public void setVstPicture(String vstPicture) {
		this.vstPicture = vstPicture;
	}*/
	/*public String getVstUrl() {
		return vstUrl;
	}
	public void setVstUrl(String vstUrl) {
		this.vstUrl = vstUrl;
	}*/
	public String getVstSpName() {
		return vstSpName;
	}
	public void setVstSpName(String vstSpName) {
		this.vstSpName = vstSpName;
	}
	/*public String getIsPicture() {
		return isPicture;
	}
	public void setIsPicture(String isPicture) {
		this.isPicture = isPicture;
	}*/
//	public Long getPictureCount() {
//		return pictureCount;
//	}
//	public void setPictureCount(Long pictureCount) {
//		this.pictureCount = pictureCount;
//	}
	/*public VstCmtLatitude getSumaryLatitude() {
		return sumaryLatitude;
	}
	public void setSumaryLatitude(VstCmtLatitude sumaryLatitude) {
		this.sumaryLatitude = sumaryLatitude;
	}*/
	public List<VstCmtLatitude> getCmtLatitudes() {
		return cmtLatitudes;
	}
	public void setCmtLatitudes(List<VstCmtLatitude> cmtLatitudes) {
		this.cmtLatitudes = cmtLatitudes;
	}
	
	
	public String getAvgScore() {
		return AvgScore;
	}
	public void setAvgScore(String avgScore) {
		AvgScore = avgScore;
	}
	@Override
	public String toString() {
		return "VstComment [commentId=" + commentId + ", productId=" + productId + ", userId=" + userId + ", content=" + content 
				+ ", userName=" + userName  + auditTime + ", isHide=" + isHide + ", createdTime=" + createdTime + ", isHasSensitivekey="
				+ isHasSensitivekey + ", reviewStatus=" + reviewStatus + ", vstName=" + vstName  + ", vstSpName=" + vstSpName
				+ ", cmtLatitudes=" + cmtLatitudes + "]";
	}

	
}

