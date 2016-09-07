package com.lvmama.lvf.common.dto.flight;

import com.lvmama.lvf.common.utils.DateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightSearchExcludeConditionDto implements Serializable {

    private static final long serialVersionUID = 8405141552436722222L;

    private String carrier;

    private String workStartTime;

    private String workEndTime;

    private int leadDayMin;

    private int leadDayMax;

    private List<String> suppCode = new ArrayList<String>();

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public List<String> getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(List<String> suppCode) {
        this.suppCode = suppCode;
    }

    public int getLeadDayMin() {
        return leadDayMin;
    }

    public void setLeadDayMin(int leadDayMin) {
        this.leadDayMin = leadDayMin;
    }

    public int getLeadDayMax() {
        return leadDayMax;
    }

    public void setLeadDayMax(int leadDayMax) {
        this.leadDayMax = leadDayMax;
    }

    public Boolean isWorkTime() {
        Date now = new Date();
        String nowDate =  DateUtils.formatDate(now);
        if (now.after(DateUtils.parseCnHmDate(nowDate + " " + this.workStartTime + ":00")) && now.before(DateUtils.parseCnHmDate(nowDate + " " + this.workEndTime + ":00"))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean containSuppCode(String suppCode) {
        return this.getSuppCode().contains(suppCode);
    }

    public Boolean isInLeadDay(Date departureTime) {
        int day = (int) DateUtils.getDateDiffByDay(DateUtils.formatDate(departureTime), DateUtils.formatDate(new Date()));
        if (day >= this.leadDayMin && day <= this.leadDayMax) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
