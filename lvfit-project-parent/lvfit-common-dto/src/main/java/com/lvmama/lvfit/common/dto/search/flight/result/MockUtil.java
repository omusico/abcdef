package com.lvmama.lvfit.common.dto.search.flight.result;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;

/**
 * 包机切位的航班过滤工具类.
 * 
 * @author Administrator
 * 
 */
public class MockUtil {
	 
	public static FitSdpShoppingDto morkShoppingDto(){
		return MockUtil.deserializeObject("d:\\cache\\123123123.txt",FitSdpShoppingDto.class);
	}
	
	public static void morkCacheShoopingDto(FitSdpShoppingDto shoppingDto){
		MockUtil.serializeObject(shoppingDto,"d:\\cache\\123123123.txt");
	}
	
	/**
	 * 读取文件 
	 * @param fileName
	 * @return
	 */
	public static String readFile(String fileName) {
		InputStream in;
		try {
			in = new FileInputStream(fileName);
			return IOUtils.toString(in, "GBK");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 写入文件
	 * 
	 * @param fileName
	 * @param contant
	 */
	public static void writeFile(String fileName, String contant) {
		PrintWriter out;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			out.print(contant);
			out.close();
		} catch (IOException e) {
			System.out.println("读写文件出现异常！");
		} catch (Exception e) {
			System.out.println("出现异常");
		}
	}

	public static void writeJsonToFile(String fileName, Object contant) {
		PrintWriter out;
		try { 
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			out.print(toJsonStr(contant));
			out.close();
		} catch (IOException e) {
			System.out.println("读写文件出现异常！");
		} catch (Exception e) {
			System.out.println("出现异常");
		}
	}
	
	/**
	 * 从json文件中解析json串并转换成java类型
	 * 
	 * @param name
	 * @param clazz
	 * @return
	 */
	public static <T> T createFromJsonFile(String name, TypeReference clazz) {
		try {
			String sqlFlie = readFile(name);
			String result = sqlFlie;
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				return (T) objectMapper.readValue(result, clazz);
			}
			return null;
		} catch (Exception ew) {
			ew.printStackTrace();
			return null;
		}
	}

	/**
	 * 从json文件中解析json串并转换成java类型
	 * 
	 * @param name
	 * @param clazz
	 * @return
	 */
	public static <T> T createFromJsonFile(String name, Class<T> clazz) {
		try {
			String sqlFlie = readFile(name);
			String result = sqlFlie;
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				return (T) objectMapper.readValue(result, clazz);
			}
			return null;
		} catch (Exception ew) {
			ew.printStackTrace();
			return null;
		}
	}

	/**
	 * 序列化对象保存到文件中.
	 * 
	 * @param shoppingDto
	 * @param name
	 */
	public static void serializeObject(Object shoppingDto, String name) {
		ObjectOutputStream oo;
		try {
			oo = new ObjectOutputStream(new FileOutputStream(new File(name)));
			oo.writeObject(shoppingDto);
			System.out.println("对象序列化成功！");
			oo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 从文件中反序列化对象.
	 * 
	 * @param name
	 * @param clazz
	 * @return
	 */
	public static <T> T deserializeObject(String name, Class<T> clazz) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File(name)));
			T person = (T) ois.readObject();
			System.out.println("对象反序列化成功！");
			return person;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析对象为json串.
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJsonStr(Object obj) {
		try {
			return JSONMapper.getInstance().writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析json字符串为java对象.
	 * 
	 * @param obj
	 * @param clazz
	 * @return
	 */
	public static <T> T parseJsonStr(String str, Class<T> clazz) {
		try {
			return (T) JSONMapper.getInstance().readValue(str, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解析json字符串为java对象.
	 * 
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static <T> T parseJsonStr(String str, TypeReference<T> clazz) {
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			objectMapper.configure(
					JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
			return objectMapper.readValue(str, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] aegs) throws JsonParseException,
			JsonMappingException, IOException {
		Long a = 1476288000000L; 
		System.out.println(DateUtils.parseDate(a, "yyyy-MM-dd"));
		
//		FlightSearchResult<FlightSearchFlightInfoDto> goFlightSearchResult2 = MockUtil
//				.createFromJsonFile(
//						"d:\\new_flight.txt",
//						new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {
//						});

		// String sqlFlie = readFile("d:\\老的查询往返程机票的东西.txt");
		// ObjectMapper objectMapper = JSONMapper.getInstance();
		// FlightSearchResult<FlightSearchFlightInfoDto> flightSearchResult =
		// objectMapper
		// .readValue(
		// sqlFlie,
		// new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {
		// });
		// List<FlightSearchFlightInfoDto> result =
		// flightSearchResult.getResults();
		// for(FlightSearchFlightInfoDto d:result){
		// writeFile("d:\\"+System.currentTimeMillis()+".txt",
		// getJsonStr(d)+"\n\n\n" );
		// }
	}
}
