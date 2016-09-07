package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 自主打包产品起价DTO
 * @author leizhengwei
 *
 */
public class FitSdpProductStartPriceDto implements Serializable{

	private static final long serialVersionUID = 3978307557379607928L;

	/**自主打包产品Id */
	private Long productId;
	
	/**自主打包产品起价 */
    private BigDecimal productStartPrice;
    
    /**每个城市组起价  key : 出发地 +"_"+ 目的地,例如：SHA_PEK  */
    private Map<String,BigDecimal> everyCityLineStartPrice = new HashMap<String, BigDecimal>();

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getProductStartPrice() {
		return productStartPrice;
	}

	public void setProductStartPrice(BigDecimal productStartPrice) {
		this.productStartPrice = productStartPrice;
	}

	public Map<String, BigDecimal> getEveryCityLineStartPrice() {
		return everyCityLineStartPrice;
	}

	public void setEveryCityLineStartPrice(Map<String, BigDecimal> everyCityLineStartPrice) {
		this.everyCityLineStartPrice = everyCityLineStartPrice;
	}
    
}
