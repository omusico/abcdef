package com.lvmama.lvf.common.dto.ticket;

import com.lvmama.lvf.common.dto.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 行程单统计明细 入库数量 = 单号首尾做差 +1 出库数量 = 已打印数量 未使用数量 = 入库数量-出库数量 已打印数量= 状态：print
 * 已作废数量= 状态：作废 已回收数量= 状态：已回收
 */
public class FlightTicketBSPStatisticsDetailDto implements Serializable, Dto {
	private static final long serialVersionUID = 6865987884921257096L;
	/** 入库单号 */
	private Long id;
	/** 开始单号 */
	private String bspStartNo;
	/** 结束单号 */
	private String bspEndNo;
	/** 号段关联officeno */
	private List<String> officeNos = new ArrayList<String>();
	/** officeno */
	private String officeNo;
	/** 入库时间 */
	private Date createTime = new Date();
	/** 操作者 */
	public String operName;
	/** 入库数量 */
	private Integer storageCount;
	/** 出库数量 */
	private Integer outStorageCount;
	/** 未使用数量 */
	private Integer unUsedCount;
	/** 已打印数量 */
	private Integer printCount;
	/** 已作废数量 */
	private Integer invalidCount;
	/** 已回收数量 */
	private Integer recycleCount;

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

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public Integer getStorageCount() {
		return storageCount;
	}

	public void setStorageCount(Integer storageCount) {
		this.storageCount = storageCount;
	}

	public Integer getOutStorageCount() {
		return outStorageCount;
	}

	public void setOutStorageCount(Integer outStorageCount) {
		this.outStorageCount = outStorageCount;
	}


	public Integer getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}

	public Integer getInvalidCount() {
		return invalidCount;
	}

	public void setInvalidCount(Integer invalidCount) {
		this.invalidCount = invalidCount;
	}

	public Integer getRecycleCount() {
		return recycleCount;
	}

	public void setRecycleCount(Integer recycleCount) {
		this.recycleCount = recycleCount;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUnUsedCount() {
		return unUsedCount;
	}

	public void setUnUsedCount(Integer unUsedCount) {
		this.unUsedCount = unUsedCount;
	}

}
