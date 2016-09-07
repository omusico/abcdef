package com.lvmama.lvf.common.dto.status;

import com.lvmama.lvf.common.dto.status.engine.OpContext;
import com.lvmama.lvf.common.dto.status.order.OrderStatusVaild;

public class Op {
	
	private OpSource opSource;
	private OpType opType;
	private OpAction opAction;
	private String desc;
	private String code;
	private OrderStatusVaild orderStatusVaild;
	private OpLevel opLevel;
	
	public Op() {
	}
	
	protected Op(String desc,OpSource opSource, OpType opType, OpAction opAction,OpLevel opLevel) {
		super();
		this.opSource = opSource;
		this.opType = opType;
		this.opAction = opAction;
		this.desc = desc;
		this.opLevel=opLevel;
		this.code = opSource.name()+"_"+opAction.name()+"_"+opType.name()+"_"+opLevel.name();
	}
	
	public boolean vaild(OpContext context){
	    return null==orderStatusVaild?true:orderStatusVaild.vaild(context);
	}
	
	public Op putVaild(OrderStatusVaild orderStatusVaild){
	    this.orderStatusVaild = orderStatusVaild;
	    return this;
	}

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public OpType getOpType() {
		return opType;
	}
	public void setOpType(OpType opType) {
		this.opType = opType;
	}
	public OpAction getOpAction() {
		return opAction;
	}
	public void setOpAction(OpAction opAction) {
		this.opAction = opAction;
	}
	public OpSource getOpSource() {
		return opSource;
	}
	public void setOpSource(OpSource opSource) {
		this.opSource = opSource;
	}
	
	public OpLevel getOpLevel() {
		return opLevel;
	}

	public void setOpLevel(OpLevel opLevel) {
		this.opLevel = opLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opAction == null) ? 0 : opAction.hashCode());
		result = prime * result
				+ ((opSource == null) ? 0 : opSource.hashCode());
		result = prime * result + ((opType == null) ? 0 : opType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Op other = (Op) obj;
		if (opAction != other.opAction)
			return false;
		if (opSource != other.opSource)
			return false;
		if (opType != other.opType)
			return false;
		if (opLevel != other.opLevel)
			return false;
		return true;
	}
	
	
}
