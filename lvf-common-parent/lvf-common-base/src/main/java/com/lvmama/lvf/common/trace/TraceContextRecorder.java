package com.lvmama.lvf.common.trace;

public interface TraceContextRecorder {

	public void log(String code, String target,String suppCode,String ip,String traceNo,String serverTrace,String serverTraceTime
	,String errorMessage,Boolean result);

}