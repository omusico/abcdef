package com.lvmama.vst.back.order.po;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.vst.back.biz.po.BizEnum;
import com.lvmama.vst.back.goods.po.SuppGoods;
import com.lvmama.vst.back.goods.po.SuppGoodsBaseTimePrice;
import com.lvmama.vst.back.prod.po.ProdProduct;
import com.lvmama.vst.back.wifi.po.OrdOrderWifiPickingPoint;
import com.lvmama.vst.comm.utils.DateUtil;
import com.lvmama.vst.comm.utils.order.PriceUtil;
import com.lvmama.vst.comm.vo.order.BuyInfo.HotelcombOption;
import com.lvmama.vst.comm.vo.order.BuyInfo.Item;

/**
 * @author 
 *
 */
public class OrdOrderItem implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 7931108218080321331L;

	private Long orderItemId;

	private Long orderId;

	private Long categoryId;

	private Long branchId;

	private Long contractId;

	private Long orderPackId;

	private OrdOrderPack orderPack;

	private Long suppGoodsId;

	private String mainItem;

	private String productName;
	
	private Long price; //商品的销售价格

	private Long actualSettlementPrice;

	private Long settlementPrice; //商品的结算价

	private Long quantity; //商品的数量

	private Long totalSettlementPrice;

	private Date visitTime;

	private String needResourceConfirm;

	private String resourceStatus;

	private String infoStatus;

	private Long marketPrice;

	private String performStatus;

	private String performStatusCode;

	private String cancelStrategy;//退改类型

	private String content;

	private String settlementStatus;

	private String suppGoodsName;

	private Long productId;

	private Long supplierId;


	private String deductType;

	private SuppGoods suppGoods;
	

	/**
	 * 后台用户备注
	 */
	private String orderMemo;


	private String ticketType;
	private String paymentStatus;
	private String orderStatus;

	/**
	 * 凭证确认状态
	 */
	private String certConfirmStatus;

	/**
	 * 取消凭证确认
	 */
	private String cancelCertConfirmStatus;
	/**
	 * 扣款金额
	 */
	private Long deductAmount;

	private Date lastCancelTime;

	/**
	 * 提前预订时间,该值不存储到订单
	 */
	private transient Date aheadTime;

	private String bookLimitType;
	
	/**
	 * 供应商产品名称
	 */
	private String suppProductName;
	
	/**
	 * 订单库存表
	 */
	private List<OrdOrderStock> orderStockList;

	/**
	 * 酒店类订单专用的每天使用状况时间表
	 */
	private List<OrdOrderHotelTimeRate> orderHotelTimeRateList;
	
	/***
	 * wifi订单每天使用情况时间表
	 */
	private List<OrdOrderWifiTimeRate> ordOrderWifiTimeRateList;
	
	/***
	 * wifi网点信息
	 */
	private OrdOrderWifiPickingPoint   ordOrderWifiPickingPoint;
	
	private List<OrdOrderWifiPickingPoint> ordOrderWifiPickingPointList;


	/**
	 * 优惠关系列表
	 */
	private List<OrdPromotion> ordPromotionList;

	/**
	 * content 的json原数据
	 */
	private Map<String,Object> contentMap = new HashMap<String, Object>();

	private List<OrdItemPersonRelation> ordItemPersonRelationList;

	private List<OrdMulPriceRate> ordMulPriceRateList;
	
	/**
	 * 促销修改结算价记录
	 */
	private List<OrdSettlementPriceRecord> ordSettlementPriceRecordList;
	/**
	 * 总价
	 */
	private Long totalAmount;
	
	/**
	 * 时间价格表:默认支付等待时间时使用
	 * */
	private SuppGoodsBaseTimePrice suppGoodsTimePrice;
	
	private String categoryName;
	
	private List<OrdPassCode> ordPassCodeList;
	
	private String subProcessKey;

	public List<OrdPassCode> getOrdPassCodeList() {
		return ordPassCodeList;
	}

	public void setOrdPassCodeList(List<OrdPassCode> ordPassCodeList) {
		this.ordPassCodeList = ordPassCodeList;
	}
	//产品经理ID
	private Long managerId;
	
	private String buCode;

    //底单库存列表（加了共享组信息
    private List<OrdOrderSharedStock> sharedStockList;

	/**
	 * 主订单下单时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date orderUpdateTime;
	/**
	 * 供应商名称
	 */
	private String supplierName;

	/**
	 * 销售总价
	 */
	private Double oughtAmount;
	
	
	private Long attributionId;//归属地 


	private String realBuType; //真实BU

	private String refundRules;	//退改规则（json 快照)
	
	//调用对接平台的状态
	private String invokeInterfacePfStatus;
	
	//资源审核时间
	private Date resourceAmpleTime;
	
	//信息审核时间
	private Date infoPassTime;
	/**
	 * 快递处理状态Y|N
	 */
	private String courierStatus;
	
	/**
	 * 公司主体
	 * @see ProdProduct.COMPANY_TYPE_DIC
	 */
	private String companyType;
	

	private Item  item;
	
	/**
	 * 该买断商品的数量
	 */
	private Long buyoutQuantity;
	
	/**
	 * 该买断商品的单价
	 */
	private Long buyoutPrice;
	
	private Long buyoutTotalPrice;
	/**
	 * 是否是买断商品
	 */
	private String buyoutFlag;
	
	private Long notBuyoutSettleAmout;
	/**
	 * 不能及时入园标志
	 */
	private String notInTimeFlag;
	
	/**
	 * 是否需要信息审核,默认需要
	 */
	private boolean infoPassNeedConfirm = true;
	
	/**
	 * 是否保留房
	 */
	private String stockFlag;
	
	/**
	 * 通关信息是否是PDF
	 */
	private String codeImagePdfFlag;
	
	/**
	 * PDF文件ID
	 */
	private Long pdfFileId;
	
	/**
	 * 结构化酒店套餐,具体选择规格
	 */
	private List<HotelcombOption> hotelcombOptions;
	
	/**
	 * 上海迪士尼 剧场票控件信息
	 */
	  private String disneyOrderInfo;
	
	public boolean getInfoPassNeedConfirm() {
		if(!this.hasContentValue("is_to_foreign", "Y") //目的地不是国外
				&& !this.hasContentValue("is_from_foreign", "Y")){
			infoPassNeedConfirm = false;
		}
		return infoPassNeedConfirm;
	}

	public void setInfoPassNeedConfirm(boolean infoPassNeedConfirm) {
		this.infoPassNeedConfirm = infoPassNeedConfirm;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Date getResourceAmpleTime() {
		return resourceAmpleTime;
	}
	
	public void setResourceAmpleTime(Date resourceAmpleTime) {
		this.resourceAmpleTime = resourceAmpleTime;
	}

	public Date getInfoPassTime() {
		return infoPassTime;
	}

	public void setInfoPassTime(Date infoPassTime) {
		this.infoPassTime = infoPassTime;
	}
	
	public String getInvokeInterfacePfStatus() {
		return invokeInterfacePfStatus;
	}

	public void setInvokeInterfacePfStatus(String invokeInterfacePfStatus) {
		this.invokeInterfacePfStatus = invokeInterfacePfStatus;
	}

	public String getBuCode() {
		return buCode;
	}

	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}

	public Long getAttributionId() {
		return attributionId;
	}

	public void setAttributionId(Long attributionId) {
		this.attributionId = attributionId;
	}

	public String getRealBuType() {
		return realBuType;
	}

	public void setRealBuType(String realBuType) {
		this.realBuType = realBuType;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getOrderPackId() {
		return orderPackId;
	}

	public void setOrderPackId(Long orderPackId) {
		this.orderPackId = orderPackId;
	}

	public Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	public String getMainItem() {
		return mainItem;
	}

	public void setMainItem(String mainItem) {
		this.mainItem = mainItem;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getActualSettlementPrice() {
		return actualSettlementPrice;
	}

	public void setActualSettlementPrice(Long actualSettlementPrice) {
		this.actualSettlementPrice = actualSettlementPrice;
	}

	public Long getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(Long settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Long getDeductAmount() {
		return deductAmount;
	}

	public void setDeductAmount(Long deductAmount) {
		this.deductAmount = deductAmount;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getTotalSettlementPrice() {
		return totalSettlementPrice;
	}

	public void setTotalSettlementPrice(Long totalSettlementPrice) {
		this.totalSettlementPrice = totalSettlementPrice;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public String getNeedResourceConfirm() {
		return needResourceConfirm;
	}

	public void setNeedResourceConfirm(String needResourceConfirm) {
		this.needResourceConfirm = needResourceConfirm == null ? null : needResourceConfirm.trim();
	}

	public String getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(String resourceStatus) {
		this.resourceStatus = resourceStatus == null ? null : resourceStatus.trim();
	}

	public String getInfoStatus() {
		return infoStatus;
	}

	public void setInfoStatus(String infoStatus) {
		this.infoStatus = infoStatus == null ? null : infoStatus.trim();
	}

	public Long getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Long marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getPerformStatus() {
		return performStatus;
	}

	public void setPerformStatus(String performStatus) {
		this.performStatus = performStatus == null ? null : performStatus.trim();
	}

	public String getPerformStatusCode() {
		return performStatusCode;
	}

	public void setPerformStatusCode(String performStatusCode) {
		this.performStatusCode = performStatusCode == null ? null : performStatusCode.trim();
	}

	public String getCancelStrategy() {
		return cancelStrategy;
	}

	public void setCancelStrategy(String cancelStrategy) {
		this.cancelStrategy = cancelStrategy == null ? null : cancelStrategy.trim();
	}

	public String getContent() {
		if (contentMap != null && contentMap.size() != 0) {
			JSONObject json = JSONObject.fromObject(contentMap);
			this.content = json.toString();
		} else {
			content = null;
		}
		return content;
	}

	public Date getLastCancelTime() {
		return lastCancelTime;
	}

	public void setLastCancelTime(Date lastCancelTime) {
		this.lastCancelTime = lastCancelTime;
	}

	public String getBookLimitType() {
		return bookLimitType;
	}

	public void setBookLimitType(String bookLimitType) {
		this.bookLimitType = bookLimitType;
	}

	public void putContent(String key,Object value){
		if(value!=null){
			contentMap.put(key, value);
		}
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Map<String, Object> getContentMap() {
		return contentMap;
	}

	public Object getContentValueByKey(String key) {
		Object value = null;
		if (contentMap != null) {
			value = contentMap.get(key);
		}

		return value;
	}

	public String getContentStringByKey(String key){
		Object obj=getContentValueByKey(key);
		if(obj==null){
			return null;
		}else{
			return obj.toString();
		}
	}

	@SuppressWarnings("unchecked")
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
		JSONObject json = JSONObject.fromObject(content);
		contentMap = (Map<String,Object>)JSONObject.toBean(json,HashMap.class);
	}

	public String getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus == null ? null : settlementStatus.trim();
	}

	public String getSuppGoodsName() {
		return suppGoodsName;
	}

	public void setSuppGoodsName(String suppGoodsName) {
		this.suppGoodsName = suppGoodsName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public List<OrdOrderStock> getOrderStockList() {
		return orderStockList;
	}

	public void setOrderStockList(List<OrdOrderStock> orderStockList) {
		this.orderStockList = orderStockList;
	}

	public List<OrdOrderHotelTimeRate> getOrderHotelTimeRateList() {
		return orderHotelTimeRateList;
	}

	public void setOrderHotelTimeRateList(List<OrdOrderHotelTimeRate> orderHotelTimeRateList) {
		this.orderHotelTimeRateList = orderHotelTimeRateList;
	}

	public boolean hasMainItem(){
		return "true".equalsIgnoreCase(mainItem);
	}

	public boolean isRoomReservations() {
		boolean isRoomReservations =false;
		OrdOrderStock orderStock = null;

		if ("true".equals(mainItem) && orderStockList != null) {
			int i = 0, num = 0;
			for (; i < orderStockList.size(); i++) {
				orderStock = orderStockList.get(i);
				if (orderStock == null) {
					break;
				}

				if (!OrderEnum.INVENTORY_STATUS.INVENTORY.name().equals(orderStock.getInventory())) {
					break;
				} else {
					num++;
				}
			}

			if (num == orderStockList.size()) {
				isRoomReservations = true;
			}
		}

		return isRoomReservations;
	}
	
	@JsonIgnore
	public String getRoomReservations() {
		OrdOrderStock orderStock = null;
		
		if (orderStockList != null) {
			int num = 0, allCount = 0, nonCount = 0;	//非保留房个数
			for (int i = 0; i < orderStockList.size(); i++) {
				orderStock = orderStockList.get(i);
				if (orderStock == null) {
					break;
				}
				num++;
				if (OrderEnum.INVENTORY_STATUS.INVENTORY.name().equals(orderStock.getInitInventory())) {
					allCount++;
				}
				if (OrderEnum.INVENTORY_STATUS.UNINVENTORY.name().equals(orderStock.getInitInventory())) {
					nonCount++;
				}
			}
			
			if(num > 0){
				if(num == nonCount){
					return "non";
				} else if (num == allCount) {
					return "all";
				} else {
					return "part";
				}
			}
			return "";
		}
		
		return "";
	}
	
	public String getPriceYuan(){
		return PriceUtil.trans2YuanStr(price);
	}

	public String getMarketPriceYuan(){
		return PriceUtil.trans2YuanStr(marketPrice);
	}

	public String getTotalPriceYuan() {
		return PriceUtil.trans2YuanStr(price * quantity);
	}

	public String getDeductType() {
		return deductType;
	}

	public void setDeductType(String deductType) {
		this.deductType = deductType;
	}

	public List<OrdPromotion> getOrdPromotionList() {
		return ordPromotionList;
	}

	public void setOrdPromotionList(List<OrdPromotion> ordPromotionList) {
		this.ordPromotionList = ordPromotionList;
	}

	public String getCertConfirmStatus() {
		return certConfirmStatus;
	}

	public void setCertConfirmStatus(String certConfirmStatus) {
		this.certConfirmStatus = certConfirmStatus;
	}

	public String getCancelCertConfirmStatus() {
		return cancelCertConfirmStatus;
	}

	public void setCancelCertConfirmStatus(String cancelCertConfirmStatus) {
		this.cancelCertConfirmStatus = cancelCertConfirmStatus;
	}

	public String getDeductAmountToYuan(){
		if(null==deductAmount){
			return "0";
		}
		return PriceUtil.trans2YuanStr(deductAmount);
	}

	public boolean hasSupplierApi(){
		if(supplierApi==null){
		supplierApi = contentMap.containsKey(OrderEnum.ORDER_COMMON_TYPE.supplierApiFlag.name())
				&& "Y".equalsIgnoreCase(contentMap.get(OrderEnum.ORDER_COMMON_TYPE.supplierApiFlag.name()).toString());
		//logger.info("hasSupplierApi:::::::::::::::::::::::::::::::"+supplierApi);
		}
		return supplierApi;
	}
	
	//是否需要凭证
	public boolean isNeedCertificate() {
		if(hasSupplierApi()) {
			return false;
		}
		String faxFlag = (String)contentMap.get(OrderEnum.ORDER_COMMON_TYPE.fax_flag.name());
		String ebkFlag = (String)contentMap.get(OrderEnum.ORDER_COMMON_TYPE.ebk_flag.name());
		if("Y".equals(faxFlag) || "Y".equals(ebkFlag)) {
			return true;
		}
		String categoryCode = (String)contentMap.get(OrderEnum.ORDER_COMMON_TYPE.categoryCode.name());
		if(BizEnum.BIZ_CATEGORY_TYPE.category_hotel.name().equals(categoryCode)) {
			return true;
		}
		if (BizEnum.BIZ_CATEGORY_TYPE.category_route_group.name().equals(
				categoryCode)
				|| BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.name()
						.equals(categoryCode)
				|| BizEnum.BIZ_CATEGORY_TYPE.category_route_hotelcomb.name()
						.equals(categoryCode)
				|| BizEnum.BIZ_CATEGORY_TYPE.category_route_local.name()
						.equals(categoryCode)) {
			return true;
		}
		
		return false;
	}
	
	private Boolean supplierApi=null;
//	private static final Logger logger = LoggerFactory.getLogger(OrdOrderItem.class);

	public Date getAheadTime() {
		return aheadTime;
	}

	public void setAheadTime(Date aheadTime) {
		this.aheadTime = aheadTime;
	}

	public List<OrdMulPriceRate> getOrdMulPriceRateList() {
		return ordMulPriceRateList;
	}

	public void setOrdMulPriceRateList(List<OrdMulPriceRate> ordMulPriceRateList) {
		this.ordMulPriceRateList = ordMulPriceRateList;
	}

	public String getSubProcessKey(){
		if(subProcessKey == null || "".equals(subProcessKey)){
			String type = (String)contentMap.get(OrderEnum.ORDER_COMMON_TYPE.processKey.name());
			if("sightseeing".equalsIgnoreCase(type)) {
				subProcessKey = type+"_sub";
			}
			subProcessKey = type+"_sub_process";
		}
		return subProcessKey;
	}

	public String getOrderMemo() {
		return orderMemo;
	}

	public void setOrderMemo(String orderMemo) {
		this.orderMemo = orderMemo;
	}

	public List<OrdItemPersonRelation> getOrdItemPersonRelationList() {
		return ordItemPersonRelationList;
	}

	public void setOrdItemPersonRelationList(
			List<OrdItemPersonRelation> ordItemPersonRelationList) {
		this.ordItemPersonRelationList = ordItemPersonRelationList;
	}

	public SuppGoods getSuppGoods() {
		return suppGoods;
	}

	public void setSuppGoods(SuppGoods suppGoods) {
		this.suppGoods = suppGoods;
	}

    public long getChildQuantity() {
    	Object childQuantity = getContentValueByKey(OrderEnum.ORDER_TICKET_TYPE.child_quantity.name());
    	if(null!=childQuantity){
    		return NumberUtils.toLong(childQuantity.toString());
    	}
        return 0L;
    }
    public long getSpreadQuantity() {
    	Object spreadQuantity = getContentValueByKey(OrderEnum.ORDER_COMM_TYPE.room_price_differ.name());
    	if(null!=spreadQuantity){
    		return NumberUtils.toLong(spreadQuantity.toString());
    	}
        return 0L;
    }

    public long getAdultQuantity() {
    	Object adultQuantity = getContentValueByKey(OrderEnum.ORDER_TICKET_TYPE.adult_quantity.name());
    	if(null!=adultQuantity){
    		return NumberUtils.toLong(adultQuantity.toString());
    	}
        return 0L;
    }
    //淘宝电子票
    public long getTBETickets() {//是否淘宝电子票
    	Object TBETicket = getContentValueByKey("taobaoEticket");
    	if(null!=TBETicket){
    		return NumberUtils.toLong(TBETicket.toString());
    	}
        return 0L;
    }

    public Date getValidBeginTime() {
    	String str = getContentStringByKey(OrderEnum.ORDER_TICKET_TYPE.aperiodic_start.name());
    	if(StringUtils.isNotEmpty(str)){
    		return DateUtil.toSimpleDate(str);
    	}
        return null;
    }

    public Date getValidEndTime() {
    	String str = getContentStringByKey(OrderEnum.ORDER_TICKET_TYPE.aperiodic_end.name());
    	if(StringUtils.isNotEmpty(str)){
    		return DateUtil.toSimpleDate(str);
    	}
        return null;
    }

    public String getInvalidDate() {
        return getContentStringByKey(OrderEnum.ORDER_TICKET_TYPE.aperiodic_unvalid.name());
    }


    public String getInvalidDateMemo() {
    	return getContentStringByKey(OrderEnum.ORDER_TICKET_TYPE.aperiodic_unvalid.name());
    }

    public Long getValidDays() {
        Integer validDays = (Integer)getContentValueByKey(OrderEnum.ORDER_TICKET_TYPE.cert_valid_day.name());
        if(validDays==null){
            return 0L;
        }
        return validDays.longValue();
    }

	public OrdOrderPack getOrderPack() {
		return orderPack;
	}

	public void setOrderPack(OrdOrderPack orderPack) {
		this.orderPack = orderPack;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public boolean hasTicketAperiodic(){
		return "Y".equalsIgnoreCase(getContentStringByKey(OrderEnum.ORDER_TICKET_TYPE.aperiodic_flag.name()));
	}
	
	public boolean hasExpresstypeDisplay(){
		
		return SuppGoods.GOODSTYPE.EXPRESSTYPE_DISPLAY.name().equalsIgnoreCase(this.ticketType);
	}
	
	/**
	 * 子订单资源未审核
	 * @return
	 */
	public boolean hasResourceUnverified() {
		return OrderEnum.RESOURCE_STATUS.UNVERIFIED.name().equals(resourceStatus);
	}	
	
	public boolean hasMainBranchAttach(){
		return "Y".equalsIgnoreCase(getContentStringByKey(OrderEnum.ORDER_COMMON_TYPE.branchAttachFlag.name()));
	}
	
	public boolean hasCategory(BizEnum.BIZ_CATEGORY_TYPE type){
		return type.name().equalsIgnoreCase(getContentStringByKey(OrderEnum.ORDER_COMMON_TYPE.categoryCode.name()));
	}
	
	/**
	 * 子订单资源已审核
	 * @return
	 */
	public boolean hasResourceAmple() {
		return OrderEnum.RESOURCE_STATUS.AMPLE.name().equals(resourceStatus);
	}
	
	/**
	 * 子订单资源不满足
	 * @return
	 */
	public boolean hasResourceLock() {
		return OrderEnum.RESOURCE_STATUS.LOCK.name().equals(resourceStatus);
	}
	
	/**
	 * 子订单凭证确认状态
	 * @return true 已确认  false 未确认
	 */
	public boolean hasCertConfirmStatusConfirmed(){
		return OrderEnum.CERT_CONFIRM_STATUS.CONFIRMED.name().equals(certConfirmStatus);
	}

	public String getSuppProductName() {
		return suppProductName;
	}

	public void setSuppProductName(String suppProductName) {
		this.suppProductName = suppProductName;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}	
	
	public boolean hasContentValue(String key,String value){
		String val = getContentStringByKey(key);
		return StringUtils.equals(val, value);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<OrdSettlementPriceRecord> getOrdSettlementPriceRecordList() {
		return ordSettlementPriceRecordList;
	}

	public void setOrdSettlementPriceRecordList(
			List<OrdSettlementPriceRecord> ordSettlementPriceRecordList) {
		this.ordSettlementPriceRecordList = ordSettlementPriceRecordList;
	}

	public SuppGoodsBaseTimePrice getSuppGoodsTimePrice() {
		return suppGoodsTimePrice;
	}

	public void setSuppGoodsTimePrice(SuppGoodsBaseTimePrice suppGoodsTimePrice) {
		this.suppGoodsTimePrice = suppGoodsTimePrice;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	    public List<OrdOrderSharedStock> getSharedStockList() {
        return sharedStockList;
    }

    public void setSharedStockList(List<OrdOrderSharedStock> sharedStockList) {
        this.sharedStockList = sharedStockList;
    }

	public boolean isApiFlightTicket() {
		return this.categoryId == 21 && this.hasSupplierApi();
	}
	
	public boolean isResourceAndInfoPass() {
		return OrderEnum.INFO_STATUS.INFOPASS.name().equalsIgnoreCase(this.infoStatus)
				&& this.hasResourceAmple();
	}

	public String getRefundRules() {
		return refundRules;
	}

	public void setRefundRules(String refundRules) {
		this.refundRules = refundRules;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Double getOughtAmount() {
		return oughtAmount;
	}

	public void setOughtAmount(Double oughtAmount) {
		this.oughtAmount = oughtAmount;
	}
	
	public boolean isSupplierOrderItem() {
		boolean isSupplierOrder = false;
		String supplierApiFlag =  (String) getContentStringByKey(OrderEnum.ORDER_COMMON_TYPE.supplierApiFlag.name());
		if ("Y".equalsIgnoreCase(supplierApiFlag)) {
			isSupplierOrder = true;
		}
		
		if(!isSupplierOrder && StringUtils.equals(getContentStringByKey(OrderEnum.ORDER_TICKET_TYPE.notify_type.name()), SuppGoods.NOTICETYPE.QRCODE.name())){
			isSupplierOrder = true;
		}
		
		if(!isSupplierOrder && StringUtils.equalsIgnoreCase(getContentStringByKey(OrderEnum.ORDER_COMMON_TYPE.processKey.name()), "insurance")){
			isSupplierOrder = true;
		}
		
		return isSupplierOrder;
	}

	public String getCourierStatus() {
		return courierStatus;
	}

	public void setCourierStatus(String courierStatus) {
		this.courierStatus = courierStatus;
	}

	public String getNotInTimeFlag() {
		return notInTimeFlag;
	}

	public void setNotInTimeFlag(String notInTimeFlag) {
		this.notInTimeFlag = notInTimeFlag;
	}

	public Long getBuyoutQuantity() {
		return buyoutQuantity;
	}

	public void setBuyoutQuantity(Long buyoutQuantity) {
		this.buyoutQuantity = buyoutQuantity;
	}

	public Long getBuyoutPrice() {
		return buyoutPrice;
	}

	public void setBuyoutPrice(Long buyoutPrice) {
		this.buyoutPrice = buyoutPrice;
	}

	public List<OrdOrderWifiTimeRate> getOrdOrderWifiTimeRateList() {
		return ordOrderWifiTimeRateList;
	}

	public void setOrdOrderWifiTimeRateList(
			List<OrdOrderWifiTimeRate> ordOrderWifiTimeRateList) {
		this.ordOrderWifiTimeRateList = ordOrderWifiTimeRateList;
	}

	public OrdOrderWifiPickingPoint getOrdOrderWifiPickingPoint() {
		return ordOrderWifiPickingPoint;
	}

	public void setOrdOrderWifiPickingPoint(
			OrdOrderWifiPickingPoint ordOrderWifiPickingPoint) {
		this.ordOrderWifiPickingPoint = ordOrderWifiPickingPoint;
	}

	public List<OrdOrderWifiPickingPoint> getOrdOrderWifiPickingPointList() {
		return ordOrderWifiPickingPointList;
	}

	public void setOrdOrderWifiPickingPointList(
			List<OrdOrderWifiPickingPoint> ordOrderWifiPickingPointList) {
		this.ordOrderWifiPickingPointList = ordOrderWifiPickingPointList;
	}

	public String getBuyoutFlag() {
		return buyoutFlag;
	}

	public void setBuyoutFlag(String buyoutFlag) {
		this.buyoutFlag = buyoutFlag;
	}

	public Long getBuyoutTotalPrice() {
		return buyoutTotalPrice;
	}

	public void setBuyoutTotalPrice(Long buyoutTotalPrice) {
		this.buyoutTotalPrice = buyoutTotalPrice;
	}

	public Long getNotBuyoutSettleAmout() {
		return notBuyoutSettleAmout;
	}

	public void setNotBuyoutSettleAmout(Long notBuyoutSettleAmout) {
		this.notBuyoutSettleAmout = notBuyoutSettleAmout;
	}
	public void setSubProcessKey(String subProcessKey) {
		this.subProcessKey = subProcessKey;
	}

	public Date getOrderUpdateTime() {
		return orderUpdateTime;
	}

	public void setOrderUpdateTime(Date orderUpdateTime) {
		this.orderUpdateTime = orderUpdateTime;
	}

	public String getStockFlag() {
		return stockFlag;
	}

	public void setStockFlag(String stockFlag) {
		this.stockFlag = stockFlag;
	}

	public List<HotelcombOption> getHotelcombOptions() {
		return hotelcombOptions;
	}

	public void setHotelcombOptions(List<HotelcombOption> hotelcombOptions) {
		this.hotelcombOptions = hotelcombOptions;
	}

	public String getCodeImagePdfFlag() {
		return codeImagePdfFlag;
	}

	public void setCodeImagePdfFlag(String codeImagePdfFlag) {
		this.codeImagePdfFlag = codeImagePdfFlag;
	}

	public Long getPdfFileId() {
		return pdfFileId;
	}

	public void setPdfFileId(Long pdfFileId) {
		this.pdfFileId = pdfFileId;
	}

	public String getDisneyOrderInfo() {
		return disneyOrderInfo;
	}

	public void setDisneyOrderInfo(String disneyOrderInfo) {
		this.disneyOrderInfo = disneyOrderInfo;
	}
	
	
}
