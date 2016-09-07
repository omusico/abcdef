package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitSuppFlightOrder;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppFlightOrderDetailRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppFlightOrderRepository;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSuppFlightOrderMapper;

@Repository
public class FitSuppFlightOrderRepositoryImpl implements FitSuppFlightOrderRepository {

	@Autowired
	private FitSuppFlightOrderMapper  fitSuppFlightOrderMapper;
	
	@Autowired
	private FitSuppFlightOrderDetailRepository fitSuppFlightOrderDetailRepository;
	
	@Override
	public FitSuppFlightOrderDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitSuppFlightOrder load(FitSuppFlightOrderDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSuppFlightOrderDto save(FitSuppFlightOrderDto r) {
		
		   if (null == r.getId()) {
			   fitSuppFlightOrderMapper.insert(r);
	        }else {
	        	fitSuppFlightOrderMapper.updateById(r.getId(), r);
	        }
		   Long suppFlightOrderId = r.getId();
		   List<FitSuppFlightOrderDetailDto> suppFlightOrderDetailDtos = r.getSuppFlightOrderDetailDtos();
		   if(CollectionUtils.isNotEmpty(suppFlightOrderDetailDtos)){
			   for (FitSuppFlightOrderDetailDto fitSuppFlightOrderDetailDto : suppFlightOrderDetailDtos) {
				   fitSuppFlightOrderDetailDto.setSuppFlightOrderId(suppFlightOrderId);
				   fitSuppFlightOrderDetailRepository.save(fitSuppFlightOrderDetailDto);
			   }
		   }
	       return r;
	}

	@Override
	public List<FitSuppFlightOrderDto> queryByFkId(Long fkId) {
		List<FitSuppFlightOrderDto> suppFlightList = fitSuppFlightOrderMapper.queryByFkId(fkId);
		for(FitSuppFlightOrderDto fligthOrderDto : suppFlightList){
			List<FitSuppFlightOrderDetailDto> suppFlightDetailList = fitSuppFlightOrderDetailRepository.queryByFkId(fligthOrderDto.getId());
			fligthOrderDto.setSuppFlightOrderDetailDtos(suppFlightDetailList);
		}
		return suppFlightList; 
	}

	@Override
	public int deleteByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
