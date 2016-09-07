package com.lvmama.lvf.common.domain;

import com.lvmama.lvf.common.dto.Dto;

public interface DomainByIdRepository<R extends Dto>  {

	/**
	 * @param d
	 * @return
	 * 根据主键ID从持久层获取Dto
	 */
	public R get(Long id);

}
