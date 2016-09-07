package com.lvmama.lvf.common.dto.enums;

import com.lvmama.lvf.common.dto.status.detail.DetailSuppAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;

/**
 * 供应商退废票状态
 * @author majun
 * @date   2015-3-31
 */
public enum SuppRefundStatus 
{
	UNKNOWN_STATUS("未知状态") 
	{
		@Override
		public DetailSuppAuditStatus computeDetailSuppAuditStatus() 
		{
			return DetailSuppAuditStatus.APPLY_SUPP_OP;
		}
		
		@Override
		public DetailTicketStatus computeDetailTicketStatus()
		{
			return DetailTicketStatus.APPLY_RTVT;
		}
	},
	REFUND_NEW_APPLY("新申请，待处理") 
	{
		@Override
		public DetailSuppAuditStatus computeDetailSuppAuditStatus() 
		{
			return DetailSuppAuditStatus.APPLY_SUPP_OP;
		}
		
		@Override
		public DetailTicketStatus computeDetailTicketStatus()
		{
			return DetailTicketStatus.APPLY_RTVT;
		}
	},
	SPECIAL_REFUND("特殊退票，需延时") 
	{
		@Override
		public DetailSuppAuditStatus computeDetailSuppAuditStatus() 
		{
			return DetailSuppAuditStatus.APPLY_SUPP_OP;
		}
		
		@Override
		public DetailTicketStatus computeDetailTicketStatus()
		{
			return DetailTicketStatus.APPLY_RTVT;
		}
	},
	AUDIT_PASS("审核通过，待退款") 
	{
		@Override
		public DetailSuppAuditStatus computeDetailSuppAuditStatus() 
		{
			return DetailSuppAuditStatus.APPLY_SUPP_OP;
		}
		
		@Override
		public DetailTicketStatus computeDetailTicketStatus()
		{
			return DetailTicketStatus.APPLY_RTVT;
		}
	},
	REFUND_SUCC("退款成功") 
	{
		@Override
		public DetailSuppAuditStatus computeDetailSuppAuditStatus() 
		{
			return DetailSuppAuditStatus.SUPP_OP_PASS;
		}
		
		@Override
		public DetailTicketStatus computeDetailTicketStatus()
		{
			return DetailTicketStatus.RTVT_SUCC;
		}
	},
	TICKET_DEVIL("无法退/废票") 
	{
		@Override
		public DetailSuppAuditStatus computeDetailSuppAuditStatus() 
		{
			return DetailSuppAuditStatus.SUPP_OP_REJECT;
		}
		
		@Override
		public DetailTicketStatus computeDetailTicketStatus()
		{
			return DetailTicketStatus.RTVT_FAIL;
		}
	},
	REFUND_FAIL("退款失败") 
	{
		@Override
		public DetailSuppAuditStatus computeDetailSuppAuditStatus()
		{
			return DetailSuppAuditStatus.SUPP_OP_REJECT;
		}
		
		@Override
		public DetailTicketStatus computeDetailTicketStatus()
		{
			return DetailTicketStatus.RTVT_FAIL;
		}
	};
	
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private SuppRefundStatus(String desc) {
		this.desc = desc;
	}
	
	/**
	 * 计算订单详情供应商审核状态
	 * @return	DetailSuppAuditStaus	订单详情供应商审核状态
	 */
	public abstract DetailSuppAuditStatus computeDetailSuppAuditStatus();
	
	/**
	 * 计算订单详细出退改状态
	 * @return	DetailTicketStatus		订单详细出退改状态
	 */
	public abstract DetailTicketStatus computeDetailTicketStatus();
}
