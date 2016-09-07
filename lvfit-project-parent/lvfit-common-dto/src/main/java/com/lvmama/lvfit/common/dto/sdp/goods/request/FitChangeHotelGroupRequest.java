package com.lvmama.lvfit.common.dto.sdp.goods.request;

import java.io.Serializable;

/**
 * 修改酒店信息的request
 * @author Administrator
 *
 */
public class FitChangeHotelGroupRequest implements Serializable {

    private static final long serialVersionUID = 4437596106295011865L;
    //shopping id
    private String shoppingUuid;
    //商品id
    private Long suppGoodsId;
    //分组id
    private Long groupId;
    //酒店id
    private Long hotelId;
    //房间id
    private Long roomId;
    //房间数量
    private Integer roomCount;

    public String getShoppingUuid() {
        return shoppingUuid;
    }
 

	public Integer getRoomCount() {
		return roomCount;
	}


	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}


	public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

    public Long getSuppGoodsId() {
        return suppGoodsId;
    }

    public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
        this.suppGoodsId = suppGoodsId;
    }

}
