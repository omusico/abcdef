package com.lvmama.lvfit.common.dto.status.engine;

import java.util.List;

import com.lvmama.lvfit.common.dto.status.Op;


public interface FitOrderOpEngine {

	public List<Op> generatorOp(OpContext context);
	
}
