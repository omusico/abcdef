package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.order.domain.FitOrderStatus;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderStatusRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderStatusMapper;

/**
 * @author qihuisong
 */
@Repository
public class FitOrderStatusRepositoryImpl implements FitOrderStatusRepository {

    @Autowired
    private FitOrderStatusMapper fitOrderStatusMapper;

    @Override
    public FitOrderStatusDto load(Long id) {
        return null;
    }

    @Override
    public FitOrderStatus load(FitOrderStatusDto fitOrderStatusDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderStatusDto save(FitOrderStatusDto fitOrderStatusDto) {
        if (null == fitOrderStatusDto.getId()) {
            fitOrderStatusMapper.insert(fitOrderStatusDto);
        }else {
            fitOrderStatusMapper.updateById(fitOrderStatusDto.getId(), fitOrderStatusDto);
        }
        return fitOrderStatusDto;
    }

    @Override
    public List<FitOrderStatusDto> queryByFkId(Long fkId) {
        return fitOrderStatusMapper.queryByFkId(fkId);
    }

    @Override
    public int deleteByFkId(Long fkId) {
        return 0;
    }
}
