package com.lvmama.lvfit.adapter.search.adapter.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvfit.adapter.search.adapter.VstProductCalendarSearchAdapter;
import com.lvmama.lvfit.adapter.search.adapter.VstSearchInterfaceWrapper;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpInstalmentDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.utils.FitLoggerHandler;
import com.lvmama.vst.api.vo.PageVo;
import com.lvmama.vst.api.vo.ResultHandleT;
import com.lvmama.vst.api.vo.prod.ProdGroupDateVo;
import com.lvmama.vst.back.order.vo.InstalmentGateWayConfigVO;

@Service
public class VstProductCalendarSearchAdapterImpl implements VstProductCalendarSearchAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(VstProductCalendarSearchAdapterImpl.class);
	
	@Autowired
    private VstSearchInterfaceWrapper vstSearchInterfaceWrapper;
	
	@Autowired
	private FitLoggerHandler fitLoggerHandler;
	
	
	@Override
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> findProdGroupDateByParam(FitSdpProductGroupQueryRequest fitProductGroupQueryRequest) {
		
		FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> result = new FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>();
		ResultHandleT<PageVo<ProdGroupDateVo>> resultHandle = vstSearchInterfaceWrapper.findProdGroupDateByParam(fitProductGroupQueryRequest.getPackagedProductId(), fitProductGroupQueryRequest.getBeginDate(), fitProductGroupQueryRequest.getEndDate());
		
		if(null == resultHandle || null == resultHandle.getReturnContent() || null == resultHandle.getReturnContent().getItems()){
			 throw new ExceptionWrapper(ExceptionCode.GET_NO_SDP_PRODUCT_GROUP_CALENDAR, fitProductGroupQueryRequest.getPackagedProductId());
		}
		
		List<ProdGroupDateVo> items = resultHandle.getReturnContent().getItems();
		List<FitSdpProductCalendarDto> resultLists = new ArrayList<FitSdpProductCalendarDto>();
		if(CollectionUtils.isNotEmpty(items)){
			for (ProdGroupDateVo prodGroupDateVo : items) {
				FitSdpProductCalendarDto fitProduct = new FitSdpProductCalendarDto();
				fitProduct.setProductId(prodGroupDateVo.getProductId());
				fitProduct.setAheadBookTime(prodGroupDateVo.getAheadBookTime());
				fitProduct.setDepartureDate(prodGroupDateVo.getDepartureDate());
				fitProduct.setGroupName(prodGroupDateVo.getGroupName());
				fitProduct.setStockFlag(prodGroupDateVo.getStockFlag());
				fitProduct.setStock(prodGroupDateVo.getStock());
				fitProduct.setSpecDate(prodGroupDateVo.getSpecDate());
				fitProduct.setDisplayType(prodGroupDateVo.getDisplayType());
				fitProduct.setDistributorName(prodGroupDateVo.getDistributorName());
				fitProduct.setLineRouteId(prodGroupDateVo.getLineRouteId());
				BigDecimal childSalePrice = prodGroupDateVo.getLowestSaledChildPrice()==null?new BigDecimal(0):new BigDecimal(prodGroupDateVo.getLowestSaledChildPrice());
				fitProduct.setLowestSaledChildPrice(childSalePrice.divide(new BigDecimal(100)));
				BigDecimal salePrice = prodGroupDateVo.getLowestSaledPrice()==null?new BigDecimal(0):new BigDecimal(prodGroupDateVo.getLowestSaledPrice());
				fitProduct.setLowestSaledPrice(salePrice.divide(new BigDecimal(100)));
				BigDecimal marketPrice = prodGroupDateVo.getMarketPrice()==null?new BigDecimal(0):new BigDecimal(prodGroupDateVo.getMarketPrice());
				fitProduct.setMarketPrice(marketPrice.divide(new BigDecimal(100)));
				resultLists.add(fitProduct);
			}
		}
		if(CollectionUtils.isNotEmpty(resultLists)){
			result.setResults(resultLists);
		}
		return result;
	}
	 
	/**
	 * 得到分期价规则
	 * @param categoryCode
	 * @return
	 */
	@Override
	public List<FitSdpInstalmentDto> getInstalmentInfo(String productId, String categoryCode) {
        try {
        	List<InstalmentGateWayConfigVO> instalmentList = vstSearchInterfaceWrapper.selectInstalmentBycategory(categoryCode.toUpperCase());
             if (CollectionUtils.isEmpty(instalmentList)) {
                return null;
            }
            List<FitSdpInstalmentDto> instalmentDtos = new ArrayList<FitSdpInstalmentDto>();
            boolean flag = true;
            for (InstalmentGateWayConfigVO gateWayConfig : instalmentList) {
                String exclusionProductIds = gateWayConfig.getExclusionProductId();
                if (StringUtils.isNotEmpty(exclusionProductIds)) {
                    String[] productIdArr = exclusionProductIds.split("[,]"); 
                    for (String exclusionIds : productIdArr) {
                        if (exclusionIds.equalsIgnoreCase(productId)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == false) {
                        break;
                    }
                }
                String limitRate = gateWayConfig.getLimitRate();
                if (StringUtils.isNotBlank(limitRate)) {
                    String[] array = limitRate.split(",");
                    if (ArrayUtils.isNotEmpty(array)) {
                        for (String s : array) {
                        	FitSdpInstalmentDto instalmentDto = new FitSdpInstalmentDto();
                            instalmentDto.setBankCode(gateWayConfig.getBankCode());
                            instalmentDto.setBankName(gateWayConfig.getBankName());
                            String[] limitRateArr = s.split("[|]");
                            instalmentDto.setTerm(new BigDecimal(limitRateArr[0]));
                            instalmentDto.setInterestRate(new BigDecimal(limitRateArr[1]));
                            instalmentDtos.add(instalmentDto);
                        }
                    }
                }
            }
            return instalmentDtos;
        } catch (Exception e) {
            logger.error("获取分期信息失败：" + e);
        }
        return null;
    }
}
