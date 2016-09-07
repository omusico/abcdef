package com.lvmama.lvfit.adapter.vst.adapter;

import com.lvmama.lvfit.common.dto.request.CommHeaderRequest;

/**
 * 获取头信息Adapter
 * @author leizhengwei
 *
 */
public interface CommHeaderServiceAdapter {
	
	 String getCommHead(CommHeaderRequest commHeaderRequest);
	
}
