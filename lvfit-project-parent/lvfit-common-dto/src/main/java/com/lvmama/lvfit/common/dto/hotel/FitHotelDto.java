package com.lvmama.lvfit.common.dto.hotel;

import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.vst.VstPropValue;

public class FitHotelDto implements Dto {
	/**
	 *  酒店规格
	 */
	private List<FitHotelRoomDto> hotelRooms ; //= new ArrayList<FitHotelRoomDto>();
	/**
	 *  酒店图片列表
	 */
	private List<FitHotelPicDto> picList ; //  = new ArrayList<FitHotelPicDto>();
	/**
	 * 酒店ID
	 */
	private Long id;
	/**
	 * 酒店地点ID
	 */
	private Long placeId;
	/**
	 * 酒店名称
	 */
	private String name;
	/**
	 * 酒店星级
	 */
	private String star ;
	/**
	 * 酒店地址
	 */
	private String address;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 纬度
	 */
	private String latitude;
	/**
	 * 酒店设施
	 */
	private List<VstPropValue> facilities ; // = new ArrayList<Map<String,Object>>();
	/**
	 * 周边交通
	 */
	private String traffic;
	/**
	 * 酒店电话
	 */
	private String telephone;
	/**
	 * 酒店简介
	 */
	private String description;
	/**
	 * 最早到店时间
	 */
	private String earliestArriveTime;
	/**
	 *  最晚离开时间
	 */
	private String latestLeaveTime;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public List<VstPropValue> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<VstPropValue> facilities) {
		this.facilities = facilities;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEarliestArriveTime() {
		return earliestArriveTime;
	}

	public void setEarliestArriveTime(String earliestArriveTime) {
		this.earliestArriveTime = earliestArriveTime;
	}

	public String getLatestLeaveTime() {
		return latestLeaveTime;
	}

	public void setLatestLeaveTime(String latestLeaveTime) {
		this.latestLeaveTime = latestLeaveTime;
	}

	public List<FitHotelRoomDto> getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(List<FitHotelRoomDto> hotelRooms) {
		this.hotelRooms = hotelRooms;
	}

	public List<FitHotelPicDto> getPicList() {
		return picList;
	}

	public void setPicList(List<FitHotelPicDto> picList) {
		this.picList = picList;
	}


}
