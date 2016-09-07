package com.lvmama.lvfit.online.search.controller.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.enums.FitDistrictCityEnum;
import com.lvmama.lvfit.common.dto.recommend.FitRecommendInfo;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.vst.VstSeoFriendLinkDto;
import com.lvmama.lvfit.common.dto.vst.VstSeoInnerLinkDto;
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.base.utils.AddressUtils;
import com.lvmama.lvfit.online.base.utils.IpUtils;
import com.lvmama.lvfit.online.search.controller.ToSearchController;
import com.lvmama.lvfit.online.utils.ServletUtil;

@Controller
@RequestMapping("")
public class ToSearchControllerImpl extends BaseController implements ToSearchController {
	
	@Value("seoKey")
	private String seoKey ;
	
	@Value("seoDestId")
	private String seoDestId ;
	
	@Value("seoFuZhuZhi")
	private String seoFuZhuZhi ;
	
	@Value("seoOutKey")
	private String seoOutKey ;
	
	@Value("seoInKey")
	private String seoInKey ;
	
	@Value("online.index.enabled")
	private String onlineIndexEnabled;
	
	@Autowired
	private RestClient restClient;
	@Autowired
	private FitSearchClient fitSearchClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ToSearchControllerImpl.class);

	@RequestMapping(value = "online_index", method = { RequestMethod.POST, RequestMethod.GET })
	public String show(Model model,HttpServletRequest request) throws Exception {
		
        //初始化头部参数信息
        if(null!=ServletUtil.getSession(request, null, "isBackBooking")){
            ServletUtil.removeSession(request, null , "isBackBooking");
            ServletUtil.removeSession(request, null , "SESSION_FRONT_USER");
        }
		super.initModelData(model, request);
		model.addAttribute("uuid",FitSearchRequest.createUUID());
		List<VstSeoFriendLinkDto> friendList = this.querySeoFriendLink();
		List<VstSeoInnerLinkDto> innerList  = this.querySeoInnerLink();
		model.addAttribute("friendList",friendList);
		model.addAttribute("innerList",innerList);
		return "index";
	
	}
	
	@RequestMapping(value = "back_index", method = { RequestMethod.POST, RequestMethod.GET })
	public String onlineIndex(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		//初始化头部参数信息
		ServletUtil.initLvSessionId(request, response);
		ServletUtil.putSession(request, response, "isBackBooking", "true");
		super.initModelData(model, request);
		model.addAttribute("uuid",FitSearchRequest.createUUID());
		List<VstSeoFriendLinkDto> friendList = this.querySeoFriendLink();
		List<VstSeoInnerLinkDto> innerList  = this.querySeoInnerLink();
		model.addAttribute("friendList",friendList);
		model.addAttribute("innerList",innerList);
		return "back_index";
	
	}

	@RequestMapping(value = "index/ip", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> search(HttpServletRequest request) {
		
		String ip = IpUtils.getIpAddr(request);
		String addresses = "";
		// "116.228.146.90"
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			addresses = AddressUtils.getAddresses("ip="+ ip, "utf-8");
			map.put("add", addresses);
			return map;
		} catch (Exception e) {
			LOGGER.error("return address fail,ip={} address={}"+ip+addresses,e);
			//e.printStackTrace();
		}
		return null;
	}

	@Override
	public Form toDefault(Model model, Form input) {
		return null;
	}
	
	@RequestMapping(value = "seo/queryTDK", method = RequestMethod.GET)
	@ResponseBody
	public String queryTDK(HttpServletRequest request) {
		String key = request.getParameter("key");
		String seoTdkStr = restClient.get("http://www.lvmama.com/pet_topic/tdk/queryTDK.do?key="+key, String.class);
		return seoTdkStr;
	}
	
	public List<VstSeoFriendLinkDto> querySeoFriendLink() throws Exception { 
		String seoKey =getSeoOutKey();
		String seoDestId =getSeoDestId();
		String seoFuZhuZhi =getSeoFuZhuZhi();
		String seoTdkStr = "";
		List<VstSeoFriendLinkDto> list = new ArrayList<VstSeoFriendLinkDto>();
		try{
			String url = "http://www.lvmama.com/pet_topic/seoFriendLink/querySeoFriendLink.do?seoKey="+seoKey+"&destId="+seoDestId+"&fuZhuZhi="+seoFuZhuZhi;
			seoTdkStr = restClient.get(url , String.class);
			if (StringUtils.isNotBlank(seoTdkStr)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				list = objectMapper.readValue(seoTdkStr, new TypeReference<List<VstSeoFriendLinkDto>>() {
				});
				if(CollectionUtils.isNotEmpty(list) && null != list.get(0)){
					return list;
				}
				return null;
			}
		}catch(Exception e){
			return list;
		}
		return list;
	}
	
	public List<VstSeoInnerLinkDto> querySeoInnerLink() throws Exception{
		String seoKey =getSeoInKey();
		String seoDestId ="";
		String seoTdkStr = "";
		List<VstSeoInnerLinkDto> list = new ArrayList<VstSeoInnerLinkDto>();
		try{
			String url = "http://www.lvmama.com/pet_topic/seoInnerLink/querySeoInnerLink.do?seoKey="+seoKey+"&destId="+seoDestId;
			seoTdkStr =restClient.get(url, String.class);
			if (StringUtils.isNotBlank(seoTdkStr)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				list = objectMapper.readValue(seoTdkStr, new TypeReference<List<VstSeoInnerLinkDto>>() {
				});
				if(CollectionUtils.isNotEmpty(list) && null != list.get(0)){
					return list;
				}
				return null;
			}
		}catch(Exception e){
			return list;
		}
		return list;
	}
	
	private String getSeoDestId(){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(seoDestId);
	}
	
	private String getSeoFuZhuZhi(){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(seoFuZhuZhi);
	}
	
	private String getSeoInKey(){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(seoInKey);
	}
	
	private String getSeoOutKey(){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(seoOutKey);
	}
	
	@RequestMapping(value = "recommendInfo/{districtId}")
    public String getRecommendInfo(Model model, @PathVariable(value="districtId") String name) {
        FitDistrictCityEnum cityEnum = FitDistrictCityEnum.getByName(name);

        Long destId = 79L; // 默认上海
        if (cityEnum != null) {
            destId = cityEnum.getParentDestId();
        }
        Map<String, List<FitRecommendInfo>> map = fitSearchClient.getRecommendInfo(destId);
        List<FitRecommendInfo> destinations = map.get("fit_mudidi");
        sortBySeq(destinations);
        List<FitRecommendInfo> filterDestinations = new ArrayList<FitRecommendInfo>();
        List<List<FitRecommendInfo>> lists = new ArrayList<List<FitRecommendInfo>>();
        for (FitRecommendInfo destination : destinations) {
            String bakWord1 = destination.getBakWord1();
            if (StringUtils.isNotEmpty(bakWord1)) {
                String inx = bakWord1.substring(bakWord1.length()-1);
                List<FitRecommendInfo> list = map.get("fit_mudidi_wz" + inx);
                if (CollectionUtils.isEmpty(list)) {
                    continue;
                }
                String url = destination.getUrl();
                if (StringUtils.isEmpty(url)) {
                    url = "http://fit.lvmama.com";
                } else {
                    if (!url.startsWith("http://")) {
                        url = "http://" + url;
                    }
                }
                destination.setUrl(url);
                filterDestinations.add(destination);  //过滤掉没有产品的目的地
                sortBySeq(list); // 产品按seq值从大到小排列
                lists.add(list);
            }
        }
        model.addAttribute("destinations", filterDestinations);
        
        sortBySeq(map.get("fit_remaituijian"));
        model.addAttribute("belongSiteId", destId);
        model.addAttribute("map", map);
        model.addAttribute("hotDestinationImgs", lists);
        return "recommendInfo";
    }
	
	private void sortBySeq(List<FitRecommendInfo> infos) {
	    if (CollectionUtils.isEmpty(infos)) {
	        return;
	    }
	    Collections.sort(infos, new Comparator<FitRecommendInfo>() {
            @Override
            public int compare(FitRecommendInfo o1, FitRecommendInfo o2) {
                return o2.getSeq().compareTo(o1.getSeq());
            }
        });
	}
}
