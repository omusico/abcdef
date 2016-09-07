package com.lvmama.lvfit.online.search.controller;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.form.Form;

public interface ToSearchController<I extends Form,R extends Form> {
	
	/**
	 * 查询首页静态==>调用toSearchAjax，设置默认的机票出发地目的地出发到达时间和酒店的入住城市入住时间范围
	 * 1.输出参数:航程类型
	 * 2.输出参数:服务器端当前日期
	 * @param model
	 * @param input
	 * @return
	 */
	public R toDefault(Model model,I input);
	


}
