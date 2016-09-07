package com.lvmama.lvfit.fitSearch.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.solr.json.ext.select.SolrObject;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.request.FitRecordSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitRecordSearchIndex;
import com.lvmama.lvfit.solrClient.extend.FitMainSearchSolrClient;

@Component
@Path("")
public class FitSearchResource {

    private static Logger logger = LoggerFactory.getLogger(FitSearchResource.class);

    @Autowired
    private FitMainSearchSolrClient fitMainSearchSolrClient;

    /**
     * 查询机票查询记录
     * 
     * @param flightQueryRequest 航班查询请求对象
     * @return Response
     */
    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(DpClientPath.Path.SEARCH_FIT_RECORD_FROM_SOLR)
    public Response querySearchRecord(String jsonRequest) {
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            BaseQueryDto<FitRecordSearchRequest> baseQueryDto = objectMapper.readValue(jsonRequest,
                    new TypeReference<BaseQueryDto<FitRecordSearchRequest>>() {});
            SolrObject<FitRecordSearchIndex> object_page = fitMainSearchSolrClient.selectFitRecordWithPage(baseQueryDto, FitRecordSearchIndex.class);
            BaseResponseDto<FitRecordSearchIndex> baseResponseDto = new BaseResponseDto<FitRecordSearchIndex>();
            baseResponseDto.setResults(object_page.getResults());
            baseResponseDto.setPagination(object_page.getPagination());
            String jsonResult = objectMapper.writeValueAsString(baseResponseDto);
            return Response.ok(jsonResult).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.noContent().build();
    }
}
