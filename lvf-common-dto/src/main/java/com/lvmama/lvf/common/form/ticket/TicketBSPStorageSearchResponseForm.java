package com.lvmama.lvf.common.form.ticket;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.BSPInventoryStatus;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPStorageDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 行程单查询 ResponseForm
 * @author zzs
 *
 */
public class TicketBSPStorageSearchResponseForm implements Serializable,Form {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2616628041614995551L;

	private FlightTicketBSPStorageDto ticketBSPStorageDto;
	
	private String invetoryStatusName;//入库状态
	
	private Long invetoryNumber;//入库数量


	public TicketBSPStorageSearchResponseForm() {
		super();
	}

	public TicketBSPStorageSearchResponseForm(FlightTicketBSPStorageDto ticketBSPStorageDto) {
		super();
		this.ticketBSPStorageDto = ticketBSPStorageDto;
		if(null!=this.getInvetoryStatus()){
			this.setInvetoryStatusName(this.getInvetoryStatus().getCnName());
		}if(null!=this.getBspStartNo() && null!=this.getBspEndNo()){
			Long num = Long.parseLong(this.getBspEndNo())-Long.parseLong(this.getBspStartNo())+1;
			this.setInvetoryNumber(num);
		}if(null!=this.getOfficeNo()){
			this.setOfficeNo(this.getOfficeNo());
		}
	}
    
	public PersistenceType getPtype() {
		return ticketBSPStorageDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		ticketBSPStorageDto.setPtype(ptype);	
	}

	public String getSequence() {
		return ticketBSPStorageDto.getSequence();
	}

	public Long getId() {
		return ticketBSPStorageDto.getId();
	}

	public void setId(Long id) {
		ticketBSPStorageDto.setId(id);
	}

	public String getUuid() {
		return ticketBSPStorageDto.getUuid();
	}

	public void setUuid(String uuid) {
		ticketBSPStorageDto.setUuid(uuid);
	}

	public void setCreateTime(Date createTime) {
		ticketBSPStorageDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return ticketBSPStorageDto.getUpdateTime();
	}

	public BSPInventoryStatus getInvetoryStatus() {
		return ticketBSPStorageDto.getInvetoryStatus();
	}

	public void setUpdateTime(Date updateTime) {
		ticketBSPStorageDto.setUpdateTime(updateTime);
	}

	public void setInvetoryStatus(BSPInventoryStatus invetoryStatus) {
		ticketBSPStorageDto.setInvetoryStatus(invetoryStatus);
	}

	public List<String> getOfficeNos() {
		return ticketBSPStorageDto.getOfficeNos();
	}

	public void setOfficeNos(List<String> officeNos) {
		ticketBSPStorageDto.setOfficeNos(officeNos);
	}

	public String getOfficeNo() {
		return ticketBSPStorageDto.getOfficeNo();
	}

	public void setOfficeNo(String officeNo) {
		ticketBSPStorageDto.setOfficeNo(officeNo);
	}

	public String getBspStartNo() {
		return ticketBSPStorageDto.getBspStartNo();
	}

	public void setBspStartNo(String bspStartNo) {
		ticketBSPStorageDto.setBspStartNo(bspStartNo);
	}

	public String getBspEndNo() {
		return ticketBSPStorageDto.getBspEndNo();
	}

	public void setBspEndNo(String bspEndNo) {
		ticketBSPStorageDto.setBspEndNo(bspEndNo);
	}

	public String getBspRemark() {
		return ticketBSPStorageDto.getBspRemark();
	}

	public void setBspRemark(String bspRemark) {
		ticketBSPStorageDto.setBspRemark(bspRemark);
	}
    
	public FlightTicketBSPStorageDto getTicketBSPStorageDto() {
		return ticketBSPStorageDto;
	}

	public void setTicketBSPStorageDto(FlightTicketBSPStorageDto ticketBSPStorageDto) {
		this.ticketBSPStorageDto = ticketBSPStorageDto;
	}

	public String getInvetoryStatusName() {
		return invetoryStatusName;
	}

	public void setInvetoryStatusName(String invetoryStatusName) {
		this.invetoryStatusName = invetoryStatusName;
	}
	
	public String getOperName() {
		return ticketBSPStorageDto.getOperName();
	}

	public void setOperName(String operName) {
		ticketBSPStorageDto.setOperName(operName);
	}

	
	public Long getInvetoryNumber() {
		return invetoryNumber;
	}

	public void setInvetoryNumber(Long invetoryNumber) {
		this.invetoryNumber = invetoryNumber;
	}
	
	public String getCreateTime() {
		return DateUtils.formatCnHmDate(ticketBSPStorageDto.getCreateTime());
	}
	
}
