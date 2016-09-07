package com.lvmama.lvf.common.domain;

import com.lvmama.lvf.common.dto.Dto;

/**
 * 持久层共通Repository
 * 
 * @author mashengwen
 * @date 2015-2-3
 */
public interface DomainBaseRepository<D extends Domain<R>,R extends Dto> {

	/**
	 * @param d
	 * @return
	 * 根据主键ID从持久层获取Dto
	 */
	public R load(Long id);
	
	/**
	 * @param d
	 * @return
	 * 根据Dto对象创建Domain
	 */
	public D load(R r);

	/**
	 * @param d
	 * @return
	 * 根据主键ID删除记录
	 */
	public int delete(Long id);

	/**
	 * 
	 * @param d
	 * @return
	 * 根据主键是否存在判断是调用insert还是Update
	 */
	public R save(R r);

}
