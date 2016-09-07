package com.lvmama.lvf.common.adapter.ws;

import java.lang.reflect.Method;

public interface ServiceHandler {
	public Object execute(Method method,Object[] args) throws Exception; 
}
