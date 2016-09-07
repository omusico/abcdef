package com.lvmama.lvfit.common.dto.shopping;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.FitOrderResultStatus;
import com.lvmama.lvfit.common.dto.enums.PassengerType;

public class ShoppingDetailDto extends Entity {	

    private static final long serialVersionUID = 8171255717941746981L;
    
    private String shoppingUuid;
	private String customerId;
	private String customeNo;
	private String customerName;
	private String operIp;

	private Long operId;

	private String operName;
    
	//下单类型：1前台 2：后台
	private String shoppingType = "1";

	private String contacterName;

	private String contacterMobile;

	private String contacterEmail;

	private String searchCondition;
	
    private String  arrivalCityName;
    private String  departureCityName;
    private String  hotelCityName;
    private Date   createTime;
   
    private String adultCount;
    private String childCount;
    
    // VST订单状态（成功|失败）
    private FitOrderResultStatus vstOrderStatus;
    // 机票去程状态（成功|失败）
    private FitOrderResultStatus depFliOrderStatus;
    // 机票返程状态（成功|失败）
    private FitOrderResultStatus arvFliOrderStatus;
    // VST订单状态具体信息
    private String vstOrderMsg;
    // 机票返程状态具体信息
    private String depFliOrderMsg;
    // 机票返程状态具体信息
    private String arvFliOrderMsg;
    
	public String getShoppingUuid() {
		return shoppingUuid;
	}

	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomeNo() {
		return customeNo;
	}

	public void setCustomeNo(String customeNo) {
		this.customeNo = customeNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOperIp() {
		return operIp;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}

	public Long getOperId() {
		return operId;
	}

	public void setOperId(Long operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getShoppingType() {
		return shoppingType;
	}

	public void setShoppingType(String shoppingType) {
		this.shoppingType = shoppingType;
	}

	public String getContacterName() {
		return contacterName;
	}

	public void setContacterName(String contacterName) {
		this.contacterName = contacterName;
	}

	public String getContacterMobile() {
		return contacterMobile;
	}

	public void setContacterMobile(String contacterMobile) {
		this.contacterMobile = contacterMobile;
	}

	public String getContacterEmail() {
		return contacterEmail;
	}

	public void setContacterEmail(String contacterEmail) {
		this.contacterEmail = contacterEmail;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getArrivalCityName() {
		return arrivalCityName;
	}

	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}

	public String getDepartureCityName() {
		return departureCityName;
	}

	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
     
	public String getHotelCityName() {
		return hotelCityName;
	}

	public void setHotelCityName(String hotelCityName) {
		this.hotelCityName = hotelCityName;
	}
    
	public String getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(String adultCount) {
		this.adultCount = adultCount;
	}

	public String getChildCount() {
		return childCount;
	}

	public void setChildCount(String childCount) {
		this.childCount = childCount;
	}
	
	/**
     * 构造订单列表String
     * @return 
     */
    public String constructOrderListStr()
    {
    	StringBuffer shoppingListStr = new StringBuffer();
    	shoppingListStr.append(this.getShoppingUuid()).append(",");
    	shoppingListStr.append(this.getCustomerId()).append(",");
    	if(this.getCustomerName() != null)
    	{
    		shoppingListStr.append(this.getCustomerName()).append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
    	if(StringUtils.isNotBlank(this.getContacterName()))
    	{
    		shoppingListStr.append(this.getContacterName()).append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
    	if(StringUtils.isNotBlank(this.getContacterMobile()))
    	{
    		shoppingListStr.append("\t").append(this.getContacterMobile()).append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
    	if(StringUtils.isNotBlank(this.getDepartureCityName()))
    	{
    		shoppingListStr.append(this.getDepartureCityName()).append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
    	if(StringUtils.isNotBlank(this.getArrivalCityName()))
    	{
    		shoppingListStr.append(this.getArrivalCityName()).append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
    	if(StringUtils.isNotBlank(this.getHotelCityName()))
    	{
    		shoppingListStr.append(this.getHotelCityName()).append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
    	if(StringUtils.isNotBlank(this.getAdultCount()) || StringUtils.isNotBlank(this.getChildCount()))
    	{   if(!"0".equals(this.getAdultCount())){
    		shoppingListStr.append(this.getAdultCount()+PassengerType.ADULT.getCnName());}
    	   if(!"0".equals(this.getChildCount())){
    		 shoppingListStr.append(this.getChildCount()+PassengerType.CHILDREN.getCnName());   
    	   }
    	   shoppingListStr.append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
    		
    	if(this.getCreateTime()!=null)
    	{																		
    		String dateStr = DateUtils.formatCnHmDate(this.getCreateTime());
    		shoppingListStr.append("\t").append(dateStr).append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
    	
    	if(null != this.getVstOrderStatus()){
    		shoppingListStr.append(this.getVstOrderStatus()).append(",");
    	}else{
    		shoppingListStr.append("").append(",");
    	}
		
		return shoppingListStr.toString();
    }

    public FitOrderResultStatus getVstOrderStatus() {
        return vstOrderStatus;
    }

    public void setVstOrderStatus(FitOrderResultStatus vstOrderStatus) {
        this.vstOrderStatus = vstOrderStatus;
    }

    public FitOrderResultStatus getDepFliOrderStatus() {
        return depFliOrderStatus;
    }

    public void setDepFliOrderStatus(FitOrderResultStatus depFliOrderStatus) {
        this.depFliOrderStatus = depFliOrderStatus;
    }

    public FitOrderResultStatus getArvFliOrderStatus() {
        return arvFliOrderStatus;
    }

    public void setArvFliOrderStatus(FitOrderResultStatus arvFliOrderStatus) {
        this.arvFliOrderStatus = arvFliOrderStatus;
    }

    public String getVstOrderMsg() {
        return vstOrderMsg;
    }

    public void setVstOrderMsg(String vstOrderMsg) {
        this.vstOrderMsg = vstOrderMsg;
    }

    public String getDepFliOrderMsg() {
        return depFliOrderMsg;
    }

    public void setDepFliOrderMsg(String depFliOrderMsg) {
        this.depFliOrderMsg = depFliOrderMsg;
    }

    public String getArvFliOrderMsg() {
        return arvFliOrderMsg;
    }

    public void setArvFliOrderMsg(String arvFliOrderMsg) {
        this.arvFliOrderMsg = arvFliOrderMsg;
    }

}
