/**
 * Project Name:lvfit-adapter-vst
 * File Name:CommentServiceImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.service.impl
 * Date:2015-12-3下午5:40:51
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvfit.adapter.vst.adapter.CommentServiceAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.CommentStatServiceAdapter;
import com.lvmama.lvfit.adapter.vst.service.CommentService;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.hotel.FitCommentStat;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.common.dto.vst.VstComment;
import com.lvmama.lvfit.common.dto.vst.VstCommentStat;

/**
 * ClassName:CommentServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-3 下午5:40:51 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class CommentServiceImpl implements CommentService{

	private static final Logger logger=LoggerFactory.getLogger(CommentServiceImpl.class);
	@Autowired
	private CommentServiceAdapter commentServiceAdapter;
	@Autowired
	private CommentStatServiceAdapter commentStatServiceAdapter;
	@Override
	public FitCommentDto getCommentPage(FitCommentRequest request) {
		FitCommentDto fitCommentDto = new FitCommentDto();
		try {
			VstCommentStat vstCommentStat = new VstCommentStat();
			if(request.getPlaceId()!=null && !request.getPlaceId().equals("")){
				 vstCommentStat = commentStatServiceAdapter.getVstCommentStatByPlaceId(request.getPlaceId(), "N");
			}else{
				vstCommentStat = commentStatServiceAdapter.getVstCommentStatByProductId(request.getProductId());
			}		
			Pagination pagination = request.getPagination();
			BaseQueryDto<FitCommentRequest> baseQueryDto = new BaseQueryDto<FitCommentRequest>();
			baseQueryDto.setPagination(pagination);
			//VstCommentRequest vstCommentRequest = new VstCommentRequest();
			request.setPlaceId(request.getPlaceId());
			request.setProductId(request.getProductId());
			baseQueryDto.setCondition(request);
			BaseResultDto<VstComment> baseResultDto = commentServiceAdapter.queryCommentPageList(baseQueryDto);
			FitCommentStat fitCommentStat = new FitCommentStat();
			if(vstCommentStat!=null){
				BeanUtils.copyProperties(fitCommentStat,vstCommentStat);
			}
			fitCommentDto.setCommentStat(fitCommentStat);
			fitCommentDto.setComments(baseResultDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("酒店点评信息调用异常", e.getMessage());
		}
		return fitCommentDto;
		
	}

}

