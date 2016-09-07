package com.lvmama.lvf.common.domain;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;

/**
 * @author mashengwen
 *
 */
public interface DomainQueryRepository<I extends Dto,Q extends BaseQueryDto<? extends Dto>> {

	/**
	 * @param q
	 * @return
	 * 查询返回多个对象
	 */
	public List<I> query(Q q);
	
	/**
	 * @param q
	 * @return
	 * 返回总数
	 */
	public int count(Q q);
	
}
