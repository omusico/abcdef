package com.lvmama.lvfit.common.form.booking;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderExpressDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;

import java.util.List;

/**
 *  跳转到订单填写页 输出类
 * @author qihuisong
 * @date:2015年12月16日 下午2:01:31
 */
public class ToBookingResultForm implements Form {
	
	private List<FitOrderPassengerDto> passengers;
	private List<FitOrderContacterDto> contacters;
	private List<FitOrderExpressDto> addresses;
	private List<InsuranceInfoDto> insurances;

	public List<FitOrderPassengerDto> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<FitOrderPassengerDto> passengers) {
		this.passengers = passengers;
	}

	public List<FitOrderContacterDto> getContacters() {
		return contacters;
	}

	public void setContacters(List<FitOrderContacterDto> contacters) {
		this.contacters = contacters;
	}

	public List<FitOrderExpressDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<FitOrderExpressDto> addresses) {
		this.addresses = addresses;
	}

	public List<InsuranceInfoDto> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<InsuranceInfoDto> insurances) {
		this.insurances = insurances;
	}
}
