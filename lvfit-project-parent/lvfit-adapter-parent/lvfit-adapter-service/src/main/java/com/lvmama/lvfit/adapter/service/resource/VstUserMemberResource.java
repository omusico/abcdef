/**
 * Project Name:lvfit-adapter-service
 * File Name:VstUserMemberResource.java
 * Package Name:com.lvmama.lvfit.adapter.service.resource
 * Date:2015-12-10下午11:39:24
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.comm.search.vst.vo.VstRouteSearchVO;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvfit.adapter.vst.adapter.UserProxyServiceAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.UserReceiverServiceAdapter;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.member.FitMemUserDto;
import com.lvmama.lvfit.common.dto.member.FitUserContacterDto;
import com.lvmama.lvfit.common.dto.request.FitOrderPassengerRequest;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;
import com.lvmama.vst.newsearch.service.LvmamaClientService;
import com.lvmama.vst.search.api.vo.ResultHandleT;
import com.lvmama.vst.search.api.vo.SearchResultVo;

/**
 * ClassName:VstUserMemberResource <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-10 下午11:39:24 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Component
@Path("")
public class VstUserMemberResource {
	@Autowired
	private UserReceiverServiceAdapter userReceiverServiceAdapter;
	@Autowired
	private UserProxyServiceAdapter userProxyServiceAdapter;
    @Autowired
    private LvmamaClientService lvmamaClientService;

	private static final Logger LOGGER = LoggerFactory.getLogger(VstUserMemberResource.class);
	/**
	 * 保存常用联系人信息
	 * 
	 * @param addressList
	 * @param userId
	 * @return
	 */
	@GET
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.SAVE_ORDER_PASSENGER_INFO)
	public Response saveOrderPassengerInfo(FitOrderPassengerRequest passengerRequst) throws Exception{
		ResultStatus resultStatus = userReceiverServiceAdapter.saveOrderPassengerInfo(passengerRequst);
		return Response.ok(resultStatus).build();
	}

	/**
	 * 根据用户ID和查找类型来查找相关联系人
	 * 
	 * @param userId
	 * @param searchType
	 * @return
	 * @throws Exception
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.GET_USER_RECEIVERS_BY_USER_ID)
	public Response getUserReceiversByUserId(MemUserRequest request) throws Exception {
		List<FitUserContacterDto> contacters = userReceiverServiceAdapter.getUserReceiverByUserId(request);
		return Response.ok(contacters).build();
	}

	/**
	 * 根据lvSessionId获取登录用户信息
	 * 
	 * @param userId
	 * @param searchType
	 * @return
	 * @throws Exception
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.GET_USER_BY_LVSESSION_ID)
	public Response getUserByLvSessionId(MemUserRequest request) throws Exception {
		BaseSingleResultDto<FitMemUserDto> result = userProxyServiceAdapter.getUserByLvSessionId(request);
		return Response.ok(result).build();
	}

	/**
	 * 根据lvSessionId获取常用联系人
	 * 
	 * @param userId
	 * @param searchType
	 * @return
	 * @throws Exception
	 */
	@GET
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.GET_USER_RECEIVERS_BY_LVSESSION_ID)
	public Response getUserReceiversByLvSessionId(MemUserRequest request) throws Exception {
		List<FitUserContacterDto> contacters;
        try {
            BaseSingleResultDto<FitMemUserDto> result = userProxyServiceAdapter.getUserByLvSessionId(request);
            FitMemUserDto memUser = result.getResult();
            if (memUser != null) {
            	String userId = memUser.getUserNo();
            	request.setUserId(userId);
            } else {
                LOGGER.error("获取用户失败~~~~~~~");
            }
            contacters = userReceiverServiceAdapter.getUserReceiverByUserId(request);
            return Response.ok(contacters).build();
        } catch (Exception e) {
            LOGGER.error("获取用户发送异常" + e);
        }
        return Response.ok().build();
	}
}
