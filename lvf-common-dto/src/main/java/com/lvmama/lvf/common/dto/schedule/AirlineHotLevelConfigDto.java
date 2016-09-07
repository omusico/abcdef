package com.lvmama.lvf.common.dto.schedule;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;

public class AirlineHotLevelConfigDto extends Entity implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4853429991684138610L;


    private String depCityCode;

    private String arrCityCode;

    private String hotLevel;


    public String getDepCityCode() {
        return depCityCode;
    }

    public void setDepCityCode(String depCityCode) {
        this.depCityCode = depCityCode;
    }

    public String getArrCityCode() {
        return arrCityCode;
    }

    public void setArrCityCode(String arrCityCode) {
        this.arrCityCode = arrCityCode;
    }

    public String getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(String hotLevel) {
        this.hotLevel = hotLevel;
    }
  
}