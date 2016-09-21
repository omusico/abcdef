package com.lvmama.lvfit.common.dto.search.flight.result;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.SortRuleType;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;

/**
 * 包机切位的航班过滤工具类.
 * @author Administrator
 *
 */
public class CharterFlightFilterUtil {
	static Logger logger = LoggerFactory.getLogger(CharterFlightFilterUtil.class);
	/**
     * 判断是否是包机航班
     * @param fitOrderFlightDtos
     * @return
     */
    public static boolean isCharterFlight(List<FitOrderFlightDto> fitOrderFlightDtos){
    	//两个航段类型，并且都是包机类型
    	if(CollectionUtils.isNotEmpty(fitOrderFlightDtos)&&fitOrderFlightDtos.size()==2){
    		if(SuppSaleType.DomesticProduct.name().equals(fitOrderFlightDtos.get(0).getSaleType())){
    			if(SuppSaleType.DomesticProduct.name().equals(fitOrderFlightDtos.get(1).getSaleType())){
        			return true;
        		}
    		}
    	}
    	return false;
    }
    
    /**
     * 判断是否是包机航班
     * @param fitOrderFlightDtos
     * @return
     */
    public static boolean isCharterFlightDots(List<FlightSearchFlightInfoDto> fitOrderFlightDtos){
    	//两个航段类型，并且都是包机类型
    	if(CollectionUtils.isNotEmpty(fitOrderFlightDtos)&&fitOrderFlightDtos.size()==2){
    		if(SuppSaleType.DomesticProduct.name().equals(fitOrderFlightDtos.get(0).getSaleType())){
    			if(SuppSaleType.DomesticProduct.name().equals(fitOrderFlightDtos.get(1).getSaleType())){
        			return true;
        		}
    		}
    	}
    	return false;
    }
    
    /**
     * 判断是不是包机
     * @param flightSearchFlightInfoDto
     * @return
     */
    public static boolean isCharter(FlightSearchFlightInfoDto flightSearchFlightInfoDto){
 		if(SuppSaleType.DomesticProduct.name().equals(flightSearchFlightInfoDto.getSaleType())){
			return true;
		} 
    	return false;
    }
    
    /**
     * 判断是不是包机
     * @param fitOrderFlightDto
     * @return
     */
    public static boolean isCharter(FitOrderFlightDto fitOrderFlightDto){
 		if(SuppSaleType.DomesticProduct.name().equals(fitOrderFlightDto.getSaleType())){
			return true;
		} 
    	return false;
    }
    
	/**
	 * 是否查询包机航班.
	 * @return
	 */
	public static boolean getQueryCharsetFlight() {
		Boolean ans = Boolean.valueOf(CustomizedPropertyPlaceholderConfigurer.getContextProperty("queryCharsetFlight")+"");
		return ans.booleanValue();  
    }
	
	public static void main(String[] args){
		Boolean b = Boolean.FALSE;
		System.out.println(Boolean.valueOf(null));
		if(b){
			System.out.println(1);
		}else{
			System.out.println(2);
		}
	}
	
	/**
	 * 过滤包机的航班信息.
	 * @param searchFlightInfoDtos
	 * @param removeCharter 是否删除包机信息，true删除包机信息，false就仅仅保留包机信息
	 */
	public static void filterCharterFlight(List<FlightSearchFlightInfoDto> searchFlightInfoDtos ,boolean removeCharter) {  
		List<FlightSearchFlightInfoDto> noUsefulFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
	 	for (FlightSearchFlightInfoDto searchFlightInfoDto : searchFlightInfoDtos) { 
	 		//如果要删除包机信息
	 		if(removeCharter){
		 		if(SuppSaleType.DomesticProduct.name().equals(searchFlightInfoDto.getSaleType())){ 				  
		 			noUsefulFlightInfoDtos.add(searchFlightInfoDto);
		 		} 
	 		}
	 		//如果仅仅保留包机信息.就删除非包机类型的航班
	 		else{
	 			if(!SuppSaleType.DomesticProduct.name().equals(searchFlightInfoDto.getSaleType())){ 				  
		 			noUsefulFlightInfoDtos.add(searchFlightInfoDto);
		 		} 
	 			//如果包机信息里面，没有返程航班信息，也删除该包机的航班信息.现在只考虑往返程包机的。
	 			if(searchFlightInfoDto.getReturnFlightInfoDto()==null){
	 				noUsefulFlightInfoDtos.add(searchFlightInfoDto);
	 			}
	 		}
		}
		searchFlightInfoDtos.removeAll(noUsefulFlightInfoDtos);
	} 
	
	/**
	 * 判断航班是否符合交通规则里面的时间范围。符合就返回true，否则就返回false.
	 * @param searchFlightInfoDto
	 * @param goRule
	 * @return
	 */
	private static boolean chargeRule(FlightSearchFlightInfoDto searchFlightInfoDto,FitSdpProductTrafficRulesDto rule){
		if(StringUtils.isNotBlank(rule.getDepBegTime())&&StringUtils.isNotBlank(rule.getDepEndTime())){
			  Date curFlightdepartureTime = DateUtils.parseDate(searchFlightInfoDto.getDepartureTime(),DateUtils.YYYY_MM_DD_HH_MM);
			  Date trafficRuleDepBeg = DateUtils.parseDate(searchFlightInfoDto.getDepartureDate()+" "+rule.getDepBegTime(),DateUtils.YYYY_MM_DD_HH_MM);
			  Date trafficRuleDepEnd = DateUtils.parseDate(searchFlightInfoDto.getDepartureDate()+" "+rule.getDepEndTime(),DateUtils.YYYY_MM_DD_HH_MM);
			  //如果包机出发航班出发时间不在交通规则的起止时间范围之类，就是无效数据，删除之.
			  if(!(curFlightdepartureTime.compareTo(trafficRuleDepBeg)>=0&&curFlightdepartureTime.compareTo(trafficRuleDepEnd)<=0)){
				 return false;
			  }
	    }
		
		//再比较包机的返程航班出发时间在不在交通规则的到达的起止时间范围，不在就删除之.
		if(StringUtils.isNotBlank(rule.getArrBegTime())&&StringUtils.isNotBlank(rule.getArrEndTime())){
			  Date curFlightArrEndTime = DateUtils.parseDate(searchFlightInfoDto.getArrivalTime(),DateUtils.YYYY_MM_DD_HH_MM);
			  Date trafficRuleArrBeg = DateUtils.parseDate(searchFlightInfoDto.getDepartureDate()+" "+rule.getArrBegTime(),DateUtils.YYYY_MM_DD_HH_MM);
			  Date trafficRuleArrEnd = DateUtils.parseDate(searchFlightInfoDto.getDepartureDate()+" "+rule.getArrEndTime(),DateUtils.YYYY_MM_DD_HH_MM);
			  if(!(curFlightArrEndTime.compareTo(trafficRuleArrBeg)>=0&&curFlightArrEndTime.compareTo(trafficRuleArrEnd)<=0)){
				  return false;
			  }
		 }
		return true;
	}
	
	/**
	 * 根据交通规则过滤包机航班
	 * @param searchFlightInfoDtos
	 * @param goRule 去程的交通规则
	 * @param backRule 返程的交通规则
	 */
	public static void filterFlightByTrafficRules(List<FlightSearchFlightInfoDto> searchFlightInfoDtos,FitSdpProductTrafficRulesDto goRule,FitSdpProductTrafficRulesDto backRule) {
		List<FlightSearchFlightInfoDto> noUsefulFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
		if((StringUtils.isNotBlank(goRule.getDepBegTime())&&StringUtils.isNotBlank(goRule.getDepEndTime()))
			||StringUtils.isNotBlank(backRule.getArrBegTime())&&StringUtils.isNotBlank(backRule.getArrEndTime())){
			for (FlightSearchFlightInfoDto searchFlightInfoDto : searchFlightInfoDtos) {
				//比较包机的去程航班出发时间和到达时间在不在交通规则的起止时间范围，不在就删除之.
				if(!chargeRule(searchFlightInfoDto,goRule)){
					noUsefulFlightInfoDtos.add(searchFlightInfoDto);
					continue;
				}				 
					
				//比较返程的出发与到达时间是否符合交通规则.
				List<FlightSearchFlightInfoDto> returnFlightInfoDtos = searchFlightInfoDto.getReturnFlightInfoDto();
				List<FlightSearchFlightInfoDto> noUsefulReturnFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
				for(FlightSearchFlightInfoDto returnFlightInfoDto:returnFlightInfoDtos){
					if(!chargeRule(returnFlightInfoDto,backRule)){
						noUsefulReturnFlightInfoDtos.add(searchFlightInfoDto);
						continue;
					}	
				}
				//去掉不符合规则的回程.
				returnFlightInfoDtos.removeAll(noUsefulReturnFlightInfoDtos);
				
				//如果返程航班的个数为0，就去掉当前的去程航班信息.
				if(returnFlightInfoDtos.size()<1){
					noUsefulFlightInfoDtos.add(searchFlightInfoDto);
				}
			}
			//去掉不符合规则的去程
			searchFlightInfoDtos.removeAll(noUsefulFlightInfoDtos);
		}
	}
	
	/**
	 * 过滤包机的儿童航班情况.
	 * @param flightInfoDtos
	 */
	public static void filterNoChildFlight(List<FlightSearchFlightInfoDto> flightInfoDtos) {

	    List<FlightSearchFlightInfoDto> noUsefulFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
	    for (FlightSearchFlightInfoDto searchFlightInfoDto : flightInfoDtos) {
	    	Map<String,FlightSearchSeatDto> childrenSeats = searchFlightInfoDto.getChildrenSeats();
	    	List<FlightSearchSeatDto> usefulSeats = new ArrayList<FlightSearchSeatDto>();
	    	if(null !=searchFlightInfoDto.getSeats()&&CollectionUtils.isNotEmpty(searchFlightInfoDto.getSeats())&&MapUtils.isNotEmpty(childrenSeats)){
	    		for (FlightSearchSeatDto seatDto : searchFlightInfoDto.getSeats()) {
					if(childrenSeats.containsKey(seatDto.getSeatClassCode())&&childrenSeats.get(seatDto.getSeatClassCode())!=null){
						usefulSeats.add(seatDto);
					}
				}
		    	if(CollectionUtils.isNotEmpty(usefulSeats)){
		    		searchFlightInfoDto.setSeats(usefulSeats);
		    	}else{
		    		noUsefulFlightInfoDtos.add(searchFlightInfoDto);
		    	}
	    	}
		}
	    flightInfoDtos.removeAll(noUsefulFlightInfoDtos);
   }
	
	private static boolean isOverNight(FlightSearchFlightInfoDto flightInfoDto){
		String depDateStr = flightInfoDto.getDepartureDate();
        String arrivalTime = flightInfoDto.getArrivalTime();
        Date arvDateD = DateUtils.parseDate(arrivalTime, "yyyy-MM-dd HH:mm:ss");
        String arvDateStr = DateUtils.formatDate(arvDateD, "yyyy-MM-dd");
        if (depDateStr.equals(arvDateStr)) {
           return false;
        } 
        return true;
	}
	
	/**
	 * 设置隔夜航班标示.
	 * @param searchFlightInfoDtos
	 */
	public static void setOverNightFlightFlag(List<FlightSearchFlightInfoDto> searchFlightInfoDtos) {
        for (FlightSearchFlightInfoDto flightInfoDto : searchFlightInfoDtos) {
            flightInfoDto.setHighLightFlag(isOverNight(flightInfoDto));             
            
            //设置返程的是否隔夜.
			List<FlightSearchFlightInfoDto> returnFlightInfoDtos = flightInfoDto.getReturnFlightInfoDto();
			for(FlightSearchFlightInfoDto returnFlightInfoDto:returnFlightInfoDtos){
				returnFlightInfoDto.setHighLightFlag(isOverNight(returnFlightInfoDto));
			}
        }
    }
	
	/**
	 * 过滤航班不足的包机舱位.
	 * @param goodsRequest
	 * @param searchFlightInfoDtos
	 */
	public static void filterUnderStockFlight(FitSdpGoodsRequest goodsRequest,List<FlightSearchFlightInfoDto> searchFlightInfoDtos) {
       List<FlightSearchFlightInfoDto> noUsefulFlightInfos= new ArrayList<FlightSearchFlightInfoDto>();
       FitSearchRequest fitSearchRequest = new FitSearchRequest();
       FitPassengerRequest fitPassengerRequest = new FitPassengerRequest();

       long adultCount = goodsRequest.getAdultQuantity() * goodsRequest.getQuantity();
       long childCount = goodsRequest.getChildQuantity() * goodsRequest.getQuantity();
      
       fitPassengerRequest.setAdultCount((int)adultCount);
       fitPassengerRequest.setChildCount((int)childCount);
       fitSearchRequest.setFitPassengerRequest(fitPassengerRequest);

       for(FlightSearchFlightInfoDto flightInfoDto:searchFlightInfoDtos){
           setAvailableCharterSeat(flightInfoDto, fitSearchRequest);
           //如果返程的舱位是空，就直接删除.
           if(flightInfoDto.getReturnFlightMap().size()<1){
        	   noUsefulFlightInfos.add(flightInfoDto);
           } 
       }
       searchFlightInfoDtos.removeAll(noUsefulFlightInfos);
    } 
	 
	
	/**
	 * 将一个去程--多个返程转为新的一个去程-一个返程的数组.
	 * @param flightInfos
	 * @return
	 */
	public static List<FlightSearchFlightInfoDto> setNewFlightDtoes(List<FlightSearchFlightInfoDto> flightInfos) {
		List<FlightSearchFlightInfoDto> resultList = new ArrayList<FlightSearchFlightInfoDto>();
		try {
			 for(FlightSearchFlightInfoDto flightInfo:flightInfos){
		    	//去掉航班原有的舱位信息。应该直接从getReturnFlightInfoDto中的价格政策里面取舱位信息.
		    	flightInfo.setSeats(null); 
		    	
		    	Map<String, Map<String, List<FlightSearchSeatDto>>> returnFlightMap = flightInfo.getReturnFlightMap();
		    	//找到全部的返程航班
		    	List<FlightSearchFlightInfoDto> backFlights = flightInfo.getReturnFlightInfoDto();
		    	for(FlightSearchFlightInfoDto backFlight:backFlights){
		    		FlightSearchFlightInfoDto newFlightDto = (FlightSearchFlightInfoDto)BeanUtils.cloneBean(flightInfo);   
		    		Map<String, List<FlightSearchSeatDto>> policyToSeatMap = returnFlightMap.get(backFlight.getFlightNo());
		    		Map<String, Map<String, List<FlightSearchSeatDto>>> newReturnFlightMap = new HashMap<String, Map<String, List<FlightSearchSeatDto>>>();
		    		newReturnFlightMap.put(backFlight.getFlightNo(), policyToSeatMap);
		    		List<FlightSearchFlightInfoDto> newReturnFlight = new ArrayList<FlightSearchFlightInfoDto>();
		    		if(policyToSeatMap==null){
		    			continue;
		    		}
		    		List<FlightSearchSeatDto> seats = policyToSeatMap.entrySet().iterator().next().getValue();
		    		
		    		List<FlightSearchSeatDto> goSeats = new ArrayList<FlightSearchSeatDto>();
		    		goSeats.add(seats.get(0));
		    		
		    		List<FlightSearchSeatDto> backSeats = new ArrayList<FlightSearchSeatDto>();
		    		backSeats.add(seats.get(1));
		    		
		    		//设置返程的座位对象为空  
		    		newFlightDto.setSeats(goSeats);
		    		//设置返程的座位对象为空 
		    		backFlight.setSeats(backSeats); 
		    		backFlight.setReturnFlightMap(newReturnFlightMap);
		    		newReturnFlight.add(backFlight); 
		    		newFlightDto.setReturnFlightMap(newReturnFlightMap);
		    		newFlightDto.setReturnFlightInfoDto(newReturnFlight); 
		    		resultList.add(newFlightDto);
		    	}	    	
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    return resultList;
    } 
	 
	/**
	 * 过滤某个政策id对应的座位map满足座位数.
	 * @param allSeat
	 */
	private static Map<String, List<FlightSearchSeatDto>> filterEnoughSeatMap(Map<String, List<FlightSearchSeatDto>> allSeat,int allNeedCount){
		//舱位满足要求的政策id对应的价格map.
		Map<String, List<FlightSearchSeatDto>> enoughSeatsMap = new HashMap<String, List<FlightSearchSeatDto>>();
				
		Set<Entry<String, List<FlightSearchSeatDto>>> allEntry = allSeat.entrySet();
		Iterator<Entry<String, List<FlightSearchSeatDto>>> it = allEntry.iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<FlightSearchSeatDto>> entry = (Map.Entry) it.next();
			List<FlightSearchSeatDto> seats = entry.getValue();
			//去程舱位
			FlightSearchSeatDto goSeat = seats.get(0);
			//返程舱位
			FlightSearchSeatDto backSeat = seats.get(1);
			if (goSeat.getInventoryCount() >= allNeedCount
					&& backSeat.getInventoryCount() >= allNeedCount) { 
				enoughSeatsMap.put(entry.getKey(), seats);
			}
		}
		return enoughSeatsMap;
	}
	
	/**
	 * 设置包机舱位相关参数，例如判断舱位是否足够.
	 * 包机没有儿童舱.
	 * @param flightSearchFlightInfoDto
	 * @param request
	 * @return
	 */
	public static void setAvailableCharterSeat(FlightSearchFlightInfoDto flightSearchFlightInfoDto,FitSearchRequest request){ 
		//包机没有儿童舱位，儿童卖成人价.所以直接比较可用数量与儿童+成人比较
		int allNeedCount = request.getFitPassengerRequest().getAdultCount()+request.getFitPassengerRequest().getChildCount();
		//舱位满足要求的政策id对应的价格map.
		Map<String, Map<String, List<FlightSearchSeatDto>>> enoughSeatsMap = new HashMap<String, Map<String, List<FlightSearchSeatDto>>>();
		
		//循环全部的政策id对应的价格map.
		Map<String, Map<String, List<FlightSearchSeatDto>>> flightSeatsMap = flightSearchFlightInfoDto.getReturnFlightMap();
		Set<Entry<String, Map<String, List<FlightSearchSeatDto>>>> allEntry = flightSeatsMap.entrySet();
		Iterator<Entry<String, Map<String, List<FlightSearchSeatDto>>>> it = allEntry.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Map<String, List<FlightSearchSeatDto>>> entry = (Map.Entry) it.next();
			String flightNo = entry.getKey();
			Map<String, List<FlightSearchSeatDto>> seats = entry.getValue();
			
			seats = filterEnoughSeatMap(seats,allNeedCount);
			
			if(seats.size()>0){
				enoughSeatsMap.put(flightNo, seats);
			}
		} 
		
		 
		//重新设置政策id对应seats的map为有足够数量的map.
		flightSearchFlightInfoDto.setReturnFlightMap(enoughSeatsMap);  
	} 
	
	/**
     * 1. 将航班按舱位价格由低到高排序
     * 2. 取每个航班的最低价舱位，将航班按排序规则进行排序（起飞时间|价格）
     */
	public static void sortByTrafficRule(List<FlightSearchFlightInfoDto> flightInfos,
            FitSdpProductTrafficRulesDto goRule,FitSdpProductTrafficRulesDto backRule) {
        if (CollectionUtils.isNotEmpty(flightInfos)) { 
        	//不可以单独根据seats里面的数据进行排序。因为是包机，去程+返程是绑定好关系的。如果一个换了位置，另外一个也应该位置跟着动。
        	//舱位的排序，必须根据去程+返程两个对应位置的价格顺序一起变化！！
        	//先把每个航班信息里面的政策id对应的舱位的map里面的两个舱位的价格之和进行排序.   	 
        	//航班的排序，就根据最小的政策id对应价格进行排序。
            if (goRule.getSortRuleType() == SortRuleType.SORT_BY_PRICE_ASC) {
            	Collections.sort(flightInfos, new Comparator<FlightSearchFlightInfoDto>() { 
        			@Override
        			public int compare(FlightSearchFlightInfoDto o1,
        					FlightSearchFlightInfoDto o2) {
        				BigDecimal price1 = getBaseAdultPrice(o1);
        				BigDecimal price2 = getBaseAdultPrice(o2);
        				return price1.compareTo(price2);
        			} 
        		});
            }

            //出发时间的排序没有修改.
            if (goRule.getSortRuleType() == SortRuleType.SORT_BY_DEPTIME_ASC) {
                Collections.sort(flightInfos, new Comparator<FlightSearchFlightInfoDto>() {
                    @Override
                    public int compare(FlightSearchFlightInfoDto o1, FlightSearchFlightInfoDto o2) {
                        return DateUtils
                                .parseDate(o1.getDepartureTime(), DateUtils.YYYY_MM_DD_HH_MM_SS)
                                .compareTo(DateUtils.parseDate(o2.getDepartureTime(),
                                        DateUtils.YYYY_MM_DD_HH_MM_SS));
                    }
                });
            }
        }
    }
    
    /**
     * 返回一个包机航班信息里面的基价.
     * @param flightInfo
     * @return
     */
    private static BigDecimal getBaseAdultPrice(FlightSearchFlightInfoDto flightInfo){  
    	FlightSearchFlightInfoDto backFlight = flightInfo.getReturnFlightInfoDto().get(0);
    	Map<String, List<FlightSearchSeatDto>> policySeats = backFlight.getReturnFlightMap().get(backFlight.getFlightNo());
    	Map.Entry<String,List<FlightSearchSeatDto>> policyToSeatEntry = policySeats.entrySet().iterator().next();
    	FlightSearchSeatDto goSeat = policyToSeatEntry.getValue().get(0);
    	FlightSearchSeatDto backSeat = policyToSeatEntry.getValue().get(1);
    	return goSeat.getSalesPrice().add(backSeat.getSalesPrice());
    }
     
    /**
     * 计算价差.
     * @param flightInfos
     * @param adultQuantity
     * @param childQuantity
     * @param quantity
     */
    public static  void calculateDiffPrice(List<FlightSearchFlightInfoDto> flightInfos, Long adultQuantity, Long childQuantity, Long quantity) {
	    if (CollectionUtils.isEmpty(flightInfos)
	            || CollectionUtils.isEmpty(flightInfos.get(0).getReturnFlightInfoDto())) {
	        return;
	    }
	    //成人价等于第一个位置的航班里面的去程第一个舱位价格+返程第一个舱位价格	    
	    BigDecimal iniAdultPrice = getBaseAdultPrice(flightInfos.get(0));
	    //儿童价=成人价
	    BigDecimal iniChildPrice = iniAdultPrice;
	    //基准价=成人数*成人价+儿童数*儿童价
	    BigDecimal baseSumPrice = iniAdultPrice.multiply(BigDecimal.valueOf(adultQuantity)).add(iniChildPrice.multiply(BigDecimal.valueOf(childQuantity)));
	     
	    for (FlightSearchFlightInfoDto searchFlight : flightInfos) {
	    	BigDecimal price = getBaseAdultPrice(searchFlight);
	    	//计算总价
			BigDecimal sumPrice = price.multiply(BigDecimal.valueOf(adultQuantity)).add(price.multiply(BigDecimal.valueOf(childQuantity)));
			
			Map<String, List<FlightSearchSeatDto>> policySeats = searchFlight.getReturnFlightMap().entrySet().iterator().next().getValue();
			
			Map.Entry<String,List<FlightSearchSeatDto>> policyToSeatEntry = policySeats.entrySet().iterator().next();
	    	FlightSearchSeatDto goSeat = policyToSeatEntry.getValue().get(0);
	    	FlightSearchSeatDto backSeat = policyToSeatEntry.getValue().get(1);
	    	
	    	//价差数据保存在去程的舱位上面。返程舱位上面的价差不设置。
			goSeat.setDifferentPrice(sumPrice.subtract(baseSumPrice).multiply(BigDecimal.valueOf(quantity)));
			backSeat.setDifferentPrice(new BigDecimal(0)); 
	    }
	}
    
    /**
     * 根据往返程计算基准价. 
     * @param go 去程
     * @param back 返程
     * @param childSameAsAdult 儿童是否等于成人价.
     * @param adultCount 成人数
     * @param childCount 儿童数
     * @return
     */
    public static BigDecimal calcBasePrice(FlightSearchFlightInfoDto go,FlightSearchFlightInfoDto back,boolean childSameAsAdult,Long adultCount,Long childCount){
    	if(CollectionUtils.isEmpty(go.getSeats())){
    		return  new BigDecimal(-1);
    	}
    	if(CollectionUtils.isEmpty(back.getSeats())){
    		return  new BigDecimal(-1);
    	}
    	//出发程的儿童与成人价格
		BigDecimal depAdultPrice = go.getSeats().get(0).getSalesPrice();
	    BigDecimal depChildPrice = go.getSeats().get(0).getChildrenPrice();
	    if(childSameAsAdult){
	    	depChildPrice = depAdultPrice;
	    }
	    
	    BigDecimal arvAdultPrice = back.getSeats().get(0).getSalesPrice();
	    BigDecimal arvChildPrice = back.getSeats().get(0).getChildrenPrice();
	    if(childSameAsAdult){
	    	depChildPrice = depAdultPrice;
	    }
	    BigDecimal goSumPrice = depAdultPrice.multiply(BigDecimal.valueOf(adultCount)).add(depChildPrice.multiply(BigDecimal.valueOf(childCount)));
	    BigDecimal backSumPrice = arvAdultPrice.multiply(BigDecimal.valueOf(adultCount)).add(arvChildPrice.multiply(BigDecimal.valueOf(childCount))); 
	    return goSumPrice.add(backSumPrice);
    } 
    
    /**
     * 从包机信息中得到全部包机航班里面的最便宜的往返程航班列表.
     * 返回两个对象：去程航班+返程航班
     * @param charterFlights
     * @return
     */
    public static List<FlightSearchFlightInfoDto> getCheapestGoAndBackInCharterFlights(List<FlightSearchFlightInfoDto> charterFlights){
    	List<FlightSearchFlightInfoDto> result = new ArrayList<FlightSearchFlightInfoDto>();
    	FlightSearchFlightInfoDto goFlight = charterFlights.get(0); 
		FlightSearchFlightInfoDto backFlight = goFlight.getReturnFlightInfoDto().get(0);
		result.add(goFlight);
    	result.add(backFlight);
		return result;
	} 
    
    /**
	 * 初始进入页面设置选择的航班，根据产品里面的是否非对接优先字段进行控制。找到默认选择的往返程.
	 * 如果非对接优先展示包机切位航班。
	 * 否则，展示价格最低的往返程航班。
	 * @param respForm
	 * @param req
	 */
	public static List<FlightSearchFlightInfoDto> setSumFlights(FitSdpGoodsDto goods ,FitSdpGoodsRequest req){
		//包机信息
		List<FlightSearchFlightInfoDto> charterFlights = goods.getCharterFlightInfos();
		//以前默认的查询出发航班信息
		List<FlightSearchFlightInfoDto> depFlights = goods.getDepFlightInfos();
		//以前默认查询的到达航班信息
		List<FlightSearchFlightInfoDto> arvFlights = goods.getArvFlightInfos();
		
		//计算两种航班里面的最低价的航班.
		FlightSearchFlightInfoDto sumDepFlights = new FlightSearchFlightInfoDto();
		FlightSearchFlightInfoDto sumArvFlights = new FlightSearchFlightInfoDto();
		
		//非对接优先，就只计算包机航班里面最小价格。
		if(req.getIsCharterFlightFirst()!=null&&"TRUE".equals(req.getIsCharterFlightFirst().toUpperCase())){
			if(!CollectionUtils.isEmpty(charterFlights))  {
				List<FlightSearchFlightInfoDto> cheapestFlights = CharterFlightFilterUtil.getCheapestGoAndBackInCharterFlights(charterFlights);
				sumDepFlights=cheapestFlights.get(0);  
				sumArvFlights=cheapestFlights.get(1);
			}
			//如果没有包机航班，就只好取默认查询方式里面的第一个航班
			else{
				sumDepFlights=depFlights.get(0);  
				sumArvFlights=arvFlights.get(0);
			}
		}
		//对接优先,计算出包机价格以及默认查询航班里面的最低航班.
		else{
			FlightSearchFlightInfoDto cheapestDepCharter = new FlightSearchFlightInfoDto();
			FlightSearchFlightInfoDto cheapestArvCharter = new FlightSearchFlightInfoDto();
			//得到最便宜的包机信息
			if(!CollectionUtils.isEmpty(charterFlights)){
				List<FlightSearchFlightInfoDto> cheapestFlights = CharterFlightFilterUtil.getCheapestGoAndBackInCharterFlights(charterFlights);
				cheapestDepCharter = cheapestFlights.get(0);   
				cheapestArvCharter = cheapestFlights.get(1);
				//包机的最低基准价格--
				BigDecimal sumPrice = CharterFlightFilterUtil.calcBasePrice(cheapestDepCharter, cheapestArvCharter, true, req.getAdultQuantity(), req.getChildQuantity()); 
				 
				//如果有往返程，找到最低价格的往返程与包机的最低进行比较
				if(!CollectionUtils.isEmpty(depFlights)){
					FlightSearchFlightInfoDto cheapestDepFlight = depFlights.get(0);
					FlightSearchFlightInfoDto cheapestArvFlight = arvFlights.get(0);
					  
				    BigDecimal basePrice =  CharterFlightFilterUtil.calcBasePrice(cheapestDepFlight, cheapestArvFlight, false, req.getAdultQuantity(), req.getChildQuantity());
				    
				    //单独往返程的便宜，就设置往返程，否则设置包机
				    if(sumPrice.compareTo(basePrice)>=0){
				    	sumDepFlights=cheapestDepFlight;
				    	sumArvFlights=cheapestArvFlight;
				    }
				    //否则返回包机
				    else{
				    	sumDepFlights=cheapestDepCharter;
				    	sumArvFlights=cheapestArvCharter;
				    }
				}
				//否则直接返回包机最低
				else{
					sumDepFlights=cheapestDepCharter;
			    	sumArvFlights=cheapestArvCharter;
				}
			}
			//没有包机信息，就返回最低的往返.
			else{
				sumDepFlights = depFlights.get(0);
				sumArvFlights = arvFlights.get(0); 
			}
		}
		
		List<FlightSearchFlightInfoDto> resultFlights = new ArrayList<FlightSearchFlightInfoDto>();
		sumArvFlights.setBackOrTo(FlightTripType.RETURN.name());
		sumDepFlights.setBackOrTo(FlightTripType.DEPARTURE.name());
		resultFlights.add(sumDepFlights); 
		resultFlights.add(sumArvFlights);
		return resultFlights;
	}
}
