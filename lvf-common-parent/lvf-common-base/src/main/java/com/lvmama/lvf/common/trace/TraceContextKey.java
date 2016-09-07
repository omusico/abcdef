package com.lvmama.lvf.common.trace;

public enum TraceContextKey {
	
	OPER("操作人",new ThreadLocal<String>()),
	CUSTOMER("用户",new ThreadLocal<String>()),
	IP("原始请求IP",new ThreadLocal<String>()),
	TRACENO("追踪流水号",new ThreadLocal<String>()),
	SERVERIPTRACE("服务器IP追踪",new ThreadLocal<String>()),
	SERVERTIMETRACE("服务器访问时间追踪",new ThreadLocal<String>()),
	NOTLOGGING("是否记录日志",new ThreadLocal<String>());
	
	private String cnName;
	private ThreadLocal<String> context;
	
	public ThreadLocal<String> getContext() {
		return context;
	}

	public String getCnName() {
		return cnName;
	}

	private TraceContextKey(String cnName, ThreadLocal<String> context) {
		this.cnName = cnName;
		this.context = context;
	}

	public String get() {
		return context.get();
	}

	public void set(String value) {
		context.set(value);
	}

	public void remove() {
		context.remove();
	}
	
	
	
}
