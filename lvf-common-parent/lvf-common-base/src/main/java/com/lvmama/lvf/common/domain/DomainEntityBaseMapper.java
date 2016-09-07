package com.lvmama.lvf.common.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;

/**
 * 
 * @author mashengwen
 * mybatis 的mapper继承DomainEntityMapper
 * 实现相关方法，传入和传出参数需要实现Entity接口
 *
 */
public interface DomainEntityBaseMapper<I extends Dto,Q extends BaseQueryDto<? extends Dto>> {

	/**
	 * @param i
	 * insert
	 */
	public int insert(I i);

	/**
	 * @param i
	 * getById
	 */
	public I getById(@Param("id")Long id);

	/**
	 * @param i
	 * deleteById
	 */
	public int deleteById(@Param("id")Long id);

	/**
	 * @param i
	 * updateById
	 */
	public int updateById(@Param("id")Long id,@Param("i")I i);

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
