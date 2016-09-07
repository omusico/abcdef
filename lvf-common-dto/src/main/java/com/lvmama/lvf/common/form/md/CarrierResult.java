package com.lvmama.lvf.common.form.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.CarrierType;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.form.Form;

public class CarrierResult implements Serializable,Form{

	private static final long serialVersionUID = -4662241937265030883L;
	
	private Carrier carrier=new Carrier();
	
	private String iconImage;
	
	public CarrierResult(){
		
	}
	
	public CarrierResult(Carrier carrier) {
		super();
		this.carrier = carrier;
	}
	
	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	
	public Long getId() {
		return carrier.getId();
	}

	public void setId(Long id) {
		this.carrier.setId(id);
	}
	
	public String getName() {
		return carrier.getName();
	}
	
	public void setName(String name) {
		this.carrier.setName(name);
	}
	
	public String getCode() {
		return carrier.getCode();
	}
	
	public void setCode(String code) {
		this.carrier.setCode(code);
	}
	
	public String getFullName() {
		return carrier.getFullName();
	}
	
	public void setFullName(String fullName) {
		this.carrier.setFullName(fullName);
	}
	
	public CarrierType getType() {
		return carrier.getType();
	}

	public void setType(CarrierType type) {
		this.carrier.setType(type);
	}
	
	public String getRemark() {
		return carrier.getRemark();
	}
	
	public void setRemark(String remark) {
		this.carrier.setRemark(remark);
	}
	
	public String getWebsite() {
		return carrier.getWebsite();
	}
	
	public void setWebsite(String website) {
		this.carrier.setWebsite(website);
	}
	
	public String getHotline() {
		return carrier.getHotline();
	}
	
	public void setHotline(String hotline) {
		this.carrier.setHotline(hotline);
	}
	
	public String getIconUrl() {
		return carrier.getIconUrl();
	}
	
	public void setIconUrl(String iconUrl) {
		this.carrier.setIconUrl(iconUrl);
	}

	public String getIconImage() {
		if(carrier.getIconUrl() != null)
		{
			return "<img height=80 width=40 src='"+carrier.getIconUrl()+"' />";
		}	
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

}
