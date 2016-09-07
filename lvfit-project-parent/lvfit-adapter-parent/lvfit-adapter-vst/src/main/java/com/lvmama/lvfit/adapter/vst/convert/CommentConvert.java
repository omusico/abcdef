/**
 * Project Name:lvfit-adapter-vst
 * File Name:CommentConvert.java
 * Package Name:com.lvmama.lvfit.adapter.vst.convert
 * Date:2015-11-27下午4:57:17
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.convert;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.lvmama.cmt.api.vo.CmtRequestBaseVo;
import com.lvmama.cmt.api.vo.PubFrontCmtCommentVo;
import com.lvmama.cmt.comm.vo.Page;
import com.lvmama.cmt.comm.vo.ResponseVO;
import com.lvmama.cmt.comment.vo.CmtLatitudeVO;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvfit.adapter.vst.handle.VSTLoggerHandler;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.common.dto.vst.VstCmtLatitude;
import com.lvmama.lvfit.common.dto.vst.VstComment;

/**
 * ClassName:CommentConvert <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-11-27 下午4:57:17 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class CommentConvert {

	
	private static Logger logger = LoggerFactory.getLogger(CommentConvert.class);
	/**
	 * 
	 * convertCommentRequest:转换vst查询对象. <br/>
	 * 
	 * @author liuweiguo
	 * @param commentRequest
	 * @return
	 * @since JDK 1.6
	 */
	public static CmtRequestBaseVo convertPageCondition(FitCommentRequest commentRequest) {
		CmtRequestBaseVo cmtRequest = new CmtRequestBaseVo();
		try {
			//placeId, productId, placeIdType, null,null,isElong
			BeanUtils.copyProperties(cmtRequest, commentRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return cmtRequest;
	}
	
	/**
	 * 
	 * convertResult:转换返回结果. <br/>
	 *
	 * @author liuweiguo
	 * @param responseVo
	 * @return
	 * @since JDK 1.6
	 */
	public static BaseResultDto<VstComment> convertPageResult(ResponseVO<Page<PubFrontCmtCommentVo>> responseVo) {
		Page<PubFrontCmtCommentVo> vstPage = responseVo.getReturnBody();
		Pagination pagination = new Pagination();
		//pagination.setRecords(counts);
		List<VstComment> list = new ArrayList<VstComment>();
		try {
			if(vstPage!=null){
				for (PubFrontCmtCommentVo bean : vstPage.getItems()) {
					VstComment vstComment = new VstComment();
					List<VstCmtLatitude> latitudeList= new ArrayList<VstCmtLatitude>();
					BeanUtils.copyProperties(vstComment, bean);
					if(!CollectionUtils.isEmpty(bean.getCmtLatitudes())){
						for(CmtLatitudeVO vo:bean.getCmtLatitudes()){
							VstCmtLatitude vstCmtLatitude = new VstCmtLatitude();
							BeanUtils.copyProperties(vstCmtLatitude, vo);
							latitudeList.add(vstCmtLatitude);
						}
					}		
					vstComment.setCmtLatitudes(latitudeList);
					list.add(vstComment);
				}
			}		
		} catch (Exception e) {
			logger.error("调取vst评论结果集数据转换异常:"+e.getMessage());
			e.printStackTrace();
		}
		BaseResultDto<VstComment> commentResult = new BaseResultDto<VstComment>(pagination,list);
		return commentResult;
	}

}
