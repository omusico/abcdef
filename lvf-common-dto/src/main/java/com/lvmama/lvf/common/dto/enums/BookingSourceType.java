package com.lvmama.lvf.common.dto.enums;




public enum BookingSourceType {

	/**             		短信    solr   VST     票台   51book   Ctrip  517na  lv_tra lv_dom  err2lv_tra  lowPrice*/
	H5("H5",				true , true , true , true , 	true , false, true , true , false,  true , 		true ),
	WAP("WAP",				true , true , true , true , 	true , false, true , true , false,  true , 		true ),
	APP("APP",				true , true , true , true , 	true , false, true , true , false,  true , 		true ),
	VST("主站",				false, true , false, true , 	true , false, false, false, false,  false, 		true ),
	FIT("交通X",				false, true , false, true , 	true , false, false, true, true,  false, 		true ),
	BACK("机票后台",			true , false, true , true , 	true , false, true , true , true,  true , 		true ),
	VST_BACK("打包后台", 		false, true , false, true , 	true , false, true , true , false,  true , 		true ),
	FRONT("网站",			true , true , true , true , 	true , false, true , true , false,  true , 		true ),
	SALES("分销",			true , true , false, true , 	true , false, false, true , false,  true , 		true ),
	DEFAULT("默认",			true , true , true , true , 	true , false, false, false, false,  false, 		true );
	
	private String cnName; 
	private Boolean sendSms; //是否发送短信
	private Boolean defaultFromSolr; //是否默认先从solr出数据
	private Boolean syncToVst;  //是否推送到VST
	private Boolean invokeLvmama;  //是否调用自有票台接口
	private Boolean useFive1Book;  //是否使用51政策
	private Boolean useCtrip;  //是否使用携程政策
	private Boolean useFive17Na;  //是否使用517政策
	private Boolean useLvmamaTraffic;  //是否使用驴妈妈大交通政策
	private Boolean useLvmamaDomestic;  //是否使用驴妈妈国内游政策
	private Boolean errorTrans2LvmamaTraffic;//是否失败转驴妈妈大交通政策
	private Boolean useLvmamaDailyLowestPrice;//是否使用驴妈妈自有低价日历数据

	private BookingSourceType(String cnName, Boolean sendSms, Boolean defaultFromSolr, Boolean syncToVst, Boolean invokeLvmama, 
			Boolean useFive1Book, Boolean useCtrip, Boolean useFive17Na, Boolean useLvmamaTraffic, Boolean useLvmamaDomestic,Boolean errorTrans2LvmamaTraffic,
			Boolean useLvmamaDailyLowestPrice) {
		this.cnName = cnName;
		this.sendSms = sendSms;
		this.defaultFromSolr = defaultFromSolr;
		this.syncToVst = syncToVst;
		this.invokeLvmama = invokeLvmama;
		this.useFive1Book = useFive1Book;
		this.useCtrip = useCtrip;
		this.useFive17Na = useFive17Na;
		this.useLvmamaTraffic = useLvmamaTraffic;
		this.useLvmamaDomestic = useLvmamaDomestic;
		this.errorTrans2LvmamaTraffic = errorTrans2LvmamaTraffic;
		this.useLvmamaDailyLowestPrice = useLvmamaDailyLowestPrice;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public Boolean getSendSms() {
		return sendSms;
	}

	public void setSendSms(Boolean sendSms) {
		this.sendSms = sendSms;
	}

	public Boolean getDefaultFromSolr() {
		return defaultFromSolr;
	}

	public void setDefaultFromSolr(Boolean defaultFromSolr) {
		this.defaultFromSolr = defaultFromSolr;
	}

	public Boolean getSyncToVst() {
		return syncToVst;
	}

	public void setSyncToVst(Boolean syncToVst) {
		this.syncToVst = syncToVst;
	}

	public Boolean getInvokeLvmama() {
		return invokeLvmama;
	}

	public void setInvokeLvmama(Boolean invokeLvmama) {
		this.invokeLvmama = invokeLvmama;
	}

	public Boolean getUseFive1Book() {
		return useFive1Book;
	}

	public void setUseFive1Book(Boolean useFive1Book) {
		this.useFive1Book = useFive1Book;
	}

	public Boolean getUseCtrip() {
		return useCtrip;
	}

	public void setUseCtrip(Boolean useCtrip) {
		this.useCtrip = useCtrip;
	}

	public Boolean getUseFive17Na() {
		return useFive17Na;
	}

	public void setUseFive17Na(Boolean useFive17Na) {
		this.useFive17Na = useFive17Na;
	}

	public Boolean getUseLvmamaTraffic() {
		return useLvmamaTraffic;
	}

	public void setUseLvmamaTraffic(Boolean useLvmamaTraffic) {
		this.useLvmamaTraffic = useLvmamaTraffic;
	}

	public Boolean getUseLvmamaDomestic() {
		return useLvmamaDomestic;
	}

	public void setUseLvmamaDomestic(Boolean useLvmamaDomestic) {
		this.useLvmamaDomestic = useLvmamaDomestic;
	}

	public Boolean getErrorTrans2LvmamaTraffic() {
		return errorTrans2LvmamaTraffic;
	}

	public void setErrorTrans2LvmamaTraffic(Boolean errorTrans2LvmamaTraffic) {
		this.errorTrans2LvmamaTraffic = errorTrans2LvmamaTraffic;
	}

	public Boolean getUseLvmamaDailyLowestPrice() {
		return useLvmamaDailyLowestPrice;
	}

	public void setUseLvmamaDailyLowestPrice(Boolean useLvmamaDailyLowestPrice) {
		this.useLvmamaDailyLowestPrice = useLvmamaDailyLowestPrice;
	}
	
}

