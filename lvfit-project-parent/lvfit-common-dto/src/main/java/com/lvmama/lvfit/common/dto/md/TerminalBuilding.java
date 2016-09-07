package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;

public class TerminalBuilding extends NameCode implements Serializable {
	
	/**机场 */
	private Airport airport;
	
	/**描述 */
	private String desc;
	
	public Airport getAirport() {
		return airport;
	}
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
