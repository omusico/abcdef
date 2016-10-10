package com.lvmama.cat.controller;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("")
public class MaillController {
	
	@RequestMapping(value="/sendMail",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String sendMail(HttpServletRequest request){
          try {
        	  Map<String,String[]> parameterMap = request.getParameterMap();
        	  String[] toUsers = parameterMap.get("to");
        	  if (ArrayUtils.isEmpty(toUsers) || StringUtils.isEmpty(toUsers[0]))return "200";
        	  String[] titleContent = parameterMap.get("value");
        	  String[] server = parameterMap.get("server");
        	  String[] passwd = parameterMap.get("passwd");
        	  String[] users = parameterMap.get("user");
        	  String[] fromUser = parameterMap.get("re");
        	  String[] links = parameterMap.get("link");
              Email email = new SimpleEmail();
              email.setHostName(server[0]);
              email.setCharset("UTF-8");
//              email.setSmtpPort(465);
              email.setAuthenticator(new DefaultAuthenticator(users[0], passwd[0]));
              email.setSSLOnConnect(true);
              email.setFrom(fromUser[0]);
              email.setSubject(titleContent[0].substring(0,titleContent[0].indexOf(",")));
//              email.setMsg(titleContent[0]+"");
              String replace = StringUtils.replace(titleContent[0], "cat.dianpingoa.com", links[0]);
              email.setMsg(replace);
              email.addTo(toUsers[0]);
              email.send();
          } catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}  
		return "200";
	}
	
}
