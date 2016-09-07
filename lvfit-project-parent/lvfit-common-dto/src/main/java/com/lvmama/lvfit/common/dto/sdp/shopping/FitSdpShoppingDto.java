package com.lvmama.lvfit.common.dto.sdp.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelGroupDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;

/**
 * 自主打包购物车DTO
 * @author leizhengwei
 *
 */
public class FitSdpShoppingDto implements Serializable{
	
	private static final long serialVersionUID = -1054363919216541050L;

	/**购物车基本请求信息 */
	private FitSdpShoppingRequest fitSdpShoppingRequest;
	
    /** 去程机票信息 */
    private List<FlightSearchFlightInfoDto> depFlightInfos = new ArrayList<FlightSearchFlightInfoDto>();
    /** 返程机票信息 */
    private List<FlightSearchFlightInfoDto> arvFlightInfos = new ArrayList<FlightSearchFlightInfoDto>();
	
	/**当前选中的航班信息（注意存放时候的顺序，若为往返，集合第一个元素代表去程，第二个元素代表回程） */
	private List<FlightSearchFlightInfoDto> selectedFlightInfos  = new ArrayList<FlightSearchFlightInfoDto>();
	
	/*包机切位的航班信息*/
	private List<FlightSearchFlightInfoDto> charterFlightInfos = new ArrayList<FlightSearchFlightInfoDto>();
	
	/** 搜索得到的酒店套餐信息 */
	private List<FitSdpHotelComboGoodsDto> hotelCombos = new ArrayList<FitSdpHotelComboGoodsDto>();
	
	/**被选中的酒店套餐信息 */	
	private  FitSdpHotelComboGoodsDto selectedHotelComboGoods;
	
	/** 搜索得到的酒店n组信息 */
	private List<FitSdpHotelGroupDto> hotelGroups = new ArrayList<FitSdpHotelGroupDto>();
	
	/** 全部的酒店房型信息. */
	private  List<FitSdpHotelRoomtypeDto> allRoomtypes = new ArrayList<FitSdpHotelRoomtypeDto>();
	
	/**被选中的酒店信息---n个酒店分组信息，就有n个分组里面的多个房型被选中 */	
	private  List<FitSdpHotelRoomtypeDto> selectedRoomtypes;
	
	/**...........................其他品类的商品信息.......................................(待补全)  */
	/**被选中的当地游信息 */
	private FitSdpLocalTripProductDto selectLocalTripPrduct;
	
	/**被选中的其他票信息*/
	private List<FitSdpSelectOtherTicketDto> selectOtherTickets  = new ArrayList<FitSdpSelectOtherTicketDto>();
	
	/**被选中的保险信息*/
	private List<FitSdpSelectInsuranceDto> selectInsurances = new ArrayList<FitSdpSelectInsuranceDto>();

	/**选中的房差信息*/
	private FitSdpRoomDiff selectRoomDiffs = new FitSdpRoomDiff();
	
	// 检索得到的其他票信息
	private List<FitSdpOtherTicketDto> otherTickets = new ArrayList<FitSdpOtherTicketDto>();
	// 检索得到的保险信息
	private List<FitSdpInsuranceDto> insurances = new ArrayList<FitSdpInsuranceDto>();

	public FitSdpShoppingRequest getFitSdpShoppingRequest() {
		return fitSdpShoppingRequest;
	} 

	public List<FlightSearchFlightInfoDto> getCharterFlightInfos() {
		return charterFlightInfos;
	} 

	public void setCharterFlightInfos(
			List<FlightSearchFlightInfoDto> charterFlightInfos) {
		this.charterFlightInfos = charterFlightInfos;
	}



	public void setFitSdpShoppingRequest(FitSdpShoppingRequest fitSdpShoppingRequest) {
		this.fitSdpShoppingRequest = fitSdpShoppingRequest;
	}

	public List<FlightSearchFlightInfoDto> getSelectedFlightInfos() {
		return selectedFlightInfos;
	}

	public void setSelectedFlightInfos(
			List<FlightSearchFlightInfoDto> selectedFlightInfos) {
		this.selectedFlightInfos = selectedFlightInfos;
	}

	public List<FitSdpHotelGroupDto> getHotelGroups() {
		return hotelGroups;
	}

	public void setHotelGroups(List<FitSdpHotelGroupDto> hotelGroups) {
		this.hotelGroups = hotelGroups;
	}

	public List<FitSdpHotelRoomtypeDto> getSelectedRoomtypes() {
		return selectedRoomtypes;
	}

	public void setSelectedRoomtypes(List<FitSdpHotelRoomtypeDto> selectedRoomtypes) {
		this.selectedRoomtypes = selectedRoomtypes;
	}

	public FitSdpHotelComboGoodsDto getSelectedHotelComboGoods() {
		return selectedHotelComboGoods;
	}

	public void setSelectedHotelComboGoods(
			FitSdpHotelComboGoodsDto selectedHotelComboGoods) {
		this.selectedHotelComboGoods = selectedHotelComboGoods;
	}

	public FitSdpLocalTripProductDto getSelectLocalTripPrduct() {
		return selectLocalTripPrduct;
	}

	public void setSelectLocalTripPrduct(
			FitSdpLocalTripProductDto selectLocalTripPrduct) {
		this.selectLocalTripPrduct = selectLocalTripPrduct;
	}

	public List<FitSdpHotelRoomtypeDto> getAllRoomtypes() {
		return allRoomtypes;
	}

	public void setAllRoomtypes(List<FitSdpHotelRoomtypeDto> allRoomtypes) {
		this.allRoomtypes = allRoomtypes;
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

	public FitSdpRoomDiff getSelectRoomDiffs() {
		return selectRoomDiffs;
	}

	public void setSelectRoomDiffs(FitSdpRoomDiff selectRoomDiffs) {
		this.selectRoomDiffs = selectRoomDiffs;
	}

    public List<FitSdpHotelComboGoodsDto> getHotelCombos() {
        return hotelCombos;
    }

    public void setHotelCombos(List<FitSdpHotelComboGoodsDto> hotelCombos) {
        this.hotelCombos = hotelCombos;
    }

    public List<FlightSearchFlightInfoDto> getDepFlightInfos() {
        return depFlightInfos;
    }

    public void setDepFlightInfos(List<FlightSearchFlightInfoDto> depFlightInfos) {
        this.depFlightInfos = depFlightInfos;
    }

    public List<FlightSearchFlightInfoDto> getArvFlightInfos() {
        return arvFlightInfos;
    }

    public void setArvFlightInfos(List<FlightSearchFlightInfoDto> arvFlightInfos) {
        this.arvFlightInfos = arvFlightInfos;
    }

    public List<FitSdpOtherTicketDto> getOtherTickets() {
        return otherTickets;
    }

    public void setOtherTickets(List<FitSdpOtherTicketDto> otherTickets) {
        this.otherTickets = otherTickets;
    }

    public List<FitSdpInsuranceDto> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<FitSdpInsuranceDto> insurances) {
        this.insurances = insurances;
    }
}
