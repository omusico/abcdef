package com.lvmama.lvf.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.NameCode;

public class EnumAndNameCodeUtils {

	public static String getCode(NameCode nameCode) {
		return null!=nameCode?nameCode.getCode():null;
	}
	
	public static String getName(NameCode nameCode) {
		return null!=nameCode?nameCode.getName():null;
	}
	
	public static String getName(Enum enum1) {
		return null!=enum1?enum1.name():null;
	}

	public static String[] getNames(NameCode[] nameCodes) {
		
		if(null==nameCodes||nameCodes.length==0){
			return null;
		}
		List<String> strs = new ArrayList<String>();
		for(NameCode nameCode:nameCodes){
			strs.add(nameCode.getName());	
		}
		return strs.toArray(new String[strs.size()]);
	}
	
	public static String[] getCodes(NameCode[] nameCodes) {
		
		if(null==nameCodes||nameCodes.length==0){
			return null;
		}
		List<String> strs = new ArrayList<String>();
		for(NameCode nameCode:nameCodes){
			strs.add(nameCode.getCode());	
		}
		return strs.toArray(new String[strs.size()]);
	}

	public static String[] getNames(Enum[] emums) {
		if(null==emums||emums.length==0){
			return null;
		}
		List<String> strs = new ArrayList<String>();
		for(Enum enum1:emums){
			strs.add(enum1.name());	
		}
		return strs.toArray(new String[strs.size()]);
	}

}
