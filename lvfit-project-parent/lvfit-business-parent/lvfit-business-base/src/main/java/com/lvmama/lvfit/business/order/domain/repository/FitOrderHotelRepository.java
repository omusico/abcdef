package com.lvmama.lvfit.business.order.domain.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.order.domain.FitOrderHotel;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;

public interface FitOrderHotelRepository extends DomainBaseRepository<FitOrderHotel, FitOrderHotelDto> {
	
	List<FitOrderHotelDto> getByPlanIdAndCheckIn(@Param("planId")String planId,@Param("checkin")Date checkin);


}
