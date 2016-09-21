package com.lvmama.lvfit.business.sdpproduct.service;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpCityGroupRequest;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackRequest;

public interface FitSdpProductService {
	
	
	
	/**
	 * 新增或者修改自主打包产品信息
	 * @param productId
	 * @return
	 */
	FitSdpProductBasicInfoDto saveOrUpdateProductBasicInfo(FitSdpProductBasicInfoDto productBasicInfoDto);
	
	/**
	 * 根据自主打包产品Id获取自主打包产品
	 * @param productId
	 * @return
	 */
	FitSdpProductBasicInfoDto getProductBasicInfoByProductId(Long productId);
	
	/**
	 * 分页查询自主打包产品信息
	 * @param baseQueryDto
	 * @return
	 */
	List<FitSdpProductBasicInfoDto> getProductBasicInfosByCondition(BaseQueryDto<FitSdpProductBasicInfoRequest> basicInfoDto);
	
	/**
	 * 根据自主打包产品Id获取自主打包产品交通规则
	 * @param productId
	 * @return
	 */
	List<FitSdpProductTrafficRulesDto> getProductTrafficRulesByProductId(Long productId);
	
	/**
	 * 新增或者修改自主打包产品交通规则(全删全增)
	 * @param productId
	 */
	void saveOrUpdateProductTrafficRules(List<FitSdpProductTrafficRulesDto> trafficRulesDtos);
	
	/**
	 * 根据自主打包产品Id获取自主打包产品费用规则
	 * @param productId
	 * @return
	 */
	List<FitSdpProductFeeRulesDto> getProductFeeRulesByProductId(Long productId);
	
	/**
	 * 新增或者修改自主打包产品费用规则(全删全增)
	 * @param productId
	 */
	void saveOrUpdateProductTFeeRules(List<FitSdpProductFeeRulesDto> feeRulesDtos);

	/**计算根据条件查得的结果总数
	 * @param basicInfoDto
	 * @return
	 */
	int countProductInfoList(BaseQueryDto<FitSdpProductBasicInfoRequest> basicInfoDto);
	
	/**
	 * 根据自主打包产品Id获取自主打包产品城市组
	 * @param productId
	 * @return
	 */
	List<FitSdpCityGroupDto> getProductCityGroupByProductId(Long productId);
	
	/**
	 * 新增或者修改自主打包产品产品城市组
	 * @param productId
	 */
	void saveOrUpdateProductCityGroup(List<FitSdpCityGroupDto> CityGroupDtos);
	/**
	 * 更新索引信息
	 * @param productId
	 */
	public void updateSdpProductSearchIndex(Long productId);
	/**删除产品信息根据产品Id
	 * @param productId
	 * @return
	 */
	int deleteProductByProductId(Long productId);
	
	/**根据查询条件导出Sdp产品数据
	 * @param productId
	 * @return
	 */
	List<String> querySdpProductReport(BaseQueryDto<FitSdpProductBasicInfoRequest> baseQueryDto);

	/**
	 * @param cityGroupDtos
	 */
	void updateCityUseFlagBatch(List<FitSdpCityGroupDto> cityGroupDtos);

	/**根据自主打包产品Id获取自主打包(已选择的)产品城市组
	 * @param productId
	 * @return
	 */
	List<FitSdpCityGroupDto> getSelectCityGroupByProductId(Long productId);

	/**根据产品Id查询索引
	 * @param productId
	 * @return
	 */
	List<FitSdpProductSearchIndexDto> querySdpProductSearchIndex(BaseQueryDto<Long> baseQuery);

	/**根据产品Id查询索引交通信息
	 * @param productId
	 * @return
	 */
	List<FitSdpProductSearchIndexTraffic> querySdpProductIndexTrafficList(BaseQueryDto<Long> baseQuery);
	
	/**编辑单条城市组记录
	 * @param productId
	 * @return
	 */
	void saveEditProductCityGroup(FitSdpCityGroupDto cityGroupDtos);

	/**查询单条城市组记录
	 * @param productId
	 * @return
	 */
	FitSdpCityGroupDto getProductCityGroupById(Long id);
	
	/**条件查询查询城市组记录
	 * @param productId
	 * @return
	 */
	List<FitSdpCityGroupDto> getProductCityGroupByDto(BaseQueryDto<FitSdpCityGroupRequest> dto);
	
	/**条件查询查询城市组记录总数
	 * @param productId
	 * @return
	 */
	int countSdpProductDepartCityRecords(BaseQueryDto<FitSdpCityGroupRequest> baseQueryDto);

	/**查询机票回调信息
	 * @param productId
	 * @return
	 */
	List<FitSuppOrderForFlightCallBackDto> queryFitSuppOrderFlightCallBack(BaseQueryDto<FitSuppOrderForFlightCallBackRequest> dto);

	/**查询机票回调信息总数
	 * @param productId
	 * @return
	 */
	int countSuppOrderForFlightCallBackRecords(BaseQueryDto<FitSuppOrderForFlightCallBackRequest> baseQuery);

	/**根据Id查询产品交通索引
	 * @param productId
	 * @return
	 */
	FitSdpProductSearchIndexTraffic queryTrafficIndexById(Long id);
	
	/**更新产品交通索引记录
	 * @param productId
	 * @return
	 */
	void updateOneTrafficIndex(FitSdpProductSearchIndexTraffic dto);
	
	/**根据vst主订单号获取VST子订单列表
	 * @param productId
	 * @return
	 */
	List<FitFliBookingCallBackRequest> getFlightCallBackByVstMainNo(
			BaseQueryDto<FitFliBookingCallBackRequest> baseQuery);
	
	/**查询所有同步记录
	 * @param 
	 * @return
	 */
	List<FitSdpProductSyncMsgDto> querySdpProductSynMsgInfo(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery);

	/**查询索引记录数
	 * @param 
	 * @return
	 */
	int countSdpProductSearchIndex(BaseQueryDto<Long> baseQuery);
	
	/**查询交通索引记录数
	 * @param 
	 * @return
	 */
	int countSdpProductIndexTraffic(BaseQueryDto<Long> baseQuery);

	/**查询同步索引记录数
	 * @param 
	 * @return
	 */
	int countSdpProductSynMsg(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery);
	
}
