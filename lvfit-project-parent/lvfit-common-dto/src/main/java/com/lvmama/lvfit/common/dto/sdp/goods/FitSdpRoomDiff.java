package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;

public class FitSdpRoomDiff implements Serializable  {

    private static final long serialVersionUID = -1578264234171925936L;
    // 房差单价
    private BigDecimal roomDiffPrice;
    // 份数
    private int count;

    public BigDecimal getRoomDiffPrice() {
        return roomDiffPrice;
    }

    public void setRoomDiffPrice(BigDecimal roomDiffPrice) {
        this.roomDiffPrice = roomDiffPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
