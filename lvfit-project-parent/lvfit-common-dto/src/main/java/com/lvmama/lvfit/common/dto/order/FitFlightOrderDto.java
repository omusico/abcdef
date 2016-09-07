package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitFlightBookingType;

/**
 * 供机票自行补单用的dto.
 * @author lishuiqing
 *
 */
public class FitFlightOrderDto extends Entity {

	private static final long serialVersionUID = -4842341566960811989L;

	/** 订单号信息(主单) */
	private FitOrderNoDto fitOrderNo;
	
	/** 订单总金额信息 -- 可能在子单之和之上另有扣减 */
    private FitOrderAmountDto orderAmount;
	
	/** 订单客户信息 */
	private FitOrderCustomerDto fitOrderCustomer;
	
	/** 订单联系人信息 */
	private FitOrderContacterDto fitOrderContacter;
	
	/** 订单预订来源 */
	private BookingSource bookingSource;  
 
	/** 关联关系 */
	private FitSuppMainOrderDto fitSuppMainOrderDto;

	public FitSuppMainOrderDto getFitSuppMainOrderDto() {
		return fitSuppMainOrderDto;
	}

	public void setFitSuppMainOrderDto(FitSuppMainOrderDto fitSuppMainOrderDto) {
		this.fitSuppMainOrderDto = fitSuppMainOrderDto;
	}

	/** 订单乘机人信息 */
	private List<FitOrderPassengerDto> fitOrderPassengers = new ArrayList<FitOrderPassengerDto>();
//	
//	/** 订单操作日志信息 */
//	private List<FitOrderOpLogDto> ordeOpLogs = new ArrayList<FitOrderOpLogDto>();
//	
//	/** 订单信息 */
//	private List<FitOrderDto> fitOrders = new ArrayList<FitOrderDto>();
	  
	/** 机票信息 */
	List<FitOrderFlightDto> fitOrderFlightDtos = new ArrayList<FitOrderFlightDto>();  
    
	/** 产品名称 */
	private String productName;
	
	/**机+X动态打包  */
	private FitFlightBookingType  fitFlightBookingType; 
	
    /**sdp 产品Id (仅限sdp产品) */
    private Long productId;
    
    /**sdp 品类Id (仅限sdp产品) */
    private Long categoryId;
    
    /**行程Id (仅限sdp产品) */
    private Long lineRouteId;
    
    /**sdp 航班加价规则*/
    private BigDecimal flightFeeAmount; 

	/**分销商ID */
	private Long distributionChannel;

	/**分销商代码*/
	private String distributorCode;

	public FitOrderNoDto getFitOrderNo() {
		return fitOrderNo;
	}

	public void setFitOrderNo(FitOrderNoDto fitOrderNo) {
		this.fitOrderNo = fitOrderNo;
	}

	public FitOrderAmountDto getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(FitOrderAmountDto orderAmount) {
		this.orderAmount = orderAmount;
	}

	public FitOrderCustomerDto getFitOrderCustomer() {
		return fitOrderCustomer;
	}

	public void setFitOrderCustomer(FitOrderCustomerDto fitOrderCustomer) {
		this.fitOrderCustomer = fitOrderCustomer;
	}

	public FitOrderContacterDto getFitOrderContacter() {
		return fitOrderContacter;
	}

	public void setFitOrderContacter(FitOrderContacterDto fitOrderContacter) {
		this.fitOrderContacter = fitOrderContacter;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}
 

	public List<FitOrderPassengerDto> getFitOrderPassengers() {
		return fitOrderPassengers;
	}

	public void setFitOrderPassengers(List<FitOrderPassengerDto> fitOrderPassengers) {
		this.fitOrderPassengers = fitOrderPassengers;
	} 

	public List<FitOrderFlightDto> getFitOrderFlightDtos() {
		return fitOrderFlightDtos;
	}

	public void setFitOrderFlightDtos(List<FitOrderFlightDto> fitOrderFlightDtos) {
		this.fitOrderFlightDtos = fitOrderFlightDtos;
	} 
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public FitFlightBookingType getFitFlightBookingType() {
		return fitFlightBookingType;
	}

	public void setFitFlightBookingType(FitFlightBookingType fitFlightBookingType) {
		this.fitFlightBookingType = fitFlightBookingType;
	}
	@Override
	public String getSequence() {
	    return "S_FITORD_ORDER_MAIN_NEW";
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
