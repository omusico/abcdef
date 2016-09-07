package com.lvmama.lvf.common.dto.status.detail;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 订单PNR状态枚举
 * @author majun
 * @date   2015-1-28
 */
public enum DetailBookingStatus  implements ProcessOp
{
	NULL(""),
	NOT_BOOKING("未订位"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_CONFIRM.equals(statusContext.getOp());
		}
	},
	BOOKING_SUCC("订位成功"){
		
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_BOOKING.equals(statusContext.getOp())
					||OpCommandBack.OP_PASS_ISSUE.equals(statusContext.getOp());
		}
	},
	BOOKING_FAIL("订位失败"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_REJECT_BOOKING.equals(statusContext.getOp());
		}
	};
	
	private String cnName;

	private DetailBookingStatus(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	@Override
	public boolean vaild(StatusContext statusContext) {
		return false;
	}

	@Override
	public void processOp(StatusContext statusContext) {
		if(vaild(statusContext)){
			for(FlightOrderDetailDto flightOrderDetailDto : statusContext.getOrderDetails())
			{	
				flightOrderDetailDto.setDetailBookingStatus(this);
			}
		}
	};
}
