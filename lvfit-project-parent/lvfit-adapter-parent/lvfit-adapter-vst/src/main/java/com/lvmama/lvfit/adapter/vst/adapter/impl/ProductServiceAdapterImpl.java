/**
 * Project Name:lvfit-adapter-vst
 * File Name:ProductServiceAdapterImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter.impl
 * Date:2015-11-12下午3:27:11
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvfit.adapter.vst.adapter.ProductServiceAdapter;
import com.lvmama.lvfit.adapter.vst.handle.VSTLoggerHandler;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.vst.VstBranch;
import com.lvmama.lvfit.common.dto.vst.VstPicProduct;
import com.lvmama.lvfit.common.dto.vst.VstProduct;
import com.lvmama.vst.back.client.prod.service.ProdProductClientService;
import com.lvmama.vst.back.client.pub.service.ComPhotoQueryClientService;
import com.lvmama.vst.back.prod.po.ProdProduct;
import com.lvmama.vst.back.prod.po.ProdProductBranch;
import com.lvmama.vst.back.pub.po.ComPhoto;
import com.lvmama.vst.comm.vo.ResultHandleT;

/**
 * ClassName:ProductServiceAdapterImpl <br/>
 * Function: vst产品适配器. <br/>
 * Date:     2015-11-12 下午3:27:11 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class ProductServiceAdapterImpl implements ProductServiceAdapter{
	//@SuppressWarnings("unused")
	@Autowired
	private VSTLoggerHandler logger;
	
	@Autowired
	private ProdProductClientService prodProductClientService;

	@Autowired
	private ComPhotoQueryClientService comPhotoQueryClientService;
	
	/**
	 *  获得酒店详情图片
	 * @author wanghuihui
	 * @date:2015年12月2日 上午11:13:48
	 * @param vstProductRequest
	 * @return
	 */
	public List<VstPicProduct> getHotelProductDetailPicList(Long productId) {
		ResultHandleT<List<ComPhoto>> result = comPhotoQueryClientService.findProductAllImageListByProductId(productId);
		List<ComPhoto> photoList = result.getReturnContent();
		if(null == photoList || photoList.size() == 0) return null;
		List<VstPicProduct> list = new ArrayList<VstPicProduct>();
		VstPicProduct vstPicProduct = null;
		try {
			for(ComPhoto photo : photoList){
				vstPicProduct =  new VstPicProduct();
				BeanUtils.copyProperties(vstPicProduct,photo);
				vstPicProduct.setPhotoDesc(photo.getPhotoContent());
				vstPicProduct.setFlag(photo.getRatio());
				list.add(vstPicProduct);
			}
		} catch (Exception e) {
			logger.error("酒店详情图片属性转换出错!:"+ExceptionUtils.getFullStackTrace(e));
		}
		return list;
	}
	
	/**
	 *  获得酒店详情
	 * @author wanghuihui
	 * @date:2015年12月2日 上午11:13:24
	 * @param vstProductRequest
	 * @return
	 */
	public VstProduct getHotelProductDetail(FitHotelRequest request, Boolean hasProp,Boolean hasPropValue) {
		VstProduct vstProduct=new VstProduct();
		Long productId=request.getHotelId();
		//从VST远程接口读取数据
		ResultHandleT<ProdProduct> product=prodProductClientService.findHotelProduct4Front(productId, hasProp, hasPropValue);
		ProdProduct prodProduct = product.getReturnContent();
		// 数据转换
		vstProduct = prodProductToVstProduct(vstProduct,prodProduct);
		vstProduct.setPicProductList(getHotelProductDetailPicList(productId));
		return vstProduct;
	}
	/**
	 *  对VstProduct的实体封装
	 * @author wanghuihui
	 * @date:2015年11月27日 上午10:49:15
	 * @param vstProduct 本地实体
	 * @param prodProduct VST远程过来的 商品实体
	 * @return
	 */
	private VstProduct prodProductToVstProduct(VstProduct vstProduct,ProdProduct prodProduct) {
		//vstProduct.setBranchs(getBranchs(prodProduct));
		vstProduct.setCancelFlag(prodProduct.getCancelFlag());
		vstProduct.setProductId(prodProduct.getProductId());
		vstProduct.setProductName(prodProduct.getProductName());
		vstProduct.setRecommendLevel(prodProduct.getRecommendLevel());
		vstProduct.setSaleFlag(prodProduct.getSaleFlag());
		vstProduct.setUrlId(prodProduct.getUrlId());
		vstProduct.setPropValue(prodProduct.getPropValue());
		return vstProduct;
	}
	
	/**
	 * 	得到产品规格
	 * @author wanghuihui
	 * @date:2015年12月1日 下午2:35:38
	 * @param prodProduct
	 * @return
	 */
	private List<VstBranch> getBranchs(ProdProduct prodProduct) {
		List<VstBranch> list = new ArrayList<VstBranch>();
		VstBranch vstBranch = null;
		List<ProdProductBranch> branchList = prodProduct.getProdProductBranchList();
		if(null != branchList && branchList.size() > 0){
			for(ProdProductBranch branch:branchList){
				vstBranch = new VstBranch();
				vstBranch.setBranchId(branch.getBranchId());
				vstBranch.setProductId(branch.getProductId());
				vstBranch.setBranchName(branch.getBranchName());
				vstBranch.setBranchSeq(branch.getRecommendLevel());
				vstBranch.setProductBranchId(branch.getProductBranchId());
				//vstBranch.setProductBranchPropList(branch.getProductBranchPropList());
				vstBranch.setMaxVisitor(branch.getMaxVisitor());
				vstBranch.setSaleFlag(branch.getSaleFlag());
				vstBranch.setPropValue(branch.getPropValue());
				list.add(vstBranch);
			}
		}
		return list;
	}

	@Override
	public List<VstProduct> queryHotelProdProductList(Map<String, Object> params) {
		List<VstProduct> prodList=new ArrayList<VstProduct>();
		ResultHandleT<List<ProdProduct>> productList=prodProductClientService.findProdProductList(params);
		/**
		 * 逻辑代码
		 */
		return prodList;
	}

}

