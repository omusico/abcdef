package com.lvmama.lvf.common.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class PinYinUtils {  

	protected static Logger logger = Logger.getLogger(PinYinUtils.class);
	
	private final static Map<String, String> specialWords = new HashMap<String, String>();
	static {  
		specialWords.put("厷", "gong");
	}
	
	/** 
	 * 转换乘机人姓名，生僻字拼音化
	 * @param	name 
	 * @return	String
	 */ 
	public static String transFlightPassengerName(String inputname){
		String finalName = StringUtils.EMPTY;
		String name = inputname;
		boolean needTrans = false;
		try {
			for(int i=0;i<inputname.length();i++){
				String str = inputname.substring(i, i+1);
				name = name.substring(1);
				if(StringUtils.isNotEmpty(finalName) 
						&& finalName.length()>1
						&& i == 1){
					finalName += "/";
				}
				if(needTrans || StringUtils.isEmpty(getEncoding(str,"GB2312"))){
					String pinYin = "";
					if(specialWords.containsKey(str)){
						pinYin = specialWords.get(str);
					}else {
						String[] pinyins = makeStringByStringSet(getPinyin(str)).split(",");
						pinYin = pinyins[pinyins.length-1];
					}
					finalName += pinYin;
					needTrans = true;
				}else {
					finalName += str;
				}
			}
		} catch (Exception e) {
			logger.error("乘机人姓名转拼音异常", e);
			return inputname;
		}
		if(StringUtils.isBlank(finalName)){
			finalName = inputname;
		}
		return finalName.toUpperCase();
	}
	
	/** 
	 * 字符串集合转换字符串(逗号分隔) 
	 * @param stringSet 
	 * @return 
	 */  
	public static String makeStringByStringSet(Set<String> stringSet){  
		StringBuilder str = new StringBuilder();  
		int i=0;  
		for(String s : stringSet){  
			if(i == stringSet.size() - 1){  
				str.append(s);  
			}else{  
				str.append(s + ",");  
			}  
			i++;  
		}  
		return str.toString().toLowerCase();  
	}  

	/** 
	 * 获取拼音集合 
	 * @param src 
	 * @return Set<String> 
	 */  
	public static Set<String> getPinyin(String src){  
		if(src!=null && !src.trim().equalsIgnoreCase("")){  
			char[] srcChar ;  
			srcChar=src.toCharArray();  
			//汉语拼音格式输出类  
			HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();  

			//输出设置，大小写，音标方式等  
			hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);   
			hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			hanYuPinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);  

			String[][] temp = new String[src.length()][];  
			for(int i=0;i<srcChar.length;i++){  
				char c = srcChar[i];  
				//是中文或者a-z或者A-Z转换拼音(我的需求，是保留中文或者a-z或者A-Z)  
				if(String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")){  
					try{  
						temp[i] = PinyinHelper.toHanyuPinyinStringArray(srcChar[i], hanYuPinOutputFormat);  
					}catch(BadHanyuPinyinOutputFormatCombination e) {  
						e.printStackTrace();  
					}  
				}else if(((int)c>=65 && (int)c<=90) || ((int)c>=97 && (int)c<=122)){  
					temp[i] = new String[]{String.valueOf(srcChar[i])};  
				}else{  
					temp[i] = new String[]{""};  
				}  
			}  
			String[] pingyinArray = Exchange(temp);  
			Set<String> pinyinSet = new HashSet<String>();  
			for(int i=0;i<pingyinArray.length;i++){  
				pinyinSet.add(pingyinArray[i]);  
			}  
			return pinyinSet;  
		}  
		return null;  
	}  

	/** 
	 * 递归 
	 * @param strJaggedArray 
	 * @return 
	 */  
	private static String[] Exchange(String[][] strJaggedArray){  
		String[][] temp = DoExchange(strJaggedArray);  
		return temp[0];         
	}  

	/** 
	 * 递归 
	 * @param strJaggedArray 
	 * @return 
	 */  
	private static String[][] DoExchange(String[][] strJaggedArray){  
		int len = strJaggedArray.length;  
		if(len >= 2){             
			int len1 = strJaggedArray[0].length;  
			int len2 = strJaggedArray[1].length;  
			int newlen = len1*len2;  
			String[] temp = new String[newlen];  
			int Index = 0;  
			for(int i=0;i<len1;i++){  
				for(int j=0;j<len2;j++){  
					temp[Index] = strJaggedArray[0][i] + strJaggedArray[1][j];  
					Index ++;  
				}  
			}  
			String[][] newArray = new String[len-1][];  
			for(int i=2;i<len;i++){  
				newArray[i-1] = strJaggedArray[i];                             
			}  
			newArray[0] = temp;  
			return DoExchange(newArray);  
		}else{  
			return strJaggedArray;     
		}  
	}  
	
	public static String getEncoding(String str, String charset) {      
		String encode = charset;
		try {      
			if (str.equals(new String(str.getBytes(encode), encode))) {      
				String s = encode;      
				return s;      
			}      
		} catch (Exception exception) {
		} 
		return "";
	}

	/** 
	 * @param args 
	 */  
	public static void main(String[] args) {  
		String str = "厷";  
		System.out.println(makeStringByStringSet(getPinyin(str)));
		System.out.println(transFlightPassengerName(str));  

	}

} 