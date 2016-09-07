package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;

/**
 * 行程单统计
 */
public class FlightTicketBSPStatisticsDto implements Serializable, Dto {

	private static final long serialVersionUID = -8779121019255656492L;
	/** 总入库数量 */
	private Integer totalStorageCount;
	/** 总出库数量 */
	private Integer totalOutStorageCount;
	/** 总未使用数量 */
	private Integer totalUsedCount;
	/** 总已打印数量 */
	private Integer totalPrintCount;
	/** 总已作废数量 */
	private Integer totalInvalidCount;
	/** 总已回收数量 */
	private Integer totalRecycleCount;
    /** 行程单统计明细 */
    private List<FlightTicketBSPStatisticsDetailDto> bspStatistDetails = new ArrayList<FlightTicketBSPStatisticsDetailDto>();

    public Integer getTotalStorageCount() {
        return totalStorageCount;
    }

    public void setTotalStorageCount(Integer totalStorageCount) {
        this.totalStorageCount = totalStorageCount;
    }

    public Integer getTotalOutStorageCount() {
        return totalOutStorageCount;
    }

    public void setTotalOutStorageCount(Integer totalOutStorageCount) {
        this.totalOutStorageCount = totalOutStorageCount;
    }

    public Integer getTotalUsedCount() {
        return totalUsedCount;
    }

    public void setTotalUsedCount(Integer totalUsedCount) {
        this.totalUsedCount = totalUsedCount;
    }

    public Integer getTotalPrintCount() {
        return totalPrintCount;
    }

    public void setTotalPrintCount(Integer totalPrintCount) {
        this.totalPrintCount = totalPrintCount;
    }

    public Integer getTotalInvalidCount() {
        return totalInvalidCount;
    }

    public void setTotalInvalidCount(Integer totalInvalidCount) {
        this.totalInvalidCount = totalInvalidCount;
    }

    public Integer getTotalRecycleCount() {
        return totalRecycleCount;
    }

    public void setTotalRecycleCount(Integer totalRecycleCount) {
        this.totalRecycleCount = totalRecycleCount;
    }


    @JsonIgnore
    @Override
    public Long getId() {
        return null;
    }

	public List<FlightTicketBSPStatisticsDetailDto> getBspStatistDetails() {
		return bspStatistDetails;
	}

	public void setBspStatistDetails(List<FlightTicketBSPStatisticsDetailDto> bspStatistDetails) {
		this.bspStatistDetails = bspStatistDetails;
	}
}
