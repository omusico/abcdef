/**   
* @Title: StatementStatus.java 
* @Package com.lvmama.lvf.common.dto.enums 
* @Description: TODO(..) 
* @author Chase_lv
* @date 2015年4月21日 下午5:04:29 
*/
package com.lvmama.lvfit.common.dto.enums;

/**   
 * @Title: StatementStatus.java 
 * @Package com.lvmama.lvf.common.dto.enums 
 * @Description: TODO(..) 
 * @author Chase_lv
 * @date 2015年4月21日 下午5:04:29 
 */
public enum StatementStatus {

	NORMAL("有效"),
	NOSETTLEMENT("不结算"),
	CANCEL("无效");
	
	private String cnName;

	private StatementStatus(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	

}
