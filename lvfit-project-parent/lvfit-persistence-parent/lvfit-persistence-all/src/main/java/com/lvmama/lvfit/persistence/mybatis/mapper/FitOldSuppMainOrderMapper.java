package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

public interface FitOldSuppMainOrderMapper {
    public List<FitSuppMainOrderDto> getAllOldOrderMainData();
    public void updateBindingStatus(Long vstOrderMainNo);
}
