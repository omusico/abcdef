package com.lvmama.lvf.common.dto.schedule;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;


public class DayLevelConfigDto extends Entity implements Serializable{
  
    /**
	 * 
	 */
	private static final long serialVersionUID = -6215418099164786312L;

	private Long tStartDay;

    private Long tEndDay;

    private String tLevel;


    public Long gettStartDay() {
        return tStartDay;
    }

    public void settStartDay(Long tStartDay) {
        this.tStartDay = tStartDay;
    }

    public Long gettEndDay() {
        return tEndDay;
    }

    public void settEndDay(Long tEndDay) {
        this.tEndDay = tEndDay;
    }

    public String gettLevel() {
        return tLevel;
    }

    public void settLevel(String tLevel) {
        this.tLevel = tLevel;
    }

}