package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum ScheduleClientPath {

	RUN_VST_TASK(Path.RUN_VST_TASK, "运行VST定时任务"),
	EXCUTE_VST_TASK(Path.EXCUTE_VST_TASK,"执行VST某个航线的定时任务"),
	SWITCH_VST_TASK_STATUS(Path.SWITCH_VST_TASK_STATUS,"禁用/启用VST某个航线定时任务"),
	MODIFY_VST_TASK(Path.MODIFY_VST_TASK,"修改VST某个航线时间任务"),
	HANDLE_VST_TASK(Path.HANDLE_VST_TASK,"操作VST定时任务"),
	GET_AND_RUN_VST_TASKS(Path.GET_AND_RUN_VST_TASKS,"获取VST任务配置和运行VST任务"),
	AUTO_IMPORT_VST_TASKS(Path.AUTO_IMPORT_VST_TASKS, "自动导入VST任务配置"),
	QUERY_VST_TASK_CONFIGS(Path.QUERY_VST_TASK_CONFIGS,"根据条件查询VST任务配置信息"),
	SAVE_VST_TASK_CONFIG(Path.SAVE_VST_TASK_CONFIG,"保存VST任务配置信息"),
	GET_VST_TASK_CONFIG_BY_ID(Path.GET_VST_TASK_CONFIG_BY_ID,"根据ID查询VST任务配置信息"),
	ADD_VST_TASK_OP_LOG(Path.ADD_VST_TASK_OP_LOG,"添加VST定时任务的操作日志"),
	QUERY_VST_TASK_OP_LOG(Path.QUERY_VST_TASK_OP_LOG,"查询VST定时任务的操作日志"),
	
	
	TASK_CONFIG_BATCH_SAVE(Path.TASK_CONFIG_BATCH_SAVE,"任务配置批量新增"),
	INSERT_NEED_SYNC_TASK_CONFIG_TEMP(Path.INSERT_NEED_SYNC_TASK_CONFIG_TEMP,"新增需要同步航班的当前任务配置数据"),
	SYNC_FLIGHT_BASE_INFO_BY_TASK_CONFIG(Path.SYNC_FLIGHT_BASE_INFO_BY_TASK_CONFIG,"根据当前需要同步的任务配置同步通过51同步航班基本信息"),
	SYNC_FLIGHT_BY_TASK_CONFIG_TEMP(Path.SYNC_FLIGHT_BY_TASK_CONFIG_TEMP,"根据当前任务配置数据同步航班"),
	SELECT_BASE_FLIGHT_LINE_NEED_TOS_YNC(Path.SELECT_BASE_FLIGHT_LINE_NEED_TOS_YNC," 获取配置了缓存的任务配置航线");
     
	
	public String path;
	public String cnName;
	
	public static class Path{
		
		public final static String basePath="bussiness/";
		public final static String orderPath ="order/";
		public final static String suppOrderPath = "suppOrder/";
		public final static String ticketPath ="ticket/";
		public final static String flightPath = "flight/";
		public final static String configPath = "config/";
		public final static String apiPath = "api/";
		public final static String schedulePath = "schedule/";
		public final static String taskPath = "task/";

        public final static String RUN_VST_TASK = schedulePath + taskPath + "runVstTask";
        
        public final static String EXCUTE_VST_TASK = schedulePath + taskPath + "excuteVstTask";
        
        public final static String SWITCH_VST_TASK_STATUS = schedulePath + taskPath + "switchVstTaskStatus";
        
        public final static String MODIFY_VST_TASK = schedulePath + taskPath + "modifyVstTask";
        
        public final static String HANDLE_VST_TASK = schedulePath + taskPath + "handleVstTask";
        
        public final static String GET_AND_RUN_VST_TASKS = schedulePath + taskPath + "getAndRunVstTasks";
        
        public final static String AUTO_IMPORT_VST_TASKS = schedulePath + taskPath + "autoImportVstTasks";
        
        public final static String QUERY_VST_TASK_CONFIGS = schedulePath + configPath +"queryVstTaskConfigs";
        
        public final static String SAVE_VST_TASK_CONFIG = schedulePath + configPath +"saveVstTaskConfig";
        
        public final static String GET_VST_TASK_CONFIG_BY_ID = schedulePath + configPath + "getVstTaskConfigById/{id}";
        
        public final static String ADD_VST_TASK_OP_LOG = schedulePath + configPath + "addVstTaskOpLog";
        
        public final static String QUERY_VST_TASK_OP_LOG = schedulePath + configPath + "queryVstTaskOpLogs";
        
        
        public static final String TASK_CONFIG_BATCH_SAVE = schedulePath+configPath+"batchSaveTaskConfig";
        
        public static final String INSERT_NEED_SYNC_TASK_CONFIG_TEMP = schedulePath+configPath+"insertNeedSyncTaskConfigTemp";
        
        public static final String SYNC_FLIGHT_BASE_INFO_BY_TASK_CONFIG = schedulePath+configPath+"syncflightBaseInfoByTaskConfig";
        
        public static final String SYNC_FLIGHT_BY_TASK_CONFIG_TEMP = schedulePath+configPath+"syncFlightByTaskConfigTemp/{model}";
        
        public static final String SELECT_BASE_FLIGHT_LINE_NEED_TOS_YNC = schedulePath+configPath+"selectBaseFlightLineNeedToSync";
        
      
        
        
	}
	
	private ScheduleClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getCnName() {
		return cnName;
	}

	public String url(String baseUrl){
		if(!baseUrl.contains("http")){
			baseUrl = CustomizedPropertyPlaceholderConfigurer.getContextProperty(baseUrl);
		}
		if(baseUrl.endsWith("/")){
			return baseUrl+this.path;
		}
		return baseUrl+"/" +this.path;
	}
	
	public String url(String baseUrl,Object... args){
		String url = url(baseUrl);
		String pat="\\{\\w*\\}";
		return String.format(url.replaceAll(pat,"%s"),args);
	}
}
