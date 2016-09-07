package com.lvmama.lvfit.business.order.service;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryListDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.request.FitFlightOrderQueryRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;
import com.lvmama.lvfit.common.form.order.FitOrderOpLogForm;

import java.util.List;

/**
 * 订单查询列表
 * @author qihuisong
 */
public interface OrderQueryService {
    /**
	 *  后台 订单查询列表内容
	 * @author wanghuihui
	 * @date:2016年1月5日 下午10:30:04
	 * @param FitOrderQueryRequest
	 * @return
	 */
	List<FitOrderQueryListDto> queryOrderList(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 *  后台 订单查询列表 数量
	 * @author wanghuihui
	 * @date:2016年1月5日 下午10:53:57
	 * @param baseQueryDto
	 * @return
	 */
	int countOrderListRecords(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 * 根据主键获取机酒主订单信息
	 * @param id
	 * @return
	 */
	FitOrderMainDto queryOrderMainByVstOrderMainNo(Long vstOrderMainNo);
	
	/**
	 * 根据主键获取主订单中的机票部门信息，供补单用途. 
	 * @return
	 */
	List<String> queryFlightOrderByVstOrderMainNo(FitFlightOrderQueryRequest request);
	
	/**
	 * 后台订单 操作日志列表
	 * @author wanghuihui
	 * @date:2016年1月18日 下午3:41:08
	 * @param fitOrderQueryRequest
	 * @return
	 */
	List<FitOrderOpLogForm> queryOrderLogList(
			FitOrderQueryRequest fitOrderQueryRequest);
	/**
	 *  后台订单 操作日志列表 数量
	 * @author wanghuihui
	 * @date:2016年1月18日 下午4:21:09
	 * @param baseQueryDto
	 * @return
	 */
	int countOrderLogListRecords(FitOrderQueryRequest fitOrderQueryRequest);
	/**
	 *  根据条件查询机酒订单列表
	 * @author wanghuihui
	 * @date:2016年1月22日 下午1:58:01
	 * @param baseQueryDto
	 * @return
	 */
	List<String> queryOrderAllReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 *  根据条件查询机票订单列表
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:47:02
	 * @param baseQueryDto
	 * @return
	 */
	List<String> queryOrderFlightReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 *  根据条件查询酒店订单列表
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:47:26
	 * @param baseQueryDto
	 * @return
	 */
	List<String> queryOrderHotelReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	
	/**
	 * 根据VST主单号取得VST订单信息
	 * @param vstOrderMainNo
	 * @return
	 */
	FitOrderDetail getMainOrder4VSTByOrderMainNo(Long vstOrderMainNo);
	
	public List<FitSuppMainOrderDto> getOldOrderMainData();
}
