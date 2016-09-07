package com.lvmama.lvf.common.dto;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.status.BatchFlag;

/**
 * @author lven
 *
 */
public class VSTEntity extends AEEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1404242274192013159L;
	
	/** 批量同步标识 */
	private BatchFlag batchFlag;

	public BatchFlag getBatchFlag() {
		return batchFlag;
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		this.batchFlag = batchFlag;
	}
}
