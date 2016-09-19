package com.lvmama.lvfit.vst.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lvmama.lvf.common.utils.JSONMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvfit.common.client.path.VstServiceClientPath;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpComPushDto;
import com.lvmama.lvfit.common.dto.vst.VstPushRecord;
import com.lvmama.lvfit.vst.persistence.mybatis.mapper.VstComPushMapper;


@Component
@Path("")
public class FitVstSearchResource {


	private static final Logger logger = LoggerFactory.getLogger(FitVstSearchResource.class);

	@Autowired
	private VstComPushMapper vstComPushMapper;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstServiceClientPath.Path.PUSH_COM_PUSH)
	public Response booking(FitSdpComPushDto comPushDto) {
		try {
			logger.error("实时更新数据comPushDto：["+ JSONMapper.getInstance().writeValueAsString(comPushDto)+"]");
			int count = vstComPushMapper.insert(comPushDto);
			if(count==1){
				return Response.ok(ResultStatus.SUCCESS).build();
			}
		} catch (Exception e) {
			logger.error("产品ID:"+comPushDto.getObjectId(),e);
			return Response.ok(ResultStatus.FAIL).build();
		}
		return Response.ok(ResultStatus.FAIL).build();
	}
	
	@POST
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstServiceClientPath.Path.QUERY_COM_PUSH)
	public Response queryPushList(BaseQueryDto<Long> baseQuery) {
			BaseResultDto<VstPushRecord> baseResult = new BaseResultDto<VstPushRecord>();
			List<VstPushRecord> results = vstComPushMapper.queryPushList(baseQuery);
			int records = vstComPushMapper.countPushRecords(baseQuery);
			Pagination pagination = baseQuery.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<VstPushRecord> baseResultDto = new BaseResultDto<VstPushRecord>(pagination,results);
			return Response.ok(baseResultDto).build();
	}
	
}
