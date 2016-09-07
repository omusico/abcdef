package com.lvmama.lvf.common.form.ticket;

import com.lvmama.lvf.common.dto.enums.BSPInventoryStatus;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPStoreRequest;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPStorageDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;
/**
 * 行程单入库返回Response
 * @author zzs
 *
 */
public class TicketBSPStoreResponseForm implements Form {
	
	private FlightTicketBSPStorageDto ticketBSPStorageDto;

    public void setCreateTime(Date createTime) {
		ticketBSPStorageDto.setCreateTime(createTime);
	}

	public String getOperName() {
		return ticketBSPStorageDto.getOperName();
	}

	public void setOperName(String operName) {
		ticketBSPStorageDto.setOperName(operName);
	}
	
    public String getCreateTime() {
        return DateUtils.formatCnHmDate(ticketBSPStorageDto.getCreateTime());
    }

    public List<String> getOfficeNos() {
        return ticketBSPStorageDto.getOfficeNos();
    }

    public String getBspEndNo() {
        return ticketBSPStorageDto.getBspEndNo();
    }

    public BSPInventoryStatus getInvetoryStatus() {
        return ticketBSPStorageDto.getInvetoryStatus();
    }

    public void setInvetoryStatus(BSPInventoryStatus invetoryStatus) {
        ticketBSPStorageDto.setInvetoryStatus(invetoryStatus);
    }

    public void setBspEndNo(String bspEndNo) {
        ticketBSPStorageDto.setBspEndNo(bspEndNo);
    }

    public String getUuid() {
        return ticketBSPStorageDto.getUuid();
    }

    public void setOfficeNo(String officeNo) {
        ticketBSPStorageDto.setOfficeNo(officeNo);
    }

    public void setId(Long id) {
        ticketBSPStorageDto.setId(id);
    }

    public void setUuid(String uuid) {
        ticketBSPStorageDto.setUuid(uuid);
    }

    public void setBspStartNo(String bspStartNo) {
        ticketBSPStorageDto.setBspStartNo(bspStartNo);
    }

    public void setUpdateTime(Date updateTime) {
        ticketBSPStorageDto.setUpdateTime(updateTime);
    }

    public Long getId() {
        return ticketBSPStorageDto.getId();
    }

    @JsonIgnore
    public String getSequence() {
        return ticketBSPStorageDto.getSequence();
    }

    public Date getUpdateTime() {
        return ticketBSPStorageDto.getUpdateTime();
    }

    public String getOfficeNo() {
        return ticketBSPStorageDto.getOfficeNo();
    }

    public String getBspStartNo() {
        return ticketBSPStorageDto.getBspStartNo();
    }

    public void copyFromRequest(FlightTicketBSPStoreRequest request) {
        ticketBSPStorageDto.copyFromRequest(request);
    }

    public void setOfficeNos(List<String> officeNos) {
        ticketBSPStorageDto.setOfficeNos(officeNos);
    }

    public FlightTicketBSPStorageDto getTicketBSPStorageDto() {
        return ticketBSPStorageDto;
    }

    public void setTicketBSPStorageDto(FlightTicketBSPStorageDto ticketBSPStorageDto) {
        this.ticketBSPStorageDto = ticketBSPStorageDto;
    }
    
    public String getBspRemark() {
		return ticketBSPStorageDto.getBspRemark();
	}
	public void setBspRemark(String bspRemark) {
		ticketBSPStorageDto.setBspRemark(bspRemark);
	}
	
	
}
