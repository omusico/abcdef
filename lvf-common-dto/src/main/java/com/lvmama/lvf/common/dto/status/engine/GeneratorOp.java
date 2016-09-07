package com.lvmama.lvf.common.dto.status.engine;

import java.util.List;

import com.lvmama.lvf.common.dto.status.Op;

public interface GeneratorOp {

	public List<Op> generatorFrontOp(OpContext opContext);
	
	public List<Op> generatorBackOp(OpContext opContext);
	
	public List<Op> generatorOp(OpContext opContext);
	
}
