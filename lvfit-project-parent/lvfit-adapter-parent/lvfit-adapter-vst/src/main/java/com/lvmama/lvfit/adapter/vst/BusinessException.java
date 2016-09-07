package com.lvmama.lvfit.adapter.vst;

/**
 * 自定义异常
 * @author xiexun
 *
 */
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1724053078501512938L;
	
	private String message;

	public BusinessException(String message, String... paras) {
		this.message = String.format(message, paras);
	}

	public BusinessException(String message) {
		this.message = message;
	}
	public BusinessException(String message,Throwable throwable) {
		super(message, throwable);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
