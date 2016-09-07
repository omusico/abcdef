package com.lvmama.lvfit.common.form.booking;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.order.*;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author qihuisong
 */
public class BookingInputForm implements Form {
	private FitOrderBookingRequest fitOrderBookingRequest = new FitOrderBookingRequest();
	/**     * 购买人邮箱     */
    private String email;
    /**     * 购买人电话     */
    private String mobile;
	/**     * 购买人姓名     */
    private String name;
    /**     * 购买人编号     */
    private String receiverId;
    /**     * 购买人 证件类型     */
    private String certType;
    /**     * 购买人 证件号码     */
    private String certNo;
    /**     * 购买人 生日     */
    private String birthday;
    /**     * 购买人 人员类型     */
    private String peopleType;
    
    /** 游玩人员列表 */
    private String playerList ;
    /** 应付总价格 */
    private BigDecimal totalPrice ;
    /** uuid  */
    private String shoppingUUID ;
    /** 游玩日期 */
    private String visitTime ;
    /**  机加酒产品名称 */
    private String productName ;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public final String getReceiverId() {
		return receiverId;
	}

	public final void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public final String getCertType() {
		return certType;
	}

	public final void setCertType(String certType) {
		this.certType = certType;
	}

	public final String getCertNo() {
		return certNo;
	}

	public final void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public final String getBirthday() {
		return birthday;
	}

	public final void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public final String getPeopleType() {
		return peopleType;
	}

	public final void setPeopleType(String peopleType) {
		this.peopleType = peopleType;
	}

	public String getPlayerList() {
		return playerList;
	}

	public void setPlayerList(String playerList) {
		this.playerList = playerList;
	}

	public FitOrderBookingRequest getFitOrderBookingRequest() {
		return fitOrderBookingRequest;
	}

	public void setFitOrderBookingRequest(FitOrderBookingRequest fitOrderBookingRequest) {
		this.fitOrderBookingRequest = fitOrderBookingRequest;
	}

	/*public String getVisitTime() {
		return fitOrderBookingRequest.getVisitTime();
	}*/

	public void setFitOrderOperDto(FitOrderOperDto fitOrderOperDto) {
		fitOrderBookingRequest.setFitOrderOperDto(fitOrderOperDto);
	}

	public void setFitOrderRemarkDtos(List<FitOrderRemarkDto> fitOrderRemarkDtos) {
		fitOrderBookingRequest.setFitOrderRemarkDtos(fitOrderRemarkDtos);
	}

	public FitOrderExpressDto getFitOrderExpressDto() {
		return fitOrderBookingRequest.getFitOrderExpressDto();
	}

	public void setBookingSource(BookingSource bookingSource) {
		fitOrderBookingRequest.setBookingSource(bookingSource);
	}

	public void setFitOrderExpressDto(FitOrderExpressDto fitOrderExpressDto) {
		fitOrderBookingRequest.setFitOrderExpressDto(fitOrderExpressDto);
	}

	public FitOrderOperDto getFitOrderOperDto() {
		return fitOrderBookingRequest.getFitOrderOperDto();
	}

	public void setFitOrderCustomerDto(FitOrderCustomerDto fitOrderCustomerDto) {
		fitOrderBookingRequest.setFitOrderCustomerDto(fitOrderCustomerDto);
	}

	public FitOrderAmountDto getFitOrderAmountDto() {
		return fitOrderBookingRequest.getFitOrderAmountDto();
	}

	public void setFitOrderPassengerDtos(List<FitOrderPassengerDto> fitOrderPassengerDtos) {
		fitOrderBookingRequest.setFitOrderPassengerDtos(fitOrderPassengerDtos);
	}

	public BookingSource getBookingSource() {
		return fitOrderBookingRequest.getBookingSource();
	}

	/*public void setVisitTime(String visitTime) {
		fitOrderBookingRequest.setVisitTime(visitTime);
	}*/

	public FitOrderContacterDto getFitOrderContacterDto() {
		return fitOrderBookingRequest.getFitOrderContacterDto();
	}

	public FitOrderCustomerDto getFitOrderCustomerDto() {
		return fitOrderBookingRequest.getFitOrderCustomerDto();
	}

	public List<FitOrderPassengerDto> getFitOrderPassengerDtos() {
		return fitOrderBookingRequest.getFitOrderPassengerDtos();
	}

	public void setFitOrderContacterDto(FitOrderContacterDto fitOrderContacterDto) {
		fitOrderBookingRequest.setFitOrderContacterDto(fitOrderContacterDto);
	}

	public void setFitOrderAmountDto(FitOrderAmountDto fitOrderAmountDto) {
		fitOrderBookingRequest.setFitOrderAmountDto(fitOrderAmountDto);
	}

	public List<FitOrderRemarkDto> getFitOrderRemarkDtos() {
		return fitOrderBookingRequest.getFitOrderRemarkDtos();
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShoppingUUID() {
		return shoppingUUID;
	}

	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public final String getProductName() {
		return productName;
	}

	public final void setProductName(String productName) {
		this.productName = productName;
	}
}
