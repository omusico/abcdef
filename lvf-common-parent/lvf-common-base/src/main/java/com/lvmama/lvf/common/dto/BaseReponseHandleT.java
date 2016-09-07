package com.lvmama.lvf.common.dto;

/**   
* @Title: BaseReponseHandleT.java 
* @Package com.lvmama.lvf.common.dto 
* @Description: 返回结果包含对象、结果状态、错误信息等
* @author Chase_lv
* @date 2015年4月21日 下午8:51:14 
*/
@Deprecated
public class BaseReponseHandleT<T> extends BaseReponseHandle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1659756744704552675L;
	
	/** 实际返回对象 */
	//@XmlTransien
	private T result;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
