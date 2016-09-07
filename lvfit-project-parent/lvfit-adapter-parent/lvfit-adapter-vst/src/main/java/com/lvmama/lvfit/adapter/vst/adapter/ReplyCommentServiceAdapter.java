/**
 * Project Name:lvfit-adapter-vst
 * File Name:ReplyCommentServiceAdapter.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter
 * Date:2015-11-20下午4:52:01
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.cmt.comm.vo.Page;
import com.lvmama.cmt.comm.vo.ResponseVO;
import com.lvmama.cmt.comment.vo.CmtReplyVO;

/**
 * ClassName:ReplyCommentServiceAdapter <br/>
 * Function: 点评回复接口适配器. <br/>
 * Date: 2015-11-20 下午4:52:01 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Deprecated
public interface ReplyCommentServiceAdapter {
	/**
	 * 分页查询点评回复列表
	 * 
	 * @param page 分页查询对象 CmtReplyVO查询封装对象
	 * @return 点评回复列表
	 * */
	public ResponseVO<Page<CmtReplyVO>> getCmtReplyList(Page<CmtReplyVO> page);

}
