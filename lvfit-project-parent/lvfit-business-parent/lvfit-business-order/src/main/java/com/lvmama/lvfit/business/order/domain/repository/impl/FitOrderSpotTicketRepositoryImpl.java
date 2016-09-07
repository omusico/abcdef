package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderSpotTicket;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderSpotTicketRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderSpotTicketMapper;

@Repository
public class FitOrderSpotTicketRepositoryImpl implements FitOrderSpotTicketRepository{

	@Autowired
	private FitOrderSpotTicketMapper   fitOrderSpotTicketMapper;

	@Override
	public FitOrderSpotTicketDto load(Long id) {
		return fitOrderSpotTicketMapper.getById(id);
	}

	@Override
	public FitOrderSpotTicket load(FitOrderSpotTicketDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitOrderSpotTicketDto save(FitOrderSpotTicketDto r) {
		if(null == r.getId()){
			fitOrderSpotTicketMapper.insert(r);
		} else {
			fitOrderSpotTicketMapper.updateById(r.getId(), r);
		}
		return r;
	}
}
