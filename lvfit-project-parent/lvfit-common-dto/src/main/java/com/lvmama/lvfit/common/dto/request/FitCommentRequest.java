package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.form.Form;

public class FitCommentRequest implements Serializable,Form {

	private static final long serialVersionUID = -8212381557892320514L;
	
	/**
	 * 点评ID
	 */
	private Long commentId;
	
	/**
	 * 目的地ID
	 */
	private Long placeId;
	
	/**
	 * 产品ID
	 */
	private Long productId;
	
	/**
	 * 点评分页查询
	 */
	private Pagination pagination = new Pagination();

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	
	
}
