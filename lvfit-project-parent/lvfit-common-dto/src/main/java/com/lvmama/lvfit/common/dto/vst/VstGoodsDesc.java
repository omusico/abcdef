package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;

public class VstGoodsDesc implements Serializable{

	//商品ID
	private Long goodsId;
	//商品描述ID
	private String descId;
	//费用包含
	private String priceIncludes;
	//取票时间
	private String changeTime;
	//取票地点
	private String changeAddress;
	//入园方式
	private String enterStyle;
	//是否限制入园
	private String limitFlag;
	//入园限制时间
	private String limitTime;
	//身高
	private String height;
	//年龄
	private String age;
	//地域
	private String region;
	//最大限购
	private String maxQuantity;
	//快递
	private String express;
	//实体票
	private String entityTicket;
	//其他
	private String others;
	//门票退改ID
	private String refundId;
	//退改类型
	private String cancelStrategy;
	//最晚无损取消时间
	private String latestCancelTime;
	//扣款类型（金额/百分比）
	private String deductType;
	//扣款数值
	private String deductValue;

	//商品有效期ID
	private String expId;
	//游玩日有效开始时间（期票）
	private String startTime;
	//游玩日有效结束时间（期票）
	private String endTime;
	//不适用日期
	private String unvalid;
	//有效天数（非期票）
	private String days;
	//是否过期
	private String aperiodicFlag;
	
}
