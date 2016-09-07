package com.lvmama.lvf.common.client;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.ScheduleClientPath;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.vst.VstTaskConfigDto;
import com.lvmama.lvf.common.dto.vst.VstTaskOpLog;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.form.config.TaskConfigRequestForm;
import com.lvmama.lvf.common.form.config.VSTTaskConfigRequestForm;
import com.lvmama.lvf.common.form.config.VSTTaskConfigResponseForm;
import com.lvmama.lvf.common.form.vst.VstTaskOpLogRequestForm;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * 业务接口远程调用类
 * 
 * @author majun
 * @date 2015-1-29
 */
@Component
public class ScheduleClient {

	/** 远程地址 */
	@Value("schedule.baseurl")
	private String baseUrl;

	/** 远程服务 */
	@Autowired
	private RestClient restClient;
	
	public static final Logger logger=Logger.getLogger(ScheduleClient.class);

	public String autoImportVstTasks() throws Exception{
		ScheduleClientPath command = ScheduleClientPath.AUTO_IMPORT_VST_TASKS;
		String url = command.url(baseUrl);
		try {
			return restClient.get(url, String.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	public String getAndRunVstTasks() throws Exception{
		ScheduleClientPath command = ScheduleClientPath.GET_AND_RUN_VST_TASKS;
		String url = command.url(baseUrl);
		try {
			return restClient.get(url, String.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 执行VST某条具体航线的定时任务
	 * @return
	 * @throws Exception
	 */
	public VSTTaskConfigResponseForm excuteVstTask(VSTTaskConfigRequestForm i) throws Exception{
		ScheduleClientPath command = ScheduleClientPath.EXCUTE_VST_TASK;
		String url = command.url(baseUrl);
		System.out.println(url);
		try {
			return restClient.post(url, VSTTaskConfigResponseForm.class,i);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 启用/禁VST某条具体航线的定时任务
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public String switchVstTaskStatus(VSTTaskConfigRequestForm i) throws Exception{
		ScheduleClientPath command = ScheduleClientPath.SWITCH_VST_TASK_STATUS;
		String url = command.url(baseUrl);
		System.out.println(url);
		try {
			return restClient.post(url, String.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 修改VST某条具体航线的定时任务
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public String modifyVstTask(VSTTaskConfigRequestForm i) throws Exception{
		ScheduleClientPath command = ScheduleClientPath.MODIFY_VST_TASK;
		String url = command.url(baseUrl);
		System.out.println(url);
		try {
			return restClient.post(url, String.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 操作VST定时任务
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public VSTTaskConfigResponseForm handleVstTask(VSTTaskConfigRequestForm i) throws Exception{
		ScheduleClientPath command = ScheduleClientPath.HANDLE_VST_TASK;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, VSTTaskConfigResponseForm.class,i);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据条件查询vst任务配置信息
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<VstTaskConfigDto> queryVstTaskConfigs(BaseQueryDto<VSTTaskConfigRequestForm> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		ScheduleClientPath command = ScheduleClientPath.QUERY_VST_TASK_CONFIGS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<VstTaskConfigDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 保存VST任务配置信息
	 * @param form
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public VSTTaskConfigResponseForm saveVstTaskConfig(VSTTaskConfigRequestForm form) throws Exception{
		ScheduleClientPath command = ScheduleClientPath.SAVE_VST_TASK_CONFIG;
		String url = command.url(baseUrl);
		try {
			VSTTaskConfigResponseForm response = restClient.post(url, VSTTaskConfigResponseForm.class,form);
			return response;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据ID查询VST任务配置信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public VstTaskConfigDto getVstTaskConfigById(Long id) throws Exception{
		ScheduleClientPath command = ScheduleClientPath.GET_VST_TASK_CONFIG_BY_ID;
		String url = command.url(baseUrl,id);
		try {
			VstTaskConfigDto dto = restClient.get(url, VstTaskConfigDto.class);
			return dto;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 查询VST定时任务日志
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<VstTaskOpLog> queryVstTaskOpLogs(BaseQueryDto<VstTaskOpLogRequestForm> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		ScheduleClientPath command = ScheduleClientPath.QUERY_VST_TASK_OP_LOG;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<VstTaskOpLog>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 添加VST定时任务日志
	 * @param log
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public VstTaskOpLog addVstTaskOpLog(VstTaskOpLog log) throws JsonParseException, JsonMappingException, IOException{
		ScheduleClientPath command = ScheduleClientPath.ADD_VST_TASK_OP_LOG;
		String url = command.url(baseUrl);
		try {
			VstTaskOpLog tempLog = restClient.post(url, VstTaskOpLog.class,log);
			return tempLog;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * saveUpdate任务配置
	 * @param baseQueryDto
	 * @return
	 */
	public Boolean batchSaveTaskConfig(
			TaskConfigRequestForm taskConfigRequestForm) {
		ScheduleClientPath command = ScheduleClientPath.TASK_CONFIG_BATCH_SAVE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, Boolean.class,taskConfigRequestForm);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 获取配置了缓存的任务配置航线
	 * @param baseQueryDto
	 * @return
	 */
	public String selectBaseFlightLineNeedToSync() {
		ScheduleClientPath command = ScheduleClientPath.SELECT_BASE_FLIGHT_LINE_NEED_TOS_YNC;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, String.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
}
