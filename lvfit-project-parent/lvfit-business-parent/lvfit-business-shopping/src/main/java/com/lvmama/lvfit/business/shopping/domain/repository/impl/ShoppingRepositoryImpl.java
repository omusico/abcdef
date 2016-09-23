package com.lvmama.lvfit.business.shopping.domain.repository.impl;

import java.util.Date;
import java.util.List;

import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.shopping.domain.ShoppingDetail;
import com.lvmama.lvfit.business.shopping.domain.repository.ShoppingRepository;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.ShopingMapper;

@Repository
public class ShoppingRepositoryImpl implements ShoppingRepository{

	@Autowired
	private ShopingMapper  ShopingMapper;
	
	@Override
	public ShoppingDetailDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ShoppingDetail load(ShoppingDetailDto r) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ShoppingDetailDto save(ShoppingDetailDto dto) {
		/*ShoppingDetailDto bean	=ShopingMapper.getByCode(dto.getShoppingUuid());			
		if(bean != null && bean.getId()!=null){
			dto.setUpdateTime(new Date());
			ShopingMapper.updateByCode(dto.getShoppingUuid(), dto);		
		}else{
			dto.setCreateTime(new Date());				
			ShopingMapper.insert(dto);
		}*/
		dto.setCreateTime(new Date());				
		ShopingMapper.insert(dto);
		return dto;
	}
	@Override
	public List<ShoppingDetailDto> getListByCode(String code) {
		return ShopingMapper.getListByCode(code);
	}
	@Override
	public List<ShoppingDetailDto> query(BaseQueryDto<? extends Dto> q){
		List<ShoppingDetailDto> list = ShopingMapper.query(q);
		try {			
			if (!CollectionUtils.isEmpty(list)) {
				for (ShoppingDetailDto detailDto : list) {
					String searchCondtion = detailDto.getSearchCondition();
					if (searchCondtion != null) {
						FitSearchRequest searchRequest = JSONMapper.getInstance().readValue(searchCondtion,
										new TypeReference<FitSearchRequest>() {});
						if (searchRequest.getFitPassengerRequest() != null) {
							detailDto.setDepartureCityName(searchRequest
								.getDepartureCityName());
							detailDto.setArrivalCityName(searchRequest
								.getArrivalCityName());

							HotelQueryRequest hotelQueryRequest = searchRequest.getHotelSearchRequests().get(0);

							String cityName = hotelQueryRequest.getCityName();
							detailDto.setHotelCityName(cityName);

							FitPassengerRequest fitPassengerRequest = searchRequest.getFitPassengerRequest();
							if(fitPassengerRequest!=null){
								detailDto.setAdultCount(fitPassengerRequest.getAdultCount()+"");
								detailDto.setChildCount(fitPassengerRequest.getChildCount()+"");
							}
						} else {
							FitBaseSearchRequest request = JSONMapper.getInstance().readValue(searchCondtion,
								new TypeReference<FitBaseSearchRequest>() {});
							detailDto.setDepartureCityName(request.getDepartureCityName());
							detailDto.setArrivalCityName(request.getArrivalCityName());
							detailDto.setHotelCityName(request.getCityName());
							detailDto.setAdultCount(String.valueOf(request.getAdultsCount()));
							detailDto.setChildCount(String.valueOf(request.getChildCount()));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int count(BaseQueryDto<? extends Dto> q) {
		return ShopingMapper.count(q);
	}

    @Override
    public int update(ShoppingDetailDto dto) {
       return ShopingMapper.updateByCode(dto.getShoppingUuid(), dto);
    }

}
