package com.lvmama.lvf.common.convert.xslt;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.lvmama.lvf.common.convert.Binding;
import com.lvmama.lvf.common.convert.Converter;
import com.lvmama.lvf.common.convert.exception.ResourceNotExistException;

public class XsltConverterManager implements Converter {
	
	private static final String XSLT_PACKAGE = "xslt.package";
	
	private Map<String,String> propertys = new HashMap<String, String>();
	
	public Map<String, String> getPropertys(){
		return propertys;
	}

	public void setPropertys(Map<String, String> propertys) {
		this.propertys = propertys;
	}

	public String getProperty(String key) {
		return propertys.get(key);
	}
	
	public ConcurrentMap<String, Converter> converters = new ConcurrentHashMap<String, Converter>();

	public <S, T> XsltConverterManager registerConverter(Class<S> s, Class<T> t,String prefix)  throws Exception{
		converters.put(getConverterKey(s,t,prefix),new XsltConverter(getPackagePath()+getConverterKey(s, t,prefix)+getSuffix(),
				getBinding(String.class)));
		return this;
	}
	
	public <S, T> XsltConverterManager registerConverter(Class<S> s, String t,String prefix)  throws Exception{
		converters.put(getConverterKey(s,t,prefix),new XsltConverter(getPackagePath()+getConverterKey(s, t,prefix)+getSuffix(),
				getBinding(String.class)));
		return this;
	}

	public XsltConverterManager(){
		super();
	}
	
	public String getPackagePath(){
		String packagePath=getXsltPackagePath();
		if(!packagePath.endsWith("/")){
			return packagePath+"/";
		}
		return packagePath;
	}
	
	public String getSuffix(){
		String suffix=getXsltSuffix();
		if(!suffix.startsWith(".")){
			return "."+suffix;
		}
		return suffix;
	}
	
	public String getXsltPackagePath(){
		return getProperty(XSLT_PACKAGE);
	}
	
	public <T> Binding<T> getBinding(Class<T> t){
		return null;
	};
	
	public <S, T> String getConverterKey(Class<S> s, Class<T> t,String prefix) {
		if(null==prefix){
			prefix="";
		}
		return prefix+s.getSimpleName()+"2"+t.getSimpleName();
	}
	
	public <S, T> String getConverterKey(Class<S> s, String t,String prefix) {
		if(null==prefix){
			prefix="";
		}
		return prefix+s.getSimpleName()+"2"+t;
	}
	
	
	public String getXsltSuffix() {
		return ".xslt";
	}
	
	public <S, T> T to(S s,Class<T> t) throws Exception {
		return to(s,t,null);
	}
	
	public <S, T> T to(S s,Class<T> t,String prefix) throws Exception {
		if(t.isAssignableFrom(String.class)){
			return (T)toXml(s,String.class.getSimpleName(),prefix);
		}
		return getConverter(s,t,prefix).to(s,t);
	}
	
	public <S,T> String toXml(S s,String t) throws Exception {
		return getConverter(s,t,null).toXml(s,t);
	}

	public <S,T> String toXml(S s,String t,String prefix) throws Exception {
		return getConverter(s,t,prefix).toXml(s,t);
	}

	private <S,T> Converter getConverter(S s,Class<T> t,String prefix) throws Exception {
		Converter converter =converters.get(getConverterKey(s.getClass(),t,prefix));
		if(null==converter){
			synchronized(this){
				if(null==converters.get(getConverterKey(s.getClass(),t,prefix))){
					registerConverter(s.getClass(),t,prefix);
				}
			}
			converter =converters.get(getConverterKey(s.getClass(),t,prefix));		
		}
		if(null==converter){
			throw new ResourceNotExistException("Need register "+s.getClass().getName()+" to "+t.getName()+" Converter!");
		}
		return converter;
	}
	
	private <S,T> Converter getConverter(S s,String t,String prefix) throws Exception {
		Converter converter =converters.get(getConverterKey(s.getClass(),t,prefix));
		if(null==converter){
			synchronized(this){
				if(null==converters.get(getConverterKey(s.getClass(),t,prefix))){
					registerConverter(s.getClass(),t,prefix);
				}
			}
			converter =converters.get(getConverterKey(s.getClass(),t,prefix));		
		}
		if(null==converter){
			throw new ResourceNotExistException("Need register "+s.getClass().getName()+" to "+t+" Converter!");
		}
		return converter;
	}
	
	public boolean cleanConverter(String key) {
		if (converters != null && converters.get(key) != null) {
			converters.remove(key);
			return true;
		}
		return false;
	}

}
