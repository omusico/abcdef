/**
 * Project Name:lvfit-adapter-vst
 * File Name:CommentServiceAdapter.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter
 * Date:2015-11-20下午4:50:31
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.lvfit.common.dto.vst.VstCommentStat;

/**
 * ClassName:CommentServiceAdapter <br/>
 * Function: 点评统计数据统一接口适配器. <br/>
 * Date:     2015-11-20 下午4:50:31 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface CommentStatServiceAdapter {	
	/**
	 * 
	 * 根据目的地查询点评统计数据. <br/>
	 * @author zengzhimin
	 * @param  isCruise(Y/N) 是否邮轮 
	 * @return
	 * @since JDK 1.6
	 * 
	 */
	VstCommentStat getVstCommentStatByPlaceId(Long placeId,String isCruise);
    
	/**
	 * 根据产品id获取点评统计数据
	 * @param productId
	 * @return
	 */
	VstCommentStat getVstCommentStatByProductId(Long productId);
}

