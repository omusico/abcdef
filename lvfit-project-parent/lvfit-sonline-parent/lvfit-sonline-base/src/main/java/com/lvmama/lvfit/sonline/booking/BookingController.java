package com.lvmama.lvfit.sonline.booking;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;

public interface BookingController <I extends Form, R extends BaseResponseDto<? extends Form>>{

	/**
	 * showBooking:加载预定页. <br/>
	 * 数据格式校验
	 * 传入shoppingUUID+联系人和乘客信息，组装下单报文到DP的booking服务
	 */
	public Map<String, Object> booking(Model model,HttpServletRequest request, HttpServletResponse response, I i);
}
