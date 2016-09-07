package com.lvmama.lvfit.common.dto;

import java.io.Serializable;

public class InsuranceType implements Serializable {
    private static final long serialVersionUID = 6453128594218334194L;
    
    String id;
    String name;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
