package com.lvmama.lvfit.common.dto.enums;

import java.io.Serializable;

/**
 * 品类相关的所有枚举
 * 
 * @author lancey
 *
 */
public class BizEnum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1955815250276020316L;

	public static enum BIZ_CATEGORY_TYPE {
		category_hotel(1L,"酒店"),
		category_sightseeing(9L,"岸上观光"),
		category_comb_cruise(8L,"邮轮组合产品"),
		category_visa(4L,"签证"),
		category_insurance(3L,"保险"),
		category_cruise(2L,"邮轮"),
		category_addition(7L,"附加项目"),
		category_cruise_addition(10L,"邮轮附加项"),
		
		//线路产品
		category_route(14L,"线路"),
		category_route_group(15L,"跟团游"),
		category_route_freedom(18L,"自由行"),
		category_route_local(16L,"当地游"),
		category_route_hotelcomb(17L,"酒店套餐"),
		category_route_aero_hotel(29L,"交通+X"),
		
		//门票产品
		category_ticket(5L,"门票"),
		category_single_ticket(11L,"景点门票"),
		category_other_ticket(12L,"其它票"),
		category_comb_ticket(13L,"组合套餐票"),
		
		
		category_other(90L,"其他"),
		
		//大交通
		category_traffic(19L,"大交通"),
		category_traffic_aeroplane(20L,"机票"),
		category_traffic_aero_other(21L,"其它机票"),
		category_traffic_train(22L,"火车票"),
		category_traffic_train_other(23L,"其它火车票"),
		category_traffic_bus(24L,"巴士"),
		category_traffic_bus_other(25L,"其它巴士"),
		category_traffic_ship(26L,"船票"),
		category_traffic_ship_other(27L,"其它船票"),
		;
		
		private Long categoryId;
		private String cnName;
		
		BIZ_CATEGORY_TYPE(Long categoryId,String name){
			this.categoryId = categoryId;
			this.cnName=name;
		}
		
		public String getCode(){
			return this.name();
		}
		public Long getCategoryId() {
			return this.categoryId;
		}
		public String getCnName(){
			return this.cnName;
		}
		
		public static String getCnName(Long categoryId){
			for(BIZ_CATEGORY_TYPE item:BIZ_CATEGORY_TYPE.values()){
				if(item.getCategoryId().equals(categoryId))
				{
					return item.getCnName();
				}
			}
			return categoryId+"";
		}
		
		public static String getCnName(String code){
			for(BIZ_CATEGORY_TYPE item:BIZ_CATEGORY_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		
		@Override
		public String toString(){
			return this.name();
		}
	}
	
	public static enum PRODUCT_PRICE_UNIT {
		UNIT_VEHICLES("辆"),
		UNIT_PERSON("人"),
		UNIT_PORTION("份");
		
		private String cnName;
		
		PRODUCT_PRICE_UNIT(String name){
			this.cnName=name;
		}
		
		public String getCode(){
			return this.name();
		}
		
		public String getCnName(){
			return this.cnName;
		}
		
		public static String getCnName(String code){
			for(PRODUCT_PRICE_UNIT item : PRODUCT_PRICE_UNIT.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		
		@Override
		public String toString(){
			return this.name();
		}
	}
	
	public static enum BIZ_CATEGORY_PROP_CODE {
		//组合邮轮
		the_fee_includes("费用包含"),
		cost_free("费用不含"),
		shopping_help("购物说明"),
		change_and_cancellation_instructions("退款说明"),
		attention("预订须知"),
		important("行前须知"),
		play_tips("游玩提示"),
		travel_service_guarantee("旅游服务保障"),
		recommended_items("推荐项目"),
		an_airline("所属航线"),
		are_charter("是否包船"),
		earnest("定金"),
		
		//岸上观光、邮轮附加项
		pricing_type("计价方式");
		
		private String cnName;
		
		BIZ_CATEGORY_PROP_CODE(String name){
			this.cnName=name;
		}
		
		public String getCode(){
			return this.name();
		}
		
		public String getCnName(){
			return this.cnName;
		}
		
		public static String getCnName(String code){
			for(BIZ_CATEGORY_PROP_CODE item : BIZ_CATEGORY_PROP_CODE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		
		@Override
		public String toString(){
			return this.name();
		}
	}
	
	public static enum LINE_PROP_CODE {
		cost_free("费用不包含"),
		the_fee_includes("费用包含"),
		change_and_cancellation_instructions("退改说明"),
		important("行前须知"),
		warning("出行警示及说明");
		
		private String cnName;
		
		LINE_PROP_CODE(String name){
			this.cnName=name;
		}
		
		public String getCode(){
			return this.name();
		}
		
		public String getCnName(){
			return this.cnName;
		}
		
		public static String getCnName(String code){
			for(LINE_PROP_CODE item : LINE_PROP_CODE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		
		@Override
		public String toString(){
			return this.name();
		}
	}
	
	
	 /**
	  * 酒店设施列表
	  */
    public static enum HOTEL_FACILITIES 
    {
    	FREE_WIFI(460L,"免费wifi","hotel_icon_wifi1"),
	    PAY_WIFI(461L,"收费wifi","hotel_icon_wifi2"),
	    FREE_INTERNET(462L,"免费宽带","hotel_icon_pc1"),
	    PAY_INTERNET(463L,"收费宽带","hotel_icon_pc2"),
	    FREE_PARK(464L,"免费停车场","hotel_icon_p1"),
	    PAY_PARK(465L,"收费停车场","hotel_icon_p2"),
	    FREE_PICKUP(466L,"免费接机服务","hotel_icon_jie1"),
	    PAY_PICKUP(467L,"收费接机服务","hotel_icon_jie2"),
	    INDOOR_SWIMMING_POOL(468L,"室内游泳池","hotel_icon_snyyc1"),
	    OUTDOOR_SWIMMING_POOL(469L,"室外游泳池","hotel_icon_swyyc1"),
	    GYM(470L,"健身房","hotel_icon_jsf1"),
	    BUSINESS_CENTER(471L,"商务中心","hotel_icon_swzx1"),
	    CONFERENCE_ROOM(472L,"会议室","hotel_icon_hys1"),
	    DINING_ROOM(473L,"酒店餐厅","hotel_icon_ct1");

		private Long id;
		private String cnName;
		private String css;
		
		HOTEL_FACILITIES(Long id,String name,String css){
			this.id=id;
			this.cnName=name;
			this.css = css;
		}
		
		public String getCode(){
			return this.name();
		}
		
		public String getCnName(){
			return this.cnName;
		}
		
		public String getCss()
        {
            return css;
        }

        public Long getId() {
			return this.id;
		}
		
		@Override
		public String toString(){
			return this.name();
		}
		
		public static final HOTEL_FACILITIES getFacilitiesById(long id)
		{
		    for (HOTEL_FACILITIES type : HOTEL_FACILITIES.values())
            {
                if(id == type.getId())
                {
                    return type;
                }
            }
		    return null;
		}
	}

}


