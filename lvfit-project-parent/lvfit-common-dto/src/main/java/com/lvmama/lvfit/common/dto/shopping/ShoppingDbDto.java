package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.lvmama.lvf.common.dto.Dto;

public class ShoppingDbDto implements Serializable,Dto{
	
	private List<ShoppingDetailDto> shoppingDetails;
	private List<ShoppingPassengerDto> shoppingPassengers;
	
	private List<ShoppingHotelDto> shoppingHotels;
	
	private List<ShoppingFlightDto> ShoppingFlight;
	
	private List<ShoppingSpotTicketDto>  shoppingSpots;
	
	private List<ShoppingInsuranceDto> shoppingInsurances;
	
	private List<FlightInsuranceDto> shoppingFlightInsurances;
	



	public List<ShoppingDetailDto> getShoppingDetails() {
		return shoppingDetails;
	}



	public void setShoppingDetails(List<ShoppingDetailDto> shoppingDetails) {
		this.shoppingDetails = shoppingDetails;
	}



	public List<ShoppingPassengerDto> getShoppingPassengers() {
		return shoppingPassengers;
	}



	public void setShoppingPassengers(List<ShoppingPassengerDto> shoppingPassengers) {
		this.shoppingPassengers = shoppingPassengers;
	}



	public List<ShoppingHotelDto> getShoppingHotels() {
		return shoppingHotels;
	}



	public void setShoppingHotels(List<ShoppingHotelDto> shoppingHotels) {
		this.shoppingHotels = shoppingHotels;
	}



	public List<ShoppingFlightDto> getShoppingFlight() {
		return ShoppingFlight;
	}



	public void setShoppingFlight(List<ShoppingFlightDto> shoppingFlight) {
		ShoppingFlight = shoppingFlight;
	}



	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    public ShoppingDetailDto  convertShoppingDetailDto(){
    	if(!CollectionUtils.isEmpty(shoppingDetails)){
    		return shoppingDetails.get(0);
    	}
    	return null;
    }
    
    
    public List<ShoppingHotelDto> convertShoppingHotelDtos(){
    	List<ShoppingHotelDto> results = new ArrayList<ShoppingHotelDto>();
    	if(!CollectionUtils.isEmpty(shoppingHotels)){
    		results.add(shoppingHotels.get(0));
    	}
    	return results;
    }
    
    public List<ShoppingFlightDto> convertShoppingFlightDtos(){
    	List<ShoppingFlightDto> results = new ArrayList<ShoppingFlightDto>();
    	if(!CollectionUtils.isEmpty(ShoppingFlight)){
    		for (ShoppingFlightDto shoppingFlightDto : results) {
    			ShoppingFlight.add(shoppingFlightDto);
			}
    	}
    	return results;
    }
    //门票
    public List<ShoppingSpotTicketDto> convertShoppingSpotsDtos(){
    	List<ShoppingSpotTicketDto> list = new ArrayList<ShoppingSpotTicketDto>();
    	if(!CollectionUtils.isEmpty(shoppingSpots)){
    		for(ShoppingSpotTicketDto spotDtp:shoppingSpots){
    			list.add(spotDtp);
    		}
    	}
    	return list;
    }

    //保险
    public List<ShoppingInsuranceDto> convertShoppingInsuranceDtos(){
    	List<ShoppingInsuranceDto> list = new ArrayList<ShoppingInsuranceDto>();
    	if(!CollectionUtils.isEmpty(shoppingInsurances)){
    		for (ShoppingInsuranceDto shoppingInsuranceDto : shoppingInsurances) {
				list.add(shoppingInsuranceDto);
			}
    	}
    	return list;
    }
    
    //航空意外险 
    public List<FlightInsuranceDto> convertShoppingFlightInsuranceDtos(){
    	List<FlightInsuranceDto> list = new ArrayList<FlightInsuranceDto>();
    	if(!CollectionUtils.isEmpty(shoppingFlightInsurances)){
    		for (FlightInsuranceDto shoppingInsuranceDto : shoppingFlightInsurances) {
				list.add(shoppingInsuranceDto);
			}
    	}
    	return list;
    }
    
	public List<ShoppingSpotTicketDto> getShoppingSpots() {
		return shoppingSpots;
	}



	public void setShoppingSpots(List<ShoppingSpotTicketDto> shoppingSpots) {
		this.shoppingSpots = shoppingSpots;
	}



	public List<ShoppingInsuranceDto> getShoppingInsurances() {
		return shoppingInsurances;
	}



	public void setShoppingInsurances(List<ShoppingInsuranceDto> shoppingInsurances) {
		this.shoppingInsurances = shoppingInsurances;
	}



	public final List<FlightInsuranceDto> getShoppingFlightInsurances() {
		return shoppingFlightInsurances;
	}



	public final void setShoppingFlightInsurances(
			List<FlightInsuranceDto> shoppingFlightInsurances) {
		this.shoppingFlightInsurances = shoppingFlightInsurances;
	}
}
