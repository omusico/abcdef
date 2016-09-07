package com.lvmama.lvf.common.dto.status;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActiveStatus implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 6711189557614276187L;

    /** 上架下架枚举信息 */
    private ActiveStatusEnum activeStatus = ActiveStatusEnum.ACTIVE;

    private Boolean active;
    
    public ActiveStatus(ActiveStatusEnum activeStatus) {
        super();
        this.activeStatus = activeStatus;
    }

    public ActiveStatus() {
        super();
    }
    
    public Boolean getActive() {
        if (this.getActiveStatus() != ActiveStatusEnum.INACTIVE && this.getActiveStatus() != ActiveStatusEnum.APPLY_ACTIVE){
            return true;
        } else {
            this.active = false;
        }
        return active;
    }

    public void setActive(boolean isActive) {
    }

    public ActiveStatusEnum getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatusEnum activeStatus) {
        this.activeStatus = activeStatus;
    }

}
