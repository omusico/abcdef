/**
 * 
 */
package com.lvmama.lvf.common.form.order.result.detail;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailViewDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 订单详情视图表单（总页面）
 * 
 * @author lven
 * @date 2015-2-5
 * 
 */
public class FlightOrderDetailViewForm implements Serializable, Form 
{
	private static final long serialVersionUID = 8030504453518254061L;

	private FlightOrderDetailBaseForm flightOrderDetailBaseForm = new FlightOrderDetailBaseForm();

	private FlightOrderDetailInfoForm flightOrderDetailInfoForm = new FlightOrderDetailInfoForm();

	private FlightOrderDetailRelationForm flightOrderDetailRelationForm = new FlightOrderDetailRelationForm();
	
	public FlightOrderDetailViewForm() {}
	
	/**
	 * 根据订单详情视图对象构造Form
	 * @param flightOrderDetailViewDto	订单详情视图对象
	 */
	public FlightOrderDetailViewForm(FlightOrderDetailViewDto flightOrderDetailViewDto)
	{
		//1、构造订单明细基本信息Form
		FlightOrderDetailBaseForm flightOrderDetailBaseForm = this.getFlightOrderDetailBaseForm();
		flightOrderDetailBaseForm.setFlightOrderDetailBase(flightOrderDetailViewDto.getFlightOrderDetailBase());
		
		//2、构造订单关联订单、同主单订单信息Form
		FlightOrderDetailRelationForm flightOrderDetailRelationForm = this.getFlightOrderDetailRelationForm();
		flightOrderDetailRelationForm.setFlightOrderDetailRelations(flightOrderDetailViewDto.getFlightOrderDetailRelations());
		flightOrderDetailRelationForm.setSameOrderDetailRelations(flightOrderDetailViewDto.getSameOrderDetailRelations());
		
		//3、构造订单详情明细信息Form
		FlightOrderDetailInfoForm flightOrderDetailInfoForm = this.getFlightOrderDetailInfoForm();
		flightOrderDetailInfoForm.setFlightOrderDetailInfoDto(flightOrderDetailViewDto.getFlightOrderDetailInfo());
	}
	
	public FlightOrderDetailBaseForm getFlightOrderDetailBaseForm() {
		return flightOrderDetailBaseForm;
	}

	public void setFlightOrderDetailBaseForm(
			FlightOrderDetailBaseForm flightOrderDetailBaseForm) {
		this.flightOrderDetailBaseForm = flightOrderDetailBaseForm;
	}

	public FlightOrderDetailInfoForm getFlightOrderDetailInfoForm() {
		return flightOrderDetailInfoForm;
	}

	public void setFlightOrderDetailInfoForm(
			FlightOrderDetailInfoForm flightOrderDetailInfoForm) {
		this.flightOrderDetailInfoForm = flightOrderDetailInfoForm;
	}

	public FlightOrderDetailRelationForm getFlightOrderDetailRelationForm() {
		return flightOrderDetailRelationForm;
	}

	public void setFlightOrderDetailRelationForm(
			FlightOrderDetailRelationForm flightOrderDetailRelationForm) {
		this.flightOrderDetailRelationForm = flightOrderDetailRelationForm;
	}

}
