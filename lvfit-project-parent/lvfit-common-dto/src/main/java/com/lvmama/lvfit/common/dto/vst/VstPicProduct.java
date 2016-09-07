package com.lvmama.lvfit.common.dto.vst;

public class VstPicProduct {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private Long photoId;			//图片ID
	private String photoUrl;		//图片URL
	private String photoDesc;  //图片描述
	private Long objectId;			//该图片关联的产品ID：如酒店、景点等。 
	private Integer flag;				//比例标识：1(3:2)；2(5:2)
	public Long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getPhotoDesc() {
		return photoDesc;
	}
	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}
	public Long getObjectId() {
		return objectId;
	}
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
