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
public interface DomainEntityByFkIdMapper<I extends Dto> {

	/**
	 * @param fkid
	 * deleteByFkId
	 */
	public int deleteByFkId(Long fkId);

	/**
	 * @param fkId
	 * @return
	 * 根据FkId查询返回多个对象
	 */
	public List<I> queryByFkId(Long fkId);
	
	
}
