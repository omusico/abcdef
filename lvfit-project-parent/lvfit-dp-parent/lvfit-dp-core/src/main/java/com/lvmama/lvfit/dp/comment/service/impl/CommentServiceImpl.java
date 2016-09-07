package com.lvmama.lvfit.dp.comment.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.dp.booking.service.impl.FitBookingServiceImpl;
import com.lvmama.lvfit.dp.comment.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

    private static final Logger logger = LoggerFactory.getLogger(FitBookingServiceImpl.class);

	@Autowired
	private FitAggregateClient fitAggregateClient;
	@Override
	public FitCommentDto getCommentPage(
			FitCommentRequest request) {
		try {
			FitCommentDto dto =  fitAggregateClient.getCommentPage(request);
			return dto;
		} catch (Exception e) {
			logger.error("点评获取失败:",e);
		}
		return null;
	}

}
