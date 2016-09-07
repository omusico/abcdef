package com.lvmama.lvfit.common.dto.search.spot;

import java.io.Serializable;
import java.util.Date;

public class SpotQueryRequest  implements Serializable{

	private static final long serialVersionUID = 4009862099543575281L;
	
	/**酒店Id */
	private String hotelId;
	
	/**目的地Id*/
	private String destinationId;

	/**要查询的周边距离 */
	private double distance = 10;//默认10公里
	
	/**要查询的条数 */
	private int size = 5;//默认5条
	
	/**排序序列号 */
	private int sortNum=27;//默认 门票好评数降序
	
	/** 开始日期*/
	private Date startDate;
	
	/** 结束日期*/
	private Date endDate;
	
	/**游客人数 */
	private int visitorNum;

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getVisitorNum() {
		return visitorNum;
	}

	public void setVisitorNum(int visitorNum) {
		this.visitorNum = visitorNum;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}
	
	
}
