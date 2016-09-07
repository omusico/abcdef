package com.lvmama.lvf.common.dto.supp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 存储数据库供应商信息表的信息
 * @author lutianyu
 * @date 2016年6月1日
 */
public class SuppInfo {
	
	/**用于存放来自数据库的转化后的数据*/
    public static LinkedHashMap<String, Supp> dbMaps = new LinkedHashMap<String, Supp>();
    
    public static List<Supp> suppList = new ArrayList<Supp>();
    
    public static void putDbMaps(List<Supp> suppInList){
    	LinkedHashMap<String, Supp> mapDb = new LinkedHashMap<String, Supp>();
    	List<Supp> suppListTemp = new ArrayList<Supp>();
    	
    	for (Supp supp : suppInList) {
    		mapDb.put(supp.getCode(), supp);
    		suppListTemp.add(supp);
		}
    	dbMaps = mapDb;
    	suppList = suppListTemp;
    }
    
    /**
     * 根据供应商code获取供应商信息
     * @param suppCode
     * @return
     */
    public static Supp getSuppBySuppCode(String suppCode){
    	return dbMaps.get(suppCode);
    }
    
    /**
     * 获取所有供应商作息
     * @return
     */
    public static List<Supp> getAllSupps(){
    	return suppList;
    }
}
