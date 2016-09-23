package com.lvmama.lvfit.common.dto.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.calculator.BookingDetailDto;
import com.lvmama.lvfit.common.dto.calculator.FlightSimpleInfoDto;
import com.lvmama.lvfit.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.price.FitFlightTicketPriceDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;

public class FitAppShoppingRequest implements Serializable{
	
	private static final long serialVersionUID = -5240419861163180539L;

	/**shoppingUUID */
	private String shoppingUuid;

	/**产品Id */
	private String productId;

	/**sdp 品类Id (仅限sdp产品) */
	private Long categoryId;

	/**行程Id */
	private Long lineRouteId;


	/** 机加酒产品名称  或者 sdp产品名称 */
	private String productName;

	/**选择份数*/
	private int quantity;

	/**订单预订来源*/
	private BookingSource bookingSource;

	/**成人数*/
	private int adultCount;

	/**儿童数*/
	private int childCount;

    /**选中的航班信息 key:TrafficTripeType (去程，返程) */
	private Map<String,FitAppTrafficInfoDto> selectTrafficInfo = new HashMap<String, FitAppTrafficInfoDto>();

	/**选中的商品信息 key:FitAppGoodsType (商品类别) */
	private Map<String,List<FitAppGoodsInfo>> selectGoodsInfo = new HashMap<String, List<FitAppGoodsInfo>>();

	/**分销商ID */
	private Long distributionChannel;

	/**分销商代码*/
	private String distributorCode;


	public String getShoppingUuid() {
		return shoppingUuid;
	}

	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getLineRouteId() {
		return lineRouteId;
	}

	public void setLineRouteId(Long lineRouteId) {
		this.lineRouteId = lineRouteId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public Map<String, FitAppTrafficInfoDto> getSelectTrafficInfo() {
		return selectTrafficInfo;
	}

	public void setSelectTrafficInfo(Map<String, FitAppTrafficInfoDto> selectTrafficInfo) {
		this.selectTrafficInfo = selectTrafficInfo;
	}

	/**
     * 构造算价请求Map
     * @param
     * @return
     */
    @JsonIgnore
	public Map<String, Object> getRequestMap(List<FlightSearchFlightInfoDto> selectSearchFlightInfoDtos,BookingSource bookingSource) {
    	
    	Map<String, Object> requestMap = new HashMap<String, Object>();
		AmountCalculatorRequest flightPriceRequest = this.getFlightPriceRequest(selectSearchFlightInfoDtos,bookingSource);
		if(flightPriceRequest!=null){
			requestMap.put(FitBusinessType.FIT_SDP_CALCULATE_FLI_PRICE.name(),flightPriceRequest);
		}
		return requestMap;
		
	}
    
    /**
	 * 	构造机票价格计算请求对象
	 * @param
	 * @return
	 */
	@JsonIgnore
	public AmountCalculatorRequest getFlightPriceRequest(List<FlightSearchFlightInfoDto> selectSearchFlightInfoDtos,BookingSource bookingSource) {

		List<BookingDetailDto> amountDetailDtos = new ArrayList<BookingDetailDto>();
		List<BookingDetailDto> passengerDetailDtos = new ArrayList<BookingDetailDto>();
		
		//按照乘客数和航段来构造最小单元请求对象
		for (int i = 0; i < adultCount*quantity; i++) {
			BookingDetailDto dto = new BookingDetailDto();
			dto.setPassengerType(PassengerType.ADULT);
			passengerDetailDtos.add(dto);
		}
		for (int i = 0; i < childCount*quantity; i++) {
			BookingDetailDto dto = new BookingDetailDto();
			dto.setPassengerType(PassengerType.CHILDREN);
			passengerDetailDtos.add(dto);
		}
		for (FlightSearchFlightInfoDto selectSearchFlightInfoDto : selectSearchFlightInfoDtos) {
			for (BookingDetailDto passengerDetailDto : passengerDetailDtos) {
				BookingDetailDto amountDetailDto = new BookingDetailDto();
				FlightSimpleInfoDto flightSimpleInfoDto = new FlightSimpleInfoDto();
				flightSimpleInfoDto.setDepartureDate(DateUtils.parseDate(selectSearchFlightInfoDto.getDepartureDate(), DateUtils.YYYY_MM_DD));
				flightSimpleInfoDto.setFlightNo(selectSearchFlightInfoDto.getFlightNo());
				FlightSearchSeatDto selectSearchSeatDto = selectSearchFlightInfoDto.getSeats().get(0);
				flightSimpleInfoDto.setPolicyId(selectSearchSeatDto.getPolicyId());
				//flightSimpleInfoDto.setPricePolicyId(selectSearchSeatDto.getPricePolicyId());
				flightSimpleInfoDto.setPricePolicyId(null);
				flightSimpleInfoDto.setSeatClassCode(selectSearchSeatDto.getSeatClassCode());
				flightSimpleInfoDto.setDepartureAirportCode(selectSearchFlightInfoDto.getDepartureAirportCode());
				flightSimpleInfoDto.setArrivalAirportCode(selectSearchFlightInfoDto.getArrivalAirportCode());
				FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();
				FitFlightTicketPriceDto fitFlightTicketPriceDto = new FitFlightTicketPriceDto(); 
				if(passengerDetailDto.getPassengerType()==PassengerType.CHILDREN){
					fitFlightTicketPriceDto=selectSearchFlightInfoDto.getChildrenSeats().get(selectSearchSeatDto.getSeatClassCode()).getFlightTicketPriceDto();
				}else{
					fitFlightTicketPriceDto = selectSearchSeatDto.getFlightTicketPriceDto();
				}
				try {
					BeanUtils.copyProperties(flightTicketPriceDto, fitFlightTicketPriceDto);
				} catch (Exception e) {
					//logger.error(ExceptionUtils.getFullStackTrace(e));
				}
				flightSimpleInfoDto.setFlightTicketPriceDto(flightTicketPriceDto);
				amountDetailDto.setFlightSimpleInfo(flightSimpleInfoDto);
				amountDetailDto.setPassengerType(passengerDetailDto.getPassengerType());
				amountDetailDtos.add(amountDetailDto);
			}
		}
		if(CollectionUtils.isNotEmpty(amountDetailDtos)){
			AmountCalculatorRequest flightPriceRequest = new AmountCalculatorRequest();
			flightPriceRequest.setBookingSource(BookingSource.valueOf(bookingSource.getParentSource().name()));
			flightPriceRequest.setPassengerDetailDtos(amountDetailDtos);
			return flightPriceRequest;
		}
		return null;
	}

	public Map<String, List<FitAppGoodsInfo>> getSelectGoodsInfo() {
		return selectGoodsInfo;
	}

	public void setSelectGoodsInfo(Map<String, List<FitAppGoodsInfo>> selectGoodsInfo) {
		this.selectGoodsInfo = selectGoodsInfo;
	}

	public Long getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(Long distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public String getDistributorCode() {
		return distributorCode;
	}

	public void setDistributorCode(String distributorCode) {
		this.distributorCode = distributorCode;
	}
}






