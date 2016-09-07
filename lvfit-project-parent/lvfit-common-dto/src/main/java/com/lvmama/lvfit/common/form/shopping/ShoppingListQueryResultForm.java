package com.lvmama.lvfit.common.form.shopping;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.FitOrderResultStatus;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;

public class ShoppingListQueryResultForm implements Serializable,Form {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8129756951965204178L;
	private ShoppingDetailDto shoppingDetailDto;
	public ShoppingDetailDto getShoppingDetailDto() {
		return shoppingDetailDto;
	}
	public void setShoppingDetailDto(ShoppingDetailDto shoppingDetailDto) {
		this.shoppingDetailDto = shoppingDetailDto;
	}
	
	public String getShoppingUuid() {
		return shoppingDetailDto.getShoppingUuid();
	}

	public void setShoppingUuid(String shoppingUuid) {
		shoppingDetailDto.setShoppingUuid(shoppingUuid);
	}

	public String getCustomerId() {
		return shoppingDetailDto.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		shoppingDetailDto.setCustomerId(customerId);
	}

	public String getCustomeNo() {
		return shoppingDetailDto.getCustomeNo();
	}

	public void setCustomeNo(String customeNo) {
		shoppingDetailDto.setCustomeNo(customeNo);
	}

	public String getCustomerName() {
		return shoppingDetailDto.getCustomerName();
	}

	public void setCustomerName(String customerName) {
		shoppingDetailDto.setCustomerName(customerName);
	}

	public String getOperIp() {
		return shoppingDetailDto.getOperIp();
	}

	public void setOperIp(String operIp) {
		shoppingDetailDto.setOperIp(operIp);
	}

	public Long getOperId() {
		return shoppingDetailDto.getOperId();
	}

	public void setOperId(Long operId) {
		shoppingDetailDto.setOperId(operId);
	}

	public String getOperName() {
		return shoppingDetailDto.getOperName();
	}

	public void setOperName(String operName) {
		shoppingDetailDto.setOperName(operName);
	}

	public String getShoppingType() {
		return shoppingDetailDto.getShoppingType();
	}

	public void setShoppingType(String shoppingType) {
		shoppingDetailDto.setShoppingType(shoppingType);
	}

	public String getContacterName() {
		return shoppingDetailDto.getContacterName();
	}

	public void setContacterName(String contacterName) {
		shoppingDetailDto.setContacterName(contacterName);
	}

	public String getContacterMobile() {
		return shoppingDetailDto.getContacterMobile();
	}

	public void setContacterMobile(String contacterMobile) {
		shoppingDetailDto.setContacterMobile(contacterMobile);
	}

	public String getContacterEmail() {
		return shoppingDetailDto.getContacterEmail();
	}

	public void setContacterEmail(String contacterEmail) {
		shoppingDetailDto.setContacterEmail(contacterEmail);
	}

	public String getSearchCondition() {
		return shoppingDetailDto.getSearchCondition();
	}

	public void setSearchCondition(String searchCondition) {
		shoppingDetailDto.setSearchCondition(searchCondition);
	}

	public String getArrivalCityName() {
		return shoppingDetailDto.getArrivalCityName();
	}

	public void setArrivalCityName(String arrivalCityName) {
		shoppingDetailDto.setArrivalCityName(arrivalCityName);
	}

	public String getDepartureCityName() {
		return shoppingDetailDto.getDepartureCityName();
	}

	public void setDepartureCityName(String departureCityName) {
		shoppingDetailDto.setDepartureCityName(departureCityName);
	}

	public String getCreateTimeStr() {
		if(shoppingDetailDto.getCreateTime() != null)
			return DateUtils.formatDate(shoppingDetailDto.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}
	public String getHotelCityName() {
		return shoppingDetailDto.getHotelCityName();
	}

	public void setHotelCityName(String hotelCityName) {
		shoppingDetailDto.setHotelCityName(hotelCityName);
	}
	
	public String getChildCount() {
		return shoppingDetailDto.getChildCount();
	}

	public void setChildCount(String childCount) {
		shoppingDetailDto.setChildCount(childCount);
	}
	
	public String getAdultCount() {
		return shoppingDetailDto.getAdultCount();
	}

	public void setAdultCount(String adultCount) {
		shoppingDetailDto.setAdultCount(adultCount);
	}
	
    public FitOrderResultStatus getVstOrderStatus() {
        return shoppingDetailDto.getVstOrderStatus();
    }

    public void setVstOrderStatus(FitOrderResultStatus vstOrderStatus) {
        shoppingDetailDto.setVstOrderStatus(vstOrderStatus);
    }

    public FitOrderResultStatus getDepFliOrderStatus() {
        return shoppingDetailDto.getDepFliOrderStatus();
    }

    public void setDepFliOrderStatus(FitOrderResultStatus depFliOrderStatus) {
        shoppingDetailDto.setDepFliOrderStatus(depFliOrderStatus);
    }

    public FitOrderResultStatus getArvFliOrderStatus() {
        return shoppingDetailDto.getArvFliOrderStatus();
    }

    public void setArvFliOrderStatus(FitOrderResultStatus arvFliOrderStatus) {
        shoppingDetailDto.setArvFliOrderStatus(arvFliOrderStatus);
    }

    public String getVstOrderMsg() {
        return shoppingDetailDto.getVstOrderMsg();
    }

    public void setVstOrderMsg(String vstOrderMsg) {
        shoppingDetailDto.setVstOrderMsg(vstOrderMsg);
    }

    public String getDepFliOrderMsg() {
        return shoppingDetailDto.getDepFliOrderMsg();
    }

    public void setDepFliOrderMsg(String depFliOrderMsg) {
        shoppingDetailDto.setDepFliOrderMsg(depFliOrderMsg);
    }

    public String getArvFliOrderMsg() {
        return shoppingDetailDto.getArvFliOrderMsg();
    }

    public void setArvFliOrderMsg(String arvFliOrderMsg) {
        shoppingDetailDto.setArvFliOrderMsg(arvFliOrderMsg);
    }

	public String getPassengerType(){
		StringBuffer passger = new StringBuffer();
		if(StringUtils.isNotBlank(this.getAdultCount()) || StringUtils.isNotBlank(this.getChildCount()))
    	{   if(!"0".equals(this.getAdultCount())){
    		passger.append(this.getAdultCount()+PassengerType.ADULT.getCnName());}
    	   if(!"0".equals(this.getChildCount())){
    		   passger.append(this.getChildCount()+PassengerType.CHILDREN.getCnName());   
    	   }
    	   
    	}
		return  passger.toString();
	}
}
