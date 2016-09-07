package com.lvmama.lvfit.offline.web.controller.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;


@Controller
@RequestMapping("/")
public class DemoController {
	
	@Value("offline.index.enabled")
	private String offlineIndexEnabled;
	
	@Autowired
	private RestClient restClient;

	@RequestMapping(method=RequestMethod.GET,value={"/index"})
	public String index(Model model,HttpServletRequest request, HttpServletResponse response) {
	    //PermUser user = (PermUser)ServletUtil.getSession(request, response, Constant.SESSION_BACK_USER);
	    //logger.debug(user.getUserName());
	    /*User user = new User();
		PermUser userParm = permUserservice.getPermUserByUserName("admin");
		user.setUser_Id(String.valueOf(userParm.getUserId()));
		user.setUser_Name(userParm.getUserName());
	    user.setPassword(userParm.getPassword());
		model.addAttribute("users", user);*/
		
		if(this.isOfflineIndexEnabled()){
			return "/offline_index";
		}
		return "/un_index";
	}

	public boolean isOfflineIndexEnabled() {
		boolean isOfflineIndexEnabled = Boolean.valueOf(CustomizedPropertyPlaceholderConfigurer.getContextProperty(offlineIndexEnabled) + "");
		return isOfflineIndexEnabled;
	}
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<FitFliBookingCallBackRequest> backRequests = new ArrayList<FitFliBookingCallBackRequest>();
		
		FitFliBookingCallBackRequest backRequest1 = new FitFliBookingCallBackRequest();
		backRequest1.setVstOrderMainNo(20039691l);
		backRequest1.setVstOrderNo(2000052681l);
		FitFliBookingCallBackRequest backRequest2 = new FitFliBookingCallBackRequest();
		backRequest2.setVstOrderMainNo(20039691l);
		backRequest2.setVstOrderNo(2000052682l);
		backRequests.add(backRequest1);
		backRequests.add(backRequest2);
		System.out.println(JSONMapper.getInstance().writeValueAsString(backRequests));
	}
	
}
