package com.lvmama.lvfit.common.dto;

/**
 * 请求异常对象
 * @author leizhengwei
 *
 */
public class RequestWithException {
	
	private Exception e;
	
	private Object request;

	public RequestWithException() {
		super();
	}

	public RequestWithException(Exception e, Object request) {
		super();
		this.e = e;
		this.request = request;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

	public Object getRequest() {
		return request;
	}

	public void setRequest(Object request) {
		this.request = request;
	}

}
