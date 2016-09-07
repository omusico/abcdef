package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.ZipUnZipUtils;

/**
 * 订单快照信息
 * @author majun
 * @date   2015-1-19
 */
@XmlRootElement
public class FlightOrderSnapshotDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = -6077852059685211601L;

	/** 订单压缩JSON字符串 */
	private String zipJson;
	
	/** 订单操作日期信息 */
	private OrderOpLogDto orderOpLog;
	

	
	public FlightOrderDto convertZipJson2FlightOrder() throws Exception 
	{
		String unzipJson = ZipUnZipUtils.getInstance().unzipBase642String(this.zipJson);
		return JSONMapper.getInstance().convertValue(unzipJson,FlightOrderDto.class);
	}
	
	public void convertFlightOrder2ZipJson(FlightOrderDto flightOrder) throws Exception
	{
		String json = JSONMapper.getInstance().writeValueAsString(flightOrder);
		this.zipJson = ZipUnZipUtils.getInstance().zipString2Base64(json);
	}

	public String getZipJson() {
		return zipJson;
	}

	public void setZipJson(String zipJson) {
		this.zipJson = zipJson;
	}

	public OrderOpLogDto getOrderOpLog() {
		return orderOpLog;
	}

	public void setOrderOpLog(OrderOpLogDto orderOpLog) {
		this.orderOpLog = orderOpLog;
	}


}
