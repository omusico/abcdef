package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.order.domain.FitSuppOrderForFlightCallBack;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;

import java.util.List;

public interface FitSuppOrderForFlightCallBackRepository extends DomainBaseRepository<FitSuppOrderForFlightCallBack, FitSuppOrderForFlightCallBackDto>,
DomainByFkIdRepository<FitSuppOrderForFlightCallBackDto>{
	
	  FitSuppOrderForFlightCallBackDto  loadByVstNos(String vstOrderMainNo,String vstOrderNo);

	  List<String> loadCallRequestStrByVstNo(String vstOrderMainNo, String vstOrderNo);
	
}
