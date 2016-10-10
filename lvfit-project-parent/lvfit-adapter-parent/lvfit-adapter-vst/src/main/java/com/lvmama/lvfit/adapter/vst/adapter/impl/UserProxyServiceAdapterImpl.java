/**
 * Project Name:lvfit-adapter-vst
 * File Name:UserProxyServiceAdapterImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter.impl
 * Date:2015-12-9上午11:14:16
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.comm.pet.po.user.UserUser;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.MemcachedUtil;
import com.lvmama.lvfit.adapter.vst.adapter.UserProxyServiceAdapter;
import com.lvmama.lvfit.adapter.vst.handle.VSTLoggerHandler;
import com.lvmama.lvfit.common.dto.member.FitMemUserDto;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;

/**
 * ClassName:UserProxyServiceAdapterImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-9 上午11:14:16 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class UserProxyServiceAdapterImpl implements UserProxyServiceAdapter {
	@Autowired
	private VSTLoggerHandler logger;

	@SuppressWarnings("unchecked")
	private Map<String, Object> getSessionMap(String lvSessionId) {
		Map<String, Object> map = null;
		if (lvSessionId != null) {
			try {
				logger.info("MemcachedUtil.getInstance().get(lvSessionId, true)：【"+JSONMapper.getInstance().writeValueAsString(MemcachedUtil.getInstance().get(lvSessionId, true))+"】");
			} catch (Exception e) {
			     logger.error(e.getMessage());
			}
			map = (Map<String, Object>) MemcachedUtil.getInstance().get(lvSessionId, true);
		}
		boolean result = false;
		if (map != null) {
			result = true;
		}
		logger.info("get object from memcached, session:" + lvSessionId + " result: " + result);
		if (map == null) {
			map = new HashMap<String, Object>();
			map.put("LAST_UPDATE_TIME", System.currentTimeMillis());
		}
		if (map.get("ver") == null) {
			map.put("ver", 0);
		}
		return map;
	}

	@Override
	public BaseSingleResultDto<FitMemUserDto> getUserByLvSessionId(MemUserRequest request) {
		BaseSingleResultDto<FitMemUserDto> result=new BaseSingleResultDto<FitMemUserDto>();
		Map<String, Object> userMap = getSessionMap(request.getLvSessionId());
		FitMemUserDto fitMemUserDto = new FitMemUserDto();
		String message="根据lvSessionId获取用户信息异常";
		if (userMap != null && userMap.containsKey("SESSION_FRONT_USER")) {
			UserUser user = (UserUser) userMap.get("SESSION_FRONT_USER");
			result.setResult(fitMemUserDto);
			try {
				BeanUtils.copyProperties(fitMemUserDto, user);
				fitMemUserDto.setUserId(user.getId());
			} catch (Exception e) {
				logger.error("根据lvSessionId获取用户信息异常"+ExceptionUtils.getFullStackTrace(e));
				result.setErrorMessage(message);
				logger.error(message);
			}
		}
		if (!userMap.containsKey("SESSION_FRONT_USER")) {
		    logger.error("key SESSION_FRONT_USER 不存在");
		}
		return result;
	}

}
