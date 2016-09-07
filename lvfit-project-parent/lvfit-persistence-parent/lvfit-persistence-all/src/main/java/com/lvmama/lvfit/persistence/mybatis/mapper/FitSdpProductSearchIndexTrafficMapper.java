package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityBatchMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndex;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import org.apache.ibatis.annotations.Param;


/**
 * 自主打包产品索引交通信息Mapper
 * @author leizhengwei
 *
 */
public interface FitSdpProductSearchIndexTrafficMapper extends DomainEntityBaseMapper<FitSdpProductSearchIndexTraffic, BaseQueryDto<? extends Dto>>,
        DomainByFkIdRepository<FitSdpProductSearchIndexTraffic>
{

}
