package com.lvmama.lvf.common.dto.order.result.detail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.order.result.detail.relation.FlightOrderDetailRelationDto;

/**
 * 订单详情视图对象
 * @author majun
 * @date   2015-3-17
 */
public class FlightOrderDetailViewDto implements Serializable
{
	private static final long serialVersionUID = -6605018639839761151L;

	/** 订单明细基本信息 */
	private FlightOrderDetailBaseDto flightOrderDetailBase;
	
	/** 同主单订单列表 */
	private List<FlightOrderDetailRelationDto> sameOrderDetailRelations;
	
	/** 关联订单列表 */
	private List<FlightOrderDetailRelationDto> flightOrderDetailRelations;
	
	/** 订单详情明细信息 */
	private FlightOrderDetailInfoDto flightOrderDetailInfo;

	public FlightOrderDetailBaseDto getFlightOrderDetailBase() {
		return flightOrderDetailBase;
	}

	public void setFlightOrderDetailBase(
			FlightOrderDetailBaseDto flightOrderDetailBase) {
		this.flightOrderDetailBase = flightOrderDetailBase;
	}

	public List<FlightOrderDetailRelationDto> getSameOrderDetailRelations() {
		return sameOrderDetailRelations;
	}

	public void setSameOrderDetailRelations(
			List<FlightOrderDetailRelationDto> sameOrderDetailRelations) {
		this.sameOrderDetailRelations = sameOrderDetailRelations;
	}

	public List<FlightOrderDetailRelationDto> getFlightOrderDetailRelations() {
		return flightOrderDetailRelations;
	}

	public void setFlightOrderDetailRelations(
			List<FlightOrderDetailRelationDto> flightOrderDetailRelations) {
		this.flightOrderDetailRelations = flightOrderDetailRelations;
	}

	public FlightOrderDetailInfoDto getFlightOrderDetailInfo() {
		return flightOrderDetailInfo;
	}

	public void setFlightOrderDetailInfo(
			FlightOrderDetailInfoDto flightOrderDetailInfo) {
		this.flightOrderDetailInfo = flightOrderDetailInfo;
	}
	
	/**
	 * 根据同主单订单列表生成关联订单列表
	 * @param 	orderId									当前订单主键
	 */
	public void generateRelationOrdersBySameOrders(Long orderId)
	{
		if(CollectionUtils.isNotEmpty(this.sameOrderDetailRelations))
		{
			//1、将同主单订单列表按照订单Root主键分组，并获取当前订单主键对应的订单Root主键
			Long orderRootId = null;
			Map<Long, List<FlightOrderDetailRelationDto>> tempMap = new HashMap<Long, List<FlightOrderDetailRelationDto>>();
			for(FlightOrderDetailRelationDto flightOrderDetailRelationDto : this.sameOrderDetailRelations)
			{
				//1.1、将同主单订单列表按照订单Root主键分组
				Long tempOrderRootId = flightOrderDetailRelationDto.getOrderRootId();
				if(tempMap.containsKey(tempOrderRootId))
					tempMap.get(tempOrderRootId).add(flightOrderDetailRelationDto);
				else
				{
					 List<FlightOrderDetailRelationDto> tempList = new ArrayList<FlightOrderDetailRelationDto>();
					 tempList.add(flightOrderDetailRelationDto);
					 tempMap.put(tempOrderRootId, tempList);
				}
				
				//1.2、获取当前订单主键对应的订单Root主键
				if(flightOrderDetailRelationDto.getOrderId().longValue() == orderId.longValue())
					orderRootId = tempOrderRootId;
			}
			
			//2、获取当前订单对应的关联订单列表
			this.flightOrderDetailRelations = tempMap.get(orderRootId);
			Collections.sort(this.flightOrderDetailRelations, new Comparator<FlightOrderDetailRelationDto>() 
					{
				@Override
				public int compare(FlightOrderDetailRelationDto o1, FlightOrderDetailRelationDto o2) 
				{
					return o1.getOrderSortCode().compareTo(o2.getOrderSortCode());
				}
			});
		}
	}
}
