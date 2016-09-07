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
public interface DomainEntityByFkIdListMapper<I extends Dto> {

	public List<I> queryByFkIdList(List<Long> i);
	
	public int deleteByFkIdList(List<Long> i);
	
	
}
