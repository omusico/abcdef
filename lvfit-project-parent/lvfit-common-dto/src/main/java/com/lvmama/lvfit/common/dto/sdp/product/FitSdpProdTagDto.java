package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;

public class FitSdpProdTagDto implements Serializable {

    private static final long serialVersionUID = 8897482416950089740L;
    // 名称
    private String tagName;
    // 内容
    private String tagContent;
    
    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    public String getTagContent() {
        return tagContent;
    }
    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }
}
