package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderPassenger;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderPassengerRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderPassengerMapper;

/**
 * @author qihuisong
 */
@Repository
public class FitOrderPassengerRepositoryImpl implements FitOrderPassengerRepository {

    @Autowired
    private FitOrderPassengerMapper fitOrderPassengerMapper;

    @Override
    public FitOrderPassengerDto load(Long id) {
        return fitOrderPassengerMapper.getById(id);
    }

    @Override
    public FitOrderPassenger load(FitOrderPassengerDto fitOrderPassengerDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderPassengerDto save(FitOrderPassengerDto fitOrderPassengerDto) {
        if (null == fitOrderPassengerDto.getId()) {
            fitOrderPassengerMapper.insert(fitOrderPassengerDto);
        }else {
            fitOrderPassengerMapper.updateById(fitOrderPassengerDto.getId(), fitOrderPassengerDto);
        }
        return fitOrderPassengerDto;
    }

    @Override
    public List<FitOrderPassengerDto> queryByFkId(Long fkId) {
        return fitOrderPassengerMapper.queryByFkId(fkId);
    }

    @Override
    public int deleteByFkId(Long fkId) {
        return 0;
    }
}
