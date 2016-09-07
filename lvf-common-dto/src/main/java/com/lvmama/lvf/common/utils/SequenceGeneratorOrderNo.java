package com.lvmama.lvf.common.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.Product;

@Component
public class SequenceGeneratorOrderNo implements GeneratorOrderNo {

	@Autowired(required=false)
    DataSource dataSource;
	
	JdbcTemplate template;
	
	
	private enum OrderNumberType {
		FLIORDNO,PAYORDNO,INSORDNO,SETTLEORDNO;
	}
	
	public String generateFlightOrderNo(BookingSource source,Product product,OrderType orderType){
		return generateOrderNumber(OrderNumberType.FLIORDNO,product.getCode(),orderType.getTypeCode());
	}
	
	public String generatePaymentOrderNo(BookingSource source){
		return generatePaymentNumber(OrderNumberType.PAYORDNO);
	}
	
	public String generateRefundOrderNo(BookingSource source,OrderType orderType){
		return generateOrderNumber(OrderNumberType.PAYORDNO,Product.REFUND.getCode(),orderType.getTypeCode());
	}
	
	public String generateNo(BookingSource source,Product productType,OrderType orderType){
		return generateOrderNumber(OrderNumberType.FLIORDNO,productType.getCode(),orderType.getTypeCode());
	}
	
	@Override
	public String generateInsuranceOrderNo(BookingSource source) {
		return generateOrderNumber(OrderNumberType.INSORDNO,Product.INSURANCE.getCode(),OrderType.NORMAL.getTypeCode());
	}

	
	public String generateFlightSuppOrderNo(String flightOrderNo,int index){
		String indexStr=index<10?"0"+index:""+index;
		return flightOrderNo+indexStr;
	};
	
	private String generateOrderNumber(OrderNumberType type,String pre,String mid) {
		return formatOrderNubmer(getMaxNumber(type, 1) ,pre,mid);
	}

	private Long getMaxNumber(OrderNumberType type, Integer minValue) {
		String sequenceName = this.getSequenceName(type);
		String sql = "select "+ sequenceName +".nextval from dual";
		template = new JdbcTemplate(dataSource);
		Long maxNumber = null;
        try {
            maxNumber = template.queryForLong(sql);
        } catch (Exception e) {
        	try{
        		this.createSequence(sequenceName, minValue);
        		maxNumber = template.queryForLong(sql);
        	}catch (Exception ex){
        		maxNumber = template.queryForLong(sql);
        	}
        }
		return maxNumber;
	}

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
	private String formatOrderNubmer(Long maxNumber ,String pre,String mid) {
		SimpleDateFormat sd = new SimpleDateFormat("yyMMdd");
		DecimalFormat df = new DecimalFormat("000000");
		String orderNumber =pre+Long.parseLong(sd.format(new Date()))+mid+df.format(maxNumber);
		return orderNumber.toUpperCase();
	}

	private String getSequenceName(OrderNumberType type) {
		SimpleDateFormat sd = new SimpleDateFormat("yyMMdd");
		return "S_"+type.name()+"_"+sd.format(new Date());
	}

    private void createSequence(String sequenceName, Integer minValue) {
	    String sql = "create sequence "+ sequenceName+" increment by 1 start with "+ minValue;
	    template.update(sql);
	}

	@Override
	public String generateSettlementOrderNo(BookingSource source) {
		return generateSettlementNumber(OrderNumberType.SETTLEORDNO,Product.SETTLEMENT.getCode(),OrderType.NORMAL.getTypeCode());
	}
	
	
	
	private String generateSettlementNumber(OrderNumberType type,String pre,String mid) {
//		return formatSettlementOrderNubmer(getMaxNumber(type, 1) ,pre,mid);
		return formatOrderNubmer(getMaxNumber(type, 1) ,pre,mid);
	}
	
	
	private String generatePaymentNumber(OrderNumberType type) {
		return formatPaymentNubmer(getMaxNumber(type, 1));
	}
	
	
	
	/**
	 * 生成12位订单支付单号
	 * 格式如下
	 * 
	 * 年月日 yyMMdd
	 * 订单号序列6位
	 * @param maxNumber
	 * @param pre
	 * @param mid
	 * @return
	 */
	private String formatPaymentNubmer(Long maxNumber) {
		SimpleDateFormat sd = new SimpleDateFormat("yyMMdd");
		DecimalFormat df = new DecimalFormat("000000");
		String orderNumber =Long.parseLong(sd.format(new Date()))+df.format(maxNumber);
		return orderNumber.toUpperCase();
	}
	
	
	
	/**
	 * 生成11位结算单号
	 * 格式如下
	 * 
	 * 产品2位
	 * 年月日 yy
	 * 出退改1位
	 * 订单号序列6位
	 * @param maxNumber
	 * @param pre
	 * @param mid
	 * @return
	 */
	private String formatSettlementOrderNubmer(Long maxNumber ,String pre,String mid) {
		SimpleDateFormat sd = new SimpleDateFormat("yy");
		DecimalFormat df = new DecimalFormat("000000");
		String orderNumber =pre+Long.parseLong(sd.format(new Date()))+mid+df.format(maxNumber);
		return orderNumber.toUpperCase();
	}
	
}
