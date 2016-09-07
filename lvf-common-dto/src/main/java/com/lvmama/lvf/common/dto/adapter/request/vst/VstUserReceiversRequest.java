package com.lvmama.lvf.common.dto.adapter.request.vst;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;

/**
 * @author lutianyu
 * @date   2015-2-26
 */
public class VstUserReceiversRequest implements Serializable{
	private static final long serialVersionUID = 6127003252723497855L;

	/** 驴妈妈会员id*/
	private String userId;
	
	/** 快递地址*/
	private List<FlightOrderExpressDto> addressList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<FlightOrderExpressDto> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<FlightOrderExpressDto> addressList) {
		this.addressList = addressList;
	}
}
