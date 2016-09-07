package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.member.FitMemUserDto;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;

/**
 * 
 * ClassName: UserProxyServiceAdapter <br/>
 * date: 2015-12-9 上午11:10:36 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 */
public interface UserProxyServiceAdapter {

	/**
	 * 
	 * getMemberByLvSessionId:通过lvSessionId获得会员信息. <br/>
	 * 
	 * @author liuweiguo
	 * @param lvSessionId
	 * @return
	 * @since JDK 1.6
	 */
	public BaseSingleResultDto<FitMemUserDto> getUserByLvSessionId(MemUserRequest request);

}
