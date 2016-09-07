package com.lvmama.lvf.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.enums.SmsKey;
import com.lvmama.lvf.common.dto.enums.SmsType;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

@Component
public class GeneratorSmsContextByFtl implements GeneratorSmsContext {
	
	@Value("ftl.templateLoaderPath")
	private String templateLoaderPath;
	
	@Value("ftl.distribution.templateLoaderPath")
	private String templateDistrLoaderPath;
	
	@Override
	public String generatorSmsContext(SmsType type,Map<String,String> values) throws Exception{
		 Configuration cfg = new Configuration();
		 String tempate = this.getTemplateLoaderPath();
		 if(values.get(SmsKey.BOOKINGSOURCE.toString())!=null && "LAMAMA_DISTRIBUTION".equals(values.get(SmsKey.BOOKINGSOURCE.toString()))){
			 tempate = this.getTemplateDistrLoaderPath();
		 }	     
	    // System.out.println(new File(tempate).getAbsolutePath());
	   /*  String path = GeneratorSmsContextByFtl.class.getClassLoader().getResource("").getPath()+tempate;*/
	     
	     cfg.setDirectoryForTemplateLoading(new File(tempate));
	     Template t = getTemplate(cfg,type.getTemplateName()+".ftl");
	     return doWirte(t,values);
	}
	
	public Template getTemplate(Configuration cfg,String name) throws IOException{
    	cfg.setDefaultEncoding("UTF-8");
    	cfg.setNumberFormat("#");
    	cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
    	return cfg.getTemplate(name);
	}
	
	public String doWirte(Template t,Map<String,String> req) throws IOException, TemplateException{
		StringWriter writer = new StringWriter();
		t.process(req,writer);
		writer.flush();
		return writer.getBuffer().toString();
	}

	public String getTemplateLoaderPath() {
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(templateLoaderPath);
	}
	
	public String getTemplateDistrLoaderPath() {
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(templateDistrLoaderPath);
	}
	
}
