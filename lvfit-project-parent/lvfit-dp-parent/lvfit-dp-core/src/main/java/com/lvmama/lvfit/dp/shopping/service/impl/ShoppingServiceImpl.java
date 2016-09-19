package com.lvmama.lvfit.dp.shopping.service.impl;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.MemcachedUtil;
import com.lvmama.lvfit.common.cache.CacheBox;
import com.lvmama.lvfit.common.cache.CacheBoxConvert;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ShoppingServiceImpl implements ShoppingService {

	private static Logger logger = LoggerFactory.getLogger(ShoppingServiceImpl.class);	
	
	/**
	 * 购物车缓存时间
	 */
	@Value("lvfit.shopping.cacheTime")
	private String cacheExpireTime;
	
	private Long getCacheExpireTime(){
		return Long.valueOf((String)CustomizedPropertyPlaceholderConfigurer.getContextProperty(cacheExpireTime));
	}
	
	@Override
	public FitShoppingDto getFitShopping(String shoppingUUID) {
		
		CacheBox box = MemcachedUtil.getInstance().get(shoppingUUID);
		
		if(null==box){
			return null;
		}
		if(System.currentTimeMillis()>box.getExpireTime()){
			//尝试重新查询并给出新的结果集,暂不实现,因为shopping查询的异步功能尚未做好;
			//return new FitShoppingDto();
			return null;
		}

		return CacheBoxConvert.ShoppingDtoResult.convertTo(box.getJson());
	}

	@Override
	public boolean putShoppingCache(String shoppingUUID, FitShoppingDto dto) {

		CacheBox box = new CacheBox();
		box.setKey(shoppingUUID);
		box.setJson(CacheBoxConvert.ShoppingDtoResult.convertFrom(dto));
		box.setExpireTime(System.currentTimeMillis()+getCacheExpireTime());
		
		return put2Cache(shoppingUUID, box);
		
	}

	private boolean put2Cache(String shoppingUUID, CacheBox box){
		
		if(null==box
				||!box.valid()){
			return false;
		}
		try{
			logger.error("key:"+box.getKey());
			logger.error("size:"+box.getJson().length());
		}catch(Exception ex){
		}
		
		if(null!=MemcachedUtil.getInstance().get(shoppingUUID)){
			return MemcachedUtil.getInstance().replace(shoppingUUID,MemcachedUtil.ONE_HOUR,box);
		}else{
			return MemcachedUtil.getInstance().set(shoppingUUID,MemcachedUtil.ONE_HOUR,box);
		}
	}
}
