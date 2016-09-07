package com.lvmama.lvf.common.event;


public interface EventListener {
	
	public void register();
	public void handler(Event event,Object context);
	
}
