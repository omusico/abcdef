package com.lvmama.lvf.common.dto.order.verify;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.supp.SuppFlightProductDto;

@XmlRootElement
public class FlightBookingVerifyInfosDto extends AEEntity implements Serializable {

	private static final long serialVersionUID = 1062707949509569179L;
	
	/**是否验仓失败 */
	private boolean isVerifyFail;
	
	/**政策及运价信息 */
	private List<FlightBookingVerifyInfoDto> flightBookingVerifyInfos;
	
	private SuppFlightProductDto suppFlightProductDto;

	public List<FlightBookingVerifyInfoDto> getFlightBookingVerifyInfos() {
		return flightBookingVerifyInfos;
	}

	public void setFlightBookingVerifyInfos(
			List<FlightBookingVerifyInfoDto> flightBookingVerifyInfos) {
		this.flightBookingVerifyInfos = flightBookingVerifyInfos;
	}

	public SuppFlightProductDto getSuppFlightProductDto() {
		return suppFlightProductDto;
	}

	public void setSuppFlightProductDto(SuppFlightProductDto suppFlightProductDto) {
		this.suppFlightProductDto = suppFlightProductDto;
	}

	public boolean isVerifyFail() {
		return isVerifyFail;
	}

	public void setVerifyFail(boolean isVerifyFail) {
		this.isVerifyFail = isVerifyFail;
	}
	
}
