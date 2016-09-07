package com.lvmama.lvfit.common.dto.status.engine;

import org.springframework.stereotype.Component;

@Component
public class FitOrderStatusEngineImpl implements FitOrderStatusEngine {

	@Override
	public void processOp(StatusContext context) {
		OrderStatusProcess.processOp(context);
	};
	
}
