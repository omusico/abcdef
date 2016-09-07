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
public interface DomainEntityByFkIdsMapper<I extends Dto> {

	/**
	 * @param fkid
	 * deleteByFkIds
	 */
	public int deleteByFkIds(Long... fkid);

	/**
	 * @param fkIds
	 * @return
	 * 根据FkIds查询返回多个对象
	 */
	public List<I> queryByFkIds(Long... fkId);
	
	
}
