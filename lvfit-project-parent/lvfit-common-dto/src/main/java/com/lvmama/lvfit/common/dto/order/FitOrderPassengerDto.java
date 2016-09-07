package com.lvmama.lvfit.common.dto.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.Gender;
import com.lvmama.lvfit.common.dto.enums.IDCardType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingPassengerDto;

public class FitOrderPassengerDto extends Entity {

    private static final long serialVersionUID = -7890973190869682174L;

    /** 主订单主键 */
    private Long orderMainId;

    /**  联系人编号 */
    private String passengerId;
    
	/** 乘客姓名 */
    private String passengerName;

    /** 乘客类型 */
    private PassengerType passengerType;

    /** 乘客性别 */
    private Gender gender;

    /** 证件类型 */
    private IDCardType passengerIDCardType;

    /** 证件号码 */
    private String passengerIDCardNo;

    /** 生日 */
    private String passengerBirthday;

    /** 手机号码 */
    private String mobile;

    /** 航意险 */
    private List<FlightInsuranceDto> flightInsuranceDtos;


    public Long getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(Long orderMainId) {
        this.orderMainId = orderMainId;
    }
    
    public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public IDCardType getPassengerIDCardType() {
        return passengerIDCardType;
    }

    public void setPassengerIDCardType(IDCardType passengerIDCardType) {
        this.passengerIDCardType = passengerIDCardType;
    }

    public String getPassengerIDCardNo() {
        return passengerIDCardNo;
    }

    public void setPassengerIDCardNo(String passengerIDCardNo) {
        this.passengerIDCardNo = passengerIDCardNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassengerBirthday() {
        return passengerBirthday;
    }

    public void setPassengerBirthday(String passengerBirthday) {
        this.passengerBirthday = passengerBirthday;
    }
    
    public static List<FitOrderPassengerDto> convertPassengerDtos(List<ShoppingPassengerDto> passengerDtos){
    	List<FitOrderPassengerDto> resultList = new ArrayList<FitOrderPassengerDto>();
    	for(ShoppingPassengerDto dto:passengerDtos){
    		FitOrderPassengerDto fitOrderPassengerDto = new FitOrderPassengerDto();
    		fitOrderPassengerDto.setPassengerName(dto.getPassengerName());
    		fitOrderPassengerDto.setPassengerBirthday(dto.getPassengerBirthday());
    		fitOrderPassengerDto.setMobile(dto.getTelephone());
    		if("ID".equals(dto.getIdCardType()))
    			fitOrderPassengerDto.setPassengerIDCardType(IDCardType.ID);
    		if("PASSPORT".equals(dto.getIdCardType()))
    			fitOrderPassengerDto.setPassengerIDCardType(IDCardType.PASSPORT);
    		if("ADULT".equals(dto.getPassengerType()))		    		
    		    fitOrderPassengerDto.setPassengerType(PassengerType.ADULT);
			if ("CHILDREN".equals(dto.getPassengerType())) {
				fitOrderPassengerDto.setPassengerType(PassengerType.CHILDREN);
			}
    		    fitOrderPassengerDto.setPassengerIDCardNo(dto.getIdCardNo());
    		    resultList.add(fitOrderPassengerDto);    
    	}
    	return resultList;
    }
    
    public String passengerKey(FlightTripType flightTripType){
		  StringBuffer passengerStr = new StringBuffer();
		  passengerStr.append(this.getPassengerName());
		  passengerStr.append(this.getPassengerType().name());
		  passengerStr.append(this.getPassengerIDCardType().name());
		  passengerStr.append(this.getPassengerIDCardNo());
		  passengerStr.append(flightTripType.name());
          return passengerStr.toString();
    }

    public List<FlightInsuranceDto> getFlightInsuranceDto() {
        return flightInsuranceDtos;
    }

    public void setFlightInsuranceDto(List<FlightInsuranceDto> flightInsuranceDto) {
        this.flightInsuranceDtos = flightInsuranceDto;
    }
}
