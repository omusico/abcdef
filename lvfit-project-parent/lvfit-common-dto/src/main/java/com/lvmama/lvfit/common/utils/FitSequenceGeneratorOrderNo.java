package com.lvmama.lvfit.common.utils;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.OrderType;
import com.lvmama.lvfit.common.dto.enums.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FitSequenceGeneratorOrderNo implements FitGeneratorOrderNo {

	@Autowired(required=false)
    DataSource dataSource;
	
	JdbcTemplate template;


	private enum OrderNumberType {
		FITORDNO,PAYORDNO,INSORDNO,SETTLEORDNO;
	}
	
	public String generateFitOrderNo(BookingSource source,Product product,OrderType orderType){
		return generateOrderNumber(OrderNumberType.FITORDNO,product.getCode(),orderType.getTypeCode());
	}
	
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


}
