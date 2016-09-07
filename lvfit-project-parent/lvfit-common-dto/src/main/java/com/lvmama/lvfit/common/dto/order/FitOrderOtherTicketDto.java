package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 其他票快照信息
 * @author leizhengwei
 *
 */
public class FitOrderOtherTicketDto extends Entity{

	private static final long serialVersionUID = -5677231398683400638L;
	
	// 产品ID
    private Long productId;
    // 产品名称
    private String productName;
    // 商品ID
    private Long goodsId;
    // 商品名称
    private String goodsName;
    // 商品详情
    private String branchDesc;
    // 选择的份数
    private Long selectCount;
    //选中的日期    
    private Date selectDate;
    // 选中的价格（单价）
    private BigDecimal selectPrice;
    
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getBranchDesc() {
		return branchDesc;
	}
	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}
	public Long getSelectCount() {
		return selectCount;
	}
	public void setSelectCount(Long selectCount) {
		this.selectCount = selectCount;
	}
	public Date getSelectDate() {
		return selectDate;
	}
	public void setSelectDate(Date selectDate) {
		this.selectDate = selectDate;
	}
	public BigDecimal getSelectPrice() {
		return selectPrice;
	}
	public void setSelectPrice(BigDecimal selectPrice) {
		this.selectPrice = selectPrice;
	}
    
    
}
