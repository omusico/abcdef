package com.lvmama.lvfit.sonline.booking.controller.form;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;

public class FitSdpShoppingResponseForm implements Serializable, Form{

	private static final long serialVersionUID = 2430385985260189273L;

	private FitSdpShoppingDto fitSdpShoppingDto;
	
	private String hotelComboStartDay;
	

	public String getHotelComboStartDay() {
		if(fitSdpShoppingDto!=null&&fitSdpShoppingDto.getSelectedHotelComboGoods()!=null&&fitSdpShoppingDto.getSelectedHotelComboGoods().getStartDay()!=null){
			 return DateUtils.formatDate(fitSdpShoppingDto.getSelectedHotelComboGoods().getStartDay());
		}
		return hotelComboStartDay;
	}

	public void setHotelComboStartDay(String hotelComboStartDay) {
		this.hotelComboStartDay = hotelComboStartDay;
	}


	public FitSdpShoppingResponseForm(FitSdpShoppingDto fitSdpShoppingDto) {
		super();
		this.fitSdpShoppingDto = fitSdpShoppingDto;
	}
	

	public FitSdpShoppingRequest getFitSdpShoppingRequest() {
		return fitSdpShoppingDto.getFitSdpShoppingRequest();
	}

	public void setFitSdpShoppingRequest(FitSdpShoppingRequest fitSdpShoppingRequest) {
		fitSdpShoppingDto.setFitSdpShoppingRequest(fitSdpShoppingRequest);
	}

	public List<FlightSearchFlightInfoDto> getSelectedFlightInfos() {
		return fitSdpShoppingDto.getSelectedFlightInfos();
	}

	public void setSelectedFlightInfos(List<FlightSearchFlightInfoDto> selectedFlightInfos) {
		fitSdpShoppingDto.setSelectedFlightInfos(selectedFlightInfos);
	}

	public FitSdpHotelComboGoodsDto getSelectedHotelComboGoods() {
		return fitSdpShoppingDto.getSelectedHotelComboGoods();
	}

	public void setSelectedHotelComboGoods(FitSdpHotelComboGoodsDto selectedHotelComboGoods) {
		fitSdpShoppingDto.setSelectedHotelComboGoods(selectedHotelComboGoods);
	}

	public FitSdpLocalTripProductDto getSelectLocalTripPrduct() {
		return fitSdpShoppingDto.getSelectLocalTripPrduct();
	}

	public void setSelectLocalTripPrduct(FitSdpLocalTripProductDto selectLocalTripPrduct) {
		fitSdpShoppingDto.setSelectLocalTripPrduct(selectLocalTripPrduct);
	}

	public List<FitSdpSelectOtherTicketDto> getSelectOtherTickets() {
		return fitSdpShoppingDto.getSelectOtherTickets();
	}

	public void setSelectOtherTickets(List<FitSdpSelectOtherTicketDto> selectOtherTickets) {
		fitSdpShoppingDto.setSelectOtherTickets(selectOtherTickets);
	}

	public List<FitSdpSelectInsuranceDto> getSelectInsurances() {
		return fitSdpShoppingDto.getSelectInsurances();
	}

	public void setSelectInsurances(List<FitSdpSelectInsuranceDto> selectInsurances) {
		fitSdpShoppingDto.setSelectInsurances(selectInsurances);
	}

	public FitSdpRoomDiff getSelectRoomDiffs() {
		return fitSdpShoppingDto.getSelectRoomDiffs();
	}

	public void setSelectRoomDiffs(FitSdpRoomDiff selectRoomDiffs) {
		fitSdpShoppingDto.setSelectRoomDiffs(selectRoomDiffs);
	}


	public FitSdpShoppingDto getFitSdpShoppingDto() {
		return fitSdpShoppingDto;
	}


	public void setFitSdpShoppingDto(FitSdpShoppingDto fitSdpShoppingDto) {
		this.fitSdpShoppingDto = fitSdpShoppingDto;
	}


	public String getProductName() {
		return this.fitSdpShoppingDto.getFitSdpShoppingRequest().getProductName();
	}
	
	public List<FitSdpHotelRoomtypeDto> getSelectedRoomtypes() {
		return this.fitSdpShoppingDto.getSelectedRoomtypes();
	}

	public void setSelectedRoomtypes(List<FitSdpHotelRoomtypeDto> selectedRoomtypes) {
		this.fitSdpShoppingDto.setSelectedRoomtypes(selectedRoomtypes);
	}
	
}
