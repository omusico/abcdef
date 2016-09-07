package com.lvmama.lvf.common.domain;

import com.lvmama.lvf.common.dto.Dto;

/**
 * 持久层共通Repository
 * 
 * @author mashengwen
 * @date 2015-2-3
 */
public interface DomainBaseLoadByFkRepository<R extends Dto> {

	/**
	 * @param d
	 * @return
	 * 根据主键ID从持久层获取Dto
	 */
	public R loadWithFk(Long id);

}
