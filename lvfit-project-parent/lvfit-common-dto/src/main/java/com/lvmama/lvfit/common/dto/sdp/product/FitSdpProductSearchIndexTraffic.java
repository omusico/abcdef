package com.lvmama.lvfit.common.dto.sdp.product;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.JudgeType;

/** 搜索索引交通信息
 * Created by leizhengwei
 * 2016/7/20
 * 13:47
 */
public class FitSdpProductSearchIndexTraffic extends Entity{


	/**
	 * 
	 */
	private static final long serialVersionUID = 499905222550215572L;

	private Long productId;

    private String toTraffic;

    private String backTraffic;

    private String depatureTime;

    private String salesVolume;

    private JudgeType isMultiDepature;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getToTraffic() {
        return toTraffic;
    }

    public void setToTraffic(String toTraffic) {
        this.toTraffic = toTraffic;
    }

    public String getBackTraffic() {
        return backTraffic;
    }

    public void setBackTraffic(String backTraffic) {
        this.backTraffic = backTraffic;
    }


    public String getDepatureTime() {
        return depatureTime;
    }

    public void setDepatureTime(String depatureTime) {
        this.depatureTime = depatureTime;
    }

    public String getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(String salesVolume) {
        this.salesVolume = salesVolume;
    }

    public JudgeType getIsMultiDepature() {
        return isMultiDepature;
    }

    public void setIsMultiDepature(JudgeType isMultiDepature) {
        this.isMultiDepature = isMultiDepature;
    }
}
