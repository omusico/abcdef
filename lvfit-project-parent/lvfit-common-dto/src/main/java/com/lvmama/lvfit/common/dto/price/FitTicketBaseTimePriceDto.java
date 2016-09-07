package com.lvmama.lvfit.common.dto.price;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.utils.PriceUtil;

/**
 * 
 * @author yueyufan
 *
 */
public class FitTicketBaseTimePriceDto implements Serializable {

	private static final long serialVersionUID = -6722726601312978610L;

	/**
	 * 时间价格表ID
	 */
	protected Long timePriceId;
	/**
	 * 商品ID
	 */
	protected Long suppGoodsId;

	/**
	 * 供应商ID
	 */
	protected Long supplierId;
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

	//价格整数50.85-->50
	public String getIntYuanOfPrice(Long price){
		String [] intYuanOfPrice = getYuanOfPrice(price).split("\\.");
		return intYuanOfPrice[0];
	}
		
	public String getYuanOfPrice(Long price){
		String yuanOfPrice = "0";
		if(price != null){
			return PriceUtil.trans2YuanStr(price);
		}
		return yuanOfPrice;
	}
	
	public Long getTimePriceId() {
		return timePriceId;
	}

	public void setTimePriceId(Long timePriceId) {
		this.timePriceId = timePriceId;
	}

	public Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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

	/**
	 * 时间价格验证
	 * 
	 *
	 */
	public class TimePriceCheckDto {
		
		//是否能下单
		private boolean isOrderAble;
		
		private String notAbleReason;
		
		//下单时库存扣减方式
		private List<StockReduceDto> stockReduceList;

		public boolean isOrderAble() {
			return isOrderAble;
		}

		public void setOrderAble(boolean isOrderAble) {
			this.isOrderAble = isOrderAble;
		}

		public List<StockReduceDto> getStockReduceList() {
			return stockReduceList;
		}

		public void setStockReduceList(List<StockReduceDto> stockReduceList) {
			this.stockReduceList = stockReduceList;
		}

		public String getNotAbleReason() {
			return notAbleReason;
		}

		public void setNotAbleReason(String notAbleReason) {
			this.isOrderAble = false;
			this.notAbleReason = notAbleReason;
		}
	}
	
	public class StockReduceDto {

		//库存扣减类型
		private REDUCETYPE reduceType;
		//库存分量
		private long stock;
		//是否扣库存
		private boolean isReduceStock;
		//是否需要资源确认
		private boolean isResourceConfirm;
		
		
		public REDUCETYPE getReduceType() {
			return reduceType;
		}


		public void setReduceType(REDUCETYPE reduceType) {
			this.reduceType = reduceType;
		}


		public long getStock() {
			return stock;
		}


		public void setStock(long stock) {
			this.stock = stock;
		}


		public boolean isResourceConfirm() {
			return isResourceConfirm;
		}


		public void setResourceConfirm(boolean isResourceConfirm) {
			this.isResourceConfirm = isResourceConfirm;
		}


		public boolean isReduceStock() {
			return isReduceStock;
		}


		public void setReduceStock(boolean isReduceStock) {
			this.isReduceStock = isReduceStock;
		}
	}
		
	//库存扣减类型枚举
	public static enum REDUCETYPE {
		FREESALE//freesale
		,
		RESERVED//保留房
		,
		UNRESERVED//非保留房
		,
		INQUIRY//现询
		,
		CONTROL;//空位
	}
	
	//库存类型
	public static enum STOCKTYPE {
		
		CONTROLLABLE("控位"), INQUIRY("现询"), FREESALE("FreeSale");
		
		private String cnName;
		public static String getCnName(String code) {
			for (STOCKTYPE item : STOCKTYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		STOCKTYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}
	
	//退改类型枚举
	public static enum CANCELSTRATEGYTYPE {
		RETREATANDCHANGE("可退改"),//可退改
		UNRETREATANDCHANGE("不退不改"),//不退不改
		MANUALCHANGE("人工退改");//人工退改
		private String cnName;

		public static String getCnName(String code) {
			for (CANCELSTRATEGYTYPE item : CANCELSTRATEGYTYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		CANCELSTRATEGYTYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}
	
	/**
	 * 预定限制
	 * 
	 *
	 */
	public static enum BOOKLIMITTYPE {
		NONE("无限制"), TIMEOUTGUARANTEE("超时担保"),ALLTIMEGUARANTEE("全程担保"), ALLGUARANTEE("一律担保"), PREAUTH("一律预授权");
		private String cnName;

		public static String getCnName(String code) {
			for (BOOKLIMITTYPE item : BOOKLIMITTYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		BOOKLIMITTYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public String getBookLimitType() {
		return bookLimitType;
	}

	public void setBookLimitType(String bookLimitType) {
		this.bookLimitType = bookLimitType;
	}
	
}
