/*
 * Copyright by Lvmama and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Lvmama from
 *
 *      http://www.lvmama.com
 *
 */ 
package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;


/**
 * 供应商默认工作时间   枚举类
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:yangxiaolong(杨小龙),
 *		date:2016年6月20日 下午12:42:17,content: </p>
 * @author yangxiaolong(杨小龙)
 * @date 2016年6月20日 下午12:42:17
 * @since
 * @version
 */
public enum PolicyPath {
	ADD_SUPP_WORK_TIME(Path.ADD_SUPP_WORK_TIME, "新增供应商默认工作时间"),
	QUERY_SUPP_WORK_TIME(Path.QUERY_SUPP_WORK_TIME, "查询供应商默认工作时间"),
	DELETE_SUPP_WORK_TIME_BY_CODE(Path.DELETE_SUPP_WORK_TIME_BY_CODE, "根据供应商编码删除工作时间"),
	
	ADD_POLICY_OPE_LOG(Path.ADD_POLICY_OPE_LOG, "插入政策操作日志"),
	QUERY_POLICY_OPE_LOG(Path.QUERY_POLICY_OPE_LOG, "查询政策操作日志");
	
	public String path;
	public String cnName;
	public static class Path{
		public final static String basePath = "bussiness/";
		/** 新增供应商默认工作时间 */
		public final static String ADD_SUPP_WORK_TIME = basePath + "suppWorkTime/add";
		/** 查询供应商默认工作时间 */
		public final static String QUERY_SUPP_WORK_TIME = basePath + "suppWorkTime/query";
		/** 根据供应商编码删除供应商工作时间*/
		public final static String DELETE_SUPP_WORK_TIME_BY_CODE = basePath + "suppWorkTime/deletByCode";
		
		public final static String ADD_POLICY_OPE_LOG = basePath + "policy/addPolicyOpeLog";
		public final static String QUERY_POLICY_OPE_LOG = basePath + "policy/queryPolicyOpeLog";
	}
	/**
	 * <p>创建一个新的实例 DefaultWorkTimePath</p>
	 * @author yangxiaolong(杨小龙)
	 * @date 2016年6月20日 下午12:47:17
	 * @param path
	 * @param cnName
	 */
	private PolicyPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
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
