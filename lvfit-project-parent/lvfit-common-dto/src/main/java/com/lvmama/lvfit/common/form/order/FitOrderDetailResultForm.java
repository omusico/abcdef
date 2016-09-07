package com.lvmama.lvfit.common.form.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.Paytarget;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderViewStatus;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitOrderFliInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderTicketInfoDto;

public class FitOrderDetailResultForm implements Serializable, Form {

	private static final long serialVersionUID = -7585171650793554731L;
	
	public FitOrderDetailResultForm() {}
	
	public FitOrderDetailResultForm(FitOrderDetail fitOrderDetail) {
	    this.fitOrderDetail = fitOrderDetail;
	}
	
	private FitOrderDetail fitOrderDetail = new FitOrderDetail();
	
	public FitOrderDetail getFitOrderDetail() {
        return fitOrderDetail;
    }
    public void setFitOrderDetail(FitOrderDetail fitOrderDetails) {
        this.fitOrderDetail = fitOrderDetails;
    }
    public FitOrderContacterDto getFitOrderContacterDto() {
		return fitOrderDetail.getFitOrderContacterDto();
	}
	public void setFitOrderContacterDto(FitOrderContacterDto fitOrderContacterDto) {
		this.fitOrderDetail.setFitOrderContacterDto(fitOrderContacterDto);
	}
	public List<FitOrderPassengerDto> getFitOrderPassengers() {
		return fitOrderDetail.getFitOrderPassengers();
	}
	public void setFitOrderPassengers(List<FitOrderPassengerDto> fitOrderPassengers) {
	    this.fitOrderDetail.setFitOrderPassengers(fitOrderPassengers);
	}
	public String getVstOrderMainNo() {
		return fitOrderDetail.getVstOrderMainNo();
	}
	public void setVstOrderMainNo(String vstOrderMainNo) {
		this.fitOrderDetail.setVstOrderMainNo(vstOrderMainNo);
	}
	public String getOrderViewStatus() {
		if(null!=fitOrderDetail.getOrderViewStatus()){
			return fitOrderDetail.getOrderViewStatus().getCnName();
		}
		return StringUtils.EMPTY;
	}
	public void setOrderViewStatus(SuppVstOrderViewStatus orderViewStatus) {
		this.fitOrderDetail.setOrderViewStatus(orderViewStatus);
	}
	public String getTotalAmount() {
		
		if(null!=fitOrderDetail.getTotalAmount()){
			return fitOrderDetail.getTotalAmount().setScale(2).toString();
		}
		return StringUtils.EMPTY;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.fitOrderDetail.setTotalAmount(totalAmount);
	}
	public String getCreateTime() {
		return DateUtils.formatDate(fitOrderDetail.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
	}
	public void setCreateTime(Date createTime) {
		this.fitOrderDetail.setCreateTime(createTime);
	}
	public String getPaytarget() {
		if(null!=fitOrderDetail.getPaytarget()){
			return fitOrderDetail.getPaytarget().getCnName();
		}
		return StringUtils.EMPTY;
	}
	public void setPaytarget(Paytarget paytarget) {
		this.fitOrderDetail.setPaytarget(paytarget);
	}
	public String getProductName() {
		return fitOrderDetail.getProductName();
	}
	public void setProductName(String productName) {
		this.fitOrderDetail.setProductName(productName);
	}
	public List<FitOrderFlightDto> getFlights() {
		return fitOrderDetail.getFlights();
	}
	public void setFlights(List<FitOrderFlightDto> flights) {
		this.fitOrderDetail.setFlights(flights);
	}
	public List<FitOrderHotelDto> getHotels() {
		return fitOrderDetail.getHotels();
	}
	public void setHotels(List<FitOrderHotelDto> hotels) {
		this.fitOrderDetail.setHotels(hotels);
	}
	public List<FitOrderSpotTicketDto> getSpotTickets() {
		return fitOrderDetail.getSpotTickets();
	}
	public void setSpotTickets(List<FitOrderSpotTicketDto> spotTickets) {
		this.fitOrderDetail.setSpotTickets(spotTickets);
	}
	public List<FitOrderInsuranceDto> getInsurances() {
		return fitOrderDetail.getInsurances();
	}
	public void setInsurances(List<FitOrderInsuranceDto> fitOrderInsuranceDtos) {
		this.fitOrderDetail.setInsurances(fitOrderInsuranceDtos);
	}
	public String getContacterEmail() {
		return fitOrderDetail.getFitOrderContacterDto().getEmail();
	}
	public void setContacterEmail(String email) {
	    fitOrderDetail.getFitOrderContacterDto().setEmail(email);
	}
	public String getContacterMobile() {
		return fitOrderDetail.getFitOrderContacterDto().getMobile();
	}
	public void setContacterMobile(String mobile) {
	    fitOrderDetail.getFitOrderContacterDto().setMobile(mobile);
	}
	public String getContacterName() {
		return fitOrderDetail.getFitOrderContacterDto().getName();
	}
	public void setContacterName(String name) {
	    fitOrderDetail.getFitOrderContacterDto().setName(name);
	}
    public List<String> getVstFlightOrderNo() {
        return fitOrderDetail.getVstFlightOrderNo();
    }
    public void setVstFlightOrderNo(List<String> vstFlightOrderNo) {
        this.fitOrderDetail.setVstFlightOrderNo(vstFlightOrderNo);
    }
    public Map<String, List<FitSuppOrderTicketInfoDto>> getTicketNosMap() {
        return fitOrderDetail.getTicketNosMap();
    }
    public void setTicketNosMap(Map<String, List<FitSuppOrderTicketInfoDto>> ticketNosMap) {
        this.fitOrderDetail.setTicketNosMap(ticketNosMap);
    }
    public String getVisitTime() {
        return DateUtils.formatDate(fitOrderDetail.getVisitTime(), DateUtils.YYYY_MM_DD);
    }
    public void setVisitTime(Date visitTime) {
        this.fitOrderDetail.setVisitTime(visitTime);
    }
    
    public static FitOrderDetailResultForm convertFitOrderMainDtoToResultForm(FitOrderMainDto mainDto) {
        FitOrderDetailResultForm resultForm = new FitOrderDetailResultForm();

        resultForm.setFitOrderContacterDto(mainDto.getFitOrderContacter());
        resultForm.setFitOrderPassengers(mainDto.getFitOrderPassengers());
        resultForm.setVstOrderMainNo(mainDto.getFitSuppMainOrderDto().getVstMainOrderNo().toString());
        resultForm.setOrderViewStatus(mainDto.getFitSuppMainOrderDto().getFitSuppMainOrderStatus().getOrderViewStatus());
        resultForm.setTotalAmount(mainDto.getFitSuppMainOrderDto().getOrderAmount().getTotalAmount());
        resultForm.setCreateTime(mainDto.getCreateTime());
        resultForm.setPaytarget(mainDto.getFitSuppMainOrderDto().getPaymentTarget());
        resultForm.setProductName(mainDto.getProductName());
        resultForm.setVisitTime(mainDto.getFitSuppMainOrderDto().getVisitTime());
        resultForm.setFlights(mainDto.getFitOrderFlightDtos());
        resultForm.setHotels(mainDto.getFitOrderHotelDtos());
        resultForm.setSpotTickets(mainDto.getFitOrderSpotTicketDtos());
        resultForm.setInsurances(mainDto.getFitOrderInsuranceDtos());
        resultForm.setFlightInsuranceDtos(mainDto.getFlightInsuranceDtos());
        
        Map<String, List<FitSuppOrderTicketInfoDto>> ticketNosMap = resultForm.getTicketNosMap();
        List<FitSuppOrderTicketInfoDto> depTicketInfo = new ArrayList<FitSuppOrderTicketInfoDto>();
        List<FitSuppOrderTicketInfoDto> arvTicketInfo = new ArrayList<FitSuppOrderTicketInfoDto>();

        for (FitSuppOrderDto suppOrderDto : mainDto.getFitSuppMainOrderDto().getFitSuppOrderDtos()) {
            for (FitSuppFlightOrderDto suppFlightOrderDto : suppOrderDto.getSuppFlightOrderDtos()) {
                for (FitSuppFlightOrderDetailDto flightOrderDetail : suppFlightOrderDto.getSuppFlightOrderDetailDtos()) {
                    FitSuppOrderTicketInfoDto ticketInfo = new FitSuppOrderTicketInfoDto();
                    ticketInfo.setName(flightOrderDetail.getFitOrderPassenger().getPassengerName());
                    ticketInfo.setTicketNo(flightOrderDetail.getFitSuppOrderTicketInfoDto().getTicketNo());
                    if (suppFlightOrderDto.getTripType() != null && suppFlightOrderDto.getTripType().equals(FlightTripType.DEPARTURE)) {
                        depTicketInfo.add(ticketInfo);
                    }
                    if (suppFlightOrderDto.getTripType() != null && suppFlightOrderDto.getTripType().equals(FlightTripType.RETURN)) {
                        arvTicketInfo.add(ticketInfo);
                    }
                }
            }
        }
        ticketNosMap.put(FlightTripType.DEPARTURE.name(), depTicketInfo);
        ticketNosMap.put(FlightTripType.RETURN.name(), arvTicketInfo);
        
        return resultForm;
    }

    public List<FitOrderFliInsuranceDto> getFlightInsuranceDtos() {
        List<FitOrderFliInsuranceDto> result = new ArrayList<FitOrderFliInsuranceDto>(); 
        Map<String, FitOrderFliInsuranceDto> map = new HashMap<String, FitOrderFliInsuranceDto>();
        
        for (FitOrderFliInsuranceDto fliInsDto : fitOrderDetail.getFlightInsuranceDtos()) {
            String insId = fliInsDto.getInsuranceId();
            if (map.containsKey(insId)) {
                FitOrderFliInsuranceDto fliIns = map.get(insId);
                Integer count = fliIns.getInsuranceCount();
                int temp = count.intValue();
                temp++;
                fliIns.setInsuranceCount(Integer.valueOf(temp));
            } else {
                map.put(insId, fliInsDto);
            }
        }
        
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public void setFlightInsuranceDtos(List<FitOrderFliInsuranceDto> flightInsuranceDtos) {
        fitOrderDetail.setFlightInsuranceDtos(flightInsuranceDtos);
    }

	
}
