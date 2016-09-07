package com.lvmama.lvfit.common.dto.app;

import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderExpressDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * APP下单请求对象
 */
public class FitAppBookingRequest implements Serializable{

	private static final long serialVersionUID = 2123558672857211197L;

	private FitAppShoppingRequest appShoppingRequest;

	/**出游时间 */
    private String visitTime;

	/**提交时购物车总价 */
	private BigDecimal totalPrice;

	/** 下单人信息 */
	private FitOrderCustomerDto fitOrderCustomerDto;

	/** 联系人 | 购买人 */
	private FitOrderContacterDto fitOrderContacterDto;

	/** 游玩人员 */
	private List<FitOrderPassengerDto> fitOrderPassengerDtos = new ArrayList<FitOrderPassengerDto>();

	/** 配送方式 */
	private FitOrderExpressDto fitOrderExpressDto;

	public FitAppShoppingRequest getAppShoppingRequest() {
		return appShoppingRequest;
	}

	public void setAppShoppingRequest(FitAppShoppingRequest appShoppingRequest) {
		this.appShoppingRequest = appShoppingRequest;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public FitOrderCustomerDto getFitOrderCustomerDto() {
		return fitOrderCustomerDto;
	}

	public void setFitOrderCustomerDto(FitOrderCustomerDto fitOrderCustomerDto) {
		this.fitOrderCustomerDto = fitOrderCustomerDto;
	}

	public FitOrderContacterDto getFitOrderContacterDto() {
		return fitOrderContacterDto;
	}

	public void setFitOrderContacterDto(FitOrderContacterDto fitOrderContacterDto) {
		this.fitOrderContacterDto = fitOrderContacterDto;
	}

	public List<FitOrderPassengerDto> getFitOrderPassengerDtos() {
		return fitOrderPassengerDtos;
	}

	public void setFitOrderPassengerDtos(List<FitOrderPassengerDto> fitOrderPassengerDtos) {
		this.fitOrderPassengerDtos = fitOrderPassengerDtos;
	}

	public FitOrderExpressDto getFitOrderExpressDto() {
		return fitOrderExpressDto;
	}

	public void setFitOrderExpressDto(FitOrderExpressDto fitOrderExpressDto) {
		this.fitOrderExpressDto = fitOrderExpressDto;
	}
}






