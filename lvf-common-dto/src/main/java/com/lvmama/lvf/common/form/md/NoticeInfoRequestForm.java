package com.lvmama.lvf.common.form.md;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.NoticeInfoRequest;
import com.lvmama.lvf.common.form.Form;
/**
 * 通知规则信息RequestForm
 * @author yangyongni
 * @date  2015年9月9日
 */
public class NoticeInfoRequestForm  implements Serializable, Form {

	private static final long serialVersionUID = -7114276441028690009L;
	
	private NoticeInfoRequest noticeInfoRequest = new NoticeInfoRequest();
	
	private Pagination pagination = new Pagination();
	
	public NoticeInfoRequest getNoticeInfoRequest() {
		return noticeInfoRequest;
	}
	public void setNoticeInfoRequest(NoticeInfoRequest noticeInfoRequest) {
		this.noticeInfoRequest = noticeInfoRequest;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public String getDepartureStartTime() {
		return noticeInfoRequest.getDepartureStartTime();
	}
	public void setDepartureStartTime(String departureStartTime) {
		noticeInfoRequest.setDepartureStartTime(departureStartTime); 
	}
	public String getDepartureEndTime() {
		return noticeInfoRequest.getDepartureEndTime();
	}
	public void setDepartureEndTime(String departureEndTime) {
		noticeInfoRequest.setDepartureEndTime(departureEndTime);
	}
	public List<Long> getIds() {
		return noticeInfoRequest.getIds();
	}
	public void setIds(List<Long> ids) {
		noticeInfoRequest.setIds(ids);
	}
	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public boolean equals(Object obj) {
		return pagination.equals(obj);
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}
}
