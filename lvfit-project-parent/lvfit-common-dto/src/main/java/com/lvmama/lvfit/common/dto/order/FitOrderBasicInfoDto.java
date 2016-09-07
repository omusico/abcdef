package com.lvmama.lvfit.common.dto.order;

import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

public class FitOrderBasicInfoDto extends Entity {

	
	private static final long serialVersionUID = 1725588482348630789L;

	/**机酒主单Id */
	private Long fitOrderMainId;
	
	/**出发城市code */
	private String depCityCode;
	
	/**到达城市code */
	private String arriCityCode;

	/**入住城市Code */
	private String checkInCityCode;
	
	/**出发时间 */
	private Date toTime;

	/**到达时间 */
	private Date returnTime;
	
	/**入住时间 */
	private Date checkInTime;
	
	/**离店时间 */
	private Date checkOutTime;
	
	/** 出游日期 */
	private String visitTime;
   	
	/** 成人数量 */
	private int adultQuantity;

	/** 儿童数量 */
	private int childQuantity;

	
	public Long getFitOrderMainId() {
		return fitOrderMainId;
	}

	public void setFitOrderMainId(Long fitOrderMainId) {
		this.fitOrderMainId = fitOrderMainId;
	}

	public String getDepCityCode() {
		return depCityCode;
	}

	public void setDepCityCode(String depCityCode) {
		this.depCityCode = depCityCode;
	}

	public String getArriCityCode() {
		return arriCityCode;
	}

	public void setArriCityCode(String arriCityCode) {
		this.arriCityCode = arriCityCode;
	}

	public String getCheckInCityCode() {
		return checkInCityCode;
	}

	public void setCheckInCityCode(String checkInCityCode) {
		this.checkInCityCode = checkInCityCode;
	}

	public Date getToTime() {
		return toTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Date getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
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
	

}
