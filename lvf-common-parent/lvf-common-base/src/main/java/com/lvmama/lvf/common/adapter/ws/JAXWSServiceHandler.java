package com.lvmama.lvf.common.adapter.ws;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.Service;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.adapter.InputType;
import com.lvmama.lvf.common.adapter.LoggerHandler;
import com.lvmama.lvf.common.adapter.LoggerMessage;
import com.lvmama.lvf.common.adapter.Operation;
import com.lvmama.lvf.common.adapter.OutputType;
import com.lvmama.lvf.common.adapter.Prefix;
import com.lvmama.lvf.common.convert.Converter;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.utils.JaxbUtils;

public class JAXWSServiceHandler implements ServiceHandler {

	private Service client = null;
	private Method portMethod = null;
	private Method operationMethod = null;
	private Converter convert = null;
	private LoggerHandler loggerHandler = null;
	private String port = "Port";

    private final Logger log= LoggerFactory.getLogger(this.getClass());

	public JAXWSServiceHandler(Service client, Converter convert,final LoggerHandler logger) {
		super();
		this.client = client;
		this.convert = convert;
		this.loggerHandler=logger;
	}
	
	public JAXWSServiceHandler(Service client, Converter convert,final LoggerHandler logger,String port) {
		super();
		this.client = client;
		this.convert = convert;
		this.loggerHandler=logger;
		this.port = port;
	}
	
	
	private void log(Object message, String target,String gid) {
		try {
			
			String errMessage = StringUtils.EMPTY;
			Boolean result = Boolean.TRUE;
			if(null==this.loggerHandler){
				return;
			}
			if(null==message){
				loggerHandler.log(target , client.getServiceName().getLocalPart(), message + "", errMessage, result, gid);
				return;
			}
			if (message instanceof LoggerMessage){
				LoggerMessage loggerMessage = (LoggerMessage) message;
				errMessage = loggerMessage.getMessage();
				result = loggerMessage.getResult();
			}
			XmlRootElement annotation = message.getClass().getAnnotation(XmlRootElement.class);
			if (annotation != null) {
				message = JaxbUtils.convertToXmlString(message);
			}
			
			loggerHandler.log(target, client.getServiceName().getLocalPart(), message + "", errMessage, result, gid);
		} catch (Exception ex) {
			log.warn(ex.getMessage(), ex);
		}
	}
	
	public Object execute(Method method, Object[] args) throws Exception {
		try {
			Object port = getPortMethod().invoke(client, null);
			Object result = invoke(method, args, port);
			return convert(method, result);
		} catch (Exception e) {
			log.error("JAXWSServiceHandler execute : ",e);
			throw e;
		}
	}

	private Object convert(Method method, Object object) throws Exception {
		Class returnType = method.getReturnType();
		OutputType outType = method.getAnnotation(OutputType.class);
		if (null == object || null == outType
				|| returnType.equals(outType.value())) {
			return object;
		}
		if (!"".equals(outType.method())) {
			object = changeObject(outType,object);
		}
		
		return to(method, object, returnType);
	}

	private Object to(Method method, Object object, Class returnType)
			throws Exception {
		Prefix prefix = method.getAnnotation(Prefix.class);
		if(null==prefix){
			return convert.to(object,returnType);
		}
		return convert.to(object,returnType,prefix.value());
	}
	private Object changeObject(OutputType outputType,Object object) throws Exception{
		if(object.getClass() == ArrayList.class){
			Class outClass = outputType.value();
			 String method_property = outputType.method();
			 Object outInstance = outClass.newInstance();
			 Method setResult = outClass.getMethod(method_property, ArrayList.class);
			 setResult.invoke(outInstance, object);
			 object = outInstance;
			
		}
		 if (log.isDebugEnabled()) {
			 log.debug(JaxbUtils.convertToXmlString(object));
		 }
		return object;
	}

	private Object invoke(Method method, Object[] args, Object port)
			throws Exception {
		
		Object[] inputs =null;
		Object result = null;
		
		InputType inputType = method.getAnnotation(InputType.class);
		
		if (null == inputType) {
			inputs =args;
		} else {
			inputs = new Object[] {to(method,args[0], inputType.value()) };
			if(!StringUtils.isEmpty(inputType.method())) {
				Method getMethod = inputs[0].getClass().getMethod(inputType.method(), null);
				Object pValue = getMethod.invoke(inputs[0], null);
				inputs = new Object[] {pValue};
			}
		}

        //用于标示是同一组请求响应报文
        String gid= UUID.randomUUID().toString();
		
		for(Object input:inputs){
			log(input,RequestResponse.RE.toString(),gid);
		}
		
		try{
			result=getOperationMethod(method, args, port).invoke(port,inputs);
		}catch(NoSuchMethodException exception){
			result = invokeMethodByName(method, port, inputs);
		}catch(IllegalArgumentException  exception){
			result = invokeMethodByName(method, port, inputs);
		}
		log(result,RequestResponse.RS.toString(),gid);
		return result;
	}

	private Object invokeMethodByName(Method method, Object port,
			Object[] inputs) {
		Object result;
		try{
			result=invokeByName(getOperationMethodByName(method,port),port,inputs);
		}catch(Exception ex){
			ex.printStackTrace();
			result=ExceptionUtils.getFullStackTrace(ex);
		}
		return result;
	}
	
	private Object invokeByName(Method method,Object target,Object[] inputs) throws Exception{
		
		Method portMethod = getPortMethod();
		Method interfaceMethod = null;
		for(Method targetMethod:portMethod.getReturnType().getMethods()){
			if(method.getName().toUpperCase().equals(targetMethod.getName().toUpperCase())){
				interfaceMethod = targetMethod;
			}
		}
		
		if(null==interfaceMethod){
			return null;
		}
		
		List list = new ArrayList();
		Object input = inputs[0];
		Class inputCls = input.getClass();
		Annotation[][] annotationss = interfaceMethod.getParameterAnnotations();
		for(Annotation[] annotations:annotationss){
			for(Annotation annotation:annotations){
				WebParam wp = (WebParam)annotation;
				String name = wp.name();
				list.add(inputCls.getDeclaredMethod("get"+name.substring(0,1).toUpperCase()+name.substring(1,name.length())).invoke(input));
			}
		}
		Object[] args = list.toArray();
		return method.invoke(target,args);
	}
	
	private Method getPortMethod() throws NoSuchMethodException {
		if (null == portMethod) {
			synchronized (this) {
				String portMethodName;
				try {
					portMethodName = "get" + client.getClass().getSimpleName().substring(0, client.getClass().getSimpleName().length() - 7) + this.port;
					portMethod = client.getClass().getDeclaredMethod(portMethodName, null);
				} catch (Exception e) {
					portMethodName = "get" + client.getClass().getSimpleName() + this.port;
					portMethod = client.getClass().getDeclaredMethod(portMethodName, null);
				}
			}
		}
		return portMethod;
	}

	private Method getOperationMethod(Method method, Object[] args, Object port)
			throws NoSuchMethodException, Exception {
		if (null == operationMethod) {
			synchronized (this) {
				if (null == operationMethod) {
					Operation operation = method.getAnnotation(Operation.class);
					InputType inputType = method.getAnnotation(InputType.class);
					if (null == inputType) {
						operationMethod = port.getClass().getDeclaredMethod(
								operation.value(), method.getParameterTypes());
					} else {
						Object[] inargs = new Object[] {to(method,args[0], inputType.value()) };
						Class<?> type = inargs[0].getClass();
						if(!StringUtils.isEmpty(inputType.method())) {
							Method getMethod = inargs[0].getClass().getMethod(inputType.method(), null);
							type = getMethod.getReturnType();
						}
						port.getClass().getDeclaredMethods();
						operationMethod = port.getClass().getDeclaredMethod(operation.value(), new Class[] { type });
					}
				}
			}
		}
		return operationMethod;
	}
	
	private Method getOperationMethodByName(Method method,Object port)
		throws NoSuchMethodException, Exception {
		if (null == operationMethod) {
			synchronized (this) {
				if (null == operationMethod) {
					Operation operation = method.getAnnotation(Operation.class);
					InputType inputType = method.getAnnotation(InputType.class);
					if (null == inputType) {
						operationMethod = port.getClass().getDeclaredMethod(
								operation.value(), method.getParameterTypes());
					} else {
						Method[] methods =  port.getClass().getDeclaredMethods();
						operation = method.getAnnotation(Operation.class);
						for(Method targetMethod:methods){
							if(operation.value().toUpperCase().equals(targetMethod.getName().toUpperCase())){
								operationMethod = targetMethod;
								return operationMethod;
							}
						}
					}
				}
			}
		}
		return operationMethod;
	}

}
