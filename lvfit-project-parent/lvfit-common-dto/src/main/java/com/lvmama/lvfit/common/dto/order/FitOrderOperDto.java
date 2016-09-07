package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;

public class FitOrderOperDto extends Entity {

    private static final long serialVersionUID = -3831685127384949251L;

    /** 订单主键 */
    private Long orderId;

    /** 操作者 */
    public String oper;

    /** 备注 */
    public String remark;

    public Long getOrderId() {
        return orderId;
    }
	
	private Long operId;

	private String operName;
	
	private String operIp;

	public Long getOperId() {
		return operId;
	}

	public void setOperId(Long operId) {
		this.operId = operId;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getOperIp() {
		return operIp;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}
	
	

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public static FitOrderOperDto convertOperDto(ShoppingDetailDto dto){
    	FitOrderOperDto resultDto = new FitOrderOperDto();
    	resultDto.setOperId(dto.getOperId());
    	resultDto.setOperIp(dto.getOperIp());
    	resultDto.setOperName(dto.getOperName());
    	return resultDto;
    }
}
