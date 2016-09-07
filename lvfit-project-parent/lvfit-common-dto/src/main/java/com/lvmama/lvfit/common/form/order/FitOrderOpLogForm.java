package com.lvmama.lvfit.common.form.order;


import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;

public class FitOrderOpLogForm  implements Dto , Serializable{
	/**
	 * @author wanghuihui
	 * @date:2016年1月18日 下午7:45:54
	 */
	private static final long serialVersionUID = 518074583098694833L;
	private FitOrderOpLogDto fitOrderOpLogDto ;
	private String operType ;
	
	public final String getOperType() {
		return operType;
	}
	public final void setOperType(String operType) {
		this.operType = operType;
	}
	public final FitOrderOpLogDto getFitOrderOpLogDto() {
		return fitOrderOpLogDto;
	}
	public final void setFitOrderOpLogDto(FitOrderOpLogDto fitOrderOpLogDto) {
		this.fitOrderOpLogDto = fitOrderOpLogDto;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
