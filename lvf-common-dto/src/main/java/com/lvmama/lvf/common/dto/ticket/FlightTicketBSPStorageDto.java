package com.lvmama.lvf.common.dto.ticket;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.BSPInventoryStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPStoreRequest;
/**
 * 行程单入库DTO
 *
 */
public class FlightTicketBSPStorageDto extends Entity {
	
	private static final long serialVersionUID = -5965081688738377661L;
	private static final String ENUM_TYPE_SPLITER = ",";
	
    /** 号段开始 */
    private String bspStartNo;
    /** 号段结束 */
    private String bspEndNo;
    /** 号段关联officeno */
    private List<String> officeNos=new ArrayList<String>();
    /** 号段关联officeno */
    private String officeNo;
    /** 入库状态 */
    private BSPInventoryStatus invetoryStatus;
    /** 操作人 */
    private String operName;
    /** 入库备注 */
	public String bspRemark;
    
	public BSPInventoryStatus getInvetoryStatus() {
		return invetoryStatus;
	}
	public void setInvetoryStatus(BSPInventoryStatus invetoryStatus) {
		this.invetoryStatus = invetoryStatus;
	}
	public List<String> getOfficeNos() {
		return officeNos;
	}
	public void setOfficeNos(List<String> officeNos) {
		this.officeNos = officeNos;
	}
	public String getOfficeNo() {
		return officeNo;
	}
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}
	
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
	private <T> String buildEnumString(List<T> types) {
		StringBuilder ticketType = new StringBuilder("");
		if (types != null && types.size() > 0) {
			for (T type : types) {
				ticketType.append(type).append(ENUM_TYPE_SPLITER);
			}
		}
		return ticketType.substring(0, ticketType.length());
	}
	
	
	public String getBspRemark() {
		return bspRemark;
	}
	public void setBspRemark(String bspRemark) {
		this.bspRemark = bspRemark;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	
	public void copyFromRequest(FlightTicketBSPStoreRequest request) {
		    this.setId(request.getId());
            this.setBspStartNo(request.getBspStartNo());
	    	this.setBspEndNo(request.getBspEndNo());
	    	this.setInvetoryStatus(request.getInvetoryStatus());
	    	if(request.getOfficeNo()!="" && request.getOfficeNo()!=null){
	    		String[] offValue=request.getOfficeNo().split(",");
		    	List<String> officeNoList=new ArrayList<String>();
		    	for (int i = 0; i < offValue.length; i++) {
		    		officeNoList.add(offValue[i]);
				}
		    	this.setOfficeNos(officeNoList);
	    	}
	    	this.setOfficeNo(request.getOfficeNo());
	    	this.setOperName(request.getOperName());
	    	this.setBspRemark(request.getBspRemark());
	    }
	  
}
