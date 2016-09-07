package com.lvmama.lvfit.sonline.search.controller.form;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchResponseForm implements Serializable,Form{

	private static final long serialVersionUID = 4086903690796089875L;

	private FitSdpProductBasicInfoDto basicInfo;
	
	private List<String> photoUrls = new ArrayList<String>();

    private String productTypeName;

    public String getProductTypeName() {
        if(StringUtils.isNotBlank(this.getBasicInfo().getProductType())){
            return  PRODUCTTYPE.getCnName(this.getBasicInfo().getProductType());
        }
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public List<String> getPhotoUrls() {
		
		if(StringUtils.isNotBlank(this.getBasicInfo().getPhotoUrls())){
			String[] photoUrlsArr = this.getBasicInfo().getPhotoUrls().split(",");
			for (String photeUrl : photoUrlsArr) {
				photoUrls.add(photeUrl);
			}
		}
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Map<String, List<FitSdpCityGroupDto>> cityMaps = new TreeMap<String, List<FitSdpCityGroupDto>>();
	
	public List<Long> districtIds = new ArrayList<Long>();
	
	public List<Long> getDistrictIds() {
		return districtIds;
	}

	public void setDistrictIds(List<Long> districtIds) {
		this.districtIds = districtIds;
	}

	public SearchResponseForm(FitSdpProductBasicInfoDto basicInfo) {
	    this.basicInfo = basicInfo;
	    this.genCityMaps(basicInfo);
	}

    public FitSdpProductBasicInfoDto getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(FitSdpProductBasicInfoDto basicInfo) {
        this.basicInfo = basicInfo;
    }

    public Map<String, List<FitSdpCityGroupDto>> getCityMaps() {
        return cityMaps;
    }

    public void setCityMaps(Map<String, List<FitSdpCityGroupDto>> cityMaps) {
        this.cityMaps = cityMaps;
    }
    
    public void genCityMaps(FitSdpProductBasicInfoDto basicInfo) {
        try {
            if (CollectionUtils.isEmpty(basicInfo.getCityGroups())) {
                return;
            }
            for (FitSdpCityGroupDto district : basicInfo.getCityGroups()) {

                VSTDistrictCityEnum city = VSTDistrictCityEnum.getByCode(district.getDepartureCityCode());
                String key = city.getPinYin().substring(0, 1).toUpperCase();
                if (!cityMaps.containsKey(key)) {
                    List<FitSdpCityGroupDto> list = new ArrayList<FitSdpCityGroupDto>();
                    cityMaps.put(key, list);
                }
                List<FitSdpCityGroupDto> list = cityMaps.get(key);
                list.add(district);
                districtIds.add(district.getDepartureCityDistrictId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 由于机票每次下单最多只能9人，因此需根据每份所包含的成人儿童总数，计算下拉框中最多可选的份数：
     * 如：套餐包含2成人1儿童，则份数最多可选 ( 9 / 3 = 3 ) 份，
     * 如果不能整除则取整数， 例：套餐包含1成人1儿童，则份数最多可选 ( 9 / 2 = 4 ) 份
     */
    public int getMaxQuantityLimit() {
        try {
            if (basicInfo == null || basicInfo.getAdultQuantity() == null || basicInfo.getChildQuantity() == null) {
                return 9;
            }
            Long adultQuantity = basicInfo.getAdultQuantity() == 0 ? 1L : basicInfo.getAdultQuantity();
            Long childQuantity = basicInfo.getChildQuantity();
            
            int totalQuantity = adultQuantity.intValue() + childQuantity.intValue();
            return (9 / totalQuantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 9;
    }
    
    /**
     * 得到最小成人数
     */
    public int getAdultMinQuantity() {
        try {
            int adultMinQuantity = basicInfo.getAdditionalInfoDto().getAdultMinQuantity().intValue();
            if (adultMinQuantity > 1) {
                return adultMinQuantity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    
    /**
     * 得到最大成人数
     */
    public int getAdultMaxQuantity() {
        try {
            int adultMaxQuantity = basicInfo.getAdditionalInfoDto().getAdultMaxQuantity().intValue();
            if (adultMaxQuantity < 9) {
                return adultMaxQuantity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 9;
    }
    
    /**
     * 得到最小儿童数
     */
    public int getChildMinQuantity() {
        try {
            int childMinQuantity = basicInfo.getAdditionalInfoDto().getChildMinQuantity().intValue();
            if (childMinQuantity > 0) {
                return childMinQuantity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    /**
     * 得到最大儿童数
     * @return
     */
    public int getChildMaxQuantity() {
        try {
            int childMaxQuantity = basicInfo.getAdditionalInfoDto().getChildMaxQuantity().intValue();
            if (childMaxQuantity < 4) {
                return childMaxQuantity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 4;
    }

    public static enum PRODUCTTYPE {

        INNERLINE(1,"国内"),INNERSHORTLINE(2,"国内-短线"),INNERLONGLINE(3,"国内-长线"),
        FOREIGNLINE(4,"出境/港澳台"),EXPRESS(5,"快递"),DEPOSIT(6,"押金");

        private int      index;
        private String cnName;

        public static String getCnName(String code) {
            for (PRODUCTTYPE item : PRODUCTTYPE.values()) {
                if (item.getCode().equals(code)) {
                    return item.getCnName();
                }
            }
            return code;
        }

        public static String getCodeByIndex(int index) {
            for (PRODUCTTYPE item : PRODUCTTYPE.values()) {
                if (item.index == index) {
                    return item.getCode();
                }
            }
            return "";
        }

        public static int getIndexByCode(String code) {
            for (PRODUCTTYPE item : PRODUCTTYPE.values()) {
                if (org.apache.commons.lang3.StringUtils.endsWithIgnoreCase(item.name(), code)) {
                    return item.index;
                }
            }
            return 0;
        }



        PRODUCTTYPE(int index,String name) {
            this.index = index;
            this.cnName = name;
        }

        public String getCode() {
            return this.name();
        }


        public String getCnName() {
            return this.cnName;
        }

        @Override
        public String toString() {
            return this.name();
        }
    }
}
