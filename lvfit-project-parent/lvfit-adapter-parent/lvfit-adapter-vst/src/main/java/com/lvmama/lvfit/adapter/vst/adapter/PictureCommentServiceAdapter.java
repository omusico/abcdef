/**
 * Project Name:lvfit-adapter-vst
 * File Name:PictureCommentServiceAdapter.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter
 * Date:2015-11-20下午4:51:33
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.adapter;

import java.util.ArrayList;

import com.lvmama.cmt.comm.vo.ResponseVO;
import com.lvmama.cmt.comment.vo.CmtPictureVO;

/**
 * ClassName:PictureCommentServiceAdapter <br/>
 * Function: 点评图片接口适配器. <br/>
 * Date:     2015-11-20 下午4:51:33 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Deprecated
public interface PictureCommentServiceAdapter {
	
	/**
	 * 查询全部点评图片列表
	 * @param
	 * */
	public ResponseVO<ArrayList<CmtPictureVO>> getCmtPictureList(CmtPictureVO cmtPictureVO);

}

