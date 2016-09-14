package com.lvmama.lvfit.common.dto.sdp.calculator.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.calculator.BookingDetailDto;
import com.lvmama.lvfit.common.dto.calculator.FlightSimpleInfoDto;
import com.lvmama.lvfit.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvfit.common.dto.calculator.InsuranceCalculatRequest;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.price.FitFlightTicketPriceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.CharterFlightFilterUtil;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;


public class FitSdpCalculateAmountRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(FitSdpCalculateAmountRequest.class);
	
	private String shoppingUUID;
	
	private BookingSource bookingSource;

	public final String getShoppingUUID() {
		return shoppingUUID;
	}

	public final void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}

	public final BookingSource getBookingSource() {
		return bookingSource;
	}

	public final void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}
	
	/**
     * 构造算价请求Map
     * @param selectShoppingDto
     * @return
     */
    @JsonIgnore
	public Map<String, Object> getRequestMap(FitSdpShoppingDto selectShoppingDto,BookingSource bookingSource) {
    	
    	Map<String, Object> requestMap = new HashMap<String, Object>();
    	
    	List<FlightSearchFlightInfoDto> selectSearchFlightInfoDtos = selectShoppingDto.getSelectedFlightInfos();
    	FitSdpShoppingRequest fitSdpShoppingRequest = selectShoppingDto.getFitSdpShoppingRequest();
		fitSdpShoppingRequest.setBookingSource(bookingSource);
		AmountCalculatorRequest flightPriceRequest = this.getFlightPriceRequest(selectSearchFlightInfoDtos,fitSdpShoppingRequest);
		if(flightPriceRequest!=null){ 
			//如果当前是包机航班，就修改里面的乘客的航意险的数量为原有的两倍.
			if(CharterFlightFilterUtil.isCharsetFlightDots(selectSearchFlightInfoDtos)){
				 List<BookingDetailDto>  bookingDetails = flightPriceRequest.getPassengerDetailDtos();
				 for(BookingDetailDto bkdetail:bookingDetails){
					 List<InsuranceCalculatRequest> insRequests =  bkdetail.getInsuranceCalculatRequests();
					 for(InsuranceCalculatRequest req:insRequests){
						 req.setInsuranceCount(2*req.getInsuranceCount());
					 }
				 } 
			}		
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
	public AmountCalculatorRequest getFlightPriceRequest(List<FlightSearchFlightInfoDto> selectSearchFlightInfoDtos,FitSdpShoppingRequest fitSdpShoppingRequest) {

		List<BookingDetailDto> amountDetailDtos = new ArrayList<BookingDetailDto>();
		Integer adultCount = fitSdpShoppingRequest.getFitPassengerRequest().getAdultCount();
		Integer childCount = fitSdpShoppingRequest.getFitPassengerRequest().getChildCount();
		Integer quantity = null!=fitSdpShoppingRequest.getQuantity()?fitSdpShoppingRequest.getQuantity().intValue():1;
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
				//传入销售类型，如果是包机切位，后面计算要使用该字段计算.
				flightSimpleInfoDto.setSaleType(selectSearchFlightInfoDto.getSaleType());
				flightSimpleInfoDto.setSeatClassCode(selectSearchSeatDto.getSeatClassCode());
				flightSimpleInfoDto.setDepartureAirportCode(selectSearchFlightInfoDto.getDepartureAirportCode());
				flightSimpleInfoDto.setArrivalAirportCode(selectSearchFlightInfoDto.getArrivalAirportCode());
				FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();
				FitFlightTicketPriceDto fitFlightTicketPriceDto = new FitFlightTicketPriceDto(); 
				//如果不是包机切位，就考虑儿童舱的问题
				if(!CharterFlightFilterUtil.isCharset(selectSearchFlightInfoDto)){
					if(passengerDetailDto.getPassengerType()==PassengerType.CHILDREN){
						fitFlightTicketPriceDto=selectSearchFlightInfoDto.getChildrenSeats().get(selectSearchSeatDto.getSeatClassType()).getFlightTicketPriceDto();
					}else{
						fitFlightTicketPriceDto = selectSearchSeatDto.getFlightTicketPriceDto();
					}
				}
				//包机切位没有儿童舱的问题
				else{
					fitFlightTicketPriceDto = selectSearchSeatDto.getFlightTicketPriceDto();
				}
				try {
					BeanUtils.copyProperties(flightTicketPriceDto, fitFlightTicketPriceDto);
				} catch (Exception e) {
					logger.error(ExceptionUtils.getFullStackTrace(e));
				}
				flightSimpleInfoDto.setFlightTicketPriceDto(flightTicketPriceDto);
				amountDetailDto.setFlightSimpleInfo(flightSimpleInfoDto);
				amountDetailDto.setPassengerType(passengerDetailDto.getPassengerType());
				amountDetailDtos.add(amountDetailDto);
			}
			//如果是包机切位，只计算一个航程的价格.
			if(CharterFlightFilterUtil.isCharset(selectSearchFlightInfoDto)){
				break;
			}
		}
		if(CollectionUtils.isNotEmpty(amountDetailDtos)){
			AmountCalculatorRequest flightPriceRequest = new AmountCalculatorRequest();
			flightPriceRequest.setBookingSource(BookingSource.valueOf(fitSdpShoppingRequest.getBookingSource().getParentSource().name()));
			flightPriceRequest.setPassengerDetailDtos(amountDetailDtos);
			return flightPriceRequest;
		}
		return null;
	}
}
