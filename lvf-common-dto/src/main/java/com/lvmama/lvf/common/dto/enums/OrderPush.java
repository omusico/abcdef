package com.lvmama.lvf.common.dto.enums;

/**
 * H5订单推送
 *
 */
public class OrderPush {
	public static enum ORDER_STATUS {
	NORMAL("正常"),
	CANCEL("取消"),
	FINISHED("完成");
	
	private String cnName;
	ORDER_STATUS(String name){
		this.cnName=name;
	}
	public String getCode(){
		return this.name();
	}
	public String getCnName(){
		return this.cnName;
	}
	public static String getCnName(String code){
		for(ORDER_STATUS item:ORDER_STATUS.values()){
			if(item.getCode().equals(code))
			{
				return item.getCnName();
			}
		}
		return code;
	}
	public String toString(){
		return this.name();
	}
}

	/**
	 * 
	 * 显示订单状态
	 *
	 */
	public static enum VIEW_ORDER_STATUS {
		CANCEL("取消"),
		UNPAY("待支付"),
		PAYED("已支付"),
		FINISHED("完成");
	
		
		private String cnName;
		VIEW_ORDER_STATUS(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(VIEW_ORDER_STATUS item:VIEW_ORDER_STATUS.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
	/**
	 * 
	 * 支付状态PAYMENT_QUERY_STATUS 
	 *
	 */
	public static enum PAYMENT_STATUS {
		UNPAY("未支付"),
		PAYED("支付完成");
		
		private String cnName;
		PAYMENT_STATUS(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(PAYMENT_STATUS item:PAYMENT_STATUS.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}

	/**
	 * 
	 * 退款状态REFUNDMENT_STATUS
	 *
	 */
	public static enum REFUND_STATUS {
		REFUNDED("已退款"),
		PROCESSING("退款中");
		
		private String cnName;
		REFUND_STATUS(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(REFUND_STATUS item:REFUND_STATUS.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
	
	
	public static enum SYNC_TYPE {
		CANCEL("订单同步【取消】"),
		DELETE("订单同步【删除】"),
		TOPAY("订单同步【待支付】"),
		TOREFUND("订单同步【待退款】"),
		TOTRAVEL("订单同步【待出行】");
		
		private String cnName;
		SYNC_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(SYNC_TYPE item:SYNC_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
}

