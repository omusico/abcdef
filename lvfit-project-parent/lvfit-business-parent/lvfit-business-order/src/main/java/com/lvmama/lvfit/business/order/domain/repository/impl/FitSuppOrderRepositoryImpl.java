package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitSuppOrder;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppFlightOrderRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderForFlightCallBackRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderStatusRepository;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSuppOrderMapper;

/**
 * @author qihuisong
 */
@Repository
public class FitSuppOrderRepositoryImpl implements FitSuppOrderRepository {
	private static final Logger logger = LoggerFactory.getLogger(FitSuppOrderRepositoryImpl.class);

    @Autowired
    private FitSuppOrderMapper fitSuppOrderMapper;
    
    @Autowired
    private FitSuppFlightOrderRepository fitSuppFlightOrderRepository;
    
    @Autowired
    private FitSuppOrderStatusRepository fitSuppOrderStatusRepository;
    
    @Autowired
    private FitSuppOrderForFlightCallBackRepository fitSuppOrderForFlightCallBackRepository;
    
    

    @Override
    public FitSuppOrderDto load(Long id) {
        return null;
    }

    @Override
    public FitSuppOrder load(FitSuppOrderDto fitSuppOrderDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitSuppOrderDto save(FitSuppOrderDto fitSuppOrderDto) { 
        if (null == fitSuppOrderDto.getId()) {
            fitSuppOrderMapper.insert(fitSuppOrderDto);
        }else {
            fitSuppOrderMapper.updateById(fitSuppOrderDto.getId(), fitSuppOrderDto);
        }
        
        Long suppOrderId = fitSuppOrderDto.getId();
        List<FitSuppFlightOrderDto> suppFlightOrderDtos = fitSuppOrderDto.getSuppFlightOrderDtos();
        if(CollectionUtils.isNotEmpty(suppFlightOrderDtos)){
        	for (FitSuppFlightOrderDto fitSuppFlightOrderDto : suppFlightOrderDtos) {
        		fitSuppFlightOrderDto.setSuppOrderId(suppOrderId);
        		fitSuppFlightOrderRepository.save(fitSuppFlightOrderDto);
			}
        }
        
        FitSuppOrderStatusDto fitSuppOrderStatusDto = fitSuppOrderDto.getFitSuppOrderStatusDto();
        if(null!=fitSuppOrderStatusDto){
        	fitSuppOrderStatusDto.setSuppOrderId(suppOrderId);
        	fitSuppOrderStatusRepository.save(fitSuppOrderStatusDto);
        }
        
        FitSuppOrderForFlightCallBackDto flightCallBackDto = fitSuppOrderDto.getFlightCallBackDto();
        logger.info("84...保存反馈字符串："+fitSuppOrderDto.getIsCharterFlightSub()+",,"+flightCallBackDto);
        if(null!=flightCallBackDto){
        	logger.info("保存反馈字符串。。。");
        	flightCallBackDto.setSuppOrderId(suppOrderId);
        	fitSuppOrderForFlightCallBackRepository.save(flightCallBackDto);
        }
        
        return fitSuppOrderDto;
    }

    @Override
    public List<FitSuppOrderDto> queryByFkId(Long fkId) {
    	List<FitSuppOrderDto> suppOrderList = fitSuppOrderMapper.queryByFkId(fkId);
        //获得特殊单 机票相关信息
		for(FitSuppOrderDto suppOrderDto : suppOrderList){
			if (BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId().intValue() == suppOrderDto.getCategoryId().intValue()) {
				
				List<FitSuppFlightOrderDto>  suppFlightOrderDtos = fitSuppFlightOrderRepository.queryByFkId(suppOrderDto.getId());
				suppOrderDto.setSuppFlightOrderDtos(suppFlightOrderDtos);
				
				List<FitSuppOrderForFlightCallBackDto> flightCallBackDtos = fitSuppOrderForFlightCallBackRepository.queryByFkId(suppOrderDto.getId());
				if(CollectionUtils.isNotEmpty(flightCallBackDtos)){
					suppOrderDto.setFlightCallBackDto(flightCallBackDtos.get(0));
				}
				
	        }
			List<FitSuppOrderStatusDto> suppOrderStatusDtos = fitSuppOrderStatusRepository.queryByFkId(suppOrderDto.getId());
			if(CollectionUtils.isNotEmpty(suppOrderStatusDtos)){
				suppOrderDto.setFitSuppOrderStatusDto(suppOrderStatusDtos.get(0));
			}
		}
		return suppOrderList;
    }

    @Override
    public int deleteByFkId(Long fkId) {
        return 0;
    }

	@Override
	public FitSuppOrderDto loadByNo(String no) {
		return fitSuppOrderMapper.getByNo(no);
	}
}
