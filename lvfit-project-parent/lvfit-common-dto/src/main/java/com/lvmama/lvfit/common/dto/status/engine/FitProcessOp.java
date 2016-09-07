package com.lvmama.lvfit.common.dto.status.engine;


public interface FitProcessOp {

	public boolean vaild(StatusContext statusContext);
	public void processOp(StatusContext statusContext);

}
