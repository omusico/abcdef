package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.form.Form;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FlightOrderImportExcelForm implements Form {

	private CommonsMultipartFile execFile;

	private String status;

	public CommonsMultipartFile getExecFile() {
		return execFile;
	}

	public void setExecFile(CommonsMultipartFile execFile) {
		this.execFile = execFile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
