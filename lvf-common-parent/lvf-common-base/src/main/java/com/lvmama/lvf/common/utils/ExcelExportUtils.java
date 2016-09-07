package com.lvmama.lvf.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelExportUtils {

	private final static Logger logger = LoggerFactory.getLogger(ExcelExportUtils.class);

	public static void createExcelFile(HttpServletRequest request, HttpServletResponse response, File file) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			request.setCharacterEncoding("ISO8859-1");
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("gb2312"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(file.length()));
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			logger.error("exportFile", e);
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
				if (file != null)
					file.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
