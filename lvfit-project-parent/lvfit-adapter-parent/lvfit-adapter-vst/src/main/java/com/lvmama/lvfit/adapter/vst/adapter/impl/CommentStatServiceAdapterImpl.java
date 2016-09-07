package com.lvmama.lvfit.adapter.vst.adapter.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.cmt.comment.service.VstCmtTitleStatistisService;
import com.lvmama.cmt.comment.vo.VstCmtTitleStatisticsVO;
import com.lvmama.lvfit.adapter.vst.adapter.CommentStatServiceAdapter;
import com.lvmama.lvfit.common.dto.vst.VstCommentStat;

@Service
public class CommentStatServiceAdapterImpl implements CommentStatServiceAdapter {

	@Autowired
	private VstCmtTitleStatistisService vstCmtTitleStatistisService;

	private static final Logger logger = LoggerFactory.getLogger(CommentStatServiceAdapterImpl.class);

	
	@Override
	/**
	 * 
	 * 根据目的地查询点评统计数据. <br/>
	 * @author zengzhimin
	 * @param  isCruise(Y/N) 是否邮轮 
	 * @return
	 * @since JDK 1.6
	 * 
	 */
	public VstCommentStat getVstCommentStatByPlaceId(Long placeId, String isCruise) {
		VstCmtTitleStatisticsVO vstVo = vstCmtTitleStatistisService.getVstCmtTitleStatisticsByPlaceId(placeId, isCruise);
		VstCommentStat bean = new VstCommentStat();
		try {
			if (vstVo != null) {
				BeanUtils.copyProperties(bean, vstVo);
				// 好评率
				bean.setFormatAvgScore(vstVo.getFormatAvgScore());
			}
			
		} catch (Exception e) {
			logger.error("获取好评异常:",e);
		}
		return bean;

	}

	@Override
	public VstCommentStat getVstCommentStatByProductId(Long productId) {
		VstCmtTitleStatisticsVO vstVo = vstCmtTitleStatistisService.getVstCmtTitleStatisticsByProductId(productId);
		VstCommentStat bean = new VstCommentStat();
		try {
			if (vstVo != null) {
				BeanUtils.copyProperties(bean, vstVo);
				// 好评率
				bean.setFormatAvgScore(vstVo.getFormatAvgScore());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

}
