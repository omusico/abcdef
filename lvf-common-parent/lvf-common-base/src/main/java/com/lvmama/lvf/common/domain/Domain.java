package com.lvmama.lvf.common.domain;

import com.lvmama.lvf.common.dto.Dto;

/**
 * 
 * @author mashengwen
 * 
 * 领域对象实现domain接口
 * 使用对应的DTO作为生成领域对象的数据结构
 * self 方法用于获取自身的数据结构
 * 列如 FlightOrder impl Domain<FlightOrderDto>
 * 
 * 订单信息 
 * private FlightOrderDto self;
 * 
 * public FlightOrderDto self() {
		return this.self;
	}
 * 
 * 只操作领域对象自身数据结构的原子业务逻辑方法写在领域对象内
 */
public interface Domain<T extends Dto> {
	
	public T self();
	
}
