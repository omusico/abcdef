package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Map;


/**
 * 生成优惠券+绑定优惠券请求：对接人：王重倍
 * @author lujingzhong
 *
 */
public class CreatBindCouponRequest implements Serializable{

	private static final long serialVersionUID = 7571833863920906356L;

	/**map key(Long)为优惠券的批次号,value(Integer)为对应要生成的优惠券的数量*/
	private Map<Long, Integer> couponIdAndGenerateNum;
	
	/**用户短id：userid*/
	private String userid;

	public Map<Long, Integer> getCouponIdAndGenerateNum() {
		return couponIdAndGenerateNum;
	}

	public void setCouponIdAndGenerateNum(Map<Long, Integer> couponIdAndGenerateNum) {
		this.couponIdAndGenerateNum = couponIdAndGenerateNum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	
	
	

}
