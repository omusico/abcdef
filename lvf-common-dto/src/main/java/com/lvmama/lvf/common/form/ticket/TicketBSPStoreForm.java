package com.lvmama.lvf.common.form.ticket;
import com.lvmama.lvf.common.dto.enums.BSPInventoryStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPStoreRequest;
import com.lvmama.lvf.common.form.Form;

import java.util.List;

/**
 * 行程单入库requestForm
 * 
 * @author zzs
 * 
 */
public class TicketBSPStoreForm implements Form {

	private FlightTicketBSPStoreRequest request = new FlightTicketBSPStoreRequest();

	public String getBspStartNo() {
		return request.getBspStartNo();
	}

	public String getBspEndNo() {
		return request.getBspEndNo();
	}

	public void setOfficeNos(List<String> officeNos) {
		request.setOfficeNos(officeNos);
	}

	public void setInvetoryStatus(BSPInventoryStatus invetoryStatus) {
		request.setInvetoryStatus(invetoryStatus);
	}

	public BSPInventoryStatus getInvetoryStatus() {
		return request.getInvetoryStatus();
	}

	public void setBspStartNo(String bspStartNo) {
		request.setBspStartNo(bspStartNo);
	}

	public void setBspEndNo(String bspEndNo) {
		request.setBspEndNo(bspEndNo);
	}

	public List<String> getOfficeNos() {
		return request.getOfficeNos();
	}

	public FlightTicketBSPStoreRequest getRequest() {
		return request;
	}

	public void setRequest(FlightTicketBSPStoreRequest request) {
		this.request = request;
	}

	public String getBspRemark() {
		return request.getBspRemark();
	}

	public void setBspRemark(String bspRemark) {
		request.setBspRemark(bspRemark);
	}

	public String getOfficeNo() {
		return request.getOfficeNo();
	}

	public void setOfficeNo(String officeNo) {
		request.setOfficeNo(officeNo);
	}

	public Long getId() {
		return request.getId();
	}

	public void setId(Long id) {
		request.setId(id);
	}
	
	public String getOperName() {
		return request.getOperName();
	}

	public void setOperName(String operName) {
		request.setOperName(operName);
	}
    
}
