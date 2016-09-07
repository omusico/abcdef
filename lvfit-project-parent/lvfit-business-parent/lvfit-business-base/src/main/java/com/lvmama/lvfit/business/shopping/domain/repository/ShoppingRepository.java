package com.lvmama.lvfit.business.shopping.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainQueryRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.business.shopping.domain.ShoppingDetail;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;

public interface ShoppingRepository extends DomainBaseRepository< ShoppingDetail, ShoppingDetailDto>,DomainQueryRepository<ShoppingDetailDto, BaseQueryDto<? extends Dto>>{
	
   public List<ShoppingDetailDto> getListByCode(String code);

   public int update(ShoppingDetailDto dto);
}
