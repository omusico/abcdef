package com.lvmama.lvf.common.dto.request;
import com.lvmama.lvf.common.dto.enums.BSPInventoryStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 行程单入库Request
 * 
 * @author zzs
 * 
 */
public class FlightTicketBSPStoreRequest implements Serializable {

	private static final long serialVersionUID = -1919953764974135444L;
	/** 请求修改入库id */
	private Long id;
	/** 号段开始 */
	private String bspStartNo;
	/** 号段结束 */
	private String bspEndNo;
	/** 号段关联officeno */
	private List<String> officeNos = new ArrayList<String>();
	/** 号段关联officeno */
	private String officeNo;
	/** 操作人 */
	private String operName;
	/** 入库状态 */
	private BSPInventoryStatus invetoryStatus;
	/** 入库备注 */
	public String bspRemark;

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

	public List<String> getOfficeNos() {
		return officeNos;
	}

	public void setOfficeNos(List<String> officeNos) {
		this.officeNos = officeNos;
	}

	public BSPInventoryStatus getInvetoryStatus() {
		return invetoryStatus;
	}

	public void setInvetoryStatus(BSPInventoryStatus invetoryStatus) {
		this.invetoryStatus = invetoryStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBspRemark() {
		return bspRemark;
	}

	public void setBspRemark(String bspRemark) {
		this.bspRemark = bspRemark;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

}
