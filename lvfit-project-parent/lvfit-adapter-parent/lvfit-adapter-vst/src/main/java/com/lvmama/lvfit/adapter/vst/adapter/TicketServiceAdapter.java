package com.lvmama.lvfit.adapter.vst.adapter;

import java.util.List;

import com.lvmama.lvfit.common.dto.price.FitTicketAddTimePriceDto;
import com.lvmama.lvfit.common.dto.request.FitTicketDetailRequest;
import com.lvmama.lvfit.common.dto.request.FitTicketPriceRequest;
import com.lvmama.lvfit.common.dto.ticket.FitTicketGoodsDetailDto;



/**
 * 
 * ClassName: TicketServiceAdapter <br/>
 * date: 2016-02-01 上午14:53:36 <br/>
 * 
 * @author yueyufan
 * @version
 * @since JDK 1.6
 */
public interface TicketServiceAdapter {

	
	
	
	/**
	 *  调用主站门票时间价格表接口
	 * @author yueyufan
	 * @date:2016年02月01日 下午4:50:31
	 * @param 门票查询对象
	 * @return
	 */
	
	public List<FitTicketAddTimePriceDto> findGoodsAddTimePrice(FitTicketPriceRequest ticketPriceRequest);
	
	
	/**
	 *  调用主站和详情接口
	 * @author yueyufan
	 * @date:2016年02月01日 下午4:50:31
	 * @param 门票查询对象
	 * @return
	 */
	
	public FitTicketGoodsDetailDto findGoodsDetail(FitTicketDetailRequest ticketDetailRequest);
	
}
