package com.lvmama.lvf.common.dto.status;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

public class EffectDates implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 8694337804527744810L;
	
	/** 有效日期 */
	private Date effectDate;
	
	/** 到期日期 */
	private Date expireDate;

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@JsonIgnore
	public Boolean getEffect() {
		return getEffect(new Date());
	}

	@JsonIgnore
	public Boolean getEffect(Date date) {

		if (null == date) {
			return false;
		}
		if (null == effectDate && null == expireDate) {
			return true;
		}
		if (null != effectDate && null == expireDate) {
			return date.after(effectDate);
		}
		if (null == effectDate && null != expireDate) {
			return date.before(expireDate);
		}
		return date.after(effectDate) && date.before(expireDate);
	}

}
