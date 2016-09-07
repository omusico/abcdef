package com.lvmama.lvf.common.domain;

import com.lvmama.lvf.common.dto.Dto;

/**
 * 持久层共通Repository
 * 
 * @author mashengwen
 * @date 2015-2-3
 */
public interface DomainDtoBaseRepository<R extends Dto> {

	/**
	 * @param d
	 * @return
	 * 根据主键ID创建Dto
	 */
	public R load(Long id);

	/**
	 * 
	 * @param d
	 * @return
	 * update
	 */
	public R update(R r);

}
