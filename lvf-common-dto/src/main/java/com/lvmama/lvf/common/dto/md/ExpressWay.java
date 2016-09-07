package com.lvmama.lvf.common.dto.md;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.NameCode;
import com.lvmama.lvf.common.dto.enums.DefaultSupp;

/**
 * 快递方式
 * @author majun
 * @date   2015-1-26
 */
public class ExpressWay extends NameCode implements Serializable 
{	
	private static final long serialVersionUID = 5044212820004587792L;
	
	private String desc;
	private BigDecimal price;
	private DefaultSupp defaultSupp = DefaultSupp.NOT_DEFAULT;
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public DefaultSupp getDefaultSupp() {
		return defaultSupp;
	}

	public void setDefaultSupp(DefaultSupp defaultSupp) {
		this.defaultSupp = defaultSupp;
	}
	
	
}
