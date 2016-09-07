package com.lvmama.lvfit.sonline.booking;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.member.FitMemUserDto;
import com.lvmama.lvfit.common.dto.member.FitUserContacterDto;

public interface ToBookingController <I extends Form, R extends BaseResponseDto<? extends Form>> {
	
	/**
	 * 跳转到订单填写页
	 * @param model
	 * @param request
	 * @param shopingUUID
	 * @return
	 */
	public String toBooking(Model model, HttpServletRequest request);
	
	/**
	 * 查询常用联系人
	 * @param request
	 * @return
	 */
	List<FitUserContacterDto> getVstPassengers(HttpServletRequest request);
	
	/**
	 * 查询当前用户
	 * @param request
	 * @return
	 */
	FitMemUserDto getUserByLvSessionId(HttpServletRequest request);

	/**
	 * 获取合同信息
	 * @param request
	 * @return
	 */
	Map<String,BaseSingleResultDto<String>> getContractsHtml(HttpServletRequest request);
}
