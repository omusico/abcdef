package com.lvmama.lvfit.online.search.controller.impl;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.comm.pet.po.user.UserUser;
import com.lvmama.lvf.common.client.VstClient;
import com.lvmama.lvf.common.dto.BaseReponseHandle;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Oper;
import com.lvmama.lvf.common.dto.request.UserMemberRequest;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.dto.vst.UserMemberDto;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvfit.online.utils.ServletUtil;

/**
 * 会员信息
 * @author zzs
 *
 */
@Controller
@RequestMapping("/loginUser")
public class SearchUserMemberControllerImpl {
	
	@Autowired
	private VstClient lvfVstClient;

	/**
	 * 进入主页
	 */
	@RequestMapping("/newLogin")
	public String toUserMember(Model model,HttpServletRequest request) {
		 Oper oper=TraceContext.getOperObject();
		 request.getSession().setAttribute("operUser", oper);
	     return "/search/login/newLogin";
	}
	
    /**
     * 查询会员列表
     */
	@RequestMapping("/queryUserMember")
	public String searchUserMemberAjax(Model model, String paramValue,HttpServletRequest servletRequest){
		try{
			Oper oper = (Oper)servletRequest.getSession().getAttribute("operUser");
			UserMemberRequest userRequest=new UserMemberRequest();
			userRequest.setParameters(paramValue);
			userRequest.setOper(oper);
			BaseResultDto<UserMemberDto> userResult= lvfVstClient.getUserProxyList(userRequest);
			List<UserMemberDto> userList=userResult.getResults();
			if(CollectionUtils.isNotEmpty(userList)){
				//让匹配的始终在第一
				for(UserMemberDto userMemberDto : userList){
					if(userMemberDto.getUserName().equals(paramValue)){
						if(userList.indexOf(userMemberDto)>0){
							userList.remove(userMemberDto);
							userList.add(0,userMemberDto);
						}
						break;
					}
				}
				
				model.addAttribute("userList", userList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userMember_list";
	}

	/**
	 * 注册会员信息
	 */
	@RequestMapping("/registUserMember")
	@ResponseBody
	public BaseReponseHandle registUserMemberAjax(Model model, String mobileNumber,HttpServletRequest servletRequest) {
		BaseReponseHandle baseReponse = new BaseReponseHandle();
		try{
		    Oper oper = (Oper)servletRequest.getSession().getAttribute("operUser");
			UserMemberRequest userRequest=new UserMemberRequest();
			userRequest.setParameters(mobileNumber);
			userRequest.setMobileNumber(mobileNumber);
			userRequest.setOper(oper);
			BaseResultDto<UserMemberDto> userResult= lvfVstClient.getUserProxyList(userRequest);
			List<UserMemberDto> userList=userResult.getResults();
			if(validationMember(userList)){
			   String userId=lvfVstClient.getRegistUserInfo(userRequest);
				if(StringUtil.isNotEmptyString(userId)){
					baseReponse.setMessage("注册成功！");
					baseReponse.setStatus(ResultStatus.SUCCESS);
				}else{
					baseReponse.setMessage("注册失败，请重新填写注册！");
					baseReponse.setStatus(ResultStatus.FAIL);
				}
			}else{
				
				baseReponse.setMessage("该手机号码已注册,请重新填写！");
				baseReponse.setStatus(ResultStatus.FAIL);
			}
		}catch(Exception e){
			baseReponse.setMessage("注册失败，请重新填写注册！");
			baseReponse.setStatus(ResultStatus.FAIL);
			e.printStackTrace();
		}
		return baseReponse;
	}
	
	  /**
     * 获取选取的会员信息
     */
	@RequestMapping("/chooseUserMember")
	@ResponseBody
	public BaseReponseHandle getChooseUserMemberAjax(Model model,HttpServletRequest request,String userName,String userId,String userNo
			,String grade,String mobileNumber) {
		BaseReponseHandle baseReponse = new BaseReponseHandle();
		UserMemberDto userMember=new UserMemberDto();
		try {
			userMember.setUserNo(userNo);
			userMember.setUserName(userName);
			userMember.setGrade(grade);
			userMember.setUserId(Long.valueOf(userId));
			userMember.setMobileNumber(mobileNumber);
			request.getSession().setAttribute("userMember", userMember);
			request.getSession().setAttribute("userMemberCode", userNo);
			request.getSession().setAttribute("userMemberName", userName);
			UserUser userUser = new UserUser();
			userUser.setUserNo(userNo);
			userUser.setId(Long.valueOf(userId));
			userUser.setUserName(userName);
			userUser.setGrade(grade);
			userUser.setMobileNumber(mobileNumber);
			ServletUtil.putSession(request, null, "SESSION_FRONT_USER", userUser);
			baseReponse.setStatus(ResultStatus.SUCCESS);
		} catch (Exception e) {
			baseReponse.setStatus(ResultStatus.FAIL);
			e.printStackTrace();
		}
		return baseReponse;
	}
	
	/**
     * 验证当前注册的会员是否已经注册过
     */
	public static boolean validationMember(List<UserMemberDto> userList){
		if(CollectionUtils.isNotEmpty(userList)){
			for (UserMemberDto userMember : userList) {
				String memberStr=userMember.getMobileNumber();
				int countStr=memberStr.indexOf("B");
				if(countStr<0){
					return false;
				}
			}
		}
		return true;
	}
}
