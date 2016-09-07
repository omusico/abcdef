package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;

public interface FitSdpProductBasicInfoMapper extends DomainEntityBaseMapper<FitSdpProductBasicInfoDto, BaseQueryDto<? extends FitSdpProductBasicInfoDto>>,
DomainEntityByFkIdMapper<FitSdpProductBasicInfoDto>{
     
	/**
	 * 获取可生成索引的自主打包产品信息
	 * @return
	 */
	List<Long> getCanSyncProductsByModValue(@Param("syncMachineCount")Integer syncMachineCount,
											@Param("startRow")Integer startRow,
											@Param("endRow")Integer endRow,
											@Param("modValue")Integer modValue);

	/**
	 * 获取可生成索引的自主打包产品数量
	 * @param syncMachineCount
	 * @param modValue
     * @return
     */
	int getCanSyncProductCountsByModValue(@Param("syncMachineCount")Integer syncMachineCount,
										  @Param("startRow")Integer startRow,
										  @Param("endRow")Integer endRow,
										  @Param("modValue")Integer modValue);
	
	/**
	 * 根据产品Id获取自主打包产品信息
	 * @return
	 */
	FitSdpProductBasicInfoDto getByProductId(Long productId); 
	
	/**
	 * 更新索引同步状态
	 * @param id
	 * @param curSyncFlag
	 * @return
	 */
	int updateCurSyncFlag(@Param("curSyncFlag")JudgeType curSyncFlag,@Param("id")Long id);
	
	/**根据productId删除产品信息
	 * @param productId
	 * deleteProductByProductId
	 */
	int deleteProductByProductId(Long productId);
	
	

	/**根据条件查询Sdp产品信息以供Excel导出
	 * @param baseQueryDto
	 * @return
	 */
	List<FitSdpProductBasicInfoDto> querySdpProductReport(BaseQueryDto<FitSdpProductBasicInfoRequest> baseQueryDto);
	/**根据条件查询Sdp产品信息
	 * @param baseQueryDto
	 * @return
	 */
	List<FitSdpProductBasicInfoDto> queryByCondition(BaseQueryDto<? extends FitSdpProductBasicInfoRequest> q);

	int countByCondition(BaseQueryDto<? extends FitSdpProductBasicInfoRequest> q);
	
	/**
	 * 取得当天5点之前更新的产品ID
	 * @return
     */
	List<Long> queryDataBefore5Am();
	
	/**更新多出发地标志
	 * @param muiltDpartureFlag
	 * @param productId
	 * @return
	 */
	int updateMuiltDpartureFlag(@Param("muiltDpartureFlag")JudgeType muiltDpartureFlag,@Param("id")Long productId);
}
