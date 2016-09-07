package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 行政区dto
 */
public class Destination implements Serializable {
	private static final long serialVersionUID = 271852755912618237L;
	/**
	 * 目的地ID
	 */
	private Long destId;
	/**
	 * 上级目的地ID
	 */
	private Long parentId;
	/**
	 * 上级目的地(主)
	 */
	private Destination parentDestVo;
	/**
	 * 行政区域ID
	 */
	private Long districtId;
	/**
	 * 行政区域名称
	 */
	private String districtName;
	/**
	 * 目的地类型
	 */
	private String destType;
	/**
	 * 中文名称
	 */
	private String destName;
	/**
	 * 英文名称
	 */
	private String enName;
	/**
	 * 拼音
	 */
	private String pinyin;
	/**
	 * 简拼
	 */
	private String shortPinyin;
	/**
	 * 别名
	 */
	private String destAlias;
	/**
	 * 当地语言名
	 */
	private String localLang;
	/**
	 * 是否有效
	 */
	private String cancelFlag;

	/**
	 * 是否境外-Y境外
	 */
	private String foreighFlag;
	/**
	 * 上级目的地列表(次)(关联表是BIZ_DEST_RELATION)
	 */
	private final List<Destination> parentDestVoList = new ArrayList<Destination>();

	/**
	 * 目的地类型
	 */
	public static enum DEST_TYPE {
		CONTINENT("大洲"), SPAN_COUNTRY("跨国家地区"), COUNTRY("国家"), SPAN_PROVINCE(
				"跨州省地区"), PROVINCE("州省"), SPAN_CITY("跨城市地区"), CITY("城市/直辖市/特区"), SPAN_COUNTY(
				"跨区县地区"), COUNTY("区/县"), SPAN_TOWN("跨乡镇地区"), TOWN("乡镇/街道"), SCENIC(
				"景区"), VIEWSPOT("景点"), RESTAURANT("餐厅"), SHOP("购物地"), HOTEL(
				"酒店");
		// SCENIC_ENTERTAINMENT("景点娱乐点");

		private final String cnName;

		public static String getCnName(String code) {
			for (DEST_TYPE item : DEST_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		DEST_TYPE(String name) {
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

	public Long getDestId() {
		return destId;
	}

	public void setDestId(Long destId) {
		this.destId = destId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Destination getParentDestVo() {
		return parentDestVo;
	}

	public void setParentDestVo(Destination parentDestVo) {
		this.parentDestVo = parentDestVo;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDestType() {
		return destType;
	}

	public void setDestType(String destType) {
		this.destType = destType;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getShortPinyin() {
		return shortPinyin;
	}

	public void setShortPinyin(String shortPinyin) {
		this.shortPinyin = shortPinyin;
	}

	public String getDestAlias() {
		return destAlias;
	}

	public void setDestAlias(String destAlias) {
		this.destAlias = destAlias;
	}

	public String getLocalLang() {
		return localLang;
	}

	public void setLocalLang(String localLang) {
		this.localLang = localLang;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getForeighFlag() {
		return foreighFlag;
	}

	public void setForeighFlag(String foreighFlag) {
		this.foreighFlag = foreighFlag;
	}

	public List<Destination> getParentDestVoList() {
		return parentDestVoList;
	}

}