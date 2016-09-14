package com.lvmama.lvfit.adapter.search.adapter.impl;


import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.vst.api.vo.prod.GoodsBaseVo;
import com.lvmama.vst.api.vo.prod.ProdProductPropBaseVo;
import com.lvmama.vst.api.vo.prod.ProductBaseVo;
import com.lvmama.vst.api.vo.prod.ProductBranchBaseVo;
import com.lvmama.vst.back.goods.po.SuppGoodsBaseTimePrice;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.InsuranceSearchAdapter;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsurancePriceDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProduct;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProductBranch;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceSuppGoods;
import com.lvmama.lvfit.common.utils.FitLoggerHandler;
import com.lvmama.vst.back.client.goods.service.SuppGoodsSaleReClientService;
import com.lvmama.vst.back.goods.po.SuppGoods;
import com.lvmama.vst.back.goods.po.SuppGoodsNotimeTimePrice;
import com.lvmama.vst.back.goods.po.SuppGoodsSaleRe;
import com.lvmama.vst.back.prod.po.ProdProduct;
import com.lvmama.vst.back.prod.po.ProdProductBranch;
import com.lvmama.vst.comm.vo.ResultHandleT;


@Service
public class InsuranceSearchAdapterImpl implements InsuranceSearchAdapter {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(InsuranceSearchAdapterImpl.class);
	
	@Autowired
	private SuppGoodsSaleReClientService suppGoodsSaleReClientService;
	
	@Autowired
	private FitLoggerHandler fitLoggerHandler;

	@Override
	public List<InsuranceDto> searchInsurance(InsuranceQueryRequest insuranceQueryRequest) {
		
		/** 产品ID  **/
		Long currentProductId = insuranceQueryRequest.getCurrentProductId();
		/** 渠道ID  **/
		Long distributorId = insuranceQueryRequest.getDistributorId();
		/** 游玩日期  **/
		Date vistorDate = insuranceQueryRequest.getVistorDate();
		/** 游玩天数  **/
		Long insuranceDays = insuranceQueryRequest.getInsuranceDays();
		
		String gid= UUID.randomUUID().toString();
		Object returnObj = null;
		fitLoggerHandler.addFitLog(RequestResponse.RE.toString(), InterfaceKey.SearchInsuranceInfoFromVst.name(), insuranceQueryRequest, StringUtils.EMPTY, gid);
		ResultHandleT<List<com.lvmama.vst.back.goods.po.SuppGoodsSaleRe>> resultHandle = null ;
		try {
			resultHandle =suppGoodsSaleReClientService.selectInsuranceGoodSaleResListByInsurDays(currentProductId, distributorId, vistorDate, insuranceDays);
			returnObj = resultHandle;
		} catch (Exception e) {
			returnObj = ExceptionUtils.getFullStackTrace(e);
			throw new RuntimeException(e);
		}finally{
			fitLoggerHandler.addFitLog(RequestResponse.RS.toString(), InterfaceKey.SearchInsuranceInfoFromVst.name(), returnObj, StringUtils.EMPTY, gid);
		}
		
		if(CollectionUtils.isNotEmpty(resultHandle.getReturnContent())) {
			List<InsuranceDto> insuranceList = this.getInsuranceList(resultHandle.getReturnContent().get(0).getInsSuppGoodsList(), insuranceQueryRequest.getPersonNum());
			try {
				logger.info("调用保险返回结果:insuranceList="+JSONMapper.getInstance().writeValueAsString(insuranceList));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return insuranceList;
		}
		return null;
	}

	/**
	 * 是否可售
	 * @return
	 */
	private Boolean isGoodsSaleAble(SuppGoods suppgoods, int count) {
		
		//6. 只保留人保的保险 供应商id11502
		if(!String.valueOf(suppgoods.getSupplierId()).equals("11052")) {
			return Boolean.FALSE;
		}
		//1. 可售性
		if("N".equalsIgnoreCase(suppgoods.getCancelFlag())){
			return Boolean.FALSE;
		}
		//2. 有效性
		if("N".equalsIgnoreCase(suppgoods.getOnlineFlag())){
			return Boolean.FALSE;
		}
		//3. 最小购买量(小于最小)
		if(null == suppgoods.getMinQuantity() || count < suppgoods.getMinQuantity()){
			return Boolean.FALSE;
		}
		//4. 最大购买量(大于最大)
		if(null == suppgoods.getMaxQuantity() || count > suppgoods.getMaxQuantity()){
			return Boolean.FALSE;
		}
		//5. 提前预定时间(保险那边的人已经过滤了)
		return Boolean.TRUE;
	}

	private List<InsuranceDto> getInsuranceList(List<SuppGoods> suppGoodsList, int count) {
		List<InsuranceDto> insurances = new ArrayList<InsuranceDto>();

		for (SuppGoods suppGoods : suppGoodsList) {
			if (!isGoodsSaleAble(suppGoods, count)) {
				continue;
			}
			ProdProduct prodProduct = suppGoods.getProdProduct();

			InsuranceDto insurance = new InsuranceDto();
			insurance.setProductId(prodProduct.getProductId());
			insurance.setProductName(prodProduct.getProductName());
			insurance.setGoodsName(suppGoods.getGoodsName());
			insurance.setSuppGoodsId(suppGoods.getSuppGoodsId());
			insurance.setMinQuantity(suppGoods.getMinQuantity());
			insurance.setMaxQuantity(suppGoods.getMaxQuantity());

			ProdProductBranch prodProductBranch = suppGoods.getProdProductBranch();
			insurance.setBranchId(prodProductBranch.getBranchId());
			insurance.setBranchName(prodProductBranch.getBranchName());
			if (prodProductBranch.getPropValue() != null
				&& prodProductBranch.getPropValue().get("branch_desc") != null) {
				insurance.setBranchDesc(prodProductBranch.getPropValue().get("branch_desc").toString());
			}

			SuppGoodsNotimeTimePrice timePrice = (SuppGoodsNotimeTimePrice) suppGoods.getSuppGoodsBaseTimePrice();

			insurance.setPrice(BigDecimal.valueOf(timePrice.getPriceYuan()));
			// 产品推荐级别
			insurance.setProRecommendLvl(prodProduct.getRecommendLevel().intValue());
			// 商品推荐级别
			insurance.setBranchRecommendLvl(prodProductBranch.getRecommendLevel().intValue());
			// 产品类型
			insurance.setProductType(prodProduct.getProductType());

			insurances.add(insurance);
		}
		return insurances;
	}
}
