package com.lvmama.lvf.common.security.antirefresh;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lvmama.lvf.common.security.LvfSecurityUtils;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.MemcachedUtil;

public class AntiRefreshUtils extends LvfSecurityUtils {
	
	private static final Logger logger = Logger.getLogger(AntiRefreshUtils.class);

	private static final AntiRefreshUtils instances = new AntiRefreshUtils();
	
	
//	antiRefresh.config=SUM:200-400;F2:10-20;F4:20-40;300&50-75,600&100-150;
//	SUM是连续访问次数限制，FN是N秒快速访问次数限制，后面的是XX秒内访问次数限制
//	200-400是 超过200次增加间隔时间，超过400次拒绝访问
	
	//配置文件参数String str = "SUM:30-60;F2:2-4;F4:10-20;300&10-30,600&20-40";
	//连续访问总数限制/N秒快速访问限制/M秒内访问限制
	//lv1-lv2 lv1 增加间隔时间/lv2 拒绝访问刷拒绝链接
	private Map<String,String[]> getRc(){
		try{
			String str = CustomizedPropertyPlaceholderConfigurer.getContextProperty("antiRefresh.config");
			if(null==str){
				return null;
			}
			Map<String,String[]> map = new HashMap<String,String[]>();
			String[] str1 = str.split(";");
			for(String str2:str1){
				if(str2.contains("&")){
					String[] str3 = str2.split(",");
					for(String str4:str3){
						String [] str5 = str4.split("&");
						String [] str6 = str5[1].split("-");
						map.put(str5[0],str6);
					}
				}else{
					String[] val = str2.split(":");
					String [] val2 = val[1].split("-");
					map.put(val[0],val2);
				}
			}
			return map;
		}catch(Exception ex){
			logger.error("load anti refresh config error",ex);
			return null;
		}
	}
	
	protected AntiRefreshUtils(){
	}
	
	public static AntiRefreshUtils getInstances(){
		return instances;
	}
	
	public Boolean count(HttpServletRequest request,HttpServletResponse response){
		
		Map<String,String[]> map = getRc();
		if(null==map){
			return true;
		}
		
		String[] ipAndLvfId= getIpAndLvfId(request,response);
		if(null == ipAndLvfId){
			return false;
		}
		return count(map,ipAndLvfId[0],ipAndLvfId[1]);
	}
	
	protected Boolean count(Map<String,String[]> map,String ip,String lvfId){

		try{
			
			for(Entry<String,String[]> entry:map.entrySet()){
				String type = entry.getKey();
				Long lv1 = new Long(entry.getValue()[0]);
				Long lv2 = new Long(entry.getValue()[1]);
				String timeKey = lvfId+type+"TIME_";
				String countKey = lvfId+type+"COUNT_";
				
				Long longTime = (Long)MemcachedUtil.getInstance().get(timeKey);
				Integer count = (Integer)MemcachedUtil.getInstance().get(countKey);
				
				//获取不到则重置
				if(null == count){
					count = 0;
				}
				if(null == longTime){
					longTime = new Date().getTime();
				}
				
				if(type.startsWith("F")){
					//访问速度间隔低于FN秒时
					if(new Date().getTime() - longTime < 1000*(new Long(type.substring(1)))){
						MemcachedUtil.getInstance().set(countKey,count+1);
					}else{
						MemcachedUtil.getInstance().set(countKey,count);
					}
					MemcachedUtil.getInstance().set(timeKey,new Date().getTime());
				}else if(type.equals("SUM")){
					MemcachedUtil.getInstance().set(countKey,count+1);
					MemcachedUtil.getInstance().set(timeKey,longTime);
				}else{
					if((new Date().getTime() - longTime) < 1000*(new Long(type))){
						MemcachedUtil.getInstance().set(countKey,count+1);
						MemcachedUtil.getInstance().set(timeKey,longTime);
					}else{
						MemcachedUtil.getInstance().set(countKey,0);
						MemcachedUtil.getInstance().set(timeKey,new Date().getTime());
					}
				}
				
				logger.error("ip:"+ip+";lvfId:"+lvfId
						+";"+type+"上次访问时间:"+DateUtils.formatCnHmDateS(new Date(longTime))
						+";"+type+"累计请求次数:"+count);
				
				if(count > lv2){
					Thread.sleep(1000);
					logger.error("建议拒绝访问ip:"+ip+";lvfId:"+lvfId
							+";"+type+"上次访问时间:"+DateUtils.formatCnHmDateS(new Date(longTime))
							+";"+type+"累计请求次数:"+count);					
					return false;
				}
				if(count > lv1){
					Thread.sleep(2000);
					return true;
				}
				
			}
			
			return true;
		}catch(Exception ex){
			logger.error("count error!",ex);
			return false;
		}
	}
	
}
