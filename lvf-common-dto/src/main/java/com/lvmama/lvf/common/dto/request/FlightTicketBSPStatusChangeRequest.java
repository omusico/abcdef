package com.lvmama.lvf.common.dto.request;

import com.lvmama.lvf.common.dto.enums.BSPRecycleStatus;
import com.lvmama.lvf.common.dto.enums.BSPStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FlightTicketBSPStatusChangeRequest implements Serializable {

    /** 选中的行程单Ids */
    private List<Long> bspIds=new ArrayList<Long>();

    /** 更改的行程单状态 */
    private BSPStatus bspStatus;

    /** 回收行程单状态 */
    private BSPRecycleStatus bspRecycleStatus;

    public List<Long> getBspIds() {
        return bspIds;
    }

    public void setBspIds(List<Long> bspIds) {
        this.bspIds = bspIds;
    }

    public BSPStatus getBspStatus() {
        return bspStatus;
    }

    public void setBspStatus(BSPStatus bspStatus) {
        this.bspStatus = bspStatus;
    }

    public BSPRecycleStatus getBspRecycleStatus() {
        return bspRecycleStatus;
    }

    public void setBspRecycleStatus(BSPRecycleStatus bspRecycleStatus) {
        this.bspRecycleStatus = bspRecycleStatus;
    }
}
