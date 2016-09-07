
package com.lvmama.lvf.common.form.md;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.NoticeType;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.notice.NoticeInfoDto;
import com.lvmama.lvf.common.dto.notice.NoticeRuleDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.EffectDates;
import com.lvmama.lvf.common.form.Form;
/**
 * 通知规则信息ResponseForm
 * @author yangyongni
 * @date  2015年9月9日
 */
public class NoticeInfoResponseForm implements Serializable, Form {

	private static final long serialVersionUID = 2451089514166088084L;
	
	private NoticeInfoDto noticeInfoDto = new NoticeInfoDto();
	
	/** 通知状态名称 */
	private String activeStatusName;
	/** 显示状态名称 */
	private String visibleStatusName;
	/** 通知类型名称 */
	private String noticeTypeName;
	
	public NoticeInfoResponseForm(NoticeInfoDto noticeInfoDto) {
		super();
		this.noticeInfoDto = noticeInfoDto;
	}

	public NoticeInfoDto getNoticeInfoDto() {
		return noticeInfoDto;
	}

	public void setNoticeInfoDto(NoticeInfoDto noticeInfoDto) {
		this.noticeInfoDto = noticeInfoDto;
	}
	
	public NoticeRuleDto getNoticeRule() {
		return noticeInfoDto.getNoticeRule();
	}

	public void setNoticeRule(NoticeRuleDto noticeRule) {
		noticeInfoDto.setNoticeRule(noticeRule);
	}

	public String getNoticeContent() {
		return noticeInfoDto.getNoticeContent();
	}

	public void setNoticeContent(String noticeContent) {
		noticeInfoDto.setNoticeContent(noticeContent);
	}

	public NoticeType getNoticeType() {
		return noticeInfoDto.getNoticeType();
	}

	public void setNoticeType(NoticeType noticeType) {
		noticeInfoDto.setNoticeType(noticeType);
	}

	public String getNoticeTypeName() {
		if(this.getNoticeType() != null)
			return this.getNoticeType().getCnName();
		return noticeTypeName;
	}

	public void setNoticeTypeName(String noticeTypeName) {
		this.noticeTypeName = noticeTypeName;
	}

	public String getNoticeUrl() {
		return noticeInfoDto.getNoticeUrl();
	}

	public void setNoticeUrl(String noticeUrl) {
		noticeInfoDto.setNoticeUrl(noticeUrl);
	}

	public String getUuid() {
		return noticeInfoDto.getUuid();
	}

	public void setUuid(String uuid) {
		noticeInfoDto.setUuid(uuid);
	}

	public VisibleStatus getVisibleStatus() {
		return noticeInfoDto.getVisibleStatus();
	}

	public void setVisibleStatus(VisibleStatus visibleStatus) {
		noticeInfoDto.setVisibleStatus(visibleStatus);
	}

	public String getVisibleStatusName() {
		if(this.getVisibleStatus() != null)
			return this.getVisibleStatus().getCnName();
		return visibleStatusName;
	}

	public void setVisibleStatusName(String visibleStatusName) {
		this.visibleStatusName = visibleStatusName;
	}

	public ActiveStatus getActiveStatus() {
		return noticeInfoDto.getActiveStatus();
	}

	public String getSequence() {
		return noticeInfoDto.getSequence();
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		noticeInfoDto.setActiveStatus(activeStatus);
	}

	public String getActiveStatusName() {
		if(this.getActiveStatus() != null)
			return this.getActiveStatus().getActiveStatus().getCnName();
		return activeStatusName;
	}

	public void setActiveStatusName(String activeStatusName) {
		this.activeStatusName = activeStatusName;
	}

	public EffectDates getEffectDates() {
		return noticeInfoDto.getEffectDates();
	}

	public String getSearchEffectDates() {
		return noticeInfoDto.getSearchEffectDates();
	}

	public void setEffectDates(EffectDates effectDates) {
		noticeInfoDto.setEffectDates(effectDates);
	}

	public void setSearchEffectDates(String searchEffectDates) {
		noticeInfoDto.setSearchEffectDates(searchEffectDates);
	}

	public Date getCreateTime() {
		return noticeInfoDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		noticeInfoDto.setCreateTime(createTime);
	}

	public String getDepStartDates() {
		return noticeInfoDto.getDepStartDates();
	}

	public Date getUpdateTime() {
		return noticeInfoDto.getUpdateTime();
	}

	public void setDepStartDates(String depStartDates) {
		noticeInfoDto.setDepStartDates(depStartDates);
	}

	public void setUpdateTime(Date updateTime) {
		noticeInfoDto.setUpdateTime(updateTime);
	}

	public String getIncludeAirLineCitys() {
		return noticeInfoDto.getIncludeAirLineCitys();
	}

	public void setIncludeAirLineCitys(String includeAirLineCitys) {
		noticeInfoDto.setIncludeAirLineCitys(includeAirLineCitys);
	}

	public String getExcludeAirLineCitys() {
		return noticeInfoDto.getExcludeAirLineCitys();
	}

	public void setExcludeAirLineCitys(String excludeAirLineCitys) {
		noticeInfoDto.setExcludeAirLineCitys(excludeAirLineCitys);
	}

	public String getAllAirLineCitys() {
		return noticeInfoDto.getAllAirLineCitys();
	}

	public void setAllAirLineCitys(String allAirLineCitys) {
		noticeInfoDto.setAllAirLineCitys(allAirLineCitys);
	}

	public String getWeekDays() {
		return noticeInfoDto.getWeekDays();
	}

	public void setWeekDays(String weekDays) {
		noticeInfoDto.setWeekDays(weekDays);
	}

	public Long getPriority() {
		return noticeInfoDto.getPriority();
	}

	public void setPriority(Long priority) {
		noticeInfoDto.setPriority(priority);
	}

	public Long getId() {
		return noticeInfoDto.getId();
	}

	public void setId(Long id) {
		noticeInfoDto.setId(id);
	}


}
