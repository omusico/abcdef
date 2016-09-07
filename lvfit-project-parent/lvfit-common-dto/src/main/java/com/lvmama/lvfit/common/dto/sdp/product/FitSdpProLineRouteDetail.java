package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;

public class FitSdpProLineRouteDetail implements Serializable {

    private static final long serialVersionUID = -6343936727880969632L;

    private Long detailId;
    
    private Long routeId;
    
    private Short nDay;
    
    private String title;

    private String content;

    private String stayType;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Short getnDay() {
        return nDay;
    }

    public void setnDay(Short nDay) {
        this.nDay = nDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStayType() {
        return stayType;
    }

    public void setStayType(String stayType) {
        this.stayType = stayType;
    }
}
