package com.lvmama.lvf.common.trace;

import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;

import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.dto.Oper;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.IpUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;

public class TraceContext {
	
	private static Logger logger = LoggerFactory.getLogger(TraceContext.class);
	
	public final static String prefix = "LVMAMALVFHEADER";
	
	private static String hostIp = null;
	
	static {
		try{
			hostIp = InetAddress.getLocalHost().getHostAddress();
		}catch(Exception ex){
		}
	}
	
	public static String getHeaderKey(String key){
		return (TraceContext.prefix+key).toLowerCase();
	}
	
	public static void startTrace(BaseTraceInfo object) {
		try{
			TraceContext.setIp(object.getIp());
			TraceContext.setEquipmentNo(object.getEquipmentNo());
			TraceContext.setServerTrace(null);
			TraceContext.setServerTraceTime(null);
			TraceContext.setTraceId(null);
			TraceContext.setCustomer(object.getCustomer());
		}catch(Exception ex){
			logger.warn("startTrace fail baseTraceInfo !");
		}
	}
	
	public static void startTrace(HttpServletRequest request){
//		logger.warn("startTrace"+request.getRequestURI()+":"+request.getQueryString());
		try{
			String ip = TraceContext.getIp(request);
			TraceContext.setIp(ip);
			TraceContext.setServerTrace(null);
			TraceContext.setServerTraceTime(null);
			TraceContext.setTraceId(null);
		}catch(Exception ex){
			logger.warn("startTrace fail"+request.getRequestURI()+":"+request.getQueryString());
		}
	}
	
	public static MultivaluedMap<String,Object> getContext2MultivaluedMap(){
		
    	MultivaluedMap<String,Object> headerMap = new MultivaluedMapImpl<String, Object>();
		try{
	    	
	    	String oper = TraceContext.getOper();
	    	if(null!=oper){
		    	headerMap.putSingle(getHeaderKey(TraceContextKey.OPER.name()),oper);
	    	}
	    	String customer = TraceContext.getCustomer();
	    	if(null!=customer){
	    		headerMap.putSingle(getHeaderKey(TraceContextKey.CUSTOMER.name()),customer);
	    	}
	    	String traceId = TraceContext.getTraceId();
	    	if(null!=traceId){
	    		headerMap.putSingle(getHeaderKey(TraceContextKey.TRACENO.name()),traceId);
	    	}
	    	String ip = TraceContext.getIp();
	    	if(null!=ip){
	    		headerMap.putSingle(getHeaderKey(TraceContextKey.IP.name()),ip);
	    	}
//	    	String equipmentNo = TraceContext.getEquipmentNo();
//	    	if(null!=equipmentNo){
//	    		headerMap.putSingle(getHeaderKey(TraceContextKey.EQUIPMENTNO.name()),equipmentNo);
//	    	}
	    	String serverTrace=TraceContext.getServerTrace();
	    	if(null!=serverTrace){
	    		headerMap.putSingle(getHeaderKey(TraceContextKey.SERVERIPTRACE.name()),serverTrace);
	    	}    	
	    	String serverTraceTime = TraceContext.getServerTraceTime();
	    	if(null!=serverTraceTime){
	    		headerMap.putSingle(getHeaderKey(TraceContextKey.SERVERTIMETRACE.name()),serverTraceTime);
	    	}
	    	String isLogging = TraceContext.getNotLogging();
	    	if(null!=isLogging){
	    		headerMap.putSingle(getHeaderKey(TraceContextKey.NOTLOGGING.name()),isLogging);
	    	}    	

		}catch(Exception ex){
			logger.warn("startTrace fail getContext2MultivaluedMap!");
    	}
    	return headerMap;
		
	}
	
	public static void startTrace(MultivaluedMap<String,String> headers){
		
		try{
		
//		logger.warn("startTrace"+arg0.getUriInfo().getPath()+":"+arg0.getRequest().getMethod());

//		for(Entry<String,List<String>> entry:headers.entrySet()){
//			logger.warn(entry.getKey()+""+entry.getValue());
//		}
		
		String ip = headers.getFirst(getHeaderKey(TraceContextKey.IP.name()));
//		logger.warn("startTrace(MultivaluedMap<String,String> headers):"+ip);
		TraceContext.setIp(ip);
		
		String equipmentNo = headers.getFirst(getHeaderKey(TraceContextKey.EQUIPMENTNO.name()));
//		logger.warn("startTrace(MultivaluedMap<String,String> headers):"+equipmentNo);
		TraceContext.setEquipmentNo(equipmentNo);
		
		String serverTrace = headers.getFirst(getHeaderKey(TraceContextKey.SERVERIPTRACE.name()));
//		logger.warn("startTrace(MultivaluedMap<String,String> headers):"+serverTrace);
		TraceContext.setServerTrace(serverTrace);
		
		String serverTraceTime = headers.getFirst(getHeaderKey(TraceContextKey.SERVERTIMETRACE.name()));
//		logger.warn("startTrace(MultivaluedMap<String,String> headers):"+serverTraceTime);
		TraceContext.setServerTraceTime(serverTraceTime);
		
		String traceId = headers.getFirst(getHeaderKey(TraceContextKey.TRACENO.name()));
//		logger.warn("startTrace(MultivaluedMap<String,String> headers):"+traceId);
		TraceContext.setTraceId(traceId);
		
		String oper = headers.getFirst(getHeaderKey(TraceContextKey.OPER.name()));
//		logger.warn("startTrace(MultivaluedMap<String,String> headers):"+oper);
		TraceContext.setOper(oper);

		String customer = headers.getFirst(getHeaderKey(TraceContextKey.CUSTOMER.name()));
//		logger.warn("startTrace(MultivaluedMap<String,String> headers):"+customer);
		TraceContext.setCustomer(customer);
		

		String notLogging = headers.getFirst(getHeaderKey(TraceContextKey.NOTLOGGING.name()));
//		logger.warn("startTrace(MultivaluedMap<String,String> headers):"+customer);
		TraceContext.setNotLogging(Boolean.valueOf(notLogging));
		
		}catch(Exception ex){
			logger.warn("startTrace fail !");
//			for(Entry<String,List<String>> entry:headers.entrySet()){
//				logger.warn(entry.getKey()+""+entry.getValue());
//			}
		}

	}

	public static void clear(){
		try{
			TraceContext.removeCustomer();
			TraceContext.removeIp();
			//TraceContext.removeEquipmentNo();
			TraceContext.removeOper();
			TraceContext.removeServerTrace();
			TraceContext.removeServerTraceTime();
			TraceContext.removeTraceId();
			TraceContext.removeNotLogging();
		}catch(Exception ex){
			logger.warn("clear trace fail !");
		}
	}
	
	public static void main(String[] args){
		System.out.println(getHostId());
		System.out.println(getIp());
	}
	
	public static String getHostId(){
	    try{
	    	return hostIp;
	    }catch(Exception e){
	        e.printStackTrace();  
	    } 
	    return null;
	}
	
	public static void setCustomer(String value) {
		TraceContextKey.CUSTOMER.set(value);
	}

	public static void removeCustomer() {
		TraceContextKey.CUSTOMER.remove();
	}
	
	public static String getCustomer() {
		return TraceContextKey.CUSTOMER.get();
	}
	
	public static void setServerTraceTime(String value) {
		value = (null==value)?DateUtils.formatCnHmDate(new Date()):value+","+DateUtils.formatCnHmDate(new Date());
		TraceContextKey.SERVERTIMETRACE.set(value);
	}

	public static void removeServerTraceTime() {
		TraceContextKey.SERVERTIMETRACE.remove();
	}
	
	public static String getServerTraceTime() {
		return TraceContextKey.SERVERTIMETRACE.get();
	}
	
	public static void setServerTrace(String value) {
		value = (null==value)?getHostId():value+","+getHostId();
		TraceContextKey.SERVERIPTRACE.set(value);
	}

	public static void removeServerTrace() {
		TraceContextKey.SERVERIPTRACE.remove();
	}
	
	public static String getServerTrace() {
		return TraceContextKey.SERVERIPTRACE.get();
	}
	
	public static String generateTraceId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static void setTraceId(String value) {
		TraceContextKey.TRACENO.set(value);
	}
	
	public static String getTraceId() {
		if(null==TraceContextKey.TRACENO.get()){
			setTraceId(generateTraceId());
		}
		return TraceContextKey.TRACENO.get();
	}
	
	public static void removeTraceId() {
		TraceContextKey.TRACENO.remove();
	}
	
	public static void setIp(String value) {
		TraceContextKey.IP.set(value);
	}
	public static String getIp() {
		return TraceContextKey.IP.get();
	}
	public static void removeIp() {
		TraceContextKey.IP.remove();
	}
	
	public static void setEquipmentNo(String equipmentNo) {
		TraceContextKey.EQUIPMENTNO.set(equipmentNo);
	}
	public static String getEquipmentNo() {
		return TraceContextKey.EQUIPMENTNO.get();
	}
	public static void removeEquipmentNo() {
		TraceContextKey.EQUIPMENTNO.remove();
	}
	
	public static void setOper(Oper value) {

		try{
			String oper = JSONMapper.getInstance().writeValueAsString(value);
			TraceContextKey.OPER.set(oper);
		}catch(Exception ex){
			logger.info("oper null or read from json error!",ex);
		}
	}
	
	public static void setOper(String value) {
		TraceContextKey.OPER.set(value);
	}
	
	
	public static Oper getOperObject() {
		try{
			String json =  TraceContextKey.OPER.get();
			if(StringUtil.isNotEmptyString(json)){
				return JSONMapper.getInstance().readValue(json,Oper.class);
			}
		}catch(Exception ex){
			logger.info("oper null or read from json error!",ex);
		}
		return null;
	}
	
	public static String getOper() {
		return TraceContextKey.OPER.get();
	}
	
	public static void removeOper() {
		TraceContextKey.OPER.remove();
	}
	
	public static String getIp(HttpServletRequest request){
		String ip  = IpUtils.getIpAddr(request);
//		logger.warn("ip:"+ip);
		return ip;
	}
	
	public static void setNotLogging(boolean value) {
		TraceContextKey.NOTLOGGING.set(String.valueOf(value));
	}
	
	public static String getNotLogging() {
		return TraceContextKey.NOTLOGGING.get();
	}

	public static void removeNotLogging() {
		TraceContextKey.NOTLOGGING.remove();
	}

}
