package com.lvmama.lvfit.common.form.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.request.FitShoppingListRequest;

public class ShoppingListQueryRequestForm implements Serializable,Form {

	private static final long serialVersionUID = -8212381557892320514L;
	
	private String bookingSourceStr;
		
    private FitShoppingListRequest fitShoppingListRequest = new FitShoppingListRequest();
	private Pagination pagination = new Pagination();
	
	public String getBookingSourceStr() {
		return bookingSourceStr;
	}

	public void setBookingSourceStr(String bookingSourceStr) {
		this.bookingSourceStr = bookingSourceStr;
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

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
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

	public String getShoppingUUId() {
		return fitShoppingListRequest.getShoppingUUId();
	}

	public void setShoppingUUId(String shoppingUUId) {
		fitShoppingListRequest.setShoppingUUId(shoppingUUId) ;
	}

	public String getQueryBegTime() {
		return fitShoppingListRequest.getQueryBegTime();
	}

	public void setQueryBegTime(String queryBegTime) {
		fitShoppingListRequest.setQueryBegTime(queryBegTime);
	}

	public String getQueryEndTime() {
		return fitShoppingListRequest.getQueryEndTime();
	}

	public void setQueryEndTime(String queryEndTime) {
		fitShoppingListRequest.setQueryEndTime(queryEndTime);
	}
    
	public String getContacterName() {
		return fitShoppingListRequest.getContacterName();
	}
	public void setContacterName(String contacterName) {
		fitShoppingListRequest.setContacterName(contacterName);
	}
	public String getContacterMobile() {
		return fitShoppingListRequest.getContacterMobile();
	}
	public void setContacterMobile(String contacterMobile) {
		fitShoppingListRequest.setContacterMobile(contacterMobile);
	}
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public FitShoppingListRequest getFitShoppingListRequest() {
		/*if(StringUtils.isNotBlank(this.getBookingSourceStr()))
    	{
    		String[] bookingSourceAry = this.getBookingSourceStr().split(",");
    		List<BookingSource> bookingSourceList = new ArrayList<BookingSource>();
    		for(String bookingSource : bookingSourceAry)
    			bookingSourceList.add(BookingSource.valueOf(bookingSource));
    		fitShoppingListRequest.setBookingSources(bookingSourceList);
		}*/
		return fitShoppingListRequest;
	}

	public void setFitShoppingListRequest(
			FitShoppingListRequest fitShoppingListRequest) {
		this.fitShoppingListRequest = fitShoppingListRequest;
	}
    
	
}
