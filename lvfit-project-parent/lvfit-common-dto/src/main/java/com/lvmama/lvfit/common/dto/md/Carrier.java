package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.NameCode;
import com.lvmama.lvfit.common.dto.enums.CarrierType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Carrier extends NameCode implements Serializable {
	
	private static final long serialVersionUID = -1460596408543745514L;
	
	/**航空公司类型*/
	private CarrierType type;
	
	private String remark;
	
	private String fullName;
	
	private String website;
	
	private String hotline;
	
	private String iconUrl;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public CarrierType getType() {
		return type;
	}

	public void setType(CarrierType type) {
		this.type = type;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	
	
}
