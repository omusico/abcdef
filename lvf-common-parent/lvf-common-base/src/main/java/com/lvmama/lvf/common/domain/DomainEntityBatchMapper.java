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
public interface DomainEntityBatchMapper<I extends Dto,Q extends BaseQueryDto<? extends Dto>> {
    
	/**
	 * @param i
	 * insert多个对象
	 */
	public int insertBatch(List<I> i);

	/**
	 * @param q
	 * delete多个对象
	 */
	public int deleteBatchByQuery(Q q);

	/**
	 * @param q,i
	 * updateByQuery多个对象
	 */
	public int updateBatchByQuery(@Param("q")Q q,@Param("i")I i);
	
    /**
     * @param i
     * select多个对象
     */
    public List<I> selectBatch(List<Long> i);
    
    /**
     * @param i
     * update多个对象
     */
    public int updateBatch(List<I> i);
    
    /**
     * @param i
     * delete多个对象
     */
    public int deleteBatch(List<Long> i);
	
}
