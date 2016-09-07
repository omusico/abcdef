package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;
import com.lvmama.lvfit.common.dto.enums.SelfType;

public class FlightOfficeDto extends NameCode implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 2624738674497025947L;

	/** 所使用配置PID */
	private String pId;

	/** 执行指令所使用配置组 */
	private String group;

	/** 城市信息 */
	private City city;

	/** officeNO */
	private String officeNo;

	/** officeNO的类型信息 */
	private SelfType selfType;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public SelfType getSelfType() {
		return selfType;
	}

	public void setSelfType(SelfType selfType) {
		this.selfType = selfType;
	}

}
