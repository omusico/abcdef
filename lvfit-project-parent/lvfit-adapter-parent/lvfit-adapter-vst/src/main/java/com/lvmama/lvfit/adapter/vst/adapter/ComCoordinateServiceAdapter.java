package com.lvmama.lvfit.adapter.vst.adapter;

import java.util.List;

import com.lvmama.vst.back.pub.po.ComCoordinate;
import com.lvmama.vst.comm.vo.ResultHandleT;

/**
 *  地图相关的接口适配器
 * @author wanghuihui
 * @date:2015年11月23日 下午6:42:16
 */
@Deprecated
public interface ComCoordinateServiceAdapter {
	/**
	 * 根据目的地ID查询经纬度
	 * @author wanghuihui
	 * @date:2015年11月23日 下午6:54:57
	 * @param id
	 * @return
	 */
	ResultHandleT<List<ComCoordinate>> getComCoordinateByDestId(Long id);
	
	/**
	 *  根据目的地ID 和 类型 查询经纬度
	 * @author wanghuihui
	 * @date:2015年11月23日 下午6:54:48
	 * @param id
	 * @param coordType
	 * @return
	 */
	ResultHandleT<ComCoordinate> getComCoordinateByDestIdAndType(Long id,
			String coordType);
	
	/**
	 *  根据产品ID查询 地理坐标列表 
	 * @author wanghuihui
	 * @date:2015年11月23日 下午6:55:21
	 * @param productId
	 * @return
	 */
	ResultHandleT<List<ComCoordinate>> getComCoordinateByProductId(
			Long productId);
	
	
}
