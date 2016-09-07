package com.lvmama.lvf.common.dto.other;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.AttachmentType;

public class AttachmentDto extends Entity implements Serializable {

	private static final long serialVersionUID = 373298073217595218L;
    
	private String name;
	
	private AttachmentType attachmentType;
	
	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttachmentType getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(AttachmentType attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
