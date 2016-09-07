package com.lvmama.lvfit.sdp.shopping.service.impl;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.MemcachedUtil;
import com.lvmama.lvfit.common.cache.CacheBox;
import com.lvmama.lvfit.common.cache.CacheBoxConvert;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.sdp.shopping.FitSdpShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FitSdpShoppingServiceImpl implements FitSdpShoppingService {
	
	private static Logger logger = LoggerFactory.getLogger(FitSdpShoppingServiceImpl.class);	
	/**
	 * 购物车缓存时间
	 */
	@Value("lvfit.shopping.cacheTime")
	private String cacheExpireTime;
	
	private Long getCacheExpireTime(){
		return Long.valueOf((String)CustomizedPropertyPlaceholderConfigurer.getContextProperty(cacheExpireTime));
	}
	
	@Override
	public boolean putShoppingCache(String shoppingUUID,FitSdpShoppingDto sdpShoppingDto) {
		CacheBox box = new CacheBox();
		box.setKey(shoppingUUID);
		box.setJson(CacheBoxConvert.FitSdpShoppingDtoResult.convertFrom(sdpShoppingDto));
		box.setExpireTime(System.currentTimeMillis()+getCacheExpireTime());
		return put2Cache(shoppingUUID, box);
	}

	private boolean put2Cache(String shoppingUUID, CacheBox box){
			
		if(null==box||!box.valid()){
			return false;
		}
		try{
			logger.error("key:"+box.getKey());
			logger.error("size:"+box.getJson().length());
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
		if(null!=MemcachedUtil.getInstance().get(shoppingUUID)){
			return MemcachedUtil.getInstance().replace(shoppingUUID,MemcachedUtil.ONE_HOUR,box);
		}else{
			return MemcachedUtil.getInstance().set(shoppingUUID,MemcachedUtil.ONE_HOUR,box);
		}
	}
	
	@Override
	public FitSdpShoppingDto getFitSdpShoppingDto(String shoppingUuid) {
		CacheBox box = MemcachedUtil.getInstance().get(shoppingUuid);
		
		if(null==box){
			return null;
		}
		if(System.currentTimeMillis()>box.getExpireTime()){
			//尝试重新查询并给出新的结果集,暂不实现,因为shopping查询的异步功能尚未做好;
			//return new FitShoppingDto();
			return null;
		}
		return CacheBoxConvert.FitSdpShoppingDtoResult.convertTo(box.getJson());
	}

	@Override
	public boolean updateFlightInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelComboGoods() {
		// TODO Auto-generated method stub
		return false;
	}

}
