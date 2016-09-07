/**
 * Project Name:lvfit-aggregate-base
 * File Name:HotelCommentService.java
 * Package Name:com.lvmama.lvfit.aggregate.hotel.service
 * Date:2015-12-3下午4:47:20
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.dp.comment.service;

import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;

/**
 * ClassName:HotelCommentService <br/>
 * Function: 点评. <br/>
 * Date:     2015-12-3 下午4:47:20 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface CommentService {
	/**
	 * getCommentPage:根据productId查询酒店点评. <br/>
	 *
	 * @author liuweiguo
	 * @param request
	 * @return
	 * @since JDK 1.6
	 */
	public FitCommentDto getCommentPage(FitCommentRequest request);

}

