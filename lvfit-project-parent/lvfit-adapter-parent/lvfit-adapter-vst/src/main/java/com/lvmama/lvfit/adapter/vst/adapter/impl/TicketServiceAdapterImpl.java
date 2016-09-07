package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.vst.adapter.TicketServiceAdapter;
import com.lvmama.lvfit.common.dto.price.FitTicketAddTimePriceDto;
import com.lvmama.lvfit.common.dto.request.FitTicketDetailRequest;
import com.lvmama.lvfit.common.dto.request.FitTicketPriceRequest;
import com.lvmama.lvfit.common.dto.ticket.FitTicketGoodsDetailDto;
import com.lvmama.vst.api.ticket.prod.service.VstTicketGoodsService;
import com.lvmama.vst.api.ticket.prod.vo.SuppGoodsAddTimePriceVo;
import com.lvmama.vst.api.ticket.prod.vo.TicketGoodsVo;
import com.lvmama.vst.api.vo.PageVo;
import com.lvmama.vst.api.vo.ResultHandleT;
import com.lvmama.vst.comm.utils.DateUtil;

@Service
public class TicketServiceAdapterImpl implements TicketServiceAdapter {

	@Autowired
	private VstTicketGoodsService vstTicketGoodsService;
	
	/**
	 * 调用主站门票时间价格表接口
	 * */
	@Override
	public List<FitTicketAddTimePriceDto> findGoodsAddTimePrice(FitTicketPriceRequest ticketPriceRequest){
		
		List<FitTicketAddTimePriceDto> ticketAddTimePriceDtos = new ArrayList<FitTicketAddTimePriceDto>();
		List<SuppGoodsAddTimePriceVo> suppGoodsAddTimePriceVos = new ArrayList<SuppGoodsAddTimePriceVo>();
		ResultHandleT<PageVo<SuppGoodsAddTimePriceVo>> resultHandleT= vstTicketGoodsService.findGoodsAddTimePrice(ticketPriceRequest.getSuppGoodIds(),ticketPriceRequest.getStartDate(),ticketPriceRequest.getEndDate());
		PageVo<SuppGoodsAddTimePriceVo> pageVo = new PageVo<SuppGoodsAddTimePriceVo>();
		if(null != resultHandleT){
			pageVo = resultHandleT.getReturnContent();
		}
		if(null != pageVo){
			suppGoodsAddTimePriceVos = pageVo.getItems();
		}
		for(SuppGoodsAddTimePriceVo vo: suppGoodsAddTimePriceVos){
			FitTicketAddTimePriceDto ticketAddTimePriceDto = new FitTicketAddTimePriceDto();
			//BeanUtils.copyProperties(vo, ticketAddTimePriceDto);
			BigDecimal salePrice = vo.getPrice()==null?new BigDecimal(0):new BigDecimal(vo.getPrice());
			BigDecimal divideSale = salePrice.divide(new BigDecimal(100));//123.1--->124  产品要求
			ticketAddTimePriceDto.setPrice(divideSale.setScale(2, BigDecimal.ROUND_DOWN));
			ticketAddTimePriceDto.setTimePriceId(vo.getTimePriceId());
			ticketAddTimePriceDto.setSuppGoodsId(vo.getSuppGoodsId());
			ticketAddTimePriceDto.setSupplierId(vo.getSupplierId());
			ticketAddTimePriceDto.setSpecDate(vo.getSpecDate());
			ticketAddTimePriceDto.setOnsaleFlag(vo.getOnsaleFlag());
			ticketAddTimePriceDto.setAheadBookTime(vo.getAheadBookTime());
			ticketAddTimePriceDto.setBookLimitType(vo.getBookLimitType());
			ticketAddTimePriceDto.setStockFlag(vo.getStockFlag());
			ticketAddTimePriceDto.setSettlementPrice(vo.getSettlementPrice());
			ticketAddTimePriceDto.setMarkerPrice(vo.getMarkerPrice());
			ticketAddTimePriceDto.setPriceModel(vo.getPriceModel());
			ticketAddTimePriceDtos.add(ticketAddTimePriceDto);
		}
		return ticketAddTimePriceDtos;
	
	}
	
	
	/**
	 *  调用主站门票详情接口
	 * @author yueyufan
	 * @date:2016年02月01日 下午4:50:31
	 * @param 门票查询对象
	 * @return
	 */
	@Override
	public FitTicketGoodsDetailDto findGoodsDetail(FitTicketDetailRequest ticketDetailRequest){
		FitTicketGoodsDetailDto fitTicketGoodsDetailDto = new FitTicketGoodsDetailDto();
		ResultHandleT<TicketGoodsVo> resultHandleT= vstTicketGoodsService.findGoodsDetail(ticketDetailRequest.getSuppGoodsId());
		
		TicketGoodsVo ticketGoodsVo = new TicketGoodsVo();
		if(null != resultHandleT){
			ticketGoodsVo = resultHandleT.getReturnContent();
		}
		if(null != ticketGoodsVo){
			if(null != ticketGoodsVo.getSuppGoodsDescVo()){
				fitTicketGoodsDetailDto.setAge(ticketGoodsVo.getSuppGoodsDescVo().getAge());
				fitTicketGoodsDetailDto.setChangeAddress(ticketGoodsVo.getSuppGoodsDescVo().getChangeAddress());
				fitTicketGoodsDetailDto.setChangeTime(ticketGoodsVo.getSuppGoodsDescVo().getChangeTime());
				fitTicketGoodsDetailDto.setEnterStyle(ticketGoodsVo.getSuppGoodsDescVo().getEnterStyle());
				fitTicketGoodsDetailDto.setEntityTicket(ticketGoodsVo.getSuppGoodsDescVo().getEntityTicket());
				fitTicketGoodsDetailDto.setExpress(ticketGoodsVo.getSuppGoodsDescVo().getExpress());
				fitTicketGoodsDetailDto.setHeight(ticketGoodsVo.getSuppGoodsDescVo().getHeight());
				fitTicketGoodsDetailDto.setLimitTime(ticketGoodsVo.getSuppGoodsDescVo().getLimitTime());
				fitTicketGoodsDetailDto.setOthers(ticketGoodsVo.getSuppGoodsDescVo().getOthers());
				fitTicketGoodsDetailDto.setPriceIncludes(ticketGoodsVo.getSuppGoodsDescVo().getPriceIncludes());
				fitTicketGoodsDetailDto.setRegion(ticketGoodsVo.getSuppGoodsDescVo().getRegion());
			}
			if( null != ticketGoodsVo.getSuppGoodsAdditionVo()){
				//fitTicketGoodsDetailDto.setAheadBookTime(ticketGoodsVo.getSuppGoodsAdditionVo().getAheadBookTime());
				fitTicketGoodsDetailDto.setTodayOnlineFlag(ticketGoodsVo.getSuppGoodsAdditionVo().getTodayOnlineFlag());
			}
			if(null != ticketGoodsVo.getSuppGoodsExpVo()){
				fitTicketGoodsDetailDto.setDays(ticketGoodsVo.getSuppGoodsExpVo().getDays());
				fitTicketGoodsDetailDto.setEndTime(ticketGoodsVo.getSuppGoodsExpVo().getEndTime());
				fitTicketGoodsDetailDto.setEndTimeStr(ticketGoodsVo.getSuppGoodsExpVo().getEndTime()!= null?DateUtil.formatSimpleDate(ticketGoodsVo.getSuppGoodsExpVo().getEndTime()):null);
				fitTicketGoodsDetailDto.setStartTime(ticketGoodsVo.getSuppGoodsExpVo().getStartTime());
				fitTicketGoodsDetailDto.setStartTimeStr(ticketGoodsVo.getSuppGoodsExpVo().getStartTime()!= null?DateUtil.formatSimpleDate(ticketGoodsVo.getSuppGoodsExpVo().getStartTime()):null);
				fitTicketGoodsDetailDto.setUnvalid(ticketGoodsVo.getSuppGoodsExpVo().getUnvalid());
			}
			fitTicketGoodsDetailDto.setAheadBookTime(ticketGoodsVo.getAheadBookTime());//暂时没有找到对应的字段
			fitTicketGoodsDetailDto.setAperiodicFlag(ticketGoodsVo.getAperiodicFlag());
			//fitTicketGoodsDetailDto.setBeforeTralNotice(null);//暂时没有找到对应字段，入园须知
			fitTicketGoodsDetailDto.setCancelStrategy(ticketGoodsVo.getGoodsRefundDescStr());
			fitTicketGoodsDetailDto.setCategoryId(ticketGoodsVo.getCategoryId());
			fitTicketGoodsDetailDto.setGoodsName(ticketGoodsVo.getGoodsName());
			//fitTicketGoodsDetailDto.setGoodsRefundDescStr(ticketGoodsVo.getGoodsRefundDescStr());
			fitTicketGoodsDetailDto.setGoodsSpec(ticketGoodsVo.getGoodsSpec());
			fitTicketGoodsDetailDto.setPayTarget(ticketGoodsVo.getPayTarget());
			fitTicketGoodsDetailDto.setProductBranchId(ticketGoodsVo.getProductBranchId());
			fitTicketGoodsDetailDto.setProductId(ticketGoodsVo.getProductId());
			fitTicketGoodsDetailDto.setSuppGoodsId(ticketGoodsVo.getSuppGoodsId());
			fitTicketGoodsDetailDto.setMaxQuantity(ticketGoodsVo.getMaxQuantity());
		}
		try {
			System.out.println("调用主站查询门票详情接口"+JSONMapper.getInstance().writeValueAsString(fitTicketGoodsDetailDto));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fitTicketGoodsDetailDto;
	
	}
	
}
