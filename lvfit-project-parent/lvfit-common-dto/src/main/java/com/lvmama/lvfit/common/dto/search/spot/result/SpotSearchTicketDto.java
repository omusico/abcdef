package com.lvmama.lvfit.common.dto.search.spot.result;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvfit.common.dto.price.FitTicketAddTimePriceDto;
import com.lvmama.lvfit.common.dto.ticket.FitTicketGoodsDetailDto;

/**
 * 景点搜索门票对象
 * 
 * @author leizhengwei
 *
 */
public class SpotSearchTicketDto implements Serializable {

	private static final long serialVersionUID = 4722123596497948717L;

	// 供应商商品ID
	private String suppGoodsId;
	// 产品ID
	private String productId;
	// 商品ID
	private String productBranchId;
	// 商品名称
	private String goodsName;
	//最大连住天数
	private Integer maxStayDay;
	//最小连住天数
	private Integer minStayDay;
	//最多起订量
	private Integer maxQuantity;
	//最少起订量
	private Integer minQuantity;
	// 支付对象
	private String payTarget;
	// 提前预定时间
	private String aheadBookTime;
	// 是否期票
	private String aperiodicFlag;
	// 买赠标志
    private String buyPresentFlag;
	// 市场价格
	private Double marketPrice;
	// 销售价格
	private Double sellPrice;
	// 标签名称
	private String tagName;
	// 标签描述
	private String tagMemo;
	// 促销标示
	private String promotionFlag;
	// 促销标签
	private String promotionType;
	// 返现金额(PC)
	private String rebatePc;
	// 返现金额(MOBILE)
	private String rebateMobile;
	// 团购结束时间
	private String specDate;
	// 产品图片URL
	private String photoUrl;
	// 退改类型
	private String cancelStrategy;
	// 产品名称
	private String productName;
	//门票张数
	private int ticketCount;
	//门票种类
	private String TicketSpec;
	//游玩日期
	private String visitDate;
	//是否选中
	private boolean selectFlag;
	// 商品时间价格表
	private List<FitTicketAddTimePriceDto> dayTimePriceDtos;
	// 门票详细信息
	private FitTicketGoodsDetailDto ticketGoodsDetailDto;
	
	public String getSuppGoodsId() {
		return suppGoodsId;
	}
	
	public void setSuppGoodsId(String suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductBranchId() {
		return productBranchId;
	}
	
	public void setProductBranchId(String productBranchId) {
		this.productBranchId = productBranchId;
	}
	
	public String getAheadBookTime() {
		return aheadBookTime;
	}
	
	public void setAheadBookTime(String aheadBookTime) {
		this.aheadBookTime = aheadBookTime;
	}
	
	public String getAperiodicFlag() {
		return aperiodicFlag;
	}
	
	public void setAperiodicFlag(String aperiodicFlag) {
		this.aperiodicFlag = aperiodicFlag;
	}
	
	public String getBuyPresentFlag() {
		return buyPresentFlag;
	}
	
	public void setBuyPresentFlag(String buyPresentFlag) {
		this.buyPresentFlag = buyPresentFlag;
	}
	
	public Double getMarketPrice() {
		return marketPrice;
	}
	
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	
	public Double getSellPrice() {
		return sellPrice;
	}
	
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getPayTarget() {
		return payTarget;
	}
	
	public void setPayTarget(String payTarget) {
		this.payTarget = payTarget;
	}
	
	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public String getTicketSpec() {
		return TicketSpec;
	}

	public void setTicketSpec(String ticketSpec) {
		TicketSpec = ticketSpec;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public boolean isSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(boolean selectFlag) {
		this.selectFlag = selectFlag;
	}

	public List<FitTicketAddTimePriceDto> getDayTimePriceDtos() {
		return dayTimePriceDtos;
	}
	
	public void setDayTimePriceDtos(List<FitTicketAddTimePriceDto> dayTimePriceDtos) {
		this.dayTimePriceDtos = dayTimePriceDtos;
	}

    public FitTicketGoodsDetailDto getTicketGoodsDetailDto() {
        return ticketGoodsDetailDto;
    }

    public void setTicketGoodsDetailDto(FitTicketGoodsDetailDto ticketGoodsDetailDto) {
        this.ticketGoodsDetailDto = ticketGoodsDetailDto;
    }

	public final Integer getMaxQuantity() {
		return maxQuantity;
	}

	public final void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public final Integer getMinQuantity() {
		return minQuantity;
	}

	public final void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Integer getMaxStayDay() {
		return maxStayDay;
	}

	public void setMaxStayDay(Integer maxStayDay) {
		this.maxStayDay = maxStayDay;
	}

	public Integer getMinStayDay() {
		return minStayDay;
	}

	public void setMinStayDay(Integer minStayDay) {
		this.minStayDay = minStayDay;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagMemo() {
		return tagMemo;
	}

	public void setTagMemo(String tagMemo) {
		this.tagMemo = tagMemo;
	}

	public String getPromotionFlag() {
		return promotionFlag;
	}

	public void setPromotionFlag(String promotionFlag) {
		this.promotionFlag = promotionFlag;
	}

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public String getRebatePc() {
		return rebatePc;
	}

	public void setRebatePc(String rebatePc) {
		this.rebatePc = rebatePc;
	}

	public String getRebateMobile() {
		return rebateMobile;
	}

	public void setRebateMobile(String rebateMobile) {
		this.rebateMobile = rebateMobile;
	}

	public String getSpecDate() {
		return specDate;
	}

	public void setSpecDate(String specDate) {
		this.specDate = specDate;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getCancelStrategy() {
		return cancelStrategy;
	}

	public void setCancelStrategy(String cancelStrategy) {
		this.cancelStrategy = cancelStrategy;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
