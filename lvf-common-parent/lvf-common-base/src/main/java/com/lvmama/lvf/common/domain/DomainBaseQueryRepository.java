package com.lvmama.lvf.common.domain;

import java.util.List;

import com.lvmama.lvf.common.dto.Dto;

public interface DomainBaseQueryRepository<I extends Dto> {

	/**
	 * @param q
	 * @return
	 * 查询返回多个对象
	 */
	public List<I> queryList();
	
}
