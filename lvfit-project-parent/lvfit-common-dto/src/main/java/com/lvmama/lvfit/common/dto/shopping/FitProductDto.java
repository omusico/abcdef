package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;

public class FitProductDto implements Serializable, Dto {

    private static final long serialVersionUID = 7719561405854855137L;
  
    private double price;
    private int count;
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return null;
    }
}
