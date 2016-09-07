package com.lvmama.lvf.common.dto.status.detail;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.status.OpAction;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

public enum DetailSuppAuditStatus implements ProcessOp
{
	NULL(""),
	APPLY_SUPP_OP("申请供应商处理"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpAction.APPLY_SUPP_OP.equals(statusContext.getOp().getOpAction());
		}
	},
	SUPP_OP_PASS("供应商处理通过"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpAction.SUPP_OP_PASS.equals(statusContext.getOp().getOpAction());
		}
	},
	SUPP_OP_REJECT("供应商处理驳回"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpAction.SUPP_OP_REJECT.equals(statusContext.getOp().getOpAction());
		}
	};
	
	private String cnName;
	
	private DetailSuppAuditStatus(String cnName) {
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

		if(vaild(statusContext))
		{
			for(FlightOrderDetailDto flightOrderDetailDto : statusContext.getOrderDetails())
			{
				switch (statusContext.getOp().getOpType()) 
				{
					case RTVT:
						if(null==flightOrderDetailDto.getFlightOrderDetailRTVT()){
							continue;
						}
						flightOrderDetailDto.getFlightOrderDetailRTVT().setDetailSuppAuditStatus(this);
						break;
					case CTMT:
						if(null==flightOrderDetailDto.getFlightOrderTicketCTMT()){
							continue;
						}
						flightOrderDetailDto.getFlightOrderTicketCTMT().setDetailSuppAuditStatus(this);
						break;
					case ISSUE:
						if(null==flightOrderDetailDto.getFlightOrderTicketIssue()){
							continue;
						}
						flightOrderDetailDto.getFlightOrderTicketIssue().setDetailSuppAuditStatus(this);
						break;
					default:
						break;
				}	
			}
		}
	}
}
