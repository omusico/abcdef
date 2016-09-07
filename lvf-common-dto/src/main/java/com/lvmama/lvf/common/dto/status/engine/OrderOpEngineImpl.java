package com.lvmama.lvf.common.dto.status.engine;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.status.Op;

@Component
public class OrderOpEngineImpl implements OrderOpEngine {

	public List<Op> generatorOp(OpContext context){
		return OrderOpGenerator.generatorOp(context);
	};
	
}
