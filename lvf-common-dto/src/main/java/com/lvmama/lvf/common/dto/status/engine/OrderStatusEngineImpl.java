package com.lvmama.lvf.common.dto.status.engine;

import org.springframework.stereotype.Component;

@Component
public class OrderStatusEngineImpl implements OrderStatusEngine {

	@Override
	public void processOp(StatusContext context) {
		OrderStatusProcess.processOp(context);
	};
	
}
