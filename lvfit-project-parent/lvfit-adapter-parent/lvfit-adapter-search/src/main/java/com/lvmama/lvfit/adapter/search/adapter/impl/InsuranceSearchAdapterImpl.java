package com.lvmama.lvfit.adapter.search.adapter.impl;


import java.util.Set;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

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
	public InsuranceSearchResult<InsuranceDto> searchInsurance(InsuranceQueryRequest insuranceQueryRequest) {
		
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
		
		if(resultHandle != null && resultHandle.getReturnContent() != null){
			List<InsuranceDto> result = this.getInsuranceList(resultHandle.getReturnContent());
			try {
				logger.info("调用保险返回结果:insuranceList="+JSONMapper.getInstance().writeValueAsString(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//过滤保险数据
			result = this.handleResult(result,insuranceQueryRequest);
			if(null != result && result.size() > 0){
				InsuranceSearchResult<InsuranceDto> temp = new InsuranceSearchResult<InsuranceDto>();
				temp.setResults(result);
				return temp;
			}
		}
		return null;
	}
	
	/**
	 * 过滤保险数据
	 * @param result
	 * @param insuranceQueryRequest
	 */
	private List<InsuranceDto> handleResult(List<InsuranceDto> result,InsuranceQueryRequest insuranceQueryRequest) {
		List<InsuranceDto> newResult = new ArrayList<InsuranceDto>();
		if(CollectionUtils.isNotEmpty(result)){
			for (InsuranceDto insuranceDto : result) {
				if(CollectionUtils.isNotEmpty(insuranceDto.getInsuranceProductList())){
					List<InsuranceProdProduct> newProductList = new ArrayList<InsuranceProdProduct>();
					for (InsuranceProdProduct insuranceProdProduct : insuranceDto.getInsuranceProductList()) {
						if(CollectionUtils.isNotEmpty(insuranceProdProduct.getInsuranceProductBranchList())){
							List<InsuranceProdProductBranch> newBranchList = new ArrayList<InsuranceProdProductBranch>();
							for (InsuranceProdProductBranch insuranceProdProductBranch : insuranceProdProduct.getInsuranceProductBranchList()) {
								if(CollectionUtils.isNotEmpty(insuranceProdProductBranch.getInsuranceSuppGoodList())){
									List<InsuranceSuppGoods> newGoodsList = new ArrayList<InsuranceSuppGoods>();
									for (InsuranceSuppGoods suppgoods : insuranceProdProductBranch.getInsuranceSuppGoodList()) {
										Boolean isSalse = isGoodsSaleAble(suppgoods,insuranceQueryRequest);
										if(isSalse){
											newGoodsList.add(suppgoods);
										}
									}
									if(CollectionUtils.isNotEmpty(newGoodsList)){
										insuranceProdProductBranch.setInsuranceSuppGoodList(newGoodsList);
										newBranchList.add(insuranceProdProductBranch);
									}
								}
							}
							if(CollectionUtils.isNotEmpty(newBranchList)){
								insuranceProdProduct.setInsuranceProductBranchList(newBranchList);
								newProductList.add(insuranceProdProduct);
							}
						}
					}
					if(CollectionUtils.isNotEmpty(newProductList)){
						insuranceDto.setInsuranceProductList(newProductList);
						newResult.add(insuranceDto);
					}
				}
			}
			return newResult;
		}
		return null;
	}

	/**
	 * 是否可售
	 * @param suppgoods
	 * @param insuranceQueryRequest 
	 * @return
	 */
	private Boolean isGoodsSaleAble(InsuranceSuppGoods suppgoods, InsuranceQueryRequest insuranceQueryRequest) {
		
		//6. 只保留人保的保险 供应商id11502
		if(!String.valueOf(suppgoods.getSupplierId()).equals("11052")){
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
		if(null == suppgoods.getMinQuantity()||insuranceQueryRequest.getPersonNum()<suppgoods.getMinQuantity()){
			return Boolean.FALSE;
		}
		//4. 最大购买量(大于最大)
		if(null == suppgoods.getMaxQuantity()||insuranceQueryRequest.getPersonNum()>suppgoods.getMaxQuantity()){
			return Boolean.FALSE;
		}
		//5. 提前预定时间(保险那边的人已经过滤了)
		return Boolean.TRUE;
	}

	private List<InsuranceDto> getInsuranceList(List<SuppGoodsSaleRe> inSuranceGoodsList) {
		List<InsuranceDto> result = new ArrayList<InsuranceDto>();
		if(CollectionUtils.isNotEmpty(inSuranceGoodsList)){
			for(SuppGoodsSaleRe invo :inSuranceGoodsList){
				InsuranceDto insProductDto = new InsuranceDto();
				insProductDto.setProductId(invo.getProductId());
				insProductDto.setReBranchId(invo.getReBranchId());
				insProductDto.setReType(invo.getReType());
			    insProductDto.setInsuranceProductList(getInsProductList(invo.getInsSuppGoodsList()));
				result.add(insProductDto);
			} 
		}
		return result;
	}
	
	/**
	 *  得到产品列表
	 * @author wanghuihui
	 * @date:2016年3月30日 下午4:03:35
	 * @param insSuppGoodsList
	 * @return
	 */
	private List<InsuranceProdProduct> getInsProductList(List<SuppGoods> insSuppGoodsList) {
		//List<SuppGoods> insSuppGoodsList = vstSuppGoods.getInsSuppGoodsList();
		if(null == insSuppGoodsList || insSuppGoodsList.size() == 0){
			return null;
		}
		
		List<InsuranceProdProduct> insProductList = new ArrayList<InsuranceProdProduct>();
		Set<Long> productSet = new HashSet<Long>();
		for(SuppGoods suppGood : insSuppGoodsList){
			Long productId = suppGood.getProductId();
			ProdProduct prodProduct = suppGood.getProdProduct();
			if(productSet.contains(productId)){
				for(InsuranceProdProduct insuranceProdProduct : insProductList){
					Long id = insuranceProdProduct.getProductId();
					if(productId.equals(id)){
						updateProductBranchGood(suppGood,insuranceProdProduct.getInsuranceProductBranchList());
					}
				}
			}else{
				InsuranceProdProduct insProduc = new InsuranceProdProduct();
				BeanUtils.copyProperties(prodProduct,insProduc);
				insProduc.setInsuranceProductBranchList(getInsProductBranchList(suppGood,prodProduct.getProdProductBranchList()));
				insProductList.add(insProduc);
			}
			productSet.add(productId);
		}
		
		return insProductList;
	}
	
	/**
	 *  已经存在的 产品 的规格更新
	 * @author wanghuihui
	 * @date:2016年3月30日 下午6:56:57
	 * @param suppGood
	 * @param insuranceProductBranchList
	 */
	private void updateProductBranchGood(SuppGoods suppGood,
			List<InsuranceProdProductBranch> insuranceProductBranchList) {
		for(InsuranceProdProductBranch branch : insuranceProductBranchList){
			if(suppGood.getProductBranchId().equals(branch.getProductBranchId())){
				List<InsuranceSuppGoods> insSuppGoods = branch.getInsuranceSuppGoodList();
				if(null == insSuppGoods){
					insSuppGoods = new ArrayList<InsuranceSuppGoods>();
				}
				completeInsSuppGoodsList(suppGood,branch,insSuppGoods);
			}
			
		}
	}

	/**
	 *  得到产品规格 list
	 * @author wanghuihui
	 * @date:2016年3月30日 下午4:44:27
	 * @param suppGood
	 * @param prodProductBranchList
	 * @return
	 */
	private List<InsuranceProdProductBranch> getInsProductBranchList(
			SuppGoods suppGood,List<ProdProductBranch> prodProductBranchList) {
		if(null == prodProductBranchList || prodProductBranchList.size() == 0){
			return null;
		}
		
		List<InsuranceProdProductBranch> insuranceProdProductBranchList = new ArrayList<InsuranceProdProductBranch>();
		for(ProdProductBranch prodProductBranch : prodProductBranchList){
			InsuranceProdProductBranch result = new InsuranceProdProductBranch();
			BeanUtils.copyProperties(prodProductBranch,result);
			if(prodProductBranch.getProductBranchId().equals(suppGood.getProductBranchId())){
				List<InsuranceSuppGoods> suppGoodsDtoList = new ArrayList<InsuranceSuppGoods>();
				result.setInsuranceSuppGoodList(completeInsSuppGoodsList(suppGood,result,suppGoodsDtoList));
			}
			insuranceProdProductBranchList.add(result);
		}
		return insuranceProdProductBranchList;
	}

	/**
	 *  更新 商品列表信息 
	 * @author wanghuihui
	 * @param insSuppGoods 
	 * @param suppGoods 
	 * @date:2016年3月30日 下午3:12:50
	 * @param result || null 
	 * @return
	 */
	private List<InsuranceSuppGoods> completeInsSuppGoodsList(SuppGoods suppGood, InsuranceProdProductBranch insBranch, List<InsuranceSuppGoods> suppGoodsDtoList) {
		if(null == insBranch || null == suppGood){
			return null;
		}
		
		InsuranceSuppGoods suppGoodDto = new InsuranceSuppGoods();
		suppGoodDto.setContractId(suppGood.getContractId());
		suppGoodDto.setProductBranchId(suppGood.getProductBranchId());
		suppGoodDto.setProductId(suppGood.getProductId());
		suppGoodDto.setSuppGoodsId(suppGood.getSuppGoodsId());
		suppGoodDto.setSupplierId(suppGood.getSupplierId());
		suppGoodDto.setGoodsName(suppGood.getGoodsName());
		suppGoodDto.setCancelFlag(suppGood.getCancelFlag());
		suppGoodDto.setOnlineFlag(suppGood.getOnlineFlag());
		suppGoodDto.setMaxQuantity(suppGood.getMaxQuantity());
		suppGoodDto.setMinQuantity(suppGood.getMinQuantity());
		
		if(null != suppGood.getProdProductBranch()){
			InsuranceProdProductBranch branchDto = new InsuranceProdProductBranch();
			BeanUtils.copyProperties(suppGood.getProdProductBranch(),branchDto);
			suppGoodDto.setInsuranceGoodBranch(branchDto);
		}
		
		if(null != suppGood.getSuppGoodsBaseTimePrice()){
			SuppGoodsNotimeTimePrice insTimePrice = (SuppGoodsNotimeTimePrice) suppGood.getSuppGoodsBaseTimePrice();
			InsurancePriceDto noTimePrice = new InsurancePriceDto();
			BeanUtils.copyProperties(insTimePrice, noTimePrice);
			suppGoodDto.setInsPrice(noTimePrice);
		}
		suppGoodsDtoList.add(suppGoodDto);
		insBranch.setInsuranceSuppGoodList(suppGoodsDtoList);
		return suppGoodsDtoList;
	}
	
}
