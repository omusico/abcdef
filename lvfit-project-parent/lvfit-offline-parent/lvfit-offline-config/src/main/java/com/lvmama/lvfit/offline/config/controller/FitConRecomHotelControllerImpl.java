package com.lvmama.lvfit.offline.config.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.enums.SymbolType;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelInputForm;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelRequestForm;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelResultForm;
import com.lvmama.lvfit.offline.config.FitConRecomHotelController;

@Controller
@RequestMapping("hotel")
public class FitConRecomHotelControllerImpl implements FitConRecomHotelController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FitConRecomHotelControllerImpl.class);
	@Autowired
	private FitBusinessClient businessClient;
	
	@RequestMapping("/toRecomHotelList")
	public String toRecomHotelList(){
		return "recomm_hotel_list";
	}
	
	/**
	 * 添加一条数据
	 * @param dto
	 */
	@Override
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,String> saveRecomHotel(FitConRecomHotelInputForm iuput){
		Map<String,String> map = new HashMap<String,String>();
		FitConRecomHotelDto dto = iuput.getFitConRecomHotelDto();
		try {
			Boolean flag = businessClient.saveRecomHotel(dto);
			map.put("flag", flag.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
		
	}
	/**
	 * 获取一条数据
	 * @param id
	 * @return
	 */
	@Override
	@RequestMapping(value="get",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public FitConRecomHotelResultForm getRecomHotel(Long id){
		try {
			FitConRecomHotelDto dto = businessClient.getRecomHotel(id);
			FitConRecomHotelResultForm form = new FitConRecomHotelResultForm(dto);
			return form;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@RequestMapping(value="edit",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,String> editConRecomHotel(FitConRecomHotelInputForm iuput){
		Map<String,String> map = new HashMap<String,String>();
		FitConRecomHotelDto dto = iuput.getFitConRecomHotelDto();
		
		try {
			Boolean flag = businessClient.updateRecomHotel(dto);
			map.put("flag", flag.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
		
	} 
	
	@Override
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Map<String,String> deleteRecomHotel(Long id){
		Map<String,String> map = new HashMap<String,String>();
		try {
			Boolean flag = businessClient.deleteRecomHotel(id);
			map.put("flag", flag.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 查出所有的m默认酒店数据
	 * @param model
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Override
	@RequestMapping(value="/queryRecomHotelList",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public BaseResponseDto<FitConRecomHotelResultForm> queryRecomHotelList(FitConRecomHotelInputForm input) throws JsonParseException, JsonMappingException, IOException{
		
		FitConRecomHotelDto request = input.getFitConRecomHotelDto();
		
		BaseQueryDto<FitConRecomHotelDto> baseQuery = new BaseQueryDto<FitConRecomHotelDto>();
		baseQuery.setPagination(input.getPagination());
		baseQuery.setCondition(request);
		
		//返回结果集
		BaseResponseDto<FitConRecomHotelResultForm> baseResponse = new BaseResponseDto<FitConRecomHotelResultForm>();
		
		try {
			BaseResultDto<FitConRecomHotelDto> response = businessClient.getFitConRecomHotelsAll(baseQuery);
			List<FitConRecomHotelDto> results = response.getResults();
			List<FitConRecomHotelResultForm> resultFormList = new ArrayList<FitConRecomHotelResultForm>();
			
			if(CollectionUtils.isNotEmpty(results)){
				for (FitConRecomHotelDto fcrhd : results) {
					FitConRecomHotelResultForm  resultForm = new FitConRecomHotelResultForm(fcrhd);
					resultFormList.add(resultForm);
				}
				baseResponse.setResults(resultFormList);
				baseResponse.setPagination(response.getPagination());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return baseResponse;
	}
	
	/**
	 * 批量导入默认酒店数据
	 * @param uploadFile
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@Override
	@RequestMapping(value="batch",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView batchSave(@RequestParam MultipartFile uploadFile, Model model)throws Exception{
		try {
			System.out.println("==============importBatch调用服务开始=================");
			//List<City> citys=businessClient.queryCitysByHot();
			//model.addAttribute("citys", citys);
			FitConRecomHotelRequestForm fitConRecomHotelRequestForm = readSheet(uploadFile.getInputStream());
			Boolean flag = null;
			try {
				System.out.println("==============调用服务开始=================");
				flag=businessClient.batchSaveRecomHotel(fitConRecomHotelRequestForm);
				System.out.println("==============调用服务结束=================");
			} catch (Exception e) {
				LOGGER.error("调用批量保存配置任务失败！",e);
				e.printStackTrace();
				flag = false;
			}
			BaseResponseDto<String> baseResponseDto = new BaseResponseDto<String>();
			if(flag){
				ModelAndView modelAndView = new ModelAndView();
				//modelAndView.addObject("citys", citys);
				modelAndView.addObject("importFlag", flag);
				modelAndView.setViewName("recomm_hotel_list");
				return modelAndView;
			}else{
				baseResponseDto.setMessage("导入失败！");
				return new ModelAndView("exception", "baseResponse", baseResponseDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
		
	}
	/**
     * 读取excel获取对应的数据
     * @param stream
     * @return
     */
    public FitConRecomHotelRequestForm readSheet(InputStream stream){
    	
    	XSSFWorkbook workbook;
    	FitConRecomHotelRequestForm fitConRecomHotelRequestForm = new FitConRecomHotelRequestForm();
		try {
			workbook = new XSSFWorkbook(stream);
			//解析Sheet
			XSSFSheet reconRecomHotelSheet =  workbook.getSheetAt(0);
			int reconRecomHotelCount = reconRecomHotelSheet.getLastRowNum()+1;
			List<FitConRecomHotelDto> fitConRecomHotelDtos = new ArrayList<FitConRecomHotelDto>();
			for (int i = 1; i < reconRecomHotelCount; i++) {
				FitConRecomHotelDto fitConRecomHotelDto = new FitConRecomHotelDto();
				 
				fitConRecomHotelDto.setCityName(reconRecomHotelSheet.getRow(i).getCell(0).toString());
				String productId = reconRecomHotelSheet.getRow(i).getCell(1).toString();
				if(productId.contains(".")){
					productId = productId.substring(0, productId.indexOf("."));
				}
				fitConRecomHotelDto.setProductId(productId);
				fitConRecomHotelDto.setIsDefault(SymbolType.N);
				fitConRecomHotelDto.setHotelName(reconRecomHotelSheet.getRow(i).getCell(2).toString());
				fitConRecomHotelDtos.add(fitConRecomHotelDto);
			}
			fitConRecomHotelRequestForm.setFitConRecomHotelDtos(fitConRecomHotelDtos);
			return fitConRecomHotelRequestForm;
		} catch (IOException e) {
			LOGGER.error("读取任务配置excel失败",e);			
		}
	    return null;
    	
    }

	@Override
	@RequestMapping(value="setDefaultHotel/{id}/{districtCityId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseSingleResultDto<Integer> setDefaultHotel(@PathVariable("id")Long id,@PathVariable("districtCityId")Long districtCityId) {
		BaseSingleResultDto<Integer> baseResult = businessClient.setDefaultHotel(id, districtCityId);
        return baseResult;
	}

	
}
