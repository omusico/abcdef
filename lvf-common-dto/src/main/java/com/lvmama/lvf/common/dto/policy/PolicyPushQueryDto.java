package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;

public class PolicyPushQueryDto implements Serializable{
	private static final long serialVersionUID = -8861443254410484903L;
	private String cabin;//舱位
	private String salebegindate;//销售起始日期
	private String remark;//备注信息
	private String issupplyrouteticket;//是否提供行程单
	private String kCabinType;//K位舱位类型
	private String discountType;//票面价类型
	private String discountValue;//票面价/折扣
	private String downCommion;//向下浮动点数
	private String visitPeriod;//巡查周期
	private String type;//政策类型
	private String tickettype;//出票类型
	private String autoticket;//是否自动出票
	private String flybegindate;//旅行起始日期
	private String returnmoney;//留钱
	private String returnpoint;//返点
	private String carrier;//航空公司三字码
	private String saleenddate;//销售结束日期
	private String policyid;//政策id
	private String flyenddate;//旅行结束日期
	private String dep;//出发机场代码
	private String workendtime;//工作结束时间
	private String isallowtransfer;//是否允许签转
	private String advanceTicketLatest;//最早提前出票时限
	private String advanceticketearly;//最晚提前出票时限
	private String kcabintimelimit;//手工k位时限
	private String arr;//到达机场代码
	private String shareflyno;//支持代码共享航班
	private String workbegintime;//工作开始时间
	private String visittime;//巡查总时间
	private String ispaydirectly;
	private String rules;//退改签规则
	private String flyno;//适用航班
	private String exflyno;//不适用航班
	private String officenos;//政策office
	private String cabincomment;//舱位说明
	private String idtype;//证件类型
	private String availablenum;//可售座位数
	private String kcabinway;//K位方式
	private String isswitchpnr;//是否更换pnr
	private String isvipsocket;//是否提供常旅客积分
	private String ispatvalidate;//进行PATA校验
	private String minage;//最小购买年龄
	private String maxage;//最大购买年龄
	private String faceprice;//票面价
	private String saleprice;//销售价
	private String passengertype;//乘机人类型
	private String vtworktime;//订单最晚申请废票时间
	private String beapplyhighprice;//适用于高低运价
	private String modifytime;
	private String week;//班期限制,1234567代表周一到周日
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public String getSalebegindate() {
		return salebegindate;
	}
	public void setSalebegindate(String salebegindate) {
		this.salebegindate = salebegindate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIssupplyrouteticket() {
		return issupplyrouteticket;
	}
	public void setIssupplyrouteticket(String issupplyrouteticket) {
		this.issupplyrouteticket = issupplyrouteticket;
	}
	public String getkCabinType() {
		return kCabinType;
	}
	public void setkCabinType(String kCabinType) {
		this.kCabinType = kCabinType;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(String discountValue) {
		this.discountValue = discountValue;
	}
	public String getDownCommion() {
		return downCommion;
	}
	public void setDownCommion(String downCommion) {
		this.downCommion = downCommion;
	}
	public String getVisitPeriod() {
		return visitPeriod;
	}
	public void setVisitPeriod(String visitPeriod) {
		this.visitPeriod = visitPeriod;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTickettype() {
		return tickettype;
	}
	public void setTickettype(String tickettype) {
		this.tickettype = tickettype;
	}
	public String getAutoticket() {
		return autoticket;
	}
	public void setAutoticket(String autoticket) {
		this.autoticket = autoticket;
	}
	public String getFlybegindate() {
		return flybegindate;
	}
	public void setFlybegindate(String flybegindate) {
		this.flybegindate = flybegindate;
	}
	public String getReturnmoney() {
		return returnmoney;
	}
	public void setReturnmoney(String returnmoney) {
		this.returnmoney = returnmoney;
	}
	public String getReturnpoint() {
		return returnpoint;
	}
	public void setReturnpoint(String returnpoint) {
		this.returnpoint = returnpoint;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSaleenddate() {
		return saleenddate;
	}
	public void setSaleenddate(String saleenddate) {
		this.saleenddate = saleenddate;
	}
	public String getPolicyid() {
		return policyid;
	}
	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}
	public String getFlyenddate() {
		return flyenddate;
	}
	public void setFlyenddate(String flyenddate) {
		this.flyenddate = flyenddate;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getWorkendtime() {
		return workendtime;
	}
	public void setWorkendtime(String workendtime) {
		this.workendtime = workendtime;
	}
	public String getIsallowtransfer() {
		return isallowtransfer;
	}
	public void setIsallowtransfer(String isallowtransfer) {
		this.isallowtransfer = isallowtransfer;
	}
	public String getAdvanceTicketLatest() {
		return advanceTicketLatest;
	}
	public void setAdvanceTicketLatest(String advanceTicketLatest) {
		this.advanceTicketLatest = advanceTicketLatest;
	}
	public String getKcabintimelimit() {
		return kcabintimelimit;
	}
	public void setKcabintimelimit(String kcabintimelimit) {
		this.kcabintimelimit = kcabintimelimit;
	}
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	public String getShareflyno() {
		return shareflyno;
	}
	public void setShareflyno(String shareflyno) {
		this.shareflyno = shareflyno;
	}
	public String getWorkbegintime() {
		return workbegintime;
	}
	public void setWorkbegintime(String workbegintime) {
		this.workbegintime = workbegintime;
	}
	public String getVisittime() {
		return visittime;
	}
	public void setVisittime(String visittime) {
		this.visittime = visittime;
	}
	public String getIspaydirectly() {
		return ispaydirectly;
	}
	public void setIspaydirectly(String ispaydirectly) {
		this.ispaydirectly = ispaydirectly;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getFlyno() {
		return flyno;
	}
	public void setFlyno(String flyno) {
		this.flyno = flyno;
	}
	public String getExflyno() {
		return exflyno;
	}
	public void setExflyno(String exflyno) {
		this.exflyno = exflyno;
	}
	public String getOfficenos() {
		return officenos;
	}
	public void setOfficenos(String officenos) {
		this.officenos = officenos;
	}
	public String getCabincomment() {
		return cabincomment;
	}
	public void setCabincomment(String cabincomment) {
		this.cabincomment = cabincomment;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public String getAvailablenum() {
		return availablenum;
	}
	public void setAvailablenum(String availablenum) {
		this.availablenum = availablenum;
	}
	public String getKcabinway() {
		return kcabinway;
	}
	public void setKcabinway(String kcabinway) {
		this.kcabinway = kcabinway;
	}
	public String getIsswitchpnr() {
		return isswitchpnr;
	}
	public void setIsswitchpnr(String isswitchpnr) {
		this.isswitchpnr = isswitchpnr;
	}
	public String getIsvipsocket() {
		return isvipsocket;
	}
	public void setIsvipsocket(String isvipsocket) {
		this.isvipsocket = isvipsocket;
	}
	public String getIspatvalidate() {
		return ispatvalidate;
	}
	public void setIspatvalidate(String ispatvalidate) {
		this.ispatvalidate = ispatvalidate;
	}
	public String getMinage() {
		return minage;
	}
	public void setMinage(String minage) {
		this.minage = minage;
	}
	public String getMaxage() {
		return maxage;
	}
	public void setMaxage(String maxage) {
		this.maxage = maxage;
	}
	public String getFaceprice() {
		return faceprice;
	}
	public void setFaceprice(String faceprice) {
		this.faceprice = faceprice;
	}
	public String getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}
	public String getPassengertype() {
		return passengertype;
	}
	public void setPassengertype(String passengertype) {
		this.passengertype = passengertype;
	}
	public String getVtworktime() {
		return vtworktime;
	}
	public void setVtworktime(String vtworktime) {
		this.vtworktime = vtworktime;
	}
	public String getBeapplyhighprice() {
		return beapplyhighprice;
	}
	public void setBeapplyhighprice(String beapplyhighprice) {
		this.beapplyhighprice = beapplyhighprice;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getAdvanceticketearly() {
		return advanceticketearly;
	}
	public void setAdvanceticketearly(String advanceticketearly) {
		this.advanceticketearly = advanceticketearly;
	}
}
