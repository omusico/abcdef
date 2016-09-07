/**
 * Project Name:lvfit-adapter-vst
 * File Name:HotelCommentServvice.java
 * Package Name:com.lvmama.lvfit.adapter.vst.service
 * Date:2015-12-3下午5:36:19
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.service;

import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;

/**
 * ClassName:HotelCommentServvice <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-3 下午5:36:19 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface CommentService {
	public FitCommentDto getCommentPage(FitCommentRequest request);

}

