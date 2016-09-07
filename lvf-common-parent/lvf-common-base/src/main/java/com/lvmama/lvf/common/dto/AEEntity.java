package com.lvmama.lvf.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.EffectDates;

public class AEEntity extends Entity implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -2136412211962367582L;
	
	/** 产品上架下架信息 */
	private ActiveStatus activeStatus;
	
	/** 有效时间信息 */
	private EffectDates effectDates;

	public ActiveStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public EffectDates getEffectDates() {
		return effectDates;
	}

	public void setEffectDates(EffectDates effectDates) {
		this.effectDates = effectDates;
	}

	@XmlTransient
	@JsonIgnore
	public Boolean getActive() {
		return activeStatus.getActive();
	}

	@XmlTransient
	@JsonIgnore
	public Boolean getEffect() {
		return effectDates.getEffect();
	}

	public Boolean getEffect(Date date) {
		return effectDates.getEffect(date);
	}

	@XmlTransient
	@JsonIgnore
	public Boolean isActiveAndEffcet(){
		return activeStatus.getActive()&&effectDates.getEffect();
	}

	public boolean isActiveAndEffcet(Date date){
		return activeStatus.getActive()&&effectDates.getEffect(date);
	}
	
}
