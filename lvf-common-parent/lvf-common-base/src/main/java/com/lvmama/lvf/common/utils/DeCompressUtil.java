package com.lvmama.lvf.common.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;
public class DeCompressUtil {
	
	protected static Logger logger = Logger.getLogger(DeCompressUtil.class);
	
	/** 
	 * 解压缩 
	 * @param sourceFile 解压文件（路径+文件名）
	 * @param destDir	 目标路径
	 * @return boolean	
	 */ 
	public static boolean deCompress(String sourceFile,String destDir) throws Exception{ 
		boolean result = true;
		try {
			File dstDiretory = new File(destDir); 
			if (!dstDiretory.exists()) {
				dstDiretory.mkdirs();             
			}
			Archive a = new Archive(new File(sourceFile));                
			if (a != null) {  
//				a.getMainHeader().print(); //打印文件信息.                    
				FileHeader fh = a.nextFileHeader();                     
				while (fh != null) {                              
					//文件
					if(!destDir.endsWith(File.separator)){
						destDir += File.separator;
					}
					File out = new File(destDir + fh.getFileNameString().trim());
					FileOutputStream os = new FileOutputStream(out);                                     
					a.extractFile(fh, os);                                     
					os.close();
					fh = a.nextFileHeader();
				}
			}
			a.close();
		} catch (Exception e) {
			logger.error("解压文件失败", e);
			result = false;
		}
		return result;
	} 
}