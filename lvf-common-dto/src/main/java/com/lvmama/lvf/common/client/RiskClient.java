package com.lvmama.lvf.common.client;

import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.RiskClientPath;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.request.BlackIdRequest;
import com.lvmama.lvf.common.dto.request.ForbiddenWordRequest;
import com.lvmama.lvf.common.dto.request.RiskLimitBlackRequest;
import com.lvmama.lvf.common.dto.risk.BlackIdDto;
import com.lvmama.lvf.common.dto.risk.ForbiddenWordDto;
import com.lvmama.lvf.common.dto.risk.RiskLimitBlackDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;

@Component
public class RiskClient {

    @Value("risk.baseurl")
    private String baseUrl;

    @Autowired
    private RestClient restClient;

    public static final Logger logger = Logger.getLogger(RiskClient.class);

    /**
     * 查询风控黑名单信息列表
     * 
     * @param request
     * @return BaseResultDto<BlackIdDto>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResultDto<BlackIdDto> queryBlackIds(BaseQueryDto<BlackIdRequest> request)
            throws JsonParseException, JsonMappingException, IOException {
        RiskClientPath command = RiskClientPath.QUERY_BLACK_IDS;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(request);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<BlackIdDto>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    
    /**
     * 保存风控黑名单信息
     * 
     * @param blackIdDto
     * @return Boolean
     * @throws IOException
     */
    public Boolean saveBlackId(BlackIdDto blackIdDto) {
        RiskClientPath command = RiskClientPath.SAVE_BLACK_ID;
        String url = command.url(baseUrl);
        try {
            return restClient.post(url, Boolean.class, blackIdDto);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    public BaseResultDto<BlackIdDto> queryBlackIdsByCustomerId(String customerId) {
    	RiskClientPath command = RiskClientPath.QUERY_BLACK_IDS_BY_CUSTOMER_ID;
		String url = command.url(baseUrl, customerId);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<BlackIdDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (IOException exception) {
			throw new RuntimeException();
		}
	}
    
    /**
     * 查询禁用词信息
     * 
     * @param request
     * @return BaseResultDto<BlackIdDto>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResultDto<ForbiddenWordDto> queryForbiddenWord(BaseQueryDto<ForbiddenWordRequest> request){
        RiskClientPath command = RiskClientPath.QUERY_FORBIDDEN_WORD;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(request);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<ForbiddenWordDto>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 保存或更新禁用词信息
     * 
     * @param ForbiddenWordDto
     * @return Boolean
     * @throws IOException
     */
    public Boolean saveOrUpdFbdWord(ForbiddenWordDto dto) {
        RiskClientPath command = RiskClientPath.SAVE_OR_UPD_FORBIDDEN_WORD;
        String url = command.url(baseUrl);
        try {
            return restClient.post(url, Boolean.class, dto);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 删除禁用词信息
     * 
     * @param id Record主键ID
     * @return Boolean
     * @throws IOException
     */
    public Boolean delForbiddenWord(Long id) {
        RiskClientPath command = RiskClientPath.DELETE_FORBIDDEN_WORD;
        String url = command.url(baseUrl);
        try {
            return restClient.post(url, Boolean.class, id);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 
     * <p>保存针对南航新规的风控规则优化实体</p> 
     * @author 杨小龙yangxiaolong
     * @date 2016-7-28 下午4:21:27
     * @param riskLimitBlackDto
     * @return
     * @see
     */
    public RiskLimitBlackDto saveRiskLimitBlack(RiskLimitBlackDto riskLimitBlackDto) throws Exception{
        RiskClientPath command = RiskClientPath.SAVE_RISK_LIMIT_BLACK;
        String url = command.url(baseUrl);
        try {
            return restClient.post(url, RiskLimitBlackDto.class, riskLimitBlackDto);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 
     * <p>查询针对南航新规的风控规则优化实体</p> 
     * @author 杨小龙yangxiaolong
     * @date 2016-7-28 下午4:33:09
     * @param dto
     * @return
     * @throws Exception
     * @see
     */
    public BaseResultDto<RiskLimitBlackDto> queryRiskLimitBlack(BaseQueryDto<RiskLimitBlackRequest> baseQueryDto) throws Exception {
		RiskClientPath command = RiskClientPath.QUERY_RISK_LIMIT_BLACK;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<RiskLimitBlackDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch(Exception e){
			logger.error(e.getMessage(),e);
			throw e;
		}
	}
    
    
}
