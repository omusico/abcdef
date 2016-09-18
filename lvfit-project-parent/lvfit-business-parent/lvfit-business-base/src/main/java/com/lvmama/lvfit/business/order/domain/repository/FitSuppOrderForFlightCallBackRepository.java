package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.order.domain.FitSuppOrderForFlightCallBack;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackRequest;

import java.util.List;

public interface FitSuppOrderForFlightCallBackRepository extends DomainBaseRepository<FitSuppOrderForFlightCallBack, FitSuppOrderForFlightCallBackDto>,
DomainByFkIdRepository<FitSuppOrderForFlightCallBackDto>{
	
	  FitSuppOrderForFlightCallBackDto  loadByVstNos(String vstOrderMainNo,String vstOrderNo);

	  List<String> loadCallRequestStrByVstNo(String vstOrderMainNo, String vstOrderNo);

	  List<FitSuppOrderForFlightCallBackDto> queryAll(BaseQueryDto<FitSuppOrderForFlightCallBackRequest> request);

	  int querySuppOrderForFlightCallBackCounts(BaseQueryDto<FitSuppOrderForFlightCallBackRequest> baseQuery);

	  List<FitFliBookingCallBackRequest> queryByVstMainNo(BaseQueryDto<FitFliBookingCallBackRequest> baseQuery);
	
}
