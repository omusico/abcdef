package com.lvmama.lvf.common.dto.notice;

import com.lvmama.lvf.common.dto.AEEntity;

import java.io.Serializable;

public class NoticeRuleDto extends AEEntity implements Serializable {

    private static final long serialVersionUID = 5092202990403061729L;
    /**
     * 查询所处的时间段.
     */
    private String searchEffectDates;
    /**
     * 航班起飞时间.
     */
    private String depStartDates;
    /**
     * 包含飞抵城市(style: 起飞城市,抵达城市;)
     */
    private String includeAirLineCitys;
    /**
     * 不包含飞抵城市 (style: 不包含的起飞城市, 不包含的抵达城市;)
     */
    private String excludeAirLineCitys;
    /**
     * 全选飞抵城市(style: A,抵达城市; 起飞城市, A; A, A;)
     */
    private String allAirLineCitys;
    /**
     * 航班起抵城市.
     */
    private String airLineCitys;
    /**
     * 适用班期
     */
    private String weekDays;
    /**
     * 优先级别（0~2）
     */
    private Long priority;

    public String getSearchEffectDates() {
        return searchEffectDates;
    }

    public void setSearchEffectDates(String searchEffectDates) {
        this.searchEffectDates = searchEffectDates;
    }

    public String getDepStartDates() {
        return depStartDates;
    }

    public void setDepStartDates(String depStartDates) {
        this.depStartDates = depStartDates;
    }

    public String getIncludeAirLineCitys() {
        return includeAirLineCitys;
    }

    public void setIncludeAirLineCitys(String includeAirLineCitys) {
        this.includeAirLineCitys = includeAirLineCitys;
    }

    public String getExcludeAirLineCitys() {
        return excludeAirLineCitys;
    }

    public void setExcludeAirLineCitys(String excludeAirLineCitys) {
        this.excludeAirLineCitys = excludeAirLineCitys;
    }

    public String getAirLineCitys() {
        return airLineCitys;
    }

    public void setAirLineCitys(String airLineCitys) {
        this.airLineCitys = airLineCitys;
    }

    public String getAllAirLineCitys() {
        return allAirLineCitys;
    }

    public void setAllAirLineCitys(String allAirLineCitys) {
        this.allAirLineCitys = allAirLineCitys;
    }

    public String getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(String weekDays) {
        this.weekDays = weekDays;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
