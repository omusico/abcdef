/**
 * Project Name:lvfit-adapter-vst
 * File Name:CommentServiceAdapter.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter
 * Date:2015-11-20下午4:50:31
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.cmt.api.vo.CmtRequestBaseVo;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.common.dto.vst.VstComment;

/**
 * ClassName:CommentServiceAdapter <br/>
 * Function: 点评主表统一接口适配器. <br/>
 * Date:     2015-11-20 下午4:50:31 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface CommentServiceAdapter {	
	/**
	 * 获取总记录
	 * @param CmtRequestBaseVo 查询封装对象
	 * @return
	 */
	public Long getCommentCount(CmtRequestBaseVo cmtRequestBaseVo);
	
	/**
	 * 
	 * queryCommentPageList:分页查询点评信息. <br/>
	 *
	 * @author liuweiguo
	 * @param commentRequest
	 * @return
	 * @since JDK 1.6
	 */
	public BaseResultDto<VstComment> queryCommentPageList(BaseQueryDto<FitCommentRequest> commentRequest);

}

