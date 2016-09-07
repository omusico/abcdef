package com.lvmama.lvf.common.client;

import org.apache.log4j.Logger;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.CPSClientPath;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.vst.CpsStatusRequest;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;

@Component
public class CPSClient {
	public static final Logger logger = Logger.getLogger(CPSClient.class);
	
	@Value("adapter-vst.baseurl")//现在放在VST下面
	private String baseUrl;
	
	@Autowired
	private RestClient restClient;
	
	/**
	 * cps通知消息
	 * @param cpsStatusRequest
	 * @return
	 * @throws Exception
	 */
	public BaseResultDto notifyOrderStatus(CpsStatusRequest cpsStatusRequest) throws Exception{
		CPSClientPath command = CPSClientPath.CPS_NOTIFY_ORDER_STATUS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,cpsStatusRequest);
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch(Exception e){
			logger.error(e.getMessage(),e);
			throw e;
		}
	}
	
}
