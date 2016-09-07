package com.lvmama.lvf.common.domain;

import org.apache.ibatis.annotations.Param;
import com.lvmama.lvf.common.dto.Dto;

/**
 * 
 * @author mashengwen
 * mybatis 的mapper继承DomainEntityMapper
 * 实现相关方法，传入和传出参数需要实现Entity接口
 *
 */
public interface DomainEntityByCodeMapper<I extends Dto> {

	/**
	 * @param no
	 * deleteByNo
	 */
	public int deleteByCode(@Param("code")String code);

	/**
	 * @param no
	 * updateByNo 
	 */
	public int updateByCode(@Param("code")String code,@Param("i")I i);

	/**
	 * @param no
	 * @return
	 * 根据编号查询返回多个对象
	 */
	public I getByCode(String code);
	
	
}
