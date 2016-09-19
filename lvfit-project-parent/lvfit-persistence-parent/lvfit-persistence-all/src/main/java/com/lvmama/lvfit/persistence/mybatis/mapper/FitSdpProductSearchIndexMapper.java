package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityBatchMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingPassengerDto;


/**
 * 自主打包产品Mapper
 * @author leizhengwei
 *
 */
public interface FitSdpProductSearchIndexMapper extends DomainEntityBaseMapper<FitSdpProductSearchIndexDto, BaseQueryDto<? extends Dto>>
,DomainEntityBatchMapper<FitSdpProductSearchIndexDto, BaseQueryDto<? extends Dto>>,
DomainEntityByFkIdMapper<FitSdpProductSearchIndexDto>{
	
	/**
	 * 删除所有索引
	 * @return
	 */
	public int deleteAll();
	
	/**
	 * 根据产品Id获取索引数量
	 * @return
	 */
	public int countByProductId(@Param("productId")Long productId);
	
	/**
	 * 根据产品Id获取索引列表
	 * @return
	 */
	public List<FitSdpProductSearchIndexDto> getInfoList(BaseQueryDto<Long> baseQuery);

	/**
	 * 根据产品Id获取索引列表总数
	 * @return
	 */
	public int countSearchIndex(BaseQueryDto<Long> baseQuery);
	
}
