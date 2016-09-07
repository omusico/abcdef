package com.lvmama.lvfit.aggregate.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.utils.JSONMapper;

/**
 * 机+酒solr搜索Resource
 * @author lizongze
 *
 */
@Component
@Path("")
public class FitSolrSearchResource {

    /**
     * 查询查询记录
     * 
     */
    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response querySearchRecord(String jsonRequest) {

//        try {
//            ObjectMapper objectMapper = JSONMapper.getInstance();
//            BaseQueryDto<> baseQueryDto = objectMapper.readValue(jsonRequest,
//                            new TypeReference<BaseQueryDto<>>() {});
//            SolrObject<FlightSearchRecordIndex> object_page = flightSearchRecordClient
//                    .selectRecordWithPage(baseQueryDto, FlightSearchRecordIndex.class);
//            BaseResponseDto<FlightSearchRecordIndex> baseResponseDto =
//                    new BaseResponseDto<FlightSearchRecordIndex>();
//            baseResponseDto.setResults(object_page.getResults());
//            baseResponseDto.setPagination(object_page.getPagination());
//            String jsonResult = objectMapper.writeValueAsString(baseResponseDto);
//            return Response.ok(jsonResult).build();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return Response.noContent().build();
    }
}
