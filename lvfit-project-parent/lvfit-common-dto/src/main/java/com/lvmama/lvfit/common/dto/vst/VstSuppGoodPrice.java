package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;
import java.util.Date;

public class VstSuppGoodPrice implements Serializable{
	
	private static final long serialVersionUID = -611989165818269237L;
	
	  private Long suppGoodsId;//商品ID
	    /**
		 * 时间价格表ID
		 */
		protected Long timePriceId;
		
		/**
		 * 时间
		 */
		protected Date specDate;
		
		/**
		 * Y可售N禁售
		 */
		protected String onsaleFlag;
		
		/**
		 * 日库存
		 */
		protected Long stock;
		
		/**
		 * 合同库存
		 */
		protected Long totalStock;
		
		/**
		 * 提前预定时间
		 */
		protected Long aheadBookTime;
		
		/**
		 * 最晚无损取消时间
		 */
		protected Long latestCancelTime; 
		
		/**
		 * 退改类型
		 */
		protected String cancelStrategy;
		
		/**
		 * 库存是否可恢复
		 */
		protected String restoreFlag; 
		
		/**
		 * 预定限制
		 */
		protected String bookLimitType;
		
		/**
		 * 售价
		 */
		private Long price; 
		
		/**
		 * 结算价格
		 */
		private Long settlementPrice;

		/**
		 *  最晚预定时间
		 */
		private Long latestHoldTime;
		/**
		 *  是否可超卖
		 */
		private String overshellFlag;
		/**
		 *  早餐
		 */
		private int breakfast;
		/**
		 * 担保类型
		 */
		private String guarType;
		/**
		 * 扣款类型
		 */
		private String deductType;

		/**
		 * 最晚保存时间
		 */
		private Long latestUnguarTime;
		/**
		 *  房态
		 */
		private String stockStatus;

		/**
		 * 扣款数值（金额/百分比）
		 */
		private Long deductValue;
		/**
		 *freeSale
		 */
		private String freeSaleFlag;
		/**
		 *是否保留库存（是否是非保留房）
		 */
		private String stockFlag ;
		
		/**
		 * 库存标识栏位(1:单库存、2:共享库存)
		 */

		public Long getSuppGoodsId() {
			return suppGoodsId;
		}

		public void setSuppGoodsId(Long suppGoodsId) {
			this.suppGoodsId = suppGoodsId;
		}

		public Long getTimePriceId() {
			return timePriceId;
		}

		public void setTimePriceId(Long timePriceId) {
			this.timePriceId = timePriceId;
		}

		public Date getSpecDate() {
			return specDate;
		}

		public void setSpecDate(Date specDate) {
			this.specDate = specDate;
		}

		public String getOnsaleFlag() {
			return onsaleFlag;
		}

		public void setOnsaleFlag(String onsaleFlag) {
			this.onsaleFlag = onsaleFlag;
		}

		public Long getStock() {
			return stock;
		}

		public void setStock(Long stock) {
			this.stock = stock;
		}

		public Long getTotalStock() {
			return totalStock;
		}

		public void setTotalStock(Long totalStock) {
			this.totalStock = totalStock;
		}

		public Long getAheadBookTime() {
			return aheadBookTime;
		}

		public void setAheadBookTime(Long aheadBookTime) {
			this.aheadBookTime = aheadBookTime;
		}

		public Long getLatestCancelTime() {
			return latestCancelTime;
		}

		public void setLatestCancelTime(Long latestCancelTime) {
			this.latestCancelTime = latestCancelTime;
		}

		public String getCancelStrategy() {
			return cancelStrategy;
		}

		public void setCancelStrategy(String cancelStrategy) {
			this.cancelStrategy = cancelStrategy;
		}

		public String getRestoreFlag() {
			return restoreFlag;
		}

		public void setRestoreFlag(String restoreFlag) {
			this.restoreFlag = restoreFlag;
		}

		public String getBookLimitType() {
			return bookLimitType;
		}

		public void setBookLimitType(String bookLimitType) {
			this.bookLimitType = bookLimitType;
		}

		public Long getPrice() {
			return price;
		}

		public void setPrice(Long price) {
			this.price = price;
		}

		public Long getSettlementPrice() {
			return settlementPrice;
		}

		public void setSettlementPrice(Long settlementPrice) {
			this.settlementPrice = settlementPrice;
		}

		public Long getLatestHoldTime() {
			return latestHoldTime;
		}

		public void setLatestHoldTime(Long latestHoldTime) {
			this.latestHoldTime = latestHoldTime;
		}

		public String getOvershellFlag() {
			return overshellFlag;
		}

		public void setOvershellFlag(String overshellFlag) {
			this.overshellFlag = overshellFlag;
		}

		public int getBreakfast() {
			return breakfast;
		}

		public void setBreakfast(int breakfast) {
			this.breakfast = breakfast;
		}

		public String getGuarType() {
			return guarType;
		}

		public void setGuarType(String guarType) {
			this.guarType = guarType;
		}

		public String getDeductType() {
			return deductType;
		}

		public void setDeductType(String deductType) {
			this.deductType = deductType;
		}

		public Long getLatestUnguarTime() {
			return latestUnguarTime;
		}

		public void setLatestUnguarTime(Long latestUnguarTime) {
			this.latestUnguarTime = latestUnguarTime;
		}

		public String getStockStatus() {
			return stockStatus;
		}

		public void setStockStatus(String stockStatus) {
			this.stockStatus = stockStatus;
		}

		public Long getDeductValue() {
			return deductValue;
		}

		public void setDeductValue(Long deductValue) {
			this.deductValue = deductValue;
		}

		public String getFreeSaleFlag() {
			return freeSaleFlag;
		}

		public void setFreeSaleFlag(String freeSaleFlag) {
			this.freeSaleFlag = freeSaleFlag;
		}

		public String getStockFlag() {
			return stockFlag;
		}

		public void setStockFlag(String stockFlag) {
			this.stockFlag = stockFlag;
		}
}
