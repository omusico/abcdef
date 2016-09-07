package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderFlight;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderFlightRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderFlightMapper;

@Repository
public class FitOrderFlightRepositoryImpl implements FitOrderFlightRepository {

    @Autowired
    private FitOrderFlightMapper fitOrderFlightMapper;

    @Override
    public FitOrderFlightDto load(Long id) {
        return fitOrderFlightMapper.getById(id);
    }

    @Override
    public FitOrderFlight load(FitOrderFlightDto fitOrderFlightDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderFlightDto save(FitOrderFlightDto fitOrderFlightDto) {
        if (null == fitOrderFlightDto.getId()) {
            fitOrderFlightMapper.insert(fitOrderFlightDto);
        }else {
            fitOrderFlightMapper.updateById(fitOrderFlightDto.getId(), fitOrderFlightDto);
        }
        return fitOrderFlightDto;
    }
    
    @Override
    public List<FitOrderFlightDto> getOldFitOrderMainData(String vstOrderMainNo) {
        return fitOrderFlightMapper.loadByVstOrderMainNo(vstOrderMainNo);
    }

}
