package com.lvmama.lvfit.common.dto.status.engine;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lvmama.lvfit.common.dto.status.Op;

@Component
public class FitOrderOpEngineImpl implements FitOrderOpEngine {

	public List<Op> generatorOp(OpContext context){
		return FitOrderOpGenerator.generatorOp(context);
	};
	
}
