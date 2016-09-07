/**
 * 
 */
package com.lvmama.lvfit.adapter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lvmama.comm.pet.po.pub.ComIps;
import com.lvmama.vst.comm.utils.IPMap;
import com.lvmama.vst.comm.vo.IPEntry;
import com.lvmama.vst.pet.adapter.ComIpsServiceAdapter;

/**
 * 
 * IP库所有数据
 * 
 * @author 张振华
 * 
 */
public class LvfComIpsAreaData implements Serializable {
	
	private static Object LOCK = new Object();
	private static final Log log = LogFactory.getLog(LvfComIpsAreaData.class);
	private static final long serialVersionUID = 5958631532070231335L;
	private TreeMap<IPEntry, ComIps> comIpsCache = new  TreeMap<IPEntry, ComIps>();
	
	private static LvfComIpsAreaData instance;
	
	private ComIpsServiceAdapter ipsService;
	
	private LvfComIpsAreaData(){
	};
	
	private LvfComIpsAreaData(ComIpsServiceAdapter ipsService){
		this.ipsService = ipsService;
	};
	
	public static LvfComIpsAreaData getInstance(ComIpsServiceAdapter ipsService){
		if(instance == null ){
			instance = new LvfComIpsAreaData(ipsService);
			instance.init();
		}
		return instance;
	}
	private void init(){
		synchronized (LOCK) {
			try
            {
                if(comIpsCache.size() == 0){
                	log.info("===begin init comips===");
                	long begin = System.currentTimeMillis();
                	List<String> provinceIds = new ArrayList<String>();
                	provinceIds.add("310000");
                	provinceIds.add("320000");
                	provinceIds.add("330000");
                	provinceIds.add("110000");
                	provinceIds.add("440000");
                	List<ComIps>	listComIpsArea  = ipsService.selectComIpsByProvinceIds(provinceIds);
                	long end = System.currentTimeMillis();
                	log.info("init comips success. times(ms)"+(end-begin));
                	for (ComIps ci : listComIpsArea) {
                		comIpsCache.put(new IPEntry(ci.getIpStart(), ci.getIpEnd()), ci);
                	}
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                log.info("===init comips failed.===");
            }
		}
	}
	
	/**
	 * 从淘宝IP库获取所在地
	 * @param ipAddress
	 * @return
	 */
	public ComIps queryFromTaobaoIp(String ipAddress){
		ComIps ci = null;
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(3000);
		httpClient.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
		String content = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferReader = null;
		GetMethod getMethod = null;
		try {
			getMethod = new GetMethod("http://ip.taobao.com/service/getIpInfo.php?ip="+ipAddress);
			int statusCode =httpClient.executeMethod(getMethod);
			if (statusCode == HttpStatus.SC_OK) {
				inputStream = getMethod.getResponseBodyAsStream();
				inputStreamReader = new InputStreamReader(inputStream,"utf-8");
				bufferReader = new BufferedReader(inputStreamReader);
				String line = null;
				StringBuilder sb = new StringBuilder();
				while ((line = bufferReader.readLine()) != null) {
					sb.append(line.trim());
				}
				content = sb.toString();
				JSONObject jsonObject = JSONObject.fromObject(content); 
				
				Integer code = (Integer) jsonObject.get("code");
		        if(code != null && code == 0){
		        	JSONObject data =  (JSONObject) jsonObject.get("data");
		        	String city = (String) data.get("city");
		        	String region = (String) data.get("region");
		        	if(StringUtils.isNotEmpty(city)){
		        		String regex = "(.*)市$";
		        		Pattern p = Pattern.compile(regex);
		        		Matcher m=p.matcher(city); 
		        		if(m.find()){
		        			city = m.group(1);
		        		}
		        		ci= ipsService.selectComIpsByCityProvince(region, city, ipAddress);
		        	}
		        }else{
		        	log.warn("get ip fail, taobao code is: "+ipAddress);
		        }
			}else{
				log.warn("get taobao ip error http_status: "+statusCode +" ip:"+ipAddress);
			}
		} catch (Exception e) {
			log.warn(e.getMessage());
		} finally {
			if(bufferReader != null) {
				try {
					bufferReader.close();
				} catch (IOException e) {
					log.error("bufferReader.close "+e.getMessage());
				}
			}
			if(inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					log.error("inputStreamReader.close "+e.getMessage());
				}
			}
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					log.error("inputStream.close "+e.getMessage());
				}
			}
			if(getMethod != null) {
				try {
					getMethod.releaseConnection();
				} catch (Exception e) {
					log.error("getMethod.releaseConnection "+e.getMessage());
				}
			}
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return ci;
	}

	final int MAX_ENTRIES = 10000;
	Map<String,ComIps> unknownIpscache = new LinkedHashMap<String,ComIps>(MAX_ENTRIES + 1, .75F, true) {
		// This method is called just after a new entry has been added
		public boolean removeEldestEntry(Map.Entry eldest) {
			return size() > MAX_ENTRIES;
		}
	};

	public ComIps selectComIpsAreaByIp(String ip){

		if (unknownIpscache.containsKey(ip)) {
			return unknownIpscache.get(ip);
		}

		Long ipLong = IPMap.stringToLong(ip);
		ComIps cip = null;
		cip = comIpsCache.get(new IPEntry(ipLong));
		if (cip == null) {
			cip = ipsService.query(ip);
			if(cip == null ){//IP库中不存在当前IP
				cip = this.queryFromTaobaoIp(ip);

				log.info("Unkonwn IP: " + ip);
				unknownIpscache.put(ip, cip);
			}else{
				comIpsCache.put(new IPEntry(cip.getIpStart(), cip.getIpEnd()), cip);
			}
		}
		return cip;
	}
	public static ComIps selectComIpsAreaByIp(Long ip,ComIpsServiceAdapter ipsService) {
		return LvfComIpsAreaData.getInstance(ipsService).selectComIpsAreaByIp(IPMap.longToString(ip));
	}
	
	
}

