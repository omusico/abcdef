package com.lvmama.lvf.common.client;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.TravelClientPath;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.travel.TravelAccountDto;
import com.lvmama.lvf.common.dto.travel.TravelCompanyInfoDto;
import com.lvmama.lvf.common.dto.travel.TravelPassengerDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;

/**
 * @author lutianyu
 * @date   2016年1月20日
 */
@Component
public class TravelClient {
	@Value("business.baseurl")
	private String baseUrl;

	@Autowired
	private RestClient restClient;
	
	public static final Logger logger=Logger.getLogger(TravelClient.class);
	
	public BaseResultDto<TravelCompanyInfoDto> queryCompanys(BaseQueryDto<TravelCompanyInfoDto> request){
		TravelClientPath command = TravelClientPath.QUERY_COMPANYS;
		String url = command.url(baseUrl);
		try {
			String resultStr = restClient.post(url, String.class, request);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<BaseResultDto<TravelCompanyInfoDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 *  查询公司的name及code,供前台查询条件用
	 * @return
	 */
	public List<TravelCompanyInfoDto> selectCompanyBaseInfo(){
		TravelClientPath command = TravelClientPath.SELECT_BASE_INFO;
		String url = command.url(baseUrl);
		try {
			String resultStr = restClient.get(url, String.class);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<List<TravelCompanyInfoDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 保存（新增or修改）公司
	 * @param travelCompanyInfoDto
	 * @return
	 */
	public BaseResultDto<TravelCompanyInfoDto> saveCompanyInfo(TravelCompanyInfoDto travelCompanyInfoDto){
		TravelClientPath command = TravelClientPath.SAVE_COMPANYS;
		String url = command.url(baseUrl);
		try {
			String resultStr = restClient.post(url, String.class, travelCompanyInfoDto);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<BaseResultDto<TravelCompanyInfoDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 根据id获取公司信息
	 * @param id
	 * @return
	 */
	public TravelCompanyInfoDto getCompanyById(Long id){
		TravelClientPath command = TravelClientPath.GET_COMPANY_BY_ID;
		String url = command.url(baseUrl,id);
		try {
			String resultStr = restClient.get(url, String.class);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<TravelCompanyInfoDto>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 根据登录名获取登录用户
	 * @param name
	 * @return
	 */
	public TravelAccountDto getTravelAccountByName(String name) {
		TravelClientPath command = TravelClientPath.GET_ACCOUNT_BY_NAME;
		String url = command.url(baseUrl);
		
		try {
			String jsonStr = restClient.post(url, String.class,name);
			return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<TravelAccountDto>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询乘客信息
	 * @param request
	 * @return
	 */
	public BaseResultDto<TravelPassengerDto> queryPassengers(BaseQueryDto<TravelPassengerDto> request){
		TravelClientPath command = TravelClientPath.QUERY_PASSENGERS;
		String url = command.url(baseUrl);
		try {
			String resultStr = restClient.post(url, String.class, request);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<BaseResultDto<TravelPassengerDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 保存（新增or修改）乘客
	 * @param travelPassengerDto
	 * @return
	 */
	public BaseResultDto<TravelPassengerDto> savePassenger(TravelPassengerDto travelPassengerDto){
		TravelClientPath command = TravelClientPath.SAVE_PASSENGERS;
		String url = command.url(baseUrl);
		try {
			String resultStr = restClient.post(url, String.class, travelPassengerDto);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<BaseResultDto<TravelPassengerDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 批量导入保存乘客信息
	 * @param passengers
	 * @return
	 */
	public BaseResultDto<TravelPassengerDto> batchSavePassengers(List<TravelPassengerDto> passengers){
		TravelClientPath command = TravelClientPath.BATCH_SAVE_PASSENGERS;
		String url = command.url(baseUrl);
		try {
			String resultStr = restClient.post(url, String.class, passengers);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<BaseResultDto<TravelPassengerDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 根据id获取乘客信息
	 * @param id
	 * @return
	 */
	public TravelPassengerDto getPassengerById(Long id){
		TravelClientPath command = TravelClientPath.GET_PASSENGER_BY_ID;
		String url = command.url(baseUrl,id);
		try {
			String resultStr = restClient.get(url, String.class);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<TravelPassengerDto>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	/**
	 * 根据公司编码获取公司信息
	 * @param code
	 * @return
	 */
	public TravelCompanyInfoDto getCompanyByCode(String code) {
		TravelClientPath command = TravelClientPath.GET_COMPANY_BY_CODE;
		String url = command.url(baseUrl);
		
		try {
			String jsonStr = restClient.post(url, String.class, code);
			if(StringUtils.isNotBlank(jsonStr)){
				return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<TravelCompanyInfoDto>() { });
			}
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	/**
	 * 根据乘客姓名获取乘客
	 */
	public List<TravelPassengerDto> getPassengerByName(String name) {
		TravelClientPath command = TravelClientPath.GET_PASSENGER_BY_NAME;
		String url = command.url(baseUrl);
		try {
			String jsonStr = restClient.post(url, String.class, name);
			if(jsonStr != ""){
				return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<List<TravelPassengerDto>>() { });
			}
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 根据id 删除乘客
	 * @param id
	 * @return
	 */
	public Boolean deleteTravelPassenger(Long id) {
		TravelClientPath command = TravelClientPath.DELETE_PASSENGER_BY_ID;
		String url = command.url(baseUrl);
		
		try {
			String jsonStr = restClient.post(url, String.class, id);
			return Boolean.valueOf(jsonStr);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;		
		}
	}
	
	/**
	 * 查询账户信息
	 * @param baseQuery
	 * @return
	 */
	public BaseResultDto<TravelAccountDto> queryAccounts(BaseQueryDto<TravelAccountDto> baseQuery) {
		TravelClientPath command = TravelClientPath.QUERY_ACCOUNTS;
		String url = command.url(baseUrl);
		
		try {
			String jsonStr = restClient.post(url, String.class, baseQuery);
			return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<BaseResultDto<TravelAccountDto>>() {});
		}catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;		
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 保存（新增or修改）账户
	 * @param travelAccountDto
	 * @return
	 */
	public BaseResultDto<TravelAccountDto> saveAccount(TravelAccountDto travelAccountDto){
		TravelClientPath command = TravelClientPath.SAVE_ACCOUNT;
		String url = command.url(baseUrl);
		try {
			String resultStr = restClient.post(url, String.class, travelAccountDto);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<BaseResultDto<TravelAccountDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * 根据id获取账户信息
	 * @param id
	 * @return
	 */
	public TravelAccountDto getAccountById(Long id){
		TravelClientPath command = TravelClientPath.GET_ACCOUNT_BY_ID;
		String url = command.url(baseUrl,id);
		try {
			String resultStr = restClient.get(url, String.class);
			return JSONMapper.getInstance().readValue(resultStr, new TypeReference<TravelAccountDto>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
}
