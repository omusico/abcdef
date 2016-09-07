package com.lvmama.lvfit.common.dto.order;

public class FitSuppOrderTicketInfoDto {
	
    private String name;
	/** 票号 */
	private String ticketNo;

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
