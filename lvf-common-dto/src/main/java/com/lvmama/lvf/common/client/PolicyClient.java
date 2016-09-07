/*
 * Copyright by Lvmama and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Lvmama from
 *
 *      http://www.lvmama.com
 *
 */ 
package com.lvmama.lvf.common.client;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.PolicyPath;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.policy.PolicyOpeLogDto;
import com.lvmama.lvf.common.dto.supp.SuppWorkTimeDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;

/**
 * 政策  接口
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:yangxiaolong(杨小龙),
 *		date:2016年6月20日 上午11:02:13,content: </p>
 * @author yangxiaolong(杨小龙)
 * @date 2016年6月20日 上午11:02:13
 * @since
 * @version
 */
@Component
public class PolicyClient {
	
	/** 远程地址 */
	@Value("business.baseurl")
	private String baseUrl;
	
	/** 远程服务 */
	@Autowired
	private RestClient restClient;
	
	public static final Logger logger=Logger.getLogger(PolicyClient.class);

	/**
	 * 供应商默认工作时间 接口
	 * <p>新增工作时间</p> 
	 * @author yangxiaolong(杨小龙)
	 * @date 2016年6月20日 下午12:37:37
	 * @return
	 * @see
	 */
	public SuppWorkTimeDto addSuppWorkTime(SuppWorkTimeDto workTime) {
		PolicyPath command = PolicyPath.ADD_SUPP_WORK_TIME;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, SuppWorkTimeDto.class,workTime);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 供应商默认工作时间 接口
	 * <p>查询工作时间</p> 
	 * @author yangxiaolong(杨小龙)
	 * @date 2016年6月20日 下午6:48:58
	 * @param workTime
	 * @return
	 * @throws Exception 
	 * @see
	 */
	public BaseResultDto<SuppWorkTimeDto> querySuppWorkTime(BaseQueryDto<SuppWorkTimeDto> dto) throws Exception {
		PolicyPath command = PolicyPath.QUERY_SUPP_WORK_TIME;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,dto);
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<SuppWorkTimeDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch(Exception e){
			logger.error(e.getMessage(),e);
			throw e;
		}
	}
	
	/**
	 * 供应商默认工作时间 接口
	 * <p>根据供应商编码删除工作时间</p> 
	 * @author yangxiaolong(杨小龙)
	 * @date 2016年6月20日 下午7:59:32
	 * @param workTime
	 * @return
	 * @see
	 */
	public int deleteSuppWorkTimeByCode(SuppWorkTimeDto workTime) {
		PolicyPath command = PolicyPath.DELETE_SUPP_WORK_TIME_BY_CODE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, int.class,workTime);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 
	 * <p>插入政策操作日志</p> 
	 * @author yangxiaolong(杨小龙)
	 * @date 2016年6月22日 下午12:55:15
	 * @param dto
	 * @return
	 * @see
	 */
	public PolicyOpeLogDto addPolicyOpeLog(PolicyOpeLogDto dto) {
		PolicyPath command = PolicyPath.ADD_POLICY_OPE_LOG;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, PolicyOpeLogDto.class,dto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 
	 * <p>查询政策操作日志</p> 
	 * @author yangxiaolong(杨小龙)
	 * @date 2016年6月22日 下午12:56:19
	 * @param dto
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @see
	 */
	public BaseResultDto<PolicyOpeLogDto> queryPolicyOpeLog(BaseQueryDto<PolicyOpeLogDto> dto)
			throws JsonParseException, JsonMappingException, IOException {
		PolicyPath command = PolicyPath.QUERY_POLICY_OPE_LOG;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,dto);
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<PolicyOpeLogDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	
}
