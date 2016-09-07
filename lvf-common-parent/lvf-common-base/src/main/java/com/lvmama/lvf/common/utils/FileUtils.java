package com.lvmama.lvf.common.utils;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class FileUtils {
	
	public static String getStringFromResourceAsStream(String filepath) throws Exception {
        InputStream inputStream = FileUtils.class.getResourceAsStream(filepath);
        String file = IOUtils.toString(inputStream,"UTF-8");
        //System.out.println(file);
        return file;
	}

}
