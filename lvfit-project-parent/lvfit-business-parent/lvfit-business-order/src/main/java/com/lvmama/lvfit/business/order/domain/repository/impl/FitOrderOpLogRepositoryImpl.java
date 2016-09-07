package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.order.domain.FitOrderOpLog;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderOpLogRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderOpLogMapper;

/**
 * @author qihuisong
 */
@Repository
public class FitOrderOpLogRepositoryImpl implements FitOrderOpLogRepository {

    @Autowired
    private FitOrderOpLogMapper fitOrderOpLogMapper;
    
    @Override
    public FitOrderOpLogDto load(Long id) {
        return null;
    }

    @Override
    public FitOrderOpLog load(FitOrderOpLogDto fitOrderOpLogDto) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public FitOrderOpLogDto save(FitOrderOpLogDto fitOrderOpLogDto) {
    	
    	String desc = fitOrderOpLogDto.getDesc();
        if(StringUtils.isNotBlank(desc)){
        	byte[] descBytes = desc.getBytes();
            if (descBytes.length > 2000) {
                byte[] newBytes = Arrays.copyOfRange(descBytes, 0, 2000);
                desc = new String(newBytes);
            }
        }
    	fitOrderOpLogDto.setDesc(desc);
        if (null == fitOrderOpLogDto.getId()) {
            fitOrderOpLogMapper.insert(fitOrderOpLogDto);
        }else {
            fitOrderOpLogMapper.updateById(fitOrderOpLogDto.getId(), fitOrderOpLogDto);
        }
        return fitOrderOpLogDto;
    }
    
    @Override
	public List<FitOrderOpLogDto> query(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
    	List<FitOrderOpLogDto> list = fitOrderOpLogMapper.query(baseQueryDto);
		return list;
	}

	@Override
	public int count(BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		return fitOrderOpLogMapper.count(baseQueryDto);
	}
	
	public static void main(String[] args) {
		String desc = null;
		System.out.println(desc.getBytes());
	}
}
