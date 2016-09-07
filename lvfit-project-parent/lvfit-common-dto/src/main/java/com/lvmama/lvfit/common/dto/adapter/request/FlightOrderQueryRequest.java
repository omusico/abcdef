package com.lvmama.lvfit.common.dto.adapter.request;

import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

import java.io.Serializable;

/**
 * 查询机票单品请求
 * @author qihuisong
 */
public class FlightOrderQueryRequest implements Serializable{

    private static final long serialVersionUID = -8665882347954564902L;

    private FitSuppMainOrderDto fitSuppMainOrderDto;

    public FlightOrderQueryRequest() {
    }

    public FlightOrderQueryRequest(FitSuppMainOrderDto fitSuppMainOrderDto) {
        this.fitSuppMainOrderDto = fitSuppMainOrderDto;
    }

    public FitSuppMainOrderDto getFitSuppMainOrderDto() {
        return fitSuppMainOrderDto;
    }

    public void setFitSuppMainOrderDto(FitSuppMainOrderDto fitSuppMainOrderDto) {
        this.fitSuppMainOrderDto = fitSuppMainOrderDto;
    }
}

