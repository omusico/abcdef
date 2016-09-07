package com.lvmama.lvf.common.domain;

import com.lvmama.lvf.common.dto.Dto;

public interface DomainByNoRepository<R extends Dto> {

	/**
	 * @param d
	 * @return
	 * 根据No创建Dto
	 */
	public R loadByNo(String no);

}
