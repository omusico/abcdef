package com.lvmama.lvfit.common.dto.sdp.goods.request;

import java.io.Serializable;

public class FitChangeHotelComboRequest implements Serializable {

    private static final long serialVersionUID = 4437596106295011865L;
    
    private String shoppingUuid;
    
    private Long suppGoodsId;

    public String getShoppingUuid() {
        return shoppingUuid;
    }

    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

    public Long getSuppGoodsId() {
        return suppGoodsId;
    }

    public void setSuppGoodsId(Long suppGoodsId) {
        this.suppGoodsId = suppGoodsId;
    }

}
