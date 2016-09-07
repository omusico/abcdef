package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum BussinessClientPath {

	AUTO_START_GET_SEAT_CLASS_CODE(Path.AUTO_START_GET_SEAT_CLASS_CODE,"自动查找seatclasscode"),
	GET_ORDER_BY_ORDER_ID(Path.GET_ORDER_BY_ORDER_ID, "根据订单Id查订单详情"),
	DELETE_ORDER_BY_ORDER_ID(Path.DELETE_ORDER_BY_ORDER_ID, "根据订单Id删除订单"),
	DELETE_VST_ORDER_BY_ORDER_ID(Path.DELETE_VST_ORDER_BY_ORDER_ID, "根据订单Id删除vst订单"),
	SYNC_NOT_VISIBLE_ORDER(Path.SYNC_NOT_VISIBLE_ORDER, "同步删除订单至vst"),
	GET_NOTISSUE_ORDER(Path.GET_NOTISSUE_ORDER, "获取支付15分钟未出票订单"),
	GET_ORDER_BY_ORDER_NO(Path.GET_ORDER_BY_ORDER_NO, "根据订单No查订单详情"),
	GET_ORDERS_BY_QUERY_DTO(Path.GET_ORDERS_BY_QUERY_DTO,"根据查询条件查询订单列表"),
	QUERY_SUPP_ORDER_LIST(Path.QUERY_SUPP_ORDER_LIST,"查询供应商订单列表信息"),
	QUERY_SUPP_ORDER_DETAIL(Path.QUERY_SUPP_ORDER_DETAIL,"查询航班供应商订单详情"),
	CANCEL_ORDER(Path.CANCEL_ORDER, "取消订单"),
	EDIT_ORDER_LIMITTIME(Path.EDIT_ORDER_LIMITTIME, "修改limittime"),
	
	ORDER_TICKET_CTMT_APPLY(Path.ORDER_TICKET_CTMT_APPLY, "改期改签申请"),
	ORDER_TICKET_CTMT_AUDIT(Path.ORDER_TICKET_CTMT_AUDIT, "改期改签审核"),
	ORDER_TICKET_CTMT_OPERATE(Path.ORDER_TICKET_CTMT_OPERATE, "改期改签处理"),

//	BOOKING_VERIFY_SEAT(Path.BOOKING_VERIFY_SEAT, "预订验舱"),
//	BOOKING_VERIFY_PRICE(Path.BOOKING_VERIFY_PRICE, "预订验价"),
	TO_BOOKING(Path.TO_BOOKING, "去预订"),
	BOOKING(Path.BOOKING, "预订"),
	BOOKING_REBUILD(Path.BOOKING_REBUILD, "预订重构"),
	GETBOOKING(Path.GETBOOKING, "获取预订页信息"),
	
	/**预订新resource对应PATH--start*/
	TO_BOOKING_NEW(Path.TO_BOOKING_NEW, "去预订"),
	TO_BOOKING_SIMPLE(Path.TO_BOOKING_SIMPLE, "去预订不带价格"),
	BOOKING_NEW(Path.BOOKING_NEW, "预订"),
	BOOKING_REBUILD_NEW(Path.BOOKING_REBUILD_NEW, "预订重构"),
	GET_BOOKING_ORDER_MAIN_BY_ID(Path.GET_BOOKING_ORDER_MAIN_BY_ID, "获取预订页信息"),
	/**预订新resource对应PATH--end*/
	
	GETFLIGHTINFOBYNO(Path.GETFLIGHTINFOBYNO, "根据航班号获取航班信息"),
	GETFLIGHTINFOBYNOAIRPORT(Path.GETFLIGHTINFOBYNOAIRPORT, "根据航班号获取航班信息"),
	
	MODIFY_ORDER_CONTACTER(Path.MODIFY_ORDER_CONTACTER,"修改订单联系人信息"),
	MODIFY_ORDER_EXPRESS(Path.MODIFY_ORDER_EXPRESS,"修改订单快递信息"),
	QUERY_EXPRESS_LIST(Path.QUERY_EXPRESS_LIST,"查询快递列表"),
	
	SYNC_ORDER_BY_SUPP_ORDER_NO(Path.SYNC_ORDER_BY_SUPP_ORDER_NO,"根据供应商订单No同步订单信息"),
	GET_SUPP_ORDER_BY_SUPP_ORDER_NO(Path.GET_SUPP_ORDER_BY_SUPP_ORDER_NO,"根据供应商订单No获取供应商订单"),//，主要用于回调日志
	CHECK_SUPP_ORDER_STATUS_BY_ORDER_ID(Path.CHECK_SUPP_ORDER_STATUS_BY_ORDER_ID,"验证供应商状态"),
	SUPP_ORDER_PAY(Path.SUPP_ORDER_PAY,"供应商支付"),
	SYNC_SUPP_ORDER_PAY(Path.SYNC_SUPP_ORDER_PAY,"同步供应商自动支付"),
	QUERY_ORDER_LIST(Path.QUERY_ORDER_LIST,"查询订单列表信息"),
	QUERY_ORDER_LIST_COUNT(Path.QUERY_ORDER_LIST_COUNT,"查询订单列表总的订单数"),
	QUERY_ORDER_LIST_WITH_OPTYPE(Path.QUERY_ORDER_LIST_WITH_OPTYPE,"查询订单列表信息根据操作类型"),
	QUERY_FLIGHT_ORDER_REQ_RECORD_LIST(Path.QUERY_FLIGHT_ORDER_REQ_RECORD_LIST,"查询下单请求记录列表"),
	QUERY_FLIGHT_ORDER_INTENTION_RECORD_LIST(Path.QUERY_FLIGHT_ORDER_INTENTION_RECORD_LIST,"查询客户预订意向记录列表"),
	QUERY_FLIGHT_ORDER_REQ_RECORD_LIST_OF_EXPORT(Path.QUERY_FLIGHT_ORDER_REQ_RECORD_LIST_OF_EXPORT,"导出下单请求记录信息"),
	QUERY_FLIGHT_ORDER_INTENTION_RECORD_LIST_EXPORT(Path.QUERY_FLIGHT_ORDER_INTENTION_RECORD_LIST_EXPORT,"导出客户预订意向记录列表"),
	SAVE_FLIGHT_ORDER_INTENTION(Path.SAVE_FLIGHT_ORDER_INTENTION,"保存客户预订意向"),
	QUERY_ORDER_LIST_OF_EXPORT(Path.QUERY_ORDER_LIST_OF_EXPORT, "查询订单列表信息(导出)"),
	API_FLOW_LIST(Path.API_FLOW_LIST,"查询流量列表"),
	API_FLOW_LIST_CSV(Path.API_FLOW_LIST_CSV,"查询流量列表CSV"),
	API_CACHE_CONFIG_LIST(Path.API_CACHE_CONFIG_LIST,"查询api缓存配置列表"),
	UPDATE_API_CACHE_CONFIG(Path.UPDATE_API_CACHE_CONFIG,"修改api缓存配置的有效期限制"),
	BATCH_REMOVE_API_CACHE_CONFIG(Path.BATCH_REMOVE_API_CACHE_CONFIG,"删除api缓存配置"),
	INSERT_API_CACHE_CONFIG(Path.INSERT_API_CACHE_CONFIG,"添加api缓存配置"),
	TASK_CONFIG_LIST(Path.TASK_CONFIG_LIST,"查询任务配置"),
	TASK_CONFIG_SAVE(Path.TASK_CONFIG_SAVE,"任务配置保存更新"),
	TASK_CONFIG_DELETE(Path.TASK_CONFIG_DELETE,"删除任务配置"),
	TASK_CONFIG_LOAD(Path.TASK_CONFIG_LOAD,"load任务配置"),
	 QUERY_ORDER_EXPRESS_LIST(Path.QUERY_ORDER_EXPRESS_LIST,("订单快递列表")), 
	 ORDER_EXPRESS_SAVE(Path.ORDER_EXPRESS_SAVE,("订单快递保存和更新")), 
	 ORDER_EXPRESS_LOAD(Path.ORDER_EXPRESS_LOAD,("订单快递load")), 
	API_FLOW_LIST_COUNT(Path.API_FLOW_LIST_COUNT,"查询流量统计"),
	API_FLOW_LIST_COUNT_EXPORT_CSV(Path.API_FLOW_LIST_COUNT_EXPORT_CSV,"导出流量统计"),
	QUERY_BOOKING_ORDER_LIST(Path.QUERY_BOOKING_ORDER_LIST,"查询预定订单列表信息(H5)"),
	
	AMOUNT_CALCULATE(Path.AMOUNT_CALCULATE, "订单相关金额计算"),
	MODIFY_EXPRESS_CALCULATE(Path.MODIFY_EXPRESS_CALCULATE,"修改快递后订单金额计算"),
	
	TICKET_ISSUE_OPERATION(Path.TICKET_ISSUE_OPERATION,"人工出票处理"),
	
	QUERY_PRINT_TICKET(Path.QUERY_PRINT_TICKET, "获取待打印行程单"),
	
    /**行程单--入库*/
    INSERT_TICKET_BSP_STORAGE(Path.INSERT_TICKET_BSP_STORAGE,"行程单入库"),
    QUERY_TICKET_BSP_STORAGE(Path.QUERY_TICKET_BSP_STORAGE,"查询行程单列表"),
	UPDATE_TICKET_BSP_STORAGE_STATUS(Path.UPDATE_TICKET_BSP_STORAGE_STATUS,"修改行程单的状态"),
	/**行程单--明细*/
	QUERY_TICKET_BSPDETAIL(Path.QUERY_TICKET_BSPDETAIL,"查询行程单明细"),
	QUERY_BSPDETAIL_TICKINFO_BY_ORDERNO(Path.QUERY_BSPDETAIL_TICKINFO_BY_ORDERNO,"通过订单号查询所有票号信息"),
	UPDATE_TICKET_BSPDETAIL_STATUS(Path.UPDATE_TICKET_BSPDETAIL_STATUS,"修改行程单明细状态"),
	
	UPDATE_BSP_STATUS_UNUSED(Path.UPDATE_BSP_STATUS_UNUSED,"修改行程单明细状态为未使用"),
	UPDATE_BSP_STATUS_CANCEL_INVALID(Path.UPDATE_BSP_STATUS_CANCEL_INVALID,"修改行程单明细为取消作废"),
	
	VALIDATE_BSPDETAIL_TICKETNO(Path.VALIDATE_BSPDETAIL_TICKETNO,"验证行程单所对应的票号信息"),
	OPER_TICKET_BSPNO_LOG(Path.OPER_TICKET_BSPNO_LOG,"(添加行程单的操作记录"),
	QUERY_TICKET_BSP_STATISTICS(Path.QUERY_TICKET_BSP_STATISTICS,"查询统计行程单信息"),
	
    GET_ORDER_OPLOGS_BY_ORDER_ID(Path.GET_ORDER_OPLOGS_BY_ORDER_ID,"根据订单id查询订单日志"),
	GET_ORDER_LINK_INFOS_BY_ORDER_ID(Path.GET_ORDER_LINK_INFOS_BY_ORDER_ID,"根据订单id查询关联订单"),
    LOAD_OFFICE(Path.LOAD_OFFICE,"加载office配置信息"),
	
	ORDER_APPLY(Path.ORDER_APPLY,"保存申请信息"),
	ORDER_AUDIT(Path.ORDER_AUDIT,"保存审核信息"),
	ORDER_OPERATION(Path.ORDER_OPERATION,"保存处理信息"),
	APPLY_SUPP_RTVT(Path.APPLY_SUPP_RTVT, "申请供应商退票"),
	QUERY_CITY(Path.QUERY_CITY,"查询城市"),
	QUERY_CITY_LIST(Path.QUERY_CITY_LIST,"查询城市列表"),
	QUERY_CITY_BY_HOT(Path.QUERY_CITY_BY_HOT,"查询城市"),
	GET_CITY(Path.GET_CITY,"根据三字码查询城市信息"),
	QUERY_CARRIER_BY_CODE(Path.QUERY_CARRIER_BY_CODE,"根据航空公司码查询航空公司信息"),
	QUERY_CARRIER_LIST(Path.QUERY_CARRIER_LIST,"查询航空公司列表"),
	QUERY_AUDIT_OP_LIST(Path.QUERY_AUDIT_OP_LIST,"查询出票改签退票审核/处理列表"),
	
	GET_COUPON_SWITCH(Path.GET_COUPON_SWITCH, "获取是否使用优惠券开关(PC&H5)"),
	
	QUERY_TICKET_DETAIL_LIST(Path.QUERY_TICKET_DETAIL_LIST,"查询客票明细列表信息"),
	
	QUERY_TICKET_DETAIL_LIST_OF_EXPORT(Path.QUERY_TICKET_DETAIL_LIST_OF_EXPORT, "查询客票明细信息(导出)"),

	QUERY_SALES(Path.QUERY_SALES,"查询渠道列表"),
	
    ADD_ORDER_REMARK(Path.ADD_ORDER_REMARK,"新增订单备注"),
	QUERY_ORDER_REMARK_LIST(Path.QUERY_ORDER_REMARK_LIST, "查询订单备注列表"),
	
	QUERY_ORDER_PNR(Path.QUERY_ORDER_PNR, "查询订单PNR文本信息"),
	SAVE_ORDER_PNR(Path.SAVE_ORDER_PNR,"保存订单PNR文本信息"),
	
	QUERY_ORDER_DETAIL_VIEW(Path.QUERY_ORDER_DETAIL_VIEW, "查询订单明细视图信息"),
	QUERY_ORDER_DETAIL_VIEW_BY_ORDERNO(Path.QUERY_ORDER_DETAIL_VIEW_BY_ORDERNO, "查询订单明细视图信息BYORDERNO"),

	QUERY_ORDER_PASSENGER_DETAIL_VIEW(Path.QUERY_ORDER_PASSENGER_DETAIL_VIEW, "查询订单明细视图信息包含乘客详细信息"),
	
	QUERY_ORDER_DETAIL_VIEW_BY_ID(Path.QUERY_ORDER_DETAIL_VIEW_BY_ID, "查询订单明细视图信息BYID"),
	QUERY_ORDER_PASSENGER_DETAIL_VIEW_BY_ID(Path.QUERY_ORDER_PASSENGER_DETAIL_VIEW_BY_ID, "查询订单明细视图信息(包含乘客详细信息)BYID"),

	QUERY_ORDER_DETAIL_INFO(Path.QUERY_ORDER_DETAIL_INFO, "查询订单详情明细信息"),
	
	PAY_CALLBACK(Path.PAY_CALLBACK,"支付回调"),
	PAY_CALLBACK_ACTIVE(Path.PAY_CALLBACK_ACTIVE,"支付回调，主动拉取支付信息job"),
	PAY(Path.PAY,"申请支付"),
	GET_PAYMENT_INFO(Path.GET_PAYMENT_INFO,"取得支付信息"),
	GET_PAY_INFO_FROM_VST(Path.GET_PAY_INFO_FROM_VST,"取得支付信息from vst"),
	REFUND(Path.REFUND,"申请退款"),
	PAY_AMOUNT_INFO(Path.PAY_AMOUNT_INFO,"取得可退信息"),
	IS_CAN_MAIN_PAY(Path.IS_CAN_MAIN_PAY," 是否满足主单支付条件"),
	GET_ORDER_PAY_COUNT(Path.GET_ORDER_PAY_COUNT,"订单支付数"),
	REPEAT_REFUND(Path.REPEAT_REFUND,"重复支付退款"),
	
	TO_REFUND(Path.TO_REFUND,"去申请退款"),
	REFUND_CALLBACK(Path.REFUND_CALLBACK,"退款回调"),
	SAVE_ORDER_OFFLINE_PAY_INFO(Path.SAVE_ORDER_OFFLINE_PAY_INFO,"保存线下支付信息"),
	QUERY_ORDER_PAY_INFO(Path.QUERY_ORDER_PAY_INFO,"查询支付结果信息"),
	SAVE_ORDER_ONLINE_REFUND_INFO(Path.SAVE_ORDER_ONLINE_REFUND_INFO,"保存线上退款信息"),
	SAVE_ORDER_OFFLINE_REFUND_INFO(Path.SAVE_ORDER_OFFLINE_REFUND_INFO,"保存线下退款信息"),
	QUERY_ORDER_REFUND_INFO(Path.QUERY_ORDER_REFUND_INFO,"查询退款结果信息"),
	QUERY_ORDER_REFUND_INFO_BYORDERID(Path.QUERY_ORDER_REFUND_INFO_BYORDERID,"根据订单id查询退款信息"),
	QUERY_PAYMENTS(Path.QUERY_PAYMENTS,"支付监控查询支付记录"),
	QUERY_REFUNDS(Path.QUERY_REFUNDS,"退款监控查询退款记录"),
	UPDATE_REFUND_STATUS(Path.UPDATE_REFUND_STATUS,"更新支付状态为解冻（解锁）"),
	EXPORT_REFUNDS_BY_CVS(Path.EXPORT_REFUNDS_BY_CVS,"导出退款信息(CVS)"),
	EXPORT_PAYMENTS_BY_CVS(Path.EXPORT_PAYMENTS_BY_CVS,"导出支付信息(CVS)"),
	
	GET_ORDER_MAIN_BY_VST_FLIGHT_ORDER_ID(Path.GET_ORDER_MAIN_BY_VST_FLIGHT_ORDER_ID,""),
	GET_ORDER_MAIN_BY_ID(Path.GET_ORDER_MAIN_BY_ID,"根据订单主键查询主订单信息"),
	
	SINGLE_INSURING(Path.SINGLE_INSURING, "自动投保"),
	SINGLE_INSURING_COMMON(Path.SINGLE_INSURING_COMMON,"火车票自动投保"),
	ARTIFICIAL_INSURING(Path.ARTIFICIAL_INSURING, "人工投保"),
	HESITATE_CANCEL(Path.HESITATE_CANCEL, "退保"),
	QUERY_INSURANCE(Path.QUERY_INSURANCE, "获取可用保险"),
	QUERY_INSURANCE_ORDER_LIST(Path.QUERY_INSURANCE_ORDER_LIST,"查询保单列表(OrderInsurance)"),
	QUERY_INSURANCE_ORDERS(Path.QUERY_INSURANCE_ORDERS,"查询保单列表(InsuranceOrder)"),
	SEARCH_INSURANCE_ORDER_LIST(Path.SEARCH_INSURANCE_ORDER_LIST,"查询保单列表信息,只查T_INS_ORDER表"),
	QUERY_INSURANCE_ORDER_LIST_OF_EXPORT(Path.QUERY_INSURANCE_ORDER_LIST_OF_EXPORT,"导出保单列表"),
	QUERY_INSURANCE_ORDER_DETAIL(Path.QUERY_INSURANCE_ORDER_DETAIL,"查询保单详情"),
	
	SAVE_INSURANCE(Path.SAVE_INSURANCE,"添加保险产品"),
	QUERY_INSURANCE_LIST(Path.QUERY_INSURANCE_LIST, "保险产品列表"),
	GET_INSURANCE_BY_SUPP(Path.GET_INSURANCE_BY_SUPP,"根据供应商查询保险产品"),
	QUERY_INSURANCE_CLASS(Path.QUERY_INSURANCE_CLASS, ""),
	GET_INSURANCE_BY_ID(Path.GET_INSURANCE_BY_ID,"根据ID查询保险产品详情"),
	GET_VALID_BY_SUPP_ID(Path.GET_VALID_BY_SUPP_ID,"根据供应商查询有效的保险产品"),
	UPDATE_INSURANCE_BY_ID(Path.UPDATE_INSURANCE_BY_ID,"根据ID删除保险产品"),
	UPDATE_INSURANCE_DEFAULT_RULE(Path.UPDATE_INSURANCE_DEFAULT_RULE,"修改保险产品默认状态"),
	
	MANUAL_SYNC_SUPP_RTVT(Path.MANUAL_SYNC_SUPP_RTVT, "人工同步供应商退废票信息"),
	
	SUPP_ORDER_REFUND_SYNC(Path.SUPP_ORDER_REFUND_SYNC, "供应商订单退废票信息同步"),
	
	GET_FLIGHT_INFO_BY_GOODS_ID(Path.GET_FLIGHT_INFO_BY_GOODS_ID,"根据vst商品id查询vst航班信息"),
	
	GET_FLIGHT_VST_GOODS_BY_GOODS_ID(Path.GET_FLIGHT_VST_GOODS_BY_GOODS_ID,"根据vst商品id查询vst商品信息"),
	
//	GET_POLICY_DETAIL(Path.GET_POLICY_DETAIL_BY_ID,"根据政策ID获取政策详情信息"),
//	GET_POLICY_BY_FLIGHT_INFO(Path.GET_POLICY_BY_FLIGHT_INFO,"根据航班信息获取政策详情信息"),
//	QUERY_POLICY_LIST(Path.QUERY_POLICY_LIST,"查询政策列表"),
//	QUERY_POLICY_EXCLUDE_LIST(Path.QUERY_POLICY_EXCLUDE_LIST,"查询不适用政策的航班"),
//	DELETE_POLICY_EXCLUDE(Path.DELETE_POLICY_EXCLUDE,"删除不适用政策的航班"),
	
	QUERY_ORDER_MAIN_BY_VST_ORDER_INFO(Path.QUERY_ORDER_MAIN_BY_VST_ORDER_INFO,"根据vst订单信息查询机票主单信息"),
	
	GET_ORDER_MAIN_BY_NO(Path.GET_ORDER_MAIN_BY_NO,"根据主单No查询主订单信息"),
	GET_ORDER_BY_NO(Path.GET_ORDER_BY_NO,"根据子单No查询主订单信息"),
	
	SAVE_BATCH_FLIGHT_ORDER_VST_INFO(Path.SAVE_BATCH_FLIGHT_ORDER_VST_INFO,"批量保存vst机票订单关系信息"),
	
	QUERY_ORDER_PAYMENT_INFO_BY_VST_ORDER_INFO(Path.QUERY_ORDER_PAYMENT_INFO_BY_VST_ORDER_INFO,"根据vst信息查询机票订单支付信息"),

	BINDING_VST_ORDER(Path.BINDING_VST_ORDER,"解除绑定VST航班号"),
	UNBINDING_VST_ORDER(Path.UNBINDING_VST_ORDER,"解除绑定VST航班号"),
	CREATE_SETTLEMENT(Path.CREATE_SETTLEMENT,"生成结算单"),
	
	CREATE_SETTLEMENT_TEST(Path.CREATE_SETTLEMENT_TEST,"生成结算单URL测试"),
	FLIGHT_SMS(Path.FLIGHT_SMS,"短息发送URL测试"),
	GET_SMS_CONTENT(Path.GET_SMS_CONTENT,"WEB获取短信发送内容"),
	SEND_SMS(Path.SEND_SMS,"web短信发送"),
	
	QUERY_ORDER_TICKET_INFO(Path.QUERY_ORDER_TICKET_INFO,"根据票号查询乘机人、航班等相关信息"),
	BUILD_AMOUNT_DETAIL(Path.AMOUNT_DETAIL_CALCULATE,"按乘客类型区分出金额信息"),
	
    QUERY_BINDING_ORDER_MAIN_BY_VST_ORDER_INFO(Path.QUERY_BINDING_ORDER_MAIN_BY_VST_ORDER_INFO,"根据vst信息查询绑定的主单信息"),
	
    QUERY_SUPP_LIST(Path.QUERY_SUPP_LIST,"查询供应商信息"),
    
	ADD_OP_LOG(Path.ADD_OP_LOG,"添加操作日志"),
	QUERY_OP_LOG(Path.QUERY_OP_LOG,"查询操作日志"),
	QUERY_OP_LOG_LIST(Path.QUERY_OP_LOG_LIST,"查询操作日志"),
	QUERY_OP_LOG_LIST_BY_CONDITION(Path.QUERY_OP_LOG_LIST_BY_CONDITION,"按条件查询操作日志列表"),
	QUERY_SMS_LOG_LIST(Path.QUERY_SMS_LOG_LIST,"查询短信日志列表"),
	SAVE_SMS(Path.SAVE_SMS,"保存需发送的短信信息"),
	QUERY_SMSES(Path.QUERY_SMSES,"查询需发送的短信信息"),
	SMS_GROUP_SEND(Path.SMS_GROUP_SEND,"短信群发"),
	BATCH_SMS_GROUP_SEND(Path.BATCH_SMS_GROUP_SEND,"短信批量群发"),
	QUERY_ORDER_OP_LOG_LIST(Path.QUERY_ORDER_OP_LOG_LIST,"查询订单日志"),
	QUERY_ORDER_OP_MAIN_LOG_LIST(Path.QUERY_ORDER_OP_MAIN_LOG_LIST,"查询主单跟子订单日志"),
	ADD_ORDER_OP_LOG(Path.ADD_ORDER_OP_LOG,"保存订单日志"),
	ADD_ORDER_OP_LOG_LIST(Path.ADD_ORDER_OP_LOG_LIST,"保存订单日志list"),
	
	BINDING_SALES_ORDER(Path.BINDING_SALES_ORDER,"绑定外部订单"),
	UNBINDING_SALES_ORDER(Path.UNBINDING_SALES_ORDER,"解除绑定外部订单"),
	SAVE_FLIGHT_ORDER_SALES_ORDER_RELATION(Path.SAVE_FLIGHT_ORDER_SALES_ORDER_RELATION,"保存机票订单与外部订单关系"),
	QUERY_BINDING_ORDER_MAIN_BY_ORDER_RELATION(Path.QUERY_BINDING_ORDER_MAIN_BY_ORDER_RELATION,"根据外部订单信息查询绑定的主单信息"),
	GET_CHILD_SEAT_POLICY(Path.GET_CHILD_SEAT_POLICY,"获取儿童的舱位政策"),
	GET_CHILD_SEAT_POLICY_AGGREGATE(Path.GET_CHILD_SEAT_POLICY_AGGREGATE,"获取儿童的舱位政策（聚合）"),
	QUERY_ORDER_PAYMENT_INFO_BY_SALES_ORDER_RELATION(Path.QUERY_ORDER_PAYMENT_INFO_BY_SALES_ORDER_RELATION,"根据外部订单与机票关系查询订单支付信息"),
	QUERY_VST_SYNC_CONFIG_DATAS(Path.QUERY_VST_SYNC_CONFIG_DATAS,"查询VST同步任务信息"),
	RESET_VST_SYNC_CONFIG_STATUS(Path.RESET_VST_SYNC_CONFIG_STATUS,"重置VST同步任务状态"),
	QUERY_VST_PRODUCTS(Path.QUERY_VST_PRODUCTS,"查询VST产品信息"),
	QUERY_VST_GOODS(Path.QUERY_VST_GOODS,"根据条件查询VST商品信息"),
	QUERY_VST_GOODS_TIME_PRICES(Path.QUERY_VST_GOODS_TIME_PRICES,"根据条件查询VST商品时间价格信息"),
	QUERY_VST_TRAFFIC_FLIGHTS(Path.QUERY_VST_TRAFFIC_FLIGHTS,"根据条件查询VST航班信息"),
	QUERY_VST_PRODUCT_BRANCHES(Path.QUERY_VST_PRODUCT_BRANCHES,"根据条件查询VST规格信息"),
	QUERY_VST_BASIC_FLIGHTS(Path.QUERY_VST_BASIC_FLIGHTS,"根据条件查询VST基础航班信息"),
	QUERY_VST_TASK_CONFIGS(Path.QUERY_VST_TASK_CONFIGS,"根据条件查询VST任务配置信息"),
	SAVE_VST_TASK_CONFIG(Path.SAVE_VST_TASK_CONFIG,"保存VST任务配置信息"),
	GET_VST_TASK_CONFIG_BY_ID(Path.GET_VST_TASK_CONFIG_BY_ID,"根据ID查询VST任务配置信息"),
    VERIFY_BOOKING_AGAIN(Path.VERIFY_BOOKING_AGAIN,"重新下单前验舱验价"),
    BOOKING_AGAIN(Path.BOOKING_AGAIN,"重新预订"),
    BOOKING_AGAIN_NEW(Path.BOOKING_AGAIN_NEW,"重新预订（NEW）"),
	QUERY_SALES_RULE_DISABLE(Path.QUERY_SALES_RULE_DISABLE,"查询禁售规则列表"),
	SAVE_SALES_RULE_DISABLE(Path.SAVE_SALES_RULE_DISABLE,"保存禁售规则"),
	GET_SALES_RULE_DISABLE(Path.GET_SALES_RULE_DISABLE,"根据ID查询指定禁售规则"),
	
	/**同步分销机票订单状态*/
	DIST_SYNC_ORDER_STATUS(Path.DIST_SYNC_ORDER_STATUS,"同步分销机票订单状态"),
	DIST_GET_TNTID(Path.DIST_GET_TNTID,"获取分销单号"),
	DIST_GET_ORDERNO_BY_REFUNDNO(Path.DIST_GET_ORDERNO_BY_REFUNDNO, "退款单号获取退票单号"),
	

    /**航班运价管理-----Start*/
    /**运价政策*/
    QUERY_FLIGHT_PRICE_POLICY_LIST(Path.QUERY_FLIGHT_PRICE_POLICY_LIST,"根据条件查询航班运价政策信息"),
    GET_FLIGHT_PRICE_POLICY_BY_ID(Path.GET_FLIGHT_PRICE_POLICY_BY_ID,"根据航班运价政策ID获取航班运价政策详情信息"),
    BATCH_DEL_FLIGHT_PRICE_POLICY(Path.BATCH_DEL_FLIGHT_PRICE_POLICY,"根据条件批量删除航班运价政策信息"),
    /**运价库存*/
    QUERY_FLIGHT_PRICE_INVENTORY_LIST(Path.QUERY_FLIGHT_PRICE_INVENTORY_LIST,"根据条件查询航班运价库存信息"),
    BATCH_DEL_FLIGHT_PRICE_INVENTORY(Path.BATCH_DEL_FLIGHT_PRICE_INVENTORY,"根据条件批量删除航班运价库存信息"),
	/**运价基本信息*/
	QUERY_FLIGHT_PRICE_INFO_LIST(Path.QUERY_FLIGHT_PRICE_INFO_LIST,"根据条件查询航班运基本信息"),
	BATCH_DEL_FLIGHT_PRICE_INFO(Path.BATCH_DEL_FLIGHT_PRICE_INFO,"根据条件批量删除航班运价基本信息"),
	/**航班运价管理-----End*/
	/**营销调控规则管理-----Start*/
	SAVE_SALES_RULE_SOURCE(Path.SAVE_SALES_RULE_SOURCE,"保存营销调控规则"),
	UPDATE_SALES_RULE_SOURCE(Path.UPDATE_SALES_RULE_SOURCE,"修改营销调控规则的状态"),
	BATCH_DELETE_SALES_RULE_SOURCE(Path.BATCH_DELETE_SALES_RULE_SOURCE,"批量删除营销调控规则"),
	GET_SALES_RULE_SOURCE_BY_ID(Path.GET_SALES_RULE_SOURCE_BY_ID,"查询营销调控规则详情"),
	QUERY_SALES_RULE_SOURCE(Path.QUERY_SALES_RULE_SOURCE,"查询营销调控列表"),
	/**营销调控规则管理-----End*/
	/**虚拟调控规则管理-----Start*/
	SAVE_SALES_RULE_SUPP(Path.SAVE_SALES_RULE_SUPP,"保存虚拟调控规则"),
	UPDATE_SALES_RULE_SUPP(Path.UPDATE_SALES_RULE_SUPP,"修改虚拟调控规则的状态"),
	BATCH_DELETE_SALES_RULE_SUPP(Path.BATCH_DELETE_SALES_RULE_SUPP,"删除虚拟调控规则"),
	GET_SALES_RULE_SUPP_BY_ID(Path.GET_SALES_RULE_SUPP_BY_ID,"查询虚拟调控规则详情"),
	QUERY_SALES_RULE_SUPP(Path.QUERY_SALES_RULE_SUPP,"查询虚拟调控列表"),
	/**虚拟调控管理-----End*/
	/**查询航空公司所有机场信息列表*/
	QUERY_AIRPORT_LIST(Path.QUERY_AIRPORT_LIST,"查询航空公司机场列信息"),
	QUERY_SETTLEMENT_ORDER_LIST(Path.QUERY_SETTLEMENT_ORDER_LIST,"查询结算单列表"),
	SEND_SETTLEMENT_ORDER_TO_VST(Path.SEND_SETTLEMENT_ORDER_TO_VST,"推送结算数据至VST"),
	SAVE_SETTLEMENT_ORDER(Path.SAVE_SETTLEMENT_ORDER,"生成结算单"),
	BATCH_SAVE_SETTLEMENT_ORDER(Path.BATCH_SAVE_SETTLEMENT_ORDER,"批量生成结算单"),
	BATCH_SEND_SETTLEMENT_ORDER_TO_VST(Path.BATCH_SEND_SETTLEMENT_ORDER_TO_VST,"批量推送结算数据至VST"),
	/**通知规则信息管理-----Start*/
	SAVE_NOTICE_INFO(Path.SAVE_NOTICE_INFO,"保存通知规则信息"),
	UPDATE_NOTICE_INFO(Path.UPDATE_NOTICE_INFO,"修改通知规则信息"),
	DELETE_NOTICE_INFO(Path.DELETE_NOTICE_INFO,"删除通知规则信息"),
	GET_NOTICE_INFO_BY_ID(Path.GET_NOTICE_INFO_BY_ID,"查询通知规则信息详情"),
	QUERY_NOTICE_INFO(Path.QUERY_NOTICE_INFO,"查询通知规则信息列表"),
	GET_NOTICE_INFO(Path.GET_NOTICE_INFO,"查询通知规则信息详情"),
	SYNC_NOTICE_INFO_CACHE(Path.SYNC_NOTICE_INFO_CACHE,"定时同步任务，把通知规则信息放入缓存中"),
	/**通知规则信息-----End*/
	
	/**携程改签业务-----Start*/
	FIND_SUPP_TICKET_CTMT_APPLY(Path.FIND_SUPP_TICKET_CTMT_APPLY,"验证供应商国内机票可退票/改签查询"),
    SEARCH_SUPP_CHANGE_FLIGHT_INFO_APPLY(Path.SEARCH_SUPP_CHANGE_FLIGHT_INFO_APPLY,"可改签后搜索可改签航班列表页"),
    FINISH_FLIGHT_CHANGE_APPLY(Path.FINISH_FLIGHT_CHANGE_APPLY, "根据选择的变更航班,并进行落地"),
    AUTO_CHANGE_APPLY(Path.AUTO_CHANGE_APPLY, "请求供应商改签申请"),
    SYNC_CTMT_TICKET_BY_SUPP_ORDER(Path.SYNC_CTMT_TICKET_BY_SUPP_ORDER, "根据订单ID同步供应商改签票信息"),
    //SYNC_CTMT_TICKET_INFO_HANDLE(Path.SYNC_CTMT_TICKET_INFO_HANDLE,"供应商订单改签订单信息处理"),
	/**携程改签业务-----End*/

	QUERY_ORDER_FLIGHT_CHANGE_INFO_LIST(Path.QUERY_ORDER_FLIGHT_CHANGE_INFO_LIST,("查询航变列表")),
	UPDATE_ORDER_FLAG_BY_ORDER_ID(Path.UPDATE_ORDER_FLAG_BY_ORDER_ID,"根据订单ID修改下单账号类型"),
	UPDATE_ORDER_CANCEL_BY_ORDER_ID(Path.UPDATE_ORDER_CANCEL_BY_ORDER_ID,"根据订单ID号修改T_FORD_ORDER_STATUS的订单取消状态"),
	UPDATE_PAY_AMOUNT_BY_ORDER_ID(Path.UPDATE_PAY_AMOUNT_BY_ORDER_ID,"根据订单ID修改下单账号类型"),
	ORDER_FLIGHT_CHANGE_NOTIFY(Path.ORDER_FLIGHT_CHANGE_NOTIFY, "供应商推送航变通知"),
	UPDATE_SUPP_ORDER_SUPP_BY_ORDER_ID(Path.UPDATE_SUPP_ORDER_SUPP_BY_ORDER_ID,"根据订单id修改供应商订单中的供应商信息"),
	/** ----供应商下单------ **/
	VIEW_TICKET_RULES(Path.VIEW_TICKET_RULES, "请求成人和儿童的客规信息"),
	VIEW_PRODUCT_PRICES(Path.VIEW_PRODUCT_PRICES, "请求成人和儿童的商品价格信息"),
	SUPP_BOOKING(Path.SUPP_BOOKING,"供应商下单"),
	QUERY_DETAIL_VIEW_LIST_BY_SALES_ORDERRELATION(Path.QUERY_DETAIL_VIEW_LIST_BY_SALES_ORDERRELATION, "根据外部订单信息查询订单详情视图信息"),
	OP_VALID_BY_ORDER_ID(Path.OP_VALID_BY_ORDER_ID, "根据订单Id查询是否可支付"),
	
	/**-----保险公共业务服务----*/
	SINGLE_INSURANCE(Path.SINGLE_INSURANCE, "自动投保"),
	ARTIFICIAL_TINSURANCE(Path.ARTIFICIAL_TINSURANCE, "人工投保"),

	/** 订单导入 **/
	QUERY_ORDER_IMPORT_LIST(Path.QUERY_ORDER_IMPORT_LIST, "已导入订单"),
	QUERY_ORDER_IMPORT_RECORD_LIST(Path.QUERY_ORDER_IMPORT_RECORD_LIST, "导入记录");
     
	public String path;
	public String cnName;
	
	public static class Path{
		
		
		public final static String basePath="bussiness/";
		public final static String orderPath ="order/";
		public final static String suppOrderPath = "suppOrder/";
		public final static String ticketPath ="ticket/";
		public final static String flightPath = "flight/";
		public final static String configPath = "config/";
		public final static String apiPath = "api/";
		public final static String salesPath = "sales/";
		public final static String pricePath ="price/";
		

		public final static String ADD_OP_LOG=basePath+configPath+"addOpLog";
		public final static String QUERY_OP_LOG=basePath+configPath+"queryOpLog/{businessId}/{businessType}";
		public final static String GET_CHILD_SEAT_POLICY=flightPath+"getChildSeatPolicy/{flightNo}/{seatCode}/{policyId}/{departDate}/{bookingSource}/{depCityCode}/{arrCityCode}";
		public final static String GET_CHILD_SEAT_POLICY_AGGREGATE=flightPath+"getChildSeatPolicyAggregate";
		
		
		public final static String QUERY_OP_LOG_LIST=basePath+configPath+"queryOpLogList/{businessId}/{businessType}/{operType}/{page}/{rows}";
		public final static String QUERY_ORDER_OP_LOG_LIST=basePath+configPath+"queryOrderOpLogList/{orderId}/{operType}/{page}/{rows}";
		public final static String QUERY_ORDER_OP_MAIN_LOG_LIST=basePath+configPath+"queryOrderOpLogList/{orderMainId}/{orderId}/{operType}/{page}/{rows}";
		public final static String ADD_ORDER_OP_LOG=basePath+configPath+"saveOrderOpLog";
		public final static String ADD_ORDER_OP_LOG_LIST=basePath+configPath+"saveOrderOpLogList";

		public final static String GET_ORDER_BY_ORDER_ID=basePath+orderPath+"getOrderById/{orderId}";

		public final static String DELETE_ORDER_BY_ORDER_ID=basePath+orderPath+"deleteOrderById/{orderId}";
		public final static String DELETE_VST_ORDER_BY_ORDER_ID=basePath+orderPath+"deleteVstOrderById/{orderId}";
		public final static String SYNC_NOT_VISIBLE_ORDER=basePath+orderPath+"syncNotVisibleOrder";
		public final static String GET_NOTISSUE_ORDER=basePath+orderPath+"getNotIssueOrder";
		public final static String GET_ORDERS_BY_QUERY_DTO=basePath+orderPath+"/queryFlightOrders/{BaseQueryDto}";
		public final static String ISSUE_TICKET_NOTIFY=basePath+orderPath+"sync/bysupporder/";
		public final static String GET_ORDER_BY_ORDER_NO=basePath+orderPath+"";
		/** 取消订单 */
		public final static String CANCEL_ORDER=basePath+orderPath+"cancelOrder";
		public final static String EDIT_ORDER_LIMITTIME=basePath+orderPath+"editOrderLimtTime";
		/** 改期改签申请 */
		public final static String  ORDER_TICKET_CTMT_APPLY = basePath + orderPath +"orderTicketCTMTApply";
		/** 改期改签审核 */
		public final static String  ORDER_TICKET_CTMT_AUDIT = basePath + orderPath +"orderTicketCTMTAudit";
		/** 改期改签处理 */
		public final static String  ORDER_TICKET_CTMT_OPERATE = basePath + orderPath +"orderTicketCTMTOperate";
//		/** 预订验舱 */
//		public final static String BOOKING_VERIFY_SEAT = basePath + "booking/verifySeat";
//		/** 预订验价 */
//		public final static String BOOKING_VERIFY_PRICE = basePath + "booking/verifyPrice";
		/** 去预订 */
		public final static String TO_BOOKING = basePath + "toBooking";
		/** 预订 */
		public final static String BOOKING = basePath + "booking";
		/** 预订H5 */
		public final static String BOOKING_REBUILD = basePath + "bookingRebuild";
		/** check预订 */
		public final static String GETBOOKING = basePath + "getBooking/{orderId}";
		
		/** 预订resource（新）对应path -- start */
		/** 去预订 */
		public final static String TO_BOOKING_NEW = basePath + "toBookingNew";
		/** 去预订无价格 */
		public final static String TO_BOOKING_SIMPLE = basePath + "toBookingSimple";
		/** 预订 */
		public final static String BOOKING_NEW = basePath + "bookingNew";
		/** 预订H5 */
		public final static String BOOKING_REBUILD_NEW = basePath + "bookingRebuildNew";
		/** 获取预订页信息 */
		public final static String GET_BOOKING_ORDER_MAIN_BY_ID = basePath + "getBookingOrderMainById/{orderMainId}";
		/** 预订resource（新）对应path -- end */
		
		/**根据航班号获取航班信息*/
		public final static String GETFLIGHTINFOBYNO = basePath + "getFlightinfoByNo/{depCityCode}/{arrCityCode}";
		/**根据航班号获取航班信息*/
		public final static String GETFLIGHTINFOBYNOAIRPORT = basePath + "getFlightinfoByNoAirport/{depAirportCode}/{arrAirportCode}";

		/** 修改订单联系人的信息 */
		public final static String  MODIFY_ORDER_CONTACTER = basePath + orderPath +"modifyOrderContacter";
		/** 修改订单快递信息 */
		public final static String  MODIFY_ORDER_EXPRESS = basePath + orderPath +"modifyOrderExpress";
		/** 获取待打印行程单 */
        public static final String QUERY_PRINT_TICKET = basePath+orderPath+"queryPrintTickets";
        /** 查询订单列表信息 */
        public static final String QUERY_ORDER_LIST = basePath+orderPath+"queryFlightOrderList";
        /** 查询订单列表总的订单数 */
        public static final String QUERY_ORDER_LIST_COUNT = basePath+orderPath+"queryFlightOrderListCount";
        /** 查询订单列表信息 */
        public static final String QUERY_ORDER_LIST_WITH_OPTYPE = basePath+orderPath+"queryFlightOrderList/{opType}";
        /** 查询订单列表信息(导出) */
        public static final String QUERY_ORDER_LIST_OF_EXPORT = basePath + orderPath + "queryOrderListOfExport";
        /** 查询任务配置列表 */
        public static final String TASK_CONFIG_LIST = basePath+configPath+"queryTaskConfigList";
        public static final String TASK_CONFIG_SAVE = basePath+configPath+"saveTaskConfig";
        public static final String TASK_CONFIG_DELETE = basePath+configPath+"deleteTaskConfig/{configId}";
        public static final String TASK_CONFIG_LOAD = basePath+configPath+"loadTaskConfig/{configId}";
        /**下单请求记录相关路径*/
        public static final String QUERY_FLIGHT_ORDER_REQ_RECORD_LIST = basePath + configPath + "queryFlightOrderReqRecordList";
        public static final String QUERY_FLIGHT_ORDER_REQ_RECORD_LIST_OF_EXPORT = basePath + configPath + "queryFOrderReqRecordExport";
        /**TASK #32247 客户预订意向记录接口*/
        public static final String QUERY_FLIGHT_ORDER_INTENTION_RECORD_LIST = basePath + configPath + "queryFlightOrderIntentionRecordList";
        public static final String QUERY_FLIGHT_ORDER_INTENTION_RECORD_LIST_EXPORT = basePath + configPath + "queryFOrdIntentionRecordExport";
        public static final String SAVE_FLIGHT_ORDER_INTENTION = basePath + configPath + "saveFlightOrdIntenion";
        /**查询航班供应商订单列表信息 */
        public static final String QUERY_SUPP_ORDER_LIST = basePath+orderPath+"queryFlightSuppOrderList";
        public static final String QUERY_SUPP_ORDER_DETAIL = basePath+orderPath+"queryFlightSuppOrderDetail/{orderId}";
        
        /**订单快递*/
        public static final String QUERY_ORDER_EXPRESS_LIST = basePath+orderPath+"queryOrderExpressList";
        public static final String ORDER_EXPRESS_SAVE = basePath+orderPath+"saveOrderExpress";
        public static final String ORDER_EXPRESS_LOAD = basePath+orderPath+"loadOrderExpress/{expressId}";
        
        /** 查询流量列表 */
        public static final String API_FLOW_LIST = basePath+apiPath+"queryApiFlowList";
        /** 查询流量列表CSV */
        public static final String API_FLOW_LIST_CSV = basePath+apiPath+"queryApiFlowListCsv";
        /** 查询缓存配置列表 */
        public static final String API_CACHE_CONFIG_LIST = basePath+apiPath+"queryApiCacheConfigList";
        /** 修改缓存配置的有效期限制 */
        public static final String UPDATE_API_CACHE_CONFIG = basePath+apiPath+"updateApiCacheConfig";
        /** 添加缓存配置 */
        public static final String INSERT_API_CACHE_CONFIG = basePath+apiPath+"insertApiCacheConfig";
        /** 删除缓存配置 */
        public static final String BATCH_REMOVE_API_CACHE_CONFIG = basePath+apiPath+"batchDeleteApiCacheConfig";

        /** 查询流量统计 */
        public static final String API_FLOW_LIST_COUNT = basePath+apiPath+"queryApiFlowListCount";
        /**导出流量统计*/
        public static final String API_FLOW_LIST_COUNT_EXPORT_CSV = basePath+apiPath+"queryApiFlowListCountExportCsv";
        /** 查询预定订单列表信息H5 */
        public static final String QUERY_BOOKING_ORDER_LIST = basePath+orderPath+"queryBookingFlightOrderList";
        /** 查询可用快递列表 */
        public static final String QUERY_EXPRESS_LIST=basePath +"md/queryFlightExpressList";
		 /** 订单相关金额计算 */
        public static final String AMOUNT_CALCULATE = basePath+"calculate/amountCalculate";
        /**修改快递后金额计算 */
        public static final String MODIFY_EXPRESS_CALCULATE = basePath+"calculate/modifyExpressCalculate";
        /**乘客类型金额计算 */
        public static final String AMOUNT_DETAIL_CALCULATE = basePath+"calculate/getAmountDetail";
        /**保存申请信息 */
        public static final String ORDER_APPLY = basePath+orderPath+"saveApplyInfo/{applyType}";
        /**保存审核信息 */
        public static final String ORDER_AUDIT = basePath+orderPath+"saveAuditInfo/{auditType}";
        /**保存处理信息 */
        public static final String ORDER_OPERATION = basePath + orderPath+"saveOpInfo/{operationType}";
        /** 申请供应商退票 */
        public static final String APPLY_SUPP_RTVT = basePath + orderPath + "applySuppRTVT/{orderId}";
        
        public static final String TICKET_ISSUE_OPERATION = basePath+orderPath+"orderSync";
        
        /**人工出票申请 */
        public static final String TICKET_ISSUE_APPLY = basePath+orderPath+"ticketIssueApply";
        
        /**人工出票审核 */
        public static final String TICKET_ISSUE_AUDIT = basePath+orderPath+"ticketIssueAudit";
        
        /**人工出票处理*/
        public static final String TICKET_ISSUE_OP = basePath+orderPath+"ticketIssueOp";
        
        /**行程单 */
        public final static String bspPath ="bsp/";
        /**行程单------入库*/
        /**添加行程单*/
        public static final String INSERT_TICKET_BSP_STORAGE = basePath+bspPath+"insetTicketBSPStorage";
        /**查询行程单列表 */
        public static final String QUERY_TICKET_BSP_STORAGE = basePath+bspPath+"queryTicketBSPStorageList";
        /** (回收/取消)行程单 */
        public static final String UPDATE_TICKET_BSP_STORAGE_STATUS = basePath+bspPath+"updateTicketBSPStorageStatus";
        /**行程单------明细*/
        /**查询行程单明细 */
        public static final String QUERY_TICKET_BSPDETAIL = basePath+bspPath+"queryTicketBSPDetail";
        /**通过订单号查询票号信息和pnr */
        public static final String QUERY_BSPDETAIL_TICKINFO_BY_ORDERNO = basePath+bspPath+"queryBspTickInfoByOrderNo";

        /** 修改行程单状态 */
        public static final String UPDATE_TICKET_BSPDETAIL_STATUS = basePath+bspPath+"updateTicketBSPDetailStatus";
        
        /** 修改行程单状态--未使用 */
        public static final String UPDATE_BSP_STATUS_UNUSED = basePath+bspPath+"updateBspStatusUnused";
        
        /** 修改行程单状态--取消作废 */
        public static final String UPDATE_BSP_STATUS_CANCEL_INVALID = basePath+bspPath+"updateBspStatusCancelInvalid";
        
        /** 验证行程单所对应票号 */
        public static final String VALIDATE_BSPDETAIL_TICKETNO = basePath+bspPath+"validateBspDetailTicketNo";
        /** 添加行程单的操作记录*/
        public static final String OPER_TICKET_BSPNO_LOG = basePath+bspPath+"operBSPDetailLog";
        /**行程单------统计*/
        public static final String QUERY_TICKET_BSP_STATISTICS = basePath+bspPath+"queryFlightTicketBSPStatistics";
        
        /**根据订单编号查询订单日志信息*/
        public static final String GET_ORDER_OPLOGS_BY_ORDER_ID = basePath+orderPath+"getOrderOpLogsByOrderId";
        public static final String GET_ORDER_LINK_INFOS_BY_ORDER_ID = basePath+orderPath+"getOrderLinkInfosByOrderId";

        /** 查询所有office配置 */
        public static final String LOAD_OFFICE = basePath+bspPath+"loadoffice";
        
        /** 查询所有city */
        public static final String QUERY_CITY = basePath+"md/querycity";
        
        /** 查询所有city列表 */
        public static final String QUERY_CITY_LIST = basePath+"md/queryCityList";
        
        public static final String QUERY_CITY_BY_HOT = basePath+"md/queryCityByHot";
        
        /** 根据城市三字码查询城市信息*/
        public static final String GET_CITY = basePath+"md/getCity";
        
        /** 查询出票改签退票审核/处理列表 */
		public final static String QUERY_AUDIT_OP_LIST = basePath + orderPath +"queryAuditOpList";

		/** 查询客票列表信息 */
		public final static String QUERY_TICKET_DETAIL_LIST = basePath + ticketPath +"queryFlightTicketDetails";
		
		/** 查询客票明细信息(导出) */
		public final static String QUERY_TICKET_DETAIL_LIST_OF_EXPORT = basePath + ticketPath + "queryTicketDetailListOfExport";
		
        /** 查询所有sales(渠道) */
        public static final String QUERY_SALES = basePath+"md/querysales";
        
        /** 根据Code码查询航空公司信息 */
        public static final String QUERY_CARRIER_BY_CODE = basePath+"md/queryCarrierByCode"; 
        
        /** 查询航空公司列表 */
        public static final String QUERY_CARRIER_LIST = basePath+"md/queryCarrierList"; 
        
        /** 新增订单备注**/
        public static final String ADD_ORDER_REMARK = orderPath+"addorderremark";
        
        /** 查询订单备注列表**/
        public static final String QUERY_ORDER_REMARK_LIST = orderPath+"queryorderremark";
        
        /** 查询订单PNR文本信息**/
        public static final String QUERY_ORDER_PNR = orderPath+"queryOrderPnrByOrderId";
        
        /** 保存订单PNR文本信息**/
        public static final String SAVE_ORDER_PNR = orderPath+"savePnrText";
        
        /** 查询订单详情视图信息 */
        public static final String QUERY_ORDER_DETAIL_VIEW = basePath + orderPath + "queryOrderDetailView/{orderMainId}/{orderId}/{opSource}/{opType}";

        /**查询订单详情根据子订单号*/
        public static final String QUERY_ORDER_DETAIL_VIEW_BY_ORDERNO = basePath + orderPath + "queryOrderDetailViewByOrderNo/{orderNo}/{opSource}/{opType}";
        
		/** 查询订单详情视图信息包含了关联乘客信息 */
		public static final String QUERY_ORDER_PASSENGER_DETAIL_VIEW = basePath + orderPath + "queryOrderPassengerDetailView/{orderMainId}/{orderId}/{opSource}/{opType}";
        
        /** 查询订单详情视图信息byId */
		public static final String QUERY_ORDER_DETAIL_VIEW_BY_ID = basePath + orderPath + "queryOrderDetailViewById/{orderId}/{opSource}/{opType}";

		/** 查询订单详情视图信息(包含乘客详细信息)byId */
		public static final String QUERY_ORDER_PASSENGER_DETAIL_VIEW_BY_ID = basePath + orderPath + "queryOrderPassengerDetailViewById/{orderId}/{opSource}/{opType}";

        /** 查询订单详情明细信息 */
        public static final String QUERY_ORDER_DETAIL_INFO = basePath + orderPath + "queryOrderDetailInfo/{orderMainId}/{orderId}";
        
        /**根据vst平台机票子订单查询机票主订单信息*/
        public static final String GET_ORDER_MAIN_BY_VST_FLIGHT_ORDER_ID = basePath + orderPath + "getOrderMainByVstFlightOrderId/{vstFlightOrderId}";
    
        /**根据订单主键查询订单详情*/
        public static final String GET_ORDER_MAIN_BY_ID = basePath + orderPath + "getOrderMainById/{orderMainId}";
        
        /**保险*/
        public final static String insurancePath = "insurance/";
        
        /**自动投保*/
        public static final String SINGLE_INSURING = basePath + insurancePath + "singleInsuring";
        /**自动投保  -- 火车票*/
        public static final String SINGLE_INSURING_COMMON = basePath + insurancePath + "singleInsuringCommon";
        
        /**人工投保*/
        public static final String ARTIFICIAL_INSURING = basePath + insurancePath + "artificialInsuring";
        
        /**退保*/
        public static final String HESITATE_CANCEL = basePath + insurancePath + "hesitateCancel";
        
        /**获取可用保险*/
        public static final String QUERY_INSURANCE = basePath + insurancePath + "queryInsurance";
        
        /**添加保险产品*/
        public static final String SAVE_INSURANCE = basePath + insurancePath + "saveInsurance";
        
        /**根据条件查询保险产品*/
        public static final String QUERY_INSURANCE_LIST = basePath + insurancePath + "queryInsuranceInfo";
        
        /**根据条件查询保险产品*/
        public static final String QUERY_INSURANCE_CLASS = basePath + insurancePath + "queryInsuranceClass";
        
        /**查询保单列表orderinsurance*/
        public static final String QUERY_INSURANCE_ORDER_LIST = basePath + insurancePath + "queryInsuranceOrderList";
        
        /**查询T_INS_ORDER表列表*/
        public static final String SEARCH_INSURANCE_ORDER_LIST = basePath + insurancePath + "searchInsuranceOrderList";
        
        /**查询保单列表insuranceorder*/
        public static final String QUERY_INSURANCE_ORDERS = basePath + insurancePath + "queryInsuranceOrders";
        
        /**查询保单列表（导出）*/
        public static final String QUERY_INSURANCE_ORDER_LIST_OF_EXPORT = basePath + insurancePath + "queryInsuranceOrderListofExport";
        
        /**查询保单详情*/
        public static final String QUERY_INSURANCE_ORDER_DETAIL = basePath + insurancePath + "queryInsuranceOrderDetail/{insuranceOrderId}";
        
        /**查询保单详情*/
        public static final String GET_INSURANCE_BY_SUPP = basePath + insurancePath + "getInsuranceBySupp/{suppId}";
        
        /**查询保险产品详情*/
        public static final String GET_INSURANCE_BY_ID = basePath + insurancePath + "getInsuranceById/{id}";
        
        /**查询保险产品详情*/
        public static final String GET_VALID_BY_SUPP_ID = basePath + insurancePath + "getValidBySuppId/{suppId}";
        
        /**删除保险产品*/
        public static final String UPDATE_INSURANCE_BY_ID = basePath + insurancePath + "updateInsuranceById/{id}";
        
        /**修改保险产品默认状态*/
        public static final String UPDATE_INSURANCE_DEFAULT_RULE = basePath + insurancePath + "updateInsuranceDefaultRule/{id}/{insuranceType}/{productTypes}";
        
        /**查询保险供应商信息*/
        public static final String QUERY_SUPP_LIST = basePath + "suppQuery";
        
        /**支付回调通知*/
        public static final String PAY_CALLBACK = basePath + orderPath + "payCallback";
        /**支付回调，主动拉取支付信息*/
        public static final String PAY_CALLBACK_ACTIVE = basePath + orderPath + "payCallbackActive";
        /**取得支付信息*/
        public static final String GET_PAYMENT_INFO = basePath + orderPath + "getPaymentInfo";
        /**保存线下支付信息*/
        public static final String SAVE_ORDER_OFFLINE_PAY_INFO = basePath + orderPath + "saveOrderOfflinePayInfo";
        /**查询支付信息*/
        public static final String QUERY_ORDER_PAY_INFO = basePath + orderPath + "queryOrderPayInfo";
        /**落地并保存支付信息(新建订单支付)*/
        public static final String PAY = basePath + orderPath + "pay";
        
        public static final String GET_PAY_INFO_FROM_VST = basePath + orderPath + "getPayInfoFromVst/{paymentTradeNo}";
        
        /**支付监控-显示所有支付信息*/
        public static final String QUERY_PAYMENTS = basePath + orderPath + "queryPayments";
        
       /** 退款监控-显示所有退款信息*/
        public static final String QUERY_REFUNDS = basePath + orderPath + "queryRefunds";
        
        /** 更新退款状态为解冻（解锁）*/
        public static final String UPDATE_REFUND_STATUS = basePath + orderPath + "updatePaymentStatus";
        
        /** 导出退款信息(CVS)*/
        public static final String EXPORT_REFUNDS_BY_CVS = basePath + orderPath + "exportRefundsByCsv";
        
        /** 导出支付信息(CVS)*/
        public static final String EXPORT_PAYMENTS_BY_CVS = basePath + orderPath + "exportPaymentsByCsv";
        
        /** 落地并保存退款信息(新建退款信息表)*/
        public static final String REFUND = basePath + orderPath + "refund";
        
        /** 取得可退信息*/
        public static final String PAY_AMOUNT_INFO = basePath + orderPath + "getAmountInfo";
        
        /** 是否满足主单支付条件*/
        public static final String IS_CAN_MAIN_PAY = basePath + orderPath + "isCanMainPay/{opType}";
        
        /** 订单支付数*/
        public static final String GET_ORDER_PAY_COUNT = basePath + orderPath + "getOrderPayCount/{orderNo}";
        public static final String REPEAT_REFUND = basePath + orderPath + "repeatRefund/{paymentNo}/{refundRemark}";
        
        /** 去退款（回显示退款信息）*/
        public static final String TO_REFUND = basePath + orderPath + "toRefund";
        
        /**  退款回调，回填成功/失败的信息到订单上并更新订单退款信息表中的数据(更新退款信息表)*/
        public static final String REFUND_CALLBACK = basePath + orderPath + "getPaymentInfo";
        /**保存线上退款信息*/
        public static final String SAVE_ORDER_ONLINE_REFUND_INFO = basePath + orderPath + "saveOrderOnlineRefundInfo";
        /**保存线下退款信息*/
        public static final String SAVE_ORDER_OFFLINE_REFUND_INFO = basePath + orderPath + "saveOrderOfflineRefundInfo";
        /**查询退款信息*/
        public static final String QUERY_ORDER_REFUND_INFO = basePath + orderPath + "queryOrderRefundInfo";
        
        /**根据订单Id查询退款信息*/
        public static final String QUERY_ORDER_REFUND_INFO_BYORDERID = basePath + orderPath + "queryOrderRefundsByOrderId";
        /** 人工同步供应商退废票信息 */ 
        public static final String MANUAL_SYNC_SUPP_RTVT = basePath + suppOrderPath + "manualSyncSuppRTVT/{orderId}/{suppRefundNo}";
        
        /** 供应商订单退废票信息同步 */
        //public static final String SUPP_ORDER_REFUND_SYNC = basePath + suppOrderPath + "syncSuppOrderRefund/{suppRefundNo}";
        
        /** 供应商订单退废票信息同步 */
        public static final String SUPP_ORDER_REFUND_SYNC = basePath + suppOrderPath + "syncSuppOrderRefund";
        
		/** 根据供应商订单No同步订单信息 */
		public final static String SYNC_ORDER_BY_SUPP_ORDER_NO = basePath+orderPath+"syncOrderbySuppOrderNo/{suppOrderNo}";
		public final static String GET_SUPP_ORDER_BY_SUPP_ORDER_NO = basePath+orderPath+"getSuppOrderbySuppOrderNo/{suppOrderNo}";
		/** 验证供应商订单的支付状态*/
		public final static String CHECK_SUPP_ORDER_STATUS_BY_ORDER_ID = basePath+orderPath+"checkSuppOrderStatusByOrderId/{orderId}";
		/** 供应商支付*/
		public final static String SUPP_ORDER_PAY = basePath+orderPath+"suppOrderPay/{orderId}";
        /** 同步供应商支付*/
		public final static String SYNC_SUPP_ORDER_PAY = basePath+orderPath+"syncSuppOrderPay/{orderId}";
		
        /**根据vst商品Id查询vst基础航班信息*/
        public static final String GET_FLIGHT_INFO_BY_GOODS_ID = basePath + orderPath + "getFlightInfosByGoodsId/{vstGoodsId}";
        
        /**根据vst商品Id查询vst商品信息*/
        public static final String GET_FLIGHT_VST_GOODS_BY_GOODS_ID = basePath + orderPath + "getFlightVstGoodsByGoodsId/{vstGoodsId}";
        
//        public static final String GET_POLICY_DETAIL_BY_ID = orderPath + "getPolicyDetailById/{policyId}";
//        
//        /** 根据航班信息获取政策信息*/
//        public static final String GET_POLICY_BY_FLIGHT_INFO = basePath + orderPath + "getFlightPolicyByFlightInfo";
//        
//        /** 查询政策列表*/
//        public static final String QUERY_POLICY_LIST = basePath + orderPath + "queryPolicyList";
//        
//        /** 查询不适用政策的航班*/
//        public static final String QUERY_POLICY_EXCLUDE_LIST = basePath + orderPath + "getPolicyExclude/{policyId}";
//        
//        /** 删除不适用政策的航班*/
//        public static final String DELETE_POLICY_EXCLUDE = basePath + orderPath + "deletePolicyExclude";
        
        /**根据vst订单信息查询机票主单信息*/
        public static final String QUERY_ORDER_MAIN_BY_VST_ORDER_INFO = basePath + orderPath +"queryOrderMainByVstOrderInfo";
        
        /**根据主单No查询主订单信息*/
        public static final String GET_ORDER_MAIN_BY_NO = basePath + orderPath +"queryOrderMainByNo/{orderNo}";
        
        /**根据子单No查询主订单信息*/
        public static final String GET_ORDER_BY_NO = basePath + orderPath +"queryOrderByNo/{orderNo}";
        
        /**批量保存vst机票订单关系信息*/
        public static final String SAVE_BATCH_FLIGHT_ORDER_VST_INFO = basePath + orderPath + "saveBatchFlightOrderVstInfo";
        
        /**根据vst信息查询机票订单支付信息*/
        public static final String QUERY_ORDER_PAYMENT_INFO_BY_VST_ORDER_INFO = basePath + orderPath + "queryOrderPaymentInfoByVstOrderInfo";
        
        /** 解除绑定VST航班号*/
        public static final String  UNBINDING_VST_ORDER= basePath + orderPath + "unbindingVstOrder";
        
        /**绑定VST航班号*/
        public static final String BINDING_VST_ORDER = basePath + orderPath + "bindingVstOrder";
        
        /**生成结算单*/
        public static final String CREATE_SETTLEMENT = basePath + orderPath + "createSettlement";
        
        
        /**生成结算单URL测试*/
        public static final String CREATE_SETTLEMENT_TEST = basePath + orderPath + "createSettlement/{orderId}";
        
        
        /**根据票号查询乘机人、航班等相关信息*/
		public final static String  QUERY_ORDER_TICKET_INFO = basePath + ticketPath +"queryOrderTicket/{ticketNo}/{orderNo}";
        
		public static final String QUERY_BINDING_ORDER_MAIN_BY_VST_ORDER_INFO = basePath +orderPath + "queryBindingOrderMainByVstOrderInfo";
		
		 /**短信发送测试*/
        public static final String FLIGHT_SMS = basePath  + "flightSms/{orderId}/{smsTypeName}";
        public static final String NOTIFY_PAY_SMS = basePath  + "flightSms/sendNotifyPaySms";
        public static final String GET_SMS_CONTENT = basePath  + "getSmsContent/{orderId}/{smsTypeName}";
        public static final String SEND_SMS = basePath  + "sendSms";
        /**针对特定政策，支付后发送出票相关的提示短信*/
        public static final String NOTIFY_ISSUE_AFTER_PAY_SMS = basePath  + "flightSms/sendNotifyIssueAfterPaySms";
        
        public static final String BINDING_SALES_ORDER = basePath + orderPath + "bindingSalesOrder";
        
        public static final String UNBINDING_SALES_ORDER = basePath + orderPath + "unbindingSalesOrder";
		
        public static final String SAVE_FLIGHT_ORDER_SALES_ORDER_RELATION = basePath + orderPath + "saveFlightOrderSalesOrderRelation";
        
        public static final String QUERY_BINDING_ORDER_MAIN_BY_ORDER_RELATION = basePath + orderPath + "queryBindingOrderMainByOrderRelation";
        
        public static final String QUERY_ORDER_PAYMENT_INFO_BY_SALES_ORDER_RELATION = basePath + orderPath + "queryOrderPaymentInfoBySalesOrderRelation";

        public static final String QUERY_DETAIL_VIEW_LIST_BY_SALES_ORDERRELATION = basePath + orderPath + "queryDetailViewListBySalesOrderRelation";

        /** 查询短信日志列表 */
        public static final String QUERY_SMS_LOG_LIST = basePath+"sms/querySmsLogList";
        
        /** 保存需发送的短信信息*/
        public static final String SAVE_SMS = basePath+"sms/saveSms";
        
        /** 查询需发送的短信信息*/
        public static final String QUERY_SMSES = basePath+"sms/querySmses";
        
        /** 短信群发*/
        public static final String SMS_GROUP_SEND = basePath+"sms/smsGroupSend/{id}";
        
        /** 短信批量群发*/
        public static final String BATCH_SMS_GROUP_SEND = basePath+"sms/batchSmsGroupSend";
        
        /** 查询操作日志列表 */
        public final static String QUERY_OP_LOG_LIST_BY_CONDITION=basePath+configPath+"queryOpLogListByCondition";
        
        public final static String QUERY_VST_SYNC_CONFIG_DATAS = basePath+configPath+"queryVSTSyncConfigDatas";
        
        public final static String RESET_VST_SYNC_CONFIG_STATUS = basePath + configPath+"resetVSTSyncConfigStatus";
        
        public final static String QUERY_VST_PRODUCTS = basePath + configPath +"queryVstProducts";
        
        public final static String QUERY_VST_GOODS = basePath + configPath +"queryVstGoods";
        
        public final static String QUERY_VST_GOODS_TIME_PRICES = basePath + configPath +"queryVstGoodsTimePrices";
        
        public final static String QUERY_VST_TRAFFIC_FLIGHTS = basePath + configPath +"queryVstTrafficFlights";
        
        public final static String QUERY_VST_PRODUCT_BRANCHES = basePath +configPath +"queryVstProductBranches";
        
        public final static String QUERY_VST_BASIC_FLIGHTS = basePath + configPath +"queryVstBasicFlights";
        
        public final static String QUERY_VST_TASK_CONFIGS = basePath + configPath +"queryVstTaskConfigs";
        
        public final static String SAVE_VST_TASK_CONFIG = basePath + configPath +"saveVstTaskConfig";
        
        public final static String GET_VST_TASK_CONFIG_BY_ID = basePath + configPath + "getVstTaskConfigById/{id}";
        /** 重新下单前验舱验价 */
        public final static String VERIFY_BOOKING_AGAIN = basePath + "verifyBookingAgain";
        /** 重新下单 */
        public final static String BOOKING_AGAIN = basePath + "bookingAgain";
        /** 重新下单(NEW) */
        public final static String BOOKING_AGAIN_NEW = basePath + "bookingAgainNew";
        /** 航班运价管理-----Start */
        public final static String QUERY_FLIGHT_PRICE_POLICY_LIST = basePath + pricePath + "queryFlightPricePolicyList";
        public final static String GET_FLIGHT_PRICE_POLICY_BY_ID = basePath + pricePath + "getFlightPricePolicyById/{pricePolicyId}";
        public final static String BATCH_DEL_FLIGHT_PRICE_POLICY =  basePath + pricePath + "batchDelFlightPricePolicy";
        public final static String QUERY_FLIGHT_PRICE_INVENTORY_LIST =  basePath + pricePath + "queryFlightPriceInventoryList";
        public final static String BATCH_DEL_FLIGHT_PRICE_INVENTORY =  basePath + pricePath + "batchDelFlightPriceInventory";
        public final static String QUERY_FLIGHT_PRICE_INFO_LIST = basePath + pricePath + "queryFlightPriceInfoList";
        public final static String BATCH_DEL_FLIGHT_PRICE_INFO =  basePath + pricePath + "batchDelFlightPriceInfo";
        /** 航班运价管理-----End */
        
        /** 保存禁售规则 */
        public final static String SAVE_SALES_RULE_DISABLE = basePath + salesPath+"saveSalesRuleDisable";
        /** 查询禁售规则列表 */
        public final static String QUERY_SALES_RULE_DISABLE = basePath + salesPath+"querySalesRuleDisable";
         /** 根据ID查询指定禁售规则 */
        public final static String GET_SALES_RULE_DISABLE = basePath + salesPath+"getSalesRuleDisable";
        
        /**营销调控规则管理-----Start*/
        /** 保存营销调控规则 */
        public final static String SAVE_SALES_RULE_SOURCE = basePath + salesPath+ "saveSalesRuleSource";
        /** 修改营销调控规则的状态 */
        public final static String UPDATE_SALES_RULE_SOURCE = basePath + salesPath+ "updateSalesRuleSource";
        /** 删除营销调控规则 */
        public final static String BATCH_DELETE_SALES_RULE_SOURCE = basePath + salesPath+ "batchDeleteSalesRuleSource";
        /** 查询营销调控规则详情 */
        public final static String GET_SALES_RULE_SOURCE_BY_ID = basePath + salesPath+ "getSalesRuleSource/{id}";
        /** 查询营销调控列表 */
        public final static String QUERY_SALES_RULE_SOURCE = basePath + salesPath+ "querySalesRuleSource";
        /**营销调控规则管理-----end*/
        
        /**虚拟调控规则管理-----Start*/
   	 	/** 保存虚拟调控规则 */
        public final static String SAVE_SALES_RULE_SUPP = basePath + salesPath+ "saveSalesRuleSupp";
        /** 修改虚拟调控规则的状态 */
        public final static String UPDATE_SALES_RULE_SUPP = basePath + salesPath+ "updateSaleRuleSupp";
        /** 删除虚拟调控规则 */
        public final static String BATCH_DELETE_SALES_RULE_SUPP = basePath + salesPath+ "batchDeleteSaleRuleSupp";
        /** 查询虚拟调控规则详情 */
        public final static String GET_SALES_RULE_SUPP_BY_ID = basePath + salesPath+ "getSalesRuleSupp/{id}";
        /** 查询虚拟调控列表 */
        public final static String QUERY_SALES_RULE_SUPP = basePath + salesPath+ "querySalesRuleSupp";
        /**虚拟调控规则管理-----end*/
        
        /** 查询所有的航空公司机场 */
        public final static String QUERY_AIRPORT_LIST = basePath+"md/queryAirportList";
        
        /** 查询结算单列表*/  
        public final static String QUERY_SETTLEMENT_ORDER_LIST = basePath + orderPath + "querySettlementOrderList";
        
        /** 查询结算单列表*/  
        public final static String SEND_SETTLEMENT_ORDER_TO_VST = basePath + orderPath + "sendSettlementOrderToVst";
        
        /** 生成结算单**/
        public static final String SAVE_SETTLEMENT_ORDER = orderPath+"settlement/saveSettlementOrder/{orderId}";
        
        /** 批量生成结算单**/
        public static final String BATCH_SAVE_SETTLEMENT_ORDER = orderPath+"settlement/batchSaveSettlementOrder";
        
        /** 批量推送结算单**/
        public static final String BATCH_SEND_SETTLEMENT_ORDER_TO_VST = orderPath+"settlement/batchSendSettlementOrderToVst";
      
        /**通知规则信息管理-----Start*/
   	 	/** 保存通知规则信息*/
        public final static String SAVE_NOTICE_INFO = basePath + configPath+ "saveNoticeInfo";
        /** 修改通知规则信息*/
        public final static String UPDATE_NOTICE_INFO = basePath + configPath+ "updateNoticeInfo";
        /** 删除通知规则信息 */
        public final static String DELETE_NOTICE_INFO = basePath + configPath+ "deleteNoticeInfo";
        /** 查询通知规则信息详情 */
        public final static String GET_NOTICE_INFO_BY_ID = basePath + configPath+ "getNoticeInfoById/{id}";
        /** 查询通知规则信息 */
        public final static String QUERY_NOTICE_INFO = basePath + configPath+ "queryNoticeInfo";
        /** 查询通知规则信息 */
        public final static String GET_NOTICE_INFO = basePath + configPath+ "getNoticeInfo";
        /** 定时同步任务，查询通知规则信息存入缓存 */
        public final static String SYNC_NOTICE_INFO_CACHE = basePath + configPath+ "syncNoticeInfoCache";
        /**通知规则信息管理-----end*/
        
        /**携程改签业务-----start*/
        /** 验证供应商国内机票可退票/改签查询 */
        public final static String FIND_SUPP_TICKET_CTMT_APPLY = basePath + flightPath + "findSuppTicketCTMTApply";
        /** 可改签后搜索可改签航班列表页 */
        public final static String SEARCH_SUPP_CHANGE_FLIGHT_INFO_APPLY = basePath + flightPath + "searchSuppChangeFlightInfoApply";
        /** 根据选择的变更航班,并进行落地 */
        public final static String FINISH_FLIGHT_CHANGE_APPLY = basePath + flightPath + "finishFlightChangeApply";
        /** 供应商改签申请 */
        public final static String AUTO_CHANGE_APPLY = basePath + flightPath + "autoChangeApply";
        /** 根据订单ID同步供应商改签票信息 */
        public final static String SYNC_CTMT_TICKET_BY_SUPP_ORDER = basePath + orderPath + "syncCtmtTicketbySuppOrder/{orderId}";
        /**携程改签业务-----end*/

		public final static String APPLY_CHANGE = basePath + flightPath + "applyChange";

		public final static String ORDER_FLIGHT_CHANGE_NOTIFY = basePath + orderPath + "orderFlightChange";
		public final static String QUERY_ORDER_FLIGHT_CHANGE_INFO_LIST = basePath + orderPath + "queryFlightChangeInfoList";
		
		/**启动自动查找seatclasscode的程序*/
		public final static String AUTO_START_GET_SEAT_CLASS_CODE = basePath+ "startGetSeatclassCode";
	
		/** 根据订单ID修改下单账号类型*/
		public final static String UPDATE_ORDER_FLAG_BY_ORDER_ID=basePath+orderPath+"updateOrderFlagByOrderId/{orderId}/{orderFlag}";
		
		/** 根据订单ID号修改T_FORD_ORDER_STATUS的订单取消状态  ORDER_BACK_STATUS 订单后台状态   也要改为NORMAL*/
		public final static String UPDATE_ORDER_CANCEL_BY_ORDER_ID=basePath+orderPath+"updateOrderCancelByOrderId/{orderId}/{cancelStatus}";
		
		/** 根据订单ID修改订单支付金额*/
		public final static String UPDATE_PAY_AMOUNT_BY_ORDER_ID=basePath+orderPath+"updatePayAmountByOrderId/{orderId}/{orderDirectReductionAmount}";

		/** TASK#31510:后台订单自动直减 */
		public final static String AUTO_MINUS_FLIGHT_ORD_PRICE = basePath+orderPath+"autoMinusFlightOrdPrice";
		
		public final static String VIEW_TICKET_RULES = basePath + "viewTicketRule"; 
		
		public final static String VIEW_PRODUCT_PRICES = basePath + "viewProductPrice";
		
		public final static String SUPP_BOOKING = basePath + "suppBooking";	

		public final static String OP_VALID_BY_ORDER_ID = basePath+orderPath+"isCanPayByOrderId/{orderMainId}/{orderId}/{opType}";
	    
		/** 根据订单ID修改供应商信息*/
		public final static String UPDATE_SUPP_ORDER_SUPP_BY_ORDER_ID=basePath+orderPath+"updateSuppOrderSuppByOrderId/{orderId}/{suppCode}"; 
		/**-----保险公共业务服务----*/
		/**自动投保*/
        public static final String SINGLE_INSURANCE = basePath + insurancePath + "singleInsurance";
        /**人工投保*/
        public static final String ARTIFICIAL_TINSURANCE = basePath + insurancePath + "artificialInsurance";
        
        /**同步分销机票订单状态*/
        public static final String DIST_SYNC_ORDER_STATUS = basePath + "distributor/syncStatus";
        public static final String DIST_GET_TNTID = basePath + "distributor/getTntId";
        public static final String DIST_GET_ORDERNO_BY_REFUNDNO = basePath + "distributor/getFlightOrderNoByRefundNo/{refundNo}/{refundAmount}";
        
        public static final String AUTO_XE_PNR = orderPath + "autoXePnr";

        public static final String GET_COUPON_SWITCH = basePath + "getCouponSwitch";

		/** 订单导入 **/
		public static final String QUERY_ORDER_IMPORT_LIST = basePath + orderPath + "importList";
		public static final String QUERY_ORDER_IMPORT_RECORD_LIST = basePath + orderPath + "importRecordList";

	}
	
	private BussinessClientPath(String path, String cnName) {
		this.path = path;
		this.cnName = cnName;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getCnName() {
		return cnName;
	}

	public String url(String baseUrl){
		if(!baseUrl.contains("http")){
			baseUrl = CustomizedPropertyPlaceholderConfigurer.getContextProperty(baseUrl);
		}
		if(baseUrl.endsWith("/")){
			return baseUrl+this.path;
		}
		return baseUrl+"/" +this.path;
	}
	
	public String url(String baseUrl,Object... args){
		String url = url(baseUrl);
		String pat="\\{\\w*\\}";
		return String.format(url.replaceAll(pat,"%s"),args);
	}
}
