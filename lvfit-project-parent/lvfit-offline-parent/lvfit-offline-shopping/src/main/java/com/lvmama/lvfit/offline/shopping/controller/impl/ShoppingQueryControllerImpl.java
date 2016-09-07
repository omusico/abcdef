package com.lvmama.lvfit.offline.shopping.controller.impl;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.utils.csv.CsvUtils;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.InsuranceType;
import com.lvmama.lvfit.common.dto.request.FitShoppingListRequest;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDbDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingInsuranceDto;
import com.lvmama.lvfit.common.form.shopping.ShoppingListQueryRequestForm;
import com.lvmama.lvfit.common.form.shopping.ShoppingListQueryResultForm;
import com.lvmama.lvfit.common.utils.FitCsvConfig;
import com.lvmama.lvfit.offline.exception.BaseExceptionHandler;
import com.lvmama.lvfit.offline.shopping.controller.ShoppingQueryController;
@Controller
public class ShoppingQueryControllerImpl extends BaseExceptionHandler implements ShoppingQueryController<ShoppingListQueryRequestForm,BaseResponseDto<ShoppingListQueryResultForm>>{

	@Autowired
	private FitBusinessClient fitBusinessClient;
	@RequestMapping("shopping/toShoppingList")
	@Override
	public String toShoppingList(Model model) {
		model.addAttribute("bookingSourceEnum", BookingSource.values());
		return "shopping/shopping_list";
		
	}
     
	@RequestMapping("shopping/queryShoppingList")
	@ResponseBody
	@Override
	public BaseResponseDto<ShoppingListQueryResultForm> queryShoppingList(
			Model model, ShoppingListQueryRequestForm requestForm) {
		       //1、设置查询条件
		        FitShoppingListRequest fitShoppingListRequest = requestForm.getFitShoppingListRequest();
		        //fitShoppingListRequest.setOpSource(OpSource.BACK);
				BaseQueryDto<FitShoppingListRequest> baseQuery = new BaseQueryDto<FitShoppingListRequest>(
					requestForm.getPagination(), fitShoppingListRequest);
				
				//2、查询订单列表
				
				BaseResultDto<ShoppingDetailDto> baseResultDto = fitBusinessClient.queryShoppingList(baseQuery);
				BaseResponseDto<ShoppingListQueryResultForm> baseResponseDto = new BaseResponseDto<ShoppingListQueryResultForm>();
				if(baseResultDto != null)
				{
					List<ShoppingDetailDto> shoppingDtos = baseResultDto.getResults();
					List<ShoppingListQueryResultForm> shoppingResultList = new ArrayList<ShoppingListQueryResultForm>();
					if(CollectionUtils.isNotEmpty(shoppingDtos))
					{
						for (ShoppingDetailDto shoppingDetailDto : shoppingDtos) 
						{
							ShoppingListQueryResultForm resultForm = new ShoppingListQueryResultForm();
							resultForm.setShoppingDetailDto(shoppingDetailDto);
							shoppingResultList.add(resultForm);
						}
					}
					baseResponseDto.setResults(shoppingResultList);
					baseResponseDto.setPagination(baseResultDto.getPagination());
				}
				return baseResponseDto;
				
	}
	@RequestMapping("shopping/queryShoppingDetail/{shoppingUUId}")
	@Override
	public String queryShoppingDetail(Model model, @PathVariable("shoppingUUId") String shoppingUUId) {
		 ShoppingDbDto shoppingDbDto = new ShoppingDbDto();
		 shoppingDbDto = fitBusinessClient.loadShoppingDbInfoByUuId(shoppingUUId);
		 model.addAttribute("shoppingUuid", shoppingUUId);
		 model.addAttribute("passengers", shoppingDbDto.getShoppingPassengers());
		 model.addAttribute("hotels", shoppingDbDto.getShoppingHotels());
		 model.addAttribute("flights", shoppingDbDto.getShoppingFlight());
		 model.addAttribute("detail", shoppingDbDto.getShoppingDetails());		
		 model.addAttribute("spots", shoppingDbDto.getShoppingSpots());
		 List<ShoppingInsuranceDto> shoppingInsurances = shoppingDbDto.getShoppingInsurances();
		 if(CollectionUtils.isNotEmpty(shoppingInsurances)){
			 shoppingInsurances = handleInsuranceResult(shoppingInsurances);
		 }
		 model.addAttribute("insurances", shoppingInsurances);
		 model.addAttribute("flightInsurances", shoppingDbDto.getShoppingFlightInsurances());
		 return "shopping/shopping_detail";
	}
	
	/**
	 * 处理保险
	 * @param shoppingInsurances
	 * @return
	 */
	private List<ShoppingInsuranceDto> handleInsuranceResult(List<ShoppingInsuranceDto> shoppingInsurances) {
		for (ShoppingInsuranceDto shoppingInsuranceDto : shoppingInsurances) {
			shoppingInsuranceDto.setInsuranceType(InsuranceType.getCnName(Long.valueOf(shoppingInsuranceDto.getInsuranceType())));
		}
		return shoppingInsurances;
	}

	/**
	 * 导出Csv
	 * @param requestForm
	 * @param response
	 */
	@RequestMapping("shopping/exportCsv")
	@Override
	public void exportCsv(ShoppingListQueryRequestForm requestForm, HttpServletResponse response)
	{
		//1、设置查询条件
		Pagination pagination = new Pagination(1, 50000);
		FitShoppingListRequest fitShoppingListRequest = requestForm.getFitShoppingListRequest();
		BaseQueryDto<FitShoppingListRequest> baseQueryDto = new BaseQueryDto<FitShoppingListRequest>(
			pagination, fitShoppingListRequest);
		
		//2、查询订单导出列表
		List<String> orderListStrings = fitBusinessClient.queryShoppingListForExprot(baseQueryDto);
		CsvUtils.createCsvStream(FitCsvConfig.SHOPPING_LIST, orderListStrings, response);
	}

}
