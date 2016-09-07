package com.lvmama.lvfit.online.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;

/**
 * 异常处理基类
 * @author majun
 * @date   2015-4-20
 */
public class BaseExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);
	
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) 
	{
			
		if(logger.isErrorEnabled())
			logger.error(e.getMessage(), e);
		//1、组装异常信息
		BaseResponseDto<String> baseResponseDto = new BaseResponseDto<String>();
		baseResponseDto.setStatus(ResultStatus.FAIL);
		if(e instanceof ExceptionWrapper)
		{
			ExceptionWrapper exceptionWrapper = (ExceptionWrapper) e;
			if(exceptionWrapper.getExceptionCode().getCode().equals(ExceptionCode.REMOTE_INVOKE.getCode()) 
			  || exceptionWrapper.getExceptionCode().getCode().equals(ExceptionCode.UNDEF_REMOTE_INVOKE.getCode())){
				exceptionWrapper = new ExceptionWrapper(ExceptionCode.UNDEF_ERROR);
			}
			baseResponseDto.setErrCode(exceptionWrapper.getExceptionCode().getCode());
			baseResponseDto.setMessage(exceptionWrapper.getErrMessage());
		}
		else
		{
			baseResponseDto.setErrCode(ExceptionCode.UNDEF_ERROR.getCode());
			baseResponseDto.setMessage(ExceptionCode.UNDEF_ERROR.getMessageFmt());
		}
		
		//2、根据是否是Ajax请求进行处理
		if(this.isAjaxRequest(request))
		{
			PrintWriter out = null;
			try
			{
				out = response.getWriter();
				ObjectMapper objectMapper = new ObjectMapper();
				String json = objectMapper.writeValueAsString(baseResponseDto);
				out.print(json);
				return null;
			}
			catch(IOException ioException)
			{
				return null;
			}
		}
		return new ModelAndView("error");	
	}
	
	/**
	 * 判断是否是Ajax请求
	 * @param request
	 * @return
	 */
	private boolean isAjaxRequest(HttpServletRequest request)
	{
		String header = request.getHeader("x-requested-with");
		if(header != null && header.equalsIgnoreCase("XMLHttpRequest"))
		{
			return true;
		}
		return false;
	}
}
