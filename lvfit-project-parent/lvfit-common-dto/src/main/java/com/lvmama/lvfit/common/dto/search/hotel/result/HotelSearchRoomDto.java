package com.lvmama.lvfit.common.dto.search.hotel.result;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvfit.common.dto.vst.VstBranch;

public class HotelSearchRoomDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3020015627395080179L;

	private VstBranch branch = new VstBranch();

	// 规格ID
	private String branchId;
	// 产品ID
	private String productId;
	// 规格名称
	private String branchName;
	// 推荐级别
	private String branchSeq;
	// 面积
	private String area;
	// 楼层
	private String floor;
	// 床型
	private String bedType;
	// 是否可以加床
	private String extraBed;

	
	private String roomName;
	// 宽带（有、无、收费）
	private String broadband;
	// 无烟房（有无烟房、有无烟楼层、该房可做无烟处理）
	private String nonSmoking;
	// 描述
	private String branchDesc;
	// 图片URL
	private String photoUrl;
	// 图片内容
	private String photoContent;
	// 最多入住人数
	private String maxVisitor;
	// 窗户
	private String window;
	//预定房间数量
	private Integer roomCounts;

	List<HotelSearchPlanDto> plans;

	
	//是否选中
	private boolean selectedFlag = false;


	public VstBranch getBranch() {
		return branch;
	}

	public void setBranch(VstBranch branch) {
		this.branch = branch;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getExtraBed() {
		return extraBed;
	}

	public void setExtraBed(String extraBed) {
		this.extraBed = extraBed;
	}

	public String getBroadband() {
		return broadband;
	}

	public void setBroadband(String broadband) {
		this.broadband = broadband;
	}

	public String getNonSmoking() {
		return nonSmoking;
	}

	public void setNonSmoking(String nonSmoking) {
		this.nonSmoking = nonSmoking;
	}

	public String getBranchDesc() {
		return branchDesc;
	}

	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoContent() {
		return photoContent;
	}

	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}

	public List<HotelSearchPlanDto> getPlans() {
		return plans;
	}

	public void setPlans(List<HotelSearchPlanDto> plans) {
		this.plans = plans;
	}

	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchSeq() {
		return branchSeq;
	}

	public void setBranchSeq(String branchSeq) {
		this.branchSeq = branchSeq;
	}

	public String getMaxVisitor() {
		return maxVisitor;
	}

	public void setMaxVisitor(String maxVisitor) {
		this.maxVisitor = maxVisitor;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}
	
	public boolean getSelectedFlag() {
		return selectedFlag;
	}

	public void setSelectedFlag(boolean selectedFlag) {
		this.selectedFlag = selectedFlag;
	}

	public Integer getRoomCounts() {
		return roomCounts;
	}

	public void setRoomCounts(Integer roomCounts) {
		this.roomCounts = roomCounts;
	}
    
}
