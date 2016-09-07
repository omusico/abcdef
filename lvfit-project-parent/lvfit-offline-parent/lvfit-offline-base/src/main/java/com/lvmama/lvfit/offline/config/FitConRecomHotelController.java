package com.lvmama.lvfit.offline.config;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelInputForm;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelResultForm;

public interface FitConRecomHotelController {
	/**
	 * 添加数据
	 * @param model
	 * @param iuput
	 * @return
	 */
	public Map<String,String> saveRecomHotel(FitConRecomHotelInputForm iuput);
	/**
	 * 获取数据
	 * @param id
	 * @return
	 */
	public FitConRecomHotelResultForm getRecomHotel(Long id);
	/**
	 * 修改数据
	 * @param iuput
	 * @return
	 */
	public Map<String,String> editConRecomHotel(FitConRecomHotelInputForm iuput);
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	public Map<String,String> deleteRecomHotel(Long id);
	/**
	 * 获取全部数据
	 * @param input
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResponseDto<FitConRecomHotelResultForm> queryRecomHotelList(FitConRecomHotelInputForm input) throws JsonParseException, JsonMappingException, IOException;
	/**
	 * 批量导入数据
	 * @param uploadFile
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public ModelAndView batchSave(@RequestParam MultipartFile uploadFile, Model model)throws Exception;

	/**
	 * 设置默认推荐酒店
	 * @param id
	 * @param districtCityId
	 * @return
	 */
	BaseSingleResultDto<Integer> setDefaultHotel(Long id, Long districtCityId);

}
