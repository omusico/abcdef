package com.lvmama.lvf.common.domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;

/**
 * 持久层共通Repository
 * 
 * @author mashengwen
 * @date 2015-2-3
 */
public interface DomainBatchRepository<R extends Dto,Q extends BaseQueryDto<? extends Dto>> {

	/**
	 * @param i
	 * insert多个对象
	 */
	public int insertBatch(List<R> i);

	/**
	 * @param q
	 * insert多个对象
	 */
	public int deleteBatchByQuery(Q q);

	/**
	 * @param q,i
	 * updateByQuery多个对象
	 */
	public int updateBatchByQuery(@Param("q")Q q,@Param("i")R i);
	
	 /**
     * @param i
     * select多个对象
     */
    public List<R> selectBatch(List<Long> i);
    
    /**
	 * @param q
	 * delete多个对象
	 */
	public int deleteBatch(List<Long> i);

}
