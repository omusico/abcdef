package com.lvmama.lvf.common.dto.status.engine;


public interface ProcessOp {

	public boolean vaild(StatusContext statusContext);
	public void processOp(StatusContext statusContext);

}
