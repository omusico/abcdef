package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.utils.JSONMapper;


/**
 * 推送信息
 * @author xiexun
 *
 */
public class FitSdpComPushDto extends Entity implements Serializable {

	private static final long serialVersionUID = 6074900887312653907L;

	/**
	    * ID
	    */
	   private Long id;
	   
	   /**
	    * 数据对象ID
	    */
	   private Long objectId;
	   
	   /**
	    * 数据类型（目前只有 ORDER订单|PRODUCT产品|DISTRICT行政区划）
	    */
	   private String objectType;
	   
	   /**
	    * 创建时间
	    */
	   private Date createTime;
	   
	   /**
	    * 推送标识 Y：已推送 
	    */
	   private String pushFlag;
	   
	   /**
	    * 推送次数
	    */
	   private Long pushCount;
	   
	   /**
	    * 推送内容（INFO信息|STATUS状态）
	    */
	   private String pushContent;
	   
	   /**
	    * 数据来源
	    */
	   private String dataType;
	   
	   /**
	    * 内容操作类型
	    */
	   private String operateType;
	   
	   /**
	    * 内容操作类型
	    * 2014年9月3日
	    * @version
	    */
	   public static enum OPERATE_TYPE {
		   /**
		    * 新增
		    */
		   ADD,
		   /**
		    * 删除
		    */
		   DEL,
		   /**
		    * 更新
		    */
		   UP,
		   /**
		    * 有效
		    */
		   VALID,
		   /**
		    * 无效
		    */
		   INVALID,
		   /**
		    * 可售
		    */
		   SALE,
		   /**
		    * 不可售
		    */
		   NOSALE;
		   
		   public static OPERATE_TYPE getType(String name) {
				if(name == null) {
					return null;
				}
				for(OPERATE_TYPE t : OPERATE_TYPE.values()) {
					if(t.name().equals(name)) {
						return t;
					}
				}
				return null;
			}
	   }

        /**
         * 期票有效期变更内容类型
         * 2015年11月3日
         * @version
         */
        public static enum APERIODIC_TYPE {

            NON(""),
            S("startTime"),
            E("endTime"),
            SE("startTime,endTime"),
            U("unvalid"),
            SU("startTime,unvalid"),
            EU("endTime,unvalid"),
            SEU("startTime,endTime,unvalid");

            private String name;
            private int id;

            APERIODIC_TYPE(String name){
                this.name = name;
            }

            public String getName() {
                return this.name;
            }
        }

	   /**
	    * 数据类型枚举
	    * @author xiexun
	    *
	    */
	   public static enum OBJECT_TYPE {
		   /**
		    * 订单
		    */
		   ORDER(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR}),
		   /**
		    * 通关
		    */
		   PASSPORT(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR}),
		   /**
		    * 产品
		    */
		   PRODUCT(new DATA_TYPE[]{DATA_TYPE.VST,DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT}),
		   /**
		    * 产品规格
		    */
		   PRODUCTBRANCH(new DATA_TYPE[]{DATA_TYPE.VST,DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT}),
		   /**
		    * 商品
		    */
		   GOODS(new DATA_TYPE[]{DATA_TYPE.VST,DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT}),
           /**
            * 期票商品
            */
           SUPP_GOODS(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR}),
		   /**
		    * 演出票
		    */
		   PERFORMANCE_TICKET(new DATA_TYPE[]{DATA_TYPE.VST,DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT}),
		   
		   /**
		    * 行政区划	   
		    */
		   DISTRICT(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT, DATA_TYPE.PHP}),
		   /**
		    * 目的地
		    */
		   DEST(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT, DATA_TYPE.PHP}),
		   /**
		    * 地理位置
		    */
		   DISTRICTSIGN(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT, DATA_TYPE.PHP}),
		   /**
		    * 主题
		    */
		   SUBJECT(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT, DATA_TYPE.PHP}),
		   
		   /**
		   	 * 标签
		   	 */
		   TAG(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT, DATA_TYPE.PHP}),
		   /**
		    * 字典
		    */
		   DICT(new DATA_TYPE[]{DATA_TYPE.DISTRIBUTOR,DATA_TYPE.SEARCHINCREMENT, DATA_TYPE.PHP}),
		   
		   /**
		    * 促销
		    */
		   PROMOTION(new DATA_TYPE[]{DATA_TYPE.SEARCHINCREMENT}),
		  /**
		   * 返现
		   */
		   REBATE(new DATA_TYPE[]{DATA_TYPE.SEARCHINCREMENT,DATA_TYPE.VST}),
		   /**
			 * 分销用的搜索对象
			 */
			SEARCH_DISTRIBUTOR(new DATA_TYPE[]{DATA_TYPE.SEARCHINCREMENT}),
		   

		   /**
		    * 买赠活动
		    * */
		   BUY_PRESENTER(new DATA_TYPE[]{DATA_TYPE.SEARCHINCREMENT});
			
		   private DATA_TYPE[] typeList;
			
			public DATA_TYPE[] getTypeList() {
				if(this.typeList == null) {
					return DATA_TYPE.values();
				}
				return this.typeList;
			}
			public static OBJECT_TYPE getType(String name) {
				if(name == null) {
					return null;
				}
				for(OBJECT_TYPE t : OBJECT_TYPE.values()) {
					if(t.name().equals(name)) {
						return t;
					}
				}
				return null;
			}
			OBJECT_TYPE(DATA_TYPE[] typeList){
				this.typeList = typeList;
			}
			OBJECT_TYPE(){
				
			}
		}
	   
	   /**
	    * 推送内容枚举
	    * @author xiexun
	    *
	    */
	   public static enum PUSH_CONTENT {
		/** 产品 */
		PROD_PRODUCT,
		/** 产品打包 */
		PROD_PACKAGE_GROUP,
		/** 邮轮打包 */
		PROD_COMB_OPTION,
		/** 产品交通 */
		PROD_TRAFFIC,
		/** 产品规格 */
		PROD_PRODUCT_BRANCH,
		/**
		 * 产品ADDTIONAL/产品附加信息表
		 */
		PROD_PRODUCT_ADDTIONAL,
		
		/**
		 * 产品附加表的多出发地版本
		 */
		PROD_STARTDISTRICT_ADDTIONAL,
		
		/**
		 * 产品团期表
		 */
		PROD_GROUP_DATE,		
		
		/**
		 * 产品统一退改规则
		 */
		PROD_REFUND,
		/**
		 * 产品关键字（酒店和产品属性，用于搜索）/产品与业务字典关系表
		 */
		PROD_PRODUCT_ATTR,
		
		/** 图片 *///图片表（景区、酒店等）
		COM_PHOTO,
		/** 游玩景点 */
		PROD_VIEW_SPOT,
		/** 景点活动 */
		PROD_ACTIVITY,
		/** 景点特色 *///产品特色
		PROD_FEATURE,
		/** 产品目的地关联表 */
		PROD_DEST_RE,
		/** 目的地 */
		BIZ_DEST,
		/** 产品主题关联表 */
		PROD_SUBJECT,
		/** 主题 */
		BIZ_SUBJECT,
		/** 标签关联表 */
		PROD_TAG,
		/** 标签 */
		BIZ_TAG,
		/** 产品渠道 */
		DIST_DISTRIBUTOR_PROD,
		/** 商品渠道 */
		DIST_DISTRIBUTOR_GOODS,
		/** 商品 */
		SUPP_GOODS,
		/** 行政区 */
		BIZ_DISTRICT,
		/** 行政区 */
		BIZ_DISTRICT_SIGN,
		/** 行程 */
		PROD_LINE_ROUTE,
		/** 行程明细 */
		PROD_LINE_ROUTE_DETAIL,
		/** 产品属性 */
		PROD_PRODUCT_PROP,
		/** 业务字典 */
		BIZ_DICT,
		/** 商品附加信息 */
		SUPP_GOODS_ADDITION,
		/** 商品促销关联表 */
		PROM_GOODS,
		/** 促销 */
		PROM_PROMOTION,
		/** 商品返现 */
		SUPP_GOODS_REBATE,
		/** 目的地内容 */
		BIZ_DEST_CONTENT,
		/** 目的地时间 */
		BIZ_DEST_SALE_TIME,
		/** 目的地交通 */
		BIZ_DEST_TRANS,
		/** 广告位 */
		BIZ_PROD_AD,
		/**第二出发地*/
		BIZ_DEST_AROUND,
		BIZ_DISTRICT_AROUND,
		/**
		 * 时间价格表
		 */
		SUPP_GOODS_TIME_PRICE,
		/**
		 * 演出票场次
		 */
		SUPP_GOODS_PERFORMANCE_TIMES,
		/**
		 * 演出票库存
		 */
		SUPP_GOODS_PERFORMANCE_STOCK,
		/**
		 * 搜索对象-分销产品
		 */
		VST_SEARCH_PROD_DISTRIBUTOR,
		/**
		 * 搜索对象-分销商品
		 */
		VST_SEARCH_GOODS_DISTRIBUTOR,
		/**
		 * 通关-通关码使用状态表
		 */
		INTF_PASS_PORT_CODE,
		/**
		 * 通关-通关码主表
		 */
		INTF_PASS_CODE,

		/**
		 * 状态
		 */
		STATUS,
		/**
		 * 行程设计
		 */
		LINE_ROUTE,
		/**
		 * 航线设计
		 */
		LINE_SHIP_DETAIL,
		/**
		 * 合同条款
		 */
		PROD_CONTRACT_DETAIL,

		   /**
			  * 买赠活动-赠品
			  * */  
			PROM_PRESENT_PRESENTER,  
		 /**
		  * 买赠活动-活动
		  * */  
		PROM_PRESENT_ACTIVITY,
		 /**
		  * 买赠活动-券码
		  * */  

		PROM_PRESENT_COUPON,
       /**有效期修改*/
       VALIDITY_DATE_CHANGE,

		/**
		  * 商品打包到规格表
		  * */ 
		PROD_PACKAGE_DETAIL_GOODS;
		
			public static PUSH_CONTENT getType(String name) {
				if(name == null) {
					return null;
				}
				for(PUSH_CONTENT t : PUSH_CONTENT.values()) {
					if(t.name().equals(name)) {
						return t;
					}
				}
				return null;
			}
		}
	   
	   public static enum DATA_TYPE {

			DISTRIBUTOR("分销商"),SEARCHINCREMENT("搜索增量"),PHP("PHP内容系统"),VST("Vst系统");

			private String cnName;

			public static String getCnName(String code) {
				for (DATA_TYPE item : DATA_TYPE.values()) {
					if (item.getCode().equals(code)) {
						return item.getCnName();
					}
				}
				return code;
			}
			public static DATA_TYPE getType(String name) {
				if(name == null) {
					return null;
				}
				for(DATA_TYPE t : DATA_TYPE.values()) {
					if(t.name().equals(name)) {
						return t;
					}
				}
				return null;
			}
			DATA_TYPE(String name) {
				this.cnName = name;
			}

			public String getCode() {
				return this.name();
			}

			public String getCnName() {
				return this.cnName;
			}

			@Override
			public String toString() {
				return this.name();
			}
		}

	   /**
	    * 操作时间间隔设置
	    *
	    */
	public static enum TIME_INTERVAL {
		MINUTES_1(1L);

		private long minutes;

		TIME_INTERVAL(long minutes) {
			this.minutes = minutes;
		}
		
		public static long getCnName(String code) {
			for (TIME_INTERVAL item : TIME_INTERVAL.values()) {
				if (item.getCode().equals(code)) {
					return item.minutes;
				}
			}
			return 0L;
		}

		public String getCode() {
			return this.name();
		}

		@Override
		public String toString() {
			return this.name();
		}
	}
	   
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getPushFlag() {
		return pushFlag;
	}

	public void setPushFlag(String pushFlag) {
		this.pushFlag = pushFlag;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Long getPushCount() {
		return pushCount;
	}

	public void setPushCount(Long pushCount) {
		this.pushCount = pushCount;
	}

	public String getPushContent() {
		return pushContent;
	}

	public void setPushContent(String pushContent) {
		this.pushContent = pushContent;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
    	FitSdpComPushDto comPush = new FitSdpComPushDto();
		comPush.setObjectId(380185L);
		comPush.setObjectType("GOODS");
		comPush.setCreateTime(new Date());
		comPush.setPushFlag("");
		comPush.setPushCount((long)0);
		
		//PUSH_CONTENT传入'LINE_ROUTE', 'LINE_SHIP_DETAIL','PROD_CONTRACT_DETAIL', 'PROD_GROUP_DATE', 'PROD_PACKAGE_GROUP', 'PROD_PRODUCT_ATTR','PROD_REFUND', 'PROD_STARTDISTRICT_ADDTIONAL', 'PROD_TRAFFIC', 'SUPP_GOODS_REBATE', 'SUPP_GOODS_TIME_PRICE'
		comPush.setPushContent("T_FITSDP_PRODUCT_SEARCH_INDEX");
		
		comPush.setDataType("SEARCHINCREMENT");    //必须传SEARCHINCREMENT
		comPush.setOperateType("ADD");   //可以传入 ADD DEL  U
    	System.out.println(JSONMapper.getInstance().writeValueAsString(comPush));
	}
	
}
