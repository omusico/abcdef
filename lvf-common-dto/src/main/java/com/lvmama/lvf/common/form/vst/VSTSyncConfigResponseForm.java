package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.vst.VSTSyncConfigDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTSyncConfigResponseForm implements Form, Serializable {

	private static final long serialVersionUID = -5637566488151642461L;
	
	private VSTSyncConfigDto vstSyncConfig;

	public VSTSyncConfigDto getVstSyncConfig() {
		return vstSyncConfig;
	}

	public void setVstSyncConfig(VSTSyncConfigDto vstSyncConfig) {
		this.vstSyncConfig = vstSyncConfig;
	}
	
	public Integer getSyncFlag() {
		return vstSyncConfig.getSyncFlag();
	}

	public void setSyncFlag(Integer syncFlag) {
		vstSyncConfig.setSyncFlag(syncFlag);
	}

	public Date getLastStartTime() {
		return vstSyncConfig.getLastStartTime();
	}

	public void setLastStartTime(Date lastStartTime) {
		vstSyncConfig.setLastStartTime(lastStartTime);
	}

	public Date getLastEndTime() {
		return vstSyncConfig.getLastEndTime();
	}

	public void setLastEndTime(Date lastEndTime) {
		vstSyncConfig.setLastEndTime(lastEndTime);
	}
	
	public String getLastStartTimeStr(){
		if(this.getLastStartTime() != null)
			return DateUtils.formatDate(this.getLastStartTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}
	
	public String getLastEndTimeStr(){
		if(this.getLastEndTime() != null)
			return DateUtils.formatDate(this.getLastEndTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}

}
