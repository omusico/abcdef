package com.lvmama.lvf.common.dto.request;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.BSPInventoryStatus;
import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnore;
/**
 * 行程单入库查询Request
 * @author zzs
 *
 */
public class FlightTicketBSPStoreSearchRequest implements Serializable,Dto {

	private static final long serialVersionUID = 701539338154274925L;
	
	 /** 入库单id */
    private String bspId;
    
    /** 号段开始 */
	private String bspStartNo;

	/** 号段结束 */
	private String bspEndNo;

	/** 库存状态 */
	private BSPInventoryStatus invetoryStatus;

	/** 操作者 */
	public String operName;

	/** 开始日期 */
	private String startStorageDate;//入库起时间
	
	/** 结束日期 */
	private String endStorageDate;//入库止时间

	public String getBspStartNo() {
		return bspStartNo;
	}

	public void setBspStartNo(String bspStartNo) {
		this.bspStartNo = bspStartNo;
	}

	public String getBspEndNo() {
		return bspEndNo;
	}

	public void setBspEndNo(String bspEndNo) {
		this.bspEndNo = bspEndNo;
	}
	
	public String getBspId() {
		return bspId;
	}

	public void setBspId(String bspId) {
		this.bspId = bspId;
	}
	
	public BSPInventoryStatus getInvetoryStatus() {
		return invetoryStatus;
	}

	public void setInvetoryStatus(BSPInventoryStatus invetoryStatus) {
		this.invetoryStatus = invetoryStatus;
	}
	
	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}
	
	public String getStartStorageDate() {
		return startStorageDate;
	}
	
	public void setStartStorageDate(String startStorageDate) {
		this.startStorageDate = startStorageDate;
	}

	public String getEndStorageDate() {
		return endStorageDate;
	}

	public void setEndStorageDate(String endStorageDate) {
		this.endStorageDate = endStorageDate;
	}

    @JsonIgnore
    @Override
	public Long getId() {
		return null;
	}

}
