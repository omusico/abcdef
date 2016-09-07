package com.lvmama.lvf.common.adapter.ws;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceClient;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.adapter.LoggerHandler;
import com.lvmama.lvf.common.adapter.Path;
import com.lvmama.lvf.common.convert.Converter;

public class JAXWSServiceFactory extends AbstractServiceHandlerFactory {

	private Converter converter;

	private LoggerHandler logger;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public Converter getConverter() {
		return converter;
	}

	public void setConverter(Converter converter) {
		this.converter = converter;
	}

	public LoggerHandler getLogger() {
		return logger;
	}

	public void setLogger(LoggerHandler logger) {
		this.logger = logger;
	}

	public static final String WSNAMESPACE = "ws.namespace";
	public static final String WSURL = "ws.url";
	public static final String WSPORT = "ws.port";
	
	public void registerService(Method method) throws Exception {
		Path path = method.getDeclaringClass().getAnnotation(Path.class);
		String wsdl = path.wsdl();
		if(	log.isDebugEnabled()){
			log.debug("JAXB Web Service Path:",path.wsdl());
		}
		if (StringUtils.isBlank(path.wsdl()) && StringUtils.isNotBlank(path.path())) {
			wsdl = path.path() + "?wsdl";
		}
		putHandler(getHandlerKey(method), newHandler(wsdl, path));
	}
	
	public ServiceHandler newHandler(String wsdl, Path path) throws Exception {
		try {
			Class<?> client = path.service();
			URL url = new URL(wsdl.replace("${" + WSURL + "}", getProperty(WSURL)));
			String namespace = path.namespace();
			if(StringUtils.isBlank(namespace)){
				namespace=getTargetNamespace(client);
			}
			if(StringUtils.isBlank(namespace)){
				namespace = getProperty(WSNAMESPACE);
			}
			QName qname = new QName(namespace, getQName(client));
			Service service = (Service) client.getConstructor(URL.class, QName.class).newInstance(url, qname);
			
			String port = getProperty(WSPORT);
			if(null==port){
				return new JAXWSServiceHandler(service, getConverter(), logger);
			}else{
				return new JAXWSServiceHandler(service, getConverter(), logger,port);
			}
		} catch (Exception ex) {
			log.error("JAXWSServiceFactory newHandler :" + ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	private String getQName(Class client){
		WebServiceClient service = (WebServiceClient) client.getAnnotation(WebServiceClient.class);
		return service.name();
	}
	
	private String getTargetNamespace(Class client){
		WebServiceClient service = (WebServiceClient) client.getAnnotation(WebServiceClient.class);
		return service.targetNamespace();
	}
	

	private Map<String, String> propertys = new HashMap<String, String>();

	public Map<String, String> getPropertys() {
		return propertys;
	}

	public void setPropertys(Map<String, String> propertys) {
		this.propertys = propertys;
	}

	public String getProperty(String key) {
		return propertys.get(key);
	}

}
