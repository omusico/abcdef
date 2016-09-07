package com.lvmama.lvfit.common.cache;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.ZipUnZipUtils;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import org.codehaus.jackson.type.TypeReference;

import java.util.List;
import java.util.Map;

public enum CacheBoxConvert {

    ShoppingDtoResult(new TypeReference<FitShoppingDto>() {
    }),
    FlightSearchInfosResult(new TypeReference<FitSearchResult>() {
    }),
    HotelSearchInfosResult(new TypeReference<List<HotelSearchHotelDto>>() {
    }),
    FitSdpShoppingDtoResult(new TypeReference<FitSdpShoppingDto>() {
    }),
    HotelCondition(new TypeReference<Map<String, Object>>() {
    }),
    FitSdpProductBasicInfoDto(new TypeReference<FitSdpProductBasicInfoDto>() {
    }),
    FitSdpGoodsDto(new TypeReference<FitSdpGoodsDto>() {
    }),
    FitSdpCalendarInfoMap(new TypeReference<Map<Long, List<FitSdpProductCalendarDto>>>(){
    }),
    String(new TypeReference<String>() {
    });

    public TypeReference type;

    CacheBoxConvert(TypeReference type) {
        this.type = type;
    }

    public <T> T convertTo(String json) {
        try {
            String unZipStr = ZipUnZipUtils.getInstance().unzipBase642String(json);
            return JSONMapper.getInstance().readValue(unZipStr, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String convertFrom(Object obj) {
        try {
            String jsonStr = JSONMapper.getInstance().writeValueAsString(obj);
            return ZipUnZipUtils.getInstance().zipString2Base64(jsonStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
