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
public interface DomainEntityByNoMapper<I extends Dto> {

	/**
	 * @param no
	 * deleteByNo
	 */
	public int deleteByNo(@Param("no")String no);

	/**
	 * @param no
	 * updateByNo 
	 */
	public int updateByNo(@Param("no")String no,@Param("i")I i);

	/**
	 * @param no
	 * @return
	 * 根据编号查询返回多个对象
	 */
	public I getByNo(String no);
	
	
}
