package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.status.OpSource;

public class FitShoppingListRequest implements Serializable, Dto{
	
	 private static final long serialVersionUID = -6917426056315381405L;

	    private String shoppingUUId;    
	    private String queryBegTime;
	    private String queryEndTime;
	    private String contacterName;
	    private String contacterMobile;
	    /**
	     * 预订来源
	     */
	    private List<BookingSource> bookingSources = new ArrayList<BookingSource>();
	    
	    /**
	     * 操作源
	     */
	    private OpSource opSource;
		public String getShoppingUUId() {
			return shoppingUUId;
		}
		public void setShoppingUUId(String shoppingUUId) {
			this.shoppingUUId = shoppingUUId;
		}
		public String getQueryBegTime() {
			return queryBegTime;
		}
		public void setQueryBegTime(String queryBegTime) {
			this.queryBegTime = queryBegTime;
		}
		public String getQueryEndTime() {
			return queryEndTime;
		}
		public void setQueryEndTime(String queryEndTime) {
			this.queryEndTime = queryEndTime;
		}
		public List<BookingSource> getBookingSources() {
			return bookingSources;
		}
		public void setBookingSources(List<BookingSource> bookingSources) {
			this.bookingSources = bookingSources;
		}
		
		
		public OpSource getOpSource() {
			return opSource;
		}
		public void setOpSource(OpSource opSource) {
			this.opSource = opSource;
		}
		
		public String getContacterName() {
			return contacterName;
		}
		public void setContacterName(String contacterName) {
			this.contacterName = contacterName;
		}
		public String getContacterMobile() {
			return contacterMobile;
		}
		public void setContacterMobile(String contacterMobile) {
			this.contacterMobile = contacterMobile;
		}
		@Override
		public Long getId() {
			// TODO Auto-generated method stub
			return null;
		}
	    
	    
	    
}
