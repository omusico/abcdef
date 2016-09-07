package com.lvmama.lvf.common.trace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TraceExtendHandler {

	public void execute(HttpServletRequest request,
			HttpServletResponse response);
	
}
