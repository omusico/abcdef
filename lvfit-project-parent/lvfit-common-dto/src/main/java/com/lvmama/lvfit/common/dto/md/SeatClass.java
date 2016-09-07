package com.lvmama.lvfit.common.dto.md;

import com.lvmama.lvf.common.dto.NameCode;
import com.lvmama.lvfit.common.dto.enums.SeatClassType;

/**
 * 舱位信息
 * @author majun
 * @date   2015-1-22
 */
public class SeatClass extends NameCode  
{
	private static final long serialVersionUID = 2839273631730858300L;
	
	/**舱位类型*/
	private SeatClassType seatClassType;
	
	/**承运人机场code*/
	private String carrierCode;
	
}
