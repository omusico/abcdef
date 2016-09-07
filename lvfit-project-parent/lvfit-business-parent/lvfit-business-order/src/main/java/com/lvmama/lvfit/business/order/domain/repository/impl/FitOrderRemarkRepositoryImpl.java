package com.lvmama.lvfit.business.order.domain.repository.impl;

import com.lvmama.lvfit.business.order.domain.FitOrder;
import com.lvmama.lvfit.business.order.domain.FitOrderRemark;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRemarkRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRemarkDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderRemarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author qihuisong
 */
@Repository
public class FitOrderRemarkRepositoryImpl implements FitOrderRemarkRepository {

    @Autowired
    private FitOrderRemarkMapper fitOrderRemarkMapper;

    @Override
    public FitOrderRemarkDto load(Long id) {
        return null;
    }

    @Override
    public FitOrderRemark load(FitOrderRemarkDto fitOrderRemarkDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderRemarkDto save(FitOrderRemarkDto fitOrderRemarkDto) {
        if (null == fitOrderRemarkDto.getId()) {
            fitOrderRemarkMapper.insert(fitOrderRemarkDto);
        }else {
            fitOrderRemarkMapper.updateById(fitOrderRemarkDto.getId(), fitOrderRemarkDto);
        }
        return fitOrderRemarkDto;
    }
}
