package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitSuppMainOrder;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderPassengerRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppFlightOrderRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppMainOrderRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppMainOrderStatusRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderRepository;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSuppMainOrderMapper;

/**
 * @author qihuisong
 */
@Repository
public class FitSuppMainOrderRepositoryImpl implements FitSuppMainOrderRepository {
	
	
	Logger logger = LoggerFactory.getLogger(FitSuppMainOrderRepositoryImpl.class);
    
	@Autowired
    private FitSuppMainOrderMapper fitSuppMainOrderMapper;    		//供应商关系主单
    
	@Autowired
    private FitSuppOrderRepository fitSuppOrderRepository;  					//供应商关系订单关系
    
	@Autowired
    private FitSuppFlightOrderRepository fitSuppFlightOrderRepository; //供应商 飞机票关系
    
	@Autowired
    private FitSuppFlightOrderDetailRepositoryImpl fitSuppFlightOrderDetailRepositoryImpl;//供应商 买票票详情
    
	@Autowired
    private FitSuppMainOrderStatusRepository fitSuppMainOrderStatusRepository;

	@Autowired
	private FitOrderPassengerRepository fitOrderPassengerRepository;
	
    @Autowired
    private FitVstClient fitVstClient; 
    
    @Override
    public FitSuppMainOrderDto load(Long id) {
    	
    	//加载数据
		FitSuppMainOrderDto suppMainOrderDto = fitSuppMainOrderMapper.getById(id);
		if(null == suppMainOrderDto){
			return null;
		}
		this.completeSuppMainOrderInfo(suppMainOrderDto);
		return suppMainOrderDto;
    }

    private void completeSuppMainOrderInfo(FitSuppMainOrderDto suppMainOrderDto) {
		//获得供应商信息
		List<FitSuppOrderDto>  fitSuppOrderDtos = fitSuppOrderRepository.queryByFkId(suppMainOrderDto.getId());
		suppMainOrderDto.setFitSuppOrderDtos(fitSuppOrderDtos);
		
		//获取订单状态信息
		List<FitSuppMainOrderStatusDto> suppMainOrderStatusDtos = fitSuppMainOrderStatusRepository.queryByFkId(suppMainOrderDto.getId());
		if(CollectionUtils.isNotEmpty(suppMainOrderStatusDtos)){
			suppMainOrderDto.setFitSuppMainOrderStatus(suppMainOrderStatusDtos.get(0));
		}
		
		//对于包机而言，子单是直接关联在主单上面的
		List<FitOrderPassengerDto> passengers = fitOrderPassengerRepository.queryByFkId(suppMainOrderDto.getFitMainOrderId());
		List<FitSuppFlightOrderDto>  charsetFlights = fitSuppFlightOrderRepository.queryByFkId(-suppMainOrderDto.getId()); 
		suppMainOrderDto.setSuppFlightOrderDtos(charsetFlights);
		suppMainOrderDto.setAllPassengerDtos(passengers);
		
		for(FitSuppFlightOrderDto fligthOrderDto : charsetFlights){
			List<FitSuppFlightOrderDetailDto> suppFlightDetailList = fitSuppFlightOrderDetailRepositoryImpl.queryByFkId(fligthOrderDto.getId());
			fligthOrderDto.setSuppFlightOrderDetailDtos(suppFlightDetailList);
		}
		
		//获得特殊单 机票相关信息
		for(FitSuppOrderDto suppOrder : fitSuppOrderDtos){
			if (BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId() == suppOrder.getCategoryId()) {
				List<FitSuppFlightOrderDto>  suppFlightList = fitSuppFlightOrderRepository.queryByFkId(suppOrder.getId());
				suppOrder.setSuppFlightOrderDtos(suppFlightList);
				for(FitSuppFlightOrderDto fligthOrderDto : suppFlightList){
					List<FitSuppFlightOrderDetailDto> suppFlightDetailList = fitSuppFlightOrderDetailRepositoryImpl.queryByFkId(fligthOrderDto.getId());
					fligthOrderDto.setSuppFlightOrderDetailDtos(suppFlightDetailList);
				}
	        }
		}
	}

    @Override
    public FitSuppMainOrder load(FitSuppMainOrderDto fitSuppMainOrderDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitSuppMainOrderDto save(FitSuppMainOrderDto fitSuppMainOrderDto) {
        if (null == fitSuppMainOrderDto.getId()) {
            fitSuppMainOrderMapper.insert(fitSuppMainOrderDto);
        }else {
            fitSuppMainOrderMapper.updateById(fitSuppMainOrderDto.getId(), fitSuppMainOrderDto);
        }
        
        FitSuppMainOrderStatusDto fitSuppMainOrderStatusDto = fitSuppMainOrderDto.getFitSuppMainOrderStatus();
        if(null!=fitSuppMainOrderStatusDto){
        	fitSuppMainOrderStatusDto.setSuppMainOrderId(fitSuppMainOrderDto.getId());
        	fitSuppMainOrderStatusDto.setVstMainOrderNo(fitSuppMainOrderDto.getVstMainOrderNo());
        	fitSuppMainOrderStatusRepository.save(fitSuppMainOrderStatusDto);
        }
        
        Long suppMainOrderId = fitSuppMainOrderDto.getId();
        List<FitSuppOrderDto> suppOrderDtos = fitSuppMainOrderDto.getFitSuppOrderDtos();
        if(CollectionUtils.isNotEmpty(suppOrderDtos)){
            for (FitSuppOrderDto suppOrderDto : suppOrderDtos) {
                suppOrderDto.setSuppMainOrderId(suppMainOrderId);
                fitSuppOrderRepository.save(suppOrderDto);
           }
        }
        
        return fitSuppMainOrderDto;
    }

    @Override
    public List<FitSuppMainOrderDto> queryByFkId(Long fkId) {
    	List<FitSuppMainOrderDto>  suppMainOrderDtos =  fitSuppMainOrderMapper.queryByFkId(fkId);
    	if(CollectionUtils.isNotEmpty(suppMainOrderDtos)){
    		for (FitSuppMainOrderDto suppMainOrderDto : suppMainOrderDtos) {
				this.completeSuppMainOrderInfo(suppMainOrderDto);
			}
    	}
    	return suppMainOrderDtos;
    }

    @Override
    public int deleteByFkId(Long fkId) {
        return 0;
    }

}
