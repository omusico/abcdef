package com.lvmama.lvfit.business.shopping.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.shopping.domain.ShoppingSpotTicket;
import com.lvmama.lvfit.common.dto.shopping.ShoppingSpotTicketDto;

public interface ShoppingSpotRepository extends DomainBaseRepository< ShoppingSpotTicket, ShoppingSpotTicketDto>{
	public List<ShoppingSpotTicketDto> getListByCode(String code);
	public List<ShoppingSpotTicketDto> getLatestListByCode(String code);
}
