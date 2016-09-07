package com.lvmama.lvf.common.utils;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PropertyReloader {

	@Resource(name="propertyConfigurer")
	private CustomizedPropertyPlaceholderConfigurer customizedPropertyPlaceholderConfigurer;
	
	@Scheduled(initialDelay = 5 * 60 * 1000,fixedDelay = 5 * 60 * 1000)
    public void reload(){
		customizedPropertyPlaceholderConfigurer.reload();
	}

	
}
