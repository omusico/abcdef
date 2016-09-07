package com.lvmama.lvf.common.dto.schedule;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;



public class TimePeriodConfigDto extends Entity implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6977139491499614413L;

	private Long seq;

    private Long startHour;

    private Long endHour;

    private Long period;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getStartHour() {
		return startHour;
	}

	public void setStartHour(Long startHour) {
		this.startHour = startHour;
	}

	public Long getEndHour() {
		return endHour;
	}

	public void setEndHour(Long endHour) {
		this.endHour = endHour;
	}

	public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }


}