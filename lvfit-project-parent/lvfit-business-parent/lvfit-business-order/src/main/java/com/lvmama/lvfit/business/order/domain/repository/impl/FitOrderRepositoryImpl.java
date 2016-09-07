package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.business.order.domain.FitOrder;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderMapper;

/**
 * @author qihuisong
 */
@Repository
public class FitOrderRepositoryImpl implements FitOrderRepository {

    @Autowired
    private FitOrderMapper fitOrderMapper;

    @Override
    public FitOrderDto load(Long id) {
        return fitOrderMapper.getById(id);
    }

    @Override
    public FitOrder load(FitOrderDto fitOrderDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderDto save(FitOrderDto fitOrderDto) {
        if (null == fitOrderDto.getId()) {
            fitOrderMapper.insert(fitOrderDto);
        } else {
            fitOrderMapper.updateById(fitOrderDto.getId(), fitOrderDto);
        }
        return fitOrderDto;
    }
    
    @Override
    public FitOrderDto updateByOrderNo(FitOrderDto fitOrderDto) {
    	fitOrderMapper.updateByOrderNo(fitOrderDto.getId(), fitOrderDto);
    	return fitOrderDto;
    }

    @Override
    public List<FitOrderDto> query(BaseQueryDto<? extends Dto> baseQueryDto) {
        return fitOrderMapper.query(baseQueryDto);
    }

    @Override
    public int count(BaseQueryDto<? extends Dto> baseQueryDto) {
        return fitOrderMapper.count(baseQueryDto);
    }

    @Override
    public List<FitOrderDto> queryByFkId(Long fkId) {
        return fitOrderMapper.queryByFkId(fkId);
    }

    @Override
    public int deleteByFkId(Long fkId) {
        return fitOrderMapper.deleteByFkId(fkId);
    }
}
