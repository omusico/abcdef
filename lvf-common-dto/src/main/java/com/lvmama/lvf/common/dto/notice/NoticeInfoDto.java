package com.lvmama.lvf.common.dto.notice;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.NoticeType;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.EffectDates;

public class NoticeInfoDto extends Entity implements Serializable {

    private static final long serialVersionUID = -7904738785664009150L;

    private NoticeRuleDto noticeRule = new NoticeRuleDto();
    
    /**
     * 通知消息
     */
    private String noticeContent;
    /**
     * 通知类型
     */
    private NoticeType noticeType;
    /**
     * 通知链接的url
     */
    private String noticeUrl;
    
    private VisibleStatus visibleStatus = VisibleStatus.VISIBLE;
    
    public NoticeInfoDto(){
		
   	}
   	
   	public NoticeInfoDto(NoticeRuleDto noticeRule) {
   		super();
   		this.noticeRule = noticeRule;
   	}

    public NoticeRuleDto getNoticeRule() {
        return noticeRule;
    }

    public void setNoticeRule(NoticeRuleDto noticeRule) {
        this.noticeRule = noticeRule;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl;
    }

	public VisibleStatus getVisibleStatus() {
		return visibleStatus;
	}

	public void setVisibleStatus(VisibleStatus visibleStatus) {
		this.visibleStatus = visibleStatus;
	}

	public ActiveStatus getActiveStatus() {
		return noticeRule.getActiveStatus();
	}

	public String getSequence() {
		return noticeRule.getSequence();
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		noticeRule.setActiveStatus(activeStatus);
	}

	public EffectDates getEffectDates() {
		return noticeRule.getEffectDates();
	}

	public String getSearchEffectDates() {
		return noticeRule.getSearchEffectDates();
	}

	public void setEffectDates(EffectDates effectDates) {
		noticeRule.setEffectDates(effectDates);
	}

	public void setSearchEffectDates(String searchEffectDates) {
		noticeRule.setSearchEffectDates(searchEffectDates);
	}

	public Date getCreateTime() {
		return noticeRule.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		noticeRule.setCreateTime(createTime);
	}

	public String getDepStartDates() {
		return noticeRule.getDepStartDates();
	}

	public Date getUpdateTime() {
		return noticeRule.getUpdateTime();
	}

	public void setDepStartDates(String depStartDates) {
		noticeRule.setDepStartDates(depStartDates);
	}

	public void setUpdateTime(Date updateTime) {
		noticeRule.setUpdateTime(updateTime);
	}

	public String getIncludeAirLineCitys() {
		return noticeRule.getIncludeAirLineCitys();
	}

	public void setIncludeAirLineCitys(String includeAirLineCitys) {
		noticeRule.setIncludeAirLineCitys(includeAirLineCitys);
	}

	public String getExcludeAirLineCitys() {
		return noticeRule.getExcludeAirLineCitys();
	}

	public void setExcludeAirLineCitys(String excludeAirLineCitys) {
		noticeRule.setExcludeAirLineCitys(excludeAirLineCitys);
	}

	public String getAllAirLineCitys() {
		return noticeRule.getAllAirLineCitys();
	}

	public void setAllAirLineCitys(String allAirLineCitys) {
		noticeRule.setAllAirLineCitys(allAirLineCitys);
	}

	public String getWeekDays() {
		return noticeRule.getWeekDays();
	}

	public void setWeekDays(String weekDays) {
		noticeRule.setWeekDays(weekDays);
	}

	public Long getPriority() {
		return noticeRule.getPriority();
	}

	public void setPriority(Long priority) {
		noticeRule.setPriority(priority);
	}

	public Long getId() {
		return noticeRule.getId();
	}

	public void setId(Long id) {
		noticeRule.setId(id);
	}

	public String getAirLineCitys() {
		return noticeRule.getAirLineCitys();
	}

	public void setAirLineCitys(String airLineCitys) {
		noticeRule.setAirLineCitys(airLineCitys);
	}
	
   
}
