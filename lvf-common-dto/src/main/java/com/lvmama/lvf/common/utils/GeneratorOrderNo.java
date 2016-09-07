package com.lvmama.lvf.common.utils;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.Product;




public interface GeneratorOrderNo {

	/**
	 * 产品2位
	 * 年月日 yyMMdd
	 * 出退改1位
	 * 订单号序列6位
	 * @param maxNumber
	 * @param pre
	 * @param mid
	 * @return
	 */
	String generateFlightOrderNo(BookingSource source,Product product,OrderType orderType);
	
	String generateFlightSuppOrderNo(String flightOrderNo,int index);
	
	/**
	 * 产品2位
	 * 年月日 yyMMdd
	 * 出退改1位
	 * 订单号序列6位
	 * @param maxNumber
	 * @param pre
	 * @param mid
	 * @return
	 */
	String generatePaymentOrderNo(BookingSource source);
	
	/**
	 * 产品2位
	 * 年月日 yyMMdd
	 * 出退改1位
	 * 订单号序列6位
	 * @param maxNumber
	 * @param pre
	 * @param mid
	 * @return
	 */
	String generateRefundOrderNo(BookingSource source,OrderType orderType);

	/**
	 * 产品2位
	 * 年月日 yyMMdd
	 * 出退改1位
	 * 订单号序列6位
	 * @param maxNumber
	 * @param pre
	 * @param mid
	 * @return
	 */
	String generateInsuranceOrderNo(BookingSource source);
	
	
	
	/**
	 * 生成结算单号16位(对应结算系统的子订单OrderID)
	 * 格式如下
	 * 年月日 yyMMdd
	 * 出退改1位
	 * 订单号序列6位
	 * @param maxNumber
	 * @param pre
	 * @param mid
	 * @return
	 */
	String generateSettlementOrderNo(BookingSource source);
	
	
}
