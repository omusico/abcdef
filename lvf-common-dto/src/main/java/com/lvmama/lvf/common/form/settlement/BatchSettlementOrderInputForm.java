package com.lvmama.lvf.common.form.settlement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.form.Form;

/**
 * 根据订单批量生成结算单
 * @author hedandan
 *
 */
public class BatchSettlementOrderInputForm implements Serializable,Form{

	private static final long serialVersionUID = -8382512438144937889L;

	private List<Long> orderIds = new ArrayList<Long>();

	public List<Long> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<Long> orderIds) {
		this.orderIds = orderIds;
	}
	
}
