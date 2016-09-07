package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.ConfirmType;
import com.lvmama.lvf.common.dto.enums.Gender;

/**
 * 订单联系人信息
 * @author majun
 * @date   2015-1-13
 */
@XmlRootElement
public class FlightOrderContacterDto implements Serializable ,Dto
{
	private static final long serialVersionUID = 896992179080974511L;
	
	/** 主订单主键 */
	private Long orderMainId;
	
	/** 联系人姓名 */
	private String name;
	
	/** 手机号码 */
	private String cellphone;
	
	/** 电话号码 */
	private String telphone;
	
	/** 邮箱 */
	private String email;
	
	/** 确认类型 */
	private ConfirmType confirmType;
	
	/** 紧急联系人姓名 */
	private String emergencyContactName;
	
	/** 紧急联系人手机号码 */
	private String emergencyCellphone;
	
	/** 紧急联系人电话号码 */
	private String emergencyTelphone;
	
	/** 紧急联系人邮箱 */
	private String emergencyEmail;
	
	/** 性别 */
	private Gender gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ConfirmType getConfirmType() {
		return confirmType;
	}

	public void setConfirmType(ConfirmType confirmType) {
		this.confirmType = confirmType;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyCellphone() {
		return emergencyCellphone;
	}

	public void setEmergencyCellphone(String emergencyCellphone) {
		this.emergencyCellphone = emergencyCellphone;
	}

	public String getEmergencyTelphone() {
		return emergencyTelphone;
	}

	public void setEmergencyTelphone(String emergencyTelphone) {
		this.emergencyTelphone = emergencyTelphone;
	}

	public String getEmergencyEmail() {
		return emergencyEmail;
	}

	public void setEmergencyEmail(String emergencyEmail) {
		this.emergencyEmail = emergencyEmail;
	}

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * 从请求中复制数据
	 * @param requestOrderContacterDto
	 * @param flightOrderContacterDto
	 */
	public void copyFromDto(FlightOrderContacterDto requestOrderContacterDto){
		this.setName(requestOrderContacterDto.getName());
		this.setEmail(requestOrderContacterDto.getEmail());
		this.setCellphone(requestOrderContacterDto.getCellphone());
		this.setTelphone(requestOrderContacterDto.getTelphone());
		this.setConfirmType(requestOrderContacterDto.getConfirmType());
		this.setEmail(requestOrderContacterDto.getEmail());
		this.setEmergencyCellphone(requestOrderContacterDto.getEmergencyCellphone());
		this.setEmergencyContactName(requestOrderContacterDto.getEmergencyContactName());
		this.setEmergencyEmail(requestOrderContacterDto.getEmergencyEmail());
		this.setEmergencyTelphone(requestOrderContacterDto.getEmergencyTelphone());
	}

	@JsonIgnore
	@Override
	public Long getId() {
		return orderMainId;
	}
	
}
