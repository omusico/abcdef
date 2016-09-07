package com.lvmama.lvfit.business.order.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.business.order.domain.repository.FitSuppMainOrderStatusRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderStatusRepository;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;


/**
 * 订单同步service
 * @author leizhengwei
 *
 */
@Service
public class OrderSyncServiceImpl implements OrderSyncService {
	
	private static Logger logger = LoggerFactory.getLogger(OrderSyncServiceImpl.class);
	
	@Autowired
    private 	FitVstClient  fitVstClient;  
	
	@Autowired
	private FitSuppMainOrderStatusRepository  fitSuppMainOrderStatusRepository;
	
	@Autowired
	private FitSuppOrderStatusRepository  fitSuppOrderStatusRepository;
	
	@Autowired
	private FitSuppOrderRepository  fitSuppOrderRepository;


	@Override
	public FitSuppMainOrderStatusDto syncSuppMainOrderStatus(Long vstOrderMainNo) {
		FitSuppMainOrderStatusDto suppMainOrderStatusDto =  fitVstClient.getVstOrderStatusByVstOrderMainNo(vstOrderMainNo);
		fitSuppMainOrderStatusRepository.updateByVstMainOrderNo(suppMainOrderStatusDto);
		List<FitSuppOrderStatusDto> suppOrderStatusDtos = suppMainOrderStatusDto.getSuppOrderStatusDtos();
		if(CollectionUtils.isNotEmpty(suppOrderStatusDtos)){
			for (FitSuppOrderStatusDto suppOrderStatusDto : suppOrderStatusDtos) {
				FitSuppOrderStatusDto curSuppOrderStatusDto = fitSuppOrderStatusRepository.getByVstOrderNo(suppOrderStatusDto.getVstOrderNo());
				if(curSuppOrderStatusDto==null){
					//之前无子订单状态的需要构建子订单状态信息
					FitSuppOrderDto  fitSuppOrderDto = fitSuppOrderRepository.loadByNo(String.valueOf(suppOrderStatusDto.getVstOrderNo()));
					if(fitSuppOrderDto!=null){
						suppOrderStatusDto.setSuppOrderId(fitSuppOrderDto.getId());
						suppOrderStatusDto.setVstOrderNo(fitSuppOrderDto.getVstOrderNo());
						fitSuppOrderStatusRepository.save(suppOrderStatusDto);
					}
				}else{
					//之前存在子订单状态的更新状态即可
					fitSuppOrderStatusRepository.updateByVstOrderNo(suppOrderStatusDto);
				}
				
			}
		}
		return suppMainOrderStatusDto;
	}

	@Override
	public List<FitSuppMainOrderStatusDto> queryNeedToSyncSuppMainOrderStatus() {

		return fitSuppMainOrderStatusRepository.queryNeedToSync();
	}
	
}
