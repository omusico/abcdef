package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitFlightBookingType;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;

public class FitOrderMainDto extends Entity {

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
		
	/** 订单合同信息 */
	private FitOrderAgreementDto fitOrderAgreement;

	/** 订单快递信息 */
	private FitOrderExpressDto fitOrderExpress;

	/** 订单乘机人信息 */
	private List<FitOrderPassengerDto> fitOrderPassengers = new ArrayList<FitOrderPassengerDto>();
	
	/** 订单操作日志信息 */
	private List<FitOrderOpLogDto> ordeOpLogs = new ArrayList<FitOrderOpLogDto>();
	
	/** 订单信息 */
	private List<FitOrderDto> fitOrders = new ArrayList<FitOrderDto>();
	
	/** 订单备注信息(只用于级联加载，不用于级联保存) */
	private List<FitOrderRemarkDto> fitOrderRemarks = new ArrayList<FitOrderRemarkDto>();

	/** 关联关系 */
	private FitSuppMainOrderDto fitSuppMainOrderDto;

	/** 机票信息 */
	List<FitOrderFlightDto> fitOrderFlightDtos = new ArrayList<FitOrderFlightDto>();

	/** 酒店信息 */
	List<FitOrderHotelDto> fitOrderHotelDtos = new ArrayList<FitOrderHotelDto>();
	
	/**门票信息*/
	List<FitOrderSpotTicketDto> fitOrderSpotTicketDtos = new ArrayList<FitOrderSpotTicketDto>();
	
	/**订单游玩基本信息*/
    private FitOrderBasicInfoDto fitOrderBasicInfoDto;
    
	/**保险信息*/
	List<FitOrderInsuranceDto> fitOrderInsuranceDtos = new ArrayList<FitOrderInsuranceDto>();

	/**机票航意险信息*/
    List<FitOrderFliInsuranceDto> flightInsuranceDtos = new ArrayList<FitOrderFliInsuranceDto>();
    
	/** 产品名称 */
	private String productName;
	
	/**机+X动态打包  */
	private FitFlightBookingType  fitFlightBookingType;
	
	/**酒店组合套餐信息 */
	private FitOrderHotelComboDto fitOrderHotelComboDto = null;
	
	/**当地游信息 */
	private FitOrderLocalTripProductDto fitOrderLocalTripProductDto = null;
   
	/**其他票信息 */
    private List<FitOrderOtherTicketDto> fitOrderOtherTicketDtos = new ArrayList<FitOrderOtherTicketDto>();
	
    /**sdp 产品Id (仅限sdp产品) */
    private Long productId;
    
    /**sdp 品类Id (仅限sdp产品) */
    private Long categoryId;
    
    /**行程Id (仅限sdp产品) */
    private Long lineRouteId;
    
    /**sdp 航班加价规则*/
    private BigDecimal flightFeeAmount;
    
    /**sdp产品 房差*/
    private FitOrderRoomDiffDto fitOrderRoomDiffDto = null;

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

	public FitOrderAgreementDto getFitOrderAgreement() {
		return fitOrderAgreement;
	}

	public void setFitOrderAgreement(FitOrderAgreementDto fitOrderAgreement) {
		this.fitOrderAgreement = fitOrderAgreement;
	}

	public FitOrderExpressDto getFitOrderExpress() {
		return fitOrderExpress;
	}

	public void setFitOrderExpress(FitOrderExpressDto fitOrderExpress) {
		this.fitOrderExpress = fitOrderExpress;
	}

	public List<FitOrderPassengerDto> getFitOrderPassengers() {
		return fitOrderPassengers;
	}

	public void setFitOrderPassengers(List<FitOrderPassengerDto> fitOrderPassengers) {
		this.fitOrderPassengers = fitOrderPassengers;
	}

	public List<FitOrderOpLogDto> getOrdeOpLogs() {
		return ordeOpLogs;
	}

	public void setOrdeOpLogs(List<FitOrderOpLogDto> ordeOpLogs) {
		this.ordeOpLogs = ordeOpLogs;
	}

	public List<FitOrderDto> getFitOrders() {
		return fitOrders;
	}

	public void setFitOrders(List<FitOrderDto> fitOrders) {
		this.fitOrders = fitOrders;
	}

	public List<FitOrderRemarkDto> getFitOrderRemarks() {
		return fitOrderRemarks;
	}

	public void setFitOrderRemarks(List<FitOrderRemarkDto> fitOrderRemarks) {
		this.fitOrderRemarks = fitOrderRemarks;
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

	public FitSuppMainOrderDto getFitSuppMainOrderDto() {
		return fitSuppMainOrderDto;
	}

	public void setFitSuppMainOrderDto(FitSuppMainOrderDto fitSuppMainOrderDto) {
		this.fitSuppMainOrderDto = fitSuppMainOrderDto;
	}
	
	public FitOrderBasicInfoDto getFitOrderBasicInfoDto() {
		return fitOrderBasicInfoDto;
	}
	
	public List<FitOrderInsuranceDto> getFitOrderInsuranceDtos() {
		return fitOrderInsuranceDtos;
	}

	public void setFitOrderInsuranceDtos(List<FitOrderInsuranceDto> fitOrderInsuranceDtos) {
		this.fitOrderInsuranceDtos = fitOrderInsuranceDtos;
	}

	public void setFitOrderBasicInfoDto(FitOrderBasicInfoDto fitOrderBasicInfoDto) {
		this.fitOrderBasicInfoDto = fitOrderBasicInfoDto;
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

    public List<FitOrderFliInsuranceDto> getFlightInsuranceDtos() {
        return flightInsuranceDtos;
    }

    public void setFlightInsuranceDtos(List<FitOrderFliInsuranceDto> flightInsuranceDtos) {
        this.flightInsuranceDtos = flightInsuranceDtos;
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
