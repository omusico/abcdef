package com.lvmama.lvfit.common.dto.search.insurance;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;

/**
 * 保险搜索相关 对象Form
 * @author wanghuihui
 * @date:2016年2月22日 下午6:08:28
 */
public class InsuranceSearchForm implements Serializable{

	
	private static final long serialVersionUID = -4543243174857295385L;
	
	private InsuranceDto insuranceSearchDto = new InsuranceDto();

	public InsuranceSearchForm(){
		
	}

}
