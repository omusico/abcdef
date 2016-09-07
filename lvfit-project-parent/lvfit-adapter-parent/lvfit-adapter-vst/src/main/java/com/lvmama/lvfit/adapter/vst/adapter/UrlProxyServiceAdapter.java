package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.lvfit.common.dto.order.FitPaymentUrlDto;

/**
 * 
 * ClassName: UserProxyServiceAdapter <br/>
 * date: 2015-12-9 上午11:10:36 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 */
public interface UrlProxyServiceAdapter {
	/**
	 *  获得订单审核页参数拼装
	 * @author wanghuihui
	 * @date:2015年12月25日 下午4:50:31
	 * @param VstPaymentUrl 订单对象
	 * @return
	 */
	String getPaymentUrl(FitPaymentUrlDto fitPaymentUrlDto);

}
