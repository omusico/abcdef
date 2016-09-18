package com.lvmama.lvfit.business.order.domain.repository.impl;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.utils.ZipUnZipUtils;
import com.lvmama.lvfit.business.order.domain.FitSuppOrderForFlightCallBack;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderForFlightCallBackRepository;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackRequest;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSuppOrderForFlightCallBackMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FitSuppOrderForFlightCallBackRepositoryImpl implements FitSuppOrderForFlightCallBackRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(FitSuppOrderForFlightCallBackRepositoryImpl.class);

	@Autowired
	private FitSuppOrderForFlightCallBackMapper fitSuppOrderForFlightCallBackMapper;
	
	@Override
	public FitSuppOrderForFlightCallBackDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitSuppOrderForFlightCallBack load(FitSuppOrderForFlightCallBackDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSuppOrderForFlightCallBackDto save(FitSuppOrderForFlightCallBackDto r) {
	    if (null == r.getId()) {
	    	String zipStr = StringUtils.EMPTY;
			try {
				zipStr = ZipUnZipUtils.getInstance().zipString2Base64(r.getCallRequestStr());
			} catch (Exception e) {
				logger.error(ExceptionUtils.getFullStackTrace(e));
			}
			if(StringUtils.isNotBlank(zipStr)){
			  	r.setCallRequestStr(zipStr);
			}
		    fitSuppOrderForFlightCallBackMapper.insert(r);
        }else {
        	fitSuppOrderForFlightCallBackMapper.updateById(r.getId(), r);
        }
        return r;
	}

	@Override
	public List<FitSuppOrderForFlightCallBackDto> queryByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSuppOrderForFlightCallBackDto loadByVstNos(String vstOrderMainNo,String vstOrderNo) {
		return fitSuppOrderForFlightCallBackMapper.loadByVstNos(vstOrderMainNo, vstOrderNo);
	}

	@Override
	public List<String> loadCallRequestStrByVstNo(String vstOrderMainNo, String vstOrderNo) {
		return fitSuppOrderForFlightCallBackMapper.loadCallRequestStrByVstNo(vstOrderMainNo,vstOrderNo);
	}

	@Override
	public List<FitSuppOrderForFlightCallBackDto> queryAll(BaseQueryDto<FitSuppOrderForFlightCallBackRequest> request) {
		return fitSuppOrderForFlightCallBackMapper.queryAll(request);
	}

	@Override
	public int querySuppOrderForFlightCallBackCounts(
			BaseQueryDto<FitSuppOrderForFlightCallBackRequest> baseQuery) {
		return fitSuppOrderForFlightCallBackMapper.querySuppOrderForFlightCallBackCounts(baseQuery);
	}

	@Override
	public List<FitFliBookingCallBackRequest> queryByVstMainNo(
			BaseQueryDto<FitFliBookingCallBackRequest> baseQuery) {
		return fitSuppOrderForFlightCallBackMapper.queryByVstMainNo(baseQuery);
	}

}
