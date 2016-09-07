package com.lvmama.lvf.common.utils.csv;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CSV工具类
 * @author majun
 * @date 2015-6-3
 */
public final class CsvUtils 
{
	private static final Logger logger = LoggerFactory.getLogger(CsvUtils.class);
	
	private static final String CHARSET = "GBK";
	
	private CsvUtils(){}
	
	/**
	 * 创建CSV流
	 * @param csvConfig		CSV配置枚举
	 * @param dataList		数据列表
	 * @param response		HttpServletResponse对象
	 */
	public static void createCsvStream(CsvConfig csvConfig, List<String> dataList, HttpServletResponse response)
	{
		BufferedOutputStream bufferedOutputStream = null;
		try
		{
			if(CollectionUtils.isNotEmpty(dataList))
			{
				response.setContentType("application/csv;charset="+CHARSET+"");
				response.setCharacterEncoding(CHARSET);
				response.setHeader("Content-Disposition", "attachment;filename=" + new String(csvConfig.getFileName().getBytes(CHARSET),
					"ISO-8859-1") + ".csv");
				bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
				//CsvUtils.writeBom(bufferedOutputStream);
				bufferedOutputStream.write(csvConfig.getHead().getBytes(CHARSET));
				CsvUtils.writeLine(bufferedOutputStream);
				for(String str : dataList)
				{
					bufferedOutputStream.write(str.getBytes(CHARSET));
					CsvUtils.writeLine(bufferedOutputStream);
				}
				bufferedOutputStream.flush();
			}	
			else
			{
				response.setContentType("text/html");
				response.setCharacterEncoding(CHARSET);
				response.getWriter().print("<script language=\"javascript\">alert(\"没有可导出的数据！\");window.close();</script>");
			}	
		}
		catch(Exception e)
		{
			logger.error("exportFile", e);
		}
		finally 
		{
			try 
			{
				if (bufferedOutputStream != null)
					bufferedOutputStream.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 设置换行
	 * @param 	bufferedOutputStream	输出流
	 * @throws 	IOException 
	 */
	private static void writeLine(BufferedOutputStream bufferedOutputStream) throws IOException
	{
		try 
		{
			bufferedOutputStream.write("\r\n".getBytes());
		} 
		catch (IOException e) 
		{
			throw e;
		}
	}
	
	/**
	 * 写CSV Bom(处理CSV UTF-8编码乱码)
	 * @param 	bufferedOutputStream	输出流
	 * @throws 	IOException
	 */
	private static void writeBom(BufferedOutputStream bufferedOutputStream) throws IOException
	{
		try 
		{
			bufferedOutputStream.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
		} 
		catch (IOException e) 
		{
			throw e;
		}
	}
}
