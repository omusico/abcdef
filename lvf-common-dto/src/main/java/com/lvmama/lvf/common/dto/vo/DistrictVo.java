package com.lvmama.lvf.common.dto.vo;

import java.io.Serializable;

/**
 * 行政区域
 */
public class DistrictVo implements Serializable {


	private static final long serialVersionUID = 4099259246332014910L;

	/**
	 * 行政区域ID
	 */
	private Long districtId;
	
	/**
	 * 父行政区域ID
	 */
	private Long parentId;
	
	/**
	 * 行政区域级别
	 */
	private String districtType;

	/**
	 * 行政区域名称
	 */
	private String districtName;

	/**
	 * 行政区域全拼
	 */
	private String pinyin;
	
	/**
	 * 是否有效
	 */
	private String cancelFlag;

	/**
	 * 冗余父行政区 
	 */
	private DistrictVo vstDistrictVo;
	
	/**
	 * 行政区域简拼
	 */
	private String shortPinyin;

    /**
     * 是否境外-Y境外
     */
	private String foreighFlag;

	/**
	 * 区域枚举类型 
	 * @author xiexun
	 *
	 */
	public static enum DISTRICT_TYPE {

		CONTINENT("洲"), 
		COUNTRY("国家"), 
		PROVINCE("省"), 
		PROVINCE_DCG("直辖市"), 
		PROVINCE_SA("特别行政区"), 
		PROVINCE_AN("自治区"), 
		CITY("市"), 
		COUNTY("区/县"),
		TOWN("乡镇/街道");

		private String cnName;

		public static String getCnName(String code) {
			for (DISTRICT_TYPE item : DISTRICT_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		DISTRICT_TYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public String getDistrictTypeCnName() {
		return DISTRICT_TYPE.getCnName(this.districtType);
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDistrictType() {
		return districtType;
	}

	public void setDistrictType(String districtType) {
		this.districtType = districtType;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public DistrictVo getVstDistrictVo() {
		return vstDistrictVo;
	}

	public void setVstDistrictVo(DistrictVo vstDistrictVo) {
		this.vstDistrictVo = vstDistrictVo;
	}

	public String getShortPinyin() {
		return shortPinyin;
	}

	public void setShortPinyin(String shortPinyin) {
		this.shortPinyin = shortPinyin;
	}

	public String getForeighFlag() {
		return foreighFlag;
	}

	public void setForeighFlag(String foreighFlag) {
		this.foreighFlag = foreighFlag;
	}
	
	
}
