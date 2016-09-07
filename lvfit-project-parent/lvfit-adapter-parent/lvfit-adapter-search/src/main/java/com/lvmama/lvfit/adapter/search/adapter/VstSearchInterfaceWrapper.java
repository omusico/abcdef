package com.lvmama.lvfit.adapter.search.adapter;

import java.util.Date;
import java.util.List;

import com.lvmama.vst.api.route.prod.vo.RouteProductVo;
import com.lvmama.vst.api.vo.PageVo;
import com.lvmama.vst.api.vo.prod.ProdGroupDateVo;
import com.lvmama.vst.back.goods.vo.ProdProductParam;
import com.lvmama.vst.back.order.vo.InstalmentGateWayConfigVO;
import com.lvmama.vst.back.prod.po.ProdProduct;

/**
 * Vst接口包装类
 * @author leizhengwei
 *
 */
public interface VstSearchInterfaceWrapper {
	
	/**
	 * 查询线路产品详情
	 * @param productId
	 * @param param
	 * @return
	 */
	com.lvmama.vst.comm.vo.ResultHandleT<ProdProduct> findLineProductByProductId(Long productId,ProdProductParam param);
	
	
	
	  /**
     * 根据条件查询产品团期列表（用于产品的时间价格）
     * @param productId 产品ID
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return
     */
	com.lvmama.vst.api.vo.ResultHandleT<PageVo<ProdGroupDateVo>> findProdGroupDateByParam(Long productId,Date beginDate,Date endDate);
	
	
	
	/**
	 * (该方法支持旅途 6.0版本中打包的酒店商品的最大、最小订购数，在下一个版本中将使用新方法，最大、最小订购数从规格上取)
	 * 根据参数获取产品下的可售商品
	 * @param productId 产品ID
	 * @param specDate 日期
	 * @param adultQuantity 成人数
	 * @param childQuantity 儿童数
	 * @param distributorId 分销商ID
	 * @param districtId 城市区域Id
	 * @param quantity 份数
	 * @return
	 */
	com.lvmama.vst.api.vo.ResultHandleT<RouteProductVo> findOnSaleGoodsByParam(Long productId,Date specDate, Long adultQuantity, Long childQuantity,Long distributorId, Long districtId, Long quantity);
	
	
	/**
	 * 传入品类 ，返回支持该品类的分期银行
	 * 
	 * @param category
	 * @return
	 */
	 List<InstalmentGateWayConfigVO> selectInstalmentBycategory(String category);
	

}
