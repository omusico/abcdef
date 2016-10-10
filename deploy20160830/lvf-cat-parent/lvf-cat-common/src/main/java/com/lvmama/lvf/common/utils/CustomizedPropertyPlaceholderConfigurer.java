package com.lvmama.lvf.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class CustomizedPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private static Map<String, Object> ctxPropertiesMap; 
	 
    @Override 
    protected void processProperties( 
            ConfigurableListableBeanFactory beanFactoryToProcess, 
            Properties props) throws BeansException { 
        super.processProperties(beanFactoryToProcess, props); 
        ctxPropertiesMap = new HashMap<String, Object>(); 
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr); 
            ctxPropertiesMap.put(keyStr, value); 
        }
    } 
 
    public static <T> T getContextProperty(String name) {
        return (T)ctxPropertiesMap.get(name); 
    } 
    
    public void reload(){
    	try{
    		Properties result = mergeProperties();
//    		logger.error("reload properties!"+result);
    		HashMap nc =new HashMap<String, Object>();
    		nc.putAll(result);
    		ctxPropertiesMap=nc;
    	}catch(Exception ex){
    		logger.error("reload properties error!",ex);
    	}
    }
    
}
