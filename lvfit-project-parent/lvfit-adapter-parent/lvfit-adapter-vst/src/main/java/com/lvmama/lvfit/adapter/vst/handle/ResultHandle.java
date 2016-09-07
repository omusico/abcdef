package com.lvmama.lvfit.adapter.vst.handle;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * ClassName: ResultHandle <br/>
 * date: 2015-11-12 下午1:46:49 <br/>
 *
 * @author liuweiguo
 * @version 
 * @since JDK 1.6
 */
public class ResultHandle implements Serializable {
	private static final long serialVersionUID = 4243458760743568419L;
	private static final Logger logger = LoggerFactory.getLogger(ResultHandle.class);
	private boolean success = true;
	private String msg;

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.success = false;
		this.msg = msg;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	public boolean isFail() {
		return !isSuccess();
	}

	public ResultHandle() {
	}

	public ResultHandle(String msg) {
		setMsg(msg);
	}

	public void setMsg(Exception ex) {
		setMsg(ex.getMessage());
		if (logger.isDebugEnabled()) {
			ex.printStackTrace();
		} else if (ex instanceof NullPointerException
				|| ex instanceof IllegalArgumentException) {
			ex.printStackTrace();
		}
	}
}
