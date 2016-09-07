/**
 * Project Name:lvfit-common-dto
 * File Name:FitCommentDto.java
 * Package Name:com.lvmama.lvfit.common.dto.hotel
 * Date:2015-12-3下午5:31:59
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.hotel;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvfit.common.dto.vst.VstComment;


/**
 * ClassName:FitCommentDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-3 下午5:31:59 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class FitCommentDto implements Dto{
	private BaseResultDto<VstComment> comments = new BaseResultDto<VstComment>();
	private FitCommentStat commentStat = new FitCommentStat(); 
	/**
	 * commentStat.
	 *
	 * @return  the commentStat
	 * @since   JDK 1.6
	 */
	public FitCommentStat getCommentStat() {
		return commentStat;
	}
	/**
	 * commentStat.
	 *
	 * @param   commentStat    the commentStat to set
	 * @since   JDK 1.6
	 */
	public void setCommentStat(FitCommentStat commentStat) {
		this.commentStat = commentStat;
	}
	/**
	 * @param isSuccess
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#setIsSuccess(boolean)
	 */
	public void setIsSuccess(boolean isSuccess) {
		comments.setIsSuccess(isSuccess);
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#getIsSuccess()
	 */
	public boolean getIsSuccess() {
		return comments.getIsSuccess();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#getIsFail()
	 */
	public boolean getIsFail() {
		return comments.getIsFail();
	}
	/**
	 * @param isFail
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#setIsFail(boolean)
	 */
	public void setIsFail(boolean isFail) {
		comments.setIsFail(isFail);
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getQueryKey()
	 */
	public String getQueryKey() {
		return comments.getQueryKey();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#getErrCode()
	 */
	public String getErrCode() {
		return comments.getErrCode();
	}
	/**
	 * @param queryKey
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#setQueryKey(java.lang.String)
	 */
	public void setQueryKey(String queryKey) {
		comments.setQueryKey(queryKey);
	}
	/**
	 * @param errCode
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#setErrCode(java.lang.String)
	 */
	public void setErrCode(String errCode) {
		comments.setErrCode(errCode);
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getResults()
	 */
	public List<VstComment> getResults() {
		return comments.getResults();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#getMessage()
	 */
	public String getMessage() {
		return comments.getMessage();
	}
	/**
	 * @param results
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#setResults(java.util.List)
	 */
	public void setResults(List<VstComment> results) {
		comments.setResults(results);
	}
	/**
	 * @param message
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#setMessage(java.lang.String)
	 */
	public void setMessage(String message) {
		comments.setMessage(message);
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getPagination()
	 */
	public Pagination getPagination() {
		return comments.getPagination();
	}
	/**
	 * @param message
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#setErrorMessage(java.lang.String)
	 */
	public void setErrorMessage(String message) {
		comments.setErrorMessage(message);
	}
	/**
	 * @param pagination
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#setPagination(com.lvmama.lvf.common.dto.Pagination)
	 */
	public void setPagination(Pagination pagination) {
		comments.setPagination(pagination);
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#getStatus()
	 */
	public ResultStatus getStatus() {
		return comments.getStatus();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getPage()
	 */
	public int getPage() {
		return comments.getPage();
	}
	/**
	 * @param status
	 * @see com.lvmama.lvf.common.dto.BaseReponseHandle#setStatus(com.lvmama.lvf.common.dto.status.ResultStatus)
	 */
	public void setStatus(ResultStatus status) {
		comments.setStatus(status);
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getRows()
	 */
	public int getRows() {
		return comments.getRows();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getRecords()
	 */
	public int getRecords() {
		return comments.getRecords();
	}
	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return comments.hashCode();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getTotal()
	 */
	public int getTotal() {
		return comments.getTotal();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getSidx()
	 */
	public String getSidx() {
		return comments.getSidx();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#getSord()
	 */
	public String getSord() {
		return comments.getSord();
	}
	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.BaseResultDto#isHasResults()
	 */
	public Boolean isHasResults() {
		return comments.isHasResults();
	}
	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		return comments.equals(obj);
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getIntegerOfAvgScore()
	 */
	public int getIntegerOfAvgScore() {
		return commentStat.getIntegerOfAvgScore();
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getFormatAvgScore()
	 */
	public String getFormatAvgScore() {
		return commentStat.getFormatAvgScore();
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getRoundHalfUpOfAvgScore()
	 */
	public String getRoundHalfUpOfAvgScore() {
		return commentStat.getRoundHalfUpOfAvgScore();
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getAvgScorePercent()
	 */
	public Float getAvgScorePercent() {
		return commentStat.getAvgScorePercent();
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getAvgScoreStr()
	 */
	public String getAvgScoreStr() {
		return commentStat.getAvgScoreStr();
	}
	/**
	 * @param placeId
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#setPlaceId(java.lang.Long)
	 */
	public void setPlaceId(Long placeId) {
		commentStat.setPlaceId(placeId);
	}
	/**
	 * @param commentCount
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#setCommentCount(java.lang.Long)
	 */
	public void setCommentCount(Long commentCount) {
		commentStat.setCommentCount(commentCount);
	}
	/**
	 * @param avgScore
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#setAvgScore(java.lang.Float)
	 */
	public void setAvgScore(Float avgScore) {
		commentStat.setAvgScore(avgScore);
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getPlaceId()
	 */
	public Long getPlaceId() {
		return commentStat.getPlaceId();
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getCommentCount()
	 */
	public Long getCommentCount() {
		return commentStat.getCommentCount();
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getAvgScore()
	 */
	public Float getAvgScore() {
		return commentStat.getAvgScore();
	}
	/**
	 * @param productId
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#setProductId(java.lang.Long)
	 */
	public void setProductId(Long productId) {
		commentStat.setProductId(productId);
	}
	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#getProductId()
	 */
	public Long getProductId() {
		return commentStat.getProductId();
	}
	/**
	 * @param formatAvgScore
	 * @see com.lvmama.lvfit.common.dto.vst.VstCommentStat#setFormatAvgScore(java.lang.String)
	 */
	public void setFormatAvgScore(String formatAvgScore) {
		commentStat.setFormatAvgScore(formatAvgScore);
	}
	public BaseResultDto<VstComment> getComments() {
		return comments;
	}
	public void setComments(BaseResultDto<VstComment> comments) {
		this.comments = comments;
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

