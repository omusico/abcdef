package com.lvmama.lvf.common.form.booking;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.lvmama.lvf.common.dto.booking.BookingPassengerTypeAndAmountDto;
import com.lvmama.lvf.common.dto.calculator.AmountCalculatorDetailDto;
import com.lvmama.lvf.common.dto.calculator.AmountCalculatorDto;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDiscountDto;
import com.lvmama.lvf.common.form.Form;

public class BookingCalculateRForm implements Form{

    private AmountCalculatorDto amountCalculatorDto;
    
    private List<BookingPassengerTypeAndAmountDto> bookingPassengerTypeAndAmounts;
    
    
    public BookingCalculateRForm() {
		super();
	}

	public BookingCalculateRForm(AmountCalculatorDto amountCalculatorDto,
			List<BookingPassengerTypeAndAmountDto> bookingPassengerTypeAndAmounts) {
		super();
		this.amountCalculatorDto = amountCalculatorDto;
		this.bookingPassengerTypeAndAmounts = bookingPassengerTypeAndAmounts;
	}

	public AmountCalculatorDto getAmountCalculatorDto() {
		return amountCalculatorDto;
	}

	public void setAmountCalculatorDto(AmountCalculatorDto amountCalculatorDto) {
		this.amountCalculatorDto = amountCalculatorDto;
	}

	public FlightOrderAmountDto getFlightOrderAmountDto() {
		return amountCalculatorDto.getFlightOrderAmountDto();
	}

	public void setFlightOrderAmountDto(
			FlightOrderAmountDto flightOrderAmountDto) {
		amountCalculatorDto.setFlightOrderAmountDto(flightOrderAmountDto);
	}

	public List<FlightOrderDiscountDto> getDiscounts() {
		return amountCalculatorDto.getDiscounts();
	}

	public void setDiscounts(List<FlightOrderDiscountDto> discounts) {
		amountCalculatorDto.setDiscounts(discounts);
	}

	public BigDecimal getOrderTotalAmount() {
		return amountCalculatorDto.getOrderTotalAmount();
	}

	public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
		amountCalculatorDto.setOrderTotalAmount(orderTotalAmount);
	}

	public BigDecimal getOrderTicketAmount() {
		return amountCalculatorDto.getOrderTicketAmount();
	}

	public void setOrderTicketAmount(BigDecimal orderTicketAmount) {
		amountCalculatorDto.setOrderTicketAmount(orderTicketAmount);
	}

	public BigDecimal getOrderAirportTaxAmount() {
		return amountCalculatorDto.getOrderAirportTaxAmount();
	}

	public void setOrderAirportTaxAmount(BigDecimal orderAirportTaxAmount) {
		amountCalculatorDto.setOrderAirportTaxAmount(orderAirportTaxAmount);
	}

	public BigDecimal getOrderFuelTaxAmount() {
		return amountCalculatorDto.getOrderFuelTaxAmount();
	}

	public void setOrderFuelTaxAmount(BigDecimal orderFuelTaxAmount) {
		amountCalculatorDto.setOrderFuelTaxAmount(orderFuelTaxAmount);
	}

	public BigDecimal getOrderInsuranceAmount() {
		return amountCalculatorDto.getOrderInsuranceAmount();
	}

	public void setOrderInsuranceAmount(BigDecimal orderInsuranceAmount) {
		amountCalculatorDto.setOrderInsuranceAmount(orderInsuranceAmount);
	}

	public BigDecimal getOrderPlusAmount() {
		return amountCalculatorDto.getOrderPlusAmount();
	}

	public void setOrderPlusAmount(BigDecimal orderPlusAmount) {
		amountCalculatorDto.setOrderPlusAmount(orderPlusAmount);
	}

	public BigDecimal getOrderPrepaidAmount() {
		return amountCalculatorDto.getOrderPrepaidAmount();
	}

	public void setOrderPrepaidAmount(BigDecimal orderPrepaidAmount) {
		amountCalculatorDto.setOrderPrepaidAmount(orderPrepaidAmount);
	}

	public BigDecimal getOrderPayedAmount() {
		return amountCalculatorDto.getOrderPayedAmount();
	}

	public void setOrderPayedAmount(BigDecimal orderPayedAmount) {
		amountCalculatorDto.setOrderPayedAmount(orderPayedAmount);
	}

	public BigDecimal getOrderDiscountTotalAmount() {
		return amountCalculatorDto.getOrderDiscountTotalAmount();
	}

	public void setOrderDiscountTotalAmount(BigDecimal orderDiscountTotalAmount) {
		amountCalculatorDto
				.setOrderDiscountTotalAmount(orderDiscountTotalAmount);
	}

	public BigDecimal getOrderProfitAmount() {
		return amountCalculatorDto.getOrderProfitAmount();
	}

	public void setOrderProfitAmount(BigDecimal orderProfitAmount) {
		amountCalculatorDto.setOrderProfitAmount(orderProfitAmount);
	}

	public PriceFormula getProfitFormula() {
		return amountCalculatorDto.getProfitFormula();
	}

	public void setProfitFormula(PriceFormula profitFormula) {
		amountCalculatorDto.setProfitFormula(profitFormula);
	}

	public List<FlightOrderDiscountDto> getFlightOrderDiscounts() {
		return amountCalculatorDto.getFlightOrderDiscounts();
	}

	public void setFlightOrderDiscounts(
			List<FlightOrderDiscountDto> flightOrderDiscounts) {
		amountCalculatorDto.setFlightOrderDiscounts(flightOrderDiscounts);
	}

	public BigDecimal getOrderExpressAmount() {
		return amountCalculatorDto.getOrderExpressAmount();
	}

	public void setOrderExpressAmount(BigDecimal orderExpressAmount) {
		amountCalculatorDto.setOrderExpressAmount(orderExpressAmount);
	}

	public List<AmountCalculatorDetailDto> getCalculatorDetailDtos() {
		return amountCalculatorDto.getCalculatorDetailDtos();
	}

	public void setCalculatorDetailDtos(
			List<AmountCalculatorDetailDto> calculatorDetailDtos) {
		amountCalculatorDto.setCalculatorDetailDtos(calculatorDetailDtos);
	}

	public int size() {
		return bookingPassengerTypeAndAmounts.size();
	}

	public boolean isEmpty() {
		return bookingPassengerTypeAndAmounts.isEmpty();
	}

	public boolean contains(Object o) {
		return bookingPassengerTypeAndAmounts.contains(o);
	}

	public Iterator<BookingPassengerTypeAndAmountDto> iterator() {
		return bookingPassengerTypeAndAmounts.iterator();
	}

	public Object[] toArray() {
		return bookingPassengerTypeAndAmounts.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return bookingPassengerTypeAndAmounts.toArray(a);
	}

	public boolean add(BookingPassengerTypeAndAmountDto e) {
		return bookingPassengerTypeAndAmounts.add(e);
	}

	public boolean remove(Object o) {
		return bookingPassengerTypeAndAmounts.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return bookingPassengerTypeAndAmounts.containsAll(c);
	}

	public boolean addAll(Collection<? extends BookingPassengerTypeAndAmountDto> c) {
		return bookingPassengerTypeAndAmounts.addAll(c);
	}

	public boolean addAll(int index,
			Collection<? extends BookingPassengerTypeAndAmountDto> c) {
		return bookingPassengerTypeAndAmounts.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return bookingPassengerTypeAndAmounts.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return bookingPassengerTypeAndAmounts.retainAll(c);
	}

	public void clear() {
		bookingPassengerTypeAndAmounts.clear();
	}

	public boolean equals(Object o) {
		return bookingPassengerTypeAndAmounts.equals(o);
	}

	public int hashCode() {
		return bookingPassengerTypeAndAmounts.hashCode();
	}

	public BookingPassengerTypeAndAmountDto get(int index) {
		return bookingPassengerTypeAndAmounts.get(index);
	}

	public BookingPassengerTypeAndAmountDto set(int index,
			BookingPassengerTypeAndAmountDto element) {
		return bookingPassengerTypeAndAmounts.set(index, element);
	}

	public void add(int index, BookingPassengerTypeAndAmountDto element) {
		bookingPassengerTypeAndAmounts.add(index, element);
	}

	public BookingPassengerTypeAndAmountDto remove(int index) {
		return bookingPassengerTypeAndAmounts.remove(index);
	}

	public int indexOf(Object o) {
		return bookingPassengerTypeAndAmounts.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return bookingPassengerTypeAndAmounts.lastIndexOf(o);
	}

	public ListIterator<BookingPassengerTypeAndAmountDto> listIterator() {
		return bookingPassengerTypeAndAmounts.listIterator();
	}

	public ListIterator<BookingPassengerTypeAndAmountDto> listIterator(int index) {
		return bookingPassengerTypeAndAmounts.listIterator(index);
	}

	public List<BookingPassengerTypeAndAmountDto> subList(int fromIndex,
			int toIndex) {
		return bookingPassengerTypeAndAmounts.subList(fromIndex, toIndex);
	}

	public List<BookingPassengerTypeAndAmountDto> getBookingPassengerTypeAndAmounts() {
		return bookingPassengerTypeAndAmounts;
	}

	public void setBookingPassengerTypeAndAmounts(
			List<BookingPassengerTypeAndAmountDto> bookingPassengerTypeAndAmounts) {
		this.bookingPassengerTypeAndAmounts = bookingPassengerTypeAndAmounts;
	}
	
}
