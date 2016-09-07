package com.lvmama.lvfit.business.order.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderOtherTicket;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderOtherTicketRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderOtherTicketMapper;

@Repository
public class FitOrderOtherTicketRepositoryImpl implements FitOrderOtherTicketRepository{
	
	@Autowired
	private FitOrderOtherTicketMapper fitOrderOtherTicketMapper;

	@Override
	public FitOrderOtherTicketDto load(Long id) {
		return fitOrderOtherTicketMapper.getById(id);
	}

	@Override
	public FitOrderOtherTicket load(FitOrderOtherTicketDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitOrderOtherTicketDto save(FitOrderOtherTicketDto r) {
	       if (null == r.getId()) {
	    	   fitOrderOtherTicketMapper.insert(r);
	        }else {
	        	fitOrderOtherTicketMapper.updateById(r.getId(), r);
	        }
	        return r;
	}

	
}
