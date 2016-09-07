package com.lvmama.lvfit.common.dto.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderExpressDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOperDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRemarkDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;

/**
 * @author qihuisong
 */
public class FitOrderBookingRequest {

    private String shoppingUuid;

    /**sdp 产品Id (仅限sdp产品) */
    private Long productId;
    
    /**sdp 品类Id (仅限sdp产品) */
    private Long categoryId;
    
    /**行程Id */
    private Long lineRouteId;
    
    /** 机加酒产品名称  或者 sdp产品名称 */
    private String productName;

    /** 下单人信息 */
    private FitOrderCustomerDto fitOrderCustomerDto;

    /** 联系人 | 购买人 */
    private FitOrderContacterDto fitOrderContacterDto;

    /** 游玩人员 */
    private List<FitOrderPassengerDto> fitOrderPassengerDtos = new ArrayList<FitOrderPassengerDto>();

    /** 配送方式 */
    private FitOrderExpressDto fitOrderExpressDto;

    /** 订单操作者信息 */
    private FitOrderOperDto fitOrderOperDto;

    /** 订单备注信息 */
    private List<FitOrderRemarkDto> fitOrderRemarkDtos = new ArrayList<FitOrderRemarkDto>();

    /** 预定来源 */
    private BookingSource bookingSource;

    /** 价格信息 */
    private FitOrderAmountDto fitOrderAmountDto;

    /** 机票信息 */
    private List<FitOrderFlightDto> fitOrderFlightDtos = new ArrayList<FitOrderFlightDto>();

    /** 酒店信息 */
    private List<FitOrderHotelDto> fitOrderHotelDtos = new ArrayList<FitOrderHotelDto>();
    
    /**景点门票信息*/
	private List<FitOrderSpotTicketDto> fitOrderSpotTicketDtos = new ArrayList<FitOrderSpotTicketDto>();
	
	/**保险信息*/
	private List<FitOrderInsuranceDto> fitOrderInsuranceDtos = new ArrayList<FitOrderInsuranceDto>();
	
	/**订单用户基访问信息*/
	private FitOrderBasicInfoDto fitOrderBasicInfoDto = new FitOrderBasicInfoDto();
	
	
	/*************************************交通自主打包***********************************************/
	
	/**酒店组合套餐信息 */
	private FitOrderHotelComboDto fitOrderHotelComboDto;
	
	/**当地游信息 */
	private FitOrderLocalTripProductDto fitOrderLocalTripProductDto;
   
	/**其他票信息 */
    private List<FitOrderOtherTicketDto> fitOrderOtherTicketDtos = new ArrayList<FitOrderOtherTicketDto>();
    
    /**sdp产品 航班加价规则*/
    private BigDecimal flightFeeAmount;
    
    /**sdp产品 房差信息*/
    private FitOrderRoomDiffDto fitOrderRoomDiffDto;

	/**分销商ID */
	private Long distributionChannel;

	/**分销商代码*/
	private String distributorCode;
    
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

    public FitOrderOperDto getFitOrderOperDto() {
        return fitOrderOperDto;
    }

    public void setFitOrderOperDto(FitOrderOperDto fitOrderOperDto) {
        this.fitOrderOperDto = fitOrderOperDto;
    }

    public List<FitOrderRemarkDto> getFitOrderRemarkDtos() {
        return fitOrderRemarkDtos;
    }

    public void setFitOrderRemarkDtos(List<FitOrderRemarkDto> fitOrderRemarkDtos) {
        this.fitOrderRemarkDtos = fitOrderRemarkDtos;
    }

    public BookingSource getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(BookingSource bookingSource) {
        this.bookingSource = bookingSource;
    }

    public FitOrderAmountDto getFitOrderAmountDto() {
        return fitOrderAmountDto;
    }

    public void setFitOrderAmountDto(FitOrderAmountDto fitOrderAmountDto) {
        this.fitOrderAmountDto = fitOrderAmountDto;
    }

    public List<FitOrderFlightDto> getFitOrderFlightDtos() {
        return fitOrderFlightDtos;
    }

    public void setFitOrderFlightDtos(List<FitOrderFlightDto> fitOrderFlightDtos) {
        this.fitOrderFlightDtos = fitOrderFlightDtos;
    }

    public List<FitOrderHotelDto> getFitOrderHotelDtos() {
        return fitOrderHotelDtos;
    }

    public void setFitOrderHotelDtos(List<FitOrderHotelDto> fitOrderHotelDtos) {
        this.fitOrderHotelDtos = fitOrderHotelDtos;
    }

	public List<FitOrderSpotTicketDto> getFitOrderSpotTicketDtos() {
		return fitOrderSpotTicketDtos;
	}

	public void setFitOrderSpotTicketDtos(
			List<FitOrderSpotTicketDto> fitOrderSpotTicketDtos) {
		this.fitOrderSpotTicketDtos = fitOrderSpotTicketDtos;
	}

	public String getShoppingUuid() {
        return shoppingUuid;
    }

    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

	public final String getProductName() {
		return productName;
	}

	public final void setProductName(String productName) {
		this.productName = productName;
	}

	public FitOrderBasicInfoDto getFitOrderBasicInfoDto() {
		return fitOrderBasicInfoDto;
	}

	public void setFitOrderBasicInfoDto(FitOrderBasicInfoDto fitOrderBasicInfoDto) {
		this.fitOrderBasicInfoDto = fitOrderBasicInfoDto;
	}

	public String getVisitTime() {
		return fitOrderBasicInfoDto.getVisitTime();
	}

	public void setVisitTime(String visitTime) {
		fitOrderBasicInfoDto.setVisitTime(visitTime);
	}

	public int getAdultQuantity() {
		return fitOrderBasicInfoDto.getAdultQuantity();
	}

	public void setAdultQuantity(int adultQuantity) {
		fitOrderBasicInfoDto.setAdultQuantity(adultQuantity);
	}

	public int getChildQuantity() {
		return fitOrderBasicInfoDto.getChildQuantity();
	}

	public void setChildQuantity(int childQuantity) {
		fitOrderBasicInfoDto.setChildQuantity(childQuantity);
	}

	public List<FitOrderInsuranceDto> getFitOrderInsuranceDtos() {
		return fitOrderInsuranceDtos;
	}

	public void setFitOrderInsuranceDtos(List<FitOrderInsuranceDto> fitOrderInsuranceDtos) {
		this.fitOrderInsuranceDtos = fitOrderInsuranceDtos;
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

	public void setFitOrderLocalTripProductDto(FitOrderLocalTripProductDto fitOrderLocalTripProductDto) {
		this.fitOrderLocalTripProductDto = fitOrderLocalTripProductDto;
	}

	public List<FitOrderOtherTicketDto> getFitOrderOtherTicketDtos() {
		return fitOrderOtherTicketDtos;
	}

	public void setFitOrderOtherTicketDtos(List<FitOrderOtherTicketDto> fitOrderOtherTicketDtos) {
		this.fitOrderOtherTicketDtos = fitOrderOtherTicketDtos;
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

	public BigDecimal getFlightFeeAmount() {
		return flightFeeAmount;
	}

	public void setFlightFeeAmount(BigDecimal flightFeeAmount) {
		this.flightFeeAmount = flightFeeAmount;
	}

	public FitOrderRoomDiffDto getFitOrderRoomDiffDto() {
		return fitOrderRoomDiffDto;
	}

	public void setFitOrderRoomDiffDto(
			FitOrderRoomDiffDto fitOrderRoomDiffDto) {
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
