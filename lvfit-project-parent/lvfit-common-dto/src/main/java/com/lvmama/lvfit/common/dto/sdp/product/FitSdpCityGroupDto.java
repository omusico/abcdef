package com.lvmama.lvfit.common.dto.sdp.product;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.JudgeType;

/**
 * 自主打包产品城市组信息
 * @author leizhengwei
 *
 */
public class FitSdpCityGroupDto extends Entity implements Dto{

	private static final long serialVersionUID = -1058970218307929353L;

	/**自主打包城市Id*/
	private Long productId;
	
	/**出发城市区域Id*/
	private Long departureCityDistrictId;
	
	/**出发城市区短拼音*/
	private String departureCityShortPinYin;
	
	/**出发城市code*/
	private String departureCityCode;
	
	/**出发城市名称*/
	private String departureCityName;
	
	/**到达城市区域Id*/
	private Long arrivalCityDistrictId;
	
	/**出发城市区短拼音*/
	private String arrivalCityShortPinYin;
	
	/**到达城市code*/
	private String arrivalCityCode;
	
	/**到达城市名称*/
	private String arrivalCityName;
	
	/**是否为选中出发地*/
	private JudgeType isSelectedDeparture;

	public FitSdpCityGroupDto() {
		super();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getDepartureCityDistrictId() {
		return departureCityDistrictId;
	}

	public void setDepartureCityDistrictId(Long departureCityDistrictId) {
		this.departureCityDistrictId = departureCityDistrictId;
	}

	public String getDepartureCityShortPinYin() {
		return departureCityShortPinYin;
	}

	public void setDepartureCityShortPinYin(String departureCityShortPinYin) {
		this.departureCityShortPinYin = departureCityShortPinYin;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getDepartureCityName() {
		return departureCityName;
	}

	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
	}

	public Long getArrivalCityDistrictId() {
		return arrivalCityDistrictId;
	}

	public void setArrivalCityDistrictId(Long arrivalCityDistrictId) {
		this.arrivalCityDistrictId = arrivalCityDistrictId;
	}

	public String getArrivalCityShortPinYin() {
		return arrivalCityShortPinYin;
	}

	public void setArrivalCityShortPinYin(String arrivalCityShortPinYin) {
		this.arrivalCityShortPinYin = arrivalCityShortPinYin;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}

	public String getArrivalCityName() {
		return arrivalCityName;
	}

	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}

	public JudgeType getIsSelectedDeparture() {
		return isSelectedDeparture;
	}

	public void setIsSelectedDeparture(JudgeType isSelectedDeparture) {
		this.isSelectedDeparture = isSelectedDeparture;
	}
	
}
