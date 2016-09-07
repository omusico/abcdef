package com.lvmama.lvfit.business.order.domain.repository.impl;

import com.lvmama.lvfit.business.order.domain.FitOrder;
import com.lvmama.lvfit.business.order.domain.FitOrderExpress;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderExpressRepository;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderExpressDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderExpressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author qihuisong
 */
@Repository
public class FitOrderExpressRepositoryImpl implements FitOrderExpressRepository {

    @Autowired
    private FitOrderExpressMapper fitOrderExpressMapper;

    @Override
    public FitOrderExpressDto load(Long id) {
        return null;
    }

    @Override
    public FitOrderExpress load(FitOrderExpressDto fitOrderExpressDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderExpressDto save(FitOrderExpressDto fitOrderExpressDto) {
        if (null == fitOrderExpressDto.getId()) {
            fitOrderExpressMapper.insert(fitOrderExpressDto);
        }else {
            fitOrderExpressMapper.updateById(fitOrderExpressDto.getId(), fitOrderExpressDto);
        }
        return fitOrderExpressDto;
    }
}
