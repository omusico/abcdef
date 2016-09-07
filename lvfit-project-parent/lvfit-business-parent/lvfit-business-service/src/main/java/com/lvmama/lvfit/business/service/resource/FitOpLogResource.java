package com.lvmama.lvfit.business.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.dto.FitOpLog;
import com.lvmama.lvfit.common.dto.request.FitOpLogQueryRequest;
import com.lvmama.lvfit.common.oplog.FitOpLogUtils;

@Component
@Path("")
public class FitOpLogResource {
    @Autowired
    private FitOpLogUtils fitOpLogUtils;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BussinessClientPath.Path.VIEW_OP_LOG)
    public Response query(String jsonRequest) {
        // 设置参数，查询信息
        ObjectMapper objectMapper = JSONMapper.getInstance();
        BaseQueryDto<FitOpLogQueryRequest> baseQueryDto;
        try {
            baseQueryDto = objectMapper.readValue(jsonRequest,
                    new TypeReference<BaseQueryDto<FitOpLogQueryRequest>>() {});

            List<FitOpLog> fitOpLogs = fitOpLogUtils.query(baseQueryDto);
            // 处理返回信息
            BaseResultDto<FitOpLog> baseResult = new BaseResultDto<FitOpLog>();
            baseResult.setResults(fitOpLogs);

            int records = fitOpLogUtils.count(baseQueryDto);

            Pagination pagination = baseQueryDto.getPagination();
            pagination.setRecords(records);
            pagination.countRecords(records);

            baseResult.setPagination(pagination);
            String jsonResult = JSONMapper.getInstance().writeValueAsString(baseResult);
            return Response.ok(jsonResult).build();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
