package com.lvmama.lvf.common.dto.request;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.NoticeType;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.notice.NoticeInfoDto;
import com.lvmama.lvf.common.dto.notice.NoticeRuleDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.EffectDates;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;

public class NoticeInfoQueryRequest implements Serializable, Dto {

    private static final long serialVersionUID = 7718925030635887498L;

    private NoticeInfoDto noticeInfoDto = new NoticeInfoDto();

    @Override
    public Long getId() {
        return noticeInfoDto.getId();
    }

    public NoticeRuleDto getNoticeRule() {
        return noticeInfoDto.getNoticeRule();
    }

    public void setUpdateTime(Date updateTime) {
        noticeInfoDto.setUpdateTime(updateTime);
    }

    public void setAllAirLineCitys(String allAirLineCitys) {
        noticeInfoDto.setAllAirLineCitys(allAirLineCitys);
    }

    public String getWeekDays() {
        return noticeInfoDto.getWeekDays();
    }

    public VisibleStatus getVisibleStatus() {
        return noticeInfoDto.getVisibleStatus();
    }

    public Date getUpdateTime() {
        return noticeInfoDto.getUpdateTime();
    }

    public void setPriority(Long priority) {
        noticeInfoDto.setPriority(priority);
    }

    public void setNoticeUrl(String noticeUrl) {
        noticeInfoDto.setNoticeUrl(noticeUrl);
    }

    public void setEffectDates(EffectDates effectDates) {
        noticeInfoDto.setEffectDates(effectDates);
    }

    public void setIncludeAirLineCitys(String includeAirLineCitys) {
        noticeInfoDto.setIncludeAirLineCitys(includeAirLineCitys);
    }

    public void setPtype(PersistenceType ptype) {
        noticeInfoDto.setPtype(ptype);
    }

    public String getExcludeAirLineCitys() {
        return noticeInfoDto.getExcludeAirLineCitys();
    }

    public String getNoticeUrl() {
        return noticeInfoDto.getNoticeUrl();
    }

    public String getIncludeAirLineCitys() {
        return noticeInfoDto.getIncludeAirLineCitys();
    }

    public NoticeType getNoticeType() {
        return noticeInfoDto.getNoticeType();
    }

    public String getAllAirLineCitys() {
        return noticeInfoDto.getAllAirLineCitys();
    }

    public Date getCreateTime() {
        return noticeInfoDto.getCreateTime();
    }

    public Long getPriority() {
        return noticeInfoDto.getPriority();
    }

    public ActiveStatus getActiveStatus() {
        return noticeInfoDto.getActiveStatus();
    }

    public void setExcludeAirLineCitys(String excludeAirLineCitys) {
        noticeInfoDto.setExcludeAirLineCitys(excludeAirLineCitys);
    }

    public String getUuid() {
        return noticeInfoDto.getUuid();
    }


    public void setActiveStatus(ActiveStatus activeStatus) {
        noticeInfoDto.setActiveStatus(activeStatus);
    }

    public void setVisibleStatus(VisibleStatus visibleStatus) {
        noticeInfoDto.setVisibleStatus(visibleStatus);
    }

    public void setId(Long id) {
        noticeInfoDto.setId(id);
    }

    public void setSearchEffectDates(String searchEffectDates) {
        noticeInfoDto.setSearchEffectDates(searchEffectDates);
    }

    public void setDepStartDates(String depStartDates) {
        noticeInfoDto.setDepStartDates(depStartDates);
    }

    public void setNoticeContent(String noticeContent) {
        noticeInfoDto.setNoticeContent(noticeContent);
    }


    public String getSequence() {
        return noticeInfoDto.getSequence();
    }

    public String getDepStartDates() {
        return noticeInfoDto.getDepStartDates();
    }

    public EffectDates getEffectDates() {
        return noticeInfoDto.getEffectDates();
    }

    public void setWeekDays(String weekDays) {
        noticeInfoDto.setWeekDays(weekDays);
    }

    @JsonIgnore
    @XmlTransient
    public PersistenceType getPtype() {
        return noticeInfoDto.getPtype();
    }

    public void setCreateTime(Date createTime) {
        noticeInfoDto.setCreateTime(createTime);
    }

    public String getNoticeContent() {
        return noticeInfoDto.getNoticeContent();
    }

    public void setNoticeType(NoticeType noticeType) {
        noticeInfoDto.setNoticeType(noticeType);
    }

    public String getSearchEffectDates() {
        return noticeInfoDto.getSearchEffectDates();
    }

    public void setNoticeRule(NoticeRuleDto noticeRule) {
        noticeInfoDto.setNoticeRule(noticeRule);
    }

    public void setUuid(String uuid) {
        noticeInfoDto.setUuid(uuid);
    }
}
