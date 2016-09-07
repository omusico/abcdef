package com.lvmama.lvfit.common.dto.adapter.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;

/**
 * 请求vst预定Request
 */
public class VstBookingRequest implements Serializable{

    private static final long serialVersionUID = -656931833774770447L;

    /** 游玩日期 */
    private String visitTime;

    /** 机票：成人总价（VST算价必须项） */
    private BigDecimal adultAmount;

    /** 机票：儿童总价（VST算价必须项） */
    private BigDecimal childAmount;

    /** 成人数量 */
    private int adultQuantity;

    /** 儿童数量 */
    private int childQuantity;

    /** 下单用户 */
    private FitOrderCustomerDto fitOrderCustomerDto;

    /** 联系人 */
    private FitOrderContacterDto fitOrderContacterDto;

    /** 游玩人 */
    private List<FitOrderPassengerDto> fitOrderPassengerDtoList = new ArrayList<FitOrderPassengerDto>();

    /** 酒店信息 */
    private List<FitOrderHotelDto> fitOrderHotelDtoList = new ArrayList<FitOrderHotelDto>();

    /** 航班信息 */
    private List<FitOrderFlightDto> fitOrderFlightDtoList = new ArrayList<FitOrderFlightDto>();
    
    /** 景点门票信息 */
    private List<FitOrderSpotTicketDto> fitOrderSpotTicketDtos = new ArrayList<FitOrderSpotTicketDto>();
    
    /** 景点门票信息 */
    private List<FitOrderInsuranceDto> fitOrderInsuranceDtos = new ArrayList<FitOrderInsuranceDto>();
    
    /** 产品名称 */
    private String productName;
    
    /**机酒订单信息 */
    List<FitOrderDto> fitOrderDtos = new ArrayList<FitOrderDto>();
    
    /**sdp 产品Id (仅限sdp产品) */
    private Long productId;
    
    /**sdp 品类Id (仅限sdp产品) */
    private Long categoryId;
    
    /**行程Id (仅限sdp产品) */
    private Long lineRouteId;
    
    private BookingSource bookingSource;
    
	/**酒店组合套餐信息 */
	private FitOrderHotelComboDto fitOrderHotelComboDto = null;
	
	/**当地游信息 */
	private FitOrderLocalTripProductDto fitOrderLocalTripProductDto = null;
   
	/**其他票信息 */
    private List<FitOrderOtherTicketDto> fitOrderOtherTicketDtos = new ArrayList<FitOrderOtherTicketDto>();
    
    /**sdp产品 航班加价规则*/
    private BigDecimal flightFeeAmount;
    
    /**sdp产品 房差*/
    private FitOrderRoomDiffDto fitOrderRoomDiffDto = null;

    /**分销商ID */
	private Long distributionChannel;

	/**分销商代码*/
	private String distributorCode;

    public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public BigDecimal getAdultAmount() {
        return adultAmount;
    }

    public void setAdultAmount(BigDecimal adultAmount) {
        this.adultAmount = adultAmount;
    }

    public BigDecimal getChildAmount() {
        return childAmount;
    }

    public void setChildAmount(BigDecimal childAmount) {
        this.childAmount = childAmount;
    }

    public int getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(int adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public int getChildQuantity() {
        return childQuantity;
    }

    public void setChildQuantity(int childQuantity) {
        this.childQuantity = childQuantity;
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

    public List<FitOrderPassengerDto> getFitOrderPassengerDtoList() {
        return fitOrderPassengerDtoList;
    }

    public void setFitOrderPassengerDtoList(List<FitOrderPassengerDto> fitOrderPassengerDtoList) {
        this.fitOrderPassengerDtoList = fitOrderPassengerDtoList;
    }

    public List<FitOrderHotelDto> getFitOrderHotelDtoList() {
        return fitOrderHotelDtoList;
    }

    public void setFitOrderHotelDtoList(List<FitOrderHotelDto> fitOrderHotelDtoList) {
        this.fitOrderHotelDtoList = fitOrderHotelDtoList;
    }

    public List<FitOrderFlightDto> getFitOrderFlightDtoList() {
        return fitOrderFlightDtoList;
    }

    public void setFitOrderFlightDtoList(List<FitOrderFlightDto> fitOrderFlightDtoList) {
        this.fitOrderFlightDtoList = fitOrderFlightDtoList;
    }


	public List<FitOrderSpotTicketDto> getFitOrderSpotTicketDtos() {
		return fitOrderSpotTicketDtos;
	}


	public void setFitOrderSpotTicketDtos(
			List<FitOrderSpotTicketDto> fitOrderSpotTicketDtos) {
		this.fitOrderSpotTicketDtos = fitOrderSpotTicketDtos;
	}

    public List<FitOrderInsuranceDto> getFitOrderInsuranceDtos() {
		return fitOrderInsuranceDtos;
	}

	public void setFitOrderInsuranceDtos(
			List<FitOrderInsuranceDto> fitOrderInsuranceDtos) {
		this.fitOrderInsuranceDtos = fitOrderInsuranceDtos;
	}

	public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

	public List<FitOrderDto> getFitOrderDtos() {
		return fitOrderDtos;
	}

	public void setFitOrderDtos(List<FitOrderDto> fitOrderDtos) {
		this.fitOrderDtos = fitOrderDtos;
	}
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public FitOrderHotelComboDto getFitOrderHotelComboDto() {
		return fitOrderHotelComboDto;
	}

	public void setFitOrderHotelComboDto(FitOrderHotelComboDto fitOrderHotelComboDto) {
		this.fitOrderHotelComboDto = fitOrderHotelComboDto;
	}

	public FitOrderLocalTripProductDto getFitOrderLocalTripProductDto() {
		return fitOrderLocalTripProductDto;
	}

	public void setFitOrderLocalTripProductDto(
			FitOrderLocalTripProductDto fitOrderLocalTripProductDto) {
		this.fitOrderLocalTripProductDto = fitOrderLocalTripProductDto;
	}

	public List<FitOrderOtherTicketDto> getFitOrderOtherTicketDtos() {
		return fitOrderOtherTicketDtos;
	}

	public void setFitOrderOtherTicketDtos(
			List<FitOrderOtherTicketDto> fitOrderOtherTicketDtos) {
		this.fitOrderOtherTicketDtos = fitOrderOtherTicketDtos;
	}

	@JsonIgnore
	public Map<String,FitOrderDto> getFitOrderMap(){
		
		Map<String,FitOrderDto> fitOrderMap = new HashMap<String, FitOrderDto>();
		List<FitOrderDto> fitOrderDtos = this.getFitOrderDtos();
		if(CollectionUtils.isNotEmpty(fitOrderDtos)){
			for (FitOrderDto fitOrderDto : fitOrderDtos) {
				fitOrderMap.put(fitOrderDto.getOrderKey(), fitOrderDto);
			}
		}
		return fitOrderMap;
	}
	
	@JsonIgnore
	public Map<String,List<FitOrderPassengerDto>> getFitOrderPassengerMap(){
		
		Map<String,List<FitOrderPassengerDto>> fitOrderPassengerMap = new HashMap<String, List<FitOrderPassengerDto>>();
		List<FitOrderPassengerDto> fitOrderPassengerDtos = this.getFitOrderPassengerDtoList();
		if(CollectionUtils.isNotEmpty(fitOrderPassengerDtos)){
			for (FitOrderPassengerDto fitOrderPassengerDto : fitOrderPassengerDtos) {
				  String key = fitOrderPassengerDto.getPassengerType().name();
				  if(fitOrderPassengerMap.containsKey(key)){
					  fitOrderPassengerMap.get(key).add(fitOrderPassengerDto);
				  }else{
					  List<FitOrderPassengerDto> groupFlightOrderPassengerDtos = new ArrayList<FitOrderPassengerDto>();
					  groupFlightOrderPassengerDtos.add(fitOrderPassengerDto);
					  fitOrderPassengerMap.put(key, groupFlightOrderPassengerDtos);
				 }
			}
		}
		return fitOrderPassengerMap;
	}

	public BigDecimal getFlightFeeAmount() {
		return flightFeeAmount;
	}

	public void setFlightFeeAmount(BigDecimal flightFeeAmount) {
		this.flightFeeAmount = flightFeeAmount;
	}

	public FitOrderRoomDiffDto getFitOrderRoomDiffDto() {
		return fitOrderRoomDiffDto;
	}

	public void setFitOrderRoomDiffDto(FitOrderRoomDiffDto fitOrderRoomDiffDto) {
		this.fitOrderRoomDiffDto = fitOrderRoomDiffDto;
	}

	public Long getLineRouteId() {
		return lineRouteId;
	}

	public void setLineRouteId(Long lineRouteId) {
		this.lineRouteId = lineRouteId;
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
