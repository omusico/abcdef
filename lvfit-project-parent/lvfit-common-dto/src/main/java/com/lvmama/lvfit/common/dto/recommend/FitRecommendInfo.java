package com.lvmama.lvfit.common.dto.recommend;

import java.io.Serializable;

public class FitRecommendInfo implements Serializable {

    private static final long serialVersionUID = 6472021651122354723L;
    
    // ID
    private Long recommendInfoId;
    // 推荐块ID
    private Long recommendBlockId;
    // 所属推荐块ID
    private Long parentRecommendBlockId;
    // 位置CODE
    private String dataCode;
    // 名称
    private String title;
    // 产品url
    private String url;
    // 图片url
    private String imgUrl;
    // 产品价格
    private String price;
    // 排序值
    private Long seq;
    //--------备用字段----------
    private String bakWord1;

    private String bakWord2;

    private String bakWord3;

    private String bakWord4;

    private String bakWord5;

    private String bakWord6;

    private String bakWord7;

    private String bakWord8;

    private String bakWord9;

    private String bakWord10;
    
    
    public Long getRecommendInfoId() {
        return recommendInfoId;
    }
    public void setRecommendInfoId(Long recommendInfoId) {
        this.recommendInfoId = recommendInfoId;
    }
    public Long getRecommendBlockId() {
        return recommendBlockId;
    }
    public void setRecommendBlockId(Long recommendBlockId) {
        this.recommendBlockId = recommendBlockId;
    }
    public Long getParentRecommendBlockId() {
        return parentRecommendBlockId;
    }
    public void setParentRecommendBlockId(Long parentRecommendBlockId) {
        this.parentRecommendBlockId = parentRecommendBlockId;
    }
    public String getDataCode() {
        return dataCode;
    }
    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Long getSeq() {
        return seq;
    }
    public void setSeq(Long seq) {
        this.seq = seq;
    }
    public String getBakWord1() {
        return bakWord1;
    }
    public void setBakWord1(String bakWord1) {
        this.bakWord1 = bakWord1;
    }
    public String getBakWord2() {
        return bakWord2;
    }
    public void setBakWord2(String bakWord2) {
        this.bakWord2 = bakWord2;
    }
    public String getBakWord3() {
        return bakWord3;
    }
    public void setBakWord3(String bakWord3) {
        this.bakWord3 = bakWord3;
    }
    public String getBakWord4() {
        return bakWord4;
    }
    public void setBakWord4(String bakWord4) {
        this.bakWord4 = bakWord4;
    }
    public String getBakWord5() {
        return bakWord5;
    }
    public void setBakWord5(String bakWord5) {
        this.bakWord5 = bakWord5;
    }
    public String getBakWord6() {
        return bakWord6;
    }
    public void setBakWord6(String bakWord6) {
        this.bakWord6 = bakWord6;
    }
    public String getBakWord7() {
        return bakWord7;
    }
    public void setBakWord7(String bakWord7) {
        this.bakWord7 = bakWord7;
    }
    public String getBakWord8() {
        return bakWord8;
    }
    public void setBakWord8(String bakWord8) {
        this.bakWord8 = bakWord8;
    }
    public String getBakWord9() {
        return bakWord9;
    }
    public void setBakWord9(String bakWord9) {
        this.bakWord9 = bakWord9;
    }
    public String getBakWord10() {
        return bakWord10;
    }
    public void setBakWord10(String bakWord10) {
        this.bakWord10 = bakWord10;
    }
}
