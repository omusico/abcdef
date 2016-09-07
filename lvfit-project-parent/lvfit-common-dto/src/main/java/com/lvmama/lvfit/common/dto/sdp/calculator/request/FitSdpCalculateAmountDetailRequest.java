package com.lvmama.lvfit.common.dto.sdp.calculator.request;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;

/**
 * 算计明细request
 */
public class FitSdpCalculateAmountDetailRequest implements Serializable{

	private static final long serialVersionUID = 5822519480051319887L;

	/**产品Id */
	private String productId;

	/**选中的航班算价请求对象 flightRequestMap */
	private Map<String, Object> flightRequestMap;

	/**总人数 */
	private int peopleCount;

	/**选择份数*/
	private int quantity;

	/************************此处以商品对象为维度存储方便日后扩展*********************************/
	/** 选中的酒店信息*/
	private List<FitSdpHotelRoomtypeDto> selectedFitSdpHotelRooms;

	/**选中的酒店套餐信息 */
	private FitSdpHotelComboGoodsDto selectedHotelComboGoods;

	/**选中的当地游信息 */
	private FitSdpLocalTripProductDto selectLocalTripPrduct;

	/**选中的当地游信息 */
	private FitSdpRoomDiff selectRoomDiff;

	/**选中的其他票信息 */
	private List<FitSdpSelectOtherTicketDto> selectOtherTickets;

	/**选中的保险信息 */
	private List<FitSdpSelectInsuranceDto> selectInsurances;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Map<String, Object> getFlightRequestMap() {
		return flightRequestMap;
	}

	public void setFlightRequestMap(Map<String, Object> flightRequestMap) {
		this.flightRequestMap = flightRequestMap;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public FitSdpHotelComboGoodsDto getSelectedHotelComboGoods() {
		return selectedHotelComboGoods;
	}

	public void setSelectedHotelComboGoods(FitSdpHotelComboGoodsDto selectedHotelComboGoods) {
		this.selectedHotelComboGoods = selectedHotelComboGoods;
	}

	public FitSdpLocalTripProductDto getSelectLocalTripPrduct() {
		return selectLocalTripPrduct;
	}

	public void setSelectLocalTripPrduct(FitSdpLocalTripProductDto selectLocalTripPrduct) {
		this.selectLocalTripPrduct = selectLocalTripPrduct;
	}

	public FitSdpRoomDiff getSelectRoomDiff() {
		return selectRoomDiff;
	}

	public void setSelectRoomDiff(FitSdpRoomDiff selectRoomDiff) {
		this.selectRoomDiff = selectRoomDiff;
	}

	public List<FitSdpSelectOtherTicketDto> getSelectOtherTickets() {
		return selectOtherTickets;
	}

	public void setSelectOtherTickets(List<FitSdpSelectOtherTicketDto> selectOtherTickets) {
		this.selectOtherTickets = selectOtherTickets;
	}

	public List<FitSdpSelectInsuranceDto> getSelectInsurances() {
		return selectInsurances;
	}

	public void setSelectInsurances(List<FitSdpSelectInsuranceDto> selectInsurances) {
		this.selectInsurances = selectInsurances;
	}

	public List<FitSdpHotelRoomtypeDto> getSelectedFitSdpHotelRooms() {
		return selectedFitSdpHotelRooms;
	}

	public void setSelectedFitSdpHotelRooms(List<FitSdpHotelRoomtypeDto> selectedFitSdpHotelRooms) {
		this.selectedFitSdpHotelRooms = selectedFitSdpHotelRooms;
	}
}
