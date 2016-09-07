package com.lvmama.lvfit.offline.sdpproduct.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.csv.CsvUtils;
import com.lvmama.lvfit.common.client.FitBatchClient;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.FitVstServiceClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.BizEnum.BIZ_CATEGORY_TYPE;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndex;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSynMsg;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequestForm;
import com.lvmama.lvfit.common.dto.vst.VstPushRecord;
import com.lvmama.lvfit.common.form.product.FitSdpProductBasicInfoForm;
import com.lvmama.lvfit.common.utils.FitCsvConfig;
import com.lvmama.lvfit.offline.sdpproduct.SdpProductController;

@Controller
public class SdpProductControllerImpl  implements SdpProductController{
	
	 private static final Logger logger = LoggerFactory.getLogger(SdpProductControllerImpl.class);

	@Autowired
	private FitBusinessClient fitBusinessClient;
	
	@Autowired
	private FitVstServiceClient fitVstServiceClient;
	
	@Autowired
	private FitBatchClient fitBatchClient;
	 
	@Override
	@RequestMapping(value = "sdpProduct/query", method = { RequestMethod.POST, RequestMethod.GET })
	public String showSdpProductList(Model model) {
		buildOrderModel(model);
		return "product/product_list";
	}
	@Override
	@RequestMapping(value = "sdpProduct/syncQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public String showSdpProductSyncList(Model model) {
		buildOrderModel(model);
		return "product/product_syn_index_list";
	}
	
	@RequestMapping(value = "sdpProduct/searchIndex", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchIdIndex(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		return "product/product_search_index";
	}
	
	@RequestMapping(value = "sdpProduct/searchSynInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchSynInfo(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		return "product/product_syn_msg_list";
	}
	
	@RequestMapping(value = "sdpProduct/searchPushInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchPushInfo(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		return "product/product_push_info_list";
	}
	
	@RequestMapping(value = "sdpProduct/searchTrafficIndex", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchTrafficIndex(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		return "product/product_traffic_index_list";
	}
	
	
	private void buildOrderModel(Model model) {
		model.addAttribute("JudgeType", JudgeType.values());   //订单状态
		List<BIZ_CATEGORY_TYPE> categoryTypeList = new ArrayList<BIZ_CATEGORY_TYPE>();
		categoryTypeList.add(BizEnum.BIZ_CATEGORY_TYPE.category_route_group);
		categoryTypeList.add(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom);

		model.addAttribute("BIZ_CATEGORY_TYPE",categoryTypeList);
	}

	@ResponseBody
	@RequestMapping(value = "sdpProduct/querySearchIndexList", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpProductSearchIndex> querySdpProductList(Model model, Long productId,Pagination pg) {
		BaseResultDto<FitSdpProductSearchIndex> result = new BaseResultDto<FitSdpProductSearchIndex>();
		try {
			if(productId!=null){
				result = fitBusinessClient.querySdpProductSearchIndexList(productId);
				List<FitSdpProductSearchIndex> list = result.getResults();
				List<FitSdpProductSearchIndex> res = new ArrayList<FitSdpProductSearchIndex>();
				int start = (pg.getPage()-1)*pg.getRows();
				for(int i=0;i<pg.getRows();i++){
					if(list.size()>(start+i)){
						res.add(list.get(start+i));
					}else{
						break;
					}
				}
				result.setResults(res);
				pg.setTotal((list.size()+pg.getRows()-1)/pg.getRows());
				pg.setRecords(list.size());
				result.setPagination(pg);
				return result;
			}
		} catch (Exception e) {
			logger.error("查询产品Id索引失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/querySynInfoList", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpProductSynMsg> querySynInfoList(Model model,Long productId,Pagination pg) {
		BaseResultDto<FitSdpProductSynMsg> result = new BaseResultDto<FitSdpProductSynMsg>();
		try {
			if(productId!=null){
				result = fitBusinessClient.querySdpProductSynInfoList(productId);
				List<FitSdpProductSynMsg> list = result.getResults();
				List<FitSdpProductSynMsg> res = new ArrayList<FitSdpProductSynMsg>();
				int start = (pg.getPage()-1)*pg.getRows();
				for(int i=0;i<pg.getRows();i++){
					if(list.size()>(start+i)){
						res.add(list.get(start+i));
					}else{
						break;
					}
				}
				result.setResults(res);
				pg.setTotal((list.size()+pg.getRows()-1)/pg.getRows());
				pg.setRecords(list.size());
				result.setPagination(pg);
				return result;
			}
		} catch (Exception e) {
			logger.error("查询产品同步信息失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/queryTrafficIndexList", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpProductSynMsg> queryTrafficIndexList(Model model,Long productId,Pagination pg) {
		BaseResultDto<FitSdpProductSynMsg> result = new BaseResultDto<FitSdpProductSynMsg>();
		try {
			if(productId!=null){
				result = fitBusinessClient.querySdpProductSynInfoList(productId);
				List<FitSdpProductSynMsg> list = result.getResults();
				List<FitSdpProductSynMsg> res = new ArrayList<FitSdpProductSynMsg>();
				int start = (pg.getPage()-1)*pg.getRows();
				for(int i=0;i<pg.getRows();i++){
					if(list.size()>(start+i)){
						res.add(list.get(start+i));
					}else{
						break;
					}
				}
				result.setResults(res);
				pg.setTotal((list.size()+pg.getRows()-1)/pg.getRows());
				pg.setRecords(list.size());
				result.setPagination(pg);
				return result;
			}
		} catch (Exception e) {
			logger.error("查询产品同步信息失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/querySearchPushInfoList", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<VstPushRecord> querySearchPushInfoList(Model model, Long productId,Pagination pg) {
		BaseResultDto<VstPushRecord> result = new BaseResultDto<VstPushRecord>();
		try {
			if(productId!=null){
				result = fitVstServiceClient.queryPushInfoList(productId);
				List<VstPushRecord> list = result.getResults();
				List<VstPushRecord> res = new ArrayList<VstPushRecord>();
				int start = (pg.getPage()-1)*pg.getRows();
				for(int i=0;i<pg.getRows();i++){
					if(list.size()>(start+i)){
						res.add(list.get(start+i));
					}else{
						break;
					}
				}
				result.setResults(res);
				pg.setTotal((list.size()+pg.getRows()-1)/pg.getRows());
				pg.setRecords(list.size());
				result.setPagination(pg);
				return result;
			}
		} catch (Exception e) {
			logger.error("查询产品Id索引失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@ResponseBody
	@RequestMapping(value = "sdpProduct/productQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpProductBasicInfoForm> querySdpProductList(Model model, FitSdpProductBasicInfoRequestForm requestForm) {
		
		BaseQueryDto<FitSdpProductBasicInfoRequest> baseQuery = new BaseQueryDto<FitSdpProductBasicInfoRequest>();
				//new Pagination(),fitSdpProductBasicInfoRequest);
		baseQuery.setPagination(requestForm.getPagination());
		baseQuery.setCondition(requestForm.getRequest());
		
		BaseResultDto<FitSdpProductBasicInfoForm>  baseResponse = new BaseResultDto<FitSdpProductBasicInfoForm>();
		try {
			BaseResultDto<FitSdpProductBasicInfoDto> baseResultDto = fitBusinessClient.querySdpProductBasicInfoList(baseQuery);
			List<FitSdpProductBasicInfoDto> results = baseResultDto.getResults();
			List<FitSdpProductBasicInfoForm> resultFormList = new ArrayList<FitSdpProductBasicInfoForm>();
			if(CollectionUtils.isNotEmpty(results)){
				for(FitSdpProductBasicInfoDto dto : results){
					FitSdpProductBasicInfoForm form = new FitSdpProductBasicInfoForm();
					form.setFitSdpProductBasicInfoDto(dto);
					resultFormList.add(form);
				}
				baseResponse.setResults(resultFormList);
				baseResponse.setPagination(baseResultDto.getPagination());
			}
		} catch (Exception e) {
			logger.error("自主打包产品查询失败！");
			e.printStackTrace();
		}
		return baseResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/deleteProductInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> deleteProductInfo(Model model, Long productId){
		try {
			if(productId!=null){
				ResultStatus returnStr = fitBusinessClient.deleteSdpProductInfoByProductId(productId);
				Map<String,String> map = new HashMap<String,String>();map.put("returnStr", returnStr.name());
				return map;
			}
		} catch (Exception e) {
			logger.error("自主打包产品信息删除失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/trafficRulesQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public List<FitSdpProductTrafficRulesDto> queryTrafficRules(Model model, Long productId) {
		try {
			List<FitSdpProductTrafficRulesDto> baseResultDto = fitBusinessClient.getProductTrafficRulesByProductId(productId);
			
			if(baseResultDto != null)	{
				return baseResultDto;
			}
		} catch (Exception e) {
			logger.error("自主打包产品查询失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/trafficRulesSave", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> saveOrUpdateProductTrafficRules(Model model,String productTrafficRulesDtosStr){
		try {
			JavaType javaType = JSONMapper.getInstance().getTypeFactory().constructParametricType(ArrayList.class, FitSdpProductTrafficRulesDto.class);
			List<FitSdpProductTrafficRulesDto> list = new ArrayList<FitSdpProductTrafficRulesDto>();
			list = JSONMapper.getInstance().readValue(productTrafficRulesDtosStr, javaType);
			String returnStr = fitBusinessClient.saveOrUpdateProductTrafficRules(list);
			this.updateSdpProductSearchIndex(list.get(0).getProductId());
			Map<String,String> map = new HashMap<String,String>();map.put("returnStr", returnStr);
			return map;
		} catch (Exception e) {
			logger.error("自主打包产品交通规则保存失败！");
			e.printStackTrace();
		}
		return null;//'Success'：成功
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/feeRulesQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public List<FitSdpProductFeeRulesDto> queryFeeRules(Model model, Long productId) {
		try {
			List<FitSdpProductFeeRulesDto> baseResultDto = fitBusinessClient.getProductFeeRulesByProductId(productId);
			
			if(baseResultDto != null)	{
				return baseResultDto;
			}
		} catch (Exception e) {
			logger.error("自主打包产品加价规则查询失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/feeRulesSave", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> saveOrUpdateProductFeeRules(Model model,FitSdpProductFeeRulesDto fitSdpProductFeeRulesDto){
	    try {
			List<FitSdpProductFeeRulesDto> list = new ArrayList<FitSdpProductFeeRulesDto>();
			list.add(fitSdpProductFeeRulesDto);
			String returnStr = fitBusinessClient.saveOrUpdateProductFeeRules(list);
			this.updateSdpProductSearchIndex(fitSdpProductFeeRulesDto.getProductId());
			Map<String,String> map = new HashMap<String,String>();map.put("returnStr", returnStr);
			return map;
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/cityGroupQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public List<FitSdpCityGroupDto> queryCityGroup(Model model, Long productId) {
		try {
			List<FitSdpCityGroupDto> baseResultDto = fitBusinessClient.getProductCityGroupByProductId(productId);
			
			if(baseResultDto != null)	{
				return baseResultDto;
			}
		} catch (Exception e) {
			logger.error("自主打包产品城市组查询失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/updateCitysUseFlag", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> updateCityGroupUseFlag(Model model,String cityGroupDtosStr){
	    try {
	    	JavaType javaType = JSONMapper.getInstance().getTypeFactory().constructParametricType(ArrayList.class, FitSdpCityGroupDto.class);
			List<FitSdpCityGroupDto> list = new ArrayList<FitSdpCityGroupDto>();
			list = JSONMapper.getInstance().readValue(cityGroupDtosStr, javaType);
			
			ResultStatus returnStr = fitBusinessClient.updateCityUseFlagBatch(list);
			this.updateSdpProductSearchIndex(list.get(0).getProductId());
			Map<String,String> map = new HashMap<String,String>();map.put("returnStr", returnStr.name());
			return map;
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
	
   @Async
	private void updateSdpProductSearchIndex(Long productId) {
		try {
			fitBatchClient.syncSdpProductSearchIndex(productId);
		} catch (Exception e) {
			logger.error("自主打包产品【"+productId+"】同步索引失败败！");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/syncSearchIndex", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> syncSdpProductSearchIndex(Model model,Long productId){
		try {
			if(productId!=null){
				ResultStatus returnStr = fitBatchClient.syncSdpProductSearchIndex(productId);
				Map<String,String> map = new HashMap<String,String>();
				map.put("returnStr", returnStr.name());
				return map;
			}
			
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "sdpProduct/productExportCsv", method = { RequestMethod.POST, RequestMethod.GET })
	public void productExportCsv(FitSdpProductBasicInfoRequestForm requestForm,HttpServletResponse response){
		
		BaseQueryDto<FitSdpProductBasicInfoRequest> baseQuery = new BaseQueryDto<FitSdpProductBasicInfoRequest>();
		baseQuery.setPagination(requestForm.getPagination());
		baseQuery.setCondition(requestForm.getRequest());
		/**
         * 加载数据
         */
        List<String> revenueReportStrings = fitBusinessClient.querySdpProductExportCsv(baseQuery);
        
        /**
         * 输出流
         */  
        CsvUtils.createCsvStream(FitCsvConfig.FIT_PRODUCT_REPORT_LIST, revenueReportStrings, response);
		
	}
}
