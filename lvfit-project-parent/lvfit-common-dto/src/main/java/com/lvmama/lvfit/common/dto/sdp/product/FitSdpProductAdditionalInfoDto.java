package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;
import java.util.List;

/**
 * 打包产品额外信息Dto
 * @author lizongze
 *
 */
public class FitSdpProductAdditionalInfoDto implements Serializable {

    private static final long serialVersionUID = -6240294372772132475L;
    // 头部标签
    private List<FitSdpProdTagDto> titleTags;
    // 好评率
    private Float feedBackRate;
    // 优惠
    private List<FitSdpProdTagDto> discountActivityTags;
    // 促销信息
    private String promotionInfo;
    // 往返交通（去程）
    private String toTraffic;
    // 往返交通（返程）
    private String backTraffic;
    // 目的地
    private List<FitSdpDestDto> destinations;
    // 包含项目
    private String containItems;
    // 产品经理头像URL
    private String pmUrl;
    // 产品经理名称
    private String pmUserName;
    // 产品经理推荐信息
    private String pmRecommendInfo;
    // 成人最小预定数
    private Long adultMinQuantity;
    // 成人最大预定数
    private Long adultMaxQuantity;
    // 儿童最小预定数
    private Long childMinQuantity;
    // 儿童最大预定数
    private Long childMaxQuantity;
    
    
    /************************************************************************************/
    private String multiRouteFlag;
    
    private String hotel;

    private String changeHotelFlag;
    
    private String changeTrafficFlag;
    
    public List<FitSdpProdTagDto> getTitleTags() {
        return titleTags;
    }
    public void setTitleTags(List<FitSdpProdTagDto> titleTags) {
        this.titleTags = titleTags;
    }
    public Float getFeedBackRate() {
        return feedBackRate;
    }
    public void setFeedBackRate(Float feedBackRate) {
        this.feedBackRate = feedBackRate;
    }
    public List<FitSdpProdTagDto> getDiscountActivityTags() {
        return discountActivityTags;
    }
    public void setDiscountActivityTags(List<FitSdpProdTagDto> discountActivityTags) {
        this.discountActivityTags = discountActivityTags;
    }
    public String getPromotionInfo() {
        return promotionInfo;
    }
    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
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
    public List<FitSdpDestDto> getDestination() {
        return destinations;
    }
    public void setDestination(List<FitSdpDestDto> destinations) {
        this.destinations = destinations;
    }
    public String getContainItems() {
        return containItems;
    }
    public void setContainItems(String containItems) {
        this.containItems = containItems;
    }
    public String getPmUrl() {
        return pmUrl;
    }
    public void setPmUrl(String pmUrl) {
        this.pmUrl = pmUrl;
    }
    public String getPmRecommendInfo() {
        return pmRecommendInfo;
    }
    public void setPmRecommendInfo(String pmRecommendInfo) {
        this.pmRecommendInfo = pmRecommendInfo;
    }
    public Long getAdultMinQuantity() {
        return adultMinQuantity;
    }
    public void setAdultMinQuantity(Long adultMinQuantity) {
        this.adultMinQuantity = adultMinQuantity;
    }
    public Long getAdultMaxQuantity() {
        return adultMaxQuantity;
    }
    public void setAdultMaxQuantity(Long adultMaxQuantity) {
        this.adultMaxQuantity = adultMaxQuantity;
    }
    public Long getChildMinQuantity() {
        return childMinQuantity;
    }
    public void setChildMinQuantity(Long childMinQuantity) {
        this.childMinQuantity = childMinQuantity;
    }
    public Long getChildMaxQuantity() {
        return childMaxQuantity;
    }
    public void setChildMaxQuantity(Long childMaxQuantity) {
        this.childMaxQuantity = childMaxQuantity;
    }
	public String getMultiRouteFlag() {
		return multiRouteFlag;
	}
	public void setMultiRouteFlag(String multiRouteFlag) {
		this.multiRouteFlag = multiRouteFlag;
	}
	public List<FitSdpDestDto> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<FitSdpDestDto> destinations) {
		this.destinations = destinations;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getChangeHotelFlag() {
		return changeHotelFlag;
	}
	public void setChangeHotelFlag(String changeHotelFlag) {
		this.changeHotelFlag = changeHotelFlag;
	}
	public String getChangeTrafficFlag() {
		return changeTrafficFlag;
	}
	public void setChangeTrafficFlag(String changeTrafficFlag) {
		this.changeTrafficFlag = changeTrafficFlag;
	}
    public String getPmUserName() {
        return pmUserName;
    }
    public void setPmUserName(String pmUserName) {
        this.pmUserName = pmUserName;
    }
	
    
}
