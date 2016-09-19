package com.lvmama.lvfit.vst.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpComPushDto;
import com.lvmama.lvfit.common.dto.vst.VstPushRecord;

/**
 * com_push推送mapper
 * @author leizhengwei
 *
 */
public interface VstComPushMapper 
extends DomainEntityBaseMapper<FitSdpComPushDto, BaseQueryDto<? extends Dto>> {


	List<VstPushRecord> queryPushList(BaseQueryDto<Long> baseQuery);

	int countPushRecords(BaseQueryDto<Long> baseQuery);
	
	
}
