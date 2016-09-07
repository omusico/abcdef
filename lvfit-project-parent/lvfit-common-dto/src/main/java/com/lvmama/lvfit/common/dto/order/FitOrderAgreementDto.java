package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;

public class FitOrderAgreementDto extends Entity {

    private static final long serialVersionUID = 4758581550353856873L;

    /** 主订单主键 */
    private Long orderMainId;

    /** 合同名称 */
    private String contractName;

    public Long getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(Long orderMainId) {
        this.orderMainId = orderMainId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
}
