package com.lvmama.lvfit.common.dto.booking;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderExpressDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;

/**
 * Created by qihuisong on 2015/11/27.
 *
 *
 *
 * 将要废弃，请不要使用
 *
 *
 */
public class FitBookingDto extends Entity {

    private static final long serialVersionUID = 2376508630068019820L;

    /**
     * 主订单对应品类ID，标准产品可以为null，组合产品必须设置。
     */
    private Long categoryId;

    /**
     * 分销商渠道
     */
    private Long distributionId;

    /**
     * 游玩日期
     */
    private String visitTime;

    /**
     * 成人数
     */
    private int adultQuantity;

    /**
     * 儿童数
     */
    private int childQuantity;

    /**
     * 下单人信息
     */
    private FitOrderCustomerDto fitOrderCustomerDto;

    /**
     * 联系人
     */
    private FitOrderContacterDto fitOrderContacterDto;

    /**
     * 游玩人员
     */
    private List<FitOrderPassengerDto> fitOrderPassengerDtos = new ArrayList<FitOrderPassengerDto>();

    /**
     * 配送方式
     */
    private FitOrderExpressDto fitOrderExpressDto;

    /**
     * 订单子项
     */

    /**
     * 打包产品列表
     */

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public int getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(int adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public int getChildQuantity() {
        return childQuantity;
    }

    public void setChildQuantity(int childQuantity) {
        this.childQuantity = childQuantity;
    }

    public FitOrderCustomerDto getFitOrderCustomerDto() {
        return fitOrderCustomerDto;
    }

    public void setFitOrderCustomerDto(FitOrderCustomerDto fitOrderCustomerDto) {
        this.fitOrderCustomerDto = fitOrderCustomerDto;
    }

    public FitOrderContacterDto getFitOrderContacterDto() {
        return fitOrderContacterDto;
    }

    public void setFitOrderContacterDto(FitOrderContacterDto fitOrderContacterDto) {
        this.fitOrderContacterDto = fitOrderContacterDto;
    }

    public List<FitOrderPassengerDto> getFitOrderPassengerDtos() {
        return fitOrderPassengerDtos;
    }

    public void setFitOrderPassengerDtos(List<FitOrderPassengerDto> fitOrderPassengerDtos) {
        this.fitOrderPassengerDtos = fitOrderPassengerDtos;
    }

    public FitOrderExpressDto getFitOrderExpressDto() {
        return fitOrderExpressDto;
    }

    public void setFitOrderExpressDto(FitOrderExpressDto fitOrderExpressDto) {
        this.fitOrderExpressDto = fitOrderExpressDto;
    }
}
