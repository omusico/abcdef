package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.NoticeType;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.notice.NoticeInfoDto;
import com.lvmama.lvf.common.dto.notice.NoticeRuleDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.EffectDates;
/**
 * 通知规则信息 Request
 * @author zhangzongshuang
 * @date 2015年9月7日
 */
public class NoticeInfoRequest implements Serializable, Dto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6267365021406810314L;

	private NoticeInfoDto noticeInfoDto = new NoticeInfoDto();
	/** 航班日期(毫秒数)*/
	private Long departureDate;
	/**出发城市 */
	private String departureCity;
	/**到达城市 */
	private String arrivalCity;
	/** 航班日期起*/
	private String departureStartTime;
	/** 航班日期止*/
	private String departureEndTime;
	/** 有效日期 */
	private String effectDateTime;
	/** 到期日期 */
	private String expireDateTime;
	/**通知规则信息 List*/
	private List<Long> ids = new ArrayList<Long>();
	/**显示的通知的条数*/
	private int noticeCount;
	
	public NoticeInfoDto getNoticeInfoDto() {
		return noticeInfoDto;
	}
	public void setNoticeInfoDto(NoticeInfoDto noticeInfoDto) {
		this.noticeInfoDto = noticeInfoDto;
	}
	public String getDepartureStartTime() {
		return departureStartTime;
	}
	public void setDepartureStartTime(String departureStartTime) {
		this.departureStartTime = departureStartTime;
	}
	public String getDepartureEndTime() {
		return departureEndTime;
	}
	public void setDepartureEndTime(String departureEndTime) {
		this.departureEndTime = departureEndTime;
	}
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
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
	public String getNoticeUrl() {
		return noticeInfoDto.getNoticeUrl();
	}
	public void setNoticeUrl(String noticeUrl) {
		noticeInfoDto.setNoticeUrl(noticeUrl);
	}
	public VisibleStatus getVisibleStatus() {
		return noticeInfoDto.getVisibleStatus();
	}
	public void setVisibleStatus(VisibleStatus visibleStatus) {
		noticeInfoDto.setVisibleStatus(visibleStatus);
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
	public Long getId() {
		return noticeInfoDto.getId();
	}
	public void setId(Long id) {
		noticeInfoDto.setId(id);
	}
	public EffectDates getEffectDates() {
		return noticeInfoDto.getEffectDates();
	}
	public String getUuid() {
		return noticeInfoDto.getUuid();
	}
	public String getSearchEffectDates() {
		return noticeInfoDto.getSearchEffectDates();
	}
	public void setUuid(String uuid) {
		noticeInfoDto.setUuid(uuid);
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
	public Long getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Long departureDate) {
		this.departureDate = departureDate;
	}
	
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getEffectDateTime() {
		return effectDateTime;
	}
	public void setEffectDateTime(String effectDateTime) {
		this.effectDateTime = effectDateTime;
	}
	public String getExpireDateTime() {
		return expireDateTime;
	}
	public void setExpireDateTime(String expireDateTime) {
		this.expireDateTime = expireDateTime;
	}
	public int getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	public String getAirLineCitys() {
		return noticeInfoDto.getAirLineCitys();
	}
	public void setAirLineCitys(String airLineCitys) {
		noticeInfoDto.setAirLineCitys(airLineCitys);
	}
	
}
