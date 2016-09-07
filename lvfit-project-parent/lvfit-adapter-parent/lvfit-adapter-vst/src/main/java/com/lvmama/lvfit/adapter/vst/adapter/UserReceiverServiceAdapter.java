package com.lvmama.lvfit.adapter.vst.adapter;

import java.util.List;

import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvfit.common.dto.member.FitUserContacterDto;
import com.lvmama.lvfit.common.dto.request.FitOrderPassengerRequest;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;

/**
 * 常用联系人接口 ClassName: UserReceiverServiceAdapter <br/>
 * date: 2015-12-10 上午10:54:04 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 */
public interface UserReceiverServiceAdapter {

	/**
	 * 根据用户id查找常用乘客信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<FitUserContacterDto> getUserReceiverByUserId(MemUserRequest request);

	/**
	 * 添加 修改常用乘客信息
	 * 
	 * @param userId
	 * @return
	 */
	public ResultStatus saveOrderPassengerInfo(FitOrderPassengerRequest passengerRequst);
}
