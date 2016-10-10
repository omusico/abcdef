package com.lvmama.lvfit.adapter.search.adapter.impl;

import java.util.Date;
import java.util.List;

import com.lvmama.vst.back.dujia.group.prod.vo.ProdProductNameVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvfit.adapter.search.adapter.VstSearchInterfaceWrapper;
import com.lvmama.lvfit.common.aspect.suppinterface.SuppInterfacePoint;
import com.lvmama.vst.api.prod.service.VstProductService;
import com.lvmama.vst.api.route.prod.service.VstRouteService;
import com.lvmama.vst.api.route.prod.vo.RouteProductVo;
import com.lvmama.vst.api.vo.PageVo;
import com.lvmama.vst.api.vo.prod.ProdGroupDateVo;
import com.lvmama.vst.back.client.prod.service.ProdProductClientService;
import com.lvmama.vst.back.goods.vo.ProdProductParam;
import com.lvmama.vst.back.order.vo.InstalmentGateWayConfigVO;
import com.lvmama.vst.back.prod.po.ProdProduct;
import com.lvmama.vst.comm.vo.ResultHandleT;
import com.lvmama.vst.pet.adapter.InstalmentGatewayConfigServiceAdapter;

@Service
public class VstSearchInterfaceWrapperImpl implements VstSearchInterfaceWrapper {
    
    public static final Logger logger = Logger.getLogger(VstSearchInterfaceWrapperImpl.class);
    
	@Autowired
	private VstProductService vstProductGroupService;
	
    @Autowired
    private ProdProductClientService prodProductClientService;
   
    @Autowired
    private VstRouteService vstRouteService;
   
    @Autowired
    private InstalmentGatewayConfigServiceAdapter instalmentGatewayConfigServiceAdapter;

	@Override
	@SuppInterfacePoint(InterfaceKey.SearchSdpProductFromVst)
	public com.lvmama.vst.comm.vo.ResultHandleT<ProdProduct> findLineProductByProductId(Long productId, ProdProductParam param) {
	    Long beginTime = System.currentTimeMillis();
	    ResultHandleT<ProdProduct> resultHandleT = prodProductClientService.findLineProductByProductId(productId, param);
	    Long endTime = System.currentTimeMillis();
	    logger.info("从VST查询产品接口时间：" + (endTime - beginTime));
	    return resultHandleT;
	}

	@Override
	@SuppInterfacePoint(InterfaceKey.SearchSdpProductGroupCalendarInfoFromVst)
	public com.lvmama.vst.api.vo.ResultHandleT<PageVo<ProdGroupDateVo>> findProdGroupDateByParam(Long productId, Date beginDate, Date endDate) {
		return vstProductGroupService. findProdGroupDateByParam(productId, beginDate, endDate);
	}

	@Override
	@SuppInterfacePoint(InterfaceKey.SearchSdpGoodsFromVst)
	public com.lvmama.vst.api.vo.ResultHandleT<RouteProductVo> findOnSaleGoodsByParam(Long productId,Date specDate, Long adultQuantity, Long childQuantity,Long distributorId, Long districtId, Long quantity) {
	    Long beginTime = System.currentTimeMillis();
	    com.lvmama.vst.api.vo.ResultHandleT<RouteProductVo> resultHandleT = vstRouteService.findOnSaleGoodsByParam(productId, specDate, adultQuantity, childQuantity, distributorId,districtId,quantity);
	    Long endTime = System.currentTimeMillis();
	    logger.info("从VST查询产品产品接口时间：" + (endTime - beginTime)+"--"+resultHandleT);
        return resultHandleT;
	}

	@Override
	@SuppInterfacePoint(InterfaceKey.SearchSdpInstalmentFromVst)
	public List<InstalmentGateWayConfigVO> selectInstalmentBycategory(String category) {
		return instalmentGatewayConfigServiceAdapter.selectInstalmentBycategory(category);
	}

	@Override
	public com.lvmama.vst.comm.vo.ResultHandleT<ProdProductNameVO> findProdProductNameVOByProductId(Long productId) {
		return prodProductClientService.findProdProductNameVOByProductId(productId);
	}

}