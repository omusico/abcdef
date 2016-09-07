/**
 * 
 */
package com.lvmama.lvf.common.form.order.result.detail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.order.result.detail.relation.FlightOrderDetailRelationDto;
import com.lvmama.lvf.common.form.Form;

/**
 *  订单详情关联表单
 * @author lven
 * @date 2015-2-5
 * 
 */
public class FlightOrderDetailRelationForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1986499631258029527L;


	/** 同主单订单列表 */
	private List<FlightOrderDetailRelationDto> sameOrderDetailRelations = new ArrayList<FlightOrderDetailRelationDto>();
	

	/** 关联订单列表 */
	private List<FlightOrderDetailRelationDto> flightOrderDetailRelations = new ArrayList<FlightOrderDetailRelationDto>();

	
	public List<FlightOrderDetailRelationDto> getSameOrderDetailRelations() {
		return sameOrderDetailRelations;
	}

	public void setSameOrderDetailRelations(
			List<FlightOrderDetailRelationDto> sameOrderDetailRelations) {
		this.sameOrderDetailRelations = sameOrderDetailRelations;
	}

	public List<FlightOrderDetailRelationDto> getFlightOrderDetailRelations() {
		return flightOrderDetailRelations;
	}

	public void setFlightOrderDetailRelations(
			List<FlightOrderDetailRelationDto> flightOrderDetailRelations) {
		this.flightOrderDetailRelations = flightOrderDetailRelations;
	}
	
}
