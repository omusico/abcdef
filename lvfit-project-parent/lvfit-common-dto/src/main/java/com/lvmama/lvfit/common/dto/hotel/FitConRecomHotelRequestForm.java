package com.lvmama.lvfit.common.dto.hotel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FitConRecomHotelRequestForm implements Serializable{
	
	private List<FitConRecomHotelDto> fitConRecomHotelDtos = new ArrayList<FitConRecomHotelDto>();

	public List<FitConRecomHotelDto> getFitConRecomHotelDtos() {
		return fitConRecomHotelDtos;
	}

	public void setFitConRecomHotelDtos(
			List<FitConRecomHotelDto> fitConRecomHotelDtos) {
		this.fitConRecomHotelDtos = fitConRecomHotelDtos;
	}
	
}
