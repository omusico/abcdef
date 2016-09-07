package com.lvmama.lvf.common.dto.enums;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.dto.md.SeatClass;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;

public class SeatClassCode {

    public static Logger logger = LoggerFactory.getLogger(SeatClassCode.class);

    private static LinkedHashMap<String, LinkedHashMap<String, SeatClassCode>> maps = new LinkedHashMap<String, LinkedHashMap<String, SeatClassCode>>();
   
    /**用于存放来自数据库的转化后的数据*/
    public static LinkedHashMap<String, LinkedHashMap<String, List<SeatClassCode>>> dbMaps = new LinkedHashMap<String, LinkedHashMap<String, List<SeatClassCode>>>();
    
    static {
        try {
			String str1 ="{\"HO\":{\"D\":\"公务舱\",\"E\":\"经济舱7.0折\",\"F\":\"头等舱\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱8.5折\",\"M\":\"经济舱8.0折\",\"H\":\"经济舱6.5折\",\"K\":\"经济舱5.5折\",\"T\":\"经济舱7.5折\",\"W\":\"经济舱5.0折\",\"V\":\"经济舱6.0折\",\"Q\":\"经济舱4.0折 \",\"P\":\"经济舱特价\",\"R\":\"经济舱4.5折\",\"Y\":\"经济舱全价\",\"X\":\"经济舱特价\",\"Z\":\"经济舱3.5价\"},\"NS\":{\"G\":\"经济舱特价\",\"B\":\"经济舱9.0折\",\"L\":\"经济舱7.5折\",\"M\":\"经济舱8.0折\",\"N\":\"经济舱6.5折\",\"H\":\"经济舱9.9折\",\"J\":\"公务舱\",\"K\":\"经济舱7.0折\",\"U\":\"经济舱特价\",\"T\":\"经济舱4.0折 \",\"W\":\"经济舱特价\",\"V\":\"经济舱5.0折\",\"Q\":\"经济舱6.0折\",\"S\":\"经济舱特价\",\"R\":\"经济舱特价\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱特价\"},\"ZH\":{\"E\":\"经济舱特价\",\"F\":\"头等舱\",\"G\":\"经济舱5.0折\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱8.5折\",\"H\":\"经济舱8.0折\",\"J\":\"经济舱6.5折\",\"K\":\"经济舱7.5折\",\"W\":\"经济舱4.0价\",\"V\":\"经济舱4.5折\",\"Q\":\"经济舱6.0折\",\"P\":\"头等舱\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱5.5折\"},\"CA\":{\"D\":\"公务舱\",\"E\":\"经济舱特价\",\"F\":\"头等舱\",\"G\":\"经济舱5.0折\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱8.5折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.0折 \",\"J\":\"公务舱\",\"K\":\"经济舱7.5折 \",\"U\":\"经济舱特价\",\"T\":\"经济舱特价\",\"W\":\"超级经济舱\",\"V\":\"经济舱4.5折\",\"Q\":\"经济舱6.0折 \",\"P\":\"头等舱\",\"S\":\"经济舱特价\",\"Y\":\"经济舱全价\",\"Z\":\"公务舱\"},\"JR\":{\"G\":\"经济舱特价\",\"B\":\"经济舱9.0折\",\"L\":\"经济舱特价\",\"M\":\"经济舱7.0折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.0折\",\"I\":\"经济舱特价\",\"J\":\"经济舱特价\",\"U\":\"经济舱特价\",\"T\":\"经济舱4.5折\",\"W\":\"经济舱特价\",\"V\":\"经济舱5.0折\",\"R\":\"经济舱6.0折\",\"Y\":\"经济舱全价 \",\"X\":\"经济舱特价\"},\"DZ\":{\"F\":\"  头等舱\",\"G\":\"经济舱5.0折\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱 \",\"L\":\"经济舱7,0折\",\"M\":\"经济舱8.5折\",\"H\":\"经济舱8.0折\",\"J\":\"经济舱6.5折\",\"K\":\"经济舱7.5折\",\"W\":\"经济舱4.0折 \",\"V\":\"经济舱4.5折\",\"Q\":\"经济舱6.0折\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱5.5折\"},\"HU\":{\"D\":\"公务舱\",\"E\":\"经济舱4.0折\",\"F\":\"头等舱\",\"G\":\"经济舱特价\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.5折\",\"M\":\"经济舱7.0折\",\"N\":\"经济舱特价\",\"O\":\"经济舱特价\",\"H\":\"经济舱8.5折\",\"I\":\"公务舱\",\"J\":\"公务舱\",\"K\":\"经济舱8.0折\",\"U\":\"经济舱4.5折\",\"T\":\"经济舱特价\",\"V\":\"经济舱特价\",\"Q\":\"经济舱6.0折\",\"P\":\"头等舱\",\"Y\":\"经济舱全价\",\"X\":\"经济舱5.0折\",\"Z\":\"头等舱\"},\"QW\":{\"E\":\"经济舱特价\",\"F\":\"头等舱 \",\"G\":\"经济舱5.5折\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱8.5折\",\"H\":\"经济舱8.0折\",\"K\":\"经济舱7.5折\",\"U\":\"经济舱4.5折\",\"V\":\"经济舱5.0折\",\"Q\":\"经济舱6.0折\",\"P\":\"经济舱6.5折\",\"S\":\"经济舱特价\",\"W \":\"经济舱全价\",\"R\":\"经济舱特价\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱4.0折 \"},\"FU\":{\"E\":\"经济舱4.0折\",\"F\":\"头等舱\",\"B\":\"经济舱9.0折\",\"L\":\"经济舱7.5折\",\"M\":\"经济舱7.0折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.5折\",\"I\":\"经济舱3.0折 \",\"K\":\"经济舱8.0折\",\"U\":\"经济舱4.5折\",\"T\":\"经济舱3.5折\",\"W\":\"经济舱特价\",\"V\":\"经济舱特价\",\"Q\":\"经济舱6.0折\",\"R\":\"经济舱特价\",\"Y\":\"经济舱全价 \",\"X\":\"经济舱5.0折 \",\"Z\":\"头等舱\"},\"G5\":{\"D\":\"头等舱\",\"E\":\"经济舱6.0折\",\"F\":\"头等舱\",\"G\":\"经济舱8.0折\",\"A\":\"头等舱\",\"B\":\"经济舱特价\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱8.5折\",\"O\":\"经济舱4.5折\",\"H\":\"经济舱9.0折\",\"I\":\"经济舱特价\",\"J\":\"经济舱特价\",\"K\":\"经济舱特价\",\"U\":\"经济舱4.0折\",\"T\":\"经济舱9.5折\",\"V\":\"经济舱5.5折\",\"Q\":\"经济舱6.5折\",\"P\":\"经济舱特价\",\"S\":\"经济舱7.5折\",\"R\":\"经济舱5.0折\",\"Y\":\"经济舱全价 \",\"X\":\"经济舱3.0折\",\"Z\":\"经济舱3.5折\"},\"MF\":{\"D\":\"公务舱\",\"F\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.5折\",\"M\":\"经济舱8.0折\",\"N\":\"经济舱6.5折\",\"H\":\"经济舱9.9折\",\"J\":\"头等舱\",\"K\":\"经济舱7.0折\",\"T\":\"经济舱4.0折\",\"V\":\"经济舱5.0折\",\"Q\":\"经济舱6.0折\",\"Y\":\"经济舱全价\"},\"DR\":{\"D\":\"经济舱特价\",\"E\":\"经济舱8.0折\",\"F\":\"头等舱\",\"B\":\"经济舱9.0折\",\"N\":\"经济舱6.0折\",\"H\":\"经济舱7.5折\",\"K\":\"经济舱7.0折\",\"U\":\"经济舱特价\",\"T\":\"经济舱4.0折 \",\"W\":\"经济舱3.0折\",\"V\":\"经济舱4.5折\",\"S\":\"经济舱5.0折\",\"R\":\"经济舱5.5折\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱3.5折\"},\"BK\":{\"E\":\"经济舱5.0折\",\"F\":\"头等舱\",\"B\":\"经济舱9.0折\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱7.5折\",\"N\":\"经济舱6.5折\",\"O\":\"经济舱3.0折\",\"H\":\"经济舱8.5折\",\"J\":\"经济舱特价\",\"K\":\"经济舱8.0折\",\"U\":\"经济舱4.5折\",\"T\":\"经济舱4.0折\",\"W\":\"经济舱特价\",\"Q\":\"经济舱6.0折\",\"P\":\"经济舱特价\",\"R\":\"经济舱特价\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱特价\"},\"CZ\":{\"D\":\"公务舱\",\"E\":\"经济舱5.0折\",\"F\":\"头等舱\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱6.0折\",\"M\":\"经济舱8.0折\",\"N\":\"经济舱特价\",\"H\":\"经济舱7.5折\",\"I\":\"公务舱\",\"J\":\"公务舱\",\"K\":\"经济舱特价\",\"U\":\"经济舱7.0折\",\"T\":\"经济舱特价\",\"W\":\"高端经济舱\",\"V\":\"经济舱4.5折\",\"Q\":\"经济舱特价\",\"P\":\"头等舱\",\"R\":\"经济舱特价\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱4.0价\"},\"UQ\":{\"D\":\"经济舱4.5折\",\"E\":\"经济舱3.0折\",\"A\":\"经济舱3.3折 \",\"B\":\"经济舱9.0折\",\"L\":\"经济舱6.7折\",\"M\":\"经济舱6.0折\",\"H\":\"经济舱8.2折\",\"I\":\"经济舱特价\",\"J\":\"经济舱特价\",\"K\":\"经济舱7.5折\",\"U\":\"经济舱3.7折\",\"T\":\"经济舱2.2折 \",\"W\":\"经济舱2.7折\",\"V\":\"经济舱特价\",\"Q\":\"经济舱5.0折\",\"S\":\"经济舱特价\",\"R\":\"经济舱5.5折\",\"Y\":\"经济舱全价\",\"X\":\"经济舱4.1折\",\"Z\":\"经济舱2.5折\"},\"SC\":{\"D\":\"公务舱 \",\"E\":\"经济舱特价\",\"F\":\"头等舱\",\"G\":\"经济舱5.5折\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱 \",\"L\":\"经济舱7.0折\",\"M\":\"经济舱8.5折\",\"H\":\"经济舱8.0折\",\"J\":\"经济舱特价\",\"K\":\"经济舱7.5折\",\"U\":\"经济舱4.5折\",\"T\":\"经济舱特价\",\"W\":\"经济舱全价\",\"V\":\"经济舱5.0折\",\"Q\":\"经济舱6.0折\",\"P\":\"经济舱6.5折\",\"S\":\"经济舱特价\",\"R\":\"经济舱特价\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱4.0折\"},\"3U\":{\"D\":\"经济舱特价\",\"E\":\"经济舱5.0折\",\"F\":\"头等舱\",\"G\":\"经济舱7.0折\",\"A\":\"经济舱全价\",\"C\":\"公务舱\",\"L\":\"经济舱6.0折\",\"M\":\"经济舱7.5折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.0折\",\"I\":\"头等舱\",\"J\":\"公务舱\",\"K\":\"经济舱3.5折\",\"T\":\"经济舱9.0折\",\"V\":\"经济舱4.5折\",\"Q\":\"经济舱5.5折\",\"P\":\"头等舱\",\"S\":\"经济舱6.5折\",\"R\":\"经济舱4.0折\",\"Y\":\"经济舱全价\",\"X\":\"经济舱特价\"},\"EU\":{\"D\":\"经济舱特价\",\"E\":\"经济舱5.0折\",\"F\":\"头等舱\",\"G\":\"经济舱7.0折\",\"A\":\"公务舱\",\"B\":\"经济舱特价\",\"C\":\"公务舱\",\"L\":\"经济舱6.0折\",\"M\":\"经济舱7.5折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.0折\",\"I\":\"经济舱3.0折\",\"J\":\"公务舱\",\"K\":\"经济舱3.5折\",\"T\":\"经济舱9.0折\",\"W\":\"经济舱特价\",\"V\":\"经济舱4.5折\",\"Q\":\"经济舱5.5折\",\"S\":\"经济舱6.5折\",\"R\":\"经济舱4.0折\",\"Y\":\"经济舱全价\",\"X\":\"经济舱特价\",\"Z\":\"经济舱特价\"},\"KY\":{\"F\":\"头等舱\",\"G\":\"经济舱5.0折\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱8.5折\",\"H\":\"经济舱8.0折\",\"J\":\"经济舱6.5折\",\"K\":\"经济舱7.5折\",\"W\":\"经济舱4.0折\",\"V\":\"经济舱4.5折\",\"Q\":\"经济舱6.0折\",\"P\":\"经济舱特价\",\"Y\":\"经济舱全价 \",\"Z\":\"经济舱5.5折\"},\"8L\":{\"D\":\"经济舱3.5折\",\"E\":\"经济舱4.0折 \",\"F\":\"头等舱\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.5折\",\"M\":\"经济舱7.0折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.5折\",\"I\":\"经济舱特价\",\"K\":\"经济舱8.0折\",\"U\":\"经济舱4.5折\",\"T\":\"经济舱3.0折\",\"Q\":\"经济舱6.0折\",\"P\":\"头等舱\",\"Y\":\"经济舱全价 \",\"X\":\"经济舱5.0折\"},\"PN\":{\"D\":\"经济舱5.4折\",\"E\":\"经济舱4.6折\",\"A\":\"经济舱4.8折\",\"B\":\"经济舱9.2折 \",\"L\":\"经济舱7.1折 \",\"M\":\"经济舱6.5折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.5折\",\"I\":\"经济舱3.7折\",\"J\":\"经济舱特价\",\"K\":\"经济舱7.7折\",\"U\":\"经济舱5.0折\",\"T\":\"经济舱3.9折\",\"W\":\"经济舱4.3折\",\"V\":\"经济舱特价\",\"Q\":\"经济舱5.6折\",\"P\":\"经济舱特价\",\"S\":\"经济舱特价\",\"R\":\"经济舱6.0折\",\"Y\":\"经济舱全价 \",\"X\":\"经济舱5.2折\",\"Z\":\"经济舱4.1折\"},\"GS\":{\"D\":\"公务舱\",\"E\":\"经济舱4.0折\",\"F\":\"头等舱\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.5折\",\"M\":\"经济舱7.0折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.5折\",\"I\":\"头等舱\",\"K\":\"经济舱8.0折\",\"U\":\"经济舱4.5折\",\"T\":\"经济舱特价\",\"Q\":\"经济舱6.0折\",\"P\":\"头等舱\",\"R\":\"经济舱特价\",\"Y\":\"经济舱全价 \",\"X\":\"经济舱5.0折\",\"Z\":\"经济舱特价\"},\"MU\":{\"E\":\"经济舱8.5折\",\"F\":\"头等舱\",\"G\":\"经济舱特价\",\"B\":\"经济舱9.9折\",\"C\":\"公务舱\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱9.0折\",\"N\":\"经济舱6.5折\",\"H\":\"经济舱8.0折\",\"I\":\"公务舱\",\"J\":\"公务舱\",\"K\":\"经济舱7.5折\",\"U\":\"头等舱\",\"T\":\"经济舱特价\",\"W\":\"经济舱全价\",\"V\":\"经济舱4.0折\",\"Q\":\"经济舱特价\",\"P\":\"超级经济舱\",\"S\":\"经济舱5.0折\",\"R\":\"经济舱6.0折\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱特价\"},\"JD\":{\"D\":\"经济舱2.5折\",\"E\":\"经济舱4.0折\",\"F\":\"头等舱\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"L\":\"经济舱6.5折\",\"M\":\"经济舱7.0折\",\"N\":\"经济舱特价\",\"H\":\"经济舱8.0折\",\"I\":\"经济舱特价\",\"J\":\"经济舱5.5折\",\"K\":\"经济舱7.5折\",\"U\":\"经济舱4.5折\",\"T\":\"经济舱3.5折\",\"W\":\"经济舱特价\",\"V\":\"经济舱特价\",\"Q\":\"经济舱6.0折\",\"P\":\"头等舱\",\"S\":\"经济舱2.0折\",\"Y\":\"经济舱全价\",\"X\":\"经济舱5.0折\",\"Z\":\"经济舱3.0折\"},\"GJ\":{\"D\":\"经济舱特价\",\"E\":\"经济舱特价\",\"F\":\"头等舱\",\"G\":\"经济舱5.5折\",\"A\":\"头等舱\",\"B\":\"经济舱9.0折\",\"C\":\"公务舱\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱8.5折\",\"H\":\"经济舱8.0折\",\"I\":\"经济舱特价\",\"J\":\"经济舱特价\",\"K\":\"经济舱7.5折\",\"U\":\"经济舱4.5折\",\"W\":\"经济舱特价\",\"V\":\"经济舱5.0折\",\"Q\":\"经济舱6.0折\",\"P\":\"经济舱6.5折\",\"S\":\"经济舱特价\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱4.0折 \"},\"CN\":{\"D\":\"公务舱子舱位\",\"E\":\"4折\",\"F\":\"头等舱\",\"G\":\"团队\",\"A\":\"头等舱子舱位\",\"B\":\"9折\",\"C\":\"公务舱\",\"L\":\"7.5折\",\"M\":\"7折\",\"N\":\"特价及产品\",\"O\":\"优免票\",\"H\":\"8.5折\",\"I\":\"公务舱子舱位\",\"J\":\"公务舱子舱位\",\"K\":\"8折\",\"M1\":\"6.5折\",\"U\":\"4.5折\",\"W\":\"特价及产品\",\"Q\":\"6折\",\"P\":\"头等舱子舱位\",\"S\":\"PCK/BBB免票\",\"R\":\"公务舱子舱位\",\"C1\":\"公务舱子舱位\",\"Y\":\"经济舱全价 \",\"X\":\"5折\",\"Z\":\"头等舱子舱位\",\"F1\":\"头等舱子舱位\",\"Q1\":\"5.5折\",\"V \":\"特价及产品\",\"T \":\"特价及产品\"},\"TV\":{\"D\":\"经济舱特价\",\"F\":\"头等舱 \",\"G\":\"经济舱5.0折\",\"A\":\"头等舱 \",\"B\":\"经济舱9.0折\",\"L\":\"经济舱7.0折\",\"M\":\"经济舱8.5折\",\"H\":\"经济舱8.0折\",\"I\":\"经济舱特价\",\"J\":\"经济舱6.5折\",\"K\":\"经济舱7.5折\",\"U\":\"经济舱特价\",\"T\":\"经济舱特价\",\"W\":\"经济舱特价\",\"V\":\"经济舱4.5折\",\"Q\":\"经济舱6.0折\",\"P\":\"经济舱特价\",\"R\":\"经济舱4.0折\",\"Y\":\"经济舱全价\",\"Z\":\"经济舱特价\"}}";

            Map<String, Map<String, String>> map1 = JSONMapper.getInstance().readValue(str1,  Map.class);
            
            for (Entry<String, Map<String, String>> mapk : map1.entrySet()) {
                maps.put(mapk.getKey(), new LinkedHashMap<String, SeatClassCode>());
                for (Entry<String, String> mapb : mapk.getValue().entrySet()) {
                    SeatClassCode code = new SeatClassCode(mapb.getKey(), mapb.getValue());
                    maps.get(mapk.getKey()).put(code.toString(), code);
                    if(!mapb.getKey().endsWith("1") && null==maps.get(mapk.getKey()).get(mapb.getKey()+1)){
	                    SeatClassCode code1 = new SeatClassCode(mapb.getKey()+1, mapb.getValue());
	                    maps.get(mapk.getKey()).put(code1.toString(), code1);
                    }
                }
            }
            logger.error("init seat class code succ!" + maps);
        } catch (Exception ex) {
            logger.error("init seat class code error!");
        }
        
    }
    public String name;
    public String cnName;
    public String seatClassType;
    public String chdSeatClassCode;
    public Date travelValidDate;
    public Date travelExpDate;
    public Date policyValidDate;
    public Date policyExpDate;
    
    public SeatClassCode(String name, String cnName, String seatClassType, String chdSeatClassCode, Date travelExpDate, Date travelValidDate, Date policyExpDate, Date policyValidDate) {
		super();
		this.name = name;
		this.cnName = cnName;
		this.seatClassType = seatClassType;
		this.chdSeatClassCode = chdSeatClassCode;
		//DateUtils.parseDate(sDate, pattern)
		this.travelExpDate = DateUtils.parseDate(DateUtils.formatDate(travelExpDate, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD);
		this.travelValidDate = DateUtils.parseDate(DateUtils.formatDate(travelValidDate, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD);
		this.policyExpDate = DateUtils.parseDate(DateUtils.formatDate(policyExpDate, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD);
		this.policyValidDate = DateUtils.parseDate(DateUtils.formatDate(policyValidDate, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD);
		/*this.travelExpDate = travelExpDate;
		this.travelValidDate = travelValidDate;
		this.policyExpDate = policyExpDate;
		this.policyValidDate = policyValidDate;*/
	}
    
    

    public Date getTravelValidDate() {
		return travelValidDate;
	}



	public void setTravelValidDate(Date travelValidDate) {
		this.travelValidDate = travelValidDate;
	}



	public Date getTravelExpDate() {
		return travelExpDate;
	}



	public void setTravelExpDate(Date travelExpDate) {
		this.travelExpDate = travelExpDate;
	}



	public Date getPolicyValidDate() {
		return policyValidDate;
	}



	public void setPolicyValidDate(Date policyValidDate) {
		this.policyValidDate = policyValidDate;
	}



	public Date getPolicyExpDate() {
		return policyExpDate;
	}



	public void setPolicyExpDate(Date policyExpDate) {
		this.policyExpDate = policyExpDate;
	}



	@JsonIgnore
    public String getCode(){
    	return name;
    }
    
	private SeatClassCode(String name, String cnName) {
        super();
        this.name = name;
        this.cnName = cnName;
    }

    public String toString() {
        return name;
    }

    public String getCnName() {
        return cnName;
    }

    /**
     * 根据编码和航班号获取SeatClassCode
     * @param 	seatClassCode		舱位代码
     * @param 	flightNo			航班号
     * @return  SeatClassCode		
     */
    public static SeatClassCode valueOf(String seatClassCode, String flightNo,Date departureDateTime){
    	SeatClassCode resultSeatClassCode = getByCodeAndFlightNo(seatClassCode, flightNo ,departureDateTime);
    	if(resultSeatClassCode == null){
    		resultSeatClassCode = new SeatClassCode(seatClassCode,"舱位");
    	}
    	return resultSeatClassCode;
    }
    
    public Boolean valid(Date departureDateTime){
    	Date date = new Date();
    	if(null != this.getPolicyExpDate()  
    			&& null != this.getPolicyValidDate() ){//政策有效期判断
    		date = DateUtils.parseDate(DateUtils.formatDate(date, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD);
    		if(this.getPolicyExpDate().getTime() < date.getTime() 
    				|| this.getPolicyValidDate().getTime() > date.getTime() ){
    			return false;
    		}
    	}
    	
    	if(null!=departureDateTime 
    			&& null != this.getTravelExpDate()  
    			&& null != this.getTravelValidDate() ){//政策有效期判断
    		departureDateTime = DateUtils.parseDate(DateUtils.formatDate(departureDateTime, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD);
    		if(this.getTravelExpDate().getTime() < departureDateTime.getTime() 
    				|| this.getTravelValidDate().getTime() > departureDateTime.getTime() ){
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    /**
     * 根据编码和航班号获取SeatClassCode
     * @param 	seatClassCode		舱位代码
     * @param 	flightNo			航班号
     * @return  SeatClassCode		
     */
    private static SeatClassCode getByCodeAndFlightNo(String seatClassCode
    		,String flightNo,Date departureDateTime){
    	//1、参数校验
    	if(StringUtils.isBlank(seatClassCode)){
    	    return null;
    		//throw new IllegalArgumentException("seatClassCode不能为空！");
    	}
    	if(StringUtils.isBlank(flightNo)){
    	    return null;
    		//throw new IllegalArgumentException("flightNo不能为空！");
    	}
    	
    	//2、根据航班号获取承运人编码
    	String carrierNo = flightNo.substring(0, 2);
        //3、根据舱位代码和承运人编码获取SeatClassCode
        //优先从数据库里取 (map对应数据库，maps对应json)
        Map<String, List<SeatClassCode>> seatClassCodeMap = dbMaps.get(carrierNo);
        SeatClassCode resultSeatClassCode = null;
        if(seatClassCodeMap != null){//数据库里有对应的carrierNo

        	List<SeatClassCode> codes= seatClassCodeMap.get(seatClassCode);
        	if(CollectionUtils.isNotEmpty(codes)){
        		for(SeatClassCode scc : codes){
        			if(null!=scc && scc.valid(departureDateTime)){
        				resultSeatClassCode = scc;
        				break;
        			}
        		}
        	}
        	        	
        	if (resultSeatClassCode !=null){
        		return resultSeatClassCode;
        	} else {//数据库里有有对应的carrierNo但是没有对应的code
        		if("KN".equals(carrierNo) || "FM".equals(carrierNo))
                {
                	carrierNo = "MU";
                }
        		Map<String, SeatClassCode> nmap  =  maps.get(carrierNo);
        		if(nmap!=null){
        			resultSeatClassCode = nmap.get(seatClassCode);
            		return resultSeatClassCode;
        		}
        	}
        } else {
        	if("KN".equals(carrierNo) || "FM".equals(carrierNo))
            {
            	carrierNo = "MU";
            }
        	 Map<String, SeatClassCode> nmap =  maps.get(carrierNo);
        	if(nmap != null){
            	resultSeatClassCode = nmap.get(seatClassCode);
            	return resultSeatClassCode;
            }
        }
        return null;
    }

    public static Collection<SeatClassCode> values(String flightNo) {
        String cNo = flightNo.substring(0, 2);
        
        Map<String, List<SeatClassCode>> seatClassCodeMap = dbMaps.get(cNo);
        if(seatClassCodeMap != null){//数据库里取到
        	List<SeatClassCode> result = new ArrayList<SeatClassCode>();
        	for(List<SeatClassCode> cs : seatClassCodeMap.values()){
        		result.add(cs.get(0)); //FIXME
        	}
        	return result;
        } else {//数据里取不到
        	if("KN".equals(cNo)||"FM".equals(cNo)){
            	cNo="MU";
            }
        	Map<String, SeatClassCode> m = maps.get(cNo);
        	if (null != m) {
        		return m.values();
            }
        }
        return new ArrayList<SeatClassCode>();
    }
    
    public static Map<String, SeatClassCode> values(String flightNo, Date departureDateTime) {
        String cNo = flightNo.substring(0, 2);
        Map<String, List<SeatClassCode>> seatClassCodeMap = dbMaps.get(cNo);
        if(seatClassCodeMap != null){//数据库里取到
        	Map<String, SeatClassCode> result = new HashMap<String, SeatClassCode>();
        	for(List<SeatClassCode> cs : seatClassCodeMap.values()){
        		for(SeatClassCode scc : cs){
        			if(null!=scc && scc.valid(departureDateTime)){
        				result.put(scc.getCode(), scc);
        				break;
        			}
        		}
        	}
        	return result;
        } else {//数据里取不到
        	if("KN".equals(cNo)||"FM".equals(cNo)){
            	cNo="MU";
            }
        	Map<String, SeatClassCode> m = maps.get(cNo);
        	if (null != m) {
        		return m;
            }
        }
        return new HashMap<String, SeatClassCode>();
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
       System.out.println(values("CA1858"));
       for (SeatClassCode seatClassCode: values("CA1858") ){
           System.out.println(seatClassCode.getCnName());
           System.out.println(seatClassCode.name);
       }
       System.out.println(valueOf( "M", "CA1858",new Date()).getCnName());
    }
    
//    public static SeatClassCode getSeatClassCode(String name,String cnName){
//    	return new SeatClassCode(name, cnName);
//    }
    
    public static void putDbMaps(List<SeatClass> seatClassCarriers){
    	LinkedHashMap<String, LinkedHashMap<String, List<SeatClassCode>>> mapDB = new LinkedHashMap<String, LinkedHashMap<String, List<SeatClassCode>>>();
//    	LinkedHashMap<String,String> carrMap = new LinkedHashMap<String,String>();
		if (seatClassCarriers!=null  && seatClassCarriers.size() >0){
			for (SeatClass sc:seatClassCarriers){
				///航空编号
				LinkedHashMap<String, List<SeatClassCode>> seatClassCodes = mapDB.get(sc.getCarrierCode());
				if(null == seatClassCodes){
					mapDB.put(sc.getCarrierCode(), new LinkedHashMap<String, List<SeatClassCode>>());
				}
				seatClassCodes = mapDB.get(sc.getCarrierCode());
				
				SeatClassCode seatClassCode = new SeatClassCode(sc.getCode(),
      			        sc.getName(),
      			        sc.getSeatClassType().name(),
      			        sc.getChdSeatClassCode(),
      			        sc.getTravelExpDate(),
      			        sc.getTravelValidDate(),
      			        sc.getPolicyExpDate(),
      			        sc.getPolicyValidDate()
      			        );
				
				List<SeatClassCode> sccs= seatClassCodes.get(seatClassCode.getCode());
				if(null==sccs){
					seatClassCodes.put(seatClassCode.getCode(),new ArrayList<SeatClassCode>());
				}
				sccs= seatClassCodes.get(seatClassCode.getCode());
				sccs.add(seatClassCode);
			}
			dbMaps = mapDB;
//			
//			for (SeatClass seatClassCarrier:seatClassCarriers){
//				///航空编号
//				carrMap.put(seatClassCarrier.getCarrierCode(),seatClassCarrier.getCarrierCode());
//			}
//			for (Entry<String, String> map : carrMap.entrySet()){
//				///用于存放seatClassCarrier的code和name
//				LinkedHashMap<String,SeatClass> codeNamMap = new LinkedHashMap<String,SeatClass>();
//				///当前记录的carriercode与carrMap中的值相同，将该记录保存于SeatClassCode.mapDB中
//				for (SeatClass seatClassCarrier:seatClassCarriers){
//					if(seatClassCarrier.getCarrierCode().equals(map.getKey())){
//						codeNamMap.put(seatClassCarrier.getCode(), seatClassCarrier);
//						mapDB.put(map.getKey(), codeNamMap);
//					}
//					
//				}
//			}
		}
		///转换成指定的格式，存放到SeatClassCode的静态map中
//		for (Entry<String, LinkedHashMap<String, SeatClass>> mapk : mapDB.entrySet()) {
//		SeatClassCode.dbMaps.put(mapk.getKey(), new LinkedHashMap<String, SeatClassCode>());
//  		 for(Entry<String, SeatClass> mapb : mapk.getValue().entrySet()) {
//  			SeatClass sc = mapb.getValue();
//  		    SeatClassCode code = new SeatClassCode(sc.getCode(),
//  			        sc.getName(),
//  			        sc.getSeatClassType().name(),
//  			        sc.getChdSeatClassCode(),
//  			      DateUtils.formatDateByFormat(sc.getTravelExpDate(),DateUtils.YYYY_MM_DD),
//  			      DateUtils.formatDateByFormat(sc.getTravelValidDate(),DateUtils.YYYY_MM_DD),
//  			    DateUtils.formatDateByFormat(sc.getPolicyExpDate(),DateUtils.YYYY_MM_DD),
//  			  DateUtils.formatDateByFormat(sc.getPolicyValidDate(),DateUtils.YYYY_MM_DD));
//  			SeatClassCode.dbMaps.get(mapk.getKey()).put(code.toString(), code);
//  		 }
//       }
}

    
    /*this.travelExpDate = travelExpDate;
	this.travelValidDate = policyValidDate;
	this.policyExpDate = policyExpDate;
	this.policyValidDate = policyValidDate;*/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(String seatClassType) {
		this.seatClassType = seatClassType;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

    public String getChdSeatClassCode() {
        return chdSeatClassCode;
    }

    public void setChdSeatClassCode(String chdSeatClassCode) {
        this.chdSeatClassCode = chdSeatClassCode;
    }


}
