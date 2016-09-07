package com.lvmama.lvf.common.dto.adapter.request.insurance;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
/**
 * 火车票保险信息rquest
 */
@XmlRootElement
public class TrainInsuranceRequest implements Serializable{
	/**
	 * 保单信息
	 */
	private InsuranceOrderDto insuranceOrderDto = new InsuranceOrderDto();
	/**保单号*/
	private String insuranceNo;

	public InsuranceOrderDto getInsuranceOrderDto() {
		return insuranceOrderDto;
	}

	public void setInsuranceOrderDto(InsuranceOrderDto insuranceOrderDto) {
		this.insuranceOrderDto = insuranceOrderDto;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
}
