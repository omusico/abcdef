package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.flight.FlightAirportFeeDto;
import com.lvmama.lvf.common.dto.flight.FlightAirportLineDto;
import com.lvmama.lvf.common.dto.flight.FlightFuelsurTaxDto;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.flight.FlightSeatDto;
import com.lvmama.lvf.common.dto.flight.FlightStopInfoDto;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.SeatClass;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;
import com.lvmama.lvf.common.form.Form;

public class TicketCTMTFlightResponseForm implements Serializable, Form {

    private static final long serialVersionUID = 1L;
    
    /** 航班基本信息 */
    private FlightInfoDto flightInfoDto = new FlightInfoDto();
    
    /** 机建燃油费  */
    private FlightTicketPriceDto flightTicketPriceDto = new FlightTicketPriceDto();
    
    /** 起飞时间 */
    private String departureTime;
    
    /** 到达时间 */
    private String arrivalTime;
    
    /** 舱位基本信息(编码、名称) */
    private List<SeatClass> seatClasss = new ArrayList<SeatClass>();
    
    /** 跨越的天数 */
    private int crossDay;
    
    public TicketCTMTFlightResponseForm() {
        super();
    }

    public TicketCTMTFlightResponseForm(FlightInfoDto flightInfoDto) {
        super();
        this.flightInfoDto = flightInfoDto;
    }

    public FlightInfoDto getFlightInfoDto() {
        return flightInfoDto;
    }

    public void setFlightInfoDto(FlightInfoDto flightInfoDto) {
        this.flightInfoDto = flightInfoDto;
    }

    public Long getId() {
        return flightInfoDto.getId();
    }

    public void setId(Long id) {
        flightInfoDto.setId(id);
    }

    public Airplane getAirplane() {
        return flightInfoDto.getAirplane();
    }

    public void setAirplane(Airplane airplane) {
        flightInfoDto.setAirplane(airplane);
    }

    public String getFlightNo() {
        return flightInfoDto.getFlightNo();
    }

    public void setFlightNo(String flightNo) {
        flightInfoDto.setFlightNo(flightNo);
    }

    public FlightStopInfoDto getFlightStopInfo() {
        return flightInfoDto.getFlightStopInfo();
    }

    public void setFlightStopInfo(FlightStopInfoDto flightStopInfo) {
        flightInfoDto.setFlightStopInfo(flightStopInfo);
    }

    public TimeSegmentRange getTimeSegmentRange() {
        return flightInfoDto.getTimeSegmentRange();
    }

    public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
        flightInfoDto.setTimeSegmentRange(timeSegmentRange);
    }

    public void setFees(List<FlightAirportFeeDto> fees) {
        flightInfoDto.setFees(fees);
    }

    public FlightAirportLineDto getFlightAirportLine() {
        return flightInfoDto.getFlightAirportLine();
    }

    public void setFlightAirportLine(FlightAirportLineDto flightAirportLine) {
        flightInfoDto.setFlightAirportLine(flightAirportLine);
    }

    public List<FlightAirportFeeDto> getFees() {
        return flightInfoDto.getFees();
    }

    public List<FlightFuelsurTaxDto> getTaxs() {
        return flightInfoDto.getTaxs();
    }

    public void setTaxs(List<FlightFuelsurTaxDto> taxs) {
        flightInfoDto.setTaxs(taxs);
    }

    public List<FlightSeatDto> getSeats() {
        return flightInfoDto.getSeats();
    }

    public void setSeats(List<FlightSeatDto> seats) {
        flightInfoDto.setSeats(seats);
    }

    public FlightTicketPriceDto getFlightTicketPriceDto() {
        return flightTicketPriceDto;
    }

    public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
        this.flightTicketPriceDto = flightTicketPriceDto;
    }

    public BigDecimal getFuelsurTax() {
        return flightTicketPriceDto.getFuelsurTax();
    }

    public void setFuelsurTax(BigDecimal fuelsurTax) {
        flightTicketPriceDto.setFuelsurTax(fuelsurTax);
    }

    public BigDecimal getAirportFee() {
        return flightTicketPriceDto.getAirportFee();
    }

    public void setAirportFee(BigDecimal airportFee) {
        flightTicketPriceDto.setAirportFee(airportFee);
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<SeatClass> getSeatClasss() {
        return seatClasss;
    }

    public void setSeatClasss(List<SeatClass> seatClasss) {
        this.seatClasss = seatClasss;
    }

    public Carrier getCarrier() {
        return flightInfoDto.getCarrier();
    }

    public void setCarrier(Carrier carrier) {
        flightInfoDto.setCarrier(carrier);
    }

    public int getCrossDay() {
        return crossDay;
    }

    public void setCrossDay(int crossDay) {
        this.crossDay = crossDay;
    }

    
}
