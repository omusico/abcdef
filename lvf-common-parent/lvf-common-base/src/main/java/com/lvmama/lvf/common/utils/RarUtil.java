package com.lvmama.lvf.common.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


public class RarUtil {
	
	public static String WINRAR = getRarCmd();
	
	public static String P_EXTRAT = "x";
	public static String P_RECURSE = "r";
	public static String P_SPACE = " ";
	
	private static Logger logger = Logger.getLogger(RarUtil.class);
	
	/**
	 * 将RAR文件解压到压缩文件所在目录
	 * @param sourcePath
	 * @throws IOException
	 */
	public static boolean  extratToCurrent(String sourcePath){
		return extratToCurrent(sourcePath, false);
	}
	
	public static boolean extratToCurrent(String sourcePath, boolean isRecursive){
		File sourceFile = new File(sourcePath);
		if(sourceFile.isFile()){
			String cmd = WINRAR + getPara(isRecursive) + sourceFile.getAbsolutePath() + P_SPACE + sourceFile.getParent();
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
				return true;
			} catch (IOException e) {
				logger.error("execute cmd:" + cmd +" error.", e);
			} catch (InterruptedException e) {
				logger.error("execute cmd:" + cmd +" error.", e);
			}
		}else{
			logger.error("sourcePath is not a file");
		}
		return false;
	}

	private static String getPara(boolean isRecursive) {
		String para = P_SPACE + P_EXTRAT;
		if(isRecursive){
			para += P_RECURSE;
		}
		para += P_SPACE;
		return para;
	}
	
	public static String getRarCmd(){
		String rar = null;
		
		String rar_home = System.getenv("RAR_HOME");
		if(StringUtils.isNotBlank(rar_home)){
			return "unrar";
		}
		
		String osName = System.getProperty("os.name");
		if(osName.toLowerCase().startsWith("win")){
			rar = "C:\\Program\\ Files\\WinRAR\\UnRAR.exe";
		}else{
			rar = "sh /usr/local/rar/unrar";
		}
		
		return rar;
	}
	

}
