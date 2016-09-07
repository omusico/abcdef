package com.lvmama.lvfit.common.dto.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lvmama.lvfit.common.dto.status.engine.OpContext;

public class OpList {

    public Set<Op> set = new HashSet<Op>();
    private OpContext opContext = null;
    public OpList(OpContext opContext) {
        this.opContext = opContext;
    }

    public boolean add(Op op) {
        if(null==op
                ||null==opContext){
            return false;
        }
        if(op.vaild(opContext)){
            return set.add(op);
        }
        return false;
    }
    
    public List<Op> list(){
        List<Op> list = new ArrayList<Op>();
        list.addAll(set);
        return list;
    }
    
}
