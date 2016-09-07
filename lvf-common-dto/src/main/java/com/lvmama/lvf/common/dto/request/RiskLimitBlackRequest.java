/*
 * Copyright by Lvmama and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Lvmama from
 *
 *      http://www.lvmama.com
 *
 */ 
package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.risk.RiskLimitBlackDto;

/**
 * 针对南航新规的风控规则优化  查询request
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:杨小龙yangxiaolong,
 *		date:2016-7-28 下午4:37:39,content: </p>
 * @author 杨小龙yangxiaolong
 * @date 2016-7-28 下午4:37:39
 * @since
 * @version
 */
public class RiskLimitBlackRequest implements Serializable,Dto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5175129372459541573L;

	private RiskLimitBlackDto dto;
	
	private String createTimeBegin;
	
	private String createTimeEnd;

	/**
	 * @return  the dto
	 */
	public RiskLimitBlackDto getDto() {
		return dto;
	}

	/**
	 * @param dto the dto to set
	 */
	public void setDto(RiskLimitBlackDto dto) {
		this.dto = dto;
	}

	/**
	 * @return  the createTimeBegin
	 */
	public String getCreateTimeBegin() {
		return createTimeBegin;
	}

	/**
	 * @param createTimeBegin the createTimeBegin to set
	 */
	public void setCreateTimeBegin(String createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	/**
	 * @return  the createTimeEnd
	 */
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	/**
	 * @param createTimeEnd the createTimeEnd to set
	 */
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	@Override
	public Long getId() {
		return null;
	}
	
	
}
