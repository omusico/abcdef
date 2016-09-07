package com.lvmama.lvf.common.dto.status.detail;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.OpCommandFront;
import com.lvmama.lvf.common.dto.status.TicketStatusType;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 订单详细出退改状态枚举
 * @author majun
 * @date   2015-1-28
 */
public enum DetailTicketStatus implements ProcessOp{
	
	NULL("",TicketStatusType.ISSUE),
	NOT_ISSUE("未出票", TicketStatusType.ISSUE){
		
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_PAY.equals(statusContext.getOp());
		}
	},
	APPLY_ISSUE("申请出票",TicketStatusType.ISSUE){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_ISSUE.equals(statusContext.getOp());
		}
	},
	ISSUE_SUCC("出票成功",TicketStatusType.ISSUE) {
		
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_ISSUE.equals(statusContext.getOp());
		}
	},
	ISSUE_FAIL("出票失败", TicketStatusType.ISSUE) {
		
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.AUDIT_REJECT_ISSUE.equals(statusContext.getOp())
					||OpCommandBack.OP_REJECT_ISSUE.equals(statusContext.getOp());
		}

	},
	APPLY_CTMT("申请变更",TicketStatusType.CTMT){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_CTMT.equals(statusContext.getOp())
					||OpCommandFront.APPLY_CTMT.equals(statusContext.getOp());
		}
	},
	CTMT_SUCC("变更成功", TicketStatusType.CTMT) {
		
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.OP_PASS_CTMT.equals(statusContext.getOp());
		}
		
	},
	CTMT_FAIL("变更失败", TicketStatusType.CTMT){
		
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.AUDIT_REJECT_CTMT.equals(statusContext.getOp())
					||OpCommandBack.OP_REJECT_CTMT.equals(statusContext.getOp());
		}		
		
	},
	APPLY_RTVT("申请退票",TicketStatusType.RTVT){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_RTVT.equals(statusContext.getOp())
					||OpCommandFront.APPLY_RTVT.equals(statusContext.getOp());
		}
	},
	RTVT_SUCC("退票成功",TicketStatusType.RTVT){
		
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.OP_PASS_RTVT.equals(statusContext.getOp());
		}	
	},
	RTVT_FAIL("退票失败",TicketStatusType.RTVT){
		
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.AUDIT_REJECT_RTVT.equals(statusContext.getOp())
				||OpCommandBack.OP_REJECT_RTVT.equals(statusContext.getOp());
		}
		
	};
	

	private String cnName;
	private TicketStatusType type;
	
	public static DetailTicketStatus[] getStatus(TicketStatusType ticketStatusType){
		
		List<DetailTicketStatus> detailTicketStatuss  = new ArrayList<DetailTicketStatus>();
		
		for(DetailTicketStatus detailTicketStatus : DetailTicketStatus.values())
		{
			if(detailTicketStatus.getType() == ticketStatusType)
				detailTicketStatuss.add(detailTicketStatus);
		}
		return detailTicketStatuss.toArray(new DetailTicketStatus[detailTicketStatuss.size()]);
	}

	public TicketStatusType getType() {
		return type;
	}

	public void setType(TicketStatusType type) {
		this.type = type;
	}

	private DetailTicketStatus(String cnName, TicketStatusType type) {
		this.cnName = cnName;
		this.type = type;
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
				flightOrderDetailDto.setDetailTicketStatus(this);
				
				if(null!=flightOrderDetailDto.getFlightOrderTicketInfo())
				{
					flightOrderDetailDto.getFlightOrderTicketInfo().setDetailTicketStatus(this);;
				}
				
				switch (statusContext.getOp().getOpType()) 
				{
					case RTVT:
						if(null==flightOrderDetailDto.getFlightOrderDetailRTVT()){
							continue;
						}
						flightOrderDetailDto.getFlightOrderDetailRTVT().setDetailTicketStatus(this);
						break;
					case CTMT:
						if(null==flightOrderDetailDto.getFlightOrderTicketCTMT()){
							continue;
						}
						flightOrderDetailDto.getFlightOrderTicketCTMT().setDetailTicketStatus(this);
						break;
					case ISSUE:
						if(null==flightOrderDetailDto.getFlightOrderTicketIssue()){
							continue;
						}
						flightOrderDetailDto.getFlightOrderTicketIssue().setDetailTicketStatus(this);
						break;
					default:
						break;
			}
			}
		}
	}
	
}
