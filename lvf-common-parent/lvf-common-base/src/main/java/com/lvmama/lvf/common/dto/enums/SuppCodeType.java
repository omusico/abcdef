package com.lvmama.lvf.common.dto.enums;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public enum SuppCodeType {
	CTRIP("ctrip","ctripLogger") {
		/****************携程**/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.OAE_FlightSearch);
			$(InterfaceKey.OAE_FlightVerify);
			$(InterfaceKey.OAE_FlightSaveOrder);
			$(InterfaceKey.CheckOrderAutobookResult);
			$(InterfaceKey.OAE_ViewOrderListDetails);
			$(InterfaceKey.Common_FlightAlipayV1);
			$(InterfaceKey.OpenCancelOrder);
			$(InterfaceKey.FlightReviseCondition);
			$(InterfaceKey.RescheduleSearch);
			$(InterfaceKey.FlightRebookApplication);
			$(InterfaceKey.FlightReviseCondition);
			$(InterfaceKey.FlightRefundOrder);
			$(InterfaceKey.FlightQueryTicketingOrder);
			return interFaceKeys;
		}
	},
	UNION("union","unionLogger") {
		/****************unionlife（保险）**/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.HesitateCancelInsuranceUnionLifeService);
			$(InterfaceKey.SingleInsuringInsuranceUnionLifeService);
			return interFaceKeys;
		}
	},
	BOOK("51Book","51BookLogger") {
		/****************51book**/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.GetAvailableFlightWithPriceAndCommisionServiceImpl_1_0Service);
			$(InterfaceKey.AVFlightNOServiceImpl_1_0Service);
			$(InterfaceKey.CreateOrderByPassengerServiceImpl_1_0Service);
			$(InterfaceKey.GetDailyLowestPriceServiceImpl_1_0Service);
			$(InterfaceKey.CancelOrderServiceImpl_1_0Service);
			$(InterfaceKey.GetOrderByOrderNoServiceImpl_1_0Service);
			$(InterfaceKey.PayServiceImpl_1_0Service);
			$(InterfaceKey.GetPolicyServiceImpl_1_0Service);
			$(InterfaceKey.SyncPolicyServiceImpl_1_0Service);
			$(InterfaceKey.GetPolicyByIdServiceImpl_1_0Service);
			$(InterfaceKey.GetPolicyAndFareByFlightsServiceImpl_1_0Service);
			$(InterfaceKey.GetChildPolicyAndFlightServiceImpl_1_0Service);
			$(InterfaceKey.ApplyPolicyOrderRefundServiceImpl_1_0Service);
			$(InterfaceKey.GetRefundDetailServiceImpl_1_0Service);
			$(InterfaceKey.GetModifyAndRefundStipulateServiceImpl_1_0Service);
			$(InterfaceKey.GetModifyAndRefundStipulatesServiceImpl_1_0Service);
			return interFaceKeys;
		}
	},
    TRAIN("train","trainLogger") {
		  /***************火车票LOG******/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			  //供应商
			$(InterfaceKey.GetTimetable);
			$(InterfaceKey.FindTrainsByCondition);
			$(InterfaceKey.FindMoreTicketByCondition);
			$(InterfaceKey.CommitTrainOrder);
			$(InterfaceKey.CommitSuppOrder);
			$(InterfaceKey.ValidateCommitSuppOrder);
			$(InterfaceKey.CallbackPayOrder);
			$(InterfaceKey.CallbackOnDrawOrder);
			$(InterfaceKey.SearchOrderDetail);
			$(InterfaceKey.SearchRefundOrderDetail);
			$(InterfaceKey.RefundTicket);
			$(InterfaceKey.CallbackOnRefundOrder);
			// 火车票供应商(大拓)
			$(InterfaceKey.CommitOrderToDaTuo);
			$(InterfaceKey.GetTimetableToDaTuo);
			$(InterfaceKey.CancelOrderToDaTuo);
			$(InterfaceKey.ConfirmTicketToDaTuo);
			$(InterfaceKey.RefundTicketToDaTuo);
			$(InterfaceKey.GetStationToDaTuo);
			$(InterfaceKey.SendSettlement);
			$(InterfaceKey.CommitOrderCallBackToDaTuo);
			$(InterfaceKey.ECHOConfirmTicketToDaTuo);
			$(InterfaceKey.TrainOfflineReturnMoneyNoticeFromDaTuo);
			$(InterfaceKey.CancelOrderCallBackToDaTuo);
			$(InterfaceKey.ConfirmTicketCallBackToDaTuo);
			$(InterfaceKey.RefundTicketCallBackToDaTuo);
			$(InterfaceKey.QueryMoneyToDaTuo);
			$(InterfaceKey.QueryMoneyLogToDaTuo);
			//主站
			$(InterfaceKey.SendRefund);
			$(InterfaceKey.GetPayResult);
			$(InterfaceKey.GetPayPrice);
			$(InterfaceKey.SendSettlement_OP);
			$(InterfaceKey.SendSettlement_RT);
			$(InterfaceKey.CommitInsuranceOrder);
			$(InterfaceKey.CancelInsuranceOrder);
			$(InterfaceKey.PayInsuranceOrder);
			return interFaceKeys;
		}
	},
	VST("vst","vstLogger") {
		/****************VST机票对接**/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.ChangeTraffic);
			$(InterfaceKey.QueryGroupLowerSalePrice);
			$(InterfaceKey.QueryFlightNoVoListByDateAndBranch);
			$(InterfaceKey.CancelFlightOrder);
			$(InterfaceKey.PayFlightOrder);
			$(InterfaceKey.BookingOrderAsync);
			return interFaceKeys;
		}
	},
	FIT("fit","fitLogger") {
		/**************************************Fit Interface Key********/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.SearchHotelFromVst);
			$(InterfaceKey.SearchFlight);
			$(InterfaceKey.SearchSpotTicketFormVst);
			$(InterfaceKey.SearchInsuranceInfoFromVst);
			$(InterfaceKey.SearchSdpProductFromVst);
			$(InterfaceKey.SearchSdpGoodsFromVst);
			$(InterfaceKey.SearchSdpInstalmentFromVst);
			$(InterfaceKey.FIT_BOOKING_VST);
			$(InterfaceKey.FIT_SDP_INDEX_PUSH);
			$(InterfaceKey.FIT_BOOKING_FLIGHT);
			$(InterfaceKey.FIT_AMOUNTCALCULATE_FLIGHT);
			$(InterfaceKey.SearchSdpProductGroupCalendarInfoFromVst);
			return interFaceKeys;
		}
	},
	NA("517Na","517NaLogger") {
		/****************517na**/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.Five17Na_FlightRefundOrder);
			$(InterfaceKey.Five17Na_NewFlightRefundOrder);
			$(InterfaceKey.Five17Na_FlightPayOrder);
			$(InterfaceKey.Five17Na_FlightPolicyQuery);
			$(InterfaceKey.Five17Na_FlightCreateOrder);
			$(InterfaceKey.Five17Na_FlightQueryOrderDetail);
			$(InterfaceKey.Five17Na_FlightCancelPnr);
			$(InterfaceKey.Five17Na_FlightPolicyPushSync_Full);
			$(InterfaceKey.Five17Na_FlightPolicyPushSync_Add);
			return interFaceKeys;
		}
	},
	JZINFO("jzinfo","jzinfoLogger"){

		/****************敬众信息JZINFO**/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.JZINFO_AV);
			$(InterfaceKey.JZINFO_FD);
			$(InterfaceKey.JZINFO_NFD);
			$(InterfaceKey.JZINFO_AVETIME);
		
			return interFaceKeys;
		}
		
	},
	ABE("abe","abeLogger"){
		/****************易思凯ABE**/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.ABE_CreatePNR);
			$(InterfaceKey.ABE_PATByFlights);
			$(InterfaceKey.ABE_ETDZ);
			$(InterfaceKey.ABE_RTPNR);
			$(InterfaceKey.ABE_XEPNR);
			$(InterfaceKey.ABE_DETR);
			$(InterfaceKey.ABE_ETRY);

			return interFaceKeys;
		}
		
	},
	XINYIZHAN("XinYiZhan","XinYiZhanLogger") {
		/****************众安（保险）**/
		public List<InterfaceKey> getInterFaceKey() {
			interFaceKeys.clear();
			$(InterfaceKey.HesitateCancelInsuranceZhongAnService);
			$(InterfaceKey.SingleInsuringInsuranceZhongAnService);
			$(InterfaceKey.GetOrderUndWrResultZhongAnService);
			return interFaceKeys;
		}
	};
	
	private SuppCodeType(String cnName,String coreName) {
		this.cnName = cnName;
		this.coreName=coreName;
	}

	private String cnName;
	//core的名字
	private String coreName;
	//interFaceKey归类
	private static List<InterfaceKey> interFaceKeys=new ArrayList<InterfaceKey>();
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public String getCoreName() {
		return coreName;
	}
	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}
	public abstract List<InterfaceKey> getInterFaceKey();
	
	protected void $(InterfaceKey interfacekey){
		interFaceKeys.add(interfacekey);
	}
	public static SuppCodeType getByCnName(String cnName){
		for (SuppCodeType suppCode : SuppCodeType.values()) {
			if(StringUtils.equalsIgnoreCase(suppCode.cnName, cnName))return suppCode;
		}
		return null;
	}
}
