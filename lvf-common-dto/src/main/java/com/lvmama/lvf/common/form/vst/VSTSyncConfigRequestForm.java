package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.vst.VSTSyncConfigDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTSyncConfigRequestForm implements Form, Serializable {

	private static final long serialVersionUID = -281638963939476659L;
	
	private VSTSyncConfigDto vstSyncConfig = new VSTSyncConfigDto();

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
}
