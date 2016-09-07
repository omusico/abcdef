package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.CRUDType;
import com.lvmama.lvf.common.dto.md.SeatRule;

public class SeatRuleRequest implements Serializable,Dto{

	private static final long serialVersionUID = -7934748788381339899L;

	private SeatRule seatRule;
	
	private CRUDType crudType;
	


	public SeatRule getSeatRule() {
		return seatRule;
	}




	public void setSeatRule(SeatRule seatRule) {
		this.seatRule = seatRule;
	}




	public CRUDType getCrudType() {
		return crudType;
	}




	public void setCrudType(CRUDType crudType) {
		this.crudType = crudType;
	}




	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}