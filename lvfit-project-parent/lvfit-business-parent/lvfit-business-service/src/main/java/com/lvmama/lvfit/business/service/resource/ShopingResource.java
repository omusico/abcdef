package com.lvmama.lvfit.business.service.resource;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.shopping.service.FitShoppingService;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.dto.request.FitShoppingListRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDbDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;

/**
 * 
 * @author zengzhimin
 *
 */
@Component
@Path("")
public class ShopingResource {
	@Autowired
	private FitShoppingService fitShoppingService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.SAVE_SHOPPING)
	public Response  saveOrUpdateShopping(FitShoppingDto dto){
		try{
			BaseSingleResultDto resultDto = fitShoppingService.saveOrUpdateShopping(dto);
			return Response.ok(resultDto).build();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.GETDP_SHOPPING)
	public Response loadShoppingDbInfoByUuId(String shoppingUuId){
		try{
			ShoppingDbDto resultDto = fitShoppingService.loadShoppingDbInfoByUuId(shoppingUuId);
			return Response.ok(resultDto).build();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询购物车列表
	 * @param 	baseQueryDto								查询对象
	 * @return	Response		                                                           购物车列表查询结果对象
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.QUERY_SHOPPING)
	public Response queryShoppingList(BaseQueryDto<FitShoppingListRequest> baseQueryDto)
	{
		try
		{      
			//1、获取订单列表查询对象
			ObjectMapper objectMapper = JSONMapper.getInstance();
			//2、查询购物车列表、记录总数
			List<ShoppingDetailDto> shoppingList = fitShoppingService.queryShoppingList(baseQueryDto);
			int records = fitShoppingService.countShoppingListRecords(baseQueryDto);
			
			//3、构造订单列表查询结果对象
			Pagination pagination = baseQueryDto.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<ShoppingDetailDto> baseResultDto = new BaseResultDto<ShoppingDetailDto>
				(pagination, shoppingList);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto); 
			return Response.ok(jsonResult).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询购物车列表(导出)
	 * @param jsonRequest
	 * @return
	 * @throws Exception 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.QUERY_SHOPPING_EXPROT)
	public Response queryShoppingListForExprot(BaseQueryDto<FitShoppingListRequest> baseQueryDto) throws Exception
	{
		try
		{
			//1、获取订单列表查询对象
			ObjectMapper objectMapper = JSONMapper.getInstance();
			//2、查询购物车列表、记录总数
			List<ShoppingDetailDto> shoppingList = fitShoppingService.queryShoppingList(baseQueryDto);
			List<String> shoppingListStrings = new ArrayList<String>();
			for(ShoppingDetailDto shoppingDetailDto : shoppingList)
			{
				shoppingListStrings.add(shoppingDetailDto.constructOrderListStr());
			}
			String jsonResult = objectMapper.writeValueAsString(shoppingListStrings); 
			return Response.ok(jsonResult).build();
			
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BussinessClientPath.Path.GET_SHOPPING_INFO_BY_UUID)
    public Response getShoppingInfoByUuid(@PathParam(value = "uuid") String shoppingUuId) {
        ShoppingDetailDto resultDto = fitShoppingService.getShoppingInfoByUuid(shoppingUuId);
        return Response.ok(resultDto).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BussinessClientPath.Path.UPD_SHOPPING_INFO)
    public Response saveOrUpdShoppingInfo(ShoppingDetailDto dtlDto) {
        int resultCount = fitShoppingService.updShoppingInfo(dtlDto);
        return Response.ok(Integer.valueOf(resultCount)).build();
    }
}
