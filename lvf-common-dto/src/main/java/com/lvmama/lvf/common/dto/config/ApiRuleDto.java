package com.lvmama.lvf.common.dto.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.enums.InterfaceType;
import com.lvmama.lvf.common.dto.enums.WeekDay;

public class ApiRuleDto extends AEEntity implements Serializable{

	private static final long serialVersionUID = 5152946138610346714L;
	
	/**接口名*/
	private String interfaceName;

	/**接口类型*/
	private InterfaceType interfaceType;
	
	/**接口标识*/ 
	private InterfaceKey interfaceKey;
	
	/**供应商code*/  
	private String suppCode;
	
	/**开始时刻*/  
	private Integer startHour;
	
	private Integer endHour;
	
	/**周期*/
	private String weekDays;
	
	/**回调 :YES  NO*/   
	private String callBack;
	
	@JsonIgnore
	public List<WeekDay> getEveryDay(){
		List<WeekDay> everyDays= new ArrayList<WeekDay>();
		String[] str = weekDays.split(",");
		for (int i = 0; i < str.length; i++) {
			everyDays.add(WeekDay.getWeekDayBycnName(str[i]));
		}
		return everyDays;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public InterfaceType getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(InterfaceType interfaceType) {
		this.interfaceType = interfaceType;
	}



	public InterfaceKey getInterfaceKey() {
		return interfaceKey;
	}


	public void setInterfaceKey(InterfaceKey interfaceKey) {
		this.interfaceKey = interfaceKey;
	}


	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	public String getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}

	public String getCallBack() {
		return callBack;
	}

	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}


	

	
	
	
	
	
	
	

}
