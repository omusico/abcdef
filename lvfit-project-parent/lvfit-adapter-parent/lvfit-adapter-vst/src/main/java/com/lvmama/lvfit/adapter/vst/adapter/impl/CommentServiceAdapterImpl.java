package com.lvmama.lvfit.adapter.vst.adapter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.cmt.api.service.CmtFrontCommentService;
import com.lvmama.cmt.api.vo.CmtRequestBaseVo;
import com.lvmama.cmt.api.vo.PubFrontCmtCommentVo;
import com.lvmama.cmt.comm.vo.Page;
import com.lvmama.cmt.comm.vo.ResponseVO;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvfit.adapter.vst.adapter.CommentServiceAdapter;
import com.lvmama.lvfit.adapter.vst.convert.CommentConvert;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.common.dto.vst.VstComment;

@Service
public class CommentServiceAdapterImpl implements CommentServiceAdapter {
	
	private static final Logger logger=LoggerFactory.getLogger(CommentServiceAdapterImpl.class);
	@Autowired
	private CmtFrontCommentService cmtFrontCommentService;

	@Override
	public Long getCommentCount(CmtRequestBaseVo cmtRequestBaseVo) {
		return cmtFrontCommentService.count(cmtRequestBaseVo);
	}

	@Override
	public BaseResultDto<VstComment> queryCommentPageList(BaseQueryDto<FitCommentRequest> commentRequest) {
		Pagination pager = commentRequest.getPagination();
		// 转换查询条件
		CmtRequestBaseVo cmtRequest = CommentConvert.convertPageCondition(commentRequest.getCondition());		
		cmtRequest.setIsBest("N");
		
		Long count = getCommentCount(cmtRequest);
		//转换成vst分页： pager.getRows() 每页记录数    pager.getPage() 当前页   count 记录总数
		Page<CmtRequestBaseVo> page = new Page<CmtRequestBaseVo>(pager.getRows(), pager.getPage());
		page.setParam(cmtRequest);
		ResponseVO<Page<PubFrontCmtCommentVo>> responseVo = cmtFrontCommentService.getCmtCommentList(page);
		//responseVo.getReturnBody().setPage(pager.getPage())
		// 对象转换逻辑
		BaseResultDto<VstComment> result = CommentConvert.convertPageResult(responseVo);
		result.getPagination().setRows(pager.getRows());
		result.getPagination().setPage(pager.getPage());
		result.getPagination().setRecords(count.intValue());
		int total = (count.intValue()/pager.getRows()) + (count.intValue()%pager.getRows()==0?0:1) ;
		result.getPagination().setTotal(total);
		return result;
		
	}

}
