package com.lvmama.lvfit.common.dto.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.StringUtils;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;

public class FitOrderQueryPeopleDto  implements Serializable {
	private static final long serialVersionUID = -4842341566960811989L;
    /**  联系人姓名 */
    private String contactName;
    /**  联系人手机号 */
    private String contactCellphone;
    /**  联系人邮箱 */
    private String contactEmail;
    /**  联系人固话 */
    private String contactTelphone;
    /**  游玩人姓名 */
    private String playerName;
    /**  游玩人姓名 */
    private String playerIDNumber;
    /** 游玩人入住 开始时间 */
    private String playerLiveStartTime;
    /** 游玩人入住 结束时间 */
    private String playerLiveEndTime;
    /** 游玩人 去程 开始时间 */
    private String playerFStartTime;
    /** 游玩人 返程 结束时间 */
    private String playerFEndTime;
    
    private String departCity;
    private String arriveCity;
    private String checkInCity;
    
    /** 旅游产品相关信息*/
    private String productId;
    private String productName;
    /**产品品类*/
    private String categoryId;
    
	public final String getContactName() {
		return contactName;
	}
	public final void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public final String getContactCellphone() {
		return contactCellphone;
	}
	public final void setContactCellphone(String contactCellphone) {
		this.contactCellphone = contactCellphone;
	}
	public final String getContactEmail() {
		return contactEmail;
	}
	public final void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public final String getContactTelphone() {
		return contactTelphone;
	}
	public final void setContactTelphone(String contactTelphone) {
		this.contactTelphone = contactTelphone;
	}
	public final String getPlayerName() {
		return playerName;
	}
	public final void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public final String getPlayerIDNumber() {
		return playerIDNumber;
	}
	public final void setPlayerIDNumber(String playerIDNumber) {
		this.playerIDNumber = playerIDNumber;
	}
	public final String getPlayerLiveStartTime() {
		return playerLiveStartTime;
	}
	public final String getPlayerLiveEndTime() {
		return playerLiveEndTime;
	}
	public final void setPlayerLiveEndTime(String playerLiveEndTime) {
		this.playerLiveEndTime = playerLiveEndTime;
	}
	public final void setPlayerLiveStartTime(String playerLiveStartTime) {
		this.playerLiveStartTime = playerLiveStartTime;
	}
	public final String getPlayerFStartTime() {
		return playerFStartTime;
	}
	public final void setPlayerFStartTime(String playerFStartTime) {
		this.playerFStartTime = playerFStartTime;
	}
	public final String getPlayerFEndTime() {
		return playerFEndTime;
	}
	public final void setPlayerFEndTime(String playerFEndTime) {
		this.playerFEndTime = playerFEndTime;
	}
	public final String getDepartCity() {
		return departCity;
	}
	public final void setDepartCity(String departCity) {
		if(StringUtil.isNotEmptyString(departCity) && !Pattern.matches("[A-Z]{3}",departCity)){
			this.departCity = VSTDistrictCityEnum.getCodeByCnName(departCity);;
		}else{
			this.departCity = departCity;
		}
	}
	public final String getArriveCity() {
		return arriveCity;
	}
	public final void setArriveCity(String arriveCity) {
		if(StringUtil.isNotEmptyString(arriveCity) && !Pattern.matches("[A-Z]{3}",arriveCity)){
			this.arriveCity = VSTDistrictCityEnum.getCodeByCnName(arriveCity);;
		}else{
			this.arriveCity = arriveCity;
		}
	}
	public final String getCheckInCity() {
		return checkInCity;
	}
	public final void setCheckInCity(String checkInCity) {
		if(StringUtil.isNotEmptyString(checkInCity) && !Pattern.matches("[A-Z]{3}",checkInCity)){
			this.checkInCity = VSTDistrictCityEnum.getCodeByCnName(checkInCity);;
		}else{
			this.checkInCity = checkInCity;
		}
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
}
