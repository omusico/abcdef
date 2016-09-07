package com.lvmama.lvf.common.client;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.MaindataClientPath;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseReponseHandle;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.md.AirplaneCompany;
import com.lvmama.lvf.common.dto.md.Airport;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.SeatClass;
import com.lvmama.lvf.common.dto.request.AirPlaneRequest;
import com.lvmama.lvf.common.dto.request.AirportRequest;
import com.lvmama.lvf.common.dto.request.CarrierRequest;
import com.lvmama.lvf.common.dto.request.SeatClassRequest;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * 主数据管理远程调用
 * @author suihaonan
 *
 */
@Component
public class MaindataClient {

	/** 远程地址 */
	@Value("business.maindataurl")
	private String maindataurl;
	
	/** 远程服务 */
	@Autowired
	private RestClient restClient;
	
	public static final Logger logger=Logger.getLogger(MaindataClient.class);
	
	/**
	 * 机场城市列表
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<Airport> queryAirportList(BaseQueryDto<AirportRequest> baseQueryDto) 
	{
		MaindataClientPath command = MaindataClientPath.AIRPORT_CITY_QUERY_LIST;
		String url = command.url(maindataurl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<Airport>>(){});
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加或修改机场城市
	 * @param baseQueryDto
	 * @return
	 */
	public BaseReponseHandle saveAirport(AirportRequest request) 
	{
		MaindataClientPath command = MaindataClientPath.AIRPORT_CITY_ADD;
		String url = command.url(maindataurl);
		try 
		{
			return restClient.post(url, BaseReponseHandle.class,request);
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
	}
	
	/**
	 * 根据id查询
	 * @param baseQueryDto
	 * @return
	 */
	public Airport getAirportById(Long airportId) 
	{
		MaindataClientPath command = MaindataClientPath.AIRPORT_GET_BY_ID;
		String url = command.url(maindataurl,airportId);
		try{
			return	restClient.get(url, Airport.class);
		}catch(ExceptionWrapper ew){
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据id查询
	 * @param baseQueryDto
	 * @return
	 */
	public Carrier getCarrierById(Long carrierId) 
	{
		MaindataClientPath command = MaindataClientPath.CARRIER_GET_BY_ID;
		String url = command.url(maindataurl,carrierId);
		try{
			return	restClient.get(url, Carrier.class);
		}catch(ExceptionWrapper ew){
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 删除机场城市
	 * @param baseQueryDto
	 * @return
	 */
	public BaseReponseHandle deleteAirport(Long airportId) 
	{
		MaindataClientPath command = MaindataClientPath.AIRPORT_CITY_DELETE;
		String url = command.url(maindataurl,airportId);
		try{
			return	restClient.get(url, BaseReponseHandle.class);
		}catch(ExceptionWrapper ew){
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 航空公司列表
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<Carrier> queryCarrierList(BaseQueryDto<CarrierRequest> baseQueryDto) 
	{
		MaindataClientPath command = MaindataClientPath.CARRIER_QUERY_LIST;
		String url = command.url(maindataurl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<Carrier>>(){});
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加或修改航空公司
	 * @param baseQueryDto
	 * @return
	 */
	public BaseReponseHandle saveCarrier(CarrierRequest request) 
	{
		MaindataClientPath command = MaindataClientPath.CARRIER_ADD;
		String url = command.url(maindataurl);
		try 
		{
			return restClient.post(url, BaseReponseHandle.class, request);
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
	}
	
	/**
	 * 删除航空公司
	 * @param baseQueryDto
	 * @return
	 */
	public BaseReponseHandle deleteCarrier(Long carrierId) 
	{
		MaindataClientPath command = MaindataClientPath.CARRIER_DELETE;
		String url = command.url(maindataurl,carrierId);
		try 
		{
			return restClient.get(url, BaseReponseHandle.class);
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  查找机型列表信息
	 * @param baseQueryDto
	 * @return
	 */
	
	public BaseResultDto<Airplane> queryAirPlaneList(BaseQueryDto<AirPlaneRequest> baseQueryDto){
		MaindataClientPath command = MaindataClientPath.QUERY_AIRPLANE_LIST;
		String url = command.url(maindataurl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<Airplane>>(){});
		} 	catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 保存 或更新 机型信息
	 * @param airPlaneRequest
	 * @return
	 */
	public ResultStatus saveOrUpdateAirPlane(AirPlaneRequest airPlaneRequest){
		MaindataClientPath command = MaindataClientPath.SAVEORUPDATE_AIRPLANE;
		String url = command.url(maindataurl);
		try {
            return restClient.post(url, ResultStatus.class, airPlaneRequest);
        } catch (ExceptionWrapper ew) {
        	//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过ID 获得机型信息
	 * @param id
	 * @return
	 */
	public Airplane getByIdAirPlane(Long airPlanId){
		MaindataClientPath command = MaindataClientPath.GET_BYID_AIRPLANE;
		String url = command.url(maindataurl,airPlanId);
		try {
            return restClient.get(url, Airplane.class);
        } catch (ExceptionWrapper ew) {
        	//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 *  查找舱位列表
	 * @param baseQueryDto
	 * @return
	 */
	public  BaseResultDto<SeatClass> querySeatList(BaseQueryDto<SeatClassRequest> baseQueryDto){
		MaindataClientPath command = MaindataClientPath.QUERY_SEAT_LIST;
		String url = command.url(maindataurl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<SeatClass>>(){});
		} 	catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 保存或更新舱位
	 * @param seatClassRequest
	 * @return
	 */
	public ResultStatus saveOrUpdateSeat(SeatClassRequest seatClassRequest){
		MaindataClientPath command = MaindataClientPath.SAVEORUPDATE_SEAT;
		String url = command.url(maindataurl);
		try {
            return restClient.post(url, ResultStatus.class, seatClassRequest);
        } catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
	}
	/**
	 * 获得舱位
	 * @param seatId
	 * @return
	 */
	public SeatClass getByIdSeat(Long seatId){
		MaindataClientPath command = MaindataClientPath.GET_BYID_SEAT;
		String url = command.url(maindataurl,seatId);
		try {
			return restClient.get(url, SeatClass.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	
	/**
	 * 删除舱位
	 * @param seatId
	 * @return
	 */
	public BaseReponseHandle deleteSeat(Long seatId) 
	{
		MaindataClientPath command = MaindataClientPath.DELETE_SEAT;
		String url = command.url(maindataurl,seatId);
		try 
		{
			return restClient.get(url, BaseReponseHandle.class);
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 删除机型
	 * @param airPlaneId
	 * @return
	 */
	public BaseReponseHandle deleteAirPlane(Long airPlaneId) 
	{
		MaindataClientPath command = MaindataClientPath.DELETE_AIRPLANE;
		String url = command.url(maindataurl,airPlaneId);
		try 
		{
			return restClient.get(url, BaseReponseHandle.class);
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询航空公司信息
	 * @param carrierCode
	 * @return 
	 */
	public List<SeatClass> querySeatsByCarrierCode(String carrierCode) {
		MaindataClientPath command = MaindataClientPath.QUERY_SEATS_BY_CARRIER_CODE;
		String url = command.url(maindataurl,carrierCode);
		try {
			String resultString = restClient.post(url, String.class);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<SeatClass>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据航空公司CODE和舱位CODE查询舱位信息
	 * @param carrierCode
	 * @param code
	 * @return 
	 */
	public List<SeatClass> querySeatsByCarrierWithSeatCode(String carrierCode, String code) {
		MaindataClientPath command = MaindataClientPath.QUERY_SEATS_BY_CARRIER_WITH_SEAT_CODE;
		String url = command.url(maindataurl,carrierCode,code);
		try {
			String resultString = restClient.post(url, String.class);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<SeatClass>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据航空公司CODE查询航空公司信息
	 * @param code
	 * @return 
	 */
	public List<Carrier> queryCarriersByCode(String code) {
		MaindataClientPath command = MaindataClientPath.QUERY_CARRIERS_BY_CODE;
		String url = command.url(maindataurl,code);
		try {
			String resultString = restClient.post(url, String.class);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<Carrier>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据机型CODE查询机型信息
	 * @param code
	 * @return 
	 */
	public List<Airplane> queryAirplanesByCode(String code) {
		MaindataClientPath command = MaindataClientPath.QUERY_AIRPLANES_BY_CODE;
		String url = command.url(maindataurl,code);
		try {
			String resultString = restClient.post(url, String.class);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<Airplane>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}

	/**
	 * 查询航空公司信息
	 * 
	 * 
	 */
	public List<AirplaneCompany> getAirplaneCompanies() {
		MaindataClientPath command = MaindataClientPath.QUERY_AIRPLANE_COMPANIES;
		String url = command.url(maindataurl);
		try {
			String resultString = restClient.post(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<AirplaneCompany>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 查询航线信息
	 * @param	baseQueryDto
	 * @return	BaseResultDto
	 */
	public BaseResultDto<FlightAirLineDto> queryAirlinesByCity(BaseQueryDto<FlightAirLineDto> baseQueryDto) {
		MaindataClientPath command = MaindataClientPath.QUERY_AIRLINES_BY_CITY;
		String url = command.url(maindataurl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FlightAirLineDto>>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
}
