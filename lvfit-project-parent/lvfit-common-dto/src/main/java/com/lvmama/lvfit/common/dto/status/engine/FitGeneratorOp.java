package com.lvmama.lvfit.common.dto.status.engine;

import java.util.List;

import com.lvmama.lvfit.common.dto.status.Op;

public interface FitGeneratorOp {

	public List<Op> generatorFrontOp(OpContext opContext);
	
	public List<Op> generatorBackOp(OpContext opContext);
	
	public List<Op> generatorOp(OpContext opContext);
	
}
