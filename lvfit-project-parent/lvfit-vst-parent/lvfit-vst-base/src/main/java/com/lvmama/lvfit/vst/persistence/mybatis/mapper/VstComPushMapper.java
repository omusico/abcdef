package com.lvmama.lvfit.vst.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpComPushDto;

/**
 * com_push推送mapper
 * @author leizhengwei
 *
 */
public interface VstComPushMapper 
extends DomainEntityBaseMapper<FitSdpComPushDto, BaseQueryDto<? extends Dto>> {
	
	
}
