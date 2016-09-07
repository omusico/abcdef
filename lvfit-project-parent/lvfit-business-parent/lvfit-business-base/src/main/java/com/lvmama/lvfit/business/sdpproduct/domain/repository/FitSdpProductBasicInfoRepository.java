package com.lvmama.lvfit.business.sdpproduct.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductBasicInfo;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;

/**
 * 自主打包产品Repository
 */
public interface FitSdpProductBasicInfoRepository extends DomainBaseRepository<FitSdpProductBasicInfo, FitSdpProductBasicInfoDto>{
	
	/**
	 * 根据产品Id获取自主打包产品信息
	 * @return
	 */
	FitSdpProductBasicInfoDto getByProductId(Long productId);

	/**根据产品Id删除自主打包产品信息
	 * @param productId
	 * @return
	 */
	int deleteProductByProductId(Long productId);
	/**根据条件查询自主打包产品信息供导出Excel
	 * @param productId
	 * @return
	 */
	List<FitSdpProductBasicInfoDto> querySdpProductReport(BaseQueryDto<FitSdpProductBasicInfoRequest> baseQueryDto);

	/**根据条件查询产品列表
	 * @param q
	 * @return
	 */
	List<FitSdpProductBasicInfoDto> query(BaseQueryDto<? extends FitSdpProductBasicInfoRequest> q);
	/**根据条件查询产品数量
	 * @param q
	 * @return
	 */
	int count(BaseQueryDto<? extends FitSdpProductBasicInfoRequest> q); 
	
	
	/**
	 * @param dto
	 * @return
	 */
	int updateMultiDepartureFlag(JudgeType muiltDpartureFlag,Long productId);
	
}
