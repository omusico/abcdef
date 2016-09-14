package com.lvmama.lvfit.online.freemarker;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.request.CommHeaderRequest;
import com.lvmama.lvfit.online.utils.ServletUtil;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 通过流的方式获取SuperCommHeader字符串
 * 
 * @author sunjian
 *
 */
public class SuperCommonHeaderMethod implements TemplateMethodModel {
	@Autowired
	private FitVstClient  fitVstClient; 
	

	@Override
	public Object exec(List arg) throws TemplateModelException {
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		if(null!=ServletUtil.getSession(request, null, "isBackBooking")){
	        String isBackBooking = ServletUtil.getSession(request, null, "isBackBooking").toString();
			if(Boolean.valueOf(isBackBooking).booleanValue()){
				return StringUtils.EMPTY;
			}
		}
		
		CommHeaderRequest commHeaderRequest = new CommHeaderRequest();
          if(arg.size() > 4) {
        	  Object type = arg.get(0);
              Object isNew = arg.get(1);
              Object provinceId = arg.get(2);
              Object cityId = arg.get(3);
              Object stationName = arg.get(4);
              Object pageType = arg.get(5);
              commHeaderRequest.setType(String.valueOf(type));
              commHeaderRequest.setIsNew(Boolean.valueOf(String.valueOf(isNew)));
              commHeaderRequest.setProvinceId(String.valueOf(provinceId));
              commHeaderRequest.setCityId(String.valueOf(cityId));
              commHeaderRequest.setStationName(String.valueOf(stationName));
              commHeaderRequest.setPageType(String.valueOf(pageType));
          }else if(arg.size() > 1){
        	  Object type = arg.get(0);
              Object isNew = arg.get(1);
              commHeaderRequest.setType(String.valueOf(type));
              commHeaderRequest.setIsNew(Boolean.valueOf(String.valueOf(isNew)));
          }
	        String commHeader = "";//fitVstClient.getCommHeader(commHeaderRequest);
	        SimpleScalar stringMode = new SimpleScalar(commHeader);
			return stringMode;
	}
	
}
