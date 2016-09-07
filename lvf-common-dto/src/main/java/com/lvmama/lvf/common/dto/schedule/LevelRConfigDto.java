package com.lvmama.lvf.common.dto.schedule;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;


public class LevelRConfigDto extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2528287802198327760L;

	private String hotLevel;

    private String tLevel;

    private Long levelValue;

    public String getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(String hotLevel) {
        this.hotLevel = hotLevel;
    }

    public String gettLevel() {
        return tLevel;
    }

    public void settLevel(String tLevel) {
        this.tLevel = tLevel;
    }

    public Long getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(Long levelValue) {
        this.levelValue = levelValue;
    }

}