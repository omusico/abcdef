/**
 * Project Name:lvfit-common-dto
 * File Name:VstClient.java
 * Package Name:com.lvmama.lvfit.common.client
 * Date:2015-11-12下午3:10:05
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.client;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.VstServiceClientPath;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpComPushDto;
import com.lvmama.lvfit.common.dto.vst.VstPushRecord;

@Component
public class FitVstServiceClient {

	private static Logger logger = LoggerFactory.getLogger(FitVstServiceClient.class);

	@Value("lvfit.vst.service.baseurl")
	private String baseUrl;

	@Autowired
	private RestClient restClient;

	/**
	 * 补全机票单号和供应商订单编号信息
	 */
	public ResultStatus pushComPush(FitSdpComPushDto comPushDto) {
		VstServiceClientPath command = VstServiceClientPath.PUSH_COM_PUSH;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, comPushDto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(
					command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	public BaseResultDto<VstPushRecord> queryPushInfoList(Long productId) {
		VstServiceClientPath command = VstServiceClientPath.QUERY_COM_PUSH;
		String url = command.url(baseUrl, productId);
	    try {
	           String jsonResult = restClient.post(url, String.class);
	           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<BaseResultDto<VstPushRecord>>(){});
	    }
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(
					command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

}
