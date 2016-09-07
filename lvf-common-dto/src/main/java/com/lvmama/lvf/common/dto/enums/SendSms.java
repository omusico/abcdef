package com.lvmama.lvf.common.dto.enums;
/**   
 * @Title: SendSms  
 * @Package com.lvmama.lvf.common.dto.enums
 * @Description: 火车票发送短信模板
 * @author  zhangzongshuang 
 * @date 2016年2月22日 下午4:55:14
 * @version V1.0   
 */
public enum SendSms {
	UNPAYMSG("1", "您的火车票订单(订单号：%s %s-%s %s 发车时间:%s %s %s%s张)尚未支付，请尽快完成订单支付。【客户端机票全新上线，全场底价促销中】"), //剩余支付时间15分钟
	PAY_SUCC("2", "您的火车票订单(订单号：%s %s-%s %s 发车时间:%s %s %s%s张)已支付成功，我们会尽快处理订单,出票成功后会将座位号及取票号发出,请您耐心等待。【客户端机票全新上线，全场底价促销中】"), // 支付成功
	DRAW_SUCC("3", "出票成功！(订单号：%s %s-%s %s 发车时间:%s %s %s 乘车人:%s)请于发车前凭自取票号(%s)及有效证件前往火车站或代售点换取纸质车票.未取票且距发车时间大于3小时可在线申请退票。【更多长滩岛自由行年度馈赠价￥1999起，戳 http://t.cn/RyfloVE 预定】"), // 出票成功
	DRAW_FAIL("4", "对不起，您的火车票订单(订单号：%s %s-%s %s 发车时间:%s %s %s%s张) 出票失败(%s)，我们会尽快将票款退回您的原支付渠道，请您留意短信通知。"), // 出票失败
	DRAW_FAIL_WITHOUT_REASON("4", "对不起，您的火车票订单(订单号：%s %s-%s %s 发车时间:%s %s %s%s张) 出票失败,我们会尽快将票款退回您的原支付渠道，请您留意短信通知。"), // 出票失败,但没有出票原因
	REFUND_TICK_SUCC("5", "您的火车票订单(发车时间:%s %s 车次：%s %s 乘车人:%s %s)退票成功，我们会尽快将票款退回您的原支付渠道。"), // 退票成功
	REFUND_TICK_FAIL("6", "您的火车票订单(发车时间:%s %s 车次：%s %s 乘车人:%s %s 退票失败,%s)，请您前往火车票退票窗口办理退票。"), // 退票失败
	REFUND_MON_SUCC("7", "您的火车票订单(发车时间:%s %s 车次：%s %s 乘车人:%s)退款成功，票款将按原支付渠道退回，请您注意查收。"), // 退款成功
	REFUND_TICK_SUCC_FEE_ZERO("8", "铁路局规定退票手续费最少收取2元，因此，您的火车票订单(发车时间:%s %s 车次：%s %s 乘车人:%s %s)退款为0元。"), // 退款
	REFUND_SPREADS_SUCC("9", "您的火车票订单(发车时间:%s %s 车次：%s %s 乘车人:%s)根据实际票价退还差价成功，该笔差价票款将按原支付渠道退回，请您注意查收。"); // 差额退款成功

	public final String code;
	public final String content;
	SendSms(String code, String content) {
		this.code = code;
		this.content = content;
	}
}
