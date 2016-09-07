package com.lvmama.lvf.common.domain;

import java.util.List;

import com.lvmama.lvf.common.dto.Dto;

/**
 * 
 * @author mashengwen
 * mybatis 的mapper继承DomainEntityMapper
 * 实现相关方法，传入和传出参数需要实现Entity接口
 *
 */
public interface DomainEntityQueryMapper<I extends Dto> {

	/**
	 * @param null
	 * @return
	 * 无条件查询所有数据
	 */
	public List<I> queryList();
	
	
}
