package com.lvmama.lvfit.online.comment.controller;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;

/**
 * 
 * 点评
 * 
 * 
 * */
public interface CommentController <I extends Form>{
	
	public FitCommentDto showComments(Model model, I input);

}
