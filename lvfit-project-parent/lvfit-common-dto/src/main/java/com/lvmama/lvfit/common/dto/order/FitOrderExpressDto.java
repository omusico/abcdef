package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.ExpressStatus;
import com.lvmama.lvfit.common.dto.enums.ExpressType;
import com.lvmama.lvfit.common.dto.md.ExpressWay;

import java.math.BigDecimal;
import java.util.Date;

public class FitOrderExpressDto  extends Entity {

    private static final long serialVersionUID = -9035606575985128485L;

    /** 主订单主键 */
    private Long orderMainId;

    /** 订单主键 */
    private Long orderId;

    /** 快递状态 */
    private ExpressStatus expressStatus;

    /** 快递类型 */
    private ExpressType expressType;

    /** 快递方式 */
    private ExpressWay expressWay;

    /** 地址 */
    private String address;

    /** 收件人 */
    private String recipient;

    /** 电话号码 */
    private String telephone;

    /** 手机号码 */
    private String cellphone;

    /** 邮政编码 */
    private String postCode;

    /** 快递费 */
    private BigDecimal expressPrice;

    /** 快递文件号 */
    private String expressFileNo;

    /** 邮寄世间*/
    private Date expressTime;

    private String remark;

    public Long getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(Long orderMainId) {
        this.orderMainId = orderMainId;
    }

    public ExpressStatus getExpressStatus() {
        return expressStatus;
    }

    public void setExpressStatus(ExpressStatus expressStatus) {
        this.expressStatus = expressStatus;
    }

    public ExpressType getExpressType() {
        return expressType;
    }

    public void setExpressType(ExpressType expressType) {
        this.expressType = expressType;
    }

    public ExpressWay getExpressWay() {
        return expressWay;
    }

    public void setExpressWay(ExpressWay expressWay) {
        this.expressWay = expressWay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public BigDecimal getExpressPrice() {
        return expressPrice;
    }

    public void setExpressPrice(BigDecimal expressPrice) {
        this.expressPrice = expressPrice;
    }

    public String getExpressFileNo() {
        return expressFileNo;
    }

    public void setExpressFileNo(String expressFileNo) {
        this.expressFileNo = expressFileNo;
    }

    public Date getExpressTime() {
        return expressTime;
    }

    public void setExpressTime(Date expressTime) {
        this.expressTime = expressTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
