package com.lvmama.lvf.common.dto.status.detail;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.status.OpAction;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 订单审核状态
 * 
 * @author leizhengwei
 * @date 2015-3-9
 */
public enum DetailAuditStatus implements ProcessOp {
	
	NULL(""),
	NOT_AUDIT("待审核"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.APPLY.equals(statusContext.getOp().getOpAction());
		}
	}, 
	AUDIT_PASS("审核通过"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.AUDIT_PASS.equals(statusContext.getOp().getOpAction());
		}
	}, 
	AUDIT_REJECT("审核驳回"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.AUDIT_REJECT.equals(statusContext.getOp().getOpAction());
		}		
	},
	OP_PASS("处理通过"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.OP_PASS.equals(statusContext.getOp().getOpAction());
		}		
	}, 
	OP_REJECT("处理驳回"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.OP_REJECT.equals(statusContext.getOp().getOpAction());
		}		
	};


	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private DetailAuditStatus(String cnName) {
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
						flightOrderDetailDto.getFlightOrderDetailRTVT().setDetailAuditStatus(this);
						break;
					case CTMT:
						if(null==flightOrderDetailDto.getFlightOrderTicketCTMT()){
							continue;
						}
						flightOrderDetailDto.getFlightOrderTicketCTMT().setDetailAuditStatus(this);
						break;
					case ISSUE:
						if(null==flightOrderDetailDto.getFlightOrderTicketIssue()){
							continue;
						}
						flightOrderDetailDto.getFlightOrderTicketIssue().setDetailAuditStatus(this);
						break;
					default:
						break;
				}	
			}
		}
	}
}
