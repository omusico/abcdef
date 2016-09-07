/**
 * Project Name:lvfit-adapter-vst
 * File Name:UserProxyServiceAdapterImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter.impl
 * Date:2015-12-9上午11:14:16
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.adapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.adapter.vst.adapter.OrderQueryServiceAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.UrlProxyServiceAdapter;
import com.lvmama.lvfit.adapter.vst.handle.VSTLoggerHandler;
import com.lvmama.lvfit.common.dto.order.FitPaymentUrlDto;
import com.lvmama.vst.back.goods.po.SuppGoodsTimePrice;
import com.lvmama.vst.back.order.po.OrdOrder;
import com.lvmama.vst.back.order.po.OrdPerson;
import com.lvmama.vst.back.order.po.OrderEnum;
import com.lvmama.vst.comm.vo.Constant;
import com.lvmama.vst.comm.vo.PaymentUrl;

/**
 * ClassName:UserProxyServiceAdapterImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-9 上午11:14:16 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class UrlProxyServiceAdapterImpl implements UrlProxyServiceAdapter {
	
	@Autowired
	private VSTLoggerHandler logger;
	@Autowired
	private OrderQueryServiceAdapter orderQueryServiceAdapter;
	
	
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public String getPaymentUrl(FitPaymentUrlDto fitPaymentUrlDto) {
		OrdOrder order = orderQueryServiceAdapter.queryVstOrderByVstOrderMainNo(fitPaymentUrlDto.getOrderId());
		this.hideMobile(order);
		//是否预授权支付
		boolean hasNeedPrePay=false;
		 //支付类型(正常支付/预授权).
		String paymentType=OrderEnum.PAYMENT_TYPE.PAY.name();
		//是否是预授权 否则正常付款
		 if("PRE".equals(fitPaymentUrlDto.getPreOrNormal())){
			 hasNeedPrePay=SuppGoodsTimePrice.BOOKLIMITTYPE.PREAUTH.name().equals(order.getPaymentType());
			 paymentType=OrderEnum.PAYMENT_TYPE.PRE_PAY.name();
		 }
		 Long categoryId = 0L;
		 Long productId = 0L;
		 String orderName="";
		 if(null!=order.getOrdOrderPack()){
			 orderName=order.getOrdOrderPack().getProductName();
			 categoryId = order.getOrdOrderPack().getCategoryId();
			 productId = order.getOrdOrderPack().getProductId();
		 }else{
			 orderName=order.getMainOrderItem().getProductName()+"、"+order.getMainOrderItem().getSuppGoodsName();
			 
			 categoryId = order.getMainOrderItem().getCategoryId();
			 productId = order.getMainOrderItem().getProductId();
		 }
		 
		 String categoryCode = "";
		 if(categoryId != null){
			 categoryCode = Constant.VST_CATEGORY.getCodeByCategoryId(categoryId + "");
		 }
		PaymentUrl url=new PaymentUrl(order.getOrderId(),order.getOughtAmount(),fitPaymentUrlDto.getOrderName(),
				order.getOughtAmount()-order.getActualAmount(),
				OrderEnum.PAYMENT_OBJECT_TYPE.ORD_ORDER.name(),
				paymentType,
				fitPaymentUrlDto.getWaitPayment(), fitPaymentUrlDto.getApproveTime(), fitPaymentUrlDto.getVisitTime(),
				OrderEnum.PAYMENT_BIZ_TYPE.VST_ORDER.name(), 
				null, fitPaymentUrlDto.isCanInstalment(), 
				null, null,fitPaymentUrlDto.isHasNeedPrePay(),fitPaymentUrlDto.isPrepayAble(),
				order.getPromPaymentChannel(), fitPaymentUrlDto.isCanBoundLipinkaPay(),
				fitPaymentUrlDto.isShowInsurant(), categoryCode, null, fitPaymentUrlDto.getInstalmentFlag());
		/*PaymentUrl url = new PaymentUrl(fitPaymentUrlDto.getOrderId(),fitPaymentUrlDto.getOrderAmountFen(), fitPaymentUrlDto.getOrderName(), fitPaymentUrlDto.getPayAmountFen(), fitPaymentUrlDto.getObjectType(), fitPaymentUrlDto.getPaymentType(), 
				fitPaymentUrlDto.getWaitPayment(), fitPaymentUrlDto.getApproveTime(), fitPaymentUrlDto.getVisitTime(), fitPaymentUrlDto.getBizType(), fitPaymentUrlDto.getRoyaltyParameters(), fitPaymentUrlDto.isCanInstalment(), 
				fitPaymentUrlDto.getInstalmentGateway(), fitPaymentUrlDto.getInstalmentInfoMap(), fitPaymentUrlDto.isHasNeedPrePay(), fitPaymentUrlDto.isPrepayAble(), fitPaymentUrlDto.getPaymentChannel(), 
				fitPaymentUrlDto.isCanBoundLipinkaPay(), fitPaymentUrlDto.isShowInsurant(), fitPaymentUrlDto.getCategoryCode(), fitPaymentUrlDto.getSuppProductId(), fitPaymentUrlDto.getInstalmentFlag());*/
		 if("PRE".equals(fitPaymentUrlDto.getPreOrNormal())){
			 return url.getPrePaymentUrl("");
		 }else{
			 return url.getPaymentUrl("");
		 }
		 
	}

	private void hideMobile(OrdOrder order){
		OrdPerson person=order.getContactPerson();
		if(null==person||null==person.getMobile()||person.getMobile().length()<7)return;
		String mobileMiddle=person.getMobile().substring(3, 7);
		order.getContactPerson().setMobile(person.getMobile().replace(mobileMiddle, "****"));
	}
	
}
