package com.lvmama.lvfit.common.dto.sdp.goods.request;

import java.io.Serializable;

public class FitChangeFlightRequest implements Serializable {

    private static final long serialVersionUID = -8718240203101021691L;

    private String shoppingUuid;
    
    private String flightNo;
    private int changeFlight; 
	 
	public int getChangeFlight() {
		return changeFlight;
	}

	public void setChangeFlight(int changeFlight) {
		this.changeFlight = changeFlight;
	}

	//包机的返程航班号.
    private String charsetBackflightNo;
    
    private String flightTripType;

    public String getShoppingUuid() {
        return shoppingUuid;
    } 
    
    public String getCharsetBackflightNo() {
		return charsetBackflightNo;
	}


	public void setCharsetBackflightNo(String charsetBackflightNo) {
		this.charsetBackflightNo = charsetBackflightNo;
	}


	public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightTripType() {
        return flightTripType;
    }

    public void setFlightTripType(String flightTripType) {
        this.flightTripType = flightTripType;
    }
}
