package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.adapter.vst.adapter.ComCoordinateServiceAdapter;
import com.lvmama.lvfit.adapter.vst.handle.VSTLoggerHandler;
import com.lvmama.vst.back.client.pub.service.ComCoordinateClientService;
import com.lvmama.vst.back.pub.po.ComCoordinate;
import com.lvmama.vst.comm.vo.ResultHandleT;

@Service
@Deprecated
public class ComCoordinateServiceAdapterImpl implements	ComCoordinateServiceAdapter {
	
	private VSTLoggerHandler logger;
	@Autowired
	private ComCoordinateClientService comCoordinateClientService;
	
	@Override
	public ResultHandleT<List<ComCoordinate>> getComCoordinateByDestId(Long id) {
		ResultHandleT<List<ComCoordinate>> result = comCoordinateClientService.findComCoordinateByDestId(id);
		return result;
	}
	@Override
	public ResultHandleT<ComCoordinate> getComCoordinateByDestIdAndType(Long id,String coordType) {
		ResultHandleT<ComCoordinate> result = comCoordinateClientService.findComCoordinateByDestIdAndType(id,coordType);
		return result;
	}
	@Override
	public ResultHandleT<List<ComCoordinate>>  getComCoordinateByProductId(Long productId){
		ResultHandleT<List<ComCoordinate>> result = comCoordinateClientService.findComCoordinateByProductId(productId);
		return result;
	}

	
}
