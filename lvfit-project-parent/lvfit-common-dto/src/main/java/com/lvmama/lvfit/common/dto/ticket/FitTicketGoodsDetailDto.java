package com.lvmama.lvfit.common.dto.ticket;

import java.io.Serializable;
import java.util.Date;


/**
 * 门票商品Dto
 * 
 * @author yueyufan
 *
 */
public class FitTicketGoodsDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5881737456763193087L;

	/**
	 * 商品
	 */
	private Long suppGoodsId;
	/**
	 * 产品ID
	 */
	private Long productId;
	/**
	 * 品类ID
	 */
	private Long categoryId;
	/**
	 * 是否期票
	 */
	private String aperiodicFlag;
	/**
	 * 产品规格ID
	 */
	private Long productBranchId;
	/**
	 * 商品名
	 */
	private String goodsName;
	/**
	 * 退改规则
	 * */
	// private String goodsRefundDescStr;
	/**
	 * 费用包含
	 * */
	private String priceIncludes;
	/**
	 * 入园须知
	 * **/
	// private String beforeTralNotice;

	/**
	 * 是否今日可售
	 */
	private String todayOnlineFlag;

	/**
	 * 今日提前预定时间
	 */
	private Long aheadBookTime;

	/**
	 * 所属票种
	 */
	private String goodsSpec;

	/**
	 * 商品描述里面的提前预定时间
	 * */
	/*
	 * private String aheadTimeForGoodsDesc;
	 */

	/**
	 * 取票时间
	 */
	private String changeTime;

	/**
	 * 取票地点
	 */
	private String changeAddress;
	/**
	 * 入园方式
	 */
	private String enterStyle;

	/**
	 * 入园限制时间
	 */
	private String limitTime;

	/**
	 * 游玩日有效开始时间（期票）
	 */
	private Date startTime;

	/**
	 * 游玩日有效结束时间（期票）
	 */
	private Date endTime;

	private String startTimeStr;

	private String endTimeStr;
	/**
	 * 有效天数（非期票）
	 */
	private Short days;

	/**
	 * 不适用日期
	 */
	private String unvalid;

	/**
	 * 身高
	 */
	private String height;

	/**
	 * 年龄
	 */
	private String age;

	/**
	 * 地域
	 */
	private String region;

	/**
	 * 最大起订量
	 */
	protected Long maxQuantity;
	/**
	 * 快递
	 */
	private String express;
	/**
	 * 实体票
	 */
	private String entityTicket;
	/**
	 * 其他
	 */
	private String others;

	/**
	 * 支付对象 PREPAID("预付（驴妈妈）"), PAY("现付（供应商）")
	 */
	private String payTarget;

	/**
	 * 退改说明
	 * */
	private String cancelStrategy;

	/**
	 * 门票票种枚举
	 * 
	 * @author yueyufan
	 *
	 */
	public static enum GOODSSPEC {
		PARENTAGE("亲子票[1大1小]", "亲子票", 1, 1), FAMILY("家庭票[2大1小]", "家庭票", 2, 1), LOVER(
				"情侣票[2大0小]", "情侣票", 2, 0), COUPE("双人票[2大0小]", "双人票", 2, 0), ADULT(
				"成人票[1大0小]", "成人票", 1, 0), CHILDREN("儿童票[0大1小]", "儿童票", 0, 1), OLDMAN(
				"老人票[1大0小]", "老人票", 1, 0), STUDENT("学生票[1大0小]", "学生票", 1, 0), ACTIVITY(
				"活动票[1大0小]", "活动票", 1, 0), SOLDIER("军人票[1大0小]", "军人票", 1, 0), MAN(
				"男士票[1大0小]", "男士票", 1, 0), WOMAN("女士票[1大0小]", "女士票", 1, 0), TEACHER(
				"教师票[1大0小]", "教师票", 1, 0), DISABILITY("残疾票[1大0小]", "残疾票", 1, 0), GROUP(
				"团体票[1大0小]", "团体票", 1, 0), FREE("自定义", "自定义", 0, 0);

		private String cnName;
		private String specName;
		private int adult;
		private int child;

		public static String getCnName(String code) {
			for (GOODSSPEC item : GOODSSPEC.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		public static int getAdult(String code) {
			for (GOODSSPEC item : GOODSSPEC.values()) {
				if (item.getCode().equals(code)) {
					return item.getAdult();
				}
			}
			return 0;
		}

		public static int getChild(String code) {
			for (GOODSSPEC item : GOODSSPEC.values()) {
				if (item.getCode().equals(code)) {
					return item.getChild();
				}
			}
			return 0;
		}

		public static String getSpecName(String code) {
			for (GOODSSPEC item : GOODSSPEC.values()) {
				if (item.getCode().equals(code)) {
					return item.getSpecName();
				}
			}
			return code;
		}

		GOODSSPEC(String name, String specName, int adult, int child) {
			this.cnName = name;
			this.adult = adult;
			this.child = child;
			this.specName = specName;
		}

		public String getCode() {
			return this.name();
		}

		public int getChild() {
			return this.child;
		}

		public int getAdult() {
			return this.adult;
		}

		public String getCnName() {
			return this.cnName;
		}

		public String getSpecName() {
			return this.specName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getAperiodicFlag() {
		return aperiodicFlag;
	}

	public void setAperiodicFlag(String aperiodicFlag) {
		this.aperiodicFlag = aperiodicFlag;
	}

	public Long getProductBranchId() {
		return productBranchId;
	}

	public void setProductBranchId(Long productBranchId) {
		this.productBranchId = productBranchId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/*
	 * public String getGoodsRefundDescStr() { return goodsRefundDescStr; }
	 * 
	 * public void setGoodsRefundDescStr(String goodsRefundDescStr) {
	 * this.goodsRefundDescStr = goodsRefundDescStr; }
	 */

	public String getPriceIncludes() {
		return priceIncludes;
	}

	public void setPriceIncludes(String priceIncludes) {
		this.priceIncludes = priceIncludes;
	}

	/*
	 * public String getBeforeTralNotice() { return beforeTralNotice; }
	 * 
	 * public void setBeforeTralNotice(String beforeTralNotice) {
	 * this.beforeTralNotice = beforeTralNotice; }
	 */

	public String getTodayOnlineFlag() {
		return todayOnlineFlag;
	}

	public void setTodayOnlineFlag(String todayOnlineFlag) {
		this.todayOnlineFlag = todayOnlineFlag;
	}

	public Long getAheadBookTime() {
		return aheadBookTime;
	}

	public void setAheadBookTime(Long aheadBookTime) {
		this.aheadBookTime = aheadBookTime;
	}

	public String getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	/*
	 * public String getAheadTimeForGoodsDesc() { return aheadTimeForGoodsDesc;
	 * }
	 * 
	 * public void setAheadTimeForGoodsDesc(String aheadTimeForGoodsDesc) {
	 * this.aheadTimeForGoodsDesc = aheadTimeForGoodsDesc; }
	 */

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	public String getChangeAddress() {
		return changeAddress;
	}

	public void setChangeAddress(String changeAddress) {
		this.changeAddress = changeAddress;
	}

	public String getEnterStyle() {
		return enterStyle;
	}

	public void setEnterStyle(String enterStyle) {
		this.enterStyle = enterStyle;
	}

	public String getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public Short getDays() {
		return days;
	}

	public void setDays(Short days) {
		this.days = days;
	}

	public String getUnvalid() {
		return unvalid;
	}

	public void setUnvalid(String unvalid) {
		this.unvalid = unvalid;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Long getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(Long maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public String getEntityTicket() {
		return entityTicket;
	}

	public void setEntityTicket(String entityTicket) {
		this.entityTicket = entityTicket;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getPayTarget() {
		return payTarget;
	}

	public void setPayTarget(String payTarget) {
		this.payTarget = payTarget;
	}

	public String getCancelStrategy() {
		return cancelStrategy;
	}

	public void setCancelStrategy(String cancelStrategy) {
		this.cancelStrategy = cancelStrategy;
	}

}
