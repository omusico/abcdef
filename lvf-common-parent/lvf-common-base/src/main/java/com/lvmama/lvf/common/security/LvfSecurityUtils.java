package com.lvmama.lvf.common.security;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.lvmama.lvf.common.security.antirefresh.AntiRefreshUtils;
import com.lvmama.lvf.common.utils.IpUtils;
import com.lvmama.lvf.common.utils.MD5Utils;
import com.lvmama.lvf.common.utils.MemcachedUtil;

public class LvfSecurityUtils {
	
	private static final Logger logger = Logger.getLogger(AntiRefreshUtils.class);

	private static final String SECURITY_KEY = "34c9f4c6-b7a9-4cda-a9e1-965aacd28d351459667453406";
	
	private static final LvfSecurityUtils instances = new LvfSecurityUtils();
	
	protected LvfSecurityUtils(){
	}
	
	public static LvfSecurityUtils getInstances(){
		return instances;
	}
	
	public static void main(String[] args){
		String sign = MD5Utils.generatePassword(UUID.randomUUID().toString()+"_"+new Date().getTime()+SECURITY_KEY);
		System.out.println(sign.toLowerCase());
	}
	
	public String[] getIpAndLvfId(HttpServletRequest request,HttpServletResponse response){
		
		String lvfId=getSecurityId(request,response);
		if(null == lvfId){
			try{
				String ip = IpUtils.getIpAddr(request);
				logger.error("getIp error:"+ip);
			}catch(Exception ex){
				logger.error("getIp:",ex);
			}
			return null;
		}
		
		String[] ip = getIpAndLvfId(lvfId,request,response);
		if(null == ip){
			return null;
		};
		
		return ip;
	}
	
	protected String[] getIpAndLvfId(String lvfId,HttpServletRequest request,HttpServletResponse response){
		
		try{
			
			String ip = IpUtils.getIpAddr(request);
			
			if(null == ip){
				return null;
			}
			
			String oldIp=(String)MemcachedUtil.getInstance().get(lvfId+"IP");
			String oldLvfId=(String)MemcachedUtil.getInstance().get(ip+"IP");
			
			//都没有
			if(StringUtils.isEmpty(oldIp)
					&& StringUtils.isEmpty(oldLvfId)){
				MemcachedUtil.getInstance().set(lvfId+"IP",ip);
				MemcachedUtil.getInstance().set(ip+"IP",lvfId);
				return new String[]{ip,lvfId};
			}
				
			//ip,id均一致
			if(ip.equals(oldIp)
					&&lvfId.equals(oldLvfId)){
				MemcachedUtil.getInstance().set(lvfId+"IP",3600,ip);
				MemcachedUtil.getInstance().set(ip+"IP",3600,lvfId);
				return new String[]{ip,lvfId};
			}
		
			//ip不一致(oldIp可能为null),id一致--可能重新拨号过
			if(!ip.equals(oldIp)){
				//oldIp不为空,则remove
				if(!StringUtils.isEmpty(oldIp)){
					MemcachedUtil.getInstance().remove(oldIp+"IP");
				}
				MemcachedUtil.getInstance().set(lvfId+"IP",3600,ip);
				MemcachedUtil.getInstance().set(ip+"IP",3600,lvfId);
				return new String[]{ip,lvfId};
			}
			
			//ip一致,id不一致(oldLvfId此情况可能为null)--可能清理过cookie或隐身模式
			if(ip.equals(oldIp)
					&&!lvfId.equals(oldLvfId)){
				
				if(!StringUtils.isEmpty(oldLvfId)){
					//刷新cookie,重置lvfId和以前的保持一致
					String lvfsessionId1 = oldLvfId;
					Cookie cookie = new Cookie("lvfsessionId1",lvfsessionId1);
					cookie.setDomain(".lvmama.com");
					cookie.setMaxAge(60*60*24*90);
					response.addCookie(cookie);
					
					//生成签名作为id2
					String lvfsessionId2 = MD5Utils.generatePassword(lvfsessionId1+SECURITY_KEY).toLowerCase();
					cookie = new Cookie("lvfsessionId2",lvfsessionId2);
					cookie.setDomain(".lvmama.com");
					cookie.setMaxAge(60*60*24*90);
					response.addCookie(cookie);
				}else{
					//为空则赋值为新的
					oldLvfId = lvfId;
				}
				//刷新关系
				MemcachedUtil.getInstance().set(lvfId+"IP",3600,ip);
				MemcachedUtil.getInstance().set(ip+"IP",3600,oldLvfId);
				return new String[]{ip,oldLvfId};
			}
			
		}catch(Exception ex){
			logger.error("bindIp error",ex);
		}
		return null;
	}
	
	
	protected String getSecurityId(HttpServletRequest request,HttpServletResponse response){
		
		try{
			
			Cookie[] cookies = request.getCookies();
			Cookie cookie =  null;
			String lvfsessionId1 =  null;
			String lvfsessionId2 = null;
			
			if(null==cookies){
				//没有cookie,重新初始化
				lvfsessionId1 = UUID.randomUUID().toString()+"_"+new Date().getTime();
				cookie = new Cookie("lvfsessionId1",lvfsessionId1);
				cookie.setDomain(".lvmama.com");
				cookie.setMaxAge(60*60*24*90);
				response.addCookie(cookie);
				
				//生成签名作为id2
				lvfsessionId2 = MD5Utils.generatePassword(lvfsessionId1+SECURITY_KEY).toLowerCase();
				cookie = new Cookie("lvfsessionId2",lvfsessionId2);
				cookie.setDomain(".lvmama.com");
				cookie.setMaxAge(60*60*24*90);
				response.addCookie(cookie);
				return lvfsessionId1;
			}
			
			for(Cookie co:cookies){
				if("lvfsessionId1".equals(co.getName())){
					cookie = co;
					lvfsessionId1 = co.getValue();
				}
				if("lvfsessionId2".equals(co.getName())){
					cookie = co;
					lvfsessionId2 = co.getValue();
				}
			}
			
			//有cookie,但是值为空
			if(null!=cookie&&(StringUtils.isEmpty(lvfsessionId1)
					||StringUtils.isEmpty(lvfsessionId2))){
				throw new Exception("疑似篡改id,限制访问");
			}
			
			//有cookie,值都存在
			if(null!=cookie){
				String sign = MD5Utils.generatePassword(lvfsessionId1+SECURITY_KEY).toLowerCase();
				//签名不符合
				if(!sign.equals(lvfsessionId2)){
					throw new Exception("疑似篡改id,限制访问");
				}else{
					return lvfsessionId1;
				}
				
			}else{
				//没有cookie,重新初始化
				lvfsessionId1 = UUID.randomUUID().toString()+"_"+new Date().getTime();
				cookie = new Cookie("lvfsessionId1",lvfsessionId1);
				cookie.setDomain(".lvmama.com");
				cookie.setMaxAge(60*60*24*90);
				response.addCookie(cookie);
				
				//生成签名作为id2
				lvfsessionId2 = MD5Utils.generatePassword(lvfsessionId1+SECURITY_KEY).toLowerCase();
				cookie = new Cookie("lvfsessionId2",lvfsessionId2);
				cookie.setDomain(".lvmama.com");
				cookie.setMaxAge(60*60*24*90);
				response.addCookie(cookie);
				return lvfsessionId1;
			}
			
		}catch(Exception ex){
			logger.error("add cookie error",ex);
		}		
		return null;
	}

}
