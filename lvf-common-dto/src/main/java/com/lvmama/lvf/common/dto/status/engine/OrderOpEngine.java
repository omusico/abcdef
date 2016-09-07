package com.lvmama.lvf.common.dto.status.engine;

import java.util.List;

import com.lvmama.lvf.common.dto.status.Op;


public interface OrderOpEngine {

	public List<Op> generatorOp(OpContext context);
	
}
